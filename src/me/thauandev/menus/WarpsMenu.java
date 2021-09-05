package me.thauandev.menus;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class WarpsMenu {
	public static ItemStack criarItemMenu(Material material, String nome, String[] habilidade) {

		ItemStack item = new ItemStack(material);
		ItemMeta kitem = item.getItemMeta();
		kitem.setDisplayName(nome);
		kitem.setLore(Arrays.asList(habilidade));
		item.setItemMeta(kitem);

		return item;
	}

	public static ItemStack possui;
	public static ItemMeta possuim;

	public static ItemStack vidro;
	public static ItemMeta vidrom;

	public static void inventory(Player p) {

		Inventory menu = Bukkit.createInventory(p, 54, "§bWarps");

		menu.setItem(22, criarItemMenu(Material.GLASS, "§bFps", new String[] { "§7Tenha um PvP com mais fps." }));
		menu.setItem(21, criarItemMenu(Material.BLAZE_ROD, "§b1v1", new String[] { "§7Faça 1v1 justo ." }));
		menu.setItem(23,
				criarItemMenu(Material.LAVA_BUCKET, "§bLavaChallenge", new String[] { "§7Tanquem até a ultima." }));
		menu.setItem(30, criarItemMenu(Material.STICK, "§bKnockBack",
				new String[] { "§7Vença seu inimigo usando seu Stick Magico." }));
		menu.setItem(31, criarItemMenu(Material.POTION, "§bMain", new String[] { "§7Lutem com suas forças." }));
		menu.setItem(32,
				criarItemMenu(Material.FISHING_ROD, "§bFisherman", new String[] { "§7Pesquem seus inimigos." }));
		menu.setItem(49, criarItemMenu(Material.BEDROCK, "§bEvento", new String[] { "§7Evento ganhador leva vip." }));

		ItemStack possui = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
		ItemMeta possuim = possui.getItemMeta();
		possuim.setDisplayName("§bWarps");
		possui.setItemMeta(possuim);

		ItemStack kits = new ItemStack(Material.getMaterial(54));
		ItemMeta kkits = kits.getItemMeta();
		kkits.setDisplayName("§bKits");
		kits.setItemMeta(kkits);

		ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 0);
		ItemMeta vidrom = vidro.getItemMeta();
		vidrom.setDisplayName("§bWarps");
		vidro.setItemMeta(vidrom);

		menu.setItem(0, possui);
		menu.setItem(1, vidro);
		menu.setItem(4, kits);
		menu.setItem(7, vidro);
		menu.setItem(8, possui);
		menu.setItem(9, vidro);
		menu.setItem(17, vidro);
		menu.setItem(36, vidro);
		menu.setItem(44, vidro);
		menu.setItem(45, possui);
		menu.setItem(46, vidro);
		menu.setItem(52, vidro);
		menu.setItem(53, possui);

		p.openInventory(menu);
	}
}
