package com.trapistsone.mod;

import com.trapistsone.mod.commands.CommandTeleportDimension;
import com.trapistsone.mod.creativetabs.TRAPPISTCreativeTab;
import com.trapistsone.mod.proxy.CommonProxy;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = TRAPIST1Mod.MODID, name = TRAPIST1Mod.NAME, version = TRAPIST1Mod.VERSION)
public class TRAPIST1Mod
{
    public static final String MODID = "trapistsone";
    public static final String NAME = "TRAPPIST-1 Mod";
    public static final String VERSION = "1.0";

    @SidedProxy(clientSide = "com.trapistsone.mod.proxy.ClientProxy", serverSide = "com.trapistsone.mod.proxy.CommonProxy")
    public static CommonProxy proxy;

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        logger.info("TRAPPIST-1 Mod is starting pre-initialization...");
        proxy.preInit();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        logger.info("TRAPPIST-1 Mod is initializing...");
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
        logger.info("TRAPPIST Creative Tab registered: {}", TRAPPISTCreativeTab.INSTANCE.getTabLabel());
        proxy.init();
    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event) {
        event.registerServerCommand(new CommandTeleportDimension());
    }
}
