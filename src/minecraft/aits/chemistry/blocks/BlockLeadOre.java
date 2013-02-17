package aits.chemistry.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import aits.core.common.*;
import aits.core.*;
import aits.chemistry.*;
import aits.chemistry.blocks.*;

public class BlockLeadOre extends Block {

	public BlockLeadOre(int id, int texture)
	{
		super(id, texture, Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(2.6f);
	}

	@Override
	public String getTextureFile()
	{
		return CommonProxy.EnumTextureList.ChemistryBlocks.GetPath();
	}

}
