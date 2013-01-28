package aits.core.regs;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class RegConfig {
	public static int ticksBetweenChecks;
	public static int BlockIDRange;
	public static int ItemIDRange;
	public static boolean ChemistryEnabled;

	public static void register(FMLPreInitializationEvent event) {
		// Stub Method
		// you will be able to find the config file in .minecraft/config/ and it
		// will be named Dummy.cfg
		// here our Configuration has been instantiated, and saved under the
		// name "config"
		// If the file doesn't already exist, it will be created.
		Configuration config = new Configuration(
				event.getSuggestedConfigurationFile());
		// loading the configuration from its file
		config.load();
		BlockIDRange = config
				.get(Configuration.CATEGORY_BLOCK,
						"Block ID Range",
						200,
						"This is the start of the block ID range that AITS will use. The range will end after 100 more of this number (may increase")
				.getInt();
		ItemIDRange = config
				.get(Configuration.CATEGORY_ITEM,
						"Item ID Range",
						5000,
						"This is the start of the item ID range that AITS will use. The range will end after 2500 more of this number (may increase")
				.getInt();
		ChemistryEnabled = config.get("Features",
							  "enable_chemistry",
							  true)
				.getBoolean(true);
		// saving the configuration to its file
		config.save();
	}
}
