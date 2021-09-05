package me.thauandev.menus;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;



public class TodosKits2Menu {
	
	public static ItemStack criarItemMenu(Material material, String nome, String[] habilidade){
		
		ItemStack item = new ItemStack(material);
		ItemMeta kitem = item.getItemMeta();
		kitem.setDisplayName(nome);
		kitem.setLore(Arrays.asList(habilidade));
		item.setItemMeta(kitem);
		
		return item;
	}
	@SuppressWarnings("deprecation")
	public static void inventory(Player p){
		
		Inventory menu = Bukkit.createInventory(p, 54, "§7➳ §9§lTODOS OS KITS §8(pág. 2)");
		
		ItemStack maiskits = new ItemStack(Material.getMaterial(351), 1, (short)1);
		ItemMeta kmaiskits = maiskits.getItemMeta();
		kmaiskits.setDisplayName("§7➳ §c§lPAGINA ANTERIOR");
		maiskits.setItemMeta(kmaiskits);
		
		ItemStack kits = new ItemStack(Material.getMaterial(54));
		ItemMeta kkits = kits.getItemMeta();
		kkits.setDisplayName("§7➳ §a§lSEUS KITS");
		kits.setItemMeta(kkits);
		
		ItemStack lojadekits = new ItemStack(Material.getMaterial(388));
		ItemMeta klojadekits = lojadekits.getItemMeta();
		klojadekits.setDisplayName("§7➳ §2§lLOJA DE KITS");
		lojadekits.setItemMeta(klojadekits);
		
		ItemStack padraokit = new ItemStack(Material.getMaterial(351),1,(short)6);
		ItemMeta kpadraokit = padraokit.getItemMeta();
		kpadraokit.setDisplayName("§7➳ §3§lKIT PADRAO");
		kpadraokit.setLore(Arrays.asList("§7Facilite seu modo de jogo", "§7usando o sistema §e§lPADRAO KIT.", " "));
		padraokit.setItemMeta(kpadraokit);
		
		ItemStack todososkits = new ItemStack(Material.getMaterial(399));
		ItemMeta ktodososkits = todososkits.getItemMeta();
		ktodososkits.setDisplayName("§7➳ §9§lTODOS OS KITS");
		todososkits.setItemMeta(ktodososkits);
		
		ItemStack ConfigureKit = new ItemStack(Material.TNT);
		ItemMeta kConfigureKit = ConfigureKit.getItemMeta();
		kConfigureKit.setDisplayName("§7➳ §6§lCUSTOM KIT");
		kConfigureKit.setLore(Arrays.asList("§c§l[§4§lEM BREVE§c§l] ", "§7Configure seu kit", "§7para uma melhor jogabilidade.", " "));
		ConfigureKit.setItemMeta(kConfigureKit);
		
		ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)11);
		ItemMeta kvidro = vidro.getItemMeta();
		kvidro.setDisplayName("§b§lSLASH§f§lMC");
		vidro.setItemMeta(kvidro);

		ItemStack vidro1 = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)0);
		ItemMeta kvidro1 = vidro1.getItemMeta();
		kvidro.setDisplayName("§b§lSLASH§f§lMC");
		vidro.setItemMeta(kvidro1);
		
		ItemStack cake = new ItemStack(Material.COOKIE);
		ItemMeta kcake = cake.getItemMeta();
		kvidro.setDisplayName("§6§lCookie!");
		vidro.setItemMeta(kcake);
		
		menu.setItem(0, padraokit);
		menu.setItem(8, padraokit);
		  menu.setItem(1, vidro1);
		  menu.setItem(2, vidro);
		  menu.setItem(6, vidro);
		  menu.setItem(7, vidro1);
		  menu.setItem(9, vidro1);
		  menu.setItem(10, vidro);
		  menu.setItem(11, vidro1);
		  menu.setItem(12, vidro);
		  menu.setItem(13, vidro1);
		  menu.setItem(14, vidro);
		  menu.setItem(15, vidro1);
		  menu.setItem(16, vidro);
		  menu.setItem(17, vidro1);
		  menu.setItem(18, vidro);
		  menu.setItem(26, vidro);
		  menu.setItem(27, maiskits);
		  menu.setItem(35, vidro1);
		  menu.setItem(36, vidro1);
		  menu.setItem(44, vidro1);
		  menu.setItem(45, vidro);
		  menu.setItem(46, vidro1);
		  menu.setItem(47, vidro);
		  menu.setItem(48, vidro1);
		  menu.setItem(49, ConfigureKit);
		  menu.setItem(50, vidro1);
		  menu.setItem(51, vidro);
		  menu.setItem(52, vidro1);
		  menu.setItem(53, vidro);
		
		menu.setItem(3, todososkits);
		menu.setItem(4, kits);
		menu.setItem(5, lojadekits);
		
		menu.setItem(27, maiskits);
		
		menu.addItem(criarItemMenu(Material.getMaterial(120), "§bEndermage", new String[] {"§9§lHABILIDADE §7Puxe os Players até voçê"}));
		menu.addItem(criarItemMenu(Material.WATCH, "§bStrong", new String[] {"§9§lHABILIDADE §7Fique fulliron por 10s"}));
		menu.addItem(criarItemMenu(Material.APPLE, "§bSumo", new String[] {"§9§lHABILIDADE §7Você é tão gordo que joga ", "§7seus inimigos pro alto"}));
		p.openInventory(menu);
	}
}
