package com.trapistsone.mod.world.feature;

import com.trapistsone.mod.blocks.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenIceSpike extends WorldGenerator {

    private final IBlockState iceBlock;

    public WorldGenIceSpike() {
        this.iceBlock = ModBlocks.TRAPPIST_1F_ICE_CO2.getDefaultState();
    }

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
        // Find surface strictly from top down to avoid floating starting points
        int startY = 255;
        while (startY > 2 && worldIn.isAirBlock(new BlockPos(position.getX(), startY, position.getZ()))) {
            startY--;
        }
        position = new BlockPos(position.getX(), startY, position.getZ());

        if (worldIn.getBlockState(position).getBlock() != ModBlocks.TRAPPIST_1F_ICE_SALT_WATER) {
            return false;
        }

        // Sink the spike slightly into the ice
        position = position.down(rand.nextInt(3));
        
        int height = rand.nextInt(15) + 10;
        int radius = rand.nextInt(4) + 2;

        for (int y = 0; y < height; ++y) {
            float f = (1.0F - (float)y / (float)height) * (float)radius;
            int r = Math.round(f);

            for (int x = -r; x <= r; ++x) {
                float f1 = (float)Math.abs(x) - 0.25F;

                for (int z = -r; z <= r; ++z) {
                    float f2 = (float)Math.abs(z) - 0.25F;

                    if ((x == 0 && z == 0 || f1 * f1 + f2 * f2 <= f * f) && (x != -r && x != r && z != -r && z != r || rand.nextFloat() <= 0.75F)) {
                        BlockPos blockpos = position.add(x, y, z);
                        if (worldIn.isAirBlock(blockpos) || worldIn.getBlockState(blockpos).getBlock() == ModBlocks.TRAPPIST_1F_ICE_SALT_WATER) {
                            worldIn.setBlockState(blockpos, this.iceBlock, 2);
                        }

                        // Deepen base to ensure it connects to the ground
                        if (y == 0 && r > 1) {
                            for (int depth = 1; depth < 8; depth++) {
                                BlockPos underPos = blockpos.down(depth);
                                if (worldIn.getBlockState(underPos).getBlock() == ModBlocks.TRAPPIST_1F_ICE_SALT_WATER) {
                                    worldIn.setBlockState(underPos, this.iceBlock, 2);
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}