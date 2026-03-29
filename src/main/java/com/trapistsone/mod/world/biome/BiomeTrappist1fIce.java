package com.trapistsone.mod.world.biome;

import com.trapistsone.mod.blocks.ModBlocks;
import com.trapistsone.mod.world.feature.WorldGenIceSpike;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

import java.util.Random;

public class BiomeTrappist1fIce extends Biome {

    private final WorldGenerator iceSpikeGen;

    public BiomeTrappist1fIce() {
        super(new BiomeProperties("TRAPPIST-1f Ice")
                .setBaseHeight(0.3F)
                .setHeightVariation(0.4F) // Более неровный ландшафт (торосы)
                .setTemperature(-2.0F) // Очень холодно
                .setRainfall(0.5F)
                .setSnowEnabled());

        // Поверхность - заснеженная трава
        this.topBlock = net.minecraft.init.Blocks.GRASS.getDefaultState();
        this.fillerBlock = net.minecraft.init.Blocks.DIRT.getDefaultState();

        this.iceSpikeGen = new WorldGenIceSpike();

        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();

        this.decorator.treesPerChunk = -999;
        this.decorator.flowersPerChunk = -999;
        this.decorator.grassPerChunk = -999;
    }

    @Override
    public void decorate(net.minecraft.world.World worldIn, Random rand, BlockPos pos) {
        super.decorate(worldIn, rand, pos);

        if (TerrainGen.decorate(worldIn, rand, pos, DecorateBiomeEvent.Decorate.EventType.CUSTOM)) {
            // Генерируем ледяные шипы
            for (int i = 0; i < 3; ++i) {
                int x = rand.nextInt(16) + 8;
                int z = rand.nextInt(16) + 8;
                int y = worldIn.getHeight(pos.add(x, 0, z)).getY();
                iceSpikeGen.generate(worldIn, rand, pos.add(x, y, z));
            }
        }
    }
}
