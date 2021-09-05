package me.thauandev.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thauandev.bans.API;
import me.thauandev.configuração.cfGrupo;

public class GetIPCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("getip")) {
			if((!cfGrupo.ChecarGrupo(p, "Dono") && (!cfGrupo.ChecarGrupo(p, "Gerente") && (!cfGrupo.ChecarGrupo(p, "Admin") && (!cfGrupo.ChecarGrupo(p, "Mod+") && (!cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Trial"))))))){
				API.sendMsg(p, "§c§lSPEED§f§lMC §fVocê não possui permissão para executar este comando!");
				return true;
			}
			if(args.length == 0) {
				API.sendMsg(p, "§c§lSPEED§f§lMC §fUtilize §c/getip §c(jogador)§f.");
				API.sendSound(p, Sound.NOTE_PLING, 10);
				return true;
			}
			Player ip = Bukkit.getPlayer(args[0]);
			if(ip == null) {
				API.sendMsg(p, "§c§lSPEED§f§lMC §7O jogador §c" + args[0] + " está offline!");
				API.sendSound(p, Sound.NOTE_PLING, 10);
				return true;
			}
			if(ip != null) {
				API.sendMsg(p, "§c§lSPEED§f§lMC §fChecando informações de: §c" + ip.getName());
				API.sendMsg(p, " ");
				API.sendMsg(p, "§f§lIP: §c" + ip.getAddress().getHostString());
				API.sendMsg(p, "§f§lIP §c(reverso): §c" + ip.getAddress().getHostName());
				return true;
			}
		}
		return false;
	}
}
