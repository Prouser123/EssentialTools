package me.prouser123.EssentialTools;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.libs.jline.internal.Log;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

import me.prouser123.EssentialTools.Main;

// Import GUIs
import me.prouser123.EssentialTools.gui.Admin;
import me.prouser123.EssentialTools.gui.Public;

public class Commands implements CommandExecutor {
	
	public static class enabled {
		public static boolean adminGUI;
		public static boolean publicGUI;
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
    				
    				sender.sendMessage(Main.prefix.chat + "Enabled CityServer Features: " + statusMessage);
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
		return true;
    }
}
