package me.thauandev.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import me.thauandev.bans.API;
import me.thauandev.configuração.cfGrupo;

public class DanoCommand implements CommandExecutor, Listener {
	
	public static boolean dano = false;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("dano")) {
			if((!cfGrupo.ChecarGrupo(p, "Dono") && (!cfGrupo.ChecarGrupo(p, "Gerente") && (!cfGrupo.ChecarGrupo(p, "Admin") && (!cfGrupo.ChecarGrupo(p, "Mod+")))))){
				API.sendMsg(p, "§c§l(!) §cVocê não possui permissão para executar este comando!");
				return true;
			}
			if(args.length == 0) {
				p.sendMessage("§c§lSPEED§f§lMC §cUse §c/dano (ON) (OFF)");
				return true;
			}
			if(args.length == 1) {
				if(args[0].equalsIgnoreCase("on")) {
					if((dano)) {
						p.sendMessage("§c§lSPEED§f§lMC §fO §a§lDANO §7§lGLOBAL §fFoi §a§lATIVADO");
						return true;
					}
					dano = true;
					p.sendMessage("§c§lSPEED§f§lMC §fVocê §a§lATIVOU §fo dano global.");
					Bukkit.broadcastMessage("§c§lSPEED§f§lMC §fO §a§lDANO §7§lGLOBAL §fFoi §a§lATIVADO");
					return true;
 				}
				if(args[0].equalsIgnoreCase("off")) {
					if(!(dano)) {
						p.sendMessage("§c§lSPEED§f§lMC  §cO dano global já está desativado!");
						return true;
					}
					dano = false;
					p.sendMessage("§c§lSPEED§f§lMC §fVocê §c§lDESATIVOU §fo dano global.");
					Bukkit.broadcastMessage("§c§lSPEED§f§lMC §fO §a§lDANO §7§lGLOBAL §fFoi §c§lDESATIVADO");
					return true;
				}
			}
		}
		return false;
	}
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e) {
		if(e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
			if(!(dano)) {
				e.setCancelled(true);
			}
		}
	}
	@EventHandler
	public void aoDano(EntityDamageEvent e) {
		if(e.getEntity() instanceof Player) {
			if(!(dano)) {
				e.setCancelled(true);
			}
		}
	}
}
