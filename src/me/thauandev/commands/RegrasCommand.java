package me.thauandev.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class RegrasCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("regras") || cmd.getName().equalsIgnoreCase("regra")) {
			if(args.length == 0) {
				p.sendMessage("");
				p.sendMessage("      §3§lREGRAS");
				p.sendMessage("§f- §3Não Usar hack");
				p.sendMessage("§f- §3Não testar staff");
				p.sendMessage("§f- §3Não xingar players");
				p.sendMessage("§f- §3Não xingar staff");
				p.sendMessage("§f- §3Não pedir cargo");
				p.sendMessage("§f- §3Não divulgar ip de servidores");
				p.sendMessage("§f- §3Não divulgar links sem permissão");
				p.sendMessage("§f- §3Não fazer §8§lFREE-KILL");
				p.sendMessage("§f- §3Não Abusar de bugs");			
			}
		}
		return false;
	}
}
