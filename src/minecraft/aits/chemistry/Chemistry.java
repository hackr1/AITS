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

import aits.chemistry.blocks.*;
import aits.core.*;
import aits.core.regs.*;
import aits.core.common.*;

public class Chemistry{
	
	//block definitions
	public static Block saltOre;
	public static Block platinumOre;
	public static Block leadOre;
	public static Block cinnabarOre;
	public static Block carobiiteOre;
	
	//item definitions
	/*
	public static Item salt;
	public static Item platinum;
	public static Item lead;
	public static Item cinnabar;
	public static Item potassiumfluoride;
	*/
	
	public static void load(FMLInitializationEvent fmlinitializationevent){
		
		registerBlocks();
		generateOreDictEntries();
		registerSmeltingRecipes();
		
	}
	
	private static void registerBlocks(){
		
		saltOre = new BlockSaltOre(RegConfig.BlockIDRange + 25, 0).setBlockName("Salt Ore)");
		GameRegistry.registerBlock(saltOre);
		LanguageRegistry.addName(saltOre, "Salt Ore");
		
		platinumOre = new BlockPlatinumOre(RegConfig.BlockIDRange + 26, 1).setBlockName("Platinum Ore");
		GameRegistry.registerBlock(platinumOre);
		LanguageRegistry.addName(platinumOre, "Platinum Ore");
		
		leadOre = new BlockLeadOre(RegConfig.BlockIDRange + 27, 2).setBlockName("Lead Ore");
		GameRegistry.registerBlock(leadOre);
		LanguageRegistry.addName(leadOre, "Lead Ore");
		
		cinnabarOre = new BlockCinnabarOre(RegConfig.BlockIDRange + 28, 3).setBlockName("Cinnabar Ore");
		GameRegistry.registerBlock(cinnabarOre);
		LanguageRegistry.addName(cinnabarOre, "Cinnabar Ore");
		
		carobiiteOre = new BlockCarobiiteOre(RegConfig.BlockIDRange + 29, 0).setBlockName("Carobiite Ore");
		GameRegistry.registerBlock(carobiiteOre);
		LanguageRegistry.addName(carobiiteOre, "Carobiite Ore");
	
	}
	
	private static void generateOreDictEntries(){
		
		OreDictionary.registerOre("oreSalt", new ItemStack(saltOre));
		OreDictionary.registerOre("orePlatinum", new ItemStack(platinumOre));
		OreDictionary.registerOre("oreLead", new ItemStack(leadOre));
		OreDictionary.registerOre("oreCinnabar", new ItemStack(cinnabarOre));
		OreDictionary.registerOre("oreCarobiite", new ItemStack(carobiiteOre));
	}
	
	private static void registerSmeltingRecipes(){
		//GameRegistry.addSmelting(platinumOre.blockID, new ItemStack(platinum), 1.0f);
		//GameRegistry.addSmelting(leadOre.blockID, new ItemStack(lead), 0.3f);
	}
	
	
}
		