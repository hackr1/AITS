package requimrar.Minecraft.RChem.Item;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;

import requimrar.Minecraft.RChem.RChemCommonProxy;
import requimrar.Minecraft.RChem.RadiationInfo;
import requimrar.Minecraft.RChem.RChemMod;

import net.minecraft.src.*;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import static requimrar.Minecraft.RChem.EnumCompoundList.*;
import static requimrar.Minecraft.RChem.EnumClassificationList.*;


public class RadioactiveDecayHandler
{

	protected class I_ItemRadiationEvent
	{
		public ItemStack Input;
		public ItemStack Output;

		public int DamageDealt;
	}



	static RadioactiveDecayHandler instance = new RadioactiveDecayHandler();

	public static RadioactiveDecayHandler GetInstance()
	{
		return instance;
	}

	public void UpdateRadiation(EntityPlayer player)
	{
		Container CurrentContainer = player.openContainer;

		if(CurrentContainer != null)
			UpdateItemsInContainer(player, CurrentContainer, CurrentContainer.getInventory());

		else
			UpdateItemsInContainer(player, player.inventoryContainer, player.inventoryContainer.getInventory());
	}

	private void UpdateItemsInContainer(EntityPlayer player, Container CurrentContainer, List<ItemStack> itemstacks)
	{
		//		List<I_ItemRadiationEvent> RadEvents = new ArrayList();

		for(ItemStack is : itemstacks)
		{
			if(is != null && is.itemID == RChemMod.CompoundMetaItem.itemID && ItemCompound.GetCompoundFromIS(is).GetRadiationState() != Stable &&
							ItemCompound.GetCompoundFromIS(is).GetHalfLife() > 0)
			{
				//				I_ItemRadiationEvent revent = new I_ItemRadiationEvent();
				int DamageDealt = UpdateItemRadiation(player, is);

				//				revent.Input = is.copy();
				//				revent.Output = is.copy();
			}
		}
	}

	private int UpdateItemRadiation(EntityPlayer player, ItemStack element)
	{
		RadiationInfo radinfo = ItemCompound.GetRadiationInfo(element, Minecraft.getMinecraft().theWorld);

		long CurrentTime = Minecraft.getMinecraft().theWorld.getTotalWorldTime();
		return ReduceHalfLife(player, element, CurrentTime, radinfo, Minecraft.getMinecraft().theWorld);
	}

	private int ReduceHalfLife(EntityPlayer player, ItemStack element, long CurrentTime, RadiationInfo radinfo, World world)
	{
		int Damage = 0;

		if(radinfo.GetIsElementRadioactive() && radinfo.HalfLife > 0)
		{
			//			long LifeDeduction = TimeDiff;/* Math.min(TimeDiff, radinfo.HalfLife); */

			//			radinfo.HalfLife -= LifeDeduction;
			radinfo.HalfLife -= 10;

			if(radinfo.HalfLife <= 0)
			{
				// Boom
				int dmg = radinfo.Damage;
				Damage = Math.max(Damage, dmg);

				// Will also deal effects.
				radinfo = ItemCompound.CalculateRadioactivity(player, element, world);
			}
		}

		RChemMod.CompoundMetaItem.SetRadiationInfo(radinfo, element);
		return Damage;
	}

}
