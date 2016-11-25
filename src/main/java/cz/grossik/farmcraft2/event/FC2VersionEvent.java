package cz.grossik.farmcraft2.event;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import cz.grossik.farmcraft2.Main;
import cz.grossik.farmcraft2.handler.ConfigHandler;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class FC2VersionEvent extends Thread {

	public static boolean doneChecking = false;
	public static String onlineVersion = "";
	
	public FC2VersionEvent() {
		setName("FarmCraft 2 Version Checker Thread");
		setDaemon(true);
		start();
	}
	
	public void init() {
		new FC2VersionEvent();
	}	
	
	public void run() {
		try {
			URL url = new URL("http://pastebin.com/raw/Zz75MXR8");
			BufferedReader r = new BufferedReader(new InputStreamReader(url.openStream()));
			FC2VersionEvent.onlineVersion = r.readLine();
			r.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		FC2VersionEvent.doneChecking = true;
	}
	
	@SubscribeEvent
	public void spusteni(PlayerEvent.PlayerLoggedInEvent event)
	{
		if(ConfigHandler.version == true)
		{
			if(Main.VERSION.equals(onlineVersion) == false){
				ClickEvent versionCheckChatClickEvent = new ClickEvent(ClickEvent.Action.OPEN_URL, "http://farmcraft2.8u.cz/download.php");
				Style clickableChatStyle = new Style().setClickEvent(versionCheckChatClickEvent);
				TextComponentString version = new TextComponentString(Color.UNDERLINE + "here");
				version.setStyle(clickableChatStyle);
        
				TextComponentString info = new TextComponentString(Color.GOLD + "" + Color.BOLD + "[FarmCraft 2] "+ Color.RESET + "Your current version: " + Main.VERSION + ". " + "Latest version: " + onlineVersion + ". The latest version is ");

				info.appendSibling(version);
				version.appendText(".");
        
				event.player.addChatComponentMessage(info);
			}
		} else {
			
		}
	}
	
	public enum Color
	{
	    BLACK("\u00A70"), //
	    DARK_BLUE("\u00A71"), //
	    DARK_GREEN("\u00A72"), //
	    DARK_AQUA("\u00A73"), //
	    DARK_RED("\u00A74"), //
	    DARK_PURPLE("\u00A75"), //
	    GOLD("\u00A76"), //
	    GRAY("\u00A77"), //
	    DARK_GRAY("\u00A78"), //
	    BLUE("\u00A79"), //
	    GREEN("\u00A7a"), //
	    AQUA("\u00A7b"), //
	    RED("\u00A7c"), //
	    LIGHT_PURPLE("\u00A7d"), //
	    YELLOW("\u00A7e"), //
	    WHITE("\u00A7f"), //
	 
	    STRIKE_THROUGH("\u00A7m"), //
	    UNDERLINE("\u00A7n"), //
	    BOLD("\u00A7l"), //
	    RANDOM("\u00A7k"), //
	    ITALIC("\u00A7o"), //
	    RESET("\u00A7r"); //
	 
	    public String code = "";
	 
	    private Color(String code)
	    {	 
	        this.code = code;
	    }
	 
	    @Override
	    public String toString()
	    {	 
	        return code;
	    }
	}

}
