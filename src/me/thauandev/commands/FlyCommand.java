	package me.thauandev.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thauandev.API.API;
import me.thauandev.configuração.cfGrupo;

public class FlyCommand implements CommandExecutor{
	
	public static ArrayList<Player> Fly = new ArrayList<>();
	
	public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args) {
		
		Player p = (Player)Sender;
		
		if(Cmd.getName().equalsIgnoreCase("fly")){
			if((!cfGrupo.ChecarGrupo(p, "Dono") && (!cfGrupo.ChecarGrupo(p, "Gerente") && (!cfGrupo.ChecarGrupo(p, "Admin") && (!cfGrupo.ChecarGrupo(p, "Mod+") && (!cfGrupo.ChecarGrupo(p, "Mod") && (!cfGrupo.ChecarGrupo(p, "Trial") && (!cfGrupo.ChecarGrupo(p, "Youtuber+") && (!cfGrupo.ChecarGrupo(p, "Youtuber") && (!cfGrupo.ChecarGrupo(p, "Pro") && (!cfGrupo.ChecarGrupo(p, "Mvp") && (!cfGrupo.ChecarGrupo(p, "Light"))))))))))))){
				p.sendMessage("§c§lSPEED§f§lMC §fVoce não tem acesso ao fly!");
				return true;
			}
			if(Args.length == 0 && API.getWarp(p) == "Spawn"){
				if(!Fly.contains(p)){
					p.sendMessage("§c§lSPEED§f§lMC §fVocê ativou §fo seu modo §b§lFLY§f!");
					p.setAllowFlight(true);
					Fly.add(p);
					return true;
				}
					p.sendMessage("§c§lSPEED§f§lMC §fVocê desativou §fo seu modo §b§lFLY§f!");
					p.setAllowFlight(false);
					Fly.remove(p);
					return false;
				}
			if(API.getWarp(p) != "Spawn") {
				p.sendMessage("§c§lSPEED§f§lMC §fVocê só pode §a§lATIVAR §fo seu modo fly §fno §6§lSPAWN§f!");
				return true;
			}
			else if((!cfGrupo.ChecarGrupo(p, "Dono") && (!cfGrupo.ChecarGrupo(p, "Gerente")))){
				p.sendMessage("§c§lSPEED§f§lMC §7Você não possui permissão para utilizar este comando!");
				return true;
			}
				Player target = Bukkit.getPlayer(Args[0]);
				  if ((target == null) || (!(target instanceof Player))){
					p.sendMessage("§c§lSPEED§f§lMC §fO jogador em questão está offline ou nunca entrou no servidor!");
					return true;
				}
				if(!Fly.contains(target)){
					target.sendMessage("§c§lSPEED§f§lMC §fO seu modo Fly foi ativado por §c" + p.getName());
					p.sendMessage("§c§lSPEED§f§lMC §fVocê ativou o modo Fly para o jogador §c" + target.getName());
					Fly.add(target);
					target.setAllowFlight(true);
				}else{
					target.sendMessage("§c§lSPEED§f§lMC §fO seu modo Fly foi desativado por §c" + p.getName());
					p.sendMessage("§c§lSPEED§f§lMC §fVocê desativou o modo Fly para o jogador §c" + target.getName());
					Fly.remove(target);
					target.setAllowFlight(false);
				}
		}
		return false;
	}
}
