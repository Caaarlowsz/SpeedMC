package me.thauandev.menus;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import me.thauandev.account.AccountUtils;
import me.thauandev.account.CheckUtils;
import me.thauandev.configuração.cfStatus;

public class PerfilMenu implements Listener {
	
	public static ItemStack criarItemMenu(Material material, String nome, String[] habilidade){
		
		ItemStack item = new ItemStack(material);
		ItemMeta kitem = item.getItemMeta();
		kitem.setDisplayName(nome);
		kitem.setLore(Arrays.asList(habilidade));
		item.setItemMeta(kitem);
		
		return item;
	}
	@SuppressWarnings({ })
	public static void inventory(Player p){
		
		Inventory menu = Bukkit.createInventory(p, 54, "§5§lPERFIL");

		ItemStack perfil = new ItemStack(Material.SKULL_ITEM,1,(short)3);
	    SkullMeta meta = (SkullMeta) perfil.getItemMeta();
		meta.setOwner(p.getName());
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("            §3§lINFO");
		lore.add("§7");
		lore.add("§c§m---(-)-----------------(-)---");
		lore.add("§7   Seu Nick: §b" + p.getName());
		lore.add("§7   Ranking: " + CheckUtils.Grupo(p));
		lore.add("§7   Liga: " + AccountUtils.getRankOffline(p) + " " + AccountUtils.getRankNomeOffline(p));
		lore.add("§c§m---(-)-----------------(-)---");
		meta.setLore(lore);
		
		ItemStack kills = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta kkills = kills.getItemMeta();
		kkills.setDisplayName("§a§lKILLS");
		kills.setItemMeta(kkills);
		lore.add("§7");
		lore.add("§7Voce Matou: §a" + cfStatus.getKills(p)); 
		lore.add("§7");
		
		ItemStack deaths = new ItemStack(Material.REDSTONE);
		ItemMeta kdeaths = deaths.getItemMeta();
		kdeaths.setDisplayName("§c§lDEATHS");
		deaths.setItemMeta(kdeaths);
		lore.add("§7");
		lore.add("§7Voce Morreu: §c" + cfStatus.getDeaths(p)); 
		lore.add("§7");
		
		ItemStack moedas = new ItemStack(Material.EMERALD);
		ItemMeta kmoedas = moedas.getItemMeta();
		kmoedas.setDisplayName("§6§lMOEDAS");
		moedas.setItemMeta(kmoedas);
		lore.add("§7");
		lore.add("§7Voce Possui: §6" + cfStatus.getMoney(p) + " §6§lMOEDAS"); 
		lore.add("§7");
		
		ItemStack grupo = new ItemStack(Material.PUMPKIN);
		ItemMeta kgrupo = grupo.getItemMeta();
		kgrupo.setDisplayName("§3§lGRUPO");
		grupo.setItemMeta(kgrupo);
		
		ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)14);
		ItemMeta kvidro = vidro.getItemMeta();
		kvidro.setDisplayName("§c§lSPEED§f§lMC");
		vidro.setItemMeta(kvidro);

		ItemStack vidro1 = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)0);
		ItemMeta kvidro1 = vidro1.getItemMeta();
		kvidro.setDisplayName("§c§lSPEED§f§lMC");
		vidro.setItemMeta(kvidro1);
		
		  menu.setItem(0, vidro1);
		  menu.setItem(1, vidro);
		  menu.setItem(8, vidro1);
		  menu.setItem(7, vidro);
		  menu.setItem(9, vidro);
		  menu.setItem(17, vidro);
		  menu.setItem(20, kills);
		  menu.setItem(22, grupo);
		  menu.setItem(4, perfil);
		  menu.setItem(24, deaths);
		  menu.setItem(40, moedas);
		  menu.setItem(36, vidro);
		  menu.setItem(44, vidro);
		  menu.setItem(46, vidro);
		  menu.setItem(45, vidro1);
		  menu.setItem(52, vidro);
		  menu.setItem(53, vidro1);
		p.openInventory(menu);
	}
	@EventHandler
	public void abrirMenu(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if(p.getItemInHand().getType() == Material.ANVIL && me.thauandev.API.API.getWarp(p) == "Spawn" && e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK && p.getItemInHand().hasItemMeta() && p.getItemInHand().getItemMeta().hasDisplayName() && p.getItemInHand().getItemMeta().getDisplayName().equals("§6» §7Perfil")){
			} else {
				setarInventario(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 20L, 20L);
			}
		}
	private void setarInventario(Player p) {
		// TODO Auto-generated method stub
		
	}
	}
