package me.prouser123.essentialtools;

import org.bukkit.craftbukkit.libs.jline.internal.Log;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.prouser123.essentialtools.Commands;
import me.prouser123.essentialtools.ConstructTabCompleter;
import me.prouser123.essentialtools.gui.Admin;
import me.prouser123.essentialtools.gui.Public;

import me.prouser123.essentialtools.Tools.EChat;

// Import KodiCore Utils
import me.prouser123.kodicore.Utils;
import me.prouser123.kodicore.discord.Discord;
import me.prouser123.kodicore.discord.commands.CopyOwnerAvatar;
import me.prouser123.kodicore.discord.commands.ServerInfo;
import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin {
	
	// Instance
	private static Main instance;
	
	// Version and Name string to use in commands
	public static String version;
	public static String name;
	
	// Prefixes
	public static class prefix {
		public static String log = "[EssentialTools] ";
		public static String chat;
		
	}

	// On Enable
	@Override
    public void onEnable() {
		// Instance
		instance = this;
		
		// Get version & Name
		version = getDescription().getVersion();
		name = getDescription().getName();
		
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
    	try {
    		Discord.api.disconnect();
    	} catch (Exception e) {
    		Log.warn("Coudn't disconnect from the Discord API.");
    	}
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
    	
    	// Check if Night Vision is enabled
    	if (getConfig().getString("discord.enabled").equals("true")) {
    		
    		// Set variable for status page
    		Commands.enabled.discord = true;
    		
    		// Setup Discord
            new Discord(getConfig().getString("discord.token"));
    		Discord.createListener.discordCommand("!ping", "pong", Discord.api);
    		//Discord.api.addMessageCreateListener(new CopyOwnerAvatar("!getOwnerAvatar"));
    		Discord.api.addMessageCreateListener(new ServerInfo());
    		Discord.api.addMessageCreateListener(new CopyOwnerAvatar("!getOwnerAvatar"));
    		Discord.createListener.discordToConsoleCommand("!gc", "gc", Discord.api);
    		// Log to console
    		
    		EChat.log("Enabled the Discord Bot.");
    	} else {
    		Commands.enabled.discord = false;
    	}
    }
    
    private class getConfigCalls {
    	
    	private void adminGUI() {
    		// AdminGUI Stop
    		Admin.settings.stop.position = Utils.Config.getInt("adminGUI.items.stop.position", getConfig(), name);
    		Admin.settings.stop.name = Utils.Config.getString("adminGUI.items.stop.name", getConfig(), name);
    		Admin.settings.stop.lore = Utils.Config.getString("adminGUI.items.stop.lore", getConfig(), name);
    		
    		// AdminGUI Restart
    		Admin.settings.restart.position = Utils.Config.getInt("adminGUI.items.restart.position", getConfig(), name);
    		Admin.settings.restart.name = Utils.Config.getString("adminGUI.items.restart.name", getConfig(), name);
    		Admin.settings.restart.lore = Utils.Config.getString("adminGUI.items.restart.lore", getConfig(), name);

    		// AdminGUI Serverinfo
    		Admin.settings.serverinfo.position = Utils.Config.getInt("adminGUI.items.serverinfo.position", getConfig(), name);
    		Admin.settings.serverinfo.name = Utils.Config.getString("adminGUI.items.serverinfo.name", getConfig(), name);
    		Admin.settings.serverinfo.lore = Utils.Config.getString("adminGUI.items.serverinfo.lore", getConfig(), name);

    		// AdminGUI Survival Gamemode
    		Admin.settings.survival.position = Utils.Config.getInt("adminGUI.items.survival.position", getConfig(), name);
    		Admin.settings.survival.name = Utils.Config.getString("adminGUI.items.survival.name", getConfig(), name);
    		Admin.settings.survival.lore = Utils.Config.getString("adminGUI.items.survival.lore", getConfig(), name);
    		
    		// AdminGUI Creative Gamemode
    		Admin.settings.creative.position = Utils.Config.getInt("adminGUI.items.creative.position", getConfig(), name);
    		Admin.settings.creative.name = Utils.Config.getString("adminGUI.items.creative.name", getConfig(), name);
    		Admin.settings.creative.lore = Utils.Config.getString("adminGUI.items.creative.lore", getConfig(), name);

    		// AdminGUI Vanish
    		Admin.settings.vanish.position = Utils.Config.getInt("adminGUI.items.vanish.position", getConfig(), name);
    		Admin.settings.vanish.name = Utils.Config.getString("adminGUI.items.vanish.name", getConfig(), name);
    		Admin.settings.vanish.lore = Utils.Config.getString("adminGUI.items.vanish.lore", getConfig(), name);

    		// AdminGUI Worldedit
    		Admin.settings.worldedit.position = Utils.Config.getInt("adminGUI.items.worldedit.position", getConfig(), name);
    		Admin.settings.worldedit.name = Utils.Config.getString("adminGUI.items.worldedit.name", getConfig(), name);
    		Admin.settings.worldedit.lore = Utils.Config.getString("adminGUI.items.worldedit.lore", getConfig(), name);
        }
    	
    	private void publicGUI() {
    		// Public GUI - Auction House
    		Public.settings.auctionhouse.position = Utils.Config.getInt("publicGUI.items.auctionhouse.position", getConfig(), name);
    		Public.settings.auctionhouse.name = Utils.Config.getString("publicGUI.items.auctionhouse.name", getConfig(), name);
    		Public.settings.auctionhouse.lore = Utils.Config.getString("publicGUI.items.auctionhouse.lore", getConfig(), name);
        	
    		// Public GUI - Spawn
    		Public.settings.spawn.position = Utils.Config.getInt("publicGUI.items.spawn.position", getConfig(), name);
    		Public.settings.spawn.name = Utils.Config.getString("publicGUI.items.spawn.name", getConfig(), name);
    		Public.settings.spawn.lore = Utils.Config.getString("publicGUI.items.spawn.lore", getConfig(), name);

    		// Public GUI - Faction Home
    		Public.settings.fhome.position = Utils.Config.getInt("publicGUI.items.fhome.position", getConfig(), name);
    		Public.settings.fhome.name = Utils.Config.getString("publicGUI.items.fhome.name", getConfig(), name);
    		Public.settings.fhome.lore = Utils.Config.getString("publicGUI.items.fhome.lore", getConfig(), name);

    		// Public GUI - Wild
    		Public.settings.wild.position = Utils.Config.getInt("publicGUI.items.wild.position", getConfig(), name);
    		Public.settings.wild.name = Utils.Config.getString("publicGUI.items.wild.name", getConfig(), name);
    		Public.settings.wild.lore = Utils.Config.getString("publicGUI.items.wild.lore", getConfig(), name);

    		// Public GUI - Ender Chest
    		Public.settings.echest.position = Utils.Config.getInt("publicGUI.items.echest.position", getConfig(), name);
    		Public.settings.echest.name = Utils.Config.getString("publicGUI.items.echest.name", getConfig(), name);
    		Public.settings.echest.lore = Utils.Config.getString("publicGUI.items.echest.lore", getConfig(), name);
    	}
    }
    
}
