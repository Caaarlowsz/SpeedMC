package me.thauandev.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thauandev.bans.API;

public class IpCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("ip") || cmd.getName().equalsIgnoreCase("servidor")) {
			if(args.length == 0) {
				API.sendMsg(p, "§c§lSPEED§f§lMC §7Você está conectado ao: §cspeedmc.desire.host");

			}
		}
		return false;
	}
}
