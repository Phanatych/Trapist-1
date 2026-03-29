package com.trapistsone.mod.blocks.trapist1f;

import com.trapistsone.mod.blocks.BlockBase;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockIceCO2 extends BlockBase {
    public BlockIceCO2() {
        super("trappist_1f_ice_co2", Material.ICE);
        setHardness(2.0f);
        setResistance(2.0f);
        setSoundType(SoundType.GLASS);
        slipperiness = 0.98F;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, net.minecraft.util.EnumFacing side) {
        IBlockState iblockstate = blockAccess.getBlockState(pos.offset(side));
        return iblockstate.getBlock() != this && super.shouldSideBeRendered(blockState, blockAccess, pos, side);
    }
}
