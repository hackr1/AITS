package aits.core.client;

import net.minecraftforge.client.MinecraftForgeClient;
import aits.core.common.CommonProxy;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenderers()
	{
		for(EnumTextureList l : CommonProxy.GetTextureList())
		{
			MinecraftForgeClient.preloadTexture(l.GetPath());
		}
	}
}