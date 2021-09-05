package me.thauandev.habilidades;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import me.thauandev.API.CooldownAPI;
import me.thauandev.API.KitAPI;
import me.thauandev.main.Main;

public class MiniGun implements Listener {

	private static Integer shed_id = null;

	@EventHandler
	public void onTntLaunch(PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (KitAPI.getKit(p).equalsIgnoreCase("MiniGun") && (p.getItemInHand().getType() == Material.ARROW)) {
			if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
				e.setCancelled(true);
				if (CooldownAPI.Cooldown.containsKey(p.getName())) {
					p.sendMessage("§fO seu §3§lCOOLDOWN §facaba em: §c§l" + CooldownAPI.Cooldown(p) + "s");
					return;
				}
				CooldownAPI.addCooldown(p, 40);
				cancel();
				shed_id = Integer.valueOf(
						Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable() {
							public void run() {
								Location loc = p.getLocation();
								loc.setY(loc.getY() + 0.5D);
								Arrow h = (Arrow) p.launchProjectile(Arrow.class);
								Vector velo1 = p.getLocation().getDirection().normalize().multiply(2);
								h.setVelocity(velo1);
							}
						}, 2L, 2L));
				Bukkit.getServer().getScheduler().scheduleAsyncDelayedTask(Main.plugin, new Runnable() {
					public void run() {
						MiniGun.cancel();
					}
				}, 120L);
			}
		}
	}

	@EventHandler
	public void Projectile(ProjectileHitEvent e) {
		if (e.getEntity().getType() == EntityType.ARROW)
			e.getEntity().remove();
	}

	public static void cancel() {
		if (shed_id != null) {
			Bukkit.getServer().getScheduler().cancelTask(shed_id.intValue());
			shed_id = null;
		}
	}
}
