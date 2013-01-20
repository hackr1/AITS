package aits.core;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class tabCreativeAITS extends net.minecraft.creativetab.CreativeTabs {

	public tabCreativeAITS(int par1, String par2Str) {
		super(par1, par2Str);
	}

	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex() {
		return (new ItemStack(Item.appleGold, 1, 1)).itemID;
	}

	public String getTranslatedTabLabel() {
		return "Corrupting Diamonds";
	}
}