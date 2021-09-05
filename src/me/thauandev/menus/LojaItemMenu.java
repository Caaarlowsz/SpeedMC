package me.thauandev.menus;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class LojaItemMenu implements Listener {
	
	public static void setarInventario(Player p) {
		Inventory inv = Bukkit.createInventory(null, 27, "§7§lLOJA");
		
		ItemStack kits = new ItemStack(Material.FIREWORK);
		ItemMeta kitsm = kits.getItemMeta();
		kitsm.setDisplayName("§fLoja de §9§lKITS");
		kits.setItemMeta(kitsm);
		
		ItemStack perms = new ItemStack(Material.NAME_TAG);
		ItemMeta permsm = perms.getItemMeta();
		permsm.setDisplayName("§fLoja de §5§lPERMS");
		perms.setItemMeta(permsm);
		
		ItemStack site = new ItemStack(Material.EMERALD);
		ItemMeta sitem = site.getItemMeta();
		sitem.setDisplayName("§fLoja §a§lONLINE");
		site.setItemMeta(sitem);
		
		inv.setItem(11, kits);
		inv.setItem(13, perms);
		inv.setItem(15, site);
		
		p.openInventory(inv);
	}
	@EventHandler
	public void abrirInv(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if(p.getItemInHand().getType() == Material.DIAMOND && me.thauandev.API.API.getWarp(p) == "Spawn" && e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK && p.getItemInHand().hasItemMeta() && p.getItemInHand().getItemMeta().hasDisplayName() && p.getItemInHand().getItemMeta().getDisplayName().equals("§6» §7Loja")) {
			setarInventario(p);
		}
	}
	@EventHandler
	public void clicarInv(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory().getTitle().equals("§7§lLOJA")) {
			if(e.getCurrentItem().getType() == Material.AIR) {
				e.setCancelled(true);
				return;
			}
			if(e.getCurrentItem().getType() == Material.FIREWORK) {
				e.setCancelled(true);
				LojaMenu.inventory(p);
				return;
			}
			if(e.getCurrentItem().getType() == Material.NAME_TAG) {
				e.setCancelled(true);
				p.closeInventory();
				LojaPermsMenu.inventory(p);
				return;
			}
			if(e.getCurrentItem().getType() == Material.EMERALD) {
				e.setCancelled(true);
				LojaVips.inventory(p);
			}
		}
	}
}

			
	