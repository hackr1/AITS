package aits.api;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import aits.core.DefaultProps;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainer;

/**
 * 
 * @author ProPercivalalb
 */
public class ModuleRegistry 
{
	
	public static void findAllModules()
	{
		Iterator modules = Loader.instance().getActiveModList().iterator();
		
		while(modules.hasNext())
		{
			ModContainer modContainer = (ModContainer)modules.next();
			
			if(modContainer.getMod() instanceof IAITSModule)
			{
				modContainer.getMetadata().parent = DefaultProps.MOD;
				IAITSModule module = (IAITSModule)modContainer.getMod();
				module.loadBlocks();
				module.registerBlocks();
				module.loadItems();
				module.generateOreDictEntries();
				module.registerCraftingRecipes();
				module.registerSmeltingRecipes();
				module.addLocalizations();
			}	
		}
	}
}
