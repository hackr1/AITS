package aits.core.regs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import aits.core.AITS;
import aits.core.items.ItemCoke;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class RegItems {

	public static int idCoke = 3000;// needs to changed to a configurable value

	public static void register(FMLInitializationEvent event) {
		registerCoke();
	}

	private static void registerCoke() {
		AITS.itemCoke = new ItemCoke(idCoke);
		LanguageRegistry.addName(AITS.itemCoke, "Coke");
		GameRegistry.registerItem(AITS.itemCoke, AITS.itemCoke.getItemName());
		GameRegistry.addSmelting(263, new ItemStack(AITS.itemCoke, 1, 0), 0f);
		// German localisation
		LanguageRegistry.instance().addNameForObject(AITS.itemCoke, "de_DE",
				"Koks");
	}
}
