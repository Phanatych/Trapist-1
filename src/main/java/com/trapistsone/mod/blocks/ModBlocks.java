package com.trapistsone.mod.blocks;

import com.trapistsone.mod.blocks.trapist1b.DarkVeinedRock;
import com.trapistsone.mod.blocks.trapist1b.MoltenIronOre;
import com.trapistsone.mod.blocks.trapist1b.OxidizedStone;
import com.trapistsone.mod.blocks.trapist1b.Trappist1bBasaltRock;
import com.trapistsone.mod.blocks.trapist1c.Trappist1cCracksInTheDrySoil;
import com.trapistsone.mod.blocks.trapist1c.Trappist1cSandySoil;
import com.trapistsone.mod.blocks.trapist1f.BlockIceCO2;
import com.trapistsone.mod.blocks.trapist1f.BlockIceSaltWater;
import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber
public class ModBlocks {
    public static final List<Block> BLOCKS = new ArrayList<>();

    // TRAPPIST-1b blocks
    public static final Block TRAPPIST_1B_BASALT_ROCK = new Trappist1bBasaltRock();
    public static final Block TRAPPIST_1B_DARK_VEINED_ROCK = new DarkVeinedRock();
    public static final Block TRAPPIST_1B_OXIDIZED_STONE = new OxidizedStone();
    public static final Block MOLTEN_IRON_ORE = new MoltenIronOre();

    // TRAPPIST-1c blocks
    public static final Block TRAPPIST_1C_CRACKS_IN_THE_DRY_SOIL = new Trappist1cCracksInTheDrySoil();
    public static final Block TRAPPIST_1C_SANDY_SOIL = new Trappist1cSandySoil();

    // TRAPPIST-1f blocks
    public static final Block TRAPPIST_1F_ICE_CO2 = new BlockIceCO2();
    public static final Block TRAPPIST_1F_ICE_SALT_WATER = new BlockIceSaltWater();

    static {
        BLOCKS.add(TRAPPIST_1B_BASALT_ROCK);
        BLOCKS.add(TRAPPIST_1B_DARK_VEINED_ROCK);
        BLOCKS.add(TRAPPIST_1B_OXIDIZED_STONE);
        BLOCKS.add(MOLTEN_IRON_ORE);
        BLOCKS.add(TRAPPIST_1C_CRACKS_IN_THE_DRY_SOIL);
        BLOCKS.add(TRAPPIST_1C_SANDY_SOIL);
        BLOCKS.add(TRAPPIST_1F_ICE_CO2);
        BLOCKS.add(TRAPPIST_1F_ICE_SALT_WATER);
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        for (Block block : BLOCKS) {
            event.getRegistry().register(block);
        }
    }
}
