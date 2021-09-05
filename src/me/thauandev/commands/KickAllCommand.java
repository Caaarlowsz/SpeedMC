package me.thauandev.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thauandev.configuração.cfGrupo;

public class KickAllCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("kickall")) {
			if (!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Admin")) {
				p.sendMessage("§c§lSPEED§f§lMC §fVocê não possui permissão para utilizar este comando!");
				return true;
			}
			for (Player todos : Bukkit.getOnlinePlayers()) {
				if (!cfGrupo.ChecarGrupo(todos, "Dono") && !cfGrupo.ChecarGrupo(todos, "Gerente") && todos != p
						&& !todos.isOp()) {
					todos.kickPlayer("§c§lSPEED§f§lMC" + "\n" + "§7Todos os jogadores foram " + "\n"
							+ " kickados do servidor pelo §c" + p.getName() + "§7!");
				}
			}
			p.sendMessage("§aVocê kickou todos os jogadores do servidor!");
			Bukkit.broadcastMessage(
					"§c§lSPEED§f§lMC §fTodos os jogadores foram §c§lKIKADOS §fdo servidor pelo §c" + p.getName());
			return true;
		}
		return false;
	}

}
