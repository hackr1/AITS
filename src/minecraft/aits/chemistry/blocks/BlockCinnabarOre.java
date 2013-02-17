package aits.chemistry.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import aits.core.common.*;
import aits.core.*;
import aits.chemistry.*;
import aits.chemistry.blocks.*;

public class BlockCinnabarOre extends Block {
	public BlockCinnabarOre(int id, int texture)
	{
		super(id, texture, Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(2.5f);
	}

	@Override
	public String getTextureFile()
	{
		return CommonProxy.EnumTextureList.ChemistryBlocks.GetPath();
	}

	//public int idDropped(int par1, Random random, int zero) {
	//TODO add item drop specifications to chemistry ores
	//}

}
