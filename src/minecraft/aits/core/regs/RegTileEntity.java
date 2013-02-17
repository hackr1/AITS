package aits.core.regs;

import net.minecraft.client.settings.GameSettings;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.GameRules;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;
import aits.chemistry.machines.labbench.TileLabBench;
import aits.core.tileentity.*;
public class RegTileEntity {

	public static void register(FMLInitializationEvent event)
	{
		GameRegistry.registerTileEntity(TileEntityBloomery.class, "Bloomert");
	}


}