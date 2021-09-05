package me.thauandev.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thauandev.API.ArraysAPI;
import me.thauandev.configuração.cfGrupo;

public class SpecCommand implements CommandExecutor{
	
	
	@SuppressWarnings("deprecation")
	public static void setON(Player p){
		for(Player todos : Bukkit.getOnlinePlayers()){
		if(ArraysAPI.Admin.contains(todos) && !ArraysAPI.Spec.contains(p)){
					if(todos != p){
						p.hidePlayer(todos);
					}
		   }
		}
	}
	@SuppressWarnings("deprecation")
	public static void setOFF(Player p){
		for(Player todos : Bukkit.getOnlinePlayers()){
		if(ArraysAPI.Admin.contains(todos) && ArraysAPI.Spec.contains(p)){
						p.showPlayer(todos);
						todos.showPlayer(p);
				}
		}
	}

	@Override
	public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args) {
		
		Player p = (Player)Sender;
		
		if((!cfGrupo.ChecarGrupo(p, "Dono") && (!cfGrupo.ChecarGrupo(p, "Gerente") && (!cfGrupo.ChecarGrupo(p, "Admin") && (!cfGrupo.ChecarGrupo(p, "Mod+") && (!cfGrupo.ChecarGrupo(p, "Mod") && (!cfGrupo.ChecarGrupo(p, "Trial")))))))){
			p.sendMessage("§c§lSPEED§f§lMC §fVocê não possui permissão para executar este comando!");
			return true;
		}
		
		if(Args.length == 0){
			p.sendMessage("§c§lSPEED§f§lMC §fUse §c/spec (on) (off)");
			return true;
		}
		if(Args[0].equalsIgnoreCase("on")){
		if(ArraysAPI.Spec.contains(p)){
			p.sendMessage("§c§lSPEED§f§lMC §fVocê já está com os specs ativados");
			return true;
		}
		p.sendMessage("§a§lSPEC §7Os espectadores foram: §aATIVADOS");
		ArraysAPI.Spec.add(p);
	      setOFF(p);
	      return false;
		}
		if(Args[0].equalsIgnoreCase("off")){
		p.sendMessage("§a§lSPEC §7Os espectadores foram: §cDESATIVADOS");
		ArraysAPI.Spec.remove(p);
	      setON(p);
		}
		return false;
	}
}