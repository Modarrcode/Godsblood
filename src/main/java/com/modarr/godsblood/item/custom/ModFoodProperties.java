package com.modarr.godsblood.item.custom;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties BANANA = new FoodProperties.Builder().nutrition(3).saturationModifier(0.25f)
            .alwaysEdible().fast().effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST,400), 1f).build();
}
