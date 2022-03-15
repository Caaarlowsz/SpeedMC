package me.thauandev.combatlog;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import me.thauandev.API.API;
��o.cfGrupo;
import me.thauandev.configura��o.cfStatus;
import com.github.caaarlowsz.speedmc.kitpvp.SpeedPvP;
import me.thauandev.scoreboard.sScoreAPI;

public class CombatLog implements Listener {

	public static ArrayList<Player> combat = new ArrayList<>();

	public static String getCombat(Player p) {
		if (combat.contains(p)) {
			return "�a�lSIM";
		}
		if (!combat.contains(p)) {
			return "�c�lNAO";
		}
		return "�c�lNAO";
	}

	@EventHandler
	public void aoHitar(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
			Player p = (Player) e.getEntity();
			Player k = (Player) e.getDamager();
			if (API.getWarp(p) != "Spawn" && API.getWarp(k) != "Spawn") {

				if (!combat.contains(p)) {
					combat.add(p);
					sScoreAPI.scoreboard(p);
					Bukkit.getScheduler().scheduleSyncDelayedTask(SpeedPvP.plugin, new Runnable() {

						@Override
						public void run() {
							combat.remove(p);
							sScoreAPI.scoreboard(p);
						}
					}, 10 * 20);
				}
				if (!combat.contains(k)) {
					combat.add(k);
					sScoreAPI.scoreboard(k);
					Bukkit.getScheduler().scheduleSyncDelayedTask(SpeedPvP.plugin, new Runnable() {

						@Override
						public void run() {
							combat.remove(k);
							sScoreAPI.scoreboard(k);
						}
					}, 10 * 20);
				}
			}
		}
	}

	@EventHandler
	public void aoSair(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		if (combat.contains(p)) {
			cfStatus.setDeaths(p);
		}
	}

	@EventHandler
	public void aoComando(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		if (combat.contains(p)) {
			if (!e.getMessage().contains("/report")) {
				if (!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente")
						&& !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Mod+")
						&& !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Trial")
						&& !cfGrupo.ChecarGrupo(p, "Youtuber+")) {
					e.setCancelled(true);
				}
			}
		}
	}
}
