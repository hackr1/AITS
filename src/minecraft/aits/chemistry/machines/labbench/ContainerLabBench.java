package aits.chemistry.machines.labbench;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerLabBench extends Container
{
	protected TileLabBench ThisLabBench;


	public ContainerLabBench(InventoryPlayer playerinv, TileLabBench te)
	{
		this.ThisLabBench = te;


		int i = 0;
		for (int y = 0; y < 9; y++)
		{
			for (int x = 0; x < 12; x++)
			{
				addSlotToContainer(new Slot(te, i, x * 18 - 18, y * 18 - 37));
				i++;
			}
		}

		for (int hotbarSlot = 0; hotbarSlot < 9; hotbarSlot++)
		{
			addSlotToContainer(new Slot(playerinv, hotbarSlot, 9 + hotbarSlot * 18, 256 - 69));
		}

		for (int playerInvRow = 0; playerInvRow < 3; playerInvRow++)
		{
			for (int playerInvCol = 0; playerInvCol < 9; playerInvCol++)
			{
				addSlotToContainer(new Slot(playerinv, playerInvCol + playerInvRow * 9 + 9, 9 + playerInvCol * 18, 256 - (4 - playerInvRow) * 18
								- 55));
			}
		}


	}

	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return ThisLabBench.isUseableByPlayer(player);
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer p, int i)
	{
		ItemStack itemstack = null;
		Slot slot = (Slot)inventorySlots.get(i);
		if (slot != null && slot.getHasStack())
		{
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			if (i < 108)
			{
				if (!mergeItemStack(itemstack1, 108, this.inventorySlots.size(), false))
				{
					return null;
				}
			}
			else
				return null;
			//			else if (!mergeItemStack(itemstack1, 0, 108, false))
			//			{
			//				return null;
			//			}


			if (itemstack1.stackSize == 0)
			{
				slot.putStack(null);
			}
			else
			{
				slot.onSlotChanged();
			}

			if(itemstack1.stackSize == itemstack.stackSize)
			{
				return null;
			}

			slot.onPickupFromSlot(p, itemstack1);
		}
		return itemstack;
	}



}
