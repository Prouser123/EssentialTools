package me.prouser123.EssentialTools;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.libs.jline.internal.Log;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

import me.prouser123.EssentialTools.Main;
import me.prouser123.EssentialTools.ConfigItems;

// Import GUIs
import me.prouser123.EssentialTools.gui.Admin;

public class Commands implements CommandExecutor {
	
	public static class enabled {
		public static boolean adminGUI;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if (cmd.getName().equalsIgnoreCase("etools")) {
    		if (args.length == 0) {
    			sender.sendMessage(ConfigItems.chatPrefix + "You are running EssentialTools " + Main.version);
        		return true;
    		}
    		else if (args.length == 1) {
    			if (args[0].equalsIgnoreCase("status")) {
    				
    				String statusMessage = "";
    				
    				if (enabled.adminGUI) {
    					statusMessage += (ChatColor.GREEN + "Admin GUI");
    				}
    				else {
    					statusMessage += (ChatColor.RED + "Admin GUI");
    				}
    				
    				//statusMessage += " | ";
    				
    				sender.sendMessage(ConfigItems.chatPrefix + "Enabled CityServer Features: " + statusMessage);
    			}
    		}
    	}
    	
    	else if (cmd.getName().equalsIgnoreCase("admin")){
    		Player player = (Player) sender;
    		player.openInventory(Admin.inv);
    		Log.info(Main.logPrefix + "Opened Admin Inventory for: " + player.getName().toString());
    		return true;
    	}
		return true;
    }
}
