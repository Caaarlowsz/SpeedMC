package me.thauandev.menus;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class LojaVips {
	public static ItemStack criarItemMenu(Material material, String nome, String[] habilidade){
		
		ItemStack item = new ItemStack(material);
		ItemMeta kitem = item.getItemMeta();
		kitem.setDisplayName(nome);
		kitem.setLore(Arrays.asList(habilidade));
		item.setItemMeta(kitem);
		
		return item;
	}
	public static void inventory(Player p){
		
		Inventory menu = Bukkit.createInventory(p, 9, "§7Qual §b§lVIP §7deseja?");
		
		menu.setItem(2, criarItemMenu(Material.EMERALD_BLOCK, "§a§lLIGHT", new String[] {" ", "                   §7◿ §7§lBeneficios §7◿", "§7- §7§lSLOT EXCLUSIVO EM NOSSO SERVIDOR", "§7- §7§lTAG §a§lLIGHT §7§lPARA SER DIFRENCIADO", "§7- §7§lACESSO A 11 KITS DO SERVIDOR", " "}));
		menu.setItem(4, criarItemMenu(Material.GOLD_BLOCK, "§6§lPREMIUM", new String[] {" ", "                   §7◿ §7§lBeneficios §7◿", "§7- §7§lSLOT EXCLUSIVO EM NOSSO SERVIDOR", "§7- §7§lTAG §a§lLIGHT §7e §6§lPREMIUM §7§lPARA SER DIFRENCIADO", "§7- §7§lACESSO A 16 KITS DO SERVIDOR", " "}));
		menu.setItem(6, criarItemMenu(Material.PORTAL, "§d§lULTIMATE", new String[] {" ", "                   §7◿ §7§lBeneficios §7◿", "§7- §7§lSLOT EXCLUSIVO EM NOSSO SERVIDOR", "§7- §7§lTAG §a§lLIGHT§7, §6§lPREMIUM §7e §d§lULTIMATE §7§lPARA SER DIFRENCIADO", "§7- §7§lACESSO A TODOS KITS DO SERVIDOR", " "}));
		
		p.openInventory(menu);
	}
}
