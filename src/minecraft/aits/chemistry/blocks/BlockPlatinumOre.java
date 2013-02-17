package aits.chemistry.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import aits.core.common.*;
import aits.core.*;
import aits.chemistry.*;
import aits.chemistry.blocks.*;

public class BlockPlatinumOre extends Block {

	public BlockPlatinumOre(int id, int texture)
	{
		super(id, texture, Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(3.0f);
	}

	@Override
	public String getTextureFile()
	{
		return CommonProxy.EnumTextureList.ChemistryBlocks.GetPath();
	}


}
