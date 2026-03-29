package com.trapistsone.mod.init;

import com.trapistsone.mod.world.biome.BiomeTrappist1b;
import com.trapistsone.mod.world.biome.BiomeTrappist1cDesert;
import com.trapistsone.mod.world.biome.BiomeTrappist1fIce;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class ModBiomes {

    public static final Biome TRAPPIST_1C_DESERT = new BiomeTrappist1cDesert()
            .setRegistryName("trapistsone", "trappist_1c_desert");
            
    public static final Biome TRAPPIST_1F_ICE = new BiomeTrappist1fIce()
            .setRegistryName("trapistsone", "trappist_1f_ice");

    public static final Biome TRAPPIST_1B_VOLCANIC = new BiomeTrappist1b()
            .setRegistryName("trapistsone", "trappist_1b_volcanic");

    @SubscribeEvent
    public static void registerBiomes(RegistryEvent.Register<Biome> event) {
        event.getRegistry().register(TRAPPIST_1C_DESERT);
        BiomeDictionary.addTypes(TRAPPIST_1C_DESERT, Type.DRY, Type.HOT, Type.DEAD, Type.SANDY);
        
        event.getRegistry().register(TRAPPIST_1F_ICE);
        BiomeDictionary.addTypes(TRAPPIST_1F_ICE, Type.COLD, Type.SNOWY, Type.DEAD, Type.OCEAN);

        event.getRegistry().register(TRAPPIST_1B_VOLCANIC);
        BiomeDictionary.addTypes(TRAPPIST_1B_VOLCANIC, Type.HOT, Type.DRY, Type.DEAD, Type.SPOOKY);
    }
}
