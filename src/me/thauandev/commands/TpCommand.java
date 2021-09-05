package me.thauandev.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thauandev.configura��o.cfGrupo;

public class TpCommand implements CommandExecutor{
	
	private boolean CheckarNumero(String Numero){
		try {
			Integer.parseInt(Numero);
			return true;
		} catch(NumberFormatException e){
			return false;
		}
		
	}
	
	@Override
	public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args) {
		
		Player p = (Player)Sender;
		
		if(Cmd.getName().equalsIgnoreCase("tp")){
			
			if((!cfGrupo.ChecarGrupo(p, "Dono") && (!cfGrupo.ChecarGrupo(p, "Gerente") && (!cfGrupo.ChecarGrupo(p, "Admin") && (!cfGrupo.ChecarGrupo(p, "Mod+") && (!cfGrupo.ChecarGrupo(p, "Mod") && (!cfGrupo.ChecarGrupo(p, "Trial") && (!cfGrupo.ChecarGrupo(p, "Youtuber+") && (!cfGrupo.ChecarGrupo(p, "Helper")))))))))){
				p.sendMessage("�c�lSPEED�f�lMC �cVoc� n�o possui permiss�o para executar este comando!");
				return true;
			}
			
			if(Args.length == 0){
				p.sendMessage("�9�lTELEPORTE �fUtilize �c/tp �c(jogador) (alvo) �fou �c(x) (y) (z)");
				return true;
			}
			if(Args.length > 2 || Args.length == 3){
				if (!CheckarNumero(Args[0])) {
					p.sendMessage("�c� necess�rio utilizar apenas n�meros para teleportar para uma �c�lcoordenada.");
					return true;
				}
				Integer X = Integer.parseInt(Args[0]);
				if(Args.length == 1){
					p.sendMessage("�9�lTELEPORTE �fUtilize �c/tp �c(jogador) (alvo) �fou �c(x) (y) (z)");
					return true;
				}
				if (!CheckarNumero(Args[1])) {
					p.sendMessage("�c�lSPEED�f�lMC �f� necess�rio utilizar apenas n�meros para teleportar para uma �c�lcoordenada.");
					return true;
				}
				Integer Y = Integer.parseInt(Args[1]);
				if(Args.length == 2){
					p.sendMessage("�c�lSPEED�f�lMC �f� necess�rio utilizar apenas n�meros para teleportar para uma �c�lcoordenada.");
					return true;
				}
				if (!CheckarNumero(Args[2])) {
					p.sendMessage("�c�lSPEED�f�lMC �f� necess�rio utilizar apenas n�meros para teleportar para uma �c�lcoordenada.");
					return true;
				}
				Integer Z = Integer.parseInt(Args[2]);
				p.teleport(new Location(p.getWorld(), X, Y, Z));
				p.sendMessage("�c�lSPEED�f�lMC �7Voc� foi �9�lTELEPORTEADO �7at� as coordenadas: �c" + X + " " + Y + " " + Z);
				return true;
			}
			Player t = Bukkit.getPlayerExact(Args[0]);
			if((t == null || (!(t instanceof Player)))){
				return true;
			}
			if (Args.length > 1) {
				if (Args.length == 1) {
					return true;
				}
				Player t2 = Bukkit.getPlayer(Args[1]);
				t.teleport(t2.getLocation());
				p.sendMessage("�c�lSPEED�f�lMC �fVoc� teleportou �c " + t.getName() + " �fat� voc�!");
				return true;
			}
			p.teleport(t.getLocation());
			p.sendMessage("�9�lTELEPORTE �fVoc� foi teleportado at� o jogador: �c" + t.getName());
		
		}
		return false;	
	}
}
