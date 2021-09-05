package me.thauandev.menus;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class LojaPermsMenu {
	public static ItemStack criarItemMenu(Material material, String nome, String[] habilidade) {

		ItemStack item = new ItemStack(material);
		ItemMeta kitem = item.getItemMeta();
		kitem.setDisplayName(nome);
		kitem.setLore(Arrays.asList(habilidade));
		item.setItemMeta(kitem);

		return item;
	}

	public static void inventory(Player p) {

		Inventory menu = Bukkit.createInventory(p, 27, "§5§lPERMS");

		menu.setItem(13,
				criarItemMenu(Material.NAME_TAG, "§7Tag §2§lWINNER §7- §8§l30.000",
						new String[] { " ", "                    §b§lCLIQUE                    ",
								"    §7Para Comprar a tag §2§lWINNER§7!     ", " " }));

		p.openInventory(menu);
	}
}