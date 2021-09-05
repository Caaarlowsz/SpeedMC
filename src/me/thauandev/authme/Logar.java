package me.thauandev.authme;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thauandev.configuração.cfGrupo;
import me.thauandev.main.Main;

public class Logar implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] arg3) {
		if (cmd.getName().equalsIgnoreCase("login")) {
			Player p = (Player) sender;
			if (arg3.length == 1) {
				if (arg3[0].equalsIgnoreCase(
						(String) Main.plugin.getConfig().get("Login." + p.getName().toLowerCase() + ".senha"))) {
					p.sendMessage("§c§lSPEED§f§lMC §fVocê se logou com sucesso!");
					Main.login.remove(p.getName());
					Main.login.remove(p.getName());
					Main.login.remove(p.getName());
					Main.login.remove(p.getName());
				}
				if (cfGrupo.ChecarGrupo(p, "Membro")) {
					p.chat("/tag normal");
				}
				if (cfGrupo.ChecarGrupo(p, "Light")) {
					p.chat("/tag light");
				}
				if (cfGrupo.ChecarGrupo(p, "S-pro")) {
					p.chat("/tag platinum");
				}
				if (cfGrupo.ChecarGrupo(p, "Mvp")) {
					p.chat("/tag premium");
				}
				if (cfGrupo.ChecarGrupo(p, "Pro")) {
					p.chat("/tag ultimate");
				}
				if (cfGrupo.ChecarGrupo(p, "Youtuber")) {
					p.chat("/tag Youtuber");
				}
				if (cfGrupo.ChecarGrupo(p, "Youtuber+")) {
					p.chat("/tag youtuber+");
				}
				if (cfGrupo.ChecarGrupo(p, "Trial")) {
					p.chat("/tag Trial");
				}
				if (cfGrupo.ChecarGrupo(p, "Mod")) {
					p.chat("/tag Mod");
				}
				if (cfGrupo.ChecarGrupo(p, "Mod+")) {
					p.chat("/tag modplus");
				}
				if (cfGrupo.ChecarGrupo(p, "Gerente")) {
					p.chat("/tag gerente");
				}
				if (cfGrupo.ChecarGrupo(p, "Admin")) {
					p.chat("/tag admin");
				}
				if (cfGrupo.ChecarGrupo(p, "Dono")) {
					p.chat("/tag dono");
				}
				return true;
			} else {
				p.sendMessage("§c§lSPEED§f§lMC §fA senha digitada está incorreta.");
			}

		}
		return false;
	}

}
