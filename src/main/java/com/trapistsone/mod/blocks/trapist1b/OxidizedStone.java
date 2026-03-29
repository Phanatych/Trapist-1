package com.trapistsone.mod.blocks.trapist1b;

import com.trapistsone.mod.blocks.BlockBase;
import net.minecraft.block.material.Material;

/**
 * Окисленный камень TRAPPIST-1b — окисленная вулканическая порода
 */
public class OxidizedStone extends BlockBase {
    public OxidizedStone() {
        super("trappist_1b_oxidized_stone", Material.ROCK);
        setHardness(2.0f);        // Твёрже камня (1.5)
        setResistance(10.0f);     // Высокая сопротивляемость
        setHarvestLevel("pickaxe", 1); // Требуется каменная кирка
    }
}



