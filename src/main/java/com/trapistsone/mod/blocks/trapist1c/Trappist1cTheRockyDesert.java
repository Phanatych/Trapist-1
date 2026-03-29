package com.trapistsone.mod.blocks.trapist1c;

import com.trapistsone.mod.creativetabs.TRAPPISTCreativeTab;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;

/**
 * Каменистая пустыня TRAPPIST-1c — твёрдый песчаник с гравием
 */
public class Trappist1cTheRockyDesert extends BlockFalling {
    public Trappist1cTheRockyDesert() {
        super(Material.SAND);
        setUnlocalizedName("trapistsone.trappist_1c_the_rocky_desert");
        setRegistryName("trappist_1c_the_rocky_desert");
        setCreativeTab(TRAPPISTCreativeTab.INSTANCE);
        
        // Твёрдый песчаник с камнями
        setHardness(1.5f);
        setResistance(6.0f);
        setHarvestLevel("pickaxe", 0);
    }
}
