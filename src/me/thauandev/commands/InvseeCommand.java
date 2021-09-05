package me.thauandev.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thauandev.bans.API;
import me.thauandev.configuração.cfGrupo;

public class InvseeCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("inv") || cmd.getName().equalsIgnoreCase("invsee")) {
			if ((!cfGrupo.ChecarGrupo(p, "Dono")
					&& (!cfGrupo.ChecarGrupo(p, "Gerente") && (!cfGrupo.ChecarGrupo(p, "Admin")
							&& (!cfGrupo.ChecarGrupo(p, "Mod+") && (!cfGrupo.ChecarGrupo(p, "Mod")
									&& (!cfGrupo.ChecarGrupo(p, "Trial") && (!cfGrupo.ChecarGrupo(p, "Youtuber+")
											&& (!cfGrupo.ChecarGrupo(p, "Helper")))))))))) {
				p.sendMessage("§c§lSPEED§f§lMC §cVocê não possui permissão para utilizar este comando!");
				return true;
			}
			if (args.length == 0) {
				API.sendMsg(p, "§c§lSPEED§f§lMC §fUtilize §c/invsee §fou §c/inv §f(jogador).");
				API.sendSound(p, Sound.NOTE_PLING, 10);
				return true;
			}
			Player inv = Bukkit.getPlayer(args[0]);
			if (inv == null) {
				p.sendMessage("§c§lSPEED§f§lMC §fO jogador em questão está §coffline §fou nunca entrou no servidor!");
			}
			p.sendMessage("§c§lSPEED§f§lMC §fVocê abriu o inventário de: §c" + inv.getName());
			API.sendSound(p, Sound.NOTE_PLING, 10);
			p.openInventory(inv.getInventory());
			return true;
		}
		return false;
	}
}
