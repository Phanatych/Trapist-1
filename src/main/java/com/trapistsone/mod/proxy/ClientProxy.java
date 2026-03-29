package com.trapistsone.mod.proxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void preInit() {
        super.preInit();
        // Client resources registration
    }

    @Override
    public void init() {
        super.init();
        // Client components initialization
    }
}