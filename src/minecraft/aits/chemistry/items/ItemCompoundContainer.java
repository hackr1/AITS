package aits.chemistry.items;

import static aits.chemistry.util.EnumClassificationList.Unknown;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import aits.chemistry.Chemistry;
import aits.chemistry.util.Compound;
import aits.chemistry.util.EnumCompoundList;

public class ItemCompoundContainer extends ItemCompound
{

	public ItemCompoundContainer(int id)
	{
		super(id);
		setMaxStackSize(1);
		setCreativeTab(Chemistry.ChemistryCreativeTab);
		setIconIndex(16);
		setItemName("RChem.CompoundContainer");
	}

	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean b)
	{
		EnumCompoundList Compound = this.GetCompoundFromIS(itemstack);
		NBTTagCompound Tag = itemstack.getTagCompound();
		String RoomState = GetStateInRoomTemp(Compound) != Unknown ? GetStateInRoomTemp(Compound).ClassDescription() : "Unknown";

		list.add(s + "7Container: ");

		if(Compound.IsElement())
		{
			// No components, it's an element
			list.add(GetReadableCompoundName(Compound) + " - " + GetStateInRoomTemp(Compound).ClassDescription());
			list.add(s + "5" + Compound.GetClassification().ClassDescription() + s + "r");
			list.add(s + "9Protons: " + s + "r" + Compound.GetAtomicNumber());
			list.add(s + "6Neutrons: " + s + "r" + Compound.GetNeutronNumber());
		}
		else
		{
			list.add(s + "6" + GetReadableCompoundName(Compound) + s + "r - " + s + "a" + RoomState + s + "r");
			list.add(s + "9" + Compound.GetClassification().ClassDescription() + s + "r");
		}



		if((ItemCompound.GetRadiationInfo(itemstack, Minecraft.getMinecraft().theWorld)).HalfLife < 0)
		{
			list.add(s + "aNot Radioactive" + s + "r");
			return;
		}
		else
		{
			String colour;
			String HalfLife;

			long halflife = 0;

			if(Tag == null)
				halflife = Math.min((ItemCompound.GetRadiationInfo(itemstack, Minecraft.getMinecraft().theWorld)).HalfLife, Compound.GetHalfLife());

			else
				halflife = Tag.getLong("LifeRemaining");


			// required to display values in creative inventory

			if(halflife / 20 >= 2592000)
				colour = s + "3";

			// 10 days
			else if(halflife / 20 >= 864000)
				colour = s + "e";

			// 1 day
			else if(halflife / 20 >= 864000)
				colour = s + "d";

			// 1 hour
			else if(halflife / 20 >= 3600)
				colour = s + "c";

			// 1 minute
			else if(halflife / 20 >= 60)
				colour = s + "5";

			// <1 minute
			else
				colour = s + "4";



			// TODO: Convert seconds to days/hours/minutes
			list.add("Half-life: " + colour + String.valueOf(halflife / 20) + " seconds" + s + "r");
			return;
		}
	}













	@Override
	public Compound GetChemicalInside(ItemStack itemstack)
	{
		return new Compound(ItemCompound.GetCompoundFromIS(itemstack));
	}

	@Override
	public boolean CanConnectOnLeft()
	{
		return false;
	}

	@Override
	public boolean CanConnectOnTop()
	{
		return true;
	}

	@Override
	public boolean CanConnectOnRight()
	{
		return false;
	}

	@Override
	public boolean CanConnectOnBottom()
	{
		return true;
	}

	@Override
	public int GetTemperatureDifference()
	{
		return 0;
	}

	@Override
	public boolean CanCollectChemicals()
	{
		return true;
	}

}
