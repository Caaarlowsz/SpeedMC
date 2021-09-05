package me.thauandev.menus;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.thauandev.configuração.cfGrupo;
import me.thauandev.configuração.cfPermissão;

public class LojaMenu {

	public static ItemStack criarItemMenu(Material material, String nome, String[] habilidade) {

		ItemStack item = new ItemStack(material);
		ItemMeta kitem = item.getItemMeta();
		kitem.setDisplayName(nome);
		kitem.setLore(Arrays.asList(habilidade));
		item.setItemMeta(kitem);

		return item;
	}

	public static void inventory(Player p) {

		Inventory menu = Bukkit.createInventory(p, 54, "§2§lLOJA DE KITS");

		ItemStack maiskits = new ItemStack(Material.getMaterial(351), 1, (short) 10);
		ItemMeta kmaiskits = maiskits.getItemMeta();
		kmaiskits.setDisplayName("§a§lPROXIMA PAGINA");
		maiskits.setItemMeta(kmaiskits);

		ItemStack menoskits = new ItemStack(Material.getMaterial(351), 1, (short) 8);
		ItemMeta kmenoskits = menoskits.getItemMeta();
		kmenoskits.setDisplayName("§c§lPAGINA ANTERIOR");
		menoskits.setItemMeta(kmenoskits);

		ItemStack kits = new ItemStack(Material.ENDER_CHEST);
		ItemMeta kkits = kits.getItemMeta();
		kkits.setDisplayName("§bSeus kits");
		kits.setItemMeta(kkits);

		ItemStack warp0 = new ItemStack(Material.COMPASS);
		ItemMeta kwarp0 = warp0.getItemMeta();
		kwarp0.setDisplayName("§bWarps");
		warp0.setItemMeta(kwarp0);

		ItemStack lojadekits = new ItemStack(Material.getMaterial(116));
		ItemMeta klojadekits = lojadekits.getItemMeta();
		klojadekits.setDisplayName("§bLoja de Kits");
		lojadekits.setItemMeta(klojadekits);

		ItemStack nada = new ItemStack(Material.AIR);
		ItemMeta knada = nada.getItemMeta();
		nada.setItemMeta(knada);

		ItemStack padraokit = new ItemStack(Material.getMaterial(351), 1, (short) 6);
		ItemMeta kpadraokit = padraokit.getItemMeta();
		kpadraokit.setDisplayName("§3§lKIT PADRAO");
		kpadraokit.setLore(Arrays.asList("§7Facilite seu modo de jogo", "§7usando o sistema §e§lPADRAO KIT.", " "));
		padraokit.setItemMeta(kpadraokit);

		ItemStack todososkits = new ItemStack(Material.WOOL, 1, (short) 11);
		ItemMeta ktodososkits = todososkits.getItemMeta();
		ktodososkits.setDisplayName("§9§lTODOS OS KITS");
		todososkits.setItemMeta(ktodososkits);

		ItemStack ranks = new ItemStack(Material.WOOL, 1, (short) 14);
		ItemMeta kranks = ranks.getItemMeta();
		kranks.setDisplayName("§5§lRANKS");
		ranks.setItemMeta(kranks);

		ItemStack ConfigureKit = new ItemStack(Material.TNT);
		ItemMeta kConfigureKit = ConfigureKit.getItemMeta();
		kConfigureKit.setDisplayName("§bCUSTOM KIT");
		kConfigureKit.setLore(Arrays.asList("§c§l[§4§lEM BREVE§c§l] ", "§7Configure seu kit",
				"§7para uma melhor jogabilidade.", " "));
		ConfigureKit.setItemMeta(kConfigureKit);

		ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
		ItemMeta kvidro = vidro.getItemMeta();
		kvidro.setDisplayName("§c§lSPEED§f§lMC");
		vidro.setItemMeta(kvidro);

		ItemStack vidro1 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 5);
		ItemMeta kvidro1 = vidro1.getItemMeta();
		kvidro.setDisplayName("§c§lSPEED§f§lMC");
		vidro.setItemMeta(kvidro1);

		menu.setItem(0, menoskits);
		menu.setItem(8, maiskits);
		menu.setItem(1, nada);
		menu.setItem(2, nada);
		menu.setItem(6, nada);
		menu.setItem(7, nada);
		menu.setItem(9, vidro1);
		menu.setItem(10, vidro1);
		menu.setItem(11, vidro1);
		menu.setItem(12, vidro1);
		menu.setItem(13, vidro1);
		menu.setItem(14, vidro1);
		menu.setItem(15, vidro1);
		menu.setItem(16, vidro1);
		menu.setItem(17, vidro1);
		menu.setItem(18, nada);
		menu.setItem(26, nada);
		menu.setItem(27, nada);
		menu.setItem(35, nada);
		menu.setItem(36, nada);
		menu.setItem(44, nada);
		menu.setItem(45, nada);
		menu.setItem(46, nada);
		menu.setItem(47, nada);
		menu.setItem(48, nada);
		menu.setItem(49, nada);
		menu.setItem(50, nada);
		menu.setItem(51, nada);
		menu.setItem(52, nada);
		menu.setItem(53, nada);

