package com.trapistsone.mod.blocks.trapist1f;

import com.trapistsone.mod.blocks.BlockBase;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockIceSaltWater extends BlockBase {
    public BlockIceSaltWater() {
        super("trappist_1f_ice_salt_water", Material.ROCK); // Use ROCK so it doesn't melt like vanilla ice
        setHardness(2.5f);
        setResistance(3.0f);
        setSoundType(SoundType.GLASS);
        slipperiness = 0.98F;
    }
}
