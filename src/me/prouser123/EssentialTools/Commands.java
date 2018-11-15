package me.prouser123.EssentialTools;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.libs.jline.internal.Log;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import net.md_5.bungee.api.ChatColor;

import me.prouser123.EssentialTools.Main;

// Import GUIs
import me.prouser123.EssentialTools.gui.Admin;
import me.prouser123.EssentialTools.gui.Public;

public class Commands implements CommandExecutor {
	
	public static class enabled {
		public static boolean adminGUI;
		public static boolean publicGUI;
		public static boolean nightVision;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if (cmd.getName().equalsIgnoreCase("etools")) {
    		if (args.length == 0) {
    			sender.sendMessage(Main.prefix.chat + "You are running EssentialTools " + Main.version);
        		return true;
    		}
    		else if (args.length == 1) {
    			if (args[0].equalsIgnoreCase("status")) {
    				
    				String statusMessage = "";
    				
    				if (enabled.adminGUI) {
    					statusMessage += (ChatColor.GREEN + "Admin GUI");
    				} else {
    					statusMessage += (ChatColor.RED + "Admin GUI");
    				}
    				
    				statusMessage += ChatColor.WHITE + " | ";
    				
    				if (enabled.publicGUI) {
    					statusMessage += (ChatColor.GREEN + "Public GUI");
    				} else {
    					statusMessage += (ChatColor.RED + "Public GUI");
    				}
    				
    				statusMessage += ChatColor.WHITE + " | ";
    				
    				if (enabled.nightVision) {
    					statusMessage += (ChatColor.GREEN + "Night Vision");
    				} else {
    					statusMessage += (ChatColor.RED + "Night Vision");
    				}
    				
    				sender.sendMessage(Main.prefix.chat + "Enabled Features: " + statusMessage);
    			}
    		}
    	}
    	
    	else if (cmd.getName().equalsIgnoreCase("admin")){
    		Player player = (Player) sender;
    		player.openInventory(Admin.inv);
    		Log.info(Main.prefix.log + "Opened Inventory | Admin | " + player.getName().toString());
    		return true;
    	}
    	
    	else if (cmd.getName().equalsIgnoreCase("menu")){
    		Player player = (Player) sender;
    		player.openInventory(Public.inv);
    		Log.info(Main.prefix.log + "Opened Inventory | Public | " + player.getName().toString());
    		return true;
    	}
    	
    	else if (cmd.getName().equalsIgnoreCase("nv")){
    		// Check if running in-game
    		if(!(sender instanceof Player)) {
    			sender.sendMessage(Main.prefix.chat + "This command must be run in-game.");
    		}
    		
    		Player player = (Player) sender;
    		
    		// Disable Night Vision if player has the effect
    		if (player.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
    			player.removePotionEffect(PotionEffectType.NIGHT_VISION);
    			player.sendMessage(Main.prefix.chat + "Night Vision Disabled");
    		// Enable Night Vision as player does not have it
    		} else {
    			player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 100000, 2));
    			player.sendMessage(Main.prefix.chat + "Night Vision Enabled");
    		}
    		return true;
    	}
		return true;
    }
}
