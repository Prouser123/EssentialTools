package me.prouser123.essentialtools;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.prouser123.essentialtools.Commands;
import me.prouser123.essentialtools.ConstructTabCompleter;
import me.prouser123.essentialtools.gui.Admin;
import me.prouser123.essentialtools.gui.Public;

import me.prouser123.essentialtools.Tools.EChat;

// Import KodiCore Utils
import me.prouser123.kodicore.Utils;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin {
	
	// Instance
	private static Main instance;
	
	// Version string to use in commands
	public static String version;
	
	// Prefixes
	public static class prefix {
		public static String log = "[EssentialTools] ";
		public static String chat;
		
	}
	
	// Plugin Name for KodiCore getConfig
	String pluginName = getDescription().getName();

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
    	//File file = new File(getDataFolder(), "config.yml");
    	EChat.log("Config file found.");
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
    		EChat.log("Enabled AdminGUI.");
    		
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
    		EChat.log("Enabled PublicGUI.");
    		
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
    		EChat.log("Enabled Night Vision.");
    	} else {
    		Commands.enabled.nightVision = false;
    		getCommand("nv").setExecutor(null);
    	}
    }
    
    private class getConfigCalls {
    	
    	private void adminGUI() {
    		// AdminGUI Stop
    		Admin.settings.stop.position = Utils.Config.getInt("adminGUI.items.stop.position", getConfig(), pluginName);
    		Admin.settings.stop.name = Utils.Config.getString("adminGUI.items.stop.name", getConfig(), pluginName);
    		Admin.settings.stop.lore = Utils.Config.getString("adminGUI.items.stop.lore", getConfig(), pluginName);
    		
    		// AdminGUI Restart
    		Admin.settings.restart.position = Utils.Config.getInt("adminGUI.items.restart.position", getConfig(), pluginName);
    		Admin.settings.restart.name = Utils.Config.getString("adminGUI.items.restart.name", getConfig(), pluginName);
    		Admin.settings.restart.lore = Utils.Config.getString("adminGUI.items.restart.lore", getConfig(), pluginName);

    		// AdminGUI Serverinfo
    		Admin.settings.serverinfo.position = Utils.Config.getInt("adminGUI.items.serverinfo.position", getConfig(), pluginName);
    		Admin.settings.serverinfo.name = Utils.Config.getString("adminGUI.items.serverinfo.name", getConfig(), pluginName);
    		Admin.settings.serverinfo.lore = Utils.Config.getString("adminGUI.items.serverinfo.lore", getConfig(), pluginName);

    		// AdminGUI Survival Gamemode
    		Admin.settings.survival.position = Utils.Config.getInt("adminGUI.items.survival.position", getConfig(), pluginName);
    		Admin.settings.survival.name = Utils.Config.getString("adminGUI.items.survival.name", getConfig(), pluginName);
    		Admin.settings.survival.lore = Utils.Config.getString("adminGUI.items.survival.lore", getConfig(), pluginName);
    		
    		// AdminGUI Creative Gamemode
    		Admin.settings.creative.position = Utils.Config.getInt("adminGUI.items.creative.position", getConfig(), pluginName);
    		Admin.settings.creative.name = Utils.Config.getString("adminGUI.items.creative.name", getConfig(), pluginName);
    		Admin.settings.creative.lore = Utils.Config.getString("adminGUI.items.creative.lore", getConfig(), pluginName);

    		// AdminGUI Vanish
    		Admin.settings.vanish.position = Utils.Config.getInt("adminGUI.items.vanish.position", getConfig(), pluginName);
    		Admin.settings.vanish.name = Utils.Config.getString("adminGUI.items.vanish.name", getConfig(), pluginName);
    		Admin.settings.vanish.lore = Utils.Config.getString("adminGUI.items.vanish.lore", getConfig(), pluginName);

    		// AdminGUI Worldedit
    		Admin.settings.worldedit.position = Utils.Config.getInt("adminGUI.items.worldedit.position", getConfig(), pluginName);
    		Admin.settings.worldedit.name = Utils.Config.getString("adminGUI.items.worldedit.name", getConfig(), pluginName);
    		Admin.settings.worldedit.lore = Utils.Config.getString("adminGUI.items.worldedit.lore", getConfig(), pluginName);
        }
    	
    	private void publicGUI() {
    		// Public GUI - Auction House
    		Public.settings.auctionhouse.position = Utils.Config.getInt("publicGUI.items.auctionhouse.position", getConfig(), pluginName);
    		Public.settings.auctionhouse.name = Utils.Config.getString("publicGUI.items.auctionhouse.name", getConfig(), pluginName);
    		Public.settings.auctionhouse.lore = Utils.Config.getString("publicGUI.items.auctionhouse.lore", getConfig(), pluginName);
        	
    		// Public GUI - Spawn
    		Public.settings.spawn.position = Utils.Config.getInt("publicGUI.items.spawn.position", getConfig(), pluginName);
    		Public.settings.spawn.name = Utils.Config.getString("publicGUI.items.spawn.name", getConfig(), pluginName);
    		Public.settings.spawn.lore = Utils.Config.getString("publicGUI.items.spawn.lore", getConfig(), pluginName);

    		// Public GUI - Faction Home
    		Public.settings.fhome.position = Utils.Config.getInt("publicGUI.items.fhome.position", getConfig(), pluginName);
    		Public.settings.fhome.name = Utils.Config.getString("publicGUI.items.fhome.name", getConfig(), pluginName);
    		Public.settings.fhome.lore = Utils.Config.getString("publicGUI.items.fhome.lore", getConfig(), pluginName);

    		// Public GUI - Wild
    		Public.settings.wild.position = Utils.Config.getInt("publicGUI.items.wild.position", getConfig(), pluginName);
    		Public.settings.wild.name = Utils.Config.getString("publicGUI.items.wild.name", getConfig(), pluginName);
    		Public.settings.wild.lore = Utils.Config.getString("publicGUI.items.wild.lore", getConfig(), pluginName);

    		// Public GUI - Ender Chest
    		Public.settings.echest.position = Utils.Config.getInt("publicGUI.items.echest.position", getConfig(), pluginName);
    		Public.settings.echest.name = Utils.Config.getString("publicGUI.items.echest.name", getConfig(), pluginName);
    		Public.settings.echest.lore = Utils.Config.getString("publicGUI.items.echest.lore", getConfig(), pluginName);
    	}
    }
    
}