		menu.setItem(3, warp0);
		menu.setItem(4, kits);
		menu.setItem(5, lojadekits);
		menu.setItem(8, maiskits);

		if (cfGrupo.ChecarGrupo(p, "Membro")) {

			if (!cfPermissão.getPermissao(p, "kit.monk")) {
				menu.addItem(criarItemMenu(Material.BLAZE_ROD, "§cMonk §c§l15.000",
						new String[] { "§7Confuda o inventraio de", "§7seus inimigos" }));
			} else {
				p.closeInventory();
				menu.remove(Material.BLAZE_ROD);
			}
			if (!cfPermissão.getPermissao(p, "kit.ninja")) {
				menu.addItem(criarItemMenu(Material.COMPASS, "§cNinja §c§l17.000",
						new String[] { "§7Aperte shift para teleportar ao", "§7ultimo jogador hitado" }));
			} else {
				p.closeInventory();
				menu.remove(Material.COMPASS);
			}
			if (!cfPermissão.getPermissao(p, "kit.antitower")) {
				menu.addItem(criarItemMenu(Material.GOLD_HELMET, "§cAntiTower §c§l20.000",
						new String[] { "§7Não leve dano de queda, não tome", " §7dano seja morto por stomper",
								" §7,não seja puxado por endermage!" }));
			} else {
				p.closeInventory();
				menu.remove(Material.GOLD_HELMET);
			}
			if (!cfPermissão.getPermissao(p, "kit.phantom")) {
				menu.addItem(criarItemMenu(Material.FEATHER, "§cPhantom §c§l15.000",
						new String[] { "§7Use a pena para virar", "§7um passaro e voar" }));
			} else {
				p.closeInventory();
				menu.remove(Material.FEATHER);
			}
			if (!cfPermissão.getPermissao(p, "kit.grappler")) {
				menu.addItem(criarItemMenu(Material.LEASH, "§cGrappler §c§l17.000",
						new String[] { "§7Use seu laço para se", "§7locomover pelo mapa" }));
			} else {
				p.closeInventory();
				menu.remove(Material.LEASH);
			}
			if (!cfPermissão.getPermissao(p, "kit.viper")) {
				menu.addItem(criarItemMenu(Material.SPIDER_EYE, "§cViper §c§l10.000",
						new String[] { "§7Invenene seus inimigos", "§7ao bater neles" }));
			} else {
				p.closeInventory();
				menu.remove(Material.SPIDER_EYE);
			}
			if (!cfPermissão.getPermissao(p, "kit.snail")) {
				menu.addItem(criarItemMenu(Material.STRING, "§cSnail §c§l10.000",
						new String[] { "§7Deixe seus inimigos lerdos" }));
			} else {
				p.closeInventory();
				menu.remove(Material.STRING);
			}
		}
		if (cfGrupo.ChecarGrupo(p, "Membro")
				|| (cfGrupo.ChecarGrupo(p, "Light") || (cfGrupo.ChecarGrupo(p, "Trial")))) {

			if (!cfPermissão.getPermissao(p, "kit.hulk")) {
				menu.addItem(criarItemMenu(Material.SADDLE, "§cHulk §c§l15.000",
						new String[] { "§7Puxe seus inimigos para carcunda", "§7e critique eles" }));
			} else {
				p.closeInventory();
				menu.remove(Material.SADDLE);
			}
			if (!cfPermissão.getPermissao(p, "kit.timelord")) {
				menu.addItem(criarItemMenu(Material.WATCH, "§cTimelord §c§l15.000",
						new String[] { "§7Congele os players de", "§7sua volta" }));
			} else {
				p.closeInventory();
				menu.remove(Material.WATCH);
			}
			if (!cfPermissão.getPermissao(p, "kit.thor")) {
				menu.addItem(criarItemMenu(Material.WOOD_AXE, "§cThor §c§l15.000",
						new String[] { "§7Vire o thor e lançe raios", "§7em seus inimigos" }));
			} else {
				p.closeInventory();
				menu.remove(Material.WOOD_AXE);
			}
			if (!cfPermissão.getPermissao(p, "kit.switcher")) {
				menu.addItem(criarItemMenu(Material.SNOW_BALL, "§cSwitcher §c§l10.000",
						new String[] { "§7Troque de lugar com seus inimigos ao", "§7acertar uma bola de neve nele" }));
			} else {
				p.closeInventory();
				menu.remove(Material.SNOW_BALL);
			}
			if (!cfPermissão.getPermissao(p, "kit.gladiator")) {
				menu.addItem(criarItemMenu(Material.IRON_FENCE, "§cGladiator §c§l30.000",
						new String[] { "§7Puxe seus inimigos para", "§7um 1v1 na jaula" }));
			} else {
				p.closeInventory();
				menu.remove(Material.IRON_FENCE);
			}
		}
		if (cfGrupo.ChecarGrupo(p, "Membro") || (cfGrupo.ChecarGrupo(p, "Light")
				|| (cfGrupo.ChecarGrupo(p, "Mvp") || (cfGrupo.ChecarGrupo(p, "Trial"))))) {

			if (!cfPermissão.getPermissao(p, "kit.stomper")) {
				menu.addItem(criarItemMenu(Material.IRON_BOOTS, "§cStomper §c§l35.000",
						new String[] { "§7Ao cair em cima de seus", "§7inimigos esmague-os" }));
			} else {
				p.closeInventory();
				menu.remove(Material.IRON_BOOTS);
			}
			if (!cfPermissão.getPermissao(p, "kit.magma")) {
				menu.addItem(criarItemMenu(Material.FIRE, "§cMagma §c§l17.000",
						new String[] { "§7Ao bater em seu inimigo", "§7tenha chançe de colocar fogo nele" }));
			} else {
				p.closeInventory();
				menu.remove(Material.FIRE);
			}
			if (!cfPermissão.getPermissao(p, "kit.grandpa")) {
				menu.addItem(criarItemMenu(Material.STICK, "§cGrandpa §c§l10.000",
						new String[] { "§7Jogue seu inimigo longe", "§7usando seu stick" }));
			} else {
				p.closeInventory();
				menu.remove(Material.STICK);
			}
			if (!cfPermissão.getPermissao(p, "kit.ajnin")) {
				menu.addItem(criarItemMenu(Material.NETHER_STAR, "§cAjnin §c§l20.000",
						new String[] { "§7Ao apertar shift o ultimo", "§7jogador hitado é teleportado a você" }));
			} else {
				p.closeInventory();
				menu.remove(Material.NETHER_STAR);
			}
			if (!cfPermissão.getPermissao(p, "kit.firelauncher")) {
				menu.addItem(criarItemMenu(Material.FIREBALL, "§cFireLauncher §c§l15.000",
						new String[] { "§7Use seu kit para", "§7queimar seus inimigos" }));
			} else {
				p.closeInventory();
				menu.remove(Material.FIREBALL);
			}
		}
		ItemStack PossuiTodos = new ItemStack(Material.SKULL_ITEM);
		ItemMeta kPossuiTodos = kits.getItemMeta();
		kPossuiTodos.setDisplayName("§3§lDEFAULT§f§lMC §fVoce §a§lPOSSUI §fTodos os §9§lKITS§f!");
		PossuiTodos.setItemMeta(kPossuiTodos);

