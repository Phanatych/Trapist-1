package com.trapistsone.mod.blocks.trapist1c;

import com.trapistsone.mod.blocks.BlockBase;
import net.minecraft.block.material.Material;

/**
 * Трещины в сухой почве TRAPPIST-1c — сухая земля (твердая порода)
 */
public class Trappist1cCracksInTheDrySoil extends BlockBase {
    public Trappist1cCracksInTheDrySoil() {
        super("trappist_1c_cracks_in_the_dry_soil", Material.ROCK);
        
        // Сухая потрескавшаяся земля
        setHardness(1.5f);
        setResistance(6.0f);
        setHarvestLevel("pickaxe", 0);
    }
}
