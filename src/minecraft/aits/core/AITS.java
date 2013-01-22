package aits.core;

import net.minecraft.item.ItemStack;
import aits.core.common.CommonProxy;
import aits.core.items.ItemCoke;
import aits.core.regs.RegBlocks;
import aits.core.regs.RegConfig;
import aits.core.regs.RegItems;
import aits.core.regs.RegNames;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "AITS", name = "Anchor In The Science", version = "0.0.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class AITS {

	// The instance of your mod that Forge uses.
	@Instance("corrupting_diamonds")
	public static AITS instance;
	public static final tabCreativeAITS tabAITS = new tabCreativeAITS(12,
			"AITS");
	public static ItemCoke itemCoke;

	// Says where the client and server 'proxy' code is loaded.
	@SidedProxy(clientSide = "aits.core.client.ClientProxy", serverSide = "aits.core.common.CommonProxy")
	public static CommonProxy proxy;

	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		RegConfig.register(event);
	}

	@Init
	public void load(FMLInitializationEvent event) {
		proxy.registerRenderers();

		RegBlocks.register(event);
		RegItems.register(event);
		RegNames.register(event);

		NetworkRegistry.instance().registerGuiHandler(this, proxy);
		// TODO GameRegistry.registerWorldGenerator(this);

	}

	@PostInit
	public void postInit(FMLPostInitializationEvent event) {
		// Stub Method
	}
}
