package me.prouser123.EssentialTools;

import java.io.File;

import org.bukkit.craftbukkit.libs.jline.internal.Log;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.prouser123.EssentialTools.ConstructTabCompleter;
import me.prouser123.EssentialTools.Commands;

import me.prouser123.EssentialTools.gui.Admin;
import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin {
	
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
		// Get version
		version = getDescription().getVersion();
		
		// Set chat prefix
		prefix.chat = ChatColor.WHITE + "[" + ChatColor.GOLD + getConfig().getString("chatPrefix") + ChatColor.WHITE + "] ";
		setupConfig();
		activateCommands();
		//getInventoryConfig();
		PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(new Admin(), this);
    }
   
    @Override
    public void onDisable() {
    	// On Disable
    }
    
    // Function to setup and load the config.yml file
    public void setupConfig() {
    	// Get config
    	getConfig().options().copyDefaults(true);
    	saveDefaultConfig();
    	reloadConfig();
    	
    	// Load file
    	File file = new File(getDataFolder(), "config.yml");
    	if (!file.exists()) {
    	    Log.info(prefix.log + "config.yml not found, creating!");
    	    saveDefaultConfig();
    	} else if (file.exists()) {
    	    Log.info(prefix.log + "config.yml found, loading!");
    	}
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
    }
    
}
