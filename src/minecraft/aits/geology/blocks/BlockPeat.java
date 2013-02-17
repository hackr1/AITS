package aits.geology.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import aits.core.common.*;
import aits.core.*;
import aits.chemistry.*;
import aits.chemistry.blocks.*;

public class BlockPeat extends Block {
	public BlockPeat(int id, int texture)
	{
		super(id, texture, Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(2.5f);
	}
	
	public String getTextureFile()
	{
            return CommonProxy.BLOCK_PNG;
	}
	
	//public int idDropped(int par1, Random random, int zero) {
	//TODO add item drop specifications to chemistry ores	
	//}

}
