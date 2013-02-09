package aits.core.blocks;

import java.util.Random;

import aits.core.AITS;
import aits.core.regs.RegBlocks;
import aits.core.tileentity.TileEntityBloomery;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.world.World;

public class AITSBlockBloomery extends BlockContainer
{
	public AITSBlockBloomery(int par1, Material par2Material)
	{
		super(par1, par2Material);
	}
	@Override
	public TileEntity createNewTileEntity(World var1) 
	{
		return new TileEntityBloomery();
	}

}
