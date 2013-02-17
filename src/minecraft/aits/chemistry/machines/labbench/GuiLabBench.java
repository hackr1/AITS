package aits.chemistry.machines.labbench;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import org.lwjgl.opengl.GL11;

import aits.core.common.CommonProxy;
import net.minecraft.src.*;
import net.minecraft.util.StatCollector;

public class GuiLabBench extends GuiContainer
{
	private final int SizeX;
	private final int SizeY;

	public int xSize;
	public int ySize;


	public int guiLeft;
	public int guiTop;

	public GuiLabBench(InventoryPlayer playerinv, TileLabBench tileentity)
	{
		super(new ContainerLabBench(playerinv, tileentity));
		SizeX = 236;
		SizeY = 256;

		ySize = SizeY;
		xSize = SizeX;
	}


	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j)
	{
		//		fontRenderer.drawString("Lab Bench", 6, 6, 0xFFFFFF);
		//		fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 6, ySize - 96 + 2, 0xFFFFFF);
	}



	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
		int background = mc.renderEngine.getTexture(CommonProxy.EnumTextureList.ChemistryLabBench.GetPath());
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

		this.mc.renderEngine.bindTexture(background);

		int x = (width - SizeX) / 2;
		int y = (height - SizeY) / 2;

		this.drawTexturedModalRect(x, y, 0, 0, SizeX, SizeY);

	}
}







