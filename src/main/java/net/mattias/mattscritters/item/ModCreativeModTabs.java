package net.mattias.mattscritters.item;

import net.mattias.mattscritters.MattsCritters;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MattsCritters.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MATTS_CRITTERS = CREATIVE_MODE_TABS.register("matts_critters",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CHEESE.get()))
                    .title(Component.translatable("creativetab.matts_critters"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.CHEESE.get());
                        pOutput.accept(ModItems.DEAD_RAT.get());
                        pOutput.accept(ModItems.COOKED_RAT.get());
                        pOutput.accept(ModItems.RAT_SPAWN_EGG.get());
                        pOutput.accept(ModItems.PANGOLIN_SPAWN_EGG.get());
                        pOutput.accept(ModItems.PANGOLIN_SCUTE.get());
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}