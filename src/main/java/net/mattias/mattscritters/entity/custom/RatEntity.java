package net.mattias.mattscritters.entity.custom;

import net.mattias.mattscritters.entity.ModEntities;
import net.mattias.mattscritters.entity.variant.RatVariant;
import net.mattias.mattscritters.item.ModItems;
import net.mattias.mattscritters.sounds.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class RatEntity extends Animal {
    private RatVariant variant;
    public RatEntity(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
        this.setVariant(this.random.nextInt(2));
    }

    public RatVariant getVariant() {
        return this.variant;
    }

    public void setVariant(int id) {
        this.variant = RatVariant.byId(id);
    }

    // Override the save/load method to store variant in NBT data
    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Variant", this.variant.getId());
    }
    public String getVariantTexture() {
        switch (this.getVariant()) {
            case GRAY:
                return "textures/entity/gray_rat.png";
            // case BLACK:
            //     return "textures/entity/rat/rat_black.png"; // Uncomment if adding black variant
            case WHITE:
            default:
                return "textures/entity/white_rat.png";
        }
    }
    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setVariant(compound.getInt("Variant"));
    }

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;


    @Override
    public void tick() {
        super.tick();

        if(this.level().isClientSide);
        setupAnimationStates();

    }


    private void setupAnimationStates() {
        if(this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }
    }

    @Override
    protected void updateWalkAnimation(float pPartialTick) {
        float f;
        if(this.getPose() == Pose.STANDING) {
            f = Math.min(pPartialTick * 6F, 1f);
        } else {
            f = 0f;
        }

        this.walkAnimation.update(f, 0.2f);
    }


    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));

        this.goalSelector.addGoal(1, new BreedGoal(this, 1.15D));
        this.goalSelector.addGoal(2, new TemptGoal(this, 1.2D, Ingredient.of(ModItems.CHEESE.get()), false));
        this.goalSelector.addGoal(3, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.1D));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class,3f));
        this.goalSelector.addGoal(6, new PanicGoal(this, 1.5));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));

    }


    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 10D)
                .add(Attributes.MOVEMENT_SPEED, 0.2D)
        .add(Attributes.FOLLOW_RANGE, 24D);
    }


    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        RatEntity babyRat = ModEntities.RAT.get().create(serverLevel);
        babyRat.setVariant(this.random.nextInt(2));  // Randomize the variant for offspring
        return babyRat;
    }

    @Override
    public boolean isFood(ItemStack pStack) {
        return pStack.is(ModItems.CHEESE.get());
    }


    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(ModSounds.RAT_WALK.get(), 0.15F, 1.0F);
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
            return ModSounds.RAT_IDLE.get();
        }


    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return ModSounds.RAT_HIT.get();
    }

}
