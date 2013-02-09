package aits.core;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import net.minecraft.client.Minecraft;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Version 
{
	public enum EnumUpdateState {CURRENT, OUTDATED, CONNECTION_ERROR}
	
	public static final String VERSION = "0.0.1a";
	// TODO create a dropbox .txt link
	private static final String REMOTE_VERSION_FILE = "UNKNOWN";

	public static EnumUpdateState currentVersion = EnumUpdateState.CURRENT;

	public static final int FORGE_VERSION_MAJOR = 6;
	public static final int FORGE_VERSION_MINOR = 0;
	public static final int FORGE_VERSION_PATCH = 0;

	private static String recommendedVersion;
	
	public static String getVersion() 
	{
		return VERSION;
	}

	public static String getRecommendedVersion() 
	{
		return recommendedVersion;
	}
	
	public static void versionCheck(FMLPreInitializationEvent evt) 
	{
		try 
		{
			
			String location = REMOTE_VERSION_FILE;
			HttpURLConnection conn = null;
			while(location != null && !location.isEmpty()) 
			{
				URL url = new URL(location);
				conn = (HttpURLConnection)url.openConnection();
				conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.0; ru; rv:1.9.0.11) Gecko/2009060215 Firefox/3.0.11 (.NET CLR 3.5.30729)");
				conn.connect();
				location = conn.getHeaderField("Location");
			}

			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			String line = null;
			String mcVersion = Loader.instance().getMinecraftModContainer().getVersion();
		    while ((line = reader.readLine()) != null) 
		    {
		    	if (line.startsWith(mcVersion)) 
		    	{
		    		if (line.contains(DefaultProps.MOD)) 
		    		{
		    			String[] tokens = line.split(":");
		    			recommendedVersion = tokens[2];
		    			
			    		if (line.endsWith(VERSION)) 
			    		{
			    			FMLLog.finer("Using the latest version ["+ getVersion() +"] for Minecraft " + mcVersion);
			    			currentVersion = EnumUpdateState.CURRENT;
			    			return;
			    		}
		    		}
		    	}
		    }

		    FMLLog.warning("Using outdated version ["+ getVersion() + "] for Minecraft " + mcVersion + ". Consider updating.");
		    currentVersion = EnumUpdateState.OUTDATED;

		} 
		
		catch (Exception e) 
		{
			e.printStackTrace();
			FMLLog.warning("Unable to read from remote version authority.");
			currentVersion = EnumUpdateState.CONNECTION_ERROR;
		}
	}

}
