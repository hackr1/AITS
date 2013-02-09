package aits.geology;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import aits.api.IAITSModule;
import aits.core.DefaultProps;
import aits.core.Version;
import aits.geology.blocks.BlockBricks;
import aits.geology.blocks.BlockRocks;
import aits.geology.items.ItemMultiBricks;
import aits.geology.items.ItemMultiRocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "AITS|Geology", name = "Geology", version = Version.VERSION, dependencies = DefaultProps.DEPENDENCY_CORE)
public class Geology implements IAITSModule
{
	public static Block stoneBrickMulti;
	public static Block rockMulti;
	@Override
	public void loadBlocks() 
	{
		this.stoneBrickMulti = new BlockBricks(450);
		this.rockMulti = new BlockRocks(451);
	}

	@Override
	public void registerBlocks() 
	{
		GameRegistry.registerBlock(this.stoneBrickMulti, ItemMultiBricks.class, "stoneBrickMulti");
		GameRegistry.registerBlock(this.rockMulti, ItemMultiRocks.class, "rockMulti");
	}

	@Override
	public void loadItems() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void generateOreDictEntries() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerSmeltingRecipes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerCraftingRecipes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addLocalizations() 
	{
		LanguageRegistry.addName(new ItemStack(this.stoneBrickMulti, 1, 0), "Slate Brick");
		LanguageRegistry.addName(new ItemStack(this.stoneBrickMulti, 1, 1), "Limestone Brick");
		LanguageRegistry.addName(new ItemStack(this.stoneBrickMulti, 1, 2), "Basalt Brick");
		LanguageRegistry.addName(new ItemStack(this.stoneBrickMulti, 1, 3), "Granite Brick");
		LanguageRegistry.addName(new ItemStack(this.stoneBrickMulti, 1, 4), "Pink Granite Brick");
		LanguageRegistry.addName(new ItemStack(this.stoneBrickMulti, 1, 5), "Marble Brick");
		LanguageRegistry.addName(new ItemStack(this.stoneBrickMulti, 1, 6), "Quartzite Brick");
		LanguageRegistry.addName(new ItemStack(this.rockMulti, 1, 0), "Slate");
		LanguageRegistry.addName(new ItemStack(this.rockMulti, 1, 1), "Limestone");
		LanguageRegistry.addName(new ItemStack(this.rockMulti, 1, 2), "Basalt");
		LanguageRegistry.addName(new ItemStack(this.rockMulti, 1, 3), "Granite");
		LanguageRegistry.addName(new ItemStack(this.rockMulti, 1, 4), "Pink Granite");
		LanguageRegistry.addName(new ItemStack(this.rockMulti, 1, 5), "Marble");
		LanguageRegistry.addName(new ItemStack(this.rockMulti, 1, 6), "Quartzite");
	}
}