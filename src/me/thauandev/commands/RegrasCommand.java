package me.thauandev.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RegrasCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("regras") || cmd.getName().equalsIgnoreCase("regra")) {
			if (args.length == 0) {
				p.sendMessage("");
				p.sendMessage("      �3�lREGRAS");
				p.sendMessage("�f- �3N�o Usar hack");
				p.sendMessage("�f- �3N�o testar staff");
				p.sendMessage("�f- �3N�o xingar players");
				p.sendMessage("�f- �3N�o xingar staff");
				p.sendMessage("�f- �3N�o pedir cargo");
				p.sendMessage("�f- �3N�o divulgar ip de servidores");
				p.sendMessage("�f- �3N�o divulgar links sem permiss�o");
				p.sendMessage("�f- �3N�o fazer �8�lFREE-KILL");
				p.sendMessage("�f- �3N�o Abusar de bugs");
			}
		}
		return false;
	}
}
