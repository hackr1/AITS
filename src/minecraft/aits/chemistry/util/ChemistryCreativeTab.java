package aits.chemistry.util;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import aits.chemistry.Chemistry;

public class ChemistryCreativeTab extends CreativeTabs
{

	public ChemistryCreativeTab(String label)
	{
		super(label);

	}

	@Override
	public ItemStack getIconItemStack()
	{
		return new ItemStack(Chemistry.CompoundMetaItem, 1, EnumCompoundList.Xe.ordinal());
	}

}
