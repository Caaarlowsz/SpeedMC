package me.thauandev.menus;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.thauandev.commands.GiveAllCommand;
import me.thauandev.configuração.cfGrupo;
import me.thauandev.configuração.cfPermissão;

public class KitsMenu {
	
	public static ItemStack criarItemMenu(Material material, String nome, String[] habilidade){
		
		ItemStack item = new ItemStack(material);
		ItemMeta kitem = item.getItemMeta();
		kitem.setDisplayName(nome);
		kitem.setLore(Arrays.asList(habilidade));
		item.setItemMeta(kitem);
		
		return item;
	}
	@SuppressWarnings({ "deprecation" })
	public static void inventory(Player p){
		
		Inventory menu = Bukkit.createInventory(p, 54, "§aKits");

		
		ItemStack maiskits = new ItemStack(Material.getMaterial(351), 1, (short)10);
		ItemMeta kmaiskits = maiskits.getItemMeta();
		kmaiskits.setDisplayName("§a§lPROXIMA PAGINA");
		maiskits.setItemMeta(kmaiskits);
		
		ItemStack menoskits = new ItemStack(Material.getMaterial(351), 1, (short)8);
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
		
		ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)14);
		ItemMeta kvidro = vidro.getItemMeta();
		kvidro.setDisplayName("§c§lSPEED§f§lMC");
		vidro.setItemMeta(kvidro);

		ItemStack vidro1 = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)5);
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
		
		
		if((cfGrupo.ChecarGrupo(p, "Membro") || (cfGrupo.ChecarGrupo(p, "Winner") || (cfGrupo.ChecarGrupo(p, "Builder"))) || (cfGrupo.ChecarGrupo(p, "Helper") || (cfGrupo.ChecarGrupo(p, "Light")  || (cfGrupo.ChecarGrupo(p, "S-Pro") || (cfGrupo.ChecarGrupo(p, "Mvp") || (cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Trial") || (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit || GiveAllCommand.light || GiveAllCommand.mvp || GiveAllCommand.pro))))))))))))))){	
		menu.setItem(18 , criarItemMenu(Material.STONE_SWORD, "§bPvP", new String[] {"§9§lHABILIDADE: §7Derrote seus adversários ", "§7utilizando sua espada avançada"}));
		}
	    if((cfGrupo.ChecarGrupo(p, "Membro") || (cfGrupo.ChecarGrupo(p, "Winner") || (cfGrupo.ChecarGrupo(p, "Light")   || (cfGrupo.ChecarGrupo(p, "S-Pro") || (cfGrupo.ChecarGrupo(p, "Mvp") || (cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Trial") || (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit || GiveAllCommand.light || GiveAllCommand.mvp || GiveAllCommand.pro))))))))))))))){
	    menu.setItem(19 ,criarItemMenu(Material.FIREWORK, "§bKangaroo", new String[] {"§9§lHABILIDADE: §7Dê saltos como um", "§7canguru utilizando seu item"}));
	    }
		if((cfGrupo.ChecarGrupo(p, "Membro") || (cfGrupo.ChecarGrupo(p, "Winner") || (cfGrupo.ChecarGrupo(p, "Builder"))) || (cfGrupo.ChecarGrupo(p, "Helper") || (cfGrupo.ChecarGrupo(p, "Light")   || (cfGrupo.ChecarGrupo(p, "S-Pro") || (cfGrupo.ChecarGrupo(p, "Mvp") || (cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Trial") || (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit || GiveAllCommand.light || GiveAllCommand.mvp || GiveAllCommand.pro))))))))))))))){
		menu.setItem(20 ,criarItemMenu(Material.FISHING_ROD, "§bFisherman", new String[] {"§9§lHABILIDADE: §7Pesque o seu adversário e faça estratégias!"}));
		}
		if((cfGrupo.ChecarGrupo(p, "Membro") ||(cfGrupo.ChecarGrupo(p, "Winner") ||  (cfGrupo.ChecarGrupo(p, "Light")   || (cfGrupo.ChecarGrupo(p, "S-Pro") || (cfGrupo.ChecarGrupo(p, "Mvp") || (cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Trial") || (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit || GiveAllCommand.light || GiveAllCommand.mvp || GiveAllCommand.pro))))))))))))))){
	    menu.setItem(21 ,criarItemMenu(Material.ARROW, "§bMiniGun", new String[] {"§9§lHABILIDADE: §7Encha seus inimigos", "§7de flecha com um click!"}));
	    }
		if((cfGrupo.ChecarGrupo(p, "Membro") || (cfGrupo.ChecarGrupo(p, "Winner") || (cfGrupo.ChecarGrupo(p, "Builder"))) || (cfGrupo.ChecarGrupo(p, "Helper") || (cfGrupo.ChecarGrupo(p, "Light")  || (cfGrupo.ChecarGrupo(p, "S-Pro") || (cfGrupo.ChecarGrupo(p, "Mvp") || (cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Trial") || (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit || GiveAllCommand.light || GiveAllCommand.mvp || GiveAllCommand.pro))))))))))))))){
	    menu.setItem(22 ,criarItemMenu(Material.ANVIL, "§bAnchor", new String[] {"§9§lHABILIDADE: §7Não Tome, e não de KnockBack!"}));
		}
		if((cfGrupo.ChecarGrupo(p, "Winner") || (cfGrupo.ChecarGrupo(p, "Builder"))) || (cfGrupo.ChecarGrupo(p, "Helper") || (cfGrupo.ChecarGrupo(p, "Light")   || (cfGrupo.ChecarGrupo(p, "S-Pro") || (cfGrupo.ChecarGrupo(p, "Mvp") || (cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Trial") || (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit || GiveAllCommand.light || GiveAllCommand.mvp || GiveAllCommand.pro)))))))))))))){
		menu.setItem(27 ,criarItemMenu(Material.CACTUS, "§bCactus", new String[] {"§9§lHABILIDADE: §7Vire um cacto e", "§7espete seus inimigos!"}));
		}
		if(cfGrupo.ChecarGrupo(p, "Membro") || (cfGrupo.ChecarGrupo(p, "Winner") || (cfGrupo.ChecarGrupo(p, "Light") || (cfGrupo.ChecarGrupo(p, "S-Pro") || (cfGrupo.ChecarGrupo(p, "Mvp") || (cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Trial") || (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit || GiveAllCommand.light || GiveAllCommand.mvp || GiveAllCommand.pro)))))))))))))){
		menu.setItem(24 ,criarItemMenu(Material.BLAZE_ROD, "§bMonk", new String[] {"§9§lHABILIDADE: §7Faça alterações no inventário", "§7dos seus oponentes!"}));
		}
		if(cfGrupo.ChecarGrupo(p, "Membro") || (cfGrupo.ChecarGrupo(p, "Winner") || (cfGrupo.ChecarGrupo(p, "Light") || (cfGrupo.ChecarGrupo(p, "Builder"))) || (cfGrupo.ChecarGrupo(p, "Helper") || (cfGrupo.ChecarGrupo(p, "Light")  || (cfGrupo.ChecarGrupo(p, "S-Pro") || (cfGrupo.ChecarGrupo(p, "Mvp") || (cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Trial") || (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit || GiveAllCommand.light || GiveAllCommand.mvp || GiveAllCommand.pro))))))))))))))){
		menu.setItem(25 ,criarItemMenu(Material.BOW, "§bArcher", new String[] {"§9§lHABILIDADE: §7Acabe com os oponentes usando", "§7seu arco!"}));
		}
		if(cfGrupo.ChecarGrupo(p, "Membro") || (cfGrupo.ChecarGrupo(p, "Winner") || cfGrupo.ChecarGrupo(p, "Light")   || (cfGrupo.ChecarGrupo(p, "S-Pro") || (cfGrupo.ChecarGrupo(p, "Mvp") || (cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Trial") || (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit || GiveAllCommand.light || GiveAllCommand.mvp || GiveAllCommand.pro))))))))))))){
		menu.setItem(26 ,criarItemMenu(Material.ENCHANTED_BOOK, "§bSpecialist", new String[] {"§9§lHABILIDADE: §7Tenha uma mesa", "§7de encantamento portatil!"}));
		}
		if(cfGrupo.ChecarGrupo(p, "Membro") || (cfGrupo.ChecarGrupo(p, "Winner") || cfGrupo.ChecarGrupo(p, "Light")   || (cfGrupo.ChecarGrupo(p, "S-Pro") || (cfGrupo.ChecarGrupo(p, "Mvp") || (cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Trial") || (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit || GiveAllCommand.light || GiveAllCommand.mvp || GiveAllCommand.pro))))))))))))){
		menu.setItem(23 ,criarItemMenu(Material.DIAMOND_CHESTPLATE, "§bTurtle", new String[] {"§9§lHABILIDADE: §7Aperte shift e", "§7leve menos dano!"}));
		}
		if(((cfPermissão.getPermissao(p, "kit.ninja") || (cfGrupo.ChecarGrupo(p, "Winner") || cfGrupo.ChecarGrupo(p, "Light")   || (cfGrupo.ChecarGrupo(p, "S-Pro") || (cfGrupo.ChecarGrupo(p, "Mvp") || (cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Trial") || (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit || GiveAllCommand.light || GiveAllCommand.mvp || GiveAllCommand.pro))))))))))))))){
		menu.setItem(28 ,criarItemMenu(Material.COMPASS, "§bNinja", new String[] {"§9§lHABILIDADE: §7Teleporte-se até o", "§7último jogador hitado clicando Shift!"}));
		}
	    if(((cfPermissão.getPermissao(p, "kit.antitower") || (cfGrupo.ChecarGrupo(p, "Winner") || cfGrupo.ChecarGrupo(p, "Light")   || (cfGrupo.ChecarGrupo(p, "S-Pro") || (cfGrupo.ChecarGrupo(p, "Mvp") || (cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Trial") || (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit || GiveAllCommand.light || GiveAllCommand.mvp || GiveAllCommand.pro))))))))))))))){
	    menu.setItem(29 ,criarItemMenu(Material.GOLD_HELMET, "§bAntiTower", new String[] {"§9§lHABILIDADE: §7Não leve dano de queda, não tome dano seja morto por stomper, não seja puxado por endermage!"}));
	    }
		if(((cfPermissão.getPermissao(p, "kit.phantom") || (cfGrupo.ChecarGrupo(p, "Winner") || cfGrupo.ChecarGrupo(p, "Light")   || (cfGrupo.ChecarGrupo(p, "S-Pro") || (cfGrupo.ChecarGrupo(p, "Mvp") || (cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Trial") || (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit || GiveAllCommand.light || GiveAllCommand.mvp || GiveAllCommand.pro))))))))))))))){
		menu.setItem(30 ,criarItemMenu(Material.FEATHER, "§bPhantom", new String[] {"§9§lHABILIDADE: §7Utilize sua pena para", "§7voar como um pássaro!"}));
		}
		if(((cfPermissão.getPermissao(p, "kit.grappler") || cfGrupo.ChecarGrupo(p, "Light")   || (cfGrupo.ChecarGrupo(p, "S-Pro") || (cfGrupo.ChecarGrupo(p, "Mvp") || (cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Trial") || (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit || GiveAllCommand.light || GiveAllCommand.mvp || GiveAllCommand.pro)))))))))))))){
		menu.setItem(31 ,criarItemMenu(Material.LEASH, "§bGrappler", new String[] {"§9§lHABILIDADE: §7Escale paredes utilizando", "§7sua corda mágica!"}));
		}
		if(((cfPermissão.getPermissao(p, "kit.viper") || cfGrupo.ChecarGrupo(p, "Light")   || (cfGrupo.ChecarGrupo(p, "S-Pro") || (cfGrupo.ChecarGrupo(p, "Mvp") || (cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Trial") || (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit || GiveAllCommand.light || GiveAllCommand.mvp || GiveAllCommand.pro)))))))))))))){
		menu.setItem(32 ,criarItemMenu(Material.SPIDER_EYE, "§bViper", new String[] {"§9§lHABILIDADE: §7Aplique veneno em seus", "§7adversários ao entra em combate!"}));
		}
		if(((cfPermissão.getPermissao(p, "kit.snail") || cfGrupo.ChecarGrupo(p, "Light")   || (cfGrupo.ChecarGrupo(p, "S-Pro") || (cfGrupo.ChecarGrupo(p, "Mvp") || (cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Trial") || (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit || GiveAllCommand.light || GiveAllCommand.mvp || GiveAllCommand.pro)))))))))))))){
		menu.setItem(33 ,criarItemMenu(Material.STRING, "§bSnail", new String[] {"§9§lHABILIDADE: §7Aplique lentidão profunda", "§7e ganhe vantagem!"}));
		}
		if((cfPermissão.getPermissao(p, "kit.hulk") || cfGrupo.ChecarGrupo(p, "Mvp")   || (cfGrupo.ChecarGrupo(p, "S-Pro") || (cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit || GiveAllCommand.mvp || GiveAllCommand.pro))))))))))){
		menu.setItem(34 ,criarItemMenu(Material.SADDLE, "§bHulk", new String[] {"§9§lHABILIDADE: §7Puxe seus inimigos para cima", "§7e os detenha!"}));
		}
		if((cfPermissão.getPermissao(p, "kit.timelord") || cfGrupo.ChecarGrupo(p, "Mvp")   || (cfGrupo.ChecarGrupo(p, "S-Pro") || (cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit || GiveAllCommand.mvp || GiveAllCommand.pro))))))))))){
		menu.setItem(35 ,criarItemMenu(Material.WATCH, "§bTimelord", new String[] {"§9§lHABILIDADE: §7Congele os players de", "§7sua volta"}));
		}
		if((cfPermissão.getPermissao(p, "kit.thor") || cfGrupo.ChecarGrupo(p, "Mvp")  || (cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit || GiveAllCommand.mvp || GiveAllCommand.pro)))))))))){
		menu.setItem(36 ,criarItemMenu(Material.WOOD_AXE, "§bThor", new String[] {"§9§lHABILIDADE: §7Vire o thor e lançe raios", "§7em seus inimigos"}));
		}
		if((cfPermissão.getPermissao(p, "kit.switcher") || cfGrupo.ChecarGrupo(p, "Mvp")  || (cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit || GiveAllCommand.mvp || GiveAllCommand.pro)))))))))){
		menu.setItem(37 ,criarItemMenu(Material.SNOW_BALL, "§bSwitcher", new String[] {"§9§lHABILIDADE: §7Troque de lugar com seus inimigos ao", "§7acertar uma bola de neve nele"}));
		}
		if((cfPermissão.getPermissao(p, "kit.gladiator") || cfGrupo.ChecarGrupo(p, "Mvp")  || (cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit || GiveAllCommand.mvp || GiveAllCommand.pro)))))))))){
		menu.setItem(38 ,criarItemMenu(Material.IRON_FENCE, "§bGladiator", new String[] {"§9§lHABILIDADE: §7Puxe seus inimigos para um", "§7duelo nas alturas!"}));
		}
		if(((cfPermissão.getPermissao(p, "kit.stomper") || cfGrupo.ChecarGrupo(p, "Pro")  || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono")  || GiveAllCommand.fullkit || GiveAllCommand.pro)))))))))){
		menu.setItem(39 ,criarItemMenu(Material.DIAMOND_BOOTS, "§bStomper", new String[] {"§9§lHABILIDADE: §7Transfira seu dano de", "§7queda para seus inimigos ao pular neles."}));
		}
		if(((cfPermissão.getPermissao(p, "kit.magma") || cfGrupo.ChecarGrupo(p, "Pro")  || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono")  || GiveAllCommand.fullkit || GiveAllCommand.pro)))))))))){
		menu.setItem(40 ,criarItemMenu(Material.FIRE, "§bMagma", new String[] {"§9§lHABILIDADE: §7Receba 30% de chance de queimar", "§7seus inimigos!"}));
		}
		if(((cfPermissão.getPermissao(p, "kit.grandpa") || cfGrupo.ChecarGrupo(p, "Pro")  || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono")  || GiveAllCommand.fullkit || GiveAllCommand.pro)))))))))){
		menu.setItem(41 ,criarItemMenu(Material.STICK, "§bGrandpa", new String[] {"§9§lHABILIDADE: §7Jogue seus inimigos para longe", "§7utilizando seu graveto!"}));
		}
		if(((cfPermissão.getPermissao(p, "kit.ajnin") || cfGrupo.ChecarGrupo(p, "Pro")  || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono")  || GiveAllCommand.fullkit || GiveAllCommand.pro)))))))))){
		menu.setItem(42 ,criarItemMenu(Material.NETHER_STAR, "§bAjnin", new String[] {"§9§lHABILIDADE: §7Puxe o último jogador hitado", "§7até você clicando shift!"}));
		}
		if(((cfPermissão.getPermissao(p, "kit.firelauncher") || cfGrupo.ChecarGrupo(p, "Pro")  || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono")  || GiveAllCommand.fullkit || GiveAllCommand.pro)))))))))){
		menu.setItem(43 ,criarItemMenu(Material.FIREBALL, "§bFirelauncher", new String[] {"§9§lHABILIDADE: §7Utilize a sua habilidade para", "§7queimar seus inimigos"}));
		}
		if(((cfPermissão.getPermissao(p, "kit.endermage") || cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Helper") || cfGrupo.ChecarGrupo(p, "Builder") || cfGrupo.ChecarGrupo(p, "Youtuber+") || cfGrupo.ChecarGrupo(p, "Mod+") || cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Dono")  || GiveAllCommand.fullkit || GiveAllCommand.pro))))))){
		menu.setItem(44 ,criarItemMenu(Material.getMaterial(120), "§bEndermage", new String[] {"§9§lHABILIDADE: §7Puxe Quem estiver embaixo ou acima de voçê!"}));
		}
		if(((cfPermissão.getPermissao(p, "kit.strong") || cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Helper") || cfGrupo.ChecarGrupo(p, "Builder") || cfGrupo.ChecarGrupo(p, "Youtuber+") || cfGrupo.ChecarGrupo(p, "Mod+") || cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Dono")  || GiveAllCommand.fullkit || GiveAllCommand.pro))))))){
		menu.setItem(45 ,criarItemMenu(Material.WATCH, "§bStrong", new String[] {"§9§lHABILIDADE: §7Fi	que Full Iron por alguns instantes!"}));
		}
		if(((cfPermissão.getPermissao(p, "kit.sumo") || cfGrupo.ChecarGrupo(p, "Helper") || cfGrupo.ChecarGrupo(p, "Builder") || cfGrupo.ChecarGrupo(p, "Youtuber+") || cfGrupo.ChecarGrupo(p, "Mod+") || cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono")  || GiveAllCommand.fullkit || GiveAllCommand.pro))))))){
		menu.setItem(46 ,criarItemMenu(Material.APPLE, "§bSumo", new String[] {"§9§lHABILIDADE: §7Jogue seus inimigos", "§7para o alto utilizando seu peso"}));
		}
		p.openInventory(menu);
	}
}
