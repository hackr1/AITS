package aits.chemistry.util;

import net.minecraft.item.ItemStack;
import aits.chemistry.items.ItemCompound;

public class RadiationInfo
{
	public long			TimeOfLastRadUpdate;
	public long			HalfLife;

	public int			PoisonTime;
	public int			WitherTime;
	public int			Damage;

	public ItemStack	itemstack;

	public boolean GetIsElementRadioactive()
	{
		return ItemCompound.GetCompoundFromIS(this.itemstack).GetHalfLife() > 0;
	}
}
