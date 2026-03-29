package com.trapistsone.mod.world.dimension;

import com.trapistsone.mod.init.ModBiomes;
import com.trapistsone.mod.world.chunk.ChunkGeneratorTrappist1c;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class WorldProviderTrappist1c extends WorldProvider {

    @Override
    public void init() {
        this.biomeProvider = new BiomeProviderSingle(ModBiomes.TRAPPIST_1C_DESERT);
        this.hasSkyLight = true;
    }

    @Nullable
    @SideOnly(Side.CLIENT)
    public net.minecraftforge.client.IRenderHandler getSkyRenderer() {
        return new com.trapistsone.mod.client.render.SkyProviderTrappist(201);
    }


    @Override
    public DimensionType getDimensionType() {
        return ModDimensions.TRAPPIST_1C;
    }

    @Override
    public IChunkGenerator createChunkGenerator() {
        // Разнообразный рельеф: coordinateScale и heightScale определяют плавность и высоту
        // biomeDepthWeight и biomeScaleWeight позволяют создавать перепады высот
        String generatorOptions = "{" +
                "\"coordinateScale\": 800.0," + // Уменьшили, чтобы холмы были шире
                "\"heightScale\": 600.0," + // Уменьшили высоту гор
                "\"lowerLimitScale\": 512.0," +
                "\"upperLimitScale\": 512.0," +
                "\"depthNoiseScaleX\": 200.0," +
                "\"depthNoiseScaleZ\": 200.0," +
                "\"depthNoiseScaleExponent\": 0.5," +
                "\"mainNoiseScaleX\": 400.0," + // Сильно увеличили, чтобы убрать резкие пики и парящие острова
                "\"mainNoiseScaleY\": 500.0," +
                "\"mainNoiseScaleZ\": 400.0," +
                "\"baseSize\": 8.5," +
                "\"stretchY\": 5.0," + // Уменьшили растяжение по вертикали (меньше шансов на парящие куски)
                "\"biomeDepthWeight\": 1.5," +
                "\"biomeDepthOffset\": 0.0," +
                "\"biomeScaleWeight\": 2.0," +
                "\"biomeScaleOffset\": 0.0," +
                "\"seaLevel\": 0," +
                "\"useCaves\": false," +
                "\"useDungeons\": false," +
                "\"useStrongholds\": false," +
                "\"useVillages\": false," +
                "\"useMineShafts\": false," +
                "\"useTemples\": false," +
                "\"useMonuments\": false," +
                "\"useMansions\": false," +
                "\"useRavines\": false," +
                "\"useWaterLakes\": false," +
                "\"useLavaLakes\": false," +
                "\"useLavaOceans\": false," +
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

        return new ChunkGeneratorTrappist1c(this.world, this.world.getSeed(), false, generatorOptions);
    }

    @Override
    public boolean canRespawnHere() {
        return false;
    }

    @Override
    public boolean isSurfaceWorld() {
        return false; // Not the main overworld
    }

    @SideOnly(Side.CLIENT)
    @Override
    public Vec3d getFogColor(float p_76562_1_, float p_76562_2_) {
        // A reddish/orange sky to simulate the red dwarf and lack of thick atmosphere
        return new Vec3d(0.8D, 0.4D, 0.2D);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public float getStarBrightness(float par1) {
        return 1.0F; // Bright stars due to thin atmosphere
    }

    @Override
    protected void generateLightBrightnessTable() {
        float f = 0.0F;

        for (int i = 0; i <= 15; ++i) {
            float f1 = 1.0F - (float) i / 15.0F;
            this.lightBrightnessTable[i] = (1.0F - f1) / (f1 * 3.0F + 1.0F) * 1.0F + 0.0F;
        }
    }
}
