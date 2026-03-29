package com.trapistsone.mod.blocks.trapist1c;

import com.trapistsone.mod.creativetabs.TRAPPISTCreativeTab;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;

/**
 * Песчаная почва TRAPPIST-1c — обычный падающий песок
 */
public class Trappist1cSandySoil extends BlockFalling {
    public Trappist1cSandySoil() {
        super(Material.SAND);
        setUnlocalizedName("trapistsone.trappist_1c_sandy_soil");
        setRegistryName("trappist_1c_sandy_soil");
        setCreativeTab(TRAPPISTCreativeTab.INSTANCE);
        
        // Мягкий песок, легко копается
        setHardness(0.6f);
        setResistance(0.6f);
        setHarvestLevel("shovel", 0);
    }
}
