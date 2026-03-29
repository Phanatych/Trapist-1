package com.trapistsone.mod.world.dimension;

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class ModDimensions {

    public static DimensionType TRAPPIST_1B;
    public static DimensionType TRAPPIST_1C;
    public static DimensionType TRAPPIST_1F;

    public static void registerDimensions() {
        TRAPPIST_1B = DimensionType.register("TRAPPIST-1b", "_trappist_1b", 200, WorldProviderTrappist1b.class, false);
        DimensionManager.registerDimension(200, TRAPPIST_1B);

        TRAPPIST_1C = DimensionType.register("TRAPPIST-1c", "_trappist_1c", 201, WorldProviderTrappist1c.class, false);
        DimensionManager.registerDimension(201, TRAPPIST_1C);
        
        TRAPPIST_1F = DimensionType.register("TRAPPIST-1f", "_trappist_1f", 202, WorldProviderTrappist1f.class, false);
        DimensionManager.registerDimension(202, TRAPPIST_1F);
    }
}
