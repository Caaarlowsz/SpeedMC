package me.thauandev.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thauandev.configuração.cfGrupo;

public class BcCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("bc")) {
			if (!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Admin")
					&& !cfGrupo.ChecarGrupo(p, "Gerente")) {
				p.sendMessage("§c§lSPEED§f§lMC §fVoce nao §a§lPOSSUI §fpermissao o §4§lBROADCAST§f!");
				return true;
			}
			if (args.length == 0) {
				p.sendMessage("§c§lSPEED§f§lMC §fUtilize §3/bc (MENSAGEM)");
				return true;
			}
			if (args.length >= 1) {
				String bc = "";
				for (int i = 0; i < args.length; i++) {
					bc = bc + args[i] + " ";
				}
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage("§c§lSPEED§f§lMC §f" + bc.replace("&", "§"));
				return true;
			}
		}
		return false;
	}
}
