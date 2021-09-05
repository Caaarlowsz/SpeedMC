package me.thauandev.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.thauandev.menus.YoutuberMenu;

public class YoutuberCommand implements CommandExecutor, Listener {

	public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args) {

		Player p = (Player) Sender;

		if (Cmd.getName().equalsIgnoreCase("youtuber")) {

			if (Args.length == 0) {
				YoutuberMenu.inventory(p);
				return false;
			}
		}
		return false;
	}
}