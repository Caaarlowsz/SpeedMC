package me.thauandev.habilidades;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import me.thauandev.API.CooldownAPI;
import me.thauandev.API.KitAPI;

public class Hulk implements Listener {

	@EventHandler
	public void hulk(PlayerInteractEntityEvent event) {
		if (!(event.getRightClicked() instanceof Player)) {
			return;
		}
		final Player p = event.getPlayer();
		final Player r = (Player) event.getRightClicked();
		if ((p.getItemInHand().getType() == Material.AIR) && (KitAPI.getKit(p) == "Hulk")
				&& (!CooldownAPI.Cooldown.containsKey(p.getName()) && (p.getPassenger() == null)
						&& (r.getPassenger() == null))) {
			p.setPassenger(r);
			CooldownAPI.addCooldown(p, 15);
			return;
		}
		if ((p.getItemInHand().getType() == Material.AIR) && (KitAPI.getKit(p) == "Hulk")
				&& (CooldownAPI.Cooldown.containsKey(p.getName()) && (p.getPassenger() == null)
						&& (r.getPassenger() == null))) {
			p.sendMessage("§fO seu §3§lCOOLDOWN §facaba em: §c§l" + CooldownAPI.Cooldown(p) + "s");
		}
	}

	@EventHandler
	public static void playerInteract(PlayerInteractEvent event) {
		if (!event.getAction().equals(Action.LEFT_CLICK_AIR)) {
			return;
		}
		Player player = event.getPlayer();
		if ((player.getPassenger() == null) || (!(player.getPassenger() instanceof Player))) {
			return;
		}
		Player pass = (Player) player.getPassenger();
		player.eject();
		pass.damage(0.0D, player);
		pass.setVelocity(new Vector(pass.getVelocity().getX(), 1.0D, pass.getVelocity().getZ()));
	}

}
