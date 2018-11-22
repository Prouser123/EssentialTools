package me.prouser123.essentialtools;

import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.libs.jline.internal.Log;

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
}