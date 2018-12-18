package me.prouser123.essentialtools.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.prouser123.kodicore.Utils;

public class Admin implements Listener {
	
	//public static Inventory inv = Bukkit.createInventory(null, 9, "Admin Tools");
	
	
	// Settings class from config
	public static class settings {
		
		// Classes for each item
		public static class stop {
			public static int position;
			public static String name;
			public static String lore;
			public static Material material = Material.BARRIER;
			public static String command = "stop";
			public static String permission = "minecraft.command.stop";
		}
		
		public static class restart {
			public static int position;
			public static String name;
			public static String lore;
			public static Material material = Material.REDSTONE_TORCH_ON;
			public static String command = "restart";
			public static String permission = "bukkit.command.reload";
		}
		
		public static class serverinfo {
			public static int position;
			public static String name;
			public static String lore;
			public static Material material = Material.ENDER_PEARL;
			public static String command = "gc";
			public static String permission = "essentials.gc";
		}

		public static class survival {
			public static int position;
			public static String name;
			public static String lore;
			public static Material material = Material.STONE_SWORD;
			public static String command = "gms";
			public static String permission = "essentials.gamemode.survival";
		}

		public static class creative {
			public static int position;
			public static String name;
			public static String lore;
			public static Material material = Material.DIAMOND_SWORD;
			public static String command = "gmc";
			public static String permission = "essentials.gamemode.creative";
		}

		public static class vanish {
			public static int position;
			public static String name;
			public static String lore;
			public static Material material = Material.POTION;
			public static String command = "v";
			public static String permission = "essentials.vanish";
		}

		public static class worldedit {
			public static int position;
			public static String name;
			public static String lore;
			public static Material material = Material.WOOD_AXE;
			public static String command = "/wand";
			public static String permission = "worldedit.wand";
		}
	}
	
	public static void setupAndOpenForPlayer(Player player) {
		
		Inventory inv = Bukkit.createInventory(null, 9, "Admin Tools");
		
		setup(inv);
		
		// If player can't use the command, edit the item name and lore to match.
		
		// Stop
		if (!player.hasPermission(settings.stop.permission)) {
			Utils.addInventoryItem(inv, settings.stop.material, (ChatColor.STRIKETHROUGH.toString() + ChatColor.RED + settings.stop.name), "You don't have permission!", settings.stop.position);
		}
		
		// Restart
		if (!player.hasPermission(settings.restart.permission)) {
			Utils.addInventoryItem(inv, settings.restart.material, (ChatColor.STRIKETHROUGH.toString() + ChatColor.RED + settings.restart.name), "You don't have permission!", settings.restart.position);
		}
		
		// Serverinfo
		if (!player.hasPermission(settings.serverinfo.permission)) {
			Utils.addInventoryItem(inv, settings.serverinfo.material, (ChatColor.STRIKETHROUGH.toString() + ChatColor.RED + settings.serverinfo.name), "You don't have permission!", settings.serverinfo.position);
		}
		
		// Survival
		if (!player.hasPermission(settings.survival.permission)) {
			Utils.addInventoryItem(inv, settings.survival.material, (ChatColor.STRIKETHROUGH.toString() + ChatColor.RED + settings.survival.name), "You don't have permission!", settings.survival.position);
		}
		
		// Creative
		if (!player.hasPermission(settings.creative.permission)) {
			Utils.addInventoryItem(inv, settings.creative.material, (ChatColor.STRIKETHROUGH.toString() + ChatColor.RED + settings.creative.name), "You don't have permission!", settings.creative.position);
		}
		
		// Vanish
		if (!player.hasPermission(settings.vanish.permission)) {
			Utils.addInventoryItem(inv, settings.vanish.material, (ChatColor.STRIKETHROUGH.toString() + ChatColor.RED + settings.vanish.name), "You don't have permission!", settings.vanish.position);
		}
		
		// Worldedit
		if (!player.hasPermission(settings.worldedit.permission)) {
			Utils.addInventoryItem(inv, settings.worldedit.material, (ChatColor.STRIKETHROUGH.toString() + ChatColor.RED + settings.worldedit.name), "You don't have permission!", settings.worldedit.position);
		}
		
		player.openInventory(inv);
	}
	
	public static void setup(Inventory inv) {
		// Use Inventory Tools (KodiCore)
		Utils.addInventoryItem(inv, settings.stop.material, settings.stop.name, settings.stop.lore, settings.stop.position);
		Utils.addInventoryItem(inv, settings.restart.material, settings.restart.name, settings.restart.lore, settings.restart.position);
		Utils.addInventoryItem(inv, settings.serverinfo.material, settings.serverinfo.name, settings.serverinfo.lore, settings.serverinfo.position);
		Utils.addInventoryItem(inv, settings.survival.material, settings.survival.name, settings.survival.lore, settings.survival.position);
		Utils.addInventoryItem(inv, settings.creative.material, settings.creative.name, settings.creative.lore, settings.creative.position);
		Utils.addInventoryItem(inv, settings.vanish.material, settings.vanish.name, settings.vanish.lore, settings.vanish.position);
		Utils.addInventoryItem(inv, settings.worldedit.material, settings.worldedit.name, settings.worldedit.lore, settings.worldedit.position);
		return;
	}
	
	@EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
    	Player player = (Player) event.getWhoClicked();
    	ItemStack clicked = event.getCurrentItem();
    	Inventory inventory = event.getInventory();
    	// Log.info(Main.prefix.log + "Inventory Click Event | Admin | " + player.getName());
    	if (inventory.getName().equals("Admin Tools")) {
    		// Stop command
    		if (clicked.getType() == settings.stop.material) {
    			event.setCancelled(true);
    			player.closeInventory();
    			player.performCommand(settings.stop.command);
    		
    		// Restart command
    		} else if (clicked.getType() == settings.restart.material) {
    			event.setCancelled(true);
    			player.closeInventory();
    			player.performCommand(settings.restart.command);
    			
    		// Serverinfo command
    		} else if (clicked.getType() == settings.serverinfo.material) {
    			event.setCancelled(true);
    			player.closeInventory();
    			player.performCommand(settings.serverinfo.command);
    		
    		// Survival command
    		} else if (clicked.getType() == settings.survival.material) {
     			event.setCancelled(true);
     			player.closeInventory();
     			player.performCommand(settings.survival.command);
     		
     		// Creative command
    		} else if (clicked.getType() == settings.creative.material) {
      			event.setCancelled(true);
      			player.closeInventory();
      			player.performCommand(settings.creative.command);
      		
      		// Vanish command
    		} else if (clicked.getType() == settings.vanish.material) {
      			event.setCancelled(true);
      			player.closeInventory();
      			player.performCommand(settings.vanish.command);
      		
      		// Worldedit command
    		} else if (clicked.getType() == settings.worldedit.material) {
       			event.setCancelled(true);
       			player.closeInventory();
       			player.performCommand(settings.worldedit.command);
       		}
     		
    	}
    }
}
