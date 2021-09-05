package me.thauandev.menus;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import me.thauandev.API.API;

public class OpenInventory implements Listener {

	@EventHandler
	public void ranks(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (p.getItemInHand().getType() == Material.ANVIL && API.getWarp(p) == "Spawn"
				&& e.getAction() == Action.RIGHT_CLICK_AIR
				|| e.getAction() == Action.RIGHT_CLICK_BLOCK && p.getItemInHand().hasItemMeta()
						&& p.getItemInHand().getItemMeta().hasDisplayName()
						&& p.getItemInHand().getItemMeta().getDisplayName().equals("§6» §7ver ranks")) {
			p.chat("/perfil");
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 20L, 20L);
		}
	}

	@EventHandler
	public void perfil(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (p.getItemInHand().getType() == Material.PAPER && API.getWarp(p) == "Spawn"
				&& e.getAction() == Action.RIGHT_CLICK_AIR
				|| e.getAction() == Action.RIGHT_CLICK_BLOCK && p.getItemInHand().hasItemMeta()
						&& p.getItemInHand().getItemMeta().hasDisplayName()
						&& p.getItemInHand().getItemMeta().getDisplayName().equals("§6» §7ver seu perfil")) {
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 20L, 20L);
			ConfigMenu.inventory(p);
		}
	}

	@EventHandler
	public void abrirMenuKits(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (p.getItemInHand().getType() == Material.ENDER_CHEST && API.getWarp(p) == "Spawn"
				&& e.getAction() == Action.RIGHT_CLICK_AIR
				|| e.getAction() == Action.RIGHT_CLICK_BLOCK && p.getItemInHand().hasItemMeta()
						&& p.getItemInHand().getItemMeta().hasDisplayName()
						&& p.getItemInHand().getItemMeta().getDisplayName().equals("§6» §7Seletor de KITS")) {
			KitsMenu.inventory(p);
			p.playSound(p.getLocation(), Sound.CHEST_OPEN, 20L, 20L);
		}
	}

	@EventHandler
	public void abrirMenuWarps(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (p.getItemInHand().getType() == Material.COMPASS && API.getWarp(p) == "Spawn"
				&& e.getAction() == Action.RIGHT_CLICK_AIR
				|| e.getAction() == Action.RIGHT_CLICK_BLOCK && p.getItemInHand().hasItemMeta()
						&& p.getItemInHand().getItemMeta().hasDisplayName()
						&& p.getItemInHand().getItemMeta().getDisplayName().equals("§6» §7Seletor de WARPS")) {
			p.playSound(p.getLocation(), Sound.CHEST_OPEN, 20L, 20L);
			WarpsMenu.inventory(p);
		}
	}
}
