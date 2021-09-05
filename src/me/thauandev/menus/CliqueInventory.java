
package me.thauandev.menus;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import me.thauandev.API.PadraoAPI;
import me.thauandev.account.CheckUtils;
import me.thauandev.configuração.cfConfig;
import me.thauandev.configuração.cfPermissão;
import me.thauandev.configuração.cfStatus;


public class CliqueInventory implements Listener{
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void clickartodoskits(InventoryClickEvent e){
		
		Player p = (Player) e.getWhoClicked();
		
		if((e.getInventory().getTitle().equals("§9§lTODOS OS KITS") && (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))){
			e.setCancelled(true);
			
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lSEUS KITS")){
			e.setCancelled(true);
			KitsMenu.inventory(p);
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§2§lLOJA DE KITS")){
			e.setCancelled(true);
			LojaMenu.inventory(p);
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§5§lRANKS")){
			e.setCancelled(true);
			p.chat("/rank");
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lWARPS")){
			e.setCancelled(true);
			WarpsMenu.inventory(p);
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§9§lTODOS OS KITS")){
			e.setCancelled(true);
			TodosKitsMenu.inventory(p);
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lPAGINA ANTERIOR")){
			e.setCancelled(true);
			p.closeInventory();
			return;
	    	} 
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lPROXIMA PAGINA")){
			e.setCancelled(true);
			p.closeInventory();
			return;
    	} 
	  }
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void clickarchatmenu(InventoryClickEvent e){
		
		Player p = (Player) e.getWhoClicked();
		
		if((e.getInventory().getTitle().equals("§8§lCHAT") && (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))){
			e.setCancelled(true);
			
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§f§lCLEAR")){
			e.setCancelled(true);
			p.closeInventory();
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 20L, 20L);
			p.chat("/chat clear");
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lON")){
			e.setCancelled(true);
			p.closeInventory();
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 20L, 20L);
			p.chat("/chat on");
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lOFF")){
			e.setCancelled(true);
			p.closeInventory();
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 20L, 20L);
			p.chat("/chat off");
			return;
	    	}
		}
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void clickarperfilmenu(InventoryClickEvent e){
		
		Player p = (Player) e.getWhoClicked();
		
		if((e.getInventory().getTitle().equals("§5§lPERFIL") && (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))){
			e.setCancelled(true);
			
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lKILLS")){
			e.setCancelled(true);
			p.closeInventory();
			p.sendMessage("§e§lKILLS§7: " + cfStatus.getKills(p));
			return;
		}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lPLAYER")){
			e.setCancelled(true);
			p.closeInventory();
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lDEATHS")){
			e.setCancelled(true);
			p.closeInventory();
			p.sendMessage("§c§lDEATHS§7: " + cfStatus.getDeaths(p));
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lMOEDAS")){
			e.setCancelled(true);
			p.closeInventory();
			p.sendMessage("§6§lMONEY§7: " + cfStatus.getMoney(p));
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3§lGRUPO")){
			e.setCancelled(true);
			p.closeInventory();
			p.sendMessage("§d§lSEU GRUPO§7: " + CheckUtils.Grupo(p));
			return;
		}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lSPEED§f§lMC")){
				e.setCancelled(true);
				PerfilMenu.inventory(p);
				return;
	    	}
		}
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void clickarlojapermsmenu(InventoryClickEvent e){
		
		Player p = (Player) e.getWhoClicked();
		
		if((e.getInventory().getTitle().equals("§5§lPERMS") && (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))){
			e.setCancelled(true);
			
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Tag §2§lWINNER §7- §8§l50.000")){
			e.setCancelled(true);
			p.closeInventory();
			if(cfStatus.getMoney(p) < 30000){
				p.sendMessage("§c§lSPEED§f§lMC §fVocê não possui Coins o suficiente para finalizar a compra.");
			}else{
				cfPermissão.setarPermissao(p, "tag.winner", "true");
				p.sendMessage("§c§lSPEED§f§lMC §fVocê comprou a tag §2§lWINNER§f!");
				p.chat("/tag winner");
				cfStatus.RemoveMoney(p, 30000);
			}
			p.closeInventory();
			return;
    	}
	}
}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void clickarconfigmenu(InventoryClickEvent e){
		
		Player p = (Player) e.getWhoClicked();
		
		if((e.getInventory().getTitle().equals("§8§lMenu") && (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))){
			e.setCancelled(true);
			
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§f§lSite Principal")){
			e.setCancelled(true);
			p.closeInventory();
			p.sendMessage("§c§lSPEED§f§lMC §7Nosso site (§cspeedmc.com.br§7)");
			return;
		}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§f§lYou§c§lTube")){
			e.setCancelled(true);
			p.closeInventory();
			p.sendMessage("§c§lSPEED§f§lMC §7Nosso Canal no YouTube (§cwww.youtube.com.br/thauanpvp§7)");
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7§lTeamSpeak")){
			e.setCancelled(true);
			p.closeInventory();
			p.sendMessage("§c§lSPEED§f§lMC §7Nosso TeamSpeak (§cts.speedmc.com.br§7)");
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3§lDiscord")){
			e.setCancelled(true);
			p.closeInventory();
			p.sendMessage("§c§lSPEED§f§lMC §7Nosso Discord (§chttps://discord.gg/gZ2Fe86§7)");
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lTwitter")){
			e.setCancelled(true);
			p.closeInventory();
			p.sendMessage("§c§lSPEED§f§lMC §7Nosso Discord (§ctwitter.com/speedmc_§7) §7Ou §7(§ctwitter.com/thauanpvp");
			return;
		}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lSPEED§f§lMC")){
				e.setCancelled(true);
				PerfilMenu.inventory(p);
				return;
	    	}
		}
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void clickarlojavips(InventoryClickEvent e){
		
		Player p = (Player) e.getWhoClicked();
		
		if((e.getInventory().getTitle().equals("§7Qual §b§lVIP §7deseja?") && (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))){
			e.setCancelled(true);
			
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7§l[VIP] §a§lLIGHT")){
			e.setCancelled(true);
			p.closeInventory();
			p.sendMessage("§c§lSPEED§f§lMC §fAcesse nossa §a§lLOJA§f: §3speedmc.com.br");
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7§l[VIP] §6§lPREMIUM")){
			e.setCancelled(true);
			p.closeInventory();
			p.sendMessage("§c§lSPEED§f§lMC §fAcesse nossa §a§lLOJA§f: §3speedmc.com.br");
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7§l[VIP] §d§lULTIMATE")){
			e.setCancelled(true);
			p.closeInventory();
			p.sendMessage("§c§lSPEED§f§lMC §fAcesse nossa §a§lLOJA§f: §3speedmc.com.br");
			return;
			}
		}
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void clickaryoutubermenu(InventoryClickEvent e){
		
		Player p = (Player) e.getWhoClicked();
		
		if((e.getInventory().getTitle().equals("§b§lYOUTUBER") && (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))){
			e.setCancelled(true);
			
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lPLATINUM")){
			e.setCancelled(true);
			p.closeInventory();
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 20L, 20L);
			 p.sendMessage("§c§m>-------------------------<");
			    p.sendMessage("      §7● §e§lPLATINUM §7●        ");
			    p.sendMessage(" ");
			    p.sendMessage("§7● Para Obter a Tag §e[PLATINUM]§7, Você Precisa de:");
			    p.sendMessage("§7");
			    p.sendMessage("§7● 250 Inscritos");
			    p.sendMessage("§7● FeedBack Razoável");
			    p.sendMessage("§7● Frequência de Vídeos Boa");
			    p.sendMessage("§7● 1 Vídeo no servidor");
			    p.sendMessage("§7● 20 Likes No Vídeo do Servidor.");
			    p.sendMessage(" ");
			    p.sendMessage("§c[OBSERVAÇÃO] Se Não tiver os Requisitos, Por favor Não insista na Tag!");
			    p.sendMessage("§c[OBSERVAÇÃO] Se tiver Todos os Requisitos, entre em contato!");
			    p.sendMessage(" ");
			    p.sendMessage("§c§m>-------------------------<");
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lYOUTUBER")){
			e.setCancelled(true);
			p.closeInventory();
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 20L, 20L);
			 p.sendMessage("§c§m>-------------------------<");
			    p.sendMessage("      §7● §b§lYOUTUBER §7●        ");
			    p.sendMessage(" ");
			    p.sendMessage("§7● Para Obter a Tag §b[YOUTUBER]§7, Você Precisa de:");
			    p.sendMessage("§7");
			    p.sendMessage("§7● 500 Inscritos");
			    p.sendMessage("§7● FeedBack Razoável");
			    p.sendMessage("§7● Frequência de Vídeos Boa");
			    p.sendMessage("§7● 1 Vídeo no servidor");
			    p.sendMessage("§7● 30 Likes No Vídeo do Servidor.");
			    p.sendMessage(" ");
			    p.sendMessage("§c[OBSERVAÇÃO] Se Não tiver os Requisitos, Por favor Não insista na Tag!");
			    p.sendMessage("§c[OBSERVAÇÃO] Se tiver Todos os Requisitos, entre em contato!");
			    p.sendMessage(" ");
			    p.sendMessage("§c§m>-------------------------<");
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3§lYOUTUBER+")){
			e.setCancelled(true);
			p.closeInventory();
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 20L, 20L);
			 p.sendMessage("§c§m>-------------------------<");
			    p.sendMessage("      §7● §3§lYOUTUBER+ §7●        ");
			    p.sendMessage(" ");
			    p.sendMessage("§7● Para Obter a Tag §3[YOUTUBER+]§7, Você Precisa de:");
			    p.sendMessage("§7");
			    p.sendMessage("§7● 2,5k(mil) de Inscritos");
			    p.sendMessage("§7● FeedBack Razoável");
			    p.sendMessage("§7● Frequência de Vídeos Boa");
			    p.sendMessage("§7● 1 Vídeo no servidor");
			    p.sendMessage("§7● 60 Likes em todo Vídeo no Servidor.");
			    p.sendMessage(" ");
			    p.sendMessage("§c[OBSERVAÇÃO] Se Não tiver os Requisitos, Por favor Não insista na Tag!");
			    p.sendMessage("§c[OBSERVAÇÃO] Se tiver Todos os Requisitos, entre em contato!");
			    p.sendMessage(" ");
			    p.sendMessage("§c§m>-------------------------<");
			return;
			}
		}
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void clickarwarps(InventoryClickEvent e){
		
		Player p = (Player) e.getWhoClicked();
		
		if((e.getInventory().getTitle().equals("§bWarps") && (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))){
			e.setCancelled(true);
			
			
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bFps")){
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/warp fps");
				return;
		    	}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bEvento")){
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/warp evento");
				return;
		    	}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b1v1")){
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/warp 1v1");
				return;
	    	}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bKnockback")){
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/warp knockback");
				return;
	    	}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bMain")){
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/warp main");
				return;
	    	}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bFisherman")){
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/warp fisherman");
				return;
	    	}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bKits")){
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kits");
				return;
	    	}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bKnockBack")){
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/warp KnockBack");
				return;
	    	}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bWarps")){
				e.setCancelled(true);
				p.closeInventory();
				return;
	    	}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bLavaChallenge")){
			e.setCancelled(true);
			p.closeInventory();
			p.chat("/warp challenge");
			return;
			}
		  }
		}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void clickarloja2(InventoryClickEvent e){
		
		Player p = (Player) e.getWhoClicked();
		
		if((e.getInventory().getTitle().equals("§2§lLOJA DE KITS") && (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))){
			e.setCancelled(true);
			
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bSeus Kits")){
				e.setCancelled(true);
				KitsMenu.inventory(p);
				return;
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bLoja de Kits")){
				e.setCancelled(true);
				LojaMenu.inventory(p);
				return;
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§5§lRANKS")){
				e.setCancelled(true);
				p.chat("/rank");
				return;
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bWarps")){
				e.setCancelled(true);
				WarpsMenu.inventory(p);
				return;
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§9§lTODOS OS KITS")){
				e.setCancelled(true);
				TodosKitsMenu.inventory(p);
				return;
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lPAGINA ANTERIOR")){
				e.setCancelled(true);
				p.closeInventory();
				return;
		    	} 
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lPROXIMA PAGINA")){
				e.setCancelled(true);
				p.closeInventory();
				return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7[§6§lStrong§7] §f- §7Valor: §9§l30.000XP")){
			e.setCancelled(true);
			p.closeInventory();
			if(cfStatus.getMoney(p) < 30000){
				p.sendMessage("§c§lSPEED§f§lMC §cVocê não possui XP o suficiente para finalizar a compra.");
			}else{
				cfPermissão.setarPermissao(p, "kit.strong", "true");
				p.sendMessage("§c§lSPEED§f§lMC §aVocê comprou o kit Strong!");
				cfStatus.RemoveMoney(p, 30000);
			}
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7[§6§Forcefield§7] §f- §7Valor: §9§l20.000XP")){
			e.setCancelled(true);
			p.closeInventory();
			if(cfStatus.getMoney(p) < 20000){
				p.sendMessage("§c§lSPEED§f§lMC §6» §7Você não possui coins suficientes para comprar esse kit.");
			}else{
				cfPermissão.setarPermissao(p, "kit.forcefield", "true");
				p.sendMessage("§c§lSPEED§f§lMC §aVocê comprou o kit Forcefield");
				cfStatus.RemoveMoney(p, 20000);
			}
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7[§6§Sumo§7] §f- §7Valor: §9§l15.000XP")){
			e.setCancelled(true);
			p.closeInventory();
			if(cfStatus.getMoney(p) < 15000){
				p.sendMessage("§c§lSPEED§f§lMC §7» §7Você não possui coins suficientes para comprar esse kit.");
			}else{
				cfPermissão.setarPermissao(p, "kit.sumo", "true");
				p.sendMessage("§c§lSPEED§f§lMC §aVocê comprou o kit Sumo");
				cfStatus.RemoveMoney(p, 15000);
			}
			p.closeInventory();
		    }
		  }
		}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void clickarloja(InventoryClickEvent e){
		
		Player p = (Player) e.getWhoClicked();
		
		if((e.getInventory().getTitle().equals("§7➳ §9§lTODOS OS KITS §8(pág. 1)") && (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))){
			e.setCancelled(true);
			p.closeInventory();
			
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7➳ §a§lSEUS KITS")){
			e.setCancelled(true);
			p.closeInventory();
			KitsMenu.inventory(p);
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7➳ §9§lTODOS OS KITS")){
			e.setCancelled(true);
			p.closeInventory();
			TodosKitsMenu.inventory(p);
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7[§6§Monk§7] §f- §7Valor: §9§l15.000XP")){
			e.setCancelled(true);
			p.closeInventory();
			if(cfStatus.getMoney(p) < 15000){
				p.sendMessage("§c§lSPEED§f§lMC §7» §7Você não possui coins suficientes para comprar esse kit.");
			}else{
				cfPermissão.setarPermissao(p, "kit.monk", "true");
				p.sendMessage("§c§lSPEED§f§lMC §aVocê comprou o kit Monk");
				cfStatus.RemoveMoney(p, 15000);
			}
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7[§6§Ninja§7] §f- §7Valor: §9§l17.000XP")){
			e.setCancelled(true);
			p.closeInventory();
			if(cfStatus.getMoney(p) < 17000){
				p.sendMessage("§c§lSPEED§f§lMC §7» §7Você não possui coins suficientes para comprar esse kit.");
			}else{
				cfPermissão.setarPermissao(p, "kit.ninja", "true");
				p.sendMessage("§c§lSPEED§f§lMC §aVocê comprou o kit Ninja");
				cfStatus.RemoveMoney(p, 17000);
			}
			p.closeInventory();
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7[§6&lAntiTower§7] §f- §7Valor: §9§l20.000XP")){
			e.setCancelled(true);
			p.closeInventory();
			if(cfStatus.getMoney(p) < 20000){
				p.sendMessage("§c§lSPEED§f§lMC §7» §7Você não possui coins suficientes para comprar esse kit.");
			}else{
				cfPermissão.setarPermissao(p, "kit.antitower", "true");
				p.sendMessage("§c§lSPEED§f§lMC §aVocê comprou o kit AntiTower");
				cfStatus.RemoveMoney(p, 20000);
			}
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7[§6§Phantom§7] §f- §7Valor: §9§l15.000XP")){
			e.setCancelled(true);
			p.closeInventory();
			if(cfStatus.getMoney(p) < 15000){
				p.sendMessage("§c§lSPEED§f§lMC §7» §7Você não possui coins suficientes para comprar esse kit.");
			}else{
				cfPermissão.setarPermissao(p, "kit.phantom", "true");
				p.sendMessage("§c§lSPEED§f§lMC §aVocê comprou o kit Phantom");
				cfStatus.RemoveMoney(p, 15000);
			}
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7[§6§Grappler§7] §f- §7Valor: §9§l17.000XP")){
			e.setCancelled(true);
			p.closeInventory();
			if(cfStatus.getMoney(p) < 17000){
				p.sendMessage("§c§lSPEED§f§lMC §7» §7Você não possui coins suficientes para comprar esse kit.");
			}else{
				cfPermissão.setarPermissao(p, "kit.grappler", "true");
				p.sendMessage("§c§lSPEED§f§lMC §aVocê comprou o kit Grappler");
				cfStatus.RemoveMoney(p, 17000);
			}
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7[§6§Viper§7] §f- §7Valor: §9§l10.000XP")){
			e.setCancelled(true);
			p.closeInventory();
			if(cfStatus.getMoney(p) < 10000){
				p.sendMessage("§c§lSPEED§f§lMC §7» §7Você não possui coins suficientes para comprar esse kit.");
			}else{
				cfPermissão.setarPermissao(p, "kit.viper", "true");
				p.sendMessage("§c§lSPEED§f§lMC §aVocê comprou o kit Viper");
				cfStatus.RemoveMoney(p, 10000);
			}
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7[§6§Snail§7] §f- §7Valor: §9§l10.000XP")){
			e.setCancelled(true);
			p.closeInventory();
			if(cfStatus.getMoney(p) < 10000){
				p.sendMessage("§c§lSPEED§f§lMC §7» §7Você não possui coins suficientes para comprar esse kit.");
			}else{
				cfPermissão.setarPermissao(p, "kit.snail", "true");
				p.sendMessage("§c§lSPEED§f§lMC §aVocê comprou o kit Snail");
				cfStatus.RemoveMoney(p, 10000);
			}
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7[§6§Hulk§7] §f- §7Valor: §9§l15.000XP")){
			e.setCancelled(true);
			p.closeInventory();
			if(cfStatus.getMoney(p) < 15000){
				p.sendMessage("§c§lSPEED§f§lMC §7» §7Você não possui coins suficientes para comprar esse kit.");
			}else{
				cfPermissão.setarPermissao(p, "kit.hulk", "true");
				p.sendMessage("§c§lSPEED§f§lMC §aVocê comprou o kit Hulk");
				cfStatus.RemoveMoney(p, 15000);
			}
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7[§6§§7] §f- §7Valor: §9§l15.000XP")){
			e.setCancelled(true);
			p.closeInventory();
			if(cfStatus.getMoney(p) < 15000){
				p.sendMessage("§c§lSPEED§f§lMC §6» §7Você não possui coins suficientes para comprar esse kit.");
			}else{
				cfPermissão.setarPermissao(p, "kit.timelord", "true");
				p.sendMessage("§c§lSPEED§f§lMC §aVocê comprou o kit Timelord");
				cfStatus.RemoveMoney(p, 15000);
			}
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cThor §c§l15.000")){
			e.setCancelled(true);
			p.closeInventory();
			if(cfStatus.getMoney(p) < 15000){
				p.sendMessage("§c§lSPEED§f§lMC §7» §7Você não possui coins suficientes para comprar esse kit.");
			}else{
				cfPermissão.setarPermissao(p, "kit.thor", "true");
				p.sendMessage("§c§lSPEED§f§lMC §aVocê comprou o kit Thor");
				cfStatus.RemoveMoney(p, 15000);
			}
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7[§6§l§7] §f- §7Valor: §9§l10.000XP")){
			e.setCancelled(true);
			p.closeInventory();
			if(cfStatus.getMoney(p) < 10000){
				p.sendMessage("§c§lSPEED§f§lMC §7» §7Você não possui coins suficientes para comprar esse kit.");
			}else{
				cfPermissão.setarPermissao(p, "kit.switcher", "true");
				p.sendMessage("§c§lSPEED§f§lMC §aVocê comprou o kit Switcher");
				cfStatus.RemoveMoney(p, 10000);
			}
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7[§6§lGladiator§7] §f- §7Valor: §9§l30.000XP")){
			e.setCancelled(true);
			p.closeInventory();
			if(cfStatus.getMoney(p) < 30000){
				p.sendMessage("§c§lSPEED§f§lMC §7Você não possui coins suficientes para comprar esse kit.");
			}else{
				cfPermissão.setarPermissao(p, "kit.gladiator", "true");
				p.sendMessage("§c§lSPEED§f§lMC §aVocê comprou o kit Gladiator");
				cfStatus.RemoveMoney(p, 30000);
			}
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7[§6§lEndermage§7] §f- §7Valor: §9§l17.000XP")){
			e.setCancelled(true);
			p.closeInventory();
			if(cfStatus.getMoney(p) < 17000){
				p.sendMessage("§c§lSPEED§f§lMC §7» §7Você não possui coins suficientes para comprar esse kit.");
			}else{
				cfPermissão.setarPermissao(p, "kit.endermage", "true");
				p.sendMessage("§c§lSPEED§f§lMC §aVocê comprou o kit Endermage");
				cfStatus.RemoveMoney(p, 17000);
			}
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cStomper §c§l35.000")){
			e.setCancelled(true);
			p.closeInventory();
			if(cfStatus.getMoney(p) < 35000){
				p.sendMessage("§c§lSPEED§f§lMC §7» §7Você não possui coins suficientes para comprar esse kit.");
			}else{
				cfPermissão.setarPermissao(p, "kit.stomper", "true");
				p.sendMessage("§c§lSPEED§f§lMC §aVocê comprou o kit Stomper");
				cfStatus.RemoveMoney(p, 35000);
			}
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7[§6§§7] §f- §7Valor: §9§l17.000XP")){
			e.setCancelled(true);
			p.closeInventory();
			if(cfStatus.getMoney(p) < 17000){
				p.sendMessage("§c§lSPEED§f§lMC §7» §7Você não possui coins suficientes para comprar esse kit.");
			}else{
				cfPermissão.setarPermissao(p, "kit.magma", "true");
				p.sendMessage("§c§lSPEED§f§lMC §aVocê comprou o kit Magma");
				cfStatus.RemoveMoney(p, 17000);
			}
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cGrandpa §c§l10.000")){
			e.setCancelled(true);
			p.closeInventory();
			if(cfStatus.getMoney(p) < 10000){
				p.sendMessage("§c§lSPEED§f§lMC §7» §7Você não possui coins suficientes para comprar esse kit.");
			}else{
				cfPermissão.setarPermissao(p, "kit.grandpa", "true");
				p.sendMessage("§c§lSPEED§f§lMC §aVocê comprou o kit Grandpa");
				cfStatus.RemoveMoney(p, 10000);
			}
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cAjnin §c§l20.000")){
			e.setCancelled(true);
			p.closeInventory();
			if(cfStatus.getMoney(p) < 20000){
				p.sendMessage("§c§lSPEED§f§lMC §7» §7Você não possui coins suficientes para comprar esse kit.");
			}else{
				cfPermissão.setarPermissao(p, "kit.ajnin", "true");
				p.sendMessage("§c§lSPEED§f§lMC §aVocê comprou o kit Ajnin");
				cfStatus.RemoveMoney(p, 20000);
			}
			p.closeInventory();
			return;
		  }
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cNinja §c§l17.000")){
					e.setCancelled(true);
					p.closeInventory();
					if(cfStatus.getMoney(p) < 17000){
						p.sendMessage("§c§lSPEED§f§lMC §7» §7Você não possui coins suficientes para comprar esse kit.");
					}else{
						cfPermissão.setarPermissao(p, "kit.ninja", "true");
						p.sendMessage("§c§lSPEED§f§lMC §aVocê comprou o kit Ninja");
						cfStatus.RemoveMoney(p, 17000);
					}
					p.closeInventory();
					return;
		  }
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cStomper §c§l35.000")){
					e.setCancelled(true);
					p.closeInventory();
					if(cfStatus.getMoney(p) < 35000){
						p.sendMessage("§c§lSPEED§f§lMC §7» §7Você não possui coins suficientes para comprar esse kit.");
					}else{
						cfPermissão.setarPermissao(p, "kit.stomper", "true");
						p.sendMessage("§c§lSPEED§f§lMC §aVocê comprou o kit Stomper");
						cfStatus.RemoveMoney(p, 35000);
					}
					p.closeInventory();
					return;
		  }
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cGladiator §c§l25.000")){
					e.setCancelled(true);
					p.closeInventory();
					if(cfStatus.getMoney(p) < 25000){
						p.sendMessage("§c§lSPEED§f§lMC §7» §7Você não possui coins suficientes para comprar esse kit.");
					}else{
						cfPermissão.setarPermissao(p, "kit.gladiator", "true");
						p.sendMessage("§c§lSPEED§f§lMC §aVocê comprou o kit Gladiator");
						cfStatus.RemoveMoney(p, 25000);
					}
					p.closeInventory();
					return;
		  }
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cAntiTower §c§l20.000")){
					e.setCancelled(true);
					p.closeInventory();
					if(cfStatus.getMoney(p) < 20000){
						p.sendMessage("§c§lSPEED§f§lMC §7» §7Você não possui coins suficientes para comprar esse kit.");
					}else{
						cfPermissão.setarPermissao(p, "kit.antitower", "true");
						p.sendMessage("§c§lSPEED§f§lMC §aVocê comprou o kit AntiTower");
						cfStatus.RemoveMoney(p, 20000);
					}
					p.closeInventory();
					return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cFireLauncher §c§l15.000")){
			e.setCancelled(true);
			p.closeInventory();
			if(cfStatus.getMoney(p) < 15000){
				p.sendMessage("§c§lSPEED§f§lMC §7» §7Você não possui coins suficientes para comprar esse kit.");
			}else{
				cfPermissão.setarPermissao(p, "kit.firelauncher", "true");
				p.sendMessage("§c§lSPEED§f§lMC §aVocê comprou o kit Firelauncher");
				cfStatus.RemoveMoney(p, 15000);
			}
			p.closeInventory();
		  }
		 }
		}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void clickarkits(InventoryClickEvent e){
		
		Player p = (Player) e.getWhoClicked();
		
		if((e.getInventory().getTitle().equals("§aKits") && (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))){
			e.setCancelled(true);
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§9§lTODOS OS KITS")){
			e.setCancelled(true);
			TodosKitsMenu.inventory(p);
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bWarps")){
			e.setCancelled(true);
			WarpsMenu.inventory(p);
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bSeus Kits")){
			e.setCancelled(true);
			KitsMenu.inventory(p);
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§5§lRANKS")){
			e.setCancelled(true);
			p.chat("/rank");
			p.closeInventory();
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lPAGINA ANTERIOR")){
			e.setCancelled(true);
			KitsMenu.inventory(p);
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bLoja de Kits")){
			e.setCancelled(true);
			LojaMenu.inventory(p);
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lPROXIMA PAGINA")){
			e.setCancelled(true);
			KitsMenu.inventory(p);
			return;
		}
		if(e.getCurrentItem().getType() == Material.STONE_SWORD){
			e.setCancelled(true);
			p.chat("/kit pvp");
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getType() == Material.BOW){
			e.setCancelled(true);
			p.chat("/kit archer");
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getType() == Material.FIREWORK){
			e.setCancelled(true);
			p.chat("/kit kangaroo");
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getType() == Material.FISHING_ROD){
			e.setCancelled(true);
			p.chat("/kit fisherman");
			p.closeInventory();
			return;
		}
		if(e.getCurrentItem().getType() == Material.ARROW){
			e.setCancelled(true);
			p.chat("/kit MiniGun");
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getType() == Material.ANVIL){
			e.setCancelled(true);
			p.chat("/kit anchor");
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getType() == Material.DIAMOND_CHESTPLATE){
			e.setCancelled(true);
			p.chat("/kit turtle");
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getType() == Material.CACTUS){
			e.setCancelled(true);
			p.chat("/kit cactus");
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getType() == Material.BLAZE_ROD){
			e.setCancelled(true);
			p.chat("/kit monk");
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getType() == Material.COMPASS){
			e.setCancelled(true);
			p.chat("/kit ninja");
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getType() == Material.GOLD_HELMET){
			e.setCancelled(true);
			p.chat("/kit antitower");
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getType() == Material.FEATHER){
			e.setCancelled(true);
			p.chat("/kit phantom");
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getType() == Material.ENCHANTED_BOOK){
			e.setCancelled(true);
			p.chat("/kit specialist");
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getType() == Material.LEASH){
			e.setCancelled(true);
			p.chat("/kit grappler");
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getType() == Material.SPIDER_EYE){
			e.setCancelled(true);
			p.chat("/kit viper");
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getType() == Material.STRING){
			e.setCancelled(true);
			p.chat("/kit snail");
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getType() == Material.SADDLE){
			e.setCancelled(true);
			p.chat("/kit hulk");
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getType() == Material.WATCH){
			e.setCancelled(true);
			p.chat("/kit timelord");
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getType() == Material.WOOD_AXE){
			e.setCancelled(true);
			p.chat("/kit thor");
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getType() == Material.SNOW_BALL){
			e.setCancelled(true);
			p.chat("/kit switcher");
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getType() == Material.IRON_FENCE){
			e.setCancelled(true);
			p.chat("/kit gladiator");
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bEndermage")){
			e.setCancelled(true);
			p.chat("/kit endermage");
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getType() == Material.DIAMOND_BOOTS){
			e.setCancelled(true);
			p.chat("/kit stomper");
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getType() == Material.FIRE){
			e.setCancelled(true);
			p.chat("/kit magma");
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getType() == Material.STICK){
			e.setCancelled(true);
			p.chat("/kit grandpa");
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getType() == Material.NETHER_STAR){
			e.setCancelled(true);
			p.chat("/kit ajnin");
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getType() == Material.FIREBALL){
			e.setCancelled(true);
			p.chat("/kit firelauncher");
			p.closeInventory();
			return;
			}
		if(e.getCurrentItem().getType() == Material.WATCH){
			e.setCancelled(true);
			p.closeInventory();
			p.chat("/kit strong");
			return;
		}
		if(e.getCurrentItem().getType() == Material.APPLE){
			e.setCancelled(true);
			p.closeInventory();
			p.chat("/kit sumo");
			return;
		}
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void clickarkitspadrao2(InventoryClickEvent e){
		
		Player p = (Player) e.getWhoClicked();
		
		if((e.getInventory().getTitle().equals("§7➳ §3§lKIT PADRAO §8(pág. 2)") && (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))){
			e.setCancelled(true);
			
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lVOLTAR")){
			e.setCancelled(true);
			KitsMenu.inventory(p);
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aStrong")){
			e.setCancelled(true);
			PadraoAPI.setKit(p, "Strong");
			p.sendMessage("§7Agora seu kit padrão é §6" + 			cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit"));
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aForcefield")){
			e.setCancelled(true);
			PadraoAPI.setKit(p, "Forcefield");
			p.sendMessage("§7Agora seu kit padrão é §6" + 			cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit"));
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aSumo")){
			e.setCancelled(true);
			PadraoAPI.setKit(p, "Sumo");
			p.sendMessage("§7Agora seu kit padrão é §6" + 			cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit"));
			p.closeInventory();
			return;
		  }
		}
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void clickarkitspadrao(InventoryClickEvent e){
		
		Player p = (Player) e.getWhoClicked();
		
		if((e.getInventory().getTitle().equals("§7➳ §3§lKIT PADRAO §8(pág. 1)") && (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))){
			e.setCancelled(true);
			
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lVOLTAR")){
			e.setCancelled(true);
			KitsMenu.inventory(p);
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aPvP")){
			e.setCancelled(true);
			PadraoAPI.setKit(p, "PvP");
			p.sendMessage("§7Agora seu kit padrão é §6" + 			cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit"));
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aArcher")){
			e.setCancelled(true);
			PadraoAPI.setKit(p, "Archer");
			p.sendMessage("§7Agora seu kit padrão é §6" + 			cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit"));
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aKangaroo")){
			e.setCancelled(true);
			PadraoAPI.setKit(p, "Kangaroo");
			p.sendMessage("§7Agora seu kit padrão é §6" + 			cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit"));
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aFisherman")){
			e.setCancelled(true);
			PadraoAPI.setKit(p, "Fisherman");
			p.sendMessage("§7Agora seu kit padrão é §6" + 			cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit"));
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aCactus")){
			e.setCancelled(true);
			PadraoAPI.setKit(p, "Cactus");
			p.sendMessage("§7Agora seu kit padrão é §6" + 			cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit"));
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aMonk")){
			e.setCancelled(true);
			PadraoAPI.setKit(p, "Monk");
			p.sendMessage("§7Agora seu kit padrão é §6" + 			cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit"));
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aNinja")){
			e.setCancelled(true);
			PadraoAPI.setKit(p, "Ninja");
			p.sendMessage("§7Agora seu kit padrão é §6" + 			cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit"));
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aPhantom")){
			e.setCancelled(true);
			PadraoAPI.setKit(p, "Phantom");
			p.sendMessage("§7Agora seu kit padrão é §6" + 			cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit"));
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aGrappler")){
			e.setCancelled(true);
			PadraoAPI.setKit(p, "Grappler");
			p.sendMessage("§7Agora seu kit padrão é §6" + 			cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit"));
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aViper")){
			e.setCancelled(true);
			PadraoAPI.setKit(p, "Viper");
			p.sendMessage("§7Agora seu kit padrão é §6" + 			cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit"));
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aSnail")){
			e.setCancelled(true);
			PadraoAPI.setKit(p, "Snail");
			p.sendMessage("§7Agora seu kit padrão é §6" + 			cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit"));
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aHulk")){
			e.setCancelled(true);
			PadraoAPI.setKit(p, "Hulk");
			p.sendMessage("§7Agora seu kit padrão é §6" + 			cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit"));
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aTimelord")){
			e.setCancelled(true);
			PadraoAPI.setKit(p, "Timelord");
			p.sendMessage("§7Agora seu kit padrão é §6" + 			cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit"));
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aThor")){
			e.setCancelled(true);
			PadraoAPI.setKit(p, "Thor");
			p.sendMessage("§7Agora seu kit padrão é §6" + 			cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit"));
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aSwitcher")){
			e.setCancelled(true);
			PadraoAPI.setKit(p, "Switcher");
			p.sendMessage("§7Agora seu kit padrão é §6" + 			cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit"));
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aGladiator")){
			e.setCancelled(true);
			PadraoAPI.setKit(p, "Gladiator");
			p.sendMessage("§7Agora seu kit padrão é §6" + 			cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit"));
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aEndermage")){
			e.setCancelled(true);
			PadraoAPI.setKit(p, "Endermage");
			p.sendMessage("§7Agora seu kit padrão é §6" + 			cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit"));
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aStomper")){
			e.setCancelled(true);
			PadraoAPI.setKit(p, "Stomper");
			p.sendMessage("§7Agora seu kit padrão é §6" + 			cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit"));
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aMagma")){
			e.setCancelled(true);
			PadraoAPI.setKit(p, "Magma");
			p.sendMessage("§7Agora seu kit padrão é §6" + 			cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit"));
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aGrandpa")){
			e.setCancelled(true);
			PadraoAPI.setKit(p, "Grandpa");
			p.sendMessage("§7Agora seu kit padrão é §6" + 			cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit"));
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aAjnin")){
			e.setCancelled(true);
			PadraoAPI.setKit(p, "Ajnin");
			p.sendMessage("§7Agora seu kit padrão é §6" + 			cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit"));
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aFireLauncher")){
			e.setCancelled(true);
			PadraoAPI.setKit(p, "FireLauncher");
			p.sendMessage("§7Agora seu kit padrão é §6" + 			cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit"));
			p.closeInventory();
			return;
			}
		}
	}
}
