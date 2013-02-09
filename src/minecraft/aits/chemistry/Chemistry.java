package aits.chemistry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.common.*;
import cpw.mods.fml.common.*;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.*;

import aits.api.IAITSModule;
import aits.api.ModuleRegistry;
import aits.chemistry.blocks.*;
import aits.core.*;
import aits.core.regs.*;
import aits.core.common.*;

@Mod(modid = "AITS|Chemistry", name = "Chemistry", version = Version.VERSION, dependencies = DefaultProps.DEPENDENCY_CORE)
public class Chemistry implements IAITSModule
{
	//Block definitions
	public static Block saltOre;
	public static Block platinumOre;
	public static Block leadOre;
	public static Block cinnabarOre;
	public static Block carobiiteOre;
	
	//Item definitions - not yet implemented.
	/**
	public static Item salt;
	public static Item platinum;
	public static Item lead;
	public static Item cinnabar;
	public static Item potassiumfluoride;**/
	
	@Override
	public void generateOreDictEntries()
	{
		OreDictionary.registerOre("oreSalt", new ItemStack(saltOre));
		OreDictionary.registerOre("orePlatinum", new ItemStack(platinumOre));
		OreDictionary.registerOre("oreLead", new ItemStack(leadOre));
		OreDictionary.registerOre("oreCinnabar", new ItemStack(cinnabarOre));
		OreDictionary.registerOre("oreCarobiite", new ItemStack(carobiiteOre));
	}
	
	@Override
	public void registerSmeltingRecipes()
	{
		//GameRegistry.addSmelting(platinumOre.blockID, new ItemStack(platinum), 1.0f);
		//GameRegistry.addSmelting(leadOre.blockID, new ItemStack(lead), 0.3f);
	}

	@Override
	public void loadBlocks()
	{
		saltOre = new BlockSaltOre(RegConfig.BlockIDRange + 25, 0).setBlockName("Salt Ore)");
		platinumOre = new BlockPlatinumOre(RegConfig.BlockIDRange + 26, 1).setBlockName("Platinum Ore");
		leadOre = new BlockLeadOre(RegConfig.BlockIDRange + 27, 2).setBlockName("Lead Ore");
		cinnabarOre = new BlockCinnabarOre(RegConfig.BlockIDRange + 28, 3).setBlockName("Cinnabar Ore");
		carobiiteOre = new BlockCarobiiteOre(RegConfig.BlockIDRange + 29, 0).setBlockName("Carobiite Ore");
	}

	@Override
	public void registerBlocks() 
	{
		GameRegistry.registerBlock(saltOre, "saltOre");
		GameRegistry.registerBlock(platinumOre, "platinumOre");
		GameRegistry.registerBlock(leadOre, "leadOre");
		GameRegistry.registerBlock(cinnabarOre, "cinnabarOre");
		GameRegistry.registerBlock(carobiiteOre, "carobiiteOre");
		
	}

	@Override
	public void loadItems() {}

	@Override
	public void registerCraftingRecipes() {}

	@Override
	public void addLocalizations()
	{
		LanguageRegistry.addName(saltOre, "Salt Ore");
		LanguageRegistry.addName(platinumOre, "Platinum Ore");
		LanguageRegistry.addName(leadOre, "Lead Ore");
		LanguageRegistry.addName(cinnabarOre, "Cinnabar Ore");
		LanguageRegistry.addName(carobiiteOre, "Carobiite Ore");
	}
}
		