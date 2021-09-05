
package me.thauandev.menus;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.thauandev.API.HatAPI;
import me.thauandev.bans.API;
import me.thauandev.configuração.cfGrupo;

public class HeadsMenu implements Listener {
	
	@SuppressWarnings("deprecation")
	public static void setarInventario(Player p) {
		
		Inventory inv = Bukkit.createInventory(null, 54, "§b§lHEADS");
		
		ItemStack vidro = new ItemStack(Material.GLASS);
		ItemMeta vidrom = vidro.getItemMeta();
		vidrom.setDisplayName("§b§lVIDRO");
		vidro.setItemMeta(vidrom);
		
		ItemStack beacon = new ItemStack(Material.BEACON);
		ItemMeta beaconm = vidro.getItemMeta();
		beaconm.setDisplayName("§b§lBEACON");
		beacon.setItemMeta(beaconm);
		
		ItemStack pedra = new ItemStack(Material.STONE);
		ItemMeta pedram = pedra.getItemMeta();
		pedram.setDisplayName("§b§lPEDRA");
		pedra.setItemMeta(pedram);
		
		ItemStack bedrock = new ItemStack(Material.BEDROCK);
		ItemMeta bedrockm = bedrock.getItemMeta();
		bedrockm.setDisplayName("§b§lBEDROCK");
		bedrock.setItemMeta(bedrockm);
		
		ItemStack areia = new ItemStack(Material.SAND);
		ItemMeta areiam = areia.getItemMeta();
		areiam.setDisplayName("§b§lAREIA");
		areia.setItemMeta(areiam);
		
		ItemStack esponja = new ItemStack(Material.SPONGE);
		ItemMeta esponjam = esponja.getItemMeta();
		esponjam.setDisplayName("§b§lESPONJA");
		esponja.setItemMeta(esponjam);
		
		ItemStack lapislazuli = new ItemStack(Material.LAPIS_BLOCK);
		ItemMeta lapislazulim = lapislazuli.getItemMeta();
		lapislazulim.setDisplayName("§b§lLAPIS LAZULI");
		lapislazuli.setItemMeta(lapislazulim);
		
		ItemStack la = new ItemStack(Material.WOOL);
		ItemMeta lam = la.getItemMeta();
		lam.setDisplayName("§b§lLÃ");
		la.setItemMeta(lam);
		
		ItemStack ouro = new ItemStack(Material.GOLD_BLOCK);
		ItemMeta ourom = ouro.getItemMeta();
		ourom.setDisplayName("§b§lBLOCO DE OURO");
		ouro.setItemMeta(ourom);
		
		ItemStack ferro = new ItemStack(Material.IRON_BLOCK);
		ItemMeta ferrom = ferro.getItemMeta();
		ferrom.setDisplayName("§b§lBLOCO DE FERRO");
		ferro.setItemMeta(ferrom);
		
		ItemStack tijolo = new ItemStack(Material.BRICK);
		ItemMeta tijolom = tijolo.getItemMeta();
		tijolom.setDisplayName("§b§lTIJOLO");
		tijolo.setItemMeta(tijolom);
		
		ItemStack estante = new ItemStack(Material.BOOKSHELF);
		ItemMeta estantem = estante.getItemMeta();
		estantem.setDisplayName("§b§lESTANTE");
		estante.setItemMeta(estantem);
		
		ItemStack pedramusgo = new ItemStack(Material.MOSSY_COBBLESTONE);
		ItemMeta pedramusgom = pedramusgo.getItemMeta();
		pedramusgom.setDisplayName("§b§lPEDRA DE MUSGO");
		pedramusgo.setItemMeta(pedramusgom);
		
		ItemStack obsidian = new ItemStack(Material.OBSIDIAN);
		ItemMeta obsidianm = obsidian.getItemMeta();
		obsidianm.setDisplayName("§b§lOBSIDIAN");
		obsidian.setItemMeta(obsidianm);
		
		ItemStack diamante = new ItemStack(Material.DIAMOND_BLOCK);
		ItemMeta diamantem = diamante.getItemMeta();
		diamantem.setDisplayName("§b§lBLOCO DE DIAMANTE");
		diamante.setItemMeta(diamantem);
		
		ItemStack gelo = new ItemStack(Material.ICE);
		ItemMeta gelom = gelo.getItemMeta();
		gelom.setDisplayName("§b§lGELO");
		gelo.setItemMeta(gelom);
		
		ItemStack neve = new ItemStack(Material.SNOW_BLOCK);
		ItemMeta nevem = neve.getItemMeta();
		nevem.setDisplayName("§b§lBLOCO DE NEVE");
		neve.setItemMeta(nevem);
		
		ItemStack nether = new ItemStack(Material.NETHERRACK);
		ItemMeta netherm = nether.getItemMeta();
		netherm.setDisplayName("§b§lROCHA DO NETHER");
		nether.setItemMeta(netherm);
		
		ItemStack glow = new ItemStack(Material.GLOWSTONE);
		ItemMeta glowm = glow.getItemMeta();
		glowm.setDisplayName("§b§lGLOWSTONE");
		glow.setItemMeta(glowm);
		
		ItemStack abobora = new ItemStack(Material.JACK_O_LANTERN);
		ItemMeta aboboram = abobora.getItemMeta();
		aboboram.setDisplayName("§b§lABOBORA");
		abobora.setItemMeta(aboboram);
		
		ItemStack esmeralda = new ItemStack(Material.EMERALD_BLOCK);
		ItemMeta esmeraldam = esmeralda.getItemMeta();
		esmeraldam.setDisplayName("§b§lBLOCO DE ESMERALDA");
		esmeralda.setItemMeta(esmeraldam);
		
		ItemStack sair = new ItemStack(Material.getMaterial(351), 1, (short)1);
		ItemMeta sairm = esmeralda.getItemMeta();
		sairm.setDisplayName("§c§lSAIR DO MENU");
		sair.setItemMeta(sairm);
		
		ItemStack remover = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
		ItemMeta removerm = remover.getItemMeta();
		removerm.setDisplayName("§c§lREMOVER HEAD");
		remover.setItemMeta(removerm);
		
		ItemStack vidros = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
		ItemMeta vidrosm = vidros.getItemMeta();
		vidrosm.setDisplayName("§c§lSPEED§f§lMC");
		vidros.setItemMeta(vidrosm);
		
		inv.setItem(1, vidro);
		inv.setItem(2, beacon);
		inv.setItem(3, pedra);
		inv.setItem(4, pedramusgo);
		inv.setItem(5, areia);
		inv.setItem(6, lapislazuli);
		inv.setItem(7, ferro);
		inv.setItem(10, ouro);
		inv.setItem(11, diamante);
		inv.setItem(12, esmeralda);
		inv.setItem(13, esponja);
		inv.setItem(14, bedrock);
		inv.setItem(15, la);
		inv.setItem(16, estante);
		inv.setItem(19, obsidian);
		inv.setItem(20, abobora);
		inv.setItem(21, glow);
		inv.setItem(22, nether);
		inv.setItem(23, neve);
		inv.setItem(24, gelo);
		inv.setItem(25, tijolo);
		inv.setItem(38, sair);
		inv.setItem(42, remover);
		
		p.openInventory(inv);
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void abrirMenu(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if(p.getItemInHand().getType() == Material.getMaterial(58) && me.thauandev.API.API.getWarp(p) == "Spawn" && e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK && p.getItemInHand().hasItemMeta() && p.getItemInHand().getItemMeta().hasDisplayName() && p.getItemInHand().getItemMeta().getDisplayName().equals("§6» §7Heads")){
			if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Trial") && !cfGrupo.ChecarGrupo(p, "Youtuber+") && !cfGrupo.ChecarGrupo(p, "Youtuber") && !cfGrupo.ChecarGrupo(p, "S-Pro") && !cfGrupo.ChecarGrupo(p, "Pro") && !cfGrupo.ChecarGrupo(p, "Mvp") && !cfGrupo.ChecarGrupo(p, "Helper")) {
				p.sendMessage("§c§lSPEED§f§lMC §fVoce nao §a§lPOSSUI §fpermissao para utilizar este item!");
			} else {
				setarInventario(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 20L, 20L);
			}
		}
	}
	@EventHandler
	public void clicarInv(InventoryClickEvent e) {
		
		ItemStack vidro = new ItemStack(Material.GLASS);
		ItemMeta vidrom = vidro.getItemMeta();
		vidrom.setDisplayName("§b§lVIDRO");
		vidro.setItemMeta(vidrom);
		
		ItemStack beacon = new ItemStack(Material.BEACON);
		ItemMeta beaconm = vidro.getItemMeta();
		beaconm.setDisplayName("§b§lBEACON");
		beacon.setItemMeta(beaconm);
		
		ItemStack pedra = new ItemStack(Material.STONE);
		ItemMeta pedram = pedra.getItemMeta();
		pedram.setDisplayName("§b§lPEDRA");
		pedra.setItemMeta(pedram);
		
		ItemStack bedrock = new ItemStack(Material.BEDROCK);
		ItemMeta bedrockm = bedrock.getItemMeta();
		bedrockm.setDisplayName("§b§lBEDROCK");
		bedrock.setItemMeta(bedrockm);
		
		ItemStack areia = new ItemStack(Material.SAND);
		ItemMeta areiam = areia.getItemMeta();
		areiam.setDisplayName("§b§lAREIA");
		areia.setItemMeta(areiam);
		
		ItemStack esponja = new ItemStack(Material.SPONGE);
		ItemMeta esponjam = esponja.getItemMeta();
		esponjam.setDisplayName("§b§lESPONJA");
		esponja.setItemMeta(esponjam);
		
		ItemStack lapislazuli = new ItemStack(Material.LAPIS_BLOCK);
		ItemMeta lapislazulim = lapislazuli.getItemMeta();
		lapislazulim.setDisplayName("§b§lLAPIS LAZULI");
		lapislazuli.setItemMeta(lapislazulim);
		
		ItemStack la = new ItemStack(Material.WOOL);
		ItemMeta lam = la.getItemMeta();
		lam.setDisplayName("§b§lLÃ");
		la.setItemMeta(lam);
		
		ItemStack ouro = new ItemStack(Material.GOLD_BLOCK);
		ItemMeta ourom = ouro.getItemMeta();
		ourom.setDisplayName("§b§lBLOCO DE OURO");
		ouro.setItemMeta(ourom);
		
		ItemStack ferro = new ItemStack(Material.IRON_BLOCK);
		ItemMeta ferrom = ferro.getItemMeta();
		ferrom.setDisplayName("§b§lBLOCO DE FERRO");
		ferro.setItemMeta(ferrom);
		
		ItemStack tijolo = new ItemStack(Material.BRICK);
		ItemMeta tijolom = tijolo.getItemMeta();
		tijolom.setDisplayName("§b§lTIJOLO");
		tijolo.setItemMeta(tijolom);
		
		ItemStack estante = new ItemStack(Material.BOOKSHELF);
		ItemMeta estantem = estante.getItemMeta();
		estantem.setDisplayName("§b§lESTANTE");
		estante.setItemMeta(estantem);
		
		ItemStack pedramusgo = new ItemStack(Material.MOSSY_COBBLESTONE);
		ItemMeta pedramusgom = pedramusgo.getItemMeta();
		pedramusgom.setDisplayName("§b§lPEDRA DE MUSGO");
		pedramusgo.setItemMeta(pedramusgom);
		
		ItemStack obsidian = new ItemStack(Material.OBSIDIAN);
		ItemMeta obsidianm = obsidian.getItemMeta();
		obsidianm.setDisplayName("§b§lOBSIDIAN");
		obsidian.setItemMeta(obsidianm);
		
		ItemStack diamante = new ItemStack(Material.DIAMOND_BLOCK);
		ItemMeta diamantem = diamante.getItemMeta();
		diamantem.setDisplayName("§b§lBLOCO DE DIAMANTE");
		diamante.setItemMeta(diamantem);
		
		ItemStack gelo = new ItemStack(Material.ICE);
		ItemMeta gelom = gelo.getItemMeta();
		gelom.setDisplayName("§b§lGELO");
		gelo.setItemMeta(gelom);
		
		ItemStack neve = new ItemStack(Material.SNOW_BLOCK);
		ItemMeta nevem = neve.getItemMeta();
		nevem.setDisplayName("§b§lBLOCO DE NEVE");
		neve.setItemMeta(nevem);
		
		ItemStack nether = new ItemStack(Material.NETHERRACK);
		ItemMeta netherm = nether.getItemMeta();
		netherm.setDisplayName("§b§lROCHA DO NETHER");
		nether.setItemMeta(netherm);
		
		ItemStack glow = new ItemStack(Material.GLOWSTONE);
		ItemMeta glowm = glow.getItemMeta();
		glowm.setDisplayName("§b§lGLOWSTONE");
		glow.setItemMeta(glowm);
		
		ItemStack abobora = new ItemStack(Material.JACK_O_LANTERN);
		ItemMeta aboboram = abobora.getItemMeta();
		aboboram.setDisplayName("§b§lABOBORA");
		abobora.setItemMeta(aboboram);
		
		ItemStack esmeralda = new ItemStack(Material.EMERALD_BLOCK);
		ItemMeta esmeraldam = esmeralda.getItemMeta();
		esmeraldam.setDisplayName("§b§lBLOCO DE ESMERALDA");
		esmeralda.setItemMeta(esmeraldam);
		
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory().getTitle().equalsIgnoreCase("§b§lHEADS")) {
			if(e.getCurrentItem().getType() == Material.GLASS) {
				if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Trial") && !cfGrupo.ChecarGrupo(p, "Youtuber+") && !cfGrupo.ChecarGrupo(p, "Youtuber") && !cfGrupo.ChecarGrupo(p, "S-Pro") && !cfGrupo.ChecarGrupo(p, "Pro") && !cfGrupo.ChecarGrupo(p, "Mvp") && !cfGrupo.ChecarGrupo(p, "Helper")) {
					p.sendMessage("§c§lSPEED§f§lMC §fVoce nao §a§lPOSSUI §fpermissao para utilizar §b§lCABEÇAS§!");
					p.closeInventory();
					e.setCancelled(true);
					return;
				} else {
					p.getInventory().setHelmet(vidro);
					API.sendSound(p, Sound.LEVEL_UP, 10);
					p.sendMessage("§c§lSPEED§f§lMC §fA sua cabeça foi alterada para: §c§lVIDRO");
					p.closeInventory();
					e.setCancelled(true);
					return;
				}

			}
			if(e.getCurrentItem().getType() == Material.BEACON) {
				if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Trial") && !cfGrupo.ChecarGrupo(p, "Youtuber+") && !cfGrupo.ChecarGrupo(p, "Youtuber") && !cfGrupo.ChecarGrupo(p, "S-Pro") && !cfGrupo.ChecarGrupo(p, "Pro") && !cfGrupo.ChecarGrupo(p, "Mvp") && !cfGrupo.ChecarGrupo(p, "Helper")) {
					p.sendMessage("§c§lSPEED§f§lMC §fVoce nao §a§lPOSSUI §fpermissao para utilizar §b§lCABEÇAS§!");
					p.closeInventory();
					e.setCancelled(true);
					return;
				} else {
					p.getInventory().setHelmet(beacon);
					API.sendSound(p, Sound.LEVEL_UP, 10);
					p.sendMessage("§c§lSPEED§f§lMC §fA sua cabeça foi alterada para: §c§lBEACON");
					p.closeInventory();
					e.setCancelled(true);
					return;
				}

			}
			if(e.getCurrentItem().getType() == Material.STONE) {
				if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Trial") && !cfGrupo.ChecarGrupo(p, "Youtuber+") && !cfGrupo.ChecarGrupo(p, "Youtuber") && !cfGrupo.ChecarGrupo(p, "S-Pro") && !cfGrupo.ChecarGrupo(p, "Pro") && !cfGrupo.ChecarGrupo(p, "Mvp") && !cfGrupo.ChecarGrupo(p, "Helper")) {
					p.sendMessage("§c§lSPEED§f§lMC §fVoce nao §a§lPOSSUI §fpermissao para utilizar §b§lCABEÇAS§!");
					p.closeInventory();
					e.setCancelled(true);
					return;
				} else {
					p.getInventory().setHelmet(pedra);
					API.sendSound(p, Sound.LEVEL_UP, 10);
					p.sendMessage("§c§lSPEED§f§lMC §fA sua cabeça foi alterada para: §c§lPEDRA");
					p.closeInventory();
					e.setCancelled(true);
					return;
				}

			}
			if(e.getCurrentItem().getType() == Material.MOSSY_COBBLESTONE) {
				if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Trial") && !cfGrupo.ChecarGrupo(p, "Youtuber+") && !cfGrupo.ChecarGrupo(p, "Youtuber") && !cfGrupo.ChecarGrupo(p, "S-Pro") && !cfGrupo.ChecarGrupo(p, "Pro") && !cfGrupo.ChecarGrupo(p, "Mvp") && !cfGrupo.ChecarGrupo(p, "Helper")) {
					p.sendMessage("§c§lSPEED§f§lMC §fVoce nao §a§lPOSSUI §fpermissao para utilizar §b§lCABEÇAS§!");
					p.closeInventory();
					e.setCancelled(true);
					return;
				} else {
					p.getInventory().setHelmet(pedramusgo);
					API.sendSound(p, Sound.LEVEL_UP, 10);
					p.sendMessage("§c§lSPEED§f§lMC §fA sua cabeça foi alterada para: §c§lPEDRA DE MUSGO");
					p.closeInventory();
					e.setCancelled(true);
					return;
				}

			}
			if(e.getCurrentItem().getType() == Material.SAND) {
				if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Trial") && !cfGrupo.ChecarGrupo(p, "Youtuber+") && !cfGrupo.ChecarGrupo(p, "Youtuber") && !cfGrupo.ChecarGrupo(p, "S-Pro") && !cfGrupo.ChecarGrupo(p, "Pro") && !cfGrupo.ChecarGrupo(p, "Mvp") && !cfGrupo.ChecarGrupo(p, "Helper")) {
					p.sendMessage("§c§lSPEED§f§lMC §fVoce nao §a§lPOSSUI §fpermissao para utilizar §b§lCABEÇAS§!");
					p.closeInventory();
					e.setCancelled(true);
					return;
				} else {
					p.getInventory().setHelmet(areia);
					API.sendSound(p, Sound.LEVEL_UP, 10);
					p.sendMessage("§c§lSPEED§f§lMC §fA sua cabeça foi alterada para: §c§lAREIA");
					p.closeInventory();
					e.setCancelled(true);
					return;
				}

			}
			if(e.getCurrentItem().getType() == Material.LAPIS_BLOCK) {
				if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Trial") && !cfGrupo.ChecarGrupo(p, "Youtuber+") && !cfGrupo.ChecarGrupo(p, "Youtuber") && !cfGrupo.ChecarGrupo(p, "S-Pro") && !cfGrupo.ChecarGrupo(p, "Pro") && !cfGrupo.ChecarGrupo(p, "Mvp") && !cfGrupo.ChecarGrupo(p, "Helper")) {
					p.sendMessage("§c§lSPEED§f§lMC §fVoce nao §a§lPOSSUI §fpermissao para utilizar §b§lCABEÇAS§!");
					p.closeInventory();
					e.setCancelled(true);
					return;
				} else {
					p.getInventory().setHelmet(lapislazuli);
					API.sendSound(p, Sound.LEVEL_UP, 10);
					p.sendMessage("§c§lSPEED§f§lMC §fA sua cabeça foi alterada para: §c§lLAPIS LAZULI");
					p.closeInventory();
					e.setCancelled(true);
					return;
				}

			}
			if(e.getCurrentItem().getType() == Material.IRON_BLOCK) {
				if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Trial") && !cfGrupo.ChecarGrupo(p, "Youtuber+") && !cfGrupo.ChecarGrupo(p, "Youtuber") && !cfGrupo.ChecarGrupo(p, "S-Pro") && !cfGrupo.ChecarGrupo(p, "Pro") && !cfGrupo.ChecarGrupo(p, "Mvp") && !cfGrupo.ChecarGrupo(p, "Helper")) {
					p.sendMessage("§c§lSPEED§f§lMC §fVoce nao §a§lPOSSUI §fpermissao para utilizar §b§lCABEÇAS§!");
					p.closeInventory();
					e.setCancelled(true);
					return;
				} else {
					p.getInventory().setHelmet(ferro);
					API.sendSound(p, Sound.LEVEL_UP, 10);
					p.sendMessage("§c§lSPEED§f§lMC §fA sua cabeça foi alterada para: §c§lBLOCO DE FERRO");
					p.closeInventory();
					e.setCancelled(true);
					return;
				}

			}
			if(e.getCurrentItem().getType() == Material.GOLD_BLOCK) {
				if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Trial") && !cfGrupo.ChecarGrupo(p, "Youtuber+") && !cfGrupo.ChecarGrupo(p, "Youtuber") && !cfGrupo.ChecarGrupo(p, "S-Pro") && !cfGrupo.ChecarGrupo(p, "Pro") && !cfGrupo.ChecarGrupo(p, "Mvp") && !cfGrupo.ChecarGrupo(p, "Helper")) {
					p.sendMessage("§c§lSPEED§f§lMC §fVoce nao §a§lPOSSUI §fpermissao para utilizar §b§lCABEÇAS§!");
					p.closeInventory();
					e.setCancelled(true);
					return;
				} else {
					p.getInventory().setHelmet(ouro);  
					API.sendSound(p, Sound.LEVEL_UP, 10);
					p.sendMessage("§c§lSPEED§f§lMC §fA sua cabeça foi alterada para: §c§lBLOCO DE OURO");
					p.closeInventory();
					e.setCancelled(true);
					return;
				}

			}
			if(e.getCurrentItem().getType() == Material.DIAMOND_BLOCK) {
				if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Trial") && !cfGrupo.ChecarGrupo(p, "Youtuber+") && !cfGrupo.ChecarGrupo(p, "Youtuber") && !cfGrupo.ChecarGrupo(p, "S-Pro") && !cfGrupo.ChecarGrupo(p, "Pro") && !cfGrupo.ChecarGrupo(p, "Mvp") && !cfGrupo.ChecarGrupo(p, "Helper")) {
					p.sendMessage("§c§lSPEED§f§lMC §fVoce nao §a§lPOSSUI §fpermissao para utilizar §b§lCABEÇAS§!");
					p.closeInventory();
					e.setCancelled(true);
					return;
				} else {
					p.getInventory().setHelmet(diamante);
					API.sendSound(p, Sound.LEVEL_UP, 10);
					p.sendMessage("§c§lSPEED§f§lMC §fA sua cabeça foi alterada para: §c§lBLOCO DE DIAMANTE");
					p.closeInventory();
					e.setCancelled(true);
					return;
				}

			}
			if(e.getCurrentItem().getType() == Material.EMERALD_BLOCK) {
				if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Trial") && !cfGrupo.ChecarGrupo(p, "Youtuber+") && !cfGrupo.ChecarGrupo(p, "Youtuber") && !cfGrupo.ChecarGrupo(p, "S-Pro") && !cfGrupo.ChecarGrupo(p, "Pro") && !cfGrupo.ChecarGrupo(p, "Mvp") && !cfGrupo.ChecarGrupo(p, "Helper")) {
					p.sendMessage("§c§lSPEED§f§lMC §fVoce nao §a§lPOSSUI §fpermissao para utilizar §b§lCABEÇAS§!");
					p.closeInventory();
					e.setCancelled(true);
					return;
				} else {
					p.getInventory().setHelmet(esmeralda);
					API.sendSound(p, Sound.LEVEL_UP, 10);
					p.sendMessage("§c§lSPEED§f§lMC §fA sua cabeça foi alterada para: §c§lBLOCO DE ESMERALDA");
					p.closeInventory();
					e.setCancelled(true);
					return;
				}

			}
			if(e.getCurrentItem().getType() == Material.SPONGE) {
				if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Trial") && !cfGrupo.ChecarGrupo(p, "Youtuber+") && !cfGrupo.ChecarGrupo(p, "Youtuber") && !cfGrupo.ChecarGrupo(p, "S-Pro") && !cfGrupo.ChecarGrupo(p, "Pro") && !cfGrupo.ChecarGrupo(p, "Mvp") && !cfGrupo.ChecarGrupo(p, "Helper")) {
					p.sendMessage("§c§lSPEED§f§lMC §fVoce nao §a§lPOSSUI §fpermissao para utilizar §b§lCABEÇAS§!");
					p.closeInventory();
					e.setCancelled(true);
					return;
				} else {
					p.getInventory().setHelmet(esponja);
					API.sendSound(p, Sound.LEVEL_UP, 10);
					p.sendMessage("§c§lSPEED§f§lMC §fA sua cabeça foi alterada para: §c§lESPONJA");
					p.closeInventory();
					e.setCancelled(true);
					return;
				}

			}
			if(e.getCurrentItem().getType() == Material.BEDROCK) {
				if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Trial") && !cfGrupo.ChecarGrupo(p, "Youtuber+") && !cfGrupo.ChecarGrupo(p, "Youtuber") && !cfGrupo.ChecarGrupo(p, "S-Pro") && !cfGrupo.ChecarGrupo(p, "Pro") && !cfGrupo.ChecarGrupo(p, "Mvp") && !cfGrupo.ChecarGrupo(p, "Helper")) {
					p.sendMessage("§c§lSPEED§f§lMC §fVoce nao §a§lPOSSUI §fpermissao para utilizar §b§lCABEÇAS§!");
					p.closeInventory();
					e.setCancelled(true);
					return;
				} else {
					p.getInventory().setHelmet(bedrock);
					API.sendSound(p, Sound.LEVEL_UP, 10);
					p.sendMessage("§c§lSPEED§f§lMC §fA sua cabeça foi alterada para: §c§lBEDROCK");
					p.closeInventory();
					e.setCancelled(true);
					return;
				}

			}
			if(e.getCurrentItem().getType() == Material.WOOL) {
				if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Trial") && !cfGrupo.ChecarGrupo(p, "Youtuber+") && !cfGrupo.ChecarGrupo(p, "Youtuber") && !cfGrupo.ChecarGrupo(p, "S-Pro") && !cfGrupo.ChecarGrupo(p, "Pro") && !cfGrupo.ChecarGrupo(p, "Mvp") && !cfGrupo.ChecarGrupo(p, "Helper")) {
					p.sendMessage("§c§lSPEED§f§lMC §fVoce nao §a§lPOSSUI §fpermissao para utilizar §b§lCABEÇAS§!");
					p.closeInventory();
					e.setCancelled(true);
					return;
				} else {
					p.getInventory().setHelmet(la);
					API.sendSound(p, Sound.LEVEL_UP, 10);
					p.sendMessage("§c§lSPEED§f§lMC §fA sua cabeça foi alterada para: §c§lLÃ");
					p.closeInventory();
					e.setCancelled(true);
					return;
				}

			}
			if(e.getCurrentItem().getType() == Material.BOOKSHELF) {
				if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Trial") && !cfGrupo.ChecarGrupo(p, "Youtuber+") && !cfGrupo.ChecarGrupo(p, "Youtuber") && !cfGrupo.ChecarGrupo(p, "S-Pro") && !cfGrupo.ChecarGrupo(p, "Pro") && !cfGrupo.ChecarGrupo(p, "Mvp") && !cfGrupo.ChecarGrupo(p, "Helper")) {
					p.sendMessage("§c§lSPEED§f§lMC §fVoce nao §a§lPOSSUI §fpermissao para utilizar §b§lCABEÇAS§!");
					p.closeInventory();
					e.setCancelled(true);
					return;
				} else {
					p.getInventory().setHelmet(estante);
					API.sendSound(p, Sound.LEVEL_UP, 10);
					p.sendMessage("§c§lSPEED§f§lMC §fA sua cabeça foi alterada para: §c§lESPONJA");
					p.closeInventory();
					e.setCancelled(true);
					return;
				}

			}
			if(e.getCurrentItem().getType() == Material.OBSIDIAN) {
				if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Trial") && !cfGrupo.ChecarGrupo(p, "Youtuber+") && !cfGrupo.ChecarGrupo(p, "Youtuber") && !cfGrupo.ChecarGrupo(p, "S-Pro") && !cfGrupo.ChecarGrupo(p, "Pro") && !cfGrupo.ChecarGrupo(p, "Mvp") && !cfGrupo.ChecarGrupo(p, "Helper")) {
					p.sendMessage("§c§lSPEED§f§lMC §fVoce nao §a§lPOSSUI §fpermissao para utilizar §b§lCABEÇAS§!");
					p.closeInventory();
					e.setCancelled(true);
					return;
				} else {
					p.getInventory().setHelmet(obsidian);
					API.sendSound(p, Sound.LEVEL_UP, 10);
					p.sendMessage("§c§lSPEED§f§lMC §fA sua cabeça foi alterada para: §c§lOBSIDIAN");
					p.closeInventory();
					e.setCancelled(true);
					return;
				}

			}
			if(e.getCurrentItem().getType() == Material.JACK_O_LANTERN) {
				if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Trial") && !cfGrupo.ChecarGrupo(p, "Youtuber+") && !cfGrupo.ChecarGrupo(p, "Youtuber") && !cfGrupo.ChecarGrupo(p, "S-Pro") && !cfGrupo.ChecarGrupo(p, "Pro") && !cfGrupo.ChecarGrupo(p, "Mvp") && !cfGrupo.ChecarGrupo(p, "Helper")) {
					p.sendMessage("§c§lSPEED§f§lMC §fVoce nao §a§lPOSSUI §fpermissao para utilizar §b§lCABEÇAS§!");
					p.closeInventory();
					e.setCancelled(true);
					return;
				} else {
					p.getInventory().setHelmet(abobora);
					API.sendSound(p, Sound.LEVEL_UP, 10);
					p.sendMessage("§c§lSPEED§f§lMC §fA sua cabeça foi alterada para: §c§lABOBORA");
					p.closeInventory();
					e.setCancelled(true);
					return;
				}

			}
			if(e.getCurrentItem().getType() == Material.GLOWSTONE) {
				if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Trial") && !cfGrupo.ChecarGrupo(p, "Youtuber+") && !cfGrupo.ChecarGrupo(p, "Youtuber") && !cfGrupo.ChecarGrupo(p, "S-Pro") && !cfGrupo.ChecarGrupo(p, "Pro") && !cfGrupo.ChecarGrupo(p, "Mvp") && !cfGrupo.ChecarGrupo(p, "Helper")) {
					p.sendMessage("§c§lSPEED§f§lMC §fVoce nao §a§lPOSSUI §fpermissao para utilizar §b§lCABEÇAS§!");
					p.closeInventory();
					e.setCancelled(true);
					return;
				} else {
					p.getInventory().setHelmet(glow);
					API.sendSound(p, Sound.LEVEL_UP, 10);
					p.sendMessage("§c§lSPEED§f§lMC §fA sua cabeça foi alterada para: §c§lGLOWSTONE");
					p.closeInventory();
					e.setCancelled(true);
					return;
				}

			}
			if(e.getCurrentItem().getType() == Material.NETHERRACK) {
				if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Trial") && !cfGrupo.ChecarGrupo(p, "Youtuber+") && !cfGrupo.ChecarGrupo(p, "Youtuber") && !cfGrupo.ChecarGrupo(p, "S-Pro") && !cfGrupo.ChecarGrupo(p, "Pro") && !cfGrupo.ChecarGrupo(p, "Mvp") && !cfGrupo.ChecarGrupo(p, "Helper")) {
					p.sendMessage("§c§lSPEED§f§lMC §fVoce nao §a§lPOSSUI §fpermissao para utilizar §b§lCABEÇAS§!");
					p.closeInventory();
					e.setCancelled(true);
					return;
				} else {
					p.getInventory().setHelmet(nether);
					API.sendSound(p, Sound.LEVEL_UP, 10);
					p.sendMessage("§c§lSPEED§f§lMC §fA sua cabeça foi alterada para: §c§lROCHA DO NETHER");
					p.closeInventory();
					e.setCancelled(true);
					return;
				}

			}
			if(e.getCurrentItem().getType() == Material.SNOW_BLOCK) {
				if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Trial") && !cfGrupo.ChecarGrupo(p, "Youtuber+") && !cfGrupo.ChecarGrupo(p, "Youtuber") && !cfGrupo.ChecarGrupo(p, "S-Pro") && !cfGrupo.ChecarGrupo(p, "Pro") && !cfGrupo.ChecarGrupo(p, "Mvp") && !cfGrupo.ChecarGrupo(p, "Helper")) {
					p.sendMessage("§c§lSPEED§f§lMC §fVoce nao §a§lPOSSUI §fpermissao para utilizar §b§lCABEÇAS§!");
					p.closeInventory();
					e.setCancelled(true);
					return;
				} else {
					p.getInventory().setHelmet(neve);
					API.sendSound(p, Sound.LEVEL_UP, 10);
					p.sendMessage("§c§lSPEED§f§lMC §fA sua cabeça foi alterada para: §c§lBLOCO DE NEVE");
					p.closeInventory();
					e.setCancelled(true);
					return;
				}

			}
			if(e.getCurrentItem().getType() == Material.ICE) {
				if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Trial") && !cfGrupo.ChecarGrupo(p, "Youtuber+") && !cfGrupo.ChecarGrupo(p, "Youtuber") && !cfGrupo.ChecarGrupo(p, "S-Pro") && !cfGrupo.ChecarGrupo(p, "Pro") && !cfGrupo.ChecarGrupo(p, "Mvp") && !cfGrupo.ChecarGrupo(p, "Helper")) {
					p.sendMessage("§c§lSPEED§f§lMC §fVoce nao §a§lPOSSUI §fpermissao para utilizar §b§lCABEÇAS§!");
					p.closeInventory();
					e.setCancelled(true);
					return;
				} else {
					p.getInventory().setHelmet(gelo);
					API.sendSound(p, Sound.LEVEL_UP, 10);
					p.sendMessage("§c§lSPEED§f§lMC §fA sua cabeça foi alterada para: §c§lGELO");
					p.closeInventory();
					e.setCancelled(true);
					return;
				}

			}
			if(e.getCurrentItem().getType() == Material.BRICK) {
				if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Trial") && !cfGrupo.ChecarGrupo(p, "Youtuber+") && !cfGrupo.ChecarGrupo(p, "Youtuber") && !cfGrupo.ChecarGrupo(p, "S-Pro") && !cfGrupo.ChecarGrupo(p, "Pro") && !cfGrupo.ChecarGrupo(p, "Mvp") && !cfGrupo.ChecarGrupo(p, "Helper")) {
					p.sendMessage("§c§lSPEED§f§lMC §fVoce nao §a§lPOSSUI §fpermissao para utilizar §b§lCABEÇAS§!");
					p.closeInventory();
					e.setCancelled(true);
					return;
				} else {
					p.getInventory().setHelmet(tijolo);
					API.sendSound(p, Sound.LEVEL_UP, 10);
					p.sendMessage("§c§lSPEED§f§lMC §fA sua cabeça foi alterada para: §c§lTIJOLO");
					p.closeInventory();
					e.setCancelled(true);
					return;
				}

			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lSAIR DO MENU")) {
				API.sendSound(p, Sound.LEVEL_UP, 10);
				p.closeInventory();
				e.setCancelled(true);
				return;
			}
			if(e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) {
				if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Trial") && !cfGrupo.ChecarGrupo(p, "Youtuber+") && !cfGrupo.ChecarGrupo(p, "Youtuber") && !cfGrupo.ChecarGrupo(p, "S-Pro") && !cfGrupo.ChecarGrupo(p, "Pro") && !cfGrupo.ChecarGrupo(p, "Mvp") && !cfGrupo.ChecarGrupo(p, "Helper")) {
					p.sendMessage("§c§lSPEED§f§lMC §fVoce nao §a§lPOSSUI §fpermissao para usar §c§lCABEÇAS");
					p.closeInventory();
					e.setCancelled(true);
					return;
				} else {
					HatAPI.removeHat(p);
					API.sendSound(p, Sound.LEVEL_UP, 10);
					p.sendMessage("§c§lSPEED§f§lMC §fCabeça removida com sucesso!");
					p.closeInventory();
					e.setCancelled(true);
					return;
				}
			}
		}
	}
}
