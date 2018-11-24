package me.prouser123.essentialtools.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.prouser123.essentialtools.Tools;

public class Admin implements Listener {
	
	public static Inventory inv = Bukkit.createInventory(null, 9, "Admin Tools");
	
	
	// Settings class from config
	public static class settings {
		
		// Classes for each item
		public static class stop {
			public static int position;
			public static String name;
			public static String lore;
			public static Material material = Material.BARRIER;
			public static String command = "stop";
		}
		
		public static class restart {
			public static int position;
			public static String name;
			public static String lore;
			public static Material material = Material.REDSTONE_TORCH_ON;
			public static String command = "restart";
		}
		
		public static class serverinfo {
			public static int position;
			public static String name;
			public static String lore;
			public static Material material = Material.ENDER_PEARL;
			public static String command = "gc";
		}

		public static class survival {
			public static int position;
			public static String name;
			public static String lore;
			public static Material material = Material.STONE_SWORD;
			public static String command = "gms";
		}

		public static class creative {
			public static int position;
			public static String name;
			public static String lore;
			public static Material material = Material.DIAMOND_SWORD;
			public static String command = "gmc";
		}

		public static class vanish {
			public static int position;
			public static String name;
			public static String lore;
			public static Material material = Material.POTION;
			public static String command = "v";
		}

		public static class worldedit {
			public static int position;
			public static String name;
			public static String lore;
			public static Material material = Material.WOOD_AXE;
			public static String command = "/wand";
		}
	}
	
	public static void setup() {
		// Use Inventory Tools
		Tools.Inventory.addItem(inv, settings.stop.material, settings.stop.name, settings.stop.lore, settings.stop.position);
		Tools.Inventory.addItem(inv, settings.restart.material, settings.restart.name, settings.restart.lore, settings.restart.position);
		Tools.Inventory.addItem(inv, settings.serverinfo.material, settings.serverinfo.name, settings.serverinfo.lore, settings.serverinfo.position);
		Tools.Inventory.addItem(inv, settings.survival.material, settings.survival.name, settings.survival.lore, settings.survival.position);
		Tools.Inventory.addItem(inv, settings.creative.material, settings.creative.name, settings.creative.lore, settings.creative.position);
		Tools.Inventory.addItem(inv, settings.vanish.material, settings.vanish.name, settings.vanish.lore, settings.vanish.position);
		Tools.Inventory.addItem(inv, settings.worldedit.material, settings.worldedit.name, settings.worldedit.lore, settings.worldedit.position);
		return;
	}
	
	@EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
    	Player player = (Player) event.getWhoClicked();
    	ItemStack clicked = event.getCurrentItem();
    	Inventory inventory = event.getInventory();
    	// Log.info(Main.prefix.log + "Inventory Click Event | Admin | " + player.getName());
    	if (inventory.getName().equals(inv.getName())) {
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
