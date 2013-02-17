package aits.chemistry.machines.labbench;

import java.util.Random;

import aits.chemistry.Chemistry;
import aits.core.AITS;
import aits.core.common.CommonProxy;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockLabBench extends BlockContainer
{
	public BlockLabBench(int BlockID)
	{
		super(BlockID, 1, Material.iron);
		setBlockName("RChemBlockLabBench");
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g, float t)
	{
		TileEntity te = world.getBlockTileEntity(x, y, z);

		if(te == null || player.isSneaking())
		{
			// Don't do anything here.
			return false;
		}

		player.openGui(AITS.instance, 0, world, x, y, z);
		return true;
	}


	@Override
	public void breakBlock(World world, int x, int y, int z, int i, int j)
	{
		DropItems(world, x, y, z);
		super.breakBlock(world, x, y, z, i, j);
	}

	private void DropItems(World world, int x, int y, int z)
	{
		Random rand = new Random();
		TileEntity te = world.getBlockTileEntity(x, y, z);

		if(!(te instanceof IInventory))
		{
			return;
		}

		IInventory inv = (IInventory)te;

		for(int i = 0; i < inv.getSizeInventory(); i++)
		{
			ItemStack item = inv.getStackInSlot(i);

			if(item != null && item.stackSize > 0)
			{
				float rx = rand.nextFloat() * 0.8F + 0.1F;
				float ry = rand.nextFloat() * 0.8F + 0.1F;
				float rz = rand.nextFloat() * 0.8F + 0.1F;

				EntityItem ei = new EntityItem(world, x + rx, y + ry, z + rz, new ItemStack(item.itemID, item.stackSize, item.getItemDamage()));

				if(item.hasTagCompound())
				{
					// TODO:
					// Fix when field names come out.
					ei.getEntityItem().setTagCompound((NBTTagCompound)item.getTagCompound().copy());
				}

				float factor = 0.5F;

				ei.motionX = rand.nextGaussian() * factor;
				ei.motionY = rand.nextGaussian() * factor + 0.2F;
				ei.motionZ = rand.nextGaussian() * factor;

				world.spawnEntityInWorld(ei);
				item.stackSize = 0;
			}
		}
	}

	@Override
	public String getTextureFile()
	{
		return CommonProxy.EnumTextureList.ChemistryBlocks.GetPath();
	}

	@Override
	public TileEntity createNewTileEntity(World world)
	{
		return new TileLabBench();
	}

}
