package me.thauandev.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thauandev.bans.API;

public class AplicarCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("aplicar") || cmd.getName().equalsIgnoreCase("virarstaff")) {
			if (args.length == 0) {
				API.sendMsg(p, "                               ");
				API.sendMsg(p, "             §5§lAPLICAR               ");
				API.sendMsg(p, "                               ");
				API.sendMsg(p, " ");
				API.sendMsg(p, "§fAplique-se para §5§lTRIAL §facessando: §bhttp://bit.ly/SpeedMC");
				API.sendMsg(p, "");
				API.sendMsg(p,
						"§4§lATENCAO: §fAo solicitar a leitura de sua aplicação, suas chances são reduzidas em §c§l15%§f!");
				API.sendMsg(p, "§7Atualizações da equipe em tempo real: §bhttps://twitter.com/SpeedMC");

			}
		}
		return false;
	}
}
