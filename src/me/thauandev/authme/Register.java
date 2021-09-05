package me.thauandev.authme;

import java.util.ArrayList;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thauandev.configuração.cfGrupo;
import me.thauandev.main.Main;


public class Register implements CommandExecutor{
	public static ArrayList<String> pin = new ArrayList<>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] arg3) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("register")) {
			if(Main.plugin.getConfig().contains("Login." +p.getName().toLowerCase() + ".senha")) {
				p.sendMessage("§c§lSPEED§f§lMC §fEstá conta já esta registrada em nosso banco de dados.");
				p.playSound(p.getLocation(), Sound.EXPLODE, 5F, 5F);
				   return true;
			}
			if(arg3.length==0) {
				p.sendMessage("§c§lSPEED§f§lMC §fPara efetuar seu registro, digite §c/register (senha)");
				return true;
			}
			if(arg3[0].length() <= 6) {
				p.sendMessage("§c§lSPEED§f§lMC §fA senha deve conter no mínimo, 6 caracteres.");
				return true;
			}
			if(arg3.length==1) {
			      String senha = arg3[0];
				   Main.plugin.getConfig().set("Login." + p.getName().toLowerCase() + ".senha", senha);
				   p.sendMessage("§c§lSPEED§f§lMC §aVocê se registrou com sucesso.");
				   pin.add(p.getName());
				   Main.login.remove(p.getName());
				   Main.plugin.saveConfig();
			      }
				   if(cfGrupo.ChecarGrupo(p, "Membro")) {
						p.chat("/tag normal");
						}
						if(cfGrupo.ChecarGrupo(p, "Light")) {
						p.chat("/tag light");
						}
						if(cfGrupo.ChecarGrupo(p, "S-pro")) {
						p.chat("/tag platinum");
						}
						if(cfGrupo.ChecarGrupo(p, "Mvp")) {
						p.chat("/tag premium");
						}
						if(cfGrupo.ChecarGrupo(p, "Pro")) {
						p.chat("/tag ultimate");
						}
						if(cfGrupo.ChecarGrupo(p, "Youtuber")) {
						p.chat("/tag Youtuber");
						}
						if(cfGrupo.ChecarGrupo(p, "Youtuber+")) {
						p.chat("/tag youtuber+");
						}
						if(cfGrupo.ChecarGrupo(p, "Trial")) {
						p.chat("/tag Trial");
						}
						if(cfGrupo.ChecarGrupo(p, "Mod")) {
						p.chat("/tag Mod");
						}
						if(cfGrupo.ChecarGrupo(p, "Mod+")) {
						p.chat("/tag modplus");
						}
						if(cfGrupo.ChecarGrupo(p, "Gerente")) {
						p.chat("/tag gerente");
						}
						if(cfGrupo.ChecarGrupo(p, "Admin")) {
						p.chat("/tag admin");
						}
						if(cfGrupo.ChecarGrupo(p, "Dono")) {
						p.chat("/tag dono");
					}
				   return true;
			}  
		return false;
	}

}
