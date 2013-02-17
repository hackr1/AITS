package aits.api;

/**
 * This is to be implemented by all AITS modules, IAITS contains methods that will be 
 * initialized in the base AITS mod class during init events.
 * 
 * @author ProPercivalalb
 */
public interface IAITSModule 
{
	public void loadBlocks();
	public void registerBlocks();
	
	public void loadItems();
	
	public void generateOreDictEntries();
	public void registerSmeltingRecipes();
	public void registerCraftingRecipes();
	
	public void addLocalizations();
}
