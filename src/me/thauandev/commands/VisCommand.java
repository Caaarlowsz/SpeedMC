package me.thauandev.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thauandev.API.ArraysAPI;
import me.thauandev.configura��o.cfGrupo;

public class VisCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("vis")) {
			if (!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente")
					&& !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Mod+")
					&& !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Trial")) {
				p.sendMessage("�c�l(!) �cVoc� n�o possui permiss�o para executar este comando!");
				return true;
			}
			if (args.length == 0) {
				if (ArraysAPI.Admin.contains(p)) {
					for (Player todos : Bukkit.getOnlinePlayers()) {
						todos.showPlayer(p);
						p.showPlayer(todos);
						p.sendMessage("�6�lVIS: �fVoc� est� vis�vel para todos os jogadores");
						return true;
					}
				} else {
					p.sendMessage("�cVoc� s� pode utilizar este comando quando no modo admin.");
					return true;
				}
			}
		}
		return false;
	}
}