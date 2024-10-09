package net.mattias.mattscritters.entity.client;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.mattias.mattscritters.entity.animations.ModAnimationDefinitions;
import net.mattias.mattscritters.entity.custom.PangolinEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class PangolinModel<T extends Entity> extends HierarchicalModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "pangolin"), "main");
	private final ModelPart Pangolin;
	private final ModelPart Body;
	private final ModelPart BackBody;
	private final ModelPart FrontBody;
	private final ModelPart Legs;
	private final ModelPart BackLeftLeg;
	private final ModelPart BackRightLeg;
	private final ModelPart FrontRightLeg;
	private final ModelPart FrontLeftLeg;
	private final ModelPart Tail;
	private final ModelPart Head;

	public PangolinModel(ModelPart root) {
		this.Pangolin = root.getChild("Pangolin");
		this.Body = this.Pangolin.getChild("Body");
		this.BackBody = this.Body.getChild("BackBody");
		this.FrontBody = this.Body.getChild("FrontBody");
		this.Legs = this.Body.getChild("Legs");
		this.BackLeftLeg = this.Legs.getChild("BackLeftLeg");
		this.BackRightLeg = this.Legs.getChild("BackRightLeg");
		this.FrontRightLeg = this.Legs.getChild("FrontRightLeg");
		this.FrontLeftLeg = this.Legs.getChild("FrontLeftLeg");
		this.Tail = this.Body.getChild("Tail");
		this.Head = this.Pangolin.getChild("Head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Pangolin = partdefinition.addOrReplaceChild("Pangolin", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Body = Pangolin.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition BackBody = Body.addOrReplaceChild("BackBody", CubeListBuilder.create().texOffs(28, 14).addBox(-4.0F, -6.0F, -1.0F, 8.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, 4.0F));

		PartDefinition FrontBody = Body.addOrReplaceChild("FrontBody", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -6.0F, -5.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, 0.0F));

		PartDefinition Legs = Body.addOrReplaceChild("Legs", CubeListBuilder.create(), PartPose.offset(0.0F, 1.0F, -4.0F));

		PartDefinition BackLeftLeg = Legs.addOrReplaceChild("BackLeftLeg", CubeListBuilder.create().texOffs(32, 0).addBox(2.0F, -6.0F, -1.0F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 9.0F));

		PartDefinition BackRightLeg = Legs.addOrReplaceChild("BackRightLeg", CubeListBuilder.create().texOffs(20, 32).addBox(-4.0F, -6.0F, -1.0F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 9.0F));

		PartDefinition FrontRightLeg = Legs.addOrReplaceChild("FrontRightLeg", CubeListBuilder.create().texOffs(10, 30).addBox(-4.0F, -6.0F, -1.0F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition FrontLeftLeg = Legs.addOrReplaceChild("FrontLeftLeg", CubeListBuilder.create().texOffs(0, 30).addBox(2.0F, -6.0F, -1.0F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(0, 14).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, 8.0F));

		PartDefinition Head = Pangolin.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(28, 24).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, -6.0F, -8.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

		this.animateWalk(ModAnimationDefinitions.PangolinWalk, limbSwing, limbSwingAmount, 2F, 2.5F);
		this.animate(((PangolinEntity) entity).idleAnimationState, ModAnimationDefinitions.PangolinIdle, ageInTicks, 1f);
	}
	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.Head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.Head.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Pangolin.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return Pangolin;
	}
}