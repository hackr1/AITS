package aits.core.items;

import aits.core.AITS;
import net.minecraft.item.ItemStack;

/**
 * 
 * @author Adanaran
 */
public class ItemCoke extends AITSItemBase {

	public ItemCoke(int id) {
		super(id);
		setIconIndex(0).setItemName("Coke").setMaxStackSize(64);
	}
}
