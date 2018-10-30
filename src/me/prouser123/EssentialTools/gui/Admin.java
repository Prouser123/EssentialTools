package me.prouser123.EssentialTools.gui;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.prouser123.EssentialTools.Main;

public class Admin {
	
	public static Inventory inv = Bukkit.createInventory(null, 9, "Admin Tools");
	
	
	// Settings class from config
	public static class settings {
		
		// Classes for each item
		public static class stop {
			
			// Item to stop server
			public static int position;
			public static String name;
			public static String lore;
		}
		
		public static class restart {
			public static int position;
			public static String name;
			public static String lore;
		}
		
		public static class serverinfo {
			public static int position;
			public static String name;
			public static String lore;
		}

		public static class survival {
			public static int position;
			public static String name;
			public static String lore;
		}

		public static class creative {
			public static int position;
			public static String name;
			public static String lore;
		}

		public static class vanish {
			public static int position;
			public static String name;
			public static String lore;
		}

		public static class worldedit {
			public static int position;
			public static String name;
			public static String lore;
		}
	}
	
	static void setup() {
		// Create an ItemStack
		ItemStack itemStop = new ItemStack(Material.BARRIER);
		// Get the item's meta
		ItemMeta metaStop = itemStop.getItemMeta();
		// Set display name
		metaStop.setDisplayName(settings.stop.name);
		// Set lore
		metaStop.setLore(Arrays.asList(settings.stop.lore));
		// Set the meta
		itemStop.setItemMeta(metaStop);
		// Add the item to the inventory
		inv.setItem(settings.stop.position, itemStop);
	}
}
