
package me.thauandev.commands;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thauandev.API.ChatInterativo;
import me.thauandev.configuração.cfGrupo;
import me.thauandev.main.Main;

public class ReportCommand implements CommandExecutor{
	
  @SuppressWarnings({ "unchecked", "rawtypes" })
public ArrayList<String> reported = new ArrayList();


@SuppressWarnings("deprecation")
public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args){
	  
    final Player p = (Player)Sender;
    if (Cmd.getName().equalsIgnoreCase("report")) {
      if (Args.length >= 2) {
        Player target = p.getServer().getPlayer(Args[0]);
        if (target != null) {
          if (reported.contains(p.getName())){
            p.sendMessage("§c§lSPEED§f§lMC §fAguarde para reportar novamente§f!");
            return true;
          }
          String reportMsg = StringUtils.join(
            Arrays.copyOfRange(Args, 1, Args.length), " ");
          this.reported.add(p.getName());
          p.sendMessage("§c§lSPEED§f§lMC §fSeu §9§lREPORT §fFoi enviado com sucesso §fUn staffer online ira obisevar este §3§lPLAYER§f!");
          for (Player s : Bukkit.getOnlinePlayers()) {
      		if((cfGrupo.ChecarGrupo(s, "Dono") || ((cfGrupo.ChecarGrupo(s, "Gerente") || ((cfGrupo.ChecarGrupo(s, "Admin") || ((cfGrupo.ChecarGrupo(s, "Mod+") || ((cfGrupo.ChecarGrupo(s, "Mod") || ((cfGrupo.ChecarGrupo(s, "Trial") || ((cfGrupo.ChecarGrupo(s, "Youtuber+"))))))))))))))){
            	
   			    s.getPlayer().playSound(p.getPlayer().getLocation(), Sound.ANVIL_USE, 5.0F, 5.0F);
            	s.sendMessage("                                  ");
            	s.sendMessage("            §c§lREPORT                         ");
            	s.sendMessage("                                  ");
            	s.sendMessage("    §7Jogador reportado: §c" + target.getName());
            	s.sendMessage("    §7Reportado por: §c" + p.getName());
            	s.sendMessage("    §7Motivo: §c" + reportMsg);
            	s.sendMessage("    §7Servidor: §cKitPvP ");
            	s.sendMessage("                                  ");
            	
              
        		ChatInterativo.Comando(s.getName(), "§fClique §c§l§nAQUI §fpara teleportar até o jogador.","/tp " + target.getName(), "§eClique! §8(botão esquerdo)");
              Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable(){
                public void run(){
                 reported.remove(p.getName());
                }
              }
              , 300L);
            }
          }
        }
        else {
        	p.sendMessage("§c§lSPEED§f§lMC §fEste jogadore está offline§f!");
        }
      }
      else {
			p.sendMessage("§c§lSPEED§f§lMC §fUtilize §3/report (JOGADOR) (MOTIVO)§f!");
      }
    }
    return false;
  }
}