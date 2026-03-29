package com.trapistsone.mod.events;

import com.trapistsone.mod.world.dimension.ModDimensions;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class ModEvents {

    @SubscribeEvent
    public static void onLivingUpdate(LivingEvent.LivingUpdateEvent event) {
        if (event.getEntityLiving() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getEntityLiving();
            
            // Если игрок в измерении TRAPPIST-1c
            if (player.dimension == 201) { // 201 - ID нашего измерения
                if (!player.onGround && !player.capabilities.isFlying && !player.isInWater() && !player.isInLava()) {
                    // Стандартная гравитация вычитает около 0.08 motionY каждый тик. 
                    // Чтобы сделать гравитацию ниже (марсианскую), мы будем добавлять часть motionY обратно.
                    // Например, добавление 0.04 создаст ощущение половинной гравитации.
                    player.motionY += 0.045D;
                    
                    // Ограничиваем максимальную скорость падения, чтобы игрок не разбивался так легко
                    if (player.motionY < -0.4D) {
                        player.motionY = -0.4D;
                    }
                }
            }
        }
    }
}
