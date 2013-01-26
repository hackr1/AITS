package aits.core.regs;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegSmelting {

	public static void register(FMLInitializationEvent event) {

		GameRegistry.addSmelting(263, new ItemStack(RegItems.itemCoke, 1, 0), 0f);
	}
}