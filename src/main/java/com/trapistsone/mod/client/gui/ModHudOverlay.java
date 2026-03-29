package com.trapistsone.mod.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ModHudOverlay extends Gui {

    @SubscribeEvent
    public static void onRenderGui(RenderGameOverlayEvent.Post event) {
        if (event.getType() != RenderGameOverlayEvent.ElementType.EXPERIENCE) return;

        Minecraft mc = Minecraft.getMinecraft();
        EntityPlayer player = mc.player;
        if (player == null) return;

        int dim = player.dimension;

        // Показывать HUD только в наших измерениях
        if (dim == 200 || dim == 201 || dim == 202) {
            ScaledResolution sr = new ScaledResolution(mc);
            FontRenderer fontRenderer = mc.fontRenderer;
            long time = mc.world.getWorldTime() % 24000;
            
            int temperature = 0;
            String oxygen = "0";
            String gravity = "1.0";

            if (dim == 200) {
                // TRAPPIST-1b (Вулканическая)
                gravity = "1.10";
                // Всегда очень жарко
                temperature = 380 + (int)(Math.sin((time / 24000.0) * 2.0 * Math.PI) * 50);
            }
            else if (dim == 201) {
                // TRAPPIST-1c (Марсоподобная)
                gravity = "0.38";
                if (time > 0 && time < 12000) {
                    temperature = -10 + (int)(Math.sin((time / 12000.0) * Math.PI) * 55);
                } else {
                    temperature = -10 - (int)(Math.sin(((time - 12000) / 12000.0) * Math.PI) * 50);
                }
            } 
            else if (dim == 202) {
                // TRAPPIST-1f (Ледяная)
                gravity = "0.68"; // Чуть меньше земной
                // Температура всегда экстремально низкая, небольшие колебания днем
                if (time > 0 && time < 12000) {
                    temperature = -90 + (int)(Math.sin((time / 12000.0) * Math.PI) * 15); // от -90 до -75
                } else {
                    temperature = -90 - (int)(Math.sin(((time - 12000) / 12000.0) * Math.PI) * 20); // от -90 до -110
                }
            }

            String tempText = I18n.format("gui.trapistsone.temperature", temperature);
            String oxygenText = I18n.format("gui.trapistsone.oxygen", oxygen);
            String gravText = I18n.format("gui.trapistsone.gravity", gravity);
            
            // Цвет: красный если жарко, синий если холодно
            int colorTemp = temperature > 35 ? 0xFF5555 : (temperature < -30 ? 0x5555FF : 0xFFFFFF);

            fontRenderer.drawStringWithShadow(tempText, 10, 10, colorTemp);
            fontRenderer.drawStringWithShadow(oxygenText, 10, 20, 0xAAAAAA);
            fontRenderer.drawStringWithShadow(gravText, 10, 30, 0xAAAAAA);
        }
    }
}
