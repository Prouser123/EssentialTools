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
    		Utils.Config.getInt(Admin.settings.stop.position, "adminGUI.items.stop.postion", getConfig(), pluginName);
    		Utils.Config.getString(Admin.settings.stop.name, "adminGUI.items.stop.name", getConfig(), pluginName);
    		Utils.Config.getString(Admin.settings.stop.lore, "adminGUI.items.stop.lore", getConfig(), pluginName);
    		
    		// AdminGUI Restart
    		Utils.Config.getInt(Admin.settings.restart.position, "adminGUI.items.restart.postion", getConfig(), pluginName);
    		Utils.Config.getString(Admin.settings.restart.name, "adminGUI.items.restart.name", getConfig(), pluginName);
    		Utils.Config.getString(Admin.settings.restart.lore, "adminGUI.items.restart.lore", getConfig(), pluginName);

    		// AdminGUI Serverinfo
    		Utils.Config.getInt(Admin.settings.serverinfo.position, "adminGUI.items.serverinfo.postion", getConfig(), pluginName);
    		Utils.Config.getString(Admin.settings.serverinfo.name, "adminGUI.items.serverinfo.name", getConfig(), pluginName);
    		Utils.Config.getString(Admin.settings.serverinfo.lore, "adminGUI.items.serverinfo.lore", getConfig(), pluginName);

    		// AdminGUI Survival Gamemode
    		Utils.Config.getInt(Admin.settings.survival.position, "adminGUI.items.survival.postion", getConfig(), pluginName);
    		Utils.Config.getString(Admin.settings.survival.name, "adminGUI.items.survival.name", getConfig(), pluginName);
    		Utils.Config.getString(Admin.settings.survival.lore, "adminGUI.items.survival.lore", getConfig(), pluginName);
    		
    		// AdminGUI Creative Gamemode
    		Utils.Config.getInt(Admin.settings.creative.position, "adminGUI.items.creative.postion", getConfig(), pluginName);
    		Utils.Config.getString(Admin.settings.creative.name, "adminGUI.items.creative.name", getConfig(), pluginName);
    		Utils.Config.getString(Admin.settings.creative.lore, "adminGUI.items.creative.lore", getConfig(), pluginName);

    		// AdminGUI Vanish
    		Utils.Config.getInt(Admin.settings.vanish.position, "adminGUI.items.vanish.postion", getConfig(), pluginName);
    		Utils.Config.getString(Admin.settings.vanish.name, "adminGUI.items.vanish.name", getConfig(), pluginName);
    		Utils.Config.getString(Admin.settings.vanish.lore, "adminGUI.items.vanish.lore", getConfig(), pluginName);

    		// AdminGUI Worldedit
    		Utils.Config.getInt(Admin.settings.worldedit.position, "adminGUI.items.worldedit.postion", getConfig(), pluginName);
    		Utils.Config.getString(Admin.settings.worldedit.name, "adminGUI.items.worldedit.name", getConfig(), pluginName);
    		Utils.Config.getString(Admin.settings.worldedit.lore, "adminGUI.items.worldedit.lore", getConfig(), pluginName);
        }
    	
    	private void publicGUI() {
    		// Public GUI - Auction House
    		Utils.Config.getInt(Public.settings.auctionhouse.position, "publicGUI.items.auctionhouse.position", getConfig(), pluginName);
    		Utils.Config.getString(Public.settings.auctionhouse.name, "publicGUI.items.auctionhouse.name", getConfig(), pluginName);
    		Utils.Config.getString(Public.settings.auctionhouse.lore, "publicGUI.items.auctionhouse.lore", getConfig(), pluginName);
        	
    		// Public GUI - Spawn
    		Utils.Config.getInt(Public.settings.spawn.position, "publicGUI.items.spawn.position", getConfig(), pluginName);
    		Utils.Config.getString(Public.settings.spawn.name, "publicGUI.items.spawn.name", getConfig(), pluginName);
    		Utils.Config.getString(Public.settings.spawn.lore, "publicGUI.items.spawn.lore", getConfig(), pluginName);

    		// Public GUI - Faction Home
    		Utils.Config.getInt(Public.settings.fhome.position, "publicGUI.items.fhome.position", getConfig(), pluginName);
    		Utils.Config.getString(Public.settings.fhome.name, "publicGUI.items.fhome.name", getConfig(), pluginName);
    		Utils.Config.getString(Public.settings.fhome.lore, "publicGUI.items.fhome.lore", getConfig(), pluginName);

    		// Public GUI - Wild
    		Utils.Config.getInt(Public.settings.wild.position, "publicGUI.items.wild.position", getConfig(), pluginName);
    		Utils.Config.getString(Public.settings.wild.name, "publicGUI.items.wild.name", getConfig(), pluginName);
    		Utils.Config.getString(Public.settings.wild.lore, "publicGUI.items.wild.lore", getConfig(), pluginName);

    		// Public GUI - Ender Chest
    		Utils.Config.getInt(Public.settings.echest.position, "publicGUI.items.echest.position", getConfig(), pluginName);
    		Utils.Config.getString(Public.settings.echest.name, "publicGUI.items.echest.name", getConfig(), pluginName);
    		Utils.Config.getString(Public.settings.echest.lore, "publicGUI.items.echest.lore", getConfig(), pluginName);
    	}
    }
    
}
