package cz.grossik.farmcraft2.handler;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {
	
	public static boolean version;
	
	public static void init(File configFile) {
		Configuration config = new Configuration(configFile);

		config.load();
			version = config.getBoolean("Version Checker", "Version Checker", true, "Write to chat about version.");
		config.save();
	}
}