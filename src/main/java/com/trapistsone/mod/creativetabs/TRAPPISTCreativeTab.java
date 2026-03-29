package com.trapistsone.mod.creativetabs;

import com.trapistsone.mod.blocks.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TRAPPISTCreativeTab extends CreativeTabs {
    public static final TRAPPISTCreativeTab INSTANCE = new TRAPPISTCreativeTab();

    public TRAPPISTCreativeTab() {
        super("trapist_blocks");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ModBlocks.TRAPPIST_1B_BASALT_ROCK);
    }

    @Override
    public String getTabLabel() {
        // Должно совпадать с ключом локализации itemGroup.trapist_blocks
        return "trapistsone.trapist_blocks";
    }
}