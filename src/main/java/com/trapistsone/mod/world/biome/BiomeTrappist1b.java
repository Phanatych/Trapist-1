package com.trapistsone.mod.world.biome;

import com.trapistsone.mod.blocks.ModBlocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.init.Blocks;

public class BiomeTrappist1b extends Biome {

    public BiomeTrappist1b() {
        super(new BiomeProperties("TRAPPIST-1b Volcanic")
                .setBaseHeight(0.5F)
                .setHeightVariation(0.3F)
                .setTemperature(2.0F)
                .setRainfall(0.0F)
                .setRainDisabled());

        // Основные блоки поверхности - Базальт
        this.topBlock = ModBlocks.TRAPPIST_1B_BASALT_ROCK.getDefaultState();
        this.fillerBlock = ModBlocks.TRAPPIST_1B_DARK_VEINED_ROCK.getDefaultState();

        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();

        // Отключаем всё ванильное
        this.decorator.treesPerChunk = -999;
        this.decorator.flowersPerChunk = -999;
        this.decorator.grassPerChunk = -999;
    }
}
