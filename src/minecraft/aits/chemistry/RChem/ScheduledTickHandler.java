package requimrar.Minecraft.RChem;

import java.util.EnumSet;

import requimrar.Minecraft.RChem.Item.RadioactiveDecayHandler;
import requimrar.Minecraft.RChem.Machines.LBReactionHelper;
import requimrar.Minecraft.RChem.Machines.LabBench.TileLabBench;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import cpw.mods.fml.common.IScheduledTickHandler;
import cpw.mods.fml.common.TickType;

public class ScheduledTickHandler implements IScheduledTickHandler
{

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData)
	{
		EntityPlayer entityPlayer = (EntityPlayer)tickData[0];
		World world = entityPlayer.worldObj;
		RadioactiveDecayHandler.GetInstance().UpdateRadiation(entityPlayer);

		// Also used for reacting things in benchs
		// Do it at the end, to distribute load.
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData)
	{
		for(TileLabBench t : RChemHelper.LabBenches)
		{
			LBReactionHelper.ReactLabBench(t.GetInventory(), t);
		}

	}

	@Override
	public EnumSet<TickType> ticks()
	{
		return EnumSet.of(TickType.PLAYER);
	}

	@Override
	public String getLabel()
	{
		return "RChemScheduledTickHandler";
	}

	@Override
	public int nextTickSpacing()
	{
		// we don't want to hog the system; twice per second.
		return 10;
	}

}
