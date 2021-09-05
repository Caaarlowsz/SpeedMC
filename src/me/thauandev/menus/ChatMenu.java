package me.thauandev.menus;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ChatMenu {
	public static ItemStack criarItemMenu(Material material, String nome, String[] habilidade) {

		ItemStack item = new ItemStack(material);
		ItemMeta kitem = item.getItemMeta();
		kitem.setDisplayName(nome);
		kitem.setLore(Arrays.asList(habilidade));
		item.setItemMeta(kitem);

		return item;
	}

	public static void inventory(Player p) {

		Inventory menu = Bukkit.createInventory(p, 27, "§8§lCHAT");

		menu.setItem(10, criarItemMenu(Material.WOOL, "§f§lCLEAR", new String[] { " ",
				"                    §b§lCLIQUE                    ", "          §7§lPARA LIMPAR O CHAT", " " }));
		menu.setItem(13, criarItemMenu(Material.getMaterial(2257), "§a§lON", new String[] { " ",
				"                    §b§lCLIQUE                    ", "          §7§lPARA ATIVAR O CHAT", " " }));
		menu.setItem(16, criarItemMenu(Material.getMaterial(2259), "§c§lOFF", new String[] { " ",
				"                    §b§lCLIQUE                    ", "          §7§lPARA DESATIVAR O CHAT", " " }));

		p.openInventory(menu);
	}
}