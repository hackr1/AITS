package aits.geology.items;

import static aits.chemistry.util.EnumClassificationList.Anion;
import static aits.chemistry.util.EnumClassificationList.Cation;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import aits.chemistry.Chemistry;
import aits.chemistry.items.ItemCompound;
import aits.chemistry.util.EnumCompoundList;
import aits.core.AITS;
import aits.core.common.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemMultiRock extends Item
{
	private final EnumItemName[] EnumItemNames = EnumItemName.values();
	private enum EnumItemName
	{
		SlateRockRacloir			("Slate Rock"),
		LimestoneRockRacloir		("Limestone Rock"),
		BasaltRockRacloir			("Basalt Rock"),
		GraniteRockRacloir			("Granite Rock"),
		PinkGraniteRockRacloir		("Pink Granite Rock"),
		MarbleRockRacloir			("Marble Rock"),
		QuartziteRockRacloir		("Quartzite Rock");

		/**
		 * Name of the item as a rock: ie. Slate Rock
		 */
		public final String RockName;

		/**
		 * Name of the item as a sharp rock: ie. Sharp Slate Rock
		 */
		public final String ShardName;

		/**
		 * Name of the item as racloir: ie. Slate Rock Racloir
		 */
		public final String RacloirName;

		private EnumItemName(String Name)
		{
			this.RockName = Name;
			this.ShardName = "Sharp " + Name;
			this.RacloirName = Name + " Racloir";
		}
	}


	public ItemMultiRock(int ID)
	{
		super(ID);
		setCreativeTab(AITS.tabAITS);
		setMaxStackSize(64);
		setIconIndex(0);

		setItemName("AITS.ItemMultiRock");
		setHasSubtypes(true);
	}


	@Override
	public String getItemDisplayName(ItemStack itemstack)
	{
		if(itemstack.getItemDamage() < 7)
			return EnumItemNames[itemstack.getItemDamage()].RockName;

		else if(itemstack.getItemDamage() < 14 && itemstack.getItemDamage() >= 7)
			return EnumItemNames[itemstack.getItemDamage() - 7].ShardName;

		else
			return EnumItemNames[itemstack.getItemDamage() - 14].RacloirName;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(int ItemID, CreativeTabs tab, List ItemList)
	{
		for (int i = 0; i < 21; i++)
		{
			ItemList.add(new ItemStack(ItemID, 1, i));
		}
	}

	@Override
	public String getTextureFile()
	{
		return CommonProxy.EnumTextureList.RockItems.GetPath();
	}

	@Override
	public int getMetadata(int par1)
	{
		return par1;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getIconFromDamage(int i)
	{
		if(i >= 14)
			return 32 + (i - 14);

		else if(i >= 7)
			return 16 + (i - 7);

		else
			return i;
	}

	@Override
	public String getItemNameIS(ItemStack itemstack)
	{
		if(itemstack.getItemDamage() < 7)
			return EnumItemNames[itemstack.getItemDamage()].RockName;

		else if(itemstack.getItemDamage() < 14 && itemstack.getItemDamage() >= 7)
			return EnumItemNames[itemstack.getItemDamage() - 7].ShardName;

		else
			return EnumItemNames[itemstack.getItemDamage() - 14].RacloirName;
	}
}
