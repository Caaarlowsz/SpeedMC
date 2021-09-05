package me.thauandev.menus;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class YoutuberMenu {
	public static ItemStack criarItemMenu(Material material, String nome, String[] habilidade) {

		ItemStack item = new ItemStack(material);
		ItemMeta kitem = item.getItemMeta();
		kitem.setDisplayName(nome);
		kitem.setLore(Arrays.asList(habilidade));
		item.setItemMeta(kitem);

		return item;
	}

	public static void inventory(Player p) {

		Inventory menu = Bukkit.createInventory(p, 27, "§b§lYOUTUBER");

		menu.setItem(10, criarItemMenu(Material.GOLD_BLOCK, "§e§lPLATINUM", new String[] { " ",
				"                    §b§lCLIQUE                    ", "          §7§lPARA MAIS INFORMAÇOES", " " }));
		menu.setItem(13, criarItemMenu(Material.DIAMOND_BLOCK, "§b§lYOUTUBER", new String[] { " ",
				"                    §b§lCLIQUE                    ", "          §7§lPARA MAIS INFORMAÇOES", " " }));
		menu.setItem(16, criarItemMenu(Material.LAPIS_BLOCK, "§3§lYOUTUBER+", new String[] { " ",
				"                    §b§lCLIQUE                    ", "          §7§lPARA MAIS INFORMAÇOES", " " }));

		p.openInventory(menu);
	}
}