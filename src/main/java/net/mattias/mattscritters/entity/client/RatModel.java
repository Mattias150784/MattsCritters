package net.mattias.mattscritters.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.mattias.mattscritters.entity.animations.ModAnimationDefinitions;
import net.mattias.mattscritters.entity.custom.RatEntity;
import net.minecraft.client.model.EntityModel;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class RatModel<T extends Entity> extends HierarchicalModel<T> {


	private final ModelPart Rat;
	private final ModelPart Body;
	private final ModelPart Body2;
	private final ModelPart Legs;
	private final ModelPart bone;
	private final ModelPart bone2;
	private final ModelPart bone4;
	private final ModelPart bone3;
	private final ModelPart Tail;
	private final ModelPart Face;
	private final ModelPart bone7;
	private final ModelPart bone5;
	private final ModelPart bone6;

	public RatModel(ModelPart root) {
		this.Rat = root.getChild("Rat");
		this.Body = this.Rat.getChild("Body");
		this.Body2 = this.Body.getChild("Body2");
		this.Legs = this.Body.getChild("Legs");
		this.bone = this.Legs.getChild("bone");
		this.bone2 = this.Legs.getChild("bone2");
		this.bone4 = this.Legs.getChild("bone4");
		this.bone3 = this.Legs.getChild("bone3");
		this.Tail = this.Body.getChild("Tail");
		this.Face = this.Rat.getChild("Face");
		this.bone7 = this.Face.getChild("bone7");
		this.bone5 = this.Face.getChild("bone5");
		this.bone6 = this.Face.getChild("bone6");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Rat = partdefinition.addOrReplaceChild("Rat", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Body = Rat.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(-0.5F, -4.25F, 8.0F));

		PartDefinition Body2 = Body.addOrReplaceChild("Body2", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -2.0F, -4.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 1.25F, -7.0F));

		PartDefinition Legs = Body.addOrReplaceChild("Legs", CubeListBuilder.create(), PartPose.offset(3.5F, 3.75F, -8.0F));

		PartDefinition bone = Legs.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(18, 23).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 0.0F, 4.0076F));

		PartDefinition bone2 = Legs.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(6, 21).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.5F, 0.0F, 4.0F));

		PartDefinition bone4 = Legs.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(0, 21).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.5F, 0.0F, -2.0F));

		PartDefinition bone3 = Legs.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(12, 21).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 0.0F, -2.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(0, 12).addBox(-0.5F, -0.5F, -4.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 1.0F, 1.0F));

		PartDefinition Face = Rat.addOrReplaceChild("Face", CubeListBuilder.create(), PartPose.offset(0.0F, -3.8333F, -3.8333F));

		PartDefinition bone7 = Face.addOrReplaceChild("bone7", CubeListBuilder.create().texOffs(18, 12).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.3333F, -0.6667F));

		PartDefinition bone5 = Face.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(18, 17).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.25F, -0.6667F, 0.3333F));

		PartDefinition bone6 = Face.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(18, 20).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.25F, -0.6667F, 0.3333F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

		this.animateWalk(ModAnimationDefinitions.RatWalk, limbSwing, limbSwingAmount, 2F, 2.5F);
		this.animate(((RatEntity) entity).idleAnimationState, ModAnimationDefinitions.RatIdle, ageInTicks, 1f);
	}
	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.Face.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.Face.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Rat.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return Rat;
	}
}