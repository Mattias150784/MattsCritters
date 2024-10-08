package net.mattias.mattscritters.entity.client;// Made with Blockbench 4.11.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
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
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

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