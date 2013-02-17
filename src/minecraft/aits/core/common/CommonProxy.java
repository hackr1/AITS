package aits.core.common;

import aits.chemistry.Chemistry;
import aits.chemistry.client.renderer.ItemCompoundRenderer;
import aits.chemistry.machines.labbench.ContainerLabBench;
import aits.chemistry.machines.labbench.GuiLabBench;
import aits.chemistry.machines.labbench.TileLabBench;
import aits.core.client.gui.GuiBloomery;
import aits.core.container.ContainerBloomery;
import aits.core.tileentity.TileEntityBloomery;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler
{
	public static enum EnumTextureList
	{
		CoreItems					("/aits/textures/metals.png"),
		CoreBlocks					("/aits/textures/rocks.png"),

		ChemistryBlocks				("/aits/textures/chemistry/blocks.png"),
		ChemistryItems				("/aits/textures/chemistry/items.png"),
		ChemistryCompounds			("/aits/textures/chemistry/CompoundSpriteSheet.png"),
		ChemistryLabBench			("/aits/textures/chemistry/LabBenchGUI.png");


		private final String path;

		EnumTextureList(String path)
		{
			this.path = path;
		}

		public String GetPath()
		{
			return this.path;
		}
	}

	public static EnumTextureList[] GetTextureList()
	{
		return EnumTextureList.values();
	}

	public void registerRenderers() {
		// Nothing here as the server doesn't render graphics!
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
					int x, int y, int z)
	{
		TileEntity te = world.getBlockTileEntity(x, y, z);


		if(te instanceof TileEntityBloomery)
			return new ContainerBloomery(player.inventory, (TileEntityBloomery)te);

		else if(te instanceof TileLabBench)
			return new ContainerLabBench(player.inventory, (TileLabBench)te);

		else
			return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
					int x, int y, int z)
	{
		TileEntity te = world.getBlockTileEntity(x, y, z);

		if(te instanceof TileEntityBloomery)
			return new GuiBloomery(player.inventory, (TileEntityBloomery)te);

		else if(te instanceof TileLabBench)
			return new GuiLabBench(player.inventory, (TileLabBench)te);

		else
			return null;
	}
}