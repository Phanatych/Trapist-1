package com.trapistsone.mod.world.biome;

import com.trapistsone.mod.blocks.ModBlocks;
import com.trapistsone.mod.world.feature.WorldGenCrater;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

import java.util.Random;

public class BiomeTrappist1cDesert extends Biome {

    private final WorldGenerator craterGen;

    public BiomeTrappist1cDesert() {
        super(new BiomeProperties("TRAPPIST-1c Desert")
                .setBaseHeight(0.2F) // Довольно ровная поверхность
                .setHeightVariation(0.05F) // Почти нет холмов, чтобы кратеры лучше выделялись
                .setTemperature(2.0F)
                .setRainfall(0.0F)
                .setRainDisabled());

        // Set blocks
        this.topBlock = ModBlocks.TRAPPIST_1C_SANDY_SOIL.getDefaultState();
        this.fillerBlock = ModBlocks.TRAPPIST_1C_CRACKS_IN_THE_DRY_SOIL.getDefaultState();

        this.craterGen = new WorldGenCrater();

        // Clear default spawns
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();

        // Remove vanilla decorations
        this.decorator.treesPerChunk = -999;
        this.decorator.flowersPerChunk = -999;
        this.decorator.grassPerChunk = -999;
        this.decorator.cactiPerChunk = -999;
        this.decorator.reedsPerChunk = -999;
        this.decorator.waterlilyPerChunk = -999;
    }

    @Override
    public void decorate(net.minecraft.world.World worldIn, Random rand, BlockPos pos) {
        super.decorate(worldIn, rand, pos);

        if (TerrainGen.decorate(worldIn, rand, pos, DecorateBiomeEvent.Decorate.EventType.CUSTOM)) {
            // Генерируем 1-2 кратера на чанк с определенным шансом (чтобы они не были прямо на каждом шагу)
            if (rand.nextInt(3) == 0) {
                int x = rand.nextInt(16) + 8;
                int z = rand.nextInt(16) + 8;
                int y = worldIn.getHeight(pos.add(x, 0, z)).getY();
                craterGen.generate(worldIn, rand, pos.add(x, y, z));
            }
        }
    }
}
