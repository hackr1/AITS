package aits.geology.items;

import aits.geology.Geology;
import aits.geology.blocks.BlockBricks;
import aits.geology.blocks.BlockRockTiles;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class BlockMultiRockTiles extends ItemBlock
{
    private final Block theBlock = Geology.tileMulti;
    private final String[] names = BlockRockTiles.brickType;

    public BlockMultiRockTiles(int par1)
    {
        super(par1);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @SideOnly(Side.CLIENT)

    /**
     * Gets an icon index based on an item's damage value
     */
    public int getIconFromDamage(int par1)
    {
        return this.theBlock.getBlockTextureFromSideAndMetadata(2, par1);
    }

    /**
     * Returns the metadata of the block which this Item (ItemBlock) can place
     */
    public int getMetadata(int par1)
    {
        return par1;
    }

    public String getItemNameIS(ItemStack par1ItemStack)
    {
        int var2 = par1ItemStack.getItemDamage();

        if (var2 < 0 || var2 >= this.names.length)
        {
            var2 = 0;
        }

        return super.getItemName() + "." + this.names[var2];
    }
}
