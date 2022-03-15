package me.thauandev.authme;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.caaarlowsz.speedmc.kitpvp.SpeedPvP;

public class Mudar implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] arg3) {
		if (cmd.getName().equalsIgnoreCase("mudarsenha")) {
			Player p = (Player) sender;
			if (arg3.length == 0) {
				p.sendMessage("�c�lSPEED�f�lMC �fUtilize �c/mudarsenha");
				return true;
			}
			if (SpeedPvP.login.contains(p.getName())) {
				p.sendMessage("�c�lSPEED�f�lMC �fVoc� n�o est� logado.");
				return true;
			}
			if (arg3.length == 1) {
				String senha = arg3[0];
				SpeedPvP.plugin.getConfig().set("Login." + p.getName().toLowerCase() + ".senha", senha);
				p.sendMessage("�c�lSPEED�f�lMC �fsenha alterada para: " + senha.toLowerCase());
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 5F, 5F);
				SpeedPvP.plugin.saveConfig();
				return true;
			}
		}

		return false;
	}

}
