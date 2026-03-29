package com.trapistsone.mod.blocks.trapist1b;

import com.trapistsone.mod.blocks.BlockBase;
import net.minecraft.block.material.Material;

public class MoltenIronOre extends BlockBase {
    public MoltenIronOre() {
        super("molten_iron_ore", Material.ROCK);
        setHardness(3.0f);
        setResistance(15.0f);
        setHarvestLevel("pickaxe", 2);
        setLightLevel(0.5f); // Руда светится, так как она расплавленная
    }
}
