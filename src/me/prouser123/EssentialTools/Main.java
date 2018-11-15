package me.prouser123.EssentialTools;

import java.io.File;

import org.bukkit.craftbukkit.libs.jline.internal.Log;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

// Import other plugin Scripts
import me.prouser123.EssentialTools.ConstructTabCompleter;
import me.prouser123.EssentialTools.Commands;

// Import GUIs
import me.prouser123.EssentialTools.gui.Admin;
import me.prouser123.EssentialTools.gui.Public;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin {
	
	// Instance
	private static Main instance;
	
	// Prefixes
	public static class prefix {
		public static String log = "[EssentialTools] ";
		public static String chat;
		
	}
	
	// Version string to use in commands
	public static String version;

	// On Enable
	@Override
    public void onEnable() {
		// Instance
		instance = this;
		
		// Get version
		version = getDescription().getVersion();
		
		// Set chat prefix
		prefix.chat = ChatColor.WHITE + "[" + ChatColor.GOLD + getConfig().getString("chatPrefix") + ChatColor.WHITE + "] ";
		setupConfig();
		activateCommands();
		//getInventoryConfig();
		PluginManager pm = this.getServer().getPluginManager();
		// Register Listners for Inventory Click Events
        pm.registerEvents(new Admin(), this);
        pm.registerEvents(new Public(), this);
    }
   
    @Override
    public void onDisable() {
    	// On Disable
    }
    
    // Instance
    public static Main inst() {
    	  return instance;
    	}
    
    // Function to setup and load the config.yml file
    public void setupConfig() {
    	// Get config
    	getConfig().options().copyDefaults(true);
    	saveDefaultConfig();
    	reloadConfig();
    	// Load file
    	File file = new File(getDataFolder(), "config.yml");
    	Log.info(prefix.log + "Config file found.");
    }
    
    // Function to activate and enable commands
    public void activateCommands() {
    	// Set the command executor to Commands.java
    	getCommand("etools").setExecutor(new Commands());
    	getCommand("etools").setTabCompleter(new ConstructTabCompleter());
    	
    	// Check if AdminGUI is enabled
    	if (getConfig().getString("adminGUI.enabled").equals("true")) {
    		
    		// Set command executor
    		getCommand("admin").setExecutor(new Commands());
    		Log.info(prefix.log + "Enabled AdminGUI.");
    		
    		// Get / Set variables
    		Commands.enabled.adminGUI = true;
    		new getConfigCalls().adminGUI();
    		
    		// Call inventory setup
    		Admin.setup();
    	} else {
    		Commands.enabled.adminGUI = false;
    		getCommand("admin").setExecutor(null);
    	}
    	
    	// Check if PublicGUI is enabled
    	if (getConfig().getString("publicGUI.enabled").equals("true")) {
    		
    		// Set command executor
    		getCommand("menu").setExecutor(new Commands());
    		Log.info(prefix.log + "Enabled PublicGUI.");
    		
    		// Get / Set variables
    		Commands.enabled.publicGUI = true;
    		new getConfigCalls().publicGUI();
    		
    		// Call inventory setup
    		Public.setup();
    	} else {
    		Commands.enabled.publicGUI = false;
    		getCommand("menu").setExecutor(null);
    	}
    	
    	// Check if Night Vision is enabled
    	if (getConfig().getString("nightvision.enabled").equals("true")) {
    		
    		// Set command executor
    		getCommand("nv").setExecutor(new Commands());
    		
    		// Set variable for status page
    		Commands.enabled.nightVision = true;
    		
    		// Log to console
    		Log.info(prefix.log + "Enabled Night Vision.");
    	} else {
    		Commands.enabled.nightVision = false;
    		getCommand("nv").setExecutor(null);
    	}
    }
    
    class getConfigCalls {
    	
    	void adminGUI() {
        	
        	// AdminGUI Stop
        	Admin.settings.stop.position = getConfig().getInt("adminGUI.items.stop.position");
        	Admin.settings.stop.name = getConfig().getString("adminGUI.items.stop.name");
        	Admin.settings.stop.lore = getConfig().getString("adminGUI.items.stop.lore");

        	// AdminGUI Restart
        	Admin.settings.restart.position = getConfig().getInt("adminGUI.items.restart.position");
        	Admin.settings.restart.name = getConfig().getString("adminGUI.items.restart.name");
        	Admin.settings.restart.lore = getConfig().getString("adminGUI.items.restart.lore");

        	// AdminGUI Serverinfo
        	Admin.settings.serverinfo.position = getConfig().getInt("adminGUI.items.serverinfo.position");
        	Admin.settings.serverinfo.name = getConfig().getString("adminGUI.items.serverinfo.name");
        	Admin.settings.serverinfo.lore = getConfig().getString("adminGUI.items.serverinfo.lore");

        	// AdminGUI Survival Gamemode
        	Admin.settings.survival.position = getConfig().getInt("adminGUI.items.survival.position");
        	Admin.settings.survival.name = getConfig().getString("adminGUI.items.survival.name");
        	Admin.settings.survival.lore = getConfig().getString("adminGUI.items.survival.lore");

        	// AdminGUI Creative Gamemode
        	Admin.settings.creative.position = getConfig().getInt("adminGUI.items.creative.position");
        	Admin.settings.creative.name = getConfig().getString("adminGUI.items.creative.name");
        	Admin.settings.creative.lore = getConfig().getString("adminGUI.items.creative.lore");

        	// AdminGUI Vanish
        	Admin.settings.vanish.position = getConfig().getInt("adminGUI.items.vanish.position");
        	Admin.settings.vanish.name = getConfig().getString("adminGUI.items.vanish.name");
        	Admin.settings.vanish.lore = getConfig().getString("adminGUI.items.vanish.lore");

        	// AdminGUI Worldedit
        	Admin.settings.worldedit.position = getConfig().getInt("adminGUI.items.worldedit.position");
        	Admin.settings.worldedit.name = getConfig().getString("adminGUI.items.worldedit.name");
        	Admin.settings.worldedit.lore = getConfig().getString("adminGUI.items.worldedit.lore");
        }
    	
    	void publicGUI() {

        	// Public GUI - Auction House
        	Public.settings.auctionhouse.position = getConfig().getInt("publicGUI.items.auctionhouse.position");
        	Public.settings.auctionhouse.name = getConfig().getString("publicGUI.items.auctionhouse.name");
        	Public.settings.auctionhouse.lore = getConfig().getString("publicGUI.items.auctionhouse.lore");
        	
        	// Public GUI - Spawn
        	Public.settings.spawn.position = getConfig().getInt("publicGUI.items.spawn.position");
        	Public.settings.spawn.name = getConfig().getString("publicGUI.items.spawn.name");
        	Public.settings.spawn.lore = getConfig().getString("publicGUI.items.spawn.lore");

        	// Public GUI - Faction Home
        	Public.settings.fhome.position = getConfig().getInt("publicGUI.items.fhome.position");
        	Public.settings.fhome.name = getConfig().getString("publicGUI.items.fhome.name");
        	Public.settings.fhome.lore = getConfig().getString("publicGUI.items.fhome.lore");

        	// Public GUI - Wild
        	Public.settings.wild.position = getConfig().getInt("publicGUI.items.wild.position");
        	Public.settings.wild.name = getConfig().getString("publicGUI.items.wild.name");
        	Public.settings.wild.lore = getConfig().getString("publicGUI.items.wild.lore");

        	// Public GUI - Ender Chest
        	Public.settings.echest.position = getConfig().getInt("publicGUI.items.echest.position");
        	Public.settings.echest.name = getConfig().getString("publicGUI.items.echest.name");
        	Public.settings.echest.lore = getConfig().getString("publicGUI.items.echest.lore");
    	}
    }
    
}
