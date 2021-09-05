package me.thauandev.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

import me.thauandev.configuração.cfGrupo;
import me.thauandev.menus.ChatMenu;
@SuppressWarnings("deprecation")
public class ChatCommand implements CommandExecutor, Listener{
	  public static boolean pausado = false;
	@Override
	public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args) {
		
		if(Cmd.getName().equalsIgnoreCase("chat")){
			Player p = (Player)Sender;
			
			if((!cfGrupo.ChecarGrupo(p, "Dono") && (!cfGrupo.ChecarGrupo(p, "Gerente") && (!cfGrupo.ChecarGrupo(p, "Admin") && (!cfGrupo.ChecarGrupo(p, "Mod+") && (!cfGrupo.ChecarGrupo(p, "Mod") && (!cfGrupo.ChecarGrupo(p, "Trial") && (!cfGrupo.ChecarGrupo(p, "Youtuber+"))))))))){
				p.sendMessage("§c§lSPEED§f§lMC §cVocê não possui permissão para executar este comando!");
				return true;
			}
			
			if(Args.length == 0){
				ChatMenu.inventory(p);
				return false;
			}
			if(Args[0].equalsIgnoreCase("clear")){
				
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("§c§lSPEED§f§lMC §fChat do servidor foi limpo.");
				Bukkit.getServer().broadcastMessage("   ");
			}else{
				
				if(Args[0].equalsIgnoreCase("off")){
					Bukkit.getServer().broadcastMessage("           §c§lSPEED§f§lMC         ");
					Bukkit.getServer().broadcastMessage("§b§lCHAT §fO Chat §3§lGERAL §fFoi §c§lDESATIVADO.");
					Bukkit.getServer().broadcastMessage("§7Apenas membros do grupo §a§lLIGHT");
					Bukkit.getServer().broadcastMessage("      §7E acima podem falar no chat");
					pausado = true;
			}else{
				if(Args[0].equalsIgnoreCase("on")){
					Bukkit.getServer().broadcastMessage("           §c§lSPEED§f§lMC          ");
					Bukkit.getServer().broadcastMessage("§b§lCHAT §fO Chat §3§lGERAL §fFoi §a§lATIVADO.");
					Bukkit.getServer().broadcastMessage("      §7Agora todos podem falar!   ");
					pausado = false;
					}
				}
			}
		}
		return true;
		}
			 @EventHandler
			  public void onChat(PlayerChatEvent e){
			  {
			    Player p = e.getPlayer();
			    if ((pausado) && 
			    		((!cfGrupo.ChecarGrupo(p, "Dono") && (!cfGrupo.ChecarGrupo(p, "Gerente") && (!cfGrupo.ChecarGrupo(p, "Admin") && (!cfGrupo.ChecarGrupo(p, "Mod+") && (!cfGrupo.ChecarGrupo(p, "Mod") && (!cfGrupo.ChecarGrupo(p, "Trial") && (!cfGrupo.ChecarGrupo(p, "Youtuber+") && (!cfGrupo.ChecarGrupo(p, "Youtuber") && (!cfGrupo.ChecarGrupo(p, "Pro") && (!cfGrupo.ChecarGrupo(p, "Mvp") && (!cfGrupo.ChecarGrupo(p, "Light") && (!cfGrupo.ChecarGrupo(p, "Dono"))))))))))))))){
			      e.setCancelled(true);
			      p.sendMessage("§c§lSPEED§f§lMC §fO chat do servidor está desativado, compre §a§lVIP §fpara pode falar com o chat mutado!");
			    }
		  }
	 }
}
