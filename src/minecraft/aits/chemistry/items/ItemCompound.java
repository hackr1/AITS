package aits.chemistry.items;

import static aits.chemistry.util.EnumClassificationList.Anion;
import static aits.chemistry.util.EnumClassificationList.Cation;
import static aits.chemistry.util.EnumClassificationList.Unknown;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import aits.chemistry.Chemistry;
import aits.chemistry.machines.ILabEquipment;
import aits.chemistry.util.Compound;
import aits.chemistry.util.EnumClassificationList;
import aits.chemistry.util.EnumCompoundList;
import aits.chemistry.util.RChemHelper;
import aits.chemistry.util.RadiationInfo;
import aits.core.common.CommonProxy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCompound extends ChemistryItem implements ILabEquipment
{
	private static final int StdRoomTemp	= 25;

	private static final char s = '\u00A7';

	public static EnumCompoundList[] CompoundList = EnumCompoundList.values();


	public ItemCompound(int id)
	{
		super(id);
		setMaxStackSize(64);
		setCreativeTab(Chemistry.ChemistryCreativeTab);
		setIconIndex(16);
		setItemName("RChem.Compound");


		setHasSubtypes(true);
	}

	@Override
	public String getItemDisplayName(ItemStack itemstack)
	{
		return(CompoundList[itemstack.getItemDamage()].GetFullName());
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
		return 16;
	}

	@Override
	public String getItemNameIS(ItemStack IS)
	{
		return CompoundList[IS.getItemDamage()].GetFullName();
	}

	public static String GetReadableCompoundName(EnumCompoundList compound)
	{
		String NewChemName = "";

		// Replace all numbers with their unicode equivalents.

		if(compound.IsElement())
			// cool tertiary operator; we don't want H2O1, but H2O.
			NewChemName = RChemHelper.ConvertToUnicode(GetReadableElementName(compound));

		else
			NewChemName = RChemHelper.ConvertToUnicode(compound.GetChemName());


		return NewChemName;
	}

	public static String GetReadableElementName(EnumCompoundList compound)
	{
		String unicode = "";

		String NewChemName = compound.GetChemName();

		if(!compound.IsElement())
			return "";

		if(compound.GetIsIsotope())
		{
			NewChemName = compound.GetChemName().substring(0, compound.GetChemName().indexOf('_', 0));

			// get the unicode for the isotope number (atomic weight)
			switch(compound.GetNeutronNumber() + compound.GetNeutronNumber())
			{
				case 1:
					unicode = "\u00B9";
					break;

				case 2:
					unicode = "\u00B2";
					break;

				case 3:
					unicode = "\u00B3";
					break;

				case 4:
					unicode = "\u2074";
					break;

				case 5:
					unicode = "\u2075";
					break;

				case 6:
					unicode = "\u2076";
					break;

				case 7:
					unicode = "\u2077";
					break;

				case 8:
					unicode = "\u2078";
					break;

				case 9:
					unicode = "\u2079";
					break;
			}
		}

		return unicode + NewChemName;
	}

	@Override
	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean b)
	{
		EnumCompoundList Compound = this.GetCompoundFromIS(is);

		String RoomState = GetStateInRoomTemp(Compound) != Unknown ? GetStateInRoomTemp(Compound).ClassDescription() : "Unknown";

		if(Compound.IsElement())
		{
			// No components, it's an element
			list.add(GetReadableCompoundName(Compound) + " - " + GetStateInRoomTemp(Compound).ClassDescription());
			list.add(s + "5" + Compound.GetClassification().ClassDescription() + s + "r");
			list.add(s + "9Protons: " + s + "r" + Compound.GetAtomicNumber());
			list.add(s + "6Neutrons: " + s + "r" + Compound.GetNeutronNumber());

			String colour;
			String HalfLife;

			NBTTagCompound Tag = is.getTagCompound();

			//		System.out.println(String.valueOf((RChem.ElementMetaItem.GetRadiationInfo(is, Minecraft.getMinecraft().theWorld)).HalfLife));


			if((ItemCompound.GetRadiationInfo(is, Minecraft.getMinecraft().theWorld)).HalfLife <= 0)
			{
				list.add(s + "aNot Radioactive" + s + "r");
				return;
			}

			long halflife = 0;

			if(Tag == null)
				halflife = Math.min((ItemCompound.GetRadiationInfo(is, Minecraft.getMinecraft().theWorld)).HalfLife, Compound.GetHalfLife());

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

		list.add(s + "6" + GetReadableCompoundName(Compound) + s + "r - " + s + "a" + RoomState + s + "r");
		list.add(s + "9" + Compound.GetClassification().ClassDescription() + s + "r");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack par1ItemStack)
	{
		return EnumRarity.rare;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(int ItemID, CreativeTabs tab, List ItemList)
	{
		// Length - 1 because of the unknown compound at the end.
		for (int i = 0; i < EnumCompoundList.values().length - 1; i++)
		{
			if(ItemCompound.GetCompoundFromIS(new ItemStack(ItemID, 1, i)).GetClassification() != Anion
							&& ItemCompound.GetCompoundFromIS(new ItemStack(ItemID, 1, i)).GetClassification() != Cation)
			{

				ItemList.add(new ItemStack(ItemID, 1, i));	// Add non ionic compounds
			}
		}
	}

	public static EnumClassificationList GetStateInRoomTemp(EnumCompoundList Compound)
	{
		if (Compound.GetBoilingPoint() == -300 || Compound.GetMeltingPoint() == -300)
		{
			return EnumClassificationList.Unknown;
		}

		if (Compound.GetBoilingPoint() < StdRoomTemp)
			return EnumClassificationList.Gas;

		else if (Compound.GetMeltingPoint() < StdRoomTemp)
			return EnumClassificationList.Liquid;

		else
			return EnumClassificationList.Solid;
	}

	public static EnumCompoundList GetCompoundFromIS(ItemStack itemstack)
	{
		return itemstack != null ? CompoundList[itemstack.getItemDamage()] : EnumCompoundList.UnknownC;
	}

	@Override
	public String getTextureFile()
	{
		return CommonProxy.EnumTextureList.ChemistryCompounds.GetPath();
	}


	@Override
	public boolean shouldRotateAroundWhenRendering()
	{
		return true;
	}

	public static RadiationInfo CalculateRadioactivity(EntityPlayer player, ItemStack element, World world)
	{
		EnumCompoundList Element = ItemCompound.GetCompoundFromIS(element);

		// Alpha:
		// 5 sec. poison
		// Health - 4

		// Beta:
		// 5min. poison
		// Health - 7

		// Gamma:
		// Wither 2, 20 minutes.
		// Posion 10 min.
		// Health - 10.
		// Sad life.

		RadiationInfo radinfo = new RadiationInfo();

		radinfo.PoisonTime = 0;
		radinfo.WitherTime = 0;
		radinfo.Damage = 0;
		radinfo.TimeOfLastRadUpdate = 0;

		switch(Element.GetRadiationState())
		{
			case Alpha:
				radinfo.PoisonTime = 5 * 20;
				radinfo.Damage = 4;
				player.attackEntityFrom(DamageSource.generic, radinfo.Damage);
				player.addPotionEffect(new PotionEffect(Potion.poison.getId(), radinfo.PoisonTime, 0));


				// TODO: may not be accurate.
				// TODO: also need to add a new helium atom to the output.
				// The damage is dealt, we need to affect the item now...
				// Alpha is 2 protons + 2 neutrons, so we deduct the damage accordingly.

				// H-He will never decay with alpha, so no checks are needed.
				// No point in simulating neutron release.

				element.setItemDamage(element.getItemDamage() - 2);

				break;

			case Beta:
				radinfo.PoisonTime = 5 * 60 * 20;
				radinfo.Damage = 7;
				player.attackEntityFrom(DamageSource.generic, radinfo.Damage);
				player.addPotionEffect(new PotionEffect(Potion.poison.getId(), radinfo.PoisonTime, 0));

				// TODO: fix.
				// beta is weird. Very weird. Until a general case can be made,
				// (ie we finish the rest of the elements), we will stick to a
				// switch-case method here.


				switch(ItemCompound.GetCompoundFromIS(element))
				{
					case H_3:
						element.setItemDamage(element.getItemDamage() + 1);
						break;

					default:
						break;
				}


				break;

			case Gamma:
				// TODO: may not follow laws of nuclear physics.
				radinfo.WitherTime = 20 * 60 * 20;
				radinfo.PoisonTime = 10 * 60 * 20;
				radinfo.Damage = 10;
				player.addPotionEffect(new PotionEffect(Potion.wither.getId(), radinfo.WitherTime, 1));
				player.addPotionEffect(new PotionEffect(Potion.poison.getId(), radinfo.PoisonTime, 1));
				player.attackEntityFrom(DamageSource.generic, radinfo.Damage);


				break;

			default:
				break;
		}


		NBTTagCompound tag = new NBTTagCompound();
		tag.setLong("LifeRemaining", ItemCompound.GetCompoundFromIS(element).GetHalfLife());
		element.setTagCompound(tag);


		radinfo.HalfLife = ItemCompound.GetCompoundFromIS(element).GetHalfLife();
		radinfo.itemstack = element;
		SetRadiationInfo(radinfo, element);

		return radinfo;
	}


	public static void SetRadiationInfo(RadiationInfo radinfo, ItemStack element)
	{
		NBTTagCompound Tag = element.getTagCompound();

		if(Tag == null)
			Tag = new NBTTagCompound();

		Tag.setLong("LifeRemaining", radinfo.HalfLife);
		element.setTagCompound(Tag);
	}




	public static RadiationInfo GetRadiationInfo(ItemStack element, World world)
	{
		NBTTagCompound Tag = element.getTagCompound();

		if(Tag == null)
		{
			long lastupdate = world.getTotalWorldTime();
			long life = ItemCompound.GetCompoundFromIS(element).GetHalfLife();
			RadiationInfo info = new RadiationInfo();

			info.HalfLife = life;
			info.TimeOfLastRadUpdate = 0;
			info.itemstack = element;


			if(life > 0)
				SetRadiationInfo(info, element);

			return info;
		}

		long life = Tag.getLong("LifeRemaining");
		RadiationInfo info = new RadiationInfo();

		info.TimeOfLastRadUpdate = 0;
		info.HalfLife = life;
		info.itemstack = element;

		if(life > 0)
			SetRadiationInfo(info, element);

		return info;
	}























	@Override
	public Compound GetChemicalInside(ItemStack itemstack)
	{
		Compound c = new Compound(ItemCompound.GetCompoundFromIS(itemstack));
		return c;
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
		return false;
	}
}
