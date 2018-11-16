package me.prouser123.essentialtools;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class ConstructTabCompleter implements TabCompleter {

	@Override
	public List <String> onTabComplete(CommandSender sender, Command cmd, String alias, String[] args) {
		if (cmd.getName().equalsIgnoreCase("etools") && args.length >= 1){
			List<String> list = Arrays.asList("status", "reload");
			return list;
		}
		// TODO Auto-generated method stub
		return null;
	}
	
}