		if (cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Youtuber+")
				|| (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Admin")
						|| (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Dono"))))))))) {
			menu.setItem(31, PossuiTodos);
		}

		if ((cfPermissão.getPermissao(p, "kit.monk") && cfPermissão.getPermissao(p, "kit.ninja")
				&& cfPermissão.getPermissao(p, "kit.phantom") && cfPermissão.getPermissao(p, "kit.grappler")
				&& cfPermissão.getPermissao(p, "kit.viper") && cfPermissão.getPermissao(p, "kit.snail")
				&& cfPermissão.getPermissao(p, "kit.hulk") && cfPermissão.getPermissao(p, "kit.timelord")
				&& (cfPermissão.getPermissao(p, "kit.thor") && cfPermissão.getPermissao(p, "kit.switcher")
						&& cfPermissão.getPermissao(p, "kit.gladiator") && cfPermissão.getPermissao(p, "kit.endermage")
						&& cfPermissão.getPermissao(p, "kit.stomper") && cfPermissão.getPermissao(p, "kit.firelauncher")
						&& cfPermissão.getPermissao(p, "kit.strong") && cfPermissão.getPermissao(p, "kit.sumo")
						&& cfPermissão.getPermissao(p, "kit.forcefield") && cfPermissão.getPermissao(p, "kit.magma")
						&& cfPermissão.getPermissao(p, "kit.grandpa") && cfPermissão.getPermissao(p, "kit.ajnin")))) {

			menu.setItem(31, PossuiTodos);

		}

		p.openInventory(menu);
	}
}
