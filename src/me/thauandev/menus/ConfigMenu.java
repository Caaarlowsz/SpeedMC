package me.thauandev.menus;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ConfigMenu {
	public static ItemStack criarItemMenu(Material material, String nome, String[] habilidade) {

		ItemStack item = new ItemStack(material);
		ItemMeta kitem = item.getItemMeta();
		kitem.setDisplayName(nome);
		kitem.setLore(Arrays.asList(habilidade));
		item.setItemMeta(kitem);

		return item;
	}

	public static void inventory(Player p) {

		Inventory menu = Bukkit.createInventory(p, 27, "§8§lMenu");

		menu.setItem(9, criarItemMenu(Material.getMaterial(379), "§f§lSite Principal", new String[] { " ",
				"                    §b§lCLIQUE                    ", "      §7Para Visitar nosso site!     ", " " }));
		menu.setItem(11,
				criarItemMenu(Material.REDSTONE, "§f§lYou§c§lTube",
						new String[] { " ", "                    §b§lCLIQUE                    ",
								"     §7Para Visitar nosso canal no Youtube!     ", " " }));
		menu.setItem(13,
				criarItemMenu(Material.getMaterial(58), "§7§lTeamSpeak",
						new String[] { " ", "                    §b§lCLIQUE                    ",
								"      §7Para Visitar nosso TeamSpeak!     ", " " }));
		menu.setItem(15,
				criarItemMenu(Material.LAPIS_BLOCK, "§3§lDiscord",
						new String[] { " ", "                    §b§lCLIQUE                    ",
								"      §7Para Visitar nosso Discord!     ", " " }));
		menu.setItem(17, criarItemMenu(Material.DIAMOND, "§b§lTwitter", new String[] { " ",
				"                    §b§lCLIQUE                    ", "    §7Para Visitar nosso Twitter!     ", " " }));

		p.openInventory(menu);
	}
}