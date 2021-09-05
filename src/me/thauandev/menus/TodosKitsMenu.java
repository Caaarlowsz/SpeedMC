package me.thauandev.menus;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class TodosKitsMenu {
	
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
		
		Inventory menu = Bukkit.createInventory(p, 54, "§9§lTODOS OS KITS");
		
		ItemStack maiskits = new ItemStack(Material.getMaterial(351), 1, (short)10);
		ItemMeta kmaiskits = maiskits.getItemMeta();
		kmaiskits.setDisplayName("§a§lPROXIMA PAGINA");
		maiskits.setItemMeta(kmaiskits);
		
		ItemStack menoskits = new ItemStack(Material.getMaterial(351), 1, (short)8);
		ItemMeta kmenoskits = menoskits.getItemMeta();
		kmenoskits.setDisplayName("§c§lPAGINA ANTERIOR");
		menoskits.setItemMeta(kmenoskits);
		
		ItemStack kits = new ItemStack(Material.WOOL, 1, (short)5);
		ItemMeta kkits = kits.getItemMeta();
		kkits.setDisplayName("§a§lSEUS KITS");
		kits.setItemMeta(kkits);
		
		ItemStack warp0 = new ItemStack(Material.WOOL, 1, (short)4);
		ItemMeta kwarp0 = warp0.getItemMeta();
		kwarp0.setDisplayName("§e§lWARPS");
		warp0.setItemMeta(kwarp0);
		
		ItemStack lojadekits = new ItemStack(Material.DIAMOND);
		ItemMeta klojadekits = lojadekits.getItemMeta();
		klojadekits.setDisplayName("§2§lLOJA DE KITS");
		lojadekits.setItemMeta(klojadekits);
		
		ItemStack nada = new ItemStack(Material.AIR);
		ItemMeta knada = nada.getItemMeta();
		nada.setItemMeta(knada);
		
		ItemStack padraokit = new ItemStack(Material.getMaterial(351),1,(short)6);
		ItemMeta kpadraokit = padraokit.getItemMeta();
		kpadraokit.setDisplayName("§3§lKIT PADRAO");
		kpadraokit.setLore(Arrays.asList("§7Facilite seu modo de jogo", "§7usando o sistema §e§lPADRAO KIT.", " "));
		padraokit.setItemMeta(kpadraokit);
		
		ItemStack todososkits = new ItemStack(Material.WOOL,1,(short)11);
		ItemMeta ktodososkits = todososkits.getItemMeta();
		ktodososkits.setDisplayName("§9§lTODOS OS KITS");
		todososkits.setItemMeta(ktodososkits);
		
		ItemStack ranks = new ItemStack(Material.WOOL,1,(short)14);
		ItemMeta kranks = ranks.getItemMeta();
		kranks.setDisplayName("§5§lRANKS");
		ranks.setItemMeta(kranks);
		
		ItemStack ConfigureKit = new ItemStack(Material.TNT);
		ItemMeta kConfigureKit = ConfigureKit.getItemMeta();
		kConfigureKit.setDisplayName("§bCUSTOM KIT");
		kConfigureKit.setLore(Arrays.asList("§c§l[§4§lEM BREVE§c§l] ", "§7Configure seu kit", "§7para uma melhor jogabilidade.", " "));
		ConfigureKit.setItemMeta(kConfigureKit);
		
		ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)11);
		ItemMeta kvidro = vidro.getItemMeta();
		kvidro.setDisplayName("§3§lDEFAULT§f§lMC");
		vidro.setItemMeta(kvidro);

		ItemStack vidro1 = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)0);
		ItemMeta kvidro1 = vidro1.getItemMeta();
		kvidro.setDisplayName("§3§lDEFAULT§f§lMC");
		vidro.setItemMeta(kvidro1);
		
		menu.setItem(0, menoskits);
		menu.setItem(8, maiskits);
		  menu.setItem(1, vidro);
		  menu.setItem(2, warp0);
		  menu.setItem(6, ranks);
		  menu.setItem(7, vidro);
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
		
		menu.setItem(5, todososkits);
		menu.setItem(3, kits);
		menu.setItem(4, lojadekits);
		menu.setItem(8, maiskits);
		
		menu.addItem(criarItemMenu(Material.STONE_SWORD, "§bPvP", new String[] {"§9§lHABILIDADE : §7Supere os adversários", "§7com a sua espada avançada!"}));
		menu.addItem(criarItemMenu(Material.BOW, "§bArcher", new String[] {"§9§lHABILIDADE : §7Use o seu Arco para", "§7combater seus inimigos!"}));
		menu.addItem(criarItemMenu(Material.FIREWORK, "§bKangaroo", new String[] {"§9§lHABILIDADE : §7Use a sua habilidade e", "§7dê pulos como um canguru!"}));
		menu.addItem(criarItemMenu(Material.FISHING_ROD, "§bFisherman", new String[] {"§9§lHABILIDADE : §7Pesque os seus inimigos e puxe-os até você!"}));
		menu.addItem(criarItemMenu(Material.ANVIL, "§bAnchor", new String[] {"§9§lHABILIDADE : §7Não tome,não de KnockBack!"}));
		menu.addItem(criarItemMenu(Material.CACTUS, "§bCactus", new String[] {"§9§lHABILIDADE : §7Vire um cacto e espete", "§7os seus inimigos"}));
		menu.addItem(criarItemMenu(Material.BLAZE_ROD, "§bMonk", new String[] {"§9§lHABILIDADE : §7Faça alterações no invetário", "§7inimigo!"}));
		menu.addItem(criarItemMenu(Material.COMPASS, "§bNinja", new String[] {"§9§lHABILIDADE: §7Teleporte-se até o", "§7último jogador hitado clicando Shift!"}));
		menu.addItem(criarItemMenu(Material.GOLD_HELMET, "§bAntiTower", new String[] {"§9§lHABILIDADE: §7Não leve dano de queda, não tome dano seja morto por stomper, não seja puxado por endermage!"}));
		menu.addItem(criarItemMenu(Material.FEATHER, "§bPhantom", new String[] {"§9§lHABILIDADE : §7Use as suas habilidades", "§7e voe igual um pássaro!"}));
		menu.addItem(criarItemMenu(Material.LEASH, "§bGrappler", new String[] {"§9§lHABILIDADE : §7Fisgue o seu laço em algo", "§7e divirta-se!"}));
		menu.addItem(criarItemMenu(Material.SPIDER_EYE, "§bViper", new String[] {"§9§lHABILIDADE : §7Aplique veneno nos", "§7inimigos e obtenha vantagem!"}));
		menu.addItem(criarItemMenu(Material.STRING, "§bSnail", new String[] {"§9§lHABILIDADE : §7Deixe seus adversários cansados e ataque-os!"}));
		menu.addItem(criarItemMenu(Material.SADDLE, "§bHulk", new String[] {"§9§lHABILIDADE : §7Puxe seus inimigos para cima", "§7de você e os deixe imóveis!"}));
		menu.addItem(criarItemMenu(Material.WATCH, "§bTimelord", new String[] {"§9§lHABILIDADE : §7Congele os jogadores", "§7a sua volta"}));
		menu.addItem(criarItemMenu(Material.WOOD_AXE, "§bThor", new String[] {"§9§lHABILIDADE : §7Faça uma chuva de", "§7raios e combata seus inimigos!"}));
		menu.addItem(criarItemMenu(Material.SNOW_BALL, "§bSwitcher", new String[] {"§9§lHABILIDADE : §7Troque de lugar com", "§7seu adversário usando suas bolas de neve ( ͡° ͜ʖ ͡°)"}));
		menu.addItem(criarItemMenu(Material.IRON_FENCE, "§bGladiator", new String[] {"§9§lHABILIDADE : §7Puxe seu adversário para um duelo", "§7nas alturas!"}));
		menu.addItem(criarItemMenu(Material.IRON_BOOTS, "§bStomper", new String[] {"§9§lHABILIDADE : §7Pise em seus inimigos e", "§7e esmague-os!"}));
		menu.addItem(criarItemMenu(Material.FIRE, "§bMagma", new String[] {"§9§lHABILIDADE : §7Acerte golpes nos seus inimigos", "§7e receba §2§l30% §7de chance de queima-los!"}));
		menu.addItem(criarItemMenu(Material.STICK, "§bGrandpa", new String[] {"§9§lHABILIDADE : §7Lance os seus inimigos", "§7para longe utilizando seu graveto!"}));
		menu.addItem(criarItemMenu(Material.NETHER_STAR, "§bAjnin", new String[] {"§9§lHABILIDADE : §7Puxe até você o último", "§7jogador hitado!"}));
		menu.addItem(criarItemMenu(Material.FIREBALL, "§bFireLauncher", new String[] {"§9§lHABILIDADE : §7Use o seu kit", "§7para pôr chamas nos adversários!"}));
		menu.addItem(criarItemMenu(Material.getMaterial(120), "§bEndermage", new String[] {"§9§lHABILIDADE §7Puxe os Players até voçê"}));
		menu.addItem(criarItemMenu(Material.WATCH, "§bStrong", new String[] {"§9§lHABILIDADE §7Fique fulliron por 10s"}));
		menu.addItem(criarItemMenu(Material.APPLE, "§bSumo", new String[] {"§9§lHABILIDADE §7Você é tão gordo que joga ", "§7seus inimigos pro alto"}));
		p.openInventory(menu);
	}
}
