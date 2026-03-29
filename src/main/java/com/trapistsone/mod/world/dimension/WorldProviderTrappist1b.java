package com.trapistsone.mod.world.dimension;

import com.trapistsone.mod.init.ModBiomes;
import com.trapistsone.mod.world.chunk.ChunkGeneratorTrappist1b;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class WorldProviderTrappist1b extends WorldProvider {

    @Override
    public void init() {
        this.biomeProvider = new BiomeProviderSingle(ModBiomes.TRAPPIST_1B_VOLCANIC);
        this.hasSkyLight = true;
    }

    @Nullable
    @SideOnly(Side.CLIENT)
    public net.minecraftforge.client.IRenderHandler getSkyRenderer() {
        return new com.trapistsone.mod.client.render.SkyProviderTrappist(200);
    }


    @Override
    public DimensionType getDimensionType() {
        return ModDimensions.TRAPPIST_1B;
    }

    @Override
    public IChunkGenerator createChunkGenerator() {
        String generatorOptions = "{" +
                "\"coordinateScale\": 684.412," +
                "\"heightScale\": 684.412," +
                "\"lowerLimitScale\": 512.0," +
                "\"upperLimitScale\": 512.0," +
                "\"depthNoiseScaleX\": 200.0," +
                "\"depthNoiseScaleZ\": 200.0," +
                "\"depthNoiseScaleExponent\": 0.5," +
                "\"mainNoiseScaleX\": 80.0," +
                "\"mainNoiseScaleY\": 160.0," +
                "\"mainNoiseScaleZ\": 80.0," +
                "\"baseSize\": 8.5," +
                "\"stretchY\": 12.0," +
                "\"biomeDepthWeight\": 1.0," +
                "\"biomeDepthOffset\": 0.0," +
                "\"biomeScaleWeight\": 1.0," +
                "\"biomeScaleOffset\": 0.0," +
                "\"seaLevel\": 32," + 
                "\"useCaves\": true," +
                "\"useDungeons\": true," +
                "\"useStrongholds\": false," +
                "\"useVillages\": false," +
                "\"useMineShafts\": true," +
                "\"useTemples\": false," +
                "\"useMonuments\": false," +
                "\"useMansions\": false," +
                "\"useRavines\": true," +
                "\"useWaterLakes\": false," +
                "\"useLavaLakes\": true," +
                "\"useLavaOceans\": true," +
                "\"fixedBiome\": -1," +
                "\"biomeSize\": 4," +
                "\"riverSize\": 4," +
                "\"dirtSize\": 0," +
                "\"gravelSize\": 0," +
                "\"graniteSize\": 0," +
                "\"dioriteSize\": 0," +
                "\"andesiteSize\": 0," +
                "\"coalSize\": 0," +
                "\"ironSize\": 0," +
                "\"goldSize\": 0," +
                "\"redstoneSize\": 0," +
                "\"diamondSize\": 0," +
                "\"lapisSize\": 0" +
                "}";

        return new ChunkGeneratorTrappist1b(this.world, this.world.getSeed(), false, generatorOptions);
    }

    @Override
    public boolean canRespawnHere() {
        return false;
    }

    @Override
    public boolean isSurfaceWorld() {
        return false;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public Vec3d getFogColor(float p_76562_1_, float p_76562_2_) {
        return new Vec3d(0.4D, 0.05D, 0.0D);
    }

    @Override
    protected void generateLightBrightnessTable() {
        for (int i = 0; i <= 15; ++i) {
            float f1 = 1.0F - (float) i / 15.0F;
            this.lightBrightnessTable[i] = (1.0F - f1) / (f1 * 3.0F + 1.0F) * 1.2F + 0.1F;
        }
    }
}
