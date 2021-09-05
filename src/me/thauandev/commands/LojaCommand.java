package me.thauandev.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thauandev.bans.API;

public class LojaCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("loja") || cmd.getName().equalsIgnoreCase("store")) {
			if(args.length == 0) {
				API.sendMsg(p, " ");
				API.sendMsg(p, "§c§lSPEED§f§lMC §fCompre pacotes de §a§lVIP §fou §9§lKITS §facessando: §7(§cspeedmc.buycraft.net§7)");

			}
		}
		return false;
	}
}
