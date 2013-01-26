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

	public static Item	itemCoke = new ItemCoke(RegConfig.ItemIDRange + 0);

	public static void register(FMLInitializationEvent event) {
		GameRegistry.registerItem(itemCoke,itemCoke.getItemName());
	}


}
