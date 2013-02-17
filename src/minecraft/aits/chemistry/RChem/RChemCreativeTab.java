package requimrar.Minecraft.RChem;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class RChemCreativeTab extends CreativeTabs
{

	public RChemCreativeTab(String label)
	{
		super(label);

	}

	@Override
	public ItemStack getIconItemStack()
	{
		return new ItemStack(RChemMod.CompoundMetaItem, 1, EnumCompoundList.Xe.ordinal());
	}

}
