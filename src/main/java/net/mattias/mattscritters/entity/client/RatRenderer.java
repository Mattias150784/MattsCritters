package net.mattias.mattscritters.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.mattias.mattscritters.MattsCritters;
import net.mattias.mattscritters.entity.custom.RatEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RatRenderer extends MobRenderer<RatEntity, RatModel<RatEntity>> {
    public RatRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new RatModel<>(pContext.bakeLayer(ModModelLayers.RAT_LAYER)), .5f);
    }

    @Override
    public ResourceLocation getTextureLocation(RatEntity ratEntity) {
        return new ResourceLocation(MattsCritters.MOD_ID, "textures/entity/white_rat.png");
    }

    @Override
    public void render(RatEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
if(pEntity.isBaby()) {
    pMatrixStack.scale(0.5f,0.5f,0.5f);
}


        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
