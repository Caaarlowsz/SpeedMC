package me.thauandev.authme;

import java.util.ArrayList;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thauandev.configura��o.cfGrupo;
import com.github.caaarlowsz.speedmc.kitpvp.SpeedPvP;

public class Register implements CommandExecutor {
	public static ArrayList<String> pin = new ArrayList<>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] arg3) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("register")) {
			if (SpeedPvP.plugin.getConfig().contains("Login." + p.getName().toLowerCase() + ".senha")) {
				p.sendMessage("�c�lSPEED�f�lMC �fEst� conta j� esta registrada em nosso banco de dados.");
				p.playSound(p.getLocation(), Sound.EXPLODE, 5F, 5F);
				return true;
			}
			if (arg3.length == 0) {
				p.sendMessage("�c�lSPEED�f�lMC �fPara efetuar seu registro, digite �c/register (senha)");
				return true;
			}
			if (arg3[0].length() <= 6) {
				p.sendMessage("�c�lSPEED�f�lMC �fA senha deve conter no m�nimo, 6 caracteres.");
				return true;
			}
			if (arg3.length == 1) {
				String senha = arg3[0];
				SpeedPvP.plugin.getConfig().set("Login." + p.getName().toLowerCase() + ".senha", senha);
				p.sendMessage("�c�lSPEED�f�lMC �aVoc� se registrou com sucesso.");
				pin.add(p.getName());
				SpeedPvP.login.remove(p.getName());
				SpeedPvP.plugin.saveConfig();
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
		}
		return false;
	}

}
