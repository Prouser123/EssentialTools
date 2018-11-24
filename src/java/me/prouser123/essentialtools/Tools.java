package me.prouser123.essentialtools;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.libs.jline.internal.Log;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.prouser123.essentialtools.Main;

public class Tools {
	
	public static class EChat {
		
		// Log to console with log prefix (no colours)
		public static void log(String messages) {
			Log.info(Main.prefix.log + messages);
		}
		
		// Send message to user with chat prefix (colours)
		public static void chat(CommandSender sender, String messages) {
			sender.sendMessage(Main.prefix.chat + messages);
		}
	}
	
	public static class Inventory {
		
		// Add item to inventory (using arguments)
		public static void addItem(org.bukkit.inventory.Inventory inv, Material material, String displayName, String lore, int position) {
			// Create the ItemStack
			ItemStack stack = new ItemStack(material);
			
			// Get the item's meta
			ItemMeta meta = stack.getItemMeta();
			
			// Set the display name
			meta.setDisplayName(displayName);
			
			// Set the lore
			meta.setLore(Arrays.asList(lore));
			
			// Set the meta
			stack.setItemMeta(meta);
			
			// Add the item to the inventory
			inv.setItem(position, stack);
		}
	}
}