package me.thauandev.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thauandev.bans.API;
import me.thauandev.configura��o.cfGrupo;

public class TpHereCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("tphere") || cmd.getName().equalsIgnoreCase("s")) {
			if ((!cfGrupo.ChecarGrupo(p, "Dono") && (!cfGrupo.ChecarGrupo(p, "Gerente") && (!cfGrupo.ChecarGrupo(p,
					"Admin")
					&& (!cfGrupo.ChecarGrupo(p, "Mod+") && (!cfGrupo.ChecarGrupo(p, "Mod")
							&& (!cfGrupo.ChecarGrupo(p, "Trial") && (!cfGrupo.ChecarGrupo(p, "Youtuber+"))))))))) {
				p.sendMessage("�c�lSPEED�f�lMC �cVoc� n�o possui permiss�o para executar este comando!");
				return true;
			}
			if (args.length == 0) {
				p.sendMessage("�cUse �c�l/tphere �cou �c�l/s �cpara puxar um jogador at� voc�!");
				return true;
			}
			Player k = Bukkit.getPlayer(args[0]);
			if (k == null) {
				API.sendMsg(p, "�7O jogador �a�l" + args[0] + " �7est� offline!");
				return true;
			}
			k.teleport(p);
			p.sendMessage("�7Voc� puxou o jogador �a�l" + k.getName() + " �7at� voc�!");
			me.thauandev.API.API.sendWarn("�7�o[" + p.getName() + " puxou o jogador " + k.getName() + "�7�o]");
			return true;
		}
		return false;
	}

}
