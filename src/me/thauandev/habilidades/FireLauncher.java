package me.thauandev.habilidades;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import me.thauandev.API.CooldownAPI;
import me.thauandev.API.KitAPI;
import com.github.caaarlowsz.speedmc.kitpvp.SpeedPvP;

public class FireLauncher implements Listener {

	public static ArrayList<Player> inFire = new ArrayList<>();

	@EventHandler
	public void clickar(PlayerInteractEvent e) {

		final Player p = e.getPlayer();

		if ((p.getItemInHand().getType() == Material.BLAZE_POWDER) && (KitAPI.getKit(p) == "FireLauncher")
				&& (CooldownAPI.Cooldown.containsKey(p.getName()))) {
			e.setCancelled(true);
			p.sendMessage("�fO seu �3�lCOOLDOWN �facaba em: �c�l" + CooldownAPI.Cooldown(p) + "s");
		} else {
			if ((p.getItemInHand().getType() == Material.BLAZE_POWDER) && (KitAPI.getKit(p) == "FireLauncher")
					&& (!CooldownAPI.Cooldown.containsKey(p.getName()))) {
				p.sendMessage("�aVoc� ativou a sua habilidade!");

				CooldownAPI.addCooldown(p, 35);
				inFire.add(p);

				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(SpeedPvP.getPlugin(), new Runnable() {
					public void run() {

						if (inFire.contains(p)) {
							inFire.remove(p);
						}
					}
				}, 10 * 20);

				p.getPlayer().getWorld().playEffect(p.getPlayer().getLocation(), Effect.MOBSPAWNER_FLAMES, 9999999,
						9999999);
				p.getPlayer().getWorld().playEffect(p.getPlayer().getLocation(), Effect.SMOKE, 9999999, 99999);
				p.getPlayer().playSound(p.getPlayer().getLocation(), Sound.BLAZE_HIT, 10.0F, 10.0F);
				if (inFire.contains(p)) {
					for (Entity s : p.getNearbyEntities(10.5, 1, 10.5)) {
						if (s instanceof Player) {
							Player t = (Player) s;

							t.getPlayer().getWorld().playEffect(t.getPlayer().getLocation(), Effect.SMOKE, 9999999,
									9999999);
							t.sendMessage("�7Voc� est� sendo atacado por um �2�lFirelauncher�7!");

							Vector vector = t.getLocation().getDirection();
							vector.multiply(0.0F);
							vector.setY(1.2F);
							t.setVelocity(vector);
							t.setFireTicks(150);

						}
					}
				}
			}
		}
	}
}
