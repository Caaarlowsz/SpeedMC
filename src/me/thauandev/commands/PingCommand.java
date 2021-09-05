package me.thauandev.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class PingCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("ping")) {
			if((sender instanceof Player)) {
				Player p = (Player) sender;
				int ping = ((CraftPlayer)p).getHandle().ping;
				if(args.length == 0) {
					p.sendMessage("§c§lSPEED§f§lMC §fSeu ping atual é de §c" + ping + "§cms");
					return true;
				}
				if(args.length == 1) {
					Player k = Bukkit.getPlayer(args[0]);
					if(k == null) {
						p.sendMessage("Jogador offline!");
						return true;
					}
					int ping2 = ((CraftPlayer)k).getHandle().ping;
					p.sendMessage("§c§lSPEED§f§lMC §fO ping atual de §c" + k.getName() + "§f é de §c" + ping2 + "§cms.");
					return true;
				}
			}
		}
		return false;
	}
}