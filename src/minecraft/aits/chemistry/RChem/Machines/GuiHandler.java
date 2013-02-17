package requimrar.Minecraft.RChem.Machines;

import requimrar.Minecraft.RChem.Machines.LabBench.ContainerLabBench;
import requimrar.Minecraft.RChem.Machines.LabBench.GuiLabBench;
import requimrar.Minecraft.RChem.Machines.LabBench.TileLabBench;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity te = world.getBlockTileEntity(x, y, z);
		
		if(te instanceof TileLabBench)
		{
			return new ContainerLabBench((TileLabBench)te, player.inventory);
		}
		
		return null;
	}
	
	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity te = world.getBlockTileEntity(x, y, z);
		
		if(te instanceof TileLabBench)
		{
			return new GuiLabBench(player.inventory, (TileLabBench)te);
		}
		return null;	
	}
}
