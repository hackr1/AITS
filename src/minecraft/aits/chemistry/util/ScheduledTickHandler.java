package aits.chemistry.util;

import java.util.EnumSet;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import aits.chemistry.items.RadioactiveDecayHandler;
import aits.chemistry.machines.labbench.LBReactionHelper;
import aits.chemistry.machines.labbench.TileLabBench;
import cpw.mods.fml.common.IScheduledTickHandler;
import cpw.mods.fml.common.TickType;

public class ScheduledTickHandler implements IScheduledTickHandler
{

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData)
	{
		EntityPlayer entityPlayer = (EntityPlayer) tickData[0];
		World world = entityPlayer.worldObj;
		RadioactiveDecayHandler.GetInstance().UpdateRadiation(entityPlayer);

		// Also used for reacting things in benchs
		// Do it at the end, to distribute load.
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData)
	{
		for (TileLabBench t : RChemHelper.LabBenches)
			LBReactionHelper.ReactLabBench(t.GetInventory(), t);

	}

	@Override
	public EnumSet<TickType> ticks()
	{
		return EnumSet.of(TickType.PLAYER);
	}

	@Override
	public String getLabel()
	{
		return "ChemistryScheduledTickHandler";
	}

	@Override
	public int nextTickSpacing()
	{
		// we don't want to hog the system; twice per second.
		return 10;
	}

}
