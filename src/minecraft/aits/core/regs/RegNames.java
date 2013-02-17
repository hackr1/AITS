package aits.core.regs;

import net.minecraft.item.ItemStack;
import aits.chemistry.Chemistry;
import aits.chemistry.items.ItemCompound;
import aits.core.AITS;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class RegNames {

	public static void register(FMLInitializationEvent event) {
		LanguageRegistry.addName(RegItems.itemCoke, "Coke");
		// German localisation
		LanguageRegistry.instance().addNameForObject(RegItems.itemCoke, "de_DE",
						"Koks");
	}
}