package net.mattias.mattscritters.item;

import net.mattias.mattscritters.MattsCritters;
import net.mattias.mattscritters.entity.ModEntities;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;



public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MattsCritters.MOD_ID);

    public static final RegistryObject<Item> CHEESE = ITEMS.register("cheese",
            () -> new Item(new Item.Properties().food(ModFoods.CHEESE)));

    public static final RegistryObject<Item> DEAD_RAT = ITEMS.register("dead_rat",
            () -> new Item(new Item.Properties().food(ModFoods.DEAD_RAT)));

    public static final RegistryObject<Item> COOKED_RAT = ITEMS.register("cooked_rat",
            () -> new Item(new Item.Properties().food(ModFoods.COOKED_RAT)));

    public static final RegistryObject<Item> RAT_SPAWN_EGG = ITEMS.register("rat_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.RAT, 0xb0a4a4, 0x65e5e,
                    new Item.Properties()));

    public static final RegistryObject<Item> PANGOLIN_SPAWN_EGG = ITEMS.register("pangolin_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.PANGOLIN, 0x472e0b, 0x59390c,
                    new Item.Properties()));

    public static final RegistryObject<Item> PANGOLIN_SCUTE = ITEMS.register("pangolin_scute",
            () -> new Item(new Item.Properties()));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}