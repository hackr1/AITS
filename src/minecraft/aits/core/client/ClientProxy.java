package aits.core.client;

import net.minecraftforge.client.MinecraftForgeClient;
import aits.core.common.CommonProxy;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenderers() {
		MinecraftForgeClient.preloadTexture(ITEMS_PNG);
		MinecraftForgeClient.preloadTexture(BLOCK_PNG);
		MinecraftForgeClient.preloadTexture(CHEMISTRY_BLOCK_PNG);
		MinecraftForgeClient.preloadTexture(CHEMISTRY_ITEM_PNG);
	}

}