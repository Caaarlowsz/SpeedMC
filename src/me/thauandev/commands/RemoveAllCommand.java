package me.thauandev.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thauandev.configuração.cfGrupo;

public class RemoveAllCommand implements CommandExecutor{
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args) {
		
		Player p = (Player)Sender;
		
		if(Cmd.getName().equalsIgnoreCase("removeall")){
		
		if(!cfGrupo.ChecarGrupo(p, "Dono")){
			p.sendMessage("§c§lSPEED§f§lMC §fVoce nao §a§lPOSSUI §fpermissao para §e§lREMOVEALL§f!");
			return true;
		}
		
		if(Args.length == 0){
			p.sendMessage("§c§lSPEED§f§lMC §fUse §c/removeall (light) (premium) (ultimate) (fullkit)");
			return true;
		}
		if(Args[0].equalsIgnoreCase("ultimate")){
			
			if(!GiveAllCommand.pro){
				p.sendMessage("§c§lSPEED§f§lMC §7O §d§lULTIMATE §7não está liberado!");
			}else{
			p.sendMessage("§c§lSPEED§f§lMC §7Você removeu o §d§lULTIMATE §7de §9§lTODOS§f!");
			Bukkit.broadcastMessage("§c§lSPEED§f§lMC §7O Player §c(" + p.getName() + ") §7removeu o §d§lULTIMATE §7de §9§lTODOS§f!");
				GiveAllCommand.pro = false;
				
				for(Player todos : Bukkit.getOnlinePlayers()){
					if(cfGrupo.ChecarGrupo(p, "Membro")){
					todos.chat("/tag normal");
					}
				}
				return true;
			}
		}
        if(Args[0].equalsIgnoreCase("winner")){
			
			if(!GiveAllCommand.winner){
				p.sendMessage("§c§lSPEED§f§lMC §7O §d§lWINNER §7não está liberado!");
			}else{
			p.sendMessage("§c§lSPEED§f§lMC §7Você removeu o §2§lWINNER §7de §9§lTODOS§f!");
			Bukkit.broadcastMessage("§c§lSPEED§f§lMC §7O Player §c(" + p.getName() + ") §7removeu o §2§lWINNER §7de §9§lTODOS§f!");
				GiveAllCommand.winner = false;
				
				for(Player todos : Bukkit.getOnlinePlayers()){
					if(cfGrupo.ChecarGrupo(p, "Membro")){
					todos.chat("/tag normal");
					}
				}
				return true;
			}
		}
		if(Args[0].equalsIgnoreCase("premium")){
			
			if(!GiveAllCommand.mvp){
				p.sendMessage("§c§lSPEED§f§lMC §7O §6§lPREMIUM §7não está liberado!");
			}else{
			p.sendMessage("§c§lSPEED§f§lMC §7Você removeu o §6§lPREMIUM §7de §9§lTODOS§f!");
			Bukkit.broadcastMessage("§c§lSPEED§f§lMC §7O Player §c(" + p.getName() + ") §7removeu o §6§lPREMIUM §7de §9§lTODOS§f!");
				GiveAllCommand.mvp = false;
				
				for(Player todos : Bukkit.getOnlinePlayers()){
					if(cfGrupo.ChecarGrupo(p, "Membro")){
					todos.chat("/tag normal");
					}
				}
				return true;
			}
		}
		if(Args[0].equalsIgnoreCase("light")){
			
			if(!GiveAllCommand.light){
				p.sendMessage("§c§lSPEED§f§lMC §7O §a§lLIGHT §7não está liberado!");
			}else{
			p.sendMessage("§c§lSPEED§f§lMC §7Você removeu o §a§lLIGHT §7de §9§lTODOS§f!");
			Bukkit.broadcastMessage("§c§lSPEED§f§lMC §7O Player §c(" + p.getName() + ") §7removeu o §a§lLIGHT §7de §9§lTODOS§f!");
				GiveAllCommand.light = false;
				
				for(Player todos : Bukkit.getOnlinePlayers()){
						if(cfGrupo.ChecarGrupo(p, "Membro")){
					todos.chat("/tag normal");
						}
				}
				return true;
			}
		}
		if(Args[0].equalsIgnoreCase("fullkit")){
			
			if(!GiveAllCommand.fullkit){
				p.sendMessage("§c§lSPEED§f§lMC §7O §e§lFULLKIT §7não está liberado!");
			}else{
			p.sendMessage("§c§lSPEED§f§lMC §7Você removeu o §e§lFULLKIT §7de §9§lTODOS§f!");
			Bukkit.broadcastMessage("§c§lSPEED§f§lMC §7O Player §c(" + p.getName() + ") §7removeu o §e§lFULLKIT §7de §9§lTODOS§f!");
				GiveAllCommand.fullkit = false;
				return true;
			}
		}
	}
 return false;
  }
}
