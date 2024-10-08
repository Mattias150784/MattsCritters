package net.mattias.mattscritters.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.mattias.mattscritters.MattsCritters;
import net.mattias.mattscritters.entity.custom.PangolinEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class PangolinRenderer extends MobRenderer<PangolinEntity, PangolinModel<PangolinEntity>> {
    public PangolinRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new PangolinModel<>(pContext.bakeLayer(ModModelLayers.PANGOLIN_LAYER)), .5f);
    }

    public ResourceLocation getTextureLocation(PangolinEntity pangolinEntity) {
        return new ResourceLocation(MattsCritters.MOD_ID, "textures/entity/pangolin.png");
    }

    @Override
    public void render(PangolinEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
if(pEntity.isBaby()) {
    pMatrixStack.scale(0.5f,0.5f,0.5f);
}


        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }




}
