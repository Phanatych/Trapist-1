package com.trapistsone.mod.client.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

import java.util.Random;

public class SkyProviderTrappist extends IRenderHandler {

    private final int dimId;

    public SkyProviderTrappist(int dimensionId) {
        this.dimId = dimensionId;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void render(float partialTicks, WorldClient world, Minecraft mc) {
        GlStateManager.disableTexture2D();
        GlStateManager.disableFog();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.depthMask(false);
        
        // 1. Stars
        renderStarsSimple(partialTicks, world);

        GlStateManager.enableTexture2D();
        GlStateManager.enableBlend();
        
        // Proper transparency blending
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.enableAlpha();
        GlStateManager.alphaFunc(516, 0.01F);

        double dist = 150.0D;

        // 2. Render Planets
        if (dimId == 200) {
            renderPlanet(mc, partialTicks, world, 40.0F, dist, 60.0F, 40.0F, 0.9F, 0.6F, 0.4F);
            renderPlanet(mc, partialTicks, world, 20.0F, dist, 140.0F, -20.0F, 0.3F, 0.5F, 1.0F);
        } else if (dimId == 201) {
            renderPlanet(mc, partialTicks, world, 65.0F, dist, 50.0F, 80.0F, 1.0F, 0.2F, 0.1F);
            renderPlanet(mc, partialTicks, world, 25.0F, dist, -60.0F, 30.0F, 0.4F, 0.6F, 1.0F);
        } else if (dimId == 202) {
            renderPlanet(mc, partialTicks, world, 20.0F, dist, 40.0F, 110.0F, 1.0F, 0.2F, 0.1F);
            renderPlanet(mc, partialTicks, world, 30.0F, dist, 110.0F, -40.0F, 0.9F, 0.6F, 0.4F);
        }

        // 3. Render TRAPPIST-1 Sun
        GlStateManager.pushMatrix();
        float sunSize = (dimId == 200) ? 120.0F : ((dimId == 201) ? 80.0F : 50.0F);
        GlStateManager.rotate(world.getCelestialAngle(partialTicks) * 360.0F, 1.0F, 0.0F, 0.0F);
        
        mc.renderEngine.bindTexture(new ResourceLocation("minecraft:textures/environment/sun.png"));
        
        Tessellator tess = Tessellator.getInstance();
        BufferBuilder bb = tess.getBuffer();
        bb.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
        GlStateManager.color(1.0F, 0.15F, 0.0F, 1.0F);
        bb.pos(-sunSize, dist, -sunSize).tex(0.0D, 0.0D).endVertex();
        bb.pos(sunSize, dist, -sunSize).tex(1.0D, 0.0D).endVertex();
        bb.pos(sunSize, dist, sunSize).tex(1.0D, 1.0D).endVertex();
        bb.pos(-sunSize, dist, sunSize).tex(0.0D, 1.0D).endVertex();
        tess.draw();
        GlStateManager.popMatrix();

        GlStateManager.disableAlpha();
        GlStateManager.disableBlend();
        GlStateManager.depthMask(true);
        GlStateManager.enableFog();
    }

    private void renderStarsSimple(float partialTicks, WorldClient world) {
        Random random = new Random(10842L);
        GlStateManager.pushMatrix();
        GlStateManager.rotate(world.getCelestialAngle(partialTicks) * 360.0F, 1.0F, 0.0F, 0.0F);
        
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferbuilder = tessellator.getBuffer();
        bufferbuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);

        for (int i = 0; i < 2500; ++i) {
            double d0 = (double) (random.nextFloat() * 2.0F - 1.0F);
            double d1 = (double) (random.nextFloat() * 2.0F - 1.0F);
            double d2 = (double) (random.nextFloat() * 2.0F - 1.0F);
            double d3 = (double) (0.15F + random.nextFloat() * 0.1F);
            double d4 = d0 * d0 + d1 * d1 + d2 * d2;

            if (d4 < 1.0D && d4 > 0.01D) {
                d4 = 1.0D / Math.sqrt(d4);
                d0 *= d4; d1 *= d4; d2 *= d4;
                double d5 = d0 * 145.0D;
                double d6 = d1 * 145.0D;
                double d7 = d2 * 145.0D;

                float r = 0.8f + random.nextFloat() * 0.2f;
                float g = 0.8f + random.nextFloat() * 0.2f;
                float b = 0.8f + random.nextFloat() * 0.2f;
                
                int type = random.nextInt(10);
                if (type == 0) { r = 0.5f; g = 0.5f; b = 1.0f; }
                if (type == 1) { r = 1.0f; g = 0.5f; b = 0.5f; }

                bufferbuilder.pos(d5, d6, d7).color(r, g, b, 1.0F).endVertex();
                bufferbuilder.pos(d5 + d3, d6, d7).color(r, g, b, 1.0F).endVertex();
                bufferbuilder.pos(d5 + d3, d6 + d3, d7).color(r, g, b, 1.0F).endVertex();
                bufferbuilder.pos(d5, d6 + d3, d7).color(r, g, b, 1.0F).endVertex();
            }
        }
        tessellator.draw();
        GlStateManager.popMatrix();
    }

    private void renderPlanet(Minecraft mc, float partialTicks, WorldClient world, float size, double dist, float angleX, float angleZ, float r, float g, float b) {
        GlStateManager.pushMatrix();
        GlStateManager.rotate(angleX, 1.0F, 0.0F, 0.0F);
        GlStateManager.rotate(angleZ, 0.0F, 0.0F, 1.0F);
        GlStateManager.rotate(world.getCelestialAngle(partialTicks) * 360.0F, 1.0F, 0.0F, 0.0F);
        
        GlStateManager.color(r, g, b, 1.0F);
        mc.renderEngine.bindTexture(new ResourceLocation("minecraft:textures/environment/moon_phases.png"));
        
        Tessellator tess = Tessellator.getInstance();
        BufferBuilder bb = tess.getBuffer();
        bb.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
        // Full moon UVs
        double minU = 0.0D;
        double maxU = 0.25D;
        double minV = 0.0D;
        double maxV = 0.5D;
        
        bb.pos(-size, dist, -size).tex(minU, minV).endVertex();
        bb.pos(size, dist, -size).tex(maxU, minV).endVertex();
        bb.pos(size, dist, size).tex(maxU, maxV).endVertex();
        bb.pos(-size, dist, size).tex(minU, maxV).endVertex();
        tess.draw();
        
        GlStateManager.popMatrix();
    }
}
