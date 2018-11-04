package me.prouser123.EssentialTools.gui;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.libs.jline.internal.Log;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.prouser123.EssentialTools.Main;

public class Public implements Listener {
	
	public static Inventory inv = Bukkit.createInventory(null, 9, "Menu");
	
	
	// Settings class from config
	public static class settings {
		
		// Classes for each item
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
	}
	
	public static void setup() {
		// Create an ItemStack
		ItemStack itemSpawn = new ItemStack(settings.spawn.material);
		ItemStack itemFhome = new ItemStack(settings.fhome.material);
		ItemStack itemWild = new ItemStack(settings.wild.material);
		
		// Get the item's meta
		ItemMeta metaSpawn = itemSpawn.getItemMeta();
		ItemMeta metaFhome = itemFhome.getItemMeta();
		ItemMeta metaWild = itemWild.getItemMeta();
		
		// Set display name
		metaSpawn.setDisplayName(settings.spawn.name);
		metaFhome.setDisplayName(settings.fhome.name);
		metaWild.setDisplayName(settings.wild.name);
		
		// Set lore
		metaSpawn.setLore(Arrays.asList(settings.spawn.lore));
		metaFhome.setLore(Arrays.asList(settings.fhome.lore));
		metaWild.setLore(Arrays.asList(settings.wild.lore));
		
		// Set the meta
		itemSpawn.setItemMeta(metaSpawn);
		itemFhome.setItemMeta(metaFhome);
		itemWild.setItemMeta(metaWild);
		
		// Add the item to the inventory
		inv.setItem(settings.spawn.position, itemSpawn);
		inv.setItem(settings.fhome.position, itemFhome);
		inv.setItem(settings.wild.position, itemWild);
		
		return;
	}
	
	@EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
    	Player player = (Player) event.getWhoClicked();
    	ItemStack clicked = event.getCurrentItem();
    	Inventory inventory = event.getInventory();
    	Log.info(Main.prefix.log + "Inventory Click Event | Public | " + player.getName());
    	if (inventory.getName().equals(inv.getName())) {
    		// Spawn command
    		if (clicked.getType() == settings.spawn.material) {
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
    		}
    	}
    }
}
