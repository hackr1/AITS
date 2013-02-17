package requimrar.Minecraft.RChem;

import java.util.logging.Logger;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import requimrar.Minecraft.RChem.Client.ClientPacketHandler;
import requimrar.Minecraft.RChem.Item.ItemCompound;
import requimrar.Minecraft.RChem.Machines.GuiHandler;
import requimrar.Minecraft.RChem.Machines.LabBench.BlockLabBench;
import requimrar.Minecraft.RChem.Machines.LabBench.TileLabBench;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;


// This mod will require BC3 to function (sadly)


/*// RP2 = Redpower 2
// IC2 = IndustrialCraft 2
// BC3 = Buildcraft 3
// FSTRY = Forestry
// GT = GregTech
// TE = ThermalExpansion
// RC = Railcraft
// EBX = ExtraBiomesXL

// Worldgen Ores & Ingots for ForgeOreDictionary
// DISABLED: CopperOre = oreCopper (BC3 should have this)
// DISABLED: TinOre = oreTin (BC3 should have this)
// IridiumOre = oreIridium (if !GT && IC2)
// PlatinumOre = orePlatinum (if !GT)
// UraniumOre = oreUranium (if !IC2)
// BauxiteOre = oreBauxite (if !GT)
// NickelOre = oreNickel if(!GT && !RP2)
// LeadOre = oreLead if(!TE && !GT)
// SaltpetreOre = oreSaltpeter (if !RC)

// Ingots and stuff to support

// BrassIngot = ingotBrass (if RP2)
// BronzeIngot = ingotBronze
// CopperIngot = ingotCopper
// TinIngot = ingotTin
// SilverIngot = ingotSilver (if GT || RP2 || TE)
// LeadIngot = ingotLead
// NickelIngot = ingotNickel
// PlatinumIngot = ingotPlatinum
// IridiumIngot = ingotIridium
// AluminiumIngot = ingotAluminium (if GT)
// TitaniumIngot = ingotTitanium (if GT)
// ChromeIngot = ingotChrome (if GT)
// TungstenIngot = ingotTungsten
// ElectrumIngot = ingotElectrum (if GT)
// ZincIngot = ingotZinc (if GT)
// SteelIngot = ingotSteel (if GT || RC)

// Add config option: enable nugget crafting
// to enable nuggets below. FALSE by default.
// IronNugget = nuggetIron
// SteelNugget = nuggetSteel (if RC || GT)
// SilverNugget = nuggetSilver (if GT || RP2 || TE)
// TinNugget = nuggetTin
// CopperNugget = nuggetCopper
// IridiumNugget = nuggetIridium
// BronzeNugget = nuggetBronze
// InvarNugget = nuggetInvar (if GT)
// NickelNugget = nuggetNickel
// PlatinumNugget = nuggetPlatinum
// BrassNugget = nuggetBrass (if RP2)
// ZincNugget = nuggetZinc (if GT)
// LeadNugget = nuggetLead
// TungstenNugget = nuggetTungsten (if GT)
// ElectrumNugget = nuggetElectrum (if GT)
// ChromeNugget = nuggetChrome (if GT)
// TitaniumNugget = nuggetTitanium (if GT)
// AluminiumNugget = nuggetAluminium (if GT)


// Gems to support
// UraniumRaw = dropUranium
// IridiumRaw = itemIridium
// VanillaDiamond = gemDiamond
// VanillaEmerald = gemEmerald
// ApatiteItem = gemApatite (if FSTRY)
// RubyItem = gemRuby (if RP2 || GT)
// GreenSapphireItem = gemGreenSapphire (if RP2 || GT)
// SapphireItem = gemSapphire (if GT || RP2)
// OlivineItem = gemOlivine (if GT)
// RedGarnetItem = gemGarnetRed (if GT)
// YellowGarnetItem = gemGarnetYellow (if GT)


// Dusts to support
// AshDust = dustAsh (if FSTRY)
// ObsidianDust = dustObsidian
// SulphurDust = dustSulfur
// SaltpetreDust = dustSaltpeter
// CharcoalDust = dustCharcoal (if GT)
// NikoliteDust = dustNikolite (if RP2)
// IronDust = dustIron
// GoldDust = dustGold
// CopperDust = dustCopper
// TinDust = dustTin
// SilverDust = dustSilver
// LeadDust = dustLead
// BronzeDust = dustBronze
// BrassDust = dustBrass (if GT)
// ElectrumDust = dustElectrum (if GT)
// InvarDust = dustInvar (if GT)
// NickelDust = dustNickel
// PlatinumDust = dustPlatinum
// PyriteDust = dustPyrite (if GT)
// CalciteDust = dustCalcite (if GT)
// SodaliteDust = dustSodalite (if GT)
// FlintDust = dustFlint (if GT)
// RubyDust = dustRuby (if GT)
// SapphireDust = dustSapphire (if GT)
// GreenSapphireDust = dustGreenSapphire (if GT)
// EmeraldDust = dustEmerald (if GT)
// DiamondDust = dustDiamond (if GT)
// OlivineDust = dustOlivine (if GT)
// SteelDust = dustSteel (if GT)
// ZincDust = dustZinc
// TungstenDust = dustTungsten
// ChromeDust = dustChrome
// TitaniumDust = dustTitanium
// AluminiumDust = dustAluminium
// BauxiteDust = dustBauxite
// UraniumDust = dustUranium (if GT)
// SphaleriteDust = dustSphalerite (if GT)
// MagnesiumDust = dustMagnesium
// ManganeseDust = dustManganese
// CinnabarDust = dustCinnabar (if GT)
// PhosphorusDust = dustPhosphorus
// RedGarnetDust = dustGarnetRed (if GT)
// YellowGarnetDust = dustGarnetYellow (if GT)
// PyropeGarnetDust  = dustPyrope (if GT)
// AlmandineGarnetDust = dustAlmandine (if GT)
// SpessartineGarnetDust = dustSpessartine (if GT)
// AndraditeGarnetDust = dustAndradite (if GT)
// GrossularGarnetDust = dustGrossular
// UvaroviteGarnetDust = dustUvarovite
// ClayDust = dustClay (if GT)
// CoalDust = dustCoal (if GT || IC2)
// PlutoniumDust = dustPlutonium (if GT)
// ThoriumDust = dustThorium
// BasaltDust = dustBasalt (if GT && RP2)
// MarbleDust = dustMarble (if GT && RP2)
// RedRockDust = dustRedRock (if EBX && GT)
// DarkAshDust = dustDarkAsh (if GT)


// Plates (4) to support
// MagnaliumPlate = plateMagnalium (if GT)
// SiliconPlate = plateSilicon (if GT)
// IridiumPlate = plateIridium (if IC2)


// Dyes to support
// BlackDye = dyeBlack
// RedDye = dyeRed
// GreenDye = dyeGreen
// BrownDye = dyeBrown
// BlueDye = dustLapis/dyeBlue(if RP2)
// PurpleDye = dyePurple
// CyanDye = dyeCyan
// LightGreyDye = dyeLightGray
// GreyDye = dyeGray
// WhiteDye = dyeWhite
// OrangeDye = dyeOrange
// MagentaDye = dyeMagenta
// LightBlueDye = dyeLightBlue
// YellowDye = dyeYellow
// LimeDye = dyeLime
// PinkDye = dyePink


// Gears (for materials/machines)
// TinGear = gearTin
// CopperGear = gearCopper
// InvarGear = gearInvar (if GT)
// BronzeGear = gearBronze (if RP2)


// GregTech Element Naming System:
// molecule_@x_$y
// where @ and $ are the number of
// that element in the compound; x & y
// are the chemical symbols of the
// elements.
// NOTE: Deuterium is d, Tritium is t.


// MineChem2 Element Naming System:
// ElementHydrogen = elementHydrogen
// Simple!

// Exceptions:
// Element 113:
// elementMinecraftium.
// Does not exist; change to
// ElementUnuntrium = elementMinecraftium

// Also: Add elements 114-118

 */






