package com.trapistsone.mod.world.chunk;

import com.trapistsone.mod.blocks.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.ChunkGeneratorOverworld;

public class ChunkGeneratorTrappist1b extends ChunkGeneratorOverworld {

    public ChunkGeneratorTrappist1b(World worldIn, long seed, boolean mapFeaturesEnabledIn, String generatorOptions) {
        super(worldIn, seed, mapFeaturesEnabledIn, generatorOptions);
    }

    @Override
    public void replaceBiomeBlocks(int x, int z, ChunkPrimer primer, Biome[] biomesIn) {
        super.replaceBiomeBlocks(x, z, primer, biomesIn);

        IBlockState stone = Blocks.STONE.getDefaultState();
        IBlockState basalt = ModBlocks.TRAPPIST_1B_BASALT_ROCK.getDefaultState();
        IBlockState darkVeined = ModBlocks.TRAPPIST_1B_DARK_VEINED_ROCK.getDefaultState();

        // Замена камня на базальт и темную породу
        for (int i = 0; i < 16; ++i) {
            for (int j = 0; j < 16; ++j) {
                for (int k = 0; k < 256; ++k) {
                    if (primer.getBlockState(i, k, j) == stone) {
                        // Смешиваем два вида камня для разнообразия
                        if ((i + j + k) % 5 == 0) {
                            primer.setBlockState(i, k, j, darkVeined);
                        } else {
                            primer.setBlockState(i, k, j, basalt);
                        }
                    }
                }
            }
        }
    }
}
