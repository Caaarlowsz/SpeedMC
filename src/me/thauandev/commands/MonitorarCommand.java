package me.thauandev.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thauandev.API.ArraysAPI;
import me.thauandev.configuração.cfGrupo;

public class MonitorarCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("monitorar")) {
			if (!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Admin")) {
				p.sendMessage("§c§lSPEED§f§lMC §fVocê não possui permissão para utilizar este comando.");
				return true;
			}
			if (args.length == 0) {
				p.sendMessage("§c§lSPEED§f§lMC §fUso correto: §c/monitorar (ON) (OFF)");
				return true;
			}
			if (args[0].equalsIgnoreCase("on")) {
				ArraysAPI.Monitor.add(p);
				p.sendMessage("§c§lSPEED§f§lMC §aModo monitorar ativado.");
				return true;
			}
			if (args[0].equalsIgnoreCase("off")) {
				ArraysAPI.Monitor.remove(p);
				p.sendMessage("§c§lSPEED§f§lMC §cModo monitorar desativado.");
				return true;
			}
		}
		return false;
	}

}
