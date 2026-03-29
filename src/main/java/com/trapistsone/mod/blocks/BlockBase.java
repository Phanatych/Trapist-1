package com.trapistsone.mod.blocks;

import com.trapistsone.mod.creativetabs.TRAPPISTCreativeTab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBase extends Block {
    public BlockBase(String name, Material material) {
        super(material);
        setUnlocalizedName("trapistsone." + name);
        setRegistryName(name);
        setCreativeTab(TRAPPISTCreativeTab.INSTANCE);
    }
}