package com.trapistsone.mod.blocks.trapist1b;

import com.trapistsone.mod.blocks.BlockBase;
import net.minecraft.block.material.Material;

/**
 * Базальтовая скала TRAPPIST-1b — очень твёрдая вулканическая порода
 */
public class Trappist1bBasaltRock extends BlockBase {
    public Trappist1bBasaltRock() {
        super("trappist_1b_basalt_rock", Material.ROCK);
        setHardness(3.0f);        // Твёрже гранита (1.5)
        setResistance(15.0f);     // Высокая сопротивляемость
        setHarvestLevel("pickaxe", 2); // Требуется алмазная кирка
    }
}
