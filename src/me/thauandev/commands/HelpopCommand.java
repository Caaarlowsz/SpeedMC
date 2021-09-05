package me.thauandev.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thauandev.API.ArraysAPI;
import me.thauandev.configuração.cfGrupo;
import me.thauandev.main.Main;

public class HelpopCommand implements CommandExecutor {

	public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args) {

		Player p = (Player) Sender;

		if (ArraysAPI.CooldownDica.contains(p)) {
			p.sendMessage("§c§lSPEED§f§lMC §6» §7Aguarde para executar outro comando");
			return true;
		}
		if (Args.length == 0) {
			p.sendMessage("§c§lSPEED§f§lMC §6» §7Utilize §c/helpop (ajuda)");
			return true;
		}
		p.sendMessage("§c§lSPEED§f§lMC §6» §7Sua dica foi enviada com sucesso a algum staffer");
		String dica = " ";
		for (int i = 0; i < Args.length; i++) {
			if (i == Args.length - 1) {
				dica = dica + Args[i];
			} else {
				dica = dica + Args[i] + " ";
			}
		}
		ArraysAPI.CooldownDica.add(p);

		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
			public void run() {
				if (ArraysAPI.CooldownDica.contains(p)) {
					ArraysAPI.CooldownDica.remove(p);
				}
			}
		}, 120 * 20);
		for (Player s : Bukkit.getOnlinePlayers()) {
			if ((cfGrupo.ChecarGrupo(s, "Dono") || ((cfGrupo.ChecarGrupo(s, "Gerente")
					|| ((cfGrupo.ChecarGrupo(s, "Admin") || ((cfGrupo.ChecarGrupo(s, "Mod+")
							|| ((cfGrupo.ChecarGrupo(s, "Mod") || ((cfGrupo.ChecarGrupo(s, "Trial"))))))))))))) {

				s.sendMessage(" ");
				s.sendMessage("    §c§lDICA   ");
				s.sendMessage("  §fPlayer §c" + p.getDisplayName());
				s.sendMessage("  §fDica §c" + dica);
				s.sendMessage(" ");
			}
		}
		return false;
	}
}
