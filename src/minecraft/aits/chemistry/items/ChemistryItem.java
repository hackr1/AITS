package aits.chemistry.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import aits.chemistry.Chemistry;
import aits.chemistry.machines.ILabEquipment;

public abstract class ChemistryItem extends Item implements ILabEquipment
{
	public ChemistryItem(int id)
	{
		super(id);

		setMaxStackSize(64);
		setCreativeTab(Chemistry.ChemistryCreativeTab);
		setIconIndex(0);
		setItemName("RChemGenericItem");
	}
}
