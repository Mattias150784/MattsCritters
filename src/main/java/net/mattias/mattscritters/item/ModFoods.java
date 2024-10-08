package net.mattias.mattscritters.item;


import net.minecraft.world.food.FoodProperties;

public class ModFoods {

    public static final FoodProperties CHEESE  = new FoodProperties.Builder().nutrition(2).fast()
            .saturationMod(0.2f).build();

    public static final FoodProperties DEAD_RAT  = new FoodProperties.Builder().nutrition(1).fast()
            .saturationMod(0.1f).build();

    public static final FoodProperties COOKED_RAT  = new FoodProperties.Builder().nutrition(1).fast()
            .saturationMod(0.3f).build();

}