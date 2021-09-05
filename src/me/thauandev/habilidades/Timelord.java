package me.thauandev.habilidades;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import me.thauandev.API.CooldownAPI;
import me.thauandev.API.KitAPI;
import me.thauandev.main.Main;

public class Timelord implements Listener {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static ArrayList<String> frozenPlayers = new ArrayList();

	@EventHandler
	public void onTimeLord(PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if ((p.getItemInHand().getType() == Material.WATCH)
				&& ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))) {
			if (KitAPI.getKit(p) == "Timelord") {
				if (CooldownAPI.Cooldown.containsKey(p.getName())) {
					p.sendMessage("§fO seu §3§lCOOLDOWN §facaba em: §c§l" + CooldownAPI.Cooldown(p) + "s");
					return;
				}
			}
			if (KitAPI.getKit(p) == "Timelord") {

				List<Entity> ne = e.getPlayer().getNearbyEntities(5.0D, 5.0D, 5.0D);
				for (Entity t : ne) {
					if ((t instanceof Player)) {
						final Player ta = (Player) t;
						frozenPlayers.add(((Player) t).getName());
						((Player) t).sendMessage("§fVocê foi congelado por um §e§lTIMELORD§f!");

						CooldownAPI.addCooldown(p, 35);
						p.sendMessage("§aVocê congelou os jogador a sua volta");

						Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
							public void run() {
								frozenPlayers.remove(ta.getName());
							}
						}, 5 * 20);
					}
				}
			}
		}
	}

	@EventHandler
	public void onTimeLordado(PlayerMoveEvent e) {
		if (frozenPlayers.contains(e.getPlayer().getName())) {
			e.getPlayer().teleport(e.getPlayer());
		}
	}
}
