package requimrar.Minecraft.RChem.Client;

import net.minecraftforge.client.MinecraftForgeClient;
import requimrar.Minecraft.RChem.RChemCommonProxy;
import requimrar.Minecraft.RChem.RChemMod;
import requimrar.Minecraft.RChem.Client.Renderer.ItemCompoundRenderer;

public class ClientProxy extends RChemCommonProxy
{

	@Override
	public void registerRenderers()
	{
		MinecraftForgeClient.preloadTexture(CONST_ITEMS_PNG);
		MinecraftForgeClient.preloadTexture(CONST_BLOCK_PNG);
		//		MinecraftForgeClient.registerItemRenderer(RChem.ElementMetaItem.itemID, new RChemItemElementRenderer());
		MinecraftForgeClient.registerItemRenderer(RChemMod.CompoundMetaItem.itemID, new ItemCompoundRenderer());
	}

}