package com.trapistsone.mod.world.chunk;

import com.trapistsone.mod.blocks.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.ChunkGeneratorOverworld;

public class ChunkGeneratorTrappist1f extends ChunkGeneratorOverworld {

    public ChunkGeneratorTrappist1f(World worldIn, long seed, boolean mapFeaturesEnabledIn, String generatorOptions) {
        super(worldIn, seed, mapFeaturesEnabledIn, generatorOptions);
    }

    @Override
    public void replaceBiomeBlocks(int x, int z, ChunkPrimer primer, Biome[] biomesIn) {
        super.replaceBiomeBlocks(x, z, primer, biomesIn);

        IBlockState stone = Blocks.STONE.getDefaultState();
        IBlockState iceCO2 = ModBlocks.TRAPPIST_1F_ICE_CO2.getDefaultState();
        IBlockState water = Blocks.WATER.getDefaultState();

        // Подземный океан (под толстым слоем льда - вода)
        for (int i = 0; i < 16; ++i) {
            for (int j = 0; j < 16; ++j) {
                for (int k = 0; k < 256; ++k) {
                    if (primer.getBlockState(i, k, j) == stone) {
                        // Верхняя корка (y от 50 до 255)
                        if (k > 50) {
                            primer.setBlockState(i, k, j, iceCO2);
                        } 
                        // Подледный океан (y от 5 до 50)
                        else if (k > 5) {
                            primer.setBlockState(i, k, j, water);
                        }
                        // Ядро (ниже 5)
                        else {
                            primer.setBlockState(i, k, j, ModBlocks.TRAPPIST_1B_BASALT_ROCK.getDefaultState());
                        }
                    }
                }
            }
        }
    }
}
