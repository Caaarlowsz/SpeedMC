package me.thauandev.bans;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thauandev.configuração.cfGrupo;

public class KickCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player)) {
			return true;
		}
		Player jogador = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("kick")) {
			if ((!cfGrupo.ChecarGrupo(jogador, "Dono") && (!cfGrupo.ChecarGrupo(jogador, "Gerente")
					&& (!cfGrupo.ChecarGrupo(jogador, "Admin") && (!cfGrupo.ChecarGrupo(jogador, "Mod+")
							&& (!cfGrupo.ChecarGrupo(jogador, "Mod") && (!cfGrupo.ChecarGrupo(jogador, "Trial")
									&& (!cfGrupo.ChecarGrupo(jogador, "Youtuber+"))))))))) {
				API.sendMsg(jogador, "§c§l(!) §cVocê não possui permissão para executar este comando!");
				return true;
			}
			if (args.length == 0) {
				API.sendMsg(jogador, "§d§lKICK §fUtilize §d§l/kick §d(jogador) (motivo)");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			Player vitima = Bukkit.getPlayer(args[0]);
			if (vitima == null) {
				API.sendMsg(jogador, "§cO jogador em questão está offline ou nunca entrou no servidor!");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			if (vitima.getName() == jogador.getName()) {
				API.sendMsg(jogador, "§cVocê não pode kikar a si mesmo!");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			if (args.length == 1) {
				API.sendMsg(jogador, "§d§lKICK §fUtilize §d§l/kick §d(jogador) (motivo)");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			String Motivo = "";
			for (int i = 1; i < args.length; i++) {
				Motivo = Motivo + args[i] + " ";
			}
			API.sendMsg(jogador, "§d§lKICK §fVocê kickou o jogador §3§l" + vitima.getName() + "§f.");
			API.sendStaff("§d§lKICK §f" + jogador.getName() + " kickou o jogador §c§l" + vitima.getName()
					+ "§f. Motivo: §3§l" + Motivo);
			vitima.kickPlayer(
					"§7Você foi §d§lKICKADO §fdo servidor!" + "\n" + "§7Username kickado: §c§l" + vitima.getName()
							+ "\n" + "§7Kickado por: §c§l" + jogador.getName() + "\n" + "§7Motivo: §c§l" + Motivo);
			return true;
		}
		return false;
	}
}
