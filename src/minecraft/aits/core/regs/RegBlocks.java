package aits.core.regs;

import aits.core.blocks.AITSBlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegBlocks {
public static Block bloomeryGrate = new AITSBlockBase(RegConfig.BlockIDRange + 0, 0, Material.iron);
	public static void register(FMLInitializationEvent event) {
		GameRegistry.registerBlock(bloomeryGrate);
	}
}
