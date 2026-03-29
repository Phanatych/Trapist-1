package com.trapistsone.mod.world.feature;

import com.trapistsone.mod.blocks.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenCrater extends WorldGenerator {

    private final IBlockState topBlock;
    private final IBlockState fillerBlock;

    public WorldGenCrater() {
        this.topBlock = ModBlocks.TRAPPIST_1C_SANDY_SOIL.getDefaultState();
        this.fillerBlock = ModBlocks.TRAPPIST_1C_CRACKS_IN_THE_DRY_SOIL.getDefaultState();
    }

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
        // Find surface strictly from top down to avoid floating starting points
        int startY = 255;
        while (startY > 2 && worldIn.isAirBlock(new BlockPos(position.getX(), startY, position.getZ()))) {
            startY--;
        }
        position = new BlockPos(position.getX(), startY, position.getZ());

        if (worldIn.getBlockState(position).getBlock() != ModBlocks.TRAPPIST_1C_SANDY_SOIL) {
            return false;
        }

        // Crater radius
        boolean isGiant = rand.nextInt(20) == 0;
        int radius = isGiant ? rand.nextInt(15) + 20 : rand.nextInt(8) + 5;
        
        // Crater depth
        int maxDepth = radius / 3 + rand.nextInt(3);

        int rSq = radius * radius;

        // Generation
        for (int x = -radius; x <= radius; x++) {
            for (int z = -radius; z <= radius; z++) {
                int distSq = x * x + z * z;
                
                if (distSq <= rSq) {
                    // Calculate depth shape (parabolic bowl)
                    double distanceRatio = Math.sqrt(distSq) / (double)radius;
                    int depth = (int)Math.round(maxDepth * (1.0 - Math.pow(distanceRatio, 2)));
                    
                    // Clear blocks above the new bottom ALL THE WAY UP TO SKY
                    for (int y = 120; y > -depth; y--) {
                        BlockPos pos = position.add(x, y, z);
                        if (!worldIn.isAirBlock(pos)) {
                            worldIn.setBlockToAir(pos);
                        }
                    }
                    
                    // Set floor
                    BlockPos floorPos = position.add(x, -depth, z);
                    worldIn.setBlockState(floorPos, this.topBlock, 2);
                    
                    // Set subfloor
                    for (int y = -depth - 1; y >= -depth - 3; y--) {
                        BlockPos subPos = position.add(x, y, z);
                        worldIn.setBlockState(subPos, this.fillerBlock, 2);
                    }
                }
            }
        }
        return true;
    }
}
