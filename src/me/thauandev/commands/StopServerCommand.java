package me.thauandev.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thauandev.configuração.cfGrupo;

public class StopServerCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("stopserver")) {
			if (!cfGrupo.ChecarGrupo(p, "Dono") || !p.isOp()) {
				p.sendMessage("§c§lSPEED§f§lMC §cVocê não possui permissão para executar este comando!");
				return true;
			}
			for (Player todos : Bukkit.getOnlinePlayers()) {
				todos.kickPlayer("§c§lSPEED§f§lMC" + "\n" + "§c§lSERVIDOR FECHADO!" + "\n"
						+ "    §7Podemos estar fechando por vários motivos," + "\n"
						+ "  §7mas com certeza estamos fazendo algo" + "\n" + "§7em função de sua jogatina." + "\n"
						+ " §7Esperamos a compreensão de todos." + "\n" + "§7[Att. §c§lSPEED§f§lMC§7]");
			}
			Bukkit.shutdown();
		}
		return false;
	}

}
