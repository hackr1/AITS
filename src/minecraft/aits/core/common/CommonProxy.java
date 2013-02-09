package aits.core.common;

import aits.core.client.gui.GuiBloomery;
import aits.core.container.ContainerBloomery;
import aits.core.tileentity.TileEntityBloomery;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler {
	public static String ITEMS_PNG = "/aits/textures/metals.png";
	public static String BLOCK_PNG = "/aits/textures/blocks.png";
	public static String CHEMISTRY_BLOCK_PNG = "/aits/textures/chemistry/blocks.png";
	public static String CHEMISTRY_ITEM_PNG = "/aits/textures/chemistry/items.png";
	public static String GEOLOGY_BLOCK_PNG = "/aits/textures/geology/blocks.png";
	public void registerRenderers() {
		// Nothing here as the server doesn't render graphics!
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		if(ID == 0)
		{
			TileEntityBloomery var1 = (TileEntityBloomery)world.getBlockTileEntity(x, y, z);
			return new ContainerBloomery(player.inventory, var1);
		}
		else
		{
			return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		if(ID == 0)
		{
			TileEntityBloomery var1 = (TileEntityBloomery)world.getBlockTileEntity(x, y, z);
			return new GuiBloomery(player.inventory, var1);
		}
		else
		{
			return null;
		}
	}
}