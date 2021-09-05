package me.thauandev.habilidades;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import me.thauandev.API.KitAPI;

public class AntiTower implements Listener {
	@EventHandler
	public void aogalinha(final EntityDamageEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
			final Player p = (Player) e.getEntity();
			if (KitAPI.getKit(p) == "AntiTower") {
				e.setDamage(6.0D);
			}
		}
	}
}