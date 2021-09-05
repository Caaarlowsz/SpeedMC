package me.thauandev.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thauandev.bans.API;

public class HgCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("hg") || cmd.getName().equalsIgnoreCase("hungergames")) {
			if(args.length == 0) {
				API.sendMsg(p, "§c§lSPEED§f§lMC §4§lERRO §fNenhum servidor de §3§lHARDCOREGAMES §fencontrado!");
			}
		}
		return false;
	}
}
