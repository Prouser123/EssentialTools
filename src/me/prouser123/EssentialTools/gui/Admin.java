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
		ItemStack itemRestart = new ItemStack(Material.REDSTONE_TORCH_ON);
		ItemStack itemServerinfo = new ItemStack(Material.ENDER_PEARL);
		ItemStack itemSurvival = new ItemStack(Material.STONE_SWORD);
		ItemStack itemCreative = new ItemStack(Material.DIAMOND_SWORD);
		ItemStack itemVanish = new ItemStack(Material.POTION);
		ItemStack itemWorldedit = new ItemStack(Material.WOOD_AXE);
		
		// Get the item's meta
		ItemMeta metaStop = itemStop.getItemMeta();
		ItemMeta metaRestart = itemRestart.getItemMeta();
		ItemMeta metaServerinfo = itemServerinfo.getItemMeta();
		ItemMeta metaSurvival = itemSurvival.getItemMeta();
		ItemMeta metaCreative = itemCreative.getItemMeta();
		ItemMeta metaVanish = itemVanish.getItemMeta();
		ItemMeta metaWorldedit = itemWorldedit.getItemMeta();
		
		// Set display name
		metaStop.setDisplayName(settings.stop.name);
		metaRestart.setDisplayName(settings.restart.name);
		metaServerinfo.setDisplayName(settings.serverinfo.name);
		metaSurvival.setDisplayName(settings.survival.name);
		metaCreative.setDisplayName(settings.creative.name);
		metaVanish.setDisplayName(settings.vanish.name);
		metaWorldedit.setDisplayName(settings.worldedit.name);
		
		// Set lore
		metaStop.setLore(Arrays.asList(settings.stop.lore));
		metaRestart.setLore(Arrays.asList(settings.restart.lore));
		metaServerinfo.setLore(Arrays.asList(settings.serverinfo.lore));
		metaSurvival.setLore(Arrays.asList(settings.survival.lore));
		metaCreative.setLore(Arrays.asList(settings.creative.lore));
		metaVanish.setLore(Arrays.asList(settings.vanish.lore));
		metaWorldedit.setLore(Arrays.asList(settings.worldedit.lore));
		
		// Set the meta
		itemStop.setItemMeta(metaStop);
		itemRestart.setItemMeta(metaRestart);
		itemServerinfo.setItemMeta(metaServerinfo);
		itemSurvival.setItemMeta(metaSurvival);
		itemCreative.setItemMeta(metaCreative);
		itemVanish.setItemMeta(metaVanish);
		itemWorldedit.setItemMeta(metaWorldedit);
		
		// Add the item to the inventory
		inv.setItem(settings.stop.position, itemStop);
		inv.setItem(settings.restart.position, itemRestart);
		inv.setItem(settings.serverinfo.position, itemServerinfo);
		inv.setItem(settings.survival.position, itemSurvival);
		inv.setItem(settings.creative.position, itemCreative);
		inv.setItem(settings.vanish.position, itemVanish);
		inv.setItem(settings.worldedit.position, itemWorldedit);
	}
}
