package com.trapistsone.mod.proxy;

import com.trapistsone.mod.world.dimension.ModDimensions;

public class CommonProxy {
    public void preInit() {
        // Общая предварительная инициализация
        ModDimensions.registerDimensions();
    }

    public void init() {
        // Общая инициализация
    }
}