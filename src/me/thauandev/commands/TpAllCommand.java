package me.thauandev.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thauandev.API.API;
import me.thauandev.configura��o.cfGrupo;

public class TpAllCommand implements CommandExecutor {
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("tpall")) {
			if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Mod")) {
				p.sendMessage("�c�l(!) �cVoc� n�o possui permiss�o para utilizar este comando!");
				return true;
			}
			if(args.length == 0) {
				p.sendMessage("�7Voc� puxou �3�lTODOS �fos jogadores at� voc�!");
				Bukkit.broadcastMessage("�7O jogador �6�l" + p.getName() + "�f puxou todos os jogadores!");
				API.sendWarn("�7�o[" + p.getName() + " �7�opuxou todos os jogadores]");
				for(Player todos : Bukkit.getOnlinePlayers()) {
					if(todos != p) {
						todos.teleport(p);
					}
				}
			}
		}
		return false;
	}
}
