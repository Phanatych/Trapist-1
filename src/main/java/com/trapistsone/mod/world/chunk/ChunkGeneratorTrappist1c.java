package com.trapistsone.mod.world.chunk;

import com.trapistsone.mod.blocks.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.ChunkGeneratorOverworld;

public class ChunkGeneratorTrappist1c extends ChunkGeneratorOverworld {

    public ChunkGeneratorTrappist1c(World worldIn, long seed, boolean mapFeaturesEnabledIn, String generatorOptions) {
        super(worldIn, seed, mapFeaturesEnabledIn, generatorOptions);
    }

    @Override
    public void replaceBiomeBlocks(int x, int z, ChunkPrimer primer, Biome[] biomesIn) {
        // Сначала применяем блоки биома
        super.replaceBiomeBlocks(x, z, primer, biomesIn);

        IBlockState stone = Blocks.STONE.getDefaultState();
        IBlockState undergroundRock = ModBlocks.TRAPPIST_1C_CRACKS_IN_THE_DRY_SOIL.getDefaultState();

        // Заменяем весь камень под землей на твердую породу TRAPPIST-1c
        for (int i = 0; i < 16; ++i) {
            for (int j = 0; j < 16; ++j) {
                for (int k = 0; k < 256; ++k) {
                    if (primer.getBlockState(i, k, j) == stone) {
                        primer.setBlockState(i, k, j, undergroundRock);
                    }
                }
            }
        }
    }
}
