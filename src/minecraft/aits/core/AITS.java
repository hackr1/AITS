package aits.core;

import java.util.Iterator;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import aits.api.IAITSModule;
import aits.api.ModuleRegistry;
import aits.core.common.CommonProxy;
import aits.core.items.ItemCoke;
import aits.core.regs.*;
import aits.chemistry.Chemistry;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = DefaultProps.MOD, name = "Anchor In The Science", version = Version.VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class AITS 
{
	// The instance of your mod that Forge uses.
	@Instance(DefaultProps.MOD)
	public static AITS instance;
	public static final tabCreativeAITS tabAITS = new tabCreativeAITS(12, "AITS");
	

	// Says where the client and server 'proxy' code is loaded.
	@SidedProxy(clientSide = "aits.core.client.ClientProxy", serverSide = "aits.core.common.CommonProxy")
	public static CommonProxy proxy;

	@PreInit
	public void preInit(FMLPreInitializationEvent event) 
	{
		RegConfig.register(event);
	}

	@Init
	public void load(FMLInitializationEvent event) 
	{
		proxy.registerRenderers();
		ModuleRegistry.findAllModules();
		RegBlocks.register(event);
		RegItems.register(event);
		RegNames.register(event);
		RegCrafting.register(event);
		RegSmelting.register(event);
		RegTileEntity.register(event);
		MinecraftForge.EVENT_BUS.register(new EventListener());
		NetworkRegistry.instance().registerGuiHandler(this, proxy);
		// TODO GameRegistry.registerWorldGenerator(this);

	}

	@PostInit
	public void postInit(FMLPostInitializationEvent event) 
	{
		
	}
}
