package com.trapistsone.mod.blocks.trapist1b;

import com.trapistsone.mod.blocks.BlockBase;
import net.minecraft.block.material.Material;

/**
 * Тёмная прожилковатая порода TRAPPIST-1b — плотная магматическая порода
 */
public class DarkVeinedRock extends BlockBase {
    public DarkVeinedRock() {
        super("trappist_1b_dark_veined_rock", Material.ROCK);
        setHardness(2.5f);        // Твёрже камня (1.5)
        setResistance(12.0f);     // Высокая сопротивляемость
        setHarvestLevel("pickaxe", 2); // Требуется алмазная кирка
    }
}
