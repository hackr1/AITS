package requimrar.Minecraft.RChem.Item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import requimrar.Minecraft.RChem.Compound;
import requimrar.Minecraft.RChem.RChemMod;
import requimrar.Minecraft.RChem.Machines.ILabEquipment;

public abstract class RChemItem extends Item implements ILabEquipment
{
	public RChemItem(int id)
	{
		super(id);

		setMaxStackSize(64);
		setCreativeTab(RChemMod.RChemCTab);
		setIconIndex(0);
		setItemName("RChemGenericItem");
	}

	@Override
	public abstract Compound GetChemicalInside(ItemStack itemstack);

	@Override
	public abstract boolean CanConnectOnLeft();

	@Override
	public abstract boolean CanConnectOnTop();

	@Override
	public abstract boolean CanConnectOnRight();

	@Override
	public abstract boolean CanConnectOnBottom();

	@Override
	public abstract int GetTemperatureDifference();

	@Override
	public abstract boolean CanCollectChemicals();
}
