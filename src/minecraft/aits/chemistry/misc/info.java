package aits.chemistry.misc;
// This mod will require BC3 to function (sadly)


/*
 * // RP2 = Redpower 2
 * // IC2 = IndustrialCraft 2
 * // BC3 = Buildcraft 3
 * // FSTRY = Forestry
 * // GT = GregTech
 * // TE = ThermalExpansion
 * // RC = Railcraft
 * // EBX = ExtraBiomesXL
 * 
 * // Worldgen Ores & Ingots for ForgeOreDictionary
 * // DISABLED: CopperOre = oreCopper (BC3 should have this)
 * // DISABLED: TinOre = oreTin (BC3 should have this)
 * // IridiumOre = oreIridium (if !GT && IC2)
 * // PlatinumOre = orePlatinum (if !GT)
 * // UraniumOre = oreUranium (if !IC2)
 * // BauxiteOre = oreBauxite (if !GT)
 * // NickelOre = oreNickel if(!GT && !RP2)
 * // LeadOre = oreLead if(!TE && !GT)
 * // SaltpetreOre = oreSaltpeter (if !RC)
 * 
 * // Ingots and stuff to support
 * 
 * // BrassIngot = ingotBrass (if RP2)
 * // BronzeIngot = ingotBronze
 * // CopperIngot = ingotCopper
 * // TinIngot = ingotTin
 * // SilverIngot = ingotSilver (if GT || RP2 || TE)
 * // LeadIngot = ingotLead
 * // NickelIngot = ingotNickel
 * // PlatinumIngot = ingotPlatinum
 * // IridiumIngot = ingotIridium
 * // AluminiumIngot = ingotAluminium (if GT)
 * // TitaniumIngot = ingotTitanium (if GT)
 * // ChromeIngot = ingotChrome (if GT)
 * // TungstenIngot = ingotTungsten
 * // ElectrumIngot = ingotElectrum (if GT)
 * // ZincIngot = ingotZinc (if GT)
 * // SteelIngot = ingotSteel (if GT || RC)
 * 
 * // Add config option: enable nugget crafting
 * // to enable nuggets below. FALSE by default.
 * // IronNugget = nuggetIron
 * // SteelNugget = nuggetSteel (if RC || GT)
 * // SilverNugget = nuggetSilver (if GT || RP2 || TE)
 * // TinNugget = nuggetTin
 * // CopperNugget = nuggetCopper
 * // IridiumNugget = nuggetIridium
 * // BronzeNugget = nuggetBronze
 * // InvarNugget = nuggetInvar (if GT)
 * // NickelNugget = nuggetNickel
 * // PlatinumNugget = nuggetPlatinum
 * // BrassNugget = nuggetBrass (if RP2)
 * // ZincNugget = nuggetZinc (if GT)
 * // LeadNugget = nuggetLead
 * // TungstenNugget = nuggetTungsten (if GT)
 * // ElectrumNugget = nuggetElectrum (if GT)
 * // ChromeNugget = nuggetChrome (if GT)
 * // TitaniumNugget = nuggetTitanium (if GT)
 * // AluminiumNugget = nuggetAluminium (if GT)
 * 
 * 
 * // Gems to support
 * // UraniumRaw = dropUranium
 * // IridiumRaw = itemIridium
 * // VanillaDiamond = gemDiamond
 * // VanillaEmerald = gemEmerald
 * // ApatiteItem = gemApatite (if FSTRY)
 * // RubyItem = gemRuby (if RP2 || GT)
 * // GreenSapphireItem = gemGreenSapphire (if RP2 || GT)
 * // SapphireItem = gemSapphire (if GT || RP2)
 * // OlivineItem = gemOlivine (if GT)
 * // RedGarnetItem = gemGarnetRed (if GT)
 * // YellowGarnetItem = gemGarnetYellow (if GT)
 * 
 * 
 * // Dusts to support
 * // AshDust = dustAsh (if FSTRY)
 * // ObsidianDust = dustObsidian
 * // SulphurDust = dustSulfur
 * // SaltpetreDust = dustSaltpeter
 * // CharcoalDust = dustCharcoal (if GT)
 * // NikoliteDust = dustNikolite (if RP2)
 * // IronDust = dustIron
 * // GoldDust = dustGold
 * // CopperDust = dustCopper
 * // TinDust = dustTin
 * // SilverDust = dustSilver
 * // LeadDust = dustLead
 * // BronzeDust = dustBronze
 * // BrassDust = dustBrass (if GT)
 * // ElectrumDust = dustElectrum (if GT)
 * // InvarDust = dustInvar (if GT)
 * // NickelDust = dustNickel
 * // PlatinumDust = dustPlatinum
 * // PyriteDust = dustPyrite (if GT)
 * // CalciteDust = dustCalcite (if GT)
 * // SodaliteDust = dustSodalite (if GT)
 * // FlintDust = dustFlint (if GT)
 * // RubyDust = dustRuby (if GT)
 * // SapphireDust = dustSapphire (if GT)
 * // GreenSapphireDust = dustGreenSapphire (if GT)
 * // EmeraldDust = dustEmerald (if GT)
 * // DiamondDust = dustDiamond (if GT)
 * // OlivineDust = dustOlivine (if GT)
 * // SteelDust = dustSteel (if GT)
 * // ZincDust = dustZinc
 * // TungstenDust = dustTungsten
 * // ChromeDust = dustChrome
 * // TitaniumDust = dustTitanium
 * // AluminiumDust = dustAluminium
 * // BauxiteDust = dustBauxite
 * // UraniumDust = dustUranium (if GT)
 * // SphaleriteDust = dustSphalerite (if GT)
 * // MagnesiumDust = dustMagnesium
 * // ManganeseDust = dustManganese
 * // CinnabarDust = dustCinnabar (if GT)
 * // PhosphorusDust = dustPhosphorus
 * // RedGarnetDust = dustGarnetRed (if GT)
 * // YellowGarnetDust = dustGarnetYellow (if GT)
 * // PyropeGarnetDust = dustPyrope (if GT)
 * // AlmandineGarnetDust = dustAlmandine (if GT)
 * // SpessartineGarnetDust = dustSpessartine (if GT)
 * // AndraditeGarnetDust = dustAndradite (if GT)
 * // GrossularGarnetDust = dustGrossular
 * // UvaroviteGarnetDust = dustUvarovite
 * // ClayDust = dustClay (if GT)
 * // CoalDust = dustCoal (if GT || IC2)
 * // PlutoniumDust = dustPlutonium (if GT)
 * // ThoriumDust = dustThorium
 * // BasaltDust = dustBasalt (if GT && RP2)
 * // MarbleDust = dustMarble (if GT && RP2)
 * // RedRockDust = dustRedRock (if EBX && GT)
 * // DarkAshDust = dustDarkAsh (if GT)
 * 
 * 
 * // Plates (4) to support
 * // MagnaliumPlate = plateMagnalium (if GT)
 * // SiliconPlate = plateSilicon (if GT)
 * // IridiumPlate = plateIridium (if IC2)
 * 
 * 
 * // Dyes to support
 * // BlackDye = dyeBlack
 * // RedDye = dyeRed
 * // GreenDye = dyeGreen
 * // BrownDye = dyeBrown
 * // BlueDye = dustLapis/dyeBlue(if RP2)
 * // PurpleDye = dyePurple
 * // CyanDye = dyeCyan
 * // LightGreyDye = dyeLightGray
 * // GreyDye = dyeGray
 * // WhiteDye = dyeWhite
 * // OrangeDye = dyeOrange
 * // MagentaDye = dyeMagenta
 * // LightBlueDye = dyeLightBlue
 * // YellowDye = dyeYellow
 * // LimeDye = dyeLime
 * // PinkDye = dyePink
 * 
 * 
 * // Gears (for materials/machines)
 * // TinGear = gearTin
 * // CopperGear = gearCopper
 * // InvarGear = gearInvar (if GT)
 * // BronzeGear = gearBronze (if RP2)
 * 
 * 
 * // GregTech Element Naming System:
 * // molecule_@x_$y
 * // where @ and $ are the number of
 * // that element in the compound; x & y
 * // are the chemical symbols of the
 * // elements.
 * // NOTE: Deuterium is d, Tritium is t.
 * 
 * 
 * // MineChem2 Element Naming System:
 * // ElementHydrogen = elementHydrogen
 * // Simple!
 * 
 * // Exceptions:
 * // Element 113:
 * // elementMinecraftium.
 * // Does not exist; change to
 * // ElementUnuntrium = elementMinecraftium
 * 
 * // Also: Add elements 114-118
 */





