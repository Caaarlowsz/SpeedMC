package me.thauandev.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import me.thauandev.bans.API;
import me.thauandev.configuração.cfGrupo;

public class PvPCommand implements CommandExecutor, Listener {
	
	public static boolean pvp = false;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("pvp")) {
			if((!cfGrupo.ChecarGrupo(p, "Dono") && (!cfGrupo.ChecarGrupo(p, "Gerente") && (!cfGrupo.ChecarGrupo(p, "Admin") && (!cfGrupo.ChecarGrupo(p, "Mod+")))))){
				API.sendMsg(p, "§c§lSPEED§f§lMC §7Você não possui permissão para utilizar este comando.");
				return true;
			}
			if(args.length == 0) {
				p.sendMessage("§c§lSPEED§f§lMC §fUtilize §c/pvp (on) (off)");
				return true;
			}
			if(args.length == 1) {
				if(args[0].equalsIgnoreCase("on")) {
					if((pvp)) {
						p.sendMessage("§c§lSPEED§f§lMC §fO pvp §fjá está ativado!");
						return true;
					}
					pvp = true;
					p.sendMessage("§fVocê §a§lATIVOU §fo pvp!");
					Bukkit.broadcastMessage("§c§lSPEED§f§lMC §7O pvp §7foi §a§lATIVADO §7por: §c" + p.getName() + "§7.");
					return true;
				}
			}
			if(args[0].equalsIgnoreCase("off")) {
				if(!(pvp)) {
					p.sendMessage("§fO §a§lPVP §fjá está desativado!");
					return true;
				}
				pvp = false;
				p.sendMessage("§c§lSPEED§f§lMC §fVocê §c§lDESATIVOU §fo pvp!");
				Bukkit.broadcastMessage("§c§lSPEED§f§lMC §7O pvp §7foi §c§lDESATIVADO §7por: §c" + p.getName() + "§7.");
				return true;
			}
		}
		return false;
	}
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e) {
		if(e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
			if(!(pvp)) {
				e.setCancelled(true);
			}
		}
	}
}
