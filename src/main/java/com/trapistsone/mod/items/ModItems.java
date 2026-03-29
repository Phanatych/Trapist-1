package com.trapistsone.mod.items;

import com.trapistsone.mod.blocks.ModBlocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber
public class ModItems {
    public static final List<Item> ITEMS = new ArrayList<>();

    // ItemBlocks
    public static final Item TRAPPIST_1B_BASALT_ROCK = new ItemBlock(ModBlocks.TRAPPIST_1B_BASALT_ROCK).setRegistryName(ModBlocks.TRAPPIST_1B_BASALT_ROCK.getRegistryName());
    public static final Item TRAPPIST_1B_DARK_VEINED_ROCK = new ItemBlock(ModBlocks.TRAPPIST_1B_DARK_VEINED_ROCK).setRegistryName(ModBlocks.TRAPPIST_1B_DARK_VEINED_ROCK.getRegistryName());
    public static final Item TRAPPIST_1B_OXIDIZED_STONE = new ItemBlock(ModBlocks.TRAPPIST_1B_OXIDIZED_STONE).setRegistryName(ModBlocks.TRAPPIST_1B_OXIDIZED_STONE.getRegistryName());
    public static final Item MOLTEN_IRON_ORE = new ItemBlock(ModBlocks.MOLTEN_IRON_ORE).setRegistryName(ModBlocks.MOLTEN_IRON_ORE.getRegistryName());
    
    public static final Item TRAPPIST_1C_CRACKS_IN_THE_DRY_SOIL = new ItemBlock(ModBlocks.TRAPPIST_1C_CRACKS_IN_THE_DRY_SOIL).setRegistryName(ModBlocks.TRAPPIST_1C_CRACKS_IN_THE_DRY_SOIL.getRegistryName());
    public static final Item TRAPPIST_1C_SANDY_SOIL = new ItemBlock(ModBlocks.TRAPPIST_1C_SANDY_SOIL).setRegistryName(ModBlocks.TRAPPIST_1C_SANDY_SOIL.getRegistryName());

    public static final Item TRAPPIST_1F_ICE_CO2 = new ItemBlock(ModBlocks.TRAPPIST_1F_ICE_CO2).setRegistryName(ModBlocks.TRAPPIST_1F_ICE_CO2.getRegistryName());
    public static final Item TRAPPIST_1F_ICE_SALT_WATER = new ItemBlock(ModBlocks.TRAPPIST_1F_ICE_SALT_WATER).setRegistryName(ModBlocks.TRAPPIST_1F_ICE_SALT_WATER.getRegistryName());

    static {
        ITEMS.add(TRAPPIST_1B_BASALT_ROCK);
        ITEMS.add(TRAPPIST_1B_DARK_VEINED_ROCK);
        ITEMS.add(TRAPPIST_1B_OXIDIZED_STONE);
        ITEMS.add(MOLTEN_IRON_ORE);
        ITEMS.add(TRAPPIST_1C_CRACKS_IN_THE_DRY_SOIL);
        ITEMS.add(TRAPPIST_1C_SANDY_SOIL);
        ITEMS.add(TRAPPIST_1F_ICE_CO2);
        ITEMS.add(TRAPPIST_1F_ICE_SALT_WATER);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        for (Item item : ITEMS) {
            event.getRegistry().register(item);
        }
    }
}