@Mod(modid = "RChem", name = "RealisticChemistry", version = "0.41")
@NetworkMod(clientSideRequired = true, serverSideRequired = false, clientPacketHandlerSpec =
@SidedPacketHandler(channels = {"RChem"}, packetHandler = ClientPacketHandler.class), serverPacketHandlerSpec =
@SidedPacketHandler(channels = {"RChem"}, packetHandler = ServerPacketHandler.class))


public class RChemMod
{
	public static CreativeTabs RChemCTab = new RChemCreativeTab("RChemCTab");

	private final static EnumCompoundList[] CompoundList = EnumCompoundList.values();

	public static Logger log = Logger.getLogger("RChem");


	private final GuiHandler GuiHandler = new GuiHandler();
	public static ItemCompound CompoundMetaItem;

	// This is the standard Block declaration, nothing new here
	public static final Block RChemBlockLabBench = new BlockLabBench(255);


	// The instance of your mod that Forge uses.
	@Instance("RChem")
	public static RChemMod instance;



	// Says where the client and server 'proxy' code is loaded.
	@SidedProxy(clientSide = "requimrar.Minecraft.RChem.Client.ClientProxy", serverSide = "requimrar.Minecraft.RChem.CommonProxy")
	public static RChemCommonProxy proxy;

	@Init
	public void init(FMLInitializationEvent event)
	{
		log.setParent(FMLLog.getLogger());
		log.info("Loading RChem...");


		//		ElementMetaItem = (RChemElementItem) new RChemElementItem(7900).setFull3D();
		CompoundMetaItem = (ItemCompound) new ItemCompound(7901).setFull3D();


		//		ContainerEmpty = (RChemEmptyContainer) new RChemEmptyContainer(7902).setFull3D();
		//		ContainerElementMetaItem = (RChemContainerElement) new RChemContainerElement(7903).setFull3D();


		LanguageRegistry.instance().addStringLocalization("itemGroup.RChemCTab", "en_US", "Realistic Chemistry");
		LanguageRegistry.instance().addStringLocalization("itemGroup.RChemCTab", "en_GB", "Realistic Chemistry");














		NetworkRegistry.instance().registerGuiHandler(this, GuiHandler);
		GameRegistry.registerTileEntity(TileLabBench.class, "TileLabBench");
		GameRegistry.registerBlock(RChemBlockLabBench, "RChemBlockLabBench");
		TickRegistry.registerScheduledTickHandler(new ScheduledTickHandler(), Side.SERVER);

		RChemBlockLabBench.setCreativeTab(RChemCTab);

		//		for(int i = 0; i < RChemElementEnums.values().length; i++)
		//		{
		//			GameRegistry.addShapelessRecipe(new ItemStack(ContainerElementMetaItem, 1, i), new Object[]{ new ItemStack(ElementMetaItem, 1, i), new ItemStack(ContainerEmpty, 1) });
		//			GameRegistry.addShapelessRecipe(new ItemStack(ContainerElementMetaItem, 1, i), new Object[]{ new ItemStack(ElementMetaItem, 1, i), new ItemStack(ContainerElementMetaItem, 1, i) });
		//
		//		}

		//		GameRegistry.addShapelessRecipe(new ItemStack(this.ContainerElementMetaItem, 1, 12), new ItemStack(ElementMetaItem, 1, 12), new ItemStack(ContainerElementMetaItem, 1, 0));

		// And this gives the block its in game name
		LanguageRegistry.addName(RChemBlockLabBench, "Lab Bench");

		proxy.registerRenderers();
	}

	@PostInit
	public void postInit(FMLPostInitializationEvent event)
	{
		// Stub Method
	}

	public static EnumCompoundList[] GetCompoundList()
	{
		return CompoundList;
	}
}
