package me.thauandev.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thauandev.API.ArraysAPI;
import me.thauandev.configura��o.cfGrupo;

public class InvisCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("invis")) {
			if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Trial")) {
				p.sendMessage("�c�lSPEED�f�lMC �fVoc� n�o possui permiss�o para utilizar este comando!");
				return true;
			}
			if(args.length == 0) {
				if(ArraysAPI.Admin.contains(p)) {
					AdminCommand.setAdmin(p);
					p.sendMessage("�6�lINVIS: �fVoc� est� invis�vel para todos os jogadores");
					return true;
				} else {
					p.sendMessage("�c�lSPEED�f�lMC �fVoc� s� pode utilizar este comando quando no modo admin.");
					return true;
				}
			}
		}
		return false;
	}
}
