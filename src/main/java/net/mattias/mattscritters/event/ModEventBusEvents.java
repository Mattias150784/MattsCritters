package net.mattias.mattscritters.event;

import net.mattias.mattscritters.MattsCritters;
import net.mattias.mattscritters.entity.ModEntities;
import net.mattias.mattscritters.entity.custom.RatEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MattsCritters.MOD_ID, bus =  Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
@SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.RAT.get(), RatEntity.createAttributes().build());
    }
}
