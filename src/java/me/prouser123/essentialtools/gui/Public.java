package me.prouser123.essentialtools.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.prouser123.kodicore.Utils;

public class Public implements Listener {
	
	public static Inventory inv = Bukkit.createInventory(null, 9, "Menu");
	
	
	// Settings class from config
	public static class settings {
		

		// Classes for each item
		public static class auctionhouse {
			public static int position;
			public static String name;
			public static String lore;
			public static Material material = Material.CHEST;
			public static String command = "ah";
		}
		
		public static class spawn {
			public static int position;
			public static String name;
			public static String lore;
			public static Material material = Material.GRASS;
			public static String command = "spawn";
		}
		
		public static class fhome {
			public static int position;
			public static String name;
			public static String lore;
			public static Material material = Material.STONE;
			public static String command = "f home";
		}
		
		public static class wild {
			public static int position;
			public static String name;
			public static String lore;
			public static Material material = Material.DIRT;
			public static String command = "wild";
		}
		
		public static class echest {
			public static int position;
			public static String name;
			public static String lore;
			public static Material material = Material.ENDER_CHEST;
			public static String command = "ec";
		}
	}
	
	public static void setup() {
		// Use Inventory Tools (KodiCore)
		Utils.addInventoryItem(inv, settings.auctionhouse.material, settings.auctionhouse.name, settings.auctionhouse.lore, settings.auctionhouse.position);
		Utils.addInventoryItem(inv, settings.spawn.material, settings.spawn.name, settings.spawn.lore, settings.spawn.position);
		Utils.addInventoryItem(inv, settings.fhome.material, settings.fhome.name, settings.fhome.lore, settings.fhome.position);
		Utils.addInventoryItem(inv, settings.wild.material, settings.wild.name, settings.wild.lore, settings.wild.position);
		Utils.addInventoryItem(inv, settings.echest.material, settings.echest.name, settings.echest.lore, settings.echest.position);
		return;
	}
	
	@EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
    	Player player = (Player) event.getWhoClicked();
    	ItemStack clicked = event.getCurrentItem();
    	Inventory inventory = event.getInventory();
    	// Log.info(Main.prefix.log + "Inventory Click Event | Public | " + player.getName());
    	if (inventory.getName().equals(inv.getName())) {
    		// Auction House command
    		if (clicked.getType() == settings.auctionhouse.material) {
    			event.setCancelled(true);
    			player.closeInventory();
    			player.performCommand(settings.auctionhouse.command);
    		
    		// Spawn command
    		} else if (clicked.getType() == settings.spawn.material) {
    			event.setCancelled(true);
    			player.closeInventory();
    			player.performCommand(settings.spawn.command);
    		
    		// F Home command
    		} else if (clicked.getType() == settings.fhome.material) {
    			event.setCancelled(true);
    			player.closeInventory();
    			player.performCommand(settings.fhome.command);
    			
    		// Wild command
    		} else if (clicked.getType() == settings.wild.material) {
    			event.setCancelled(true);
    			player.closeInventory();
    			player.performCommand(settings.wild.command); 		

    		// Ender Chest command
    		} else if (clicked.getType() == settings.echest.material) {
    			event.setCancelled(true);
    			player.closeInventory();
    			player.performCommand(settings.echest.command); 		
    		}
    	}
    }
}
