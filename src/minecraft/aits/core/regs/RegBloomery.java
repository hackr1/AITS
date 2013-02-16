package aits.core.regs;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import aits.core.blocks.*;
import aits.core.items.*;
import aits.core.recipes.BloomeryRecipes;
import aits.geology.blocks.*;
import aits.geology.items.*;
import aits.chemistry.blocks.*;
import net.minecraft.block.*;
import net.minecraft.item.*;

public class RegBloomery {

	public static void register(FMLInitializationEvent event) {
		//Add Bloomery recipes like this:
		BloomeryRecipes.add(Block.stone.getClass(), new ItemStack(Item.clay, 4));
		//This would give you 4 clay when putting 1 stone into the bloomery.
		
	}
}