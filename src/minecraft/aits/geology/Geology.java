package aits.geology;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import aits.api.IAITSModule;
import aits.chemistry.blocks.BlockCarobiiteOre;
import aits.core.DefaultProps;
import aits.core.Version;
import aits.core.regs.RegConfig;
import aits.geology.blocks.BlockAnthracite;
import aits.geology.blocks.BlockBituminousCoal;
import aits.geology.blocks.BlockBricks;
import aits.geology.blocks.BlockPeat;
import aits.geology.blocks.BlockRockCobblestones;
import aits.geology.blocks.BlockRockTiles;
import aits.geology.blocks.BlockRocks;
import aits.geology.blocks.BlockWallTiles;
import aits.geology.items.ItemMultiBricks;
import aits.geology.items.ItemMultiRockTiles;
import aits.geology.items.ItemMultiRocks;
import aits.geology.items.ItemRockCobblestones;
import aits.geology.items.ItemRockWallTiles;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "AITS|Geology", name = "Geology", version = Version.VERSION, dependencies = DefaultProps.DEPENDENCY_CORE)
public class Geology implements IAITSModule
{
	public static Block stoneBrickMulti;
	public static Block rockMulti;
	public static Block tileMulti;
	public static Block wallTileMulti;
	public static Block rockCobblestones;
	
	public static Block blockPeat;
	public static Block bituminousCoal;
	public static Block blockAnthracite;
	
	@Override
	public void loadBlocks() 
	{
		this.stoneBrickMulti = new BlockBricks(450);
		this.rockMulti = new BlockRocks(451);
		this.tileMulti = new BlockRockTiles(452);
		this.wallTileMulti = new BlockWallTiles(453);
		this.rockCobblestones = new BlockRockCobblestones(454);
		
		this.blockPeat = new BlockPeat(RegConfig.BlockIDRange + 30, 80).setBlockName("Peat");
		this.bituminousCoal = new BlockBituminousCoal(RegConfig.BlockIDRange + 31, 81).setBlockName("Bituminous Coal Ore");
		this.blockAnthracite = new BlockAnthracite(RegConfig.BlockIDRange + 32, 82).setBlockName("Anthracite Ore");
	}

	@Override
	public void registerBlocks() 
	{
		GameRegistry.registerBlock(this.stoneBrickMulti, ItemMultiBricks.class, "stoneBrickMulti");
		GameRegistry.registerBlock(this.rockMulti, ItemMultiRocks.class, "rockMulti");
		GameRegistry.registerBlock(this.tileMulti, ItemMultiRockTiles.class, "rockTiles");
		GameRegistry.registerBlock(this.wallTileMulti, ItemRockWallTiles.class, "rockWallTiles");
		GameRegistry.registerBlock(this.rockCobblestones, ItemRockCobblestones.class, "rockCobblestones");

		GameRegistry.registerBlock(blockPeat, "blockPeat");
		GameRegistry.registerBlock(blockAnthracite, "blockAnthracite");
		GameRegistry.registerBlock(bituminousCoal, "bituminousCoal");
	}

	@Override
	public void loadItems() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void generateOreDictEntries() 
	{

		OreDictionary.registerOre("blockPeat", new ItemStack(blockPeat));
		OreDictionary.registerOre("blockAnthracite", new ItemStack(blockAnthracite));
		OreDictionary.registerOre("bituminousCoal", new ItemStack(bituminousCoal));
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
	
		LanguageRegistry.addName(new ItemStack(this.tileMulti, 1, 0), "Slate Tile");
		LanguageRegistry.addName(new ItemStack(this.tileMulti, 1, 1), "Limestone Tile");
		LanguageRegistry.addName(new ItemStack(this.tileMulti, 1, 2), "Basalt Tile");
		LanguageRegistry.addName(new ItemStack(this.tileMulti, 1, 3), "Granite Tile");
		LanguageRegistry.addName(new ItemStack(this.tileMulti, 1, 4), "Pink Granite Tile");
		LanguageRegistry.addName(new ItemStack(this.tileMulti, 1, 5), "Marble Tile");
		LanguageRegistry.addName(new ItemStack(this.tileMulti, 1, 6), "Quartzite Tile");

		LanguageRegistry.addName(new ItemStack(this.wallTileMulti, 1, 0), "Slate Wall Tile");
		LanguageRegistry.addName(new ItemStack(this.wallTileMulti, 1, 1), "Limestone Wall Tile");
		LanguageRegistry.addName(new ItemStack(this.wallTileMulti, 1, 2), "Basalt Wall Tile");
		LanguageRegistry.addName(new ItemStack(this.wallTileMulti, 1, 3), "Granite Wall Tile");
		LanguageRegistry.addName(new ItemStack(this.wallTileMulti, 1, 4), "Pink Granite Wall Tile");
		LanguageRegistry.addName(new ItemStack(this.wallTileMulti, 1, 5), "Marble Wall Tile");
		LanguageRegistry.addName(new ItemStack(this.wallTileMulti, 1, 6), "Quartzite Wall Tile");

		LanguageRegistry.addName(new ItemStack(this.rockCobblestones, 1, 0), "Slate Cobblestone");
		LanguageRegistry.addName(new ItemStack(this.rockCobblestones, 1, 1), "Limestone Cobblestone");
		LanguageRegistry.addName(new ItemStack(this.rockCobblestones, 1, 2), "Basalt Cobblestone");
		LanguageRegistry.addName(new ItemStack(this.rockCobblestones, 1, 3), "Granite Cobblestone");
		LanguageRegistry.addName(new ItemStack(this.rockCobblestones, 1, 4), "Pink Granite Cobblestone");
		LanguageRegistry.addName(new ItemStack(this.rockCobblestones, 1, 5), "Marble Cobblestone");
		LanguageRegistry.addName(new ItemStack(this.rockCobblestones, 1, 6), "Quartzite Cobblestone");

		LanguageRegistry.addName(bituminousCoal, "Bituminous Coal Ore");
		LanguageRegistry.addName(blockPeat, "Peat");
		LanguageRegistry.addName(blockAnthracite, "Anthracite Ore");

		


	}
}