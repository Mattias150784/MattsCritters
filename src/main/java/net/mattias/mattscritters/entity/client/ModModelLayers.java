package net.mattias.mattscritters.entity.client;

import net.mattias.mattscritters.MattsCritters;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {

    public static final ModelLayerLocation RAT_LAYER = new ModelLayerLocation(
            new ResourceLocation(MattsCritters.MOD_ID, "rat_layer"), "main");

    public static final ModelLayerLocation PANGOLIN_LAYER = new ModelLayerLocation(
            new ResourceLocation(MattsCritters.MOD_ID, "pangolin_layer"), "main");

}
