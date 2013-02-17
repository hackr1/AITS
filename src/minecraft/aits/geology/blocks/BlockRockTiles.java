package aits.geology.blocks;

import aits.core.common.CommonProxy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class BlockRockTiles extends Block
{
	/** The type of tree this block came from. */
	public static final String[] brickType = new String[] {"oak", "spruce", "birch", "jungle", "1", "2", "3"};

	public BlockRockTiles(int par1)
	{
		super(par1, 4, Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(1.5F);
		this.setResistance(10.0F);
		this.setStepSound(soundStoneFootstep);
		this.setBlockName("rockTiles");
		this.setTextureFile(CommonProxy.EnumTextureList.CoreBlocks.GetPath());
	}

	/**
	 * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
	 */
	@Override
	public int getBlockTextureFromSideAndMetadata(int par1, int par2)
	{
		switch (par2)
		{
			case 1:
				// return 65;
				return 65;
			case 2:
				//  return 66;
				return 66;
			case 3:
				//  return 67;
				return 67;
			case 4:
				// return 68;
				return 68;
			case 5:
				//  return 69;
				return 69;
			case 6:
				//   return 70;
				return 70;
			default:
				//return 64;
				return 64;
		}
	}

	/**
	 * Determines the damage on the item the block drops. Used in cloth and wood.
	 */
	@Override
	public int damageDropped(int par1)
	{
		return par1;
	}

	@Override
	@SideOnly(Side.CLIENT)

	/**
	 * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
	 */
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		par3List.add(new ItemStack(par1, 1, 0));
		par3List.add(new ItemStack(par1, 1, 1));
		par3List.add(new ItemStack(par1, 1, 2));
		par3List.add(new ItemStack(par1, 1, 3));
		par3List.add(new ItemStack(par1, 1, 4));
		par3List.add(new ItemStack(par1, 1, 5));
		par3List.add(new ItemStack(par1, 1, 6));
	}
}
