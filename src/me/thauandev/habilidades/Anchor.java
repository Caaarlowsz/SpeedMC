package me.thauandev.habilidades;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.util.Vector;

import me.thauandev.API.KitAPI;
import me.thauandev.main.Main;

public class Anchor implements Listener {
	@EventHandler(priority = EventPriority.MONITOR)
	public void onPlayerHitAnchor(EntityDamageByEntityEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		if (!(e.getDamager() instanceof Player)) {
			return;
		}
		final Player p = (Player) e.getEntity();
		Player a = (Player) e.getDamager();
		if (KitAPI.getKit(p).equalsIgnoreCase("Anchor")) {
			p.setVelocity(new Vector());
			p.playSound(p.getLocation(), Sound.ANVIL_BREAK, 4.0F, 4.0F);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
				public void run() {
					p.setVelocity(new Vector());
				}
			}, 1L);
		}
		if (KitAPI.getKit(a).equalsIgnoreCase("Anchor")) {
			a.playSound(a.getLocation(), Sound.ANVIL_BREAK, 4.0F, 4.0F);
			p.setVelocity(new Vector());
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
				public void run() {
					p.setVelocity(new Vector());
				}
			}

					, 1L);
		}

	}
}