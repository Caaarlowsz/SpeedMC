package me.thauandev.authme;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thauandev.main.Main;

public class Mudar implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] arg3) {
		if (cmd.getName().equalsIgnoreCase("mudarsenha")) {
			Player p = (Player) sender;
			if (arg3.length == 0) {
				p.sendMessage("§c§lSPEED§f§lMC §fUtilize §c/mudarsenha");
				return true;
			}
			if (Main.login.contains(p.getName())) {
				p.sendMessage("§c§lSPEED§f§lMC §fVocê não está logado.");
				return true;
			}
			if (arg3.length == 1) {
				String senha = arg3[0];
				Main.plugin.getConfig().set("Login." + p.getName().toLowerCase() + ".senha", senha);
				p.sendMessage("§c§lSPEED§f§lMC §fsenha alterada para: " + senha.toLowerCase());
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 5F, 5F);
				Main.plugin.saveConfig();
				return true;
			}
		}

		return false;
	}

}
