package aits.core.recipes;

import java.util.HashMap;
import net.minecraft.item.ItemStack;

/** @author hackr1 */
public class BloomeryRecipes {

/**
* This hashmap contains the recipes for the bloomery.
* */
private static HashMap<Class, ItemStack> recipes = new HashMap<Class, ItemStack>();

/**
* Creates a new bloomery recipe.
* @param material The class of the item that you put into the bloomery.
* @param product The ItemStack that is created during the process.
*/
public static void add(Class material, ItemStack product)
{
//check if there isn't already a recipe with this material
if(recipes.get(material) == null){
//if there isn't, add a new one
recipes.put(material, product);
}
}

/**
* Returns the ItemStack that is created when putting a specified material into the bloomery.
* @param material The class of the item that you put into the bloomery.
* @return The ItemStack that is created during the process.
*/
public static ItemStack getProduct(Class material){
return recipes.get(material);
}

@Deprecated
/**
* Returns a HashMap containing all recipes for the bloomery.
* It is recommended to not use this but use {@link #getProduct(Class) getProduct} instead.
* @return The HashMap containing all recipes for the bloomery.
*/
public HashMap<Class, ItemStack> getAllRecipes(){
return recipes;
}

}