package aits.core;

import aits.core.regs.RegBlocks;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;

public class EventLisiner 
{
	@ForgeSubscribe
	public void rightclick(PlayerInteractEvent var1)
	{
		if(var1.action == Action.RIGHT_CLICK_BLOCK && !var1.entityPlayer.isSneaking())
		{
			if(var1.entityPlayer.worldObj.getBlockId(var1.x, var1.y, var1.z) == Block.cobblestone.blockID)
			{
				Integer[] place = this.getCloses(var1.entityPlayer.worldObj, var1.x, var1.y, var1.z);
				if(place[0] != 100 && place[1] != 500 && place[2] != 100)
				{
					World w = var1.entityPlayer.worldObj;
					int x = place[0];
					int y = place[1];
					int z = place[2];
					
					if(!var1.entityPlayer.worldObj.isRemote && w.getBlockId(x, y - 2, z) == Block.cobblestone.blockID && 
							//Bottom Row
							w.getBlockId(x + 1, y - 2, z + 1) == Block.cobblestone.blockID && 	
							w.getBlockId(x, y - 2, z + 1) == Block.cobblestone.blockID && 
							w.getBlockId(x - 1, y - 2, z + 1) == Block.cobblestone.blockID && 
							w.getBlockId(x - 1, y - 2, z) == Block.cobblestone.blockID && 
							w.getBlockId(x - 1, y - 2, z - 1) == Block.cobblestone.blockID && 
							w.getBlockId(x + 1, y - 2, z) == Block.cobblestone.blockID && 
							w.getBlockId(x + 1, y - 2, z - 1) == Block.cobblestone.blockID && 
							w.getBlockId(x, y - 2, z - 1) == Block.cobblestone.blockID && 
							
							//2 second row up
									w.getBlockId(x + 1, y, z + 1) == Block.cobblestone.blockID && 	
									w.getBlockId(x, y, z + 1) == Block.cobblestone.blockID && 
									w.getBlockId(x - 1, y, z + 1) == Block.cobblestone.blockID && 
									w.getBlockId(x - 1, y, z) == Block.cobblestone.blockID && 
									w.getBlockId(x - 1, y, z - 1) == Block.cobblestone.blockID && 
									w.getBlockId(x + 1, y, z) == Block.cobblestone.blockID && 
									w.getBlockId(x + 1, y, z - 1) == Block.cobblestone.blockID && 
									w.getBlockId(x, y, z - 1) == Block.cobblestone.blockID && 
									
									//Top row
									w.getBlockId(x + 1, y + 1, z + 1) == Block.cobblestone.blockID && 	
									w.getBlockId(x, y + 1, z + 1) == Block.cobblestone.blockID && 
									w.getBlockId(x - 1, y + 1, z + 1) == Block.cobblestone.blockID && 
									w.getBlockId(x - 1, y + 1, z) == Block.cobblestone.blockID && 
									w.getBlockId(x - 1, y + 1, z - 1) == Block.cobblestone.blockID && 
									w.getBlockId(x + 1, y + 1, z) == Block.cobblestone.blockID && 
									w.getBlockId(x + 1, y + 1, z - 1) == Block.cobblestone.blockID && 
									w.getBlockId(x, y + 1, z - 1) == Block.cobblestone.blockID &&

									w.getBlockId(x - 1, y - 1, z - 1) == Block.cobblestone.blockID &&
									w.getBlockId(x + 1, y - 1, z + 1) == Block.cobblestone.blockID &&
									w.getBlockId(x + 1, y - 1, z - 1) == Block.cobblestone.blockID &&
									w.getBlockId(x - 1, y - 1, z + 1) == Block.cobblestone.blockID 
							
							
							
							
							)
					{
							var1.entityPlayer.openGui(AITS.instance, 0, var1.entityPlayer.worldObj, x, y, z);
						var1.setCanceled(true);
						var1.entityPlayer.swingItem();
					}
				}
			}
		}
	}
	
	public Integer[] getCloses(World par1World, int par2, int par3, int par4)
	{
		for(int var1 = -1; var1 <= 1; ++ var1)
		{
			for(int var2 = -1; var2 <= 1; ++ var2)
			{
				for(int var3 = -2; var3 <= 2; ++ var3)
				{
					if(par1World.getBlockId(par2 + var1, par3 + var3, par4 + var2) == RegBlocks.bloomeryGrate.blockID)
					{
						return new Integer[] {par2 + var1, par3 + var3, par4 + var2};
					}
				}
			}
		}
		
		return new Integer[] {100, 500, 100};
	}
}
