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
		// Create an ItemStack
		ItemStack itemStop = new ItemStack(settings.stop.material);
		ItemStack itemRestart = new ItemStack(settings.restart.material);
		ItemStack itemServerinfo = new ItemStack(settings.serverinfo.material);
		ItemStack itemSurvival = new ItemStack(settings.survival.material);
		ItemStack itemCreative = new ItemStack(settings.creative.material);
		ItemStack itemVanish = new ItemStack(settings.vanish.material);
		ItemStack itemWorldedit = new ItemStack(settings.worldedit.material);
		
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
		
		return;
	}
	
	@EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
    	Player player = (Player) event.getWhoClicked();
    	ItemStack clicked = event.getCurrentItem();
    	Inventory inventory = event.getInventory();
    	Log.info(Main.prefix + "Inventory Clicked");
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
