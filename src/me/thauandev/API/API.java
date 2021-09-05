
package me.thauandev.API;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.spigotmc.ProtocolInjector;

import me.thauandev.API.CalendarioAPI.Calendario;
import me.thauandev.bossbar.api.BossBarAPI;
import me.thauandev.commands.GiveAllCommand;
import me.thauandev.configuração.cfConfig;
import me.thauandev.configuração.cfGrupo;
import me.thauandev.configuração.cfKitdiario;
import me.thauandev.configuração.cfPermissão;
import me.thauandev.configuração.cfStatus;
import me.thauandev.configuração.cfTempGrupo;
import me.thauandev.events.CorGrupo;
import me.thauandev.habilidades.Ajnin;
import me.thauandev.habilidades.Ninja;
import me.thauandev.habilidades.Strong;
import me.thauandev.invencivel.Proteção;
import me.thauandev.main.Main;
import me.thauandev.nametag.Array;
import me.thauandev.nametag.NametagManager;
import me.thauandev.nametag.NametagUtils;
import me.thauandev.nametag.PlayerLoader;
import me.thauandev.scoreboard.sScoreAPI;
import net.minecraft.server.v1_7_R4.ChatSerializer;
import net.minecraft.server.v1_7_R4.IChatBaseComponent;
import net.minecraft.server.v1_7_R4.PacketPlayOutChat;

public class API {

	public static ArrayList<Player> inCombat = new ArrayList<>();
	
	public static void BarAPI(Player p, String menssagem){
		
		int numero = 20;
				BossBarAPI.setMessage(p, menssagem);
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
					public void run() {
						BossBarAPI.removeBar(p);
					}
				}, numero * 4);
			}
	public static void checarGrupo(Player p){

		if(cfGrupo.pegargrupo().get("grupos." + p.getUniqueId() + ".grupo") == null){
			cfGrupo.setarGrupo(p, "Membro");
			cfGrupo.salvarconfiguracao();
		  }
		}
	public static void corGrupo(Player p){
		
		if(cfGrupo.ChecarGrupo(p, "Dono")){
			CorGrupo.setarTag(p, "§4§l");
		}
		else if(cfGrupo.ChecarGrupo(p, "Gerente")){
			CorGrupo.setarTag(p, "§3§l");
		}
		else if(cfGrupo.ChecarGrupo(p, "Admin")){
			CorGrupo.setarTag(p, "§c§l");
		}
		else if(cfGrupo.ChecarGrupo(p, "Mod+")){
			CorGrupo.setarTag(p, "§5§l");
		}
		else if(cfGrupo.ChecarGrupo(p, "Mod")){
			CorGrupo.setarTag(p, "§5§l");
		}
		else if(cfGrupo.ChecarGrupo(p, "Trial")){
			CorGrupo.setarTag(p, "§5§l");
		}
		else if(cfGrupo.ChecarGrupo(p, "Youtuber+")){
			CorGrupo.setarTag(p, "§3§l");
		}
		else if(cfGrupo.ChecarGrupo(p, "Builder")){
			CorGrupo.setarTag(p, "§2§l");
		}
		else if(cfGrupo.ChecarGrupo(p, "Helper")){
			CorGrupo.setarTag(p, "§9§l");
		}
		else if(cfGrupo.ChecarGrupo(p, "Youtuber")){
			CorGrupo.setarTag(p, "§b§l");
		}
		else if(cfGrupo.ChecarGrupo(p, "S-Pro")){
			CorGrupo.setarTag(p, "§e§l");
		}
		else if(cfGrupo.ChecarGrupo(p, "Pro")){
			CorGrupo.setarTag(p, "§6§l");
		}
		else if(cfGrupo.ChecarGrupo(p, "Mvp")){
			CorGrupo.setarTag(p, "§9§l");
		}
		else if(cfGrupo.ChecarGrupo(p, "Light")){
			CorGrupo.setarTag(p, "§a§l");
		}
		else if(cfGrupo.ChecarGrupo(p, "Membro")){
			CorGrupo.setarTag(p, "§7§l");
		}
	}
	public static void acharTag(Player p){
		 Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
			public void run() {
				API.checarGrupo(p);
				 if(cfGrupo.ChecarGrupo(p, "Dono")){
					 p.chat("/tag dono");
			}
				 if(cfGrupo.ChecarGrupo(p, "Admin")){
				p.chat("/tag admin");
			}
				 if(cfGrupo.ChecarGrupo(p, "Gerente")){
				p.chat("/tag gerente");
			}
				 if(cfGrupo.ChecarGrupo(p, "Mod+")){
				p.chat("/tag modplus");
			}
				 if(cfGrupo.ChecarGrupo(p, "Mod")){
				p.chat("/tag mod");
			}
				 if(cfGrupo.ChecarGrupo(p, "Trial")){
				p.chat("/tag trial");
			}
				 if(cfGrupo.ChecarGrupo(p, "Youtuber+")){
				p.chat("/tag youtuber+");
			}
				 if(cfGrupo.ChecarGrupo(p, "Builder")){
					 p.chat("/tag builder");
			}
				 if(cfGrupo.ChecarGrupo(p, "Helper")){
				p.chat("/tag helper");
			}
				 if(cfGrupo.ChecarGrupo(p, "Youtuber")){
				p.chat("/tag youtuber");
			}
				 if(cfGrupo.ChecarGrupo(p, "Pro")){
				p.chat("/tag ultimate");
			}
				 if(cfGrupo.ChecarGrupo(p, "S-Pro")){
				p.chat("/tag platinum");
			}
				 if(cfGrupo.ChecarGrupo(p, "Mvp")){
				p.chat("/tag premium");
			}
				 if(cfGrupo.ChecarGrupo(p, "Light")){
				p.chat("/tag light");
			}
				 if(cfGrupo.ChecarGrupo(p, "Membro")){
				p.chat("/tag normal");
			 }
		    if(GiveAllCommand.pro && cfGrupo.ChecarGrupo(p, "Membro")){
						p.chat("/tag ultimate");
					}
					 if(GiveAllCommand.mvp && cfGrupo.ChecarGrupo(p, "Membro")){
						p.chat("/tag premium");
					}
					 if(GiveAllCommand.light && cfGrupo.ChecarGrupo(p, "Membro")){
						p.chat("/tag light");
					}
			}
		 }, 2L);
	}
	@SuppressWarnings("deprecation")
	public static void checarAlgumasCoisas(Player p){
		
		 if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Youtuber+") && !cfGrupo.ChecarGrupo(p, "Pro") && !cfGrupo.ChecarGrupo(p, "Youtuber")
				 && (cfKitdiario.pegargrupo().get("kitdiario." + p.getUniqueId() + ".dia") == null)){
				 p.sendMessage("§c§lSPEED§f§lMC §fVocê já pode pegar o seu kit diário!");
					 
				 }
				API.sendItems(p);
				if(cfTempGrupo.pegargrupo().get("tempgrupos." + p.getUniqueId() + ".Dia") != null){
					if(cfTempGrupo.pegargrupo().get("tempgrupos." + p.getUniqueId() + ".Mes") != null){
						if(cfTempGrupo.pegargrupo().get("tempgrupos." + p.getUniqueId() + ".Ano") != null){
							if(cfTempGrupo.pegargrupo().get("tempgrupos." + p.getUniqueId() + ".Hora") != null){
								if(cfTempGrupo.pegargrupo().get("tempgrupos." + p.getUniqueId() + ".Minuto") != null){
									if(cfTempGrupo.pegargrupo().get("tempgrupos." + p.getUniqueId() + ".Segundos") != null){
				if((cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Dia") < CalendarioAPI.PegarCalendario(Calendario.Dia) 
						|| ((cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Dia") == CalendarioAPI.PegarCalendario(Calendario.Dia)&& (cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Mvp") || cfGrupo.ChecarGrupo(p, "Light")))))){
					
					if((cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Mes") < CalendarioAPI.PegarCalendario(Calendario.Mes) 
							|| ((cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Mes") == CalendarioAPI.PegarCalendario(Calendario.Mes)&& (cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Mvp") || cfGrupo.ChecarGrupo(p, "Light")))))){
					
						if((cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Ano") < CalendarioAPI.PegarCalendario(Calendario.Ano) 
								|| ((cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Ano") == CalendarioAPI.PegarCalendario(Calendario.Ano)&& (cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Mvp") || cfGrupo.ChecarGrupo(p, "Light")))))){
							
							if((cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Hora") < CalendarioAPI.PegarCalendario(Calendario.Hora) 
									|| ((cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Hora") == CalendarioAPI.PegarCalendario(Calendario.Hora)&& (cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Mvp") || cfGrupo.ChecarGrupo(p, "Light")))))){
								
								if((cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Minuto") < CalendarioAPI.PegarCalendario(Calendario.Minuto) 
										|| ((cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Minuto") == CalendarioAPI.PegarCalendario(Calendario.Minuto)&& (cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Mvp") || cfGrupo.ChecarGrupo(p, "Light")))))){
									
									if((cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Segundos") < CalendarioAPI.PegarCalendario(Calendario.Segundo) 
											|| ((cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Segundos") == CalendarioAPI.PegarCalendario(Calendario.Segundo)&& (cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Mvp") || cfGrupo.ChecarGrupo(p, "Light")))))){
					
						API.mandarTitulo(p, "§c§lSPEED§f§lMC");
						API.mandarSubTitulo(p, "§c§lSPEED§f§lMC O seu VIP " + cfGrupo.pegargrupo().getString("grupos." + p.getUniqueId() + ".grupo") + " §7acabou de expirar!");
						cfGrupo.salvarconfiguracao();
						Bukkit.getConsoleSender().sendMessage("§c§lSPEED§f§lMC §fO VIP do jogador §6§l" + p.getName() + " §facabou de expirar!");
						p.sendMessage("§c§lSPEED§f§lMC §7O seu VIP " + cfGrupo.pegargrupo().getString("grupos." + p.getUniqueId() + ".grupo") + "§7 acabou de expirar!");
						cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Nick", null);
						cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".grupo", null);
						cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Dia", null);
						cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Mes", null);
						cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Ano", null);
						cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Hora", null);
						cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Minuto", null);
						cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Segundos", null);
						
						cfTempGrupo.salvarconfiguracao();
						
						
						for(Player todos : Bukkit.getOnlinePlayers()){
							
							if(cfGrupo.ChecarGrupo(todos, "Dono") || cfGrupo.ChecarGrupo(todos,"Gerente") || cfGrupo.ChecarGrupo(todos,"Admin")){
								todos.sendMessage("§c§lSPEED§f§lMC §fO VIP " + cfGrupo.pegargrupo().getString("grupos." + p.getUniqueId() + ".grupo") + "§f do jogador §6§l" + p.getName() + " §facagou de expirar!");
												}
											}
						cfGrupo.setarGrupo(p, "Membro");
						if(cfGrupo.ChecarGrupo(p, "Dono")){
							CorGrupo.setarTag(p, "§4§l");
						}
						else if(cfGrupo.ChecarGrupo(p, "Gerente")){
							CorGrupo.setarTag(p, "§3§l");
						}
						else if(cfGrupo.ChecarGrupo(p, "Admin")){
							CorGrupo.setarTag(p, "§c§l");
						}
						else if(cfGrupo.ChecarGrupo(p, "Mod+")){
							CorGrupo.setarTag(p, "§5§l");
						}
						else if(cfGrupo.ChecarGrupo(p, "Mod")){
							CorGrupo.setarTag(p, "§5§l");
						}
						else if(cfGrupo.ChecarGrupo(p, "Trial")){
							CorGrupo.setarTag(p, "§5§l");
						}
						else if(cfGrupo.ChecarGrupo(p, "Youtuber+")){
							CorGrupo.setarTag(p, "§3§l");
						}
						else if(cfGrupo.ChecarGrupo(p, "Builder")){
							CorGrupo.setarTag(p, "§2§l");
						}
						else if(cfGrupo.ChecarGrupo(p, "Helper")){
							CorGrupo.setarTag(p, "§e§l");
						}
						else if(cfGrupo.ChecarGrupo(p, "Youtuber")){
							CorGrupo.setarTag(p, "§b§l");
						}
						else if(cfGrupo.ChecarGrupo(p, "S-Pro")){
							CorGrupo.setarTag(p, "§e§l");
						}
						else if(cfGrupo.ChecarGrupo(p, "Pro")){
							CorGrupo.setarTag(p, "§6§l");
						}
						else if(cfGrupo.ChecarGrupo(p, "Mvp")){
							CorGrupo.setarTag(p, "§9§l");
						}
						else if(cfGrupo.ChecarGrupo(p, "Light")){
							CorGrupo.setarTag(p, "§a§l");
						}
						else if(cfGrupo.ChecarGrupo(p, "Membro")){
							CorGrupo.setarTag(p, "§7§l");
						}
						sScoreAPI.scoreboard(p);
						p.chat("/tag normal");
										}
								}
							}
						}
					}
				}
									}
								}
							}
						}
					}
				}

	}
	public static void checarNameTag(Player p){
		 Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
			@SuppressWarnings("unused")
			public void run() {
				
		 NametagManager.MandarTeamsParaJogador(p);
	        NametagManager.Limpar(p.getName());
	        boolean SetarGrupo = true;
	          
	        LinkedHashMap<String, String> pData = PlayerLoader.getPlayer(p.getName());
	        if (pData != null) {
	        	String Prefix = (String)pData.get("prefix");
	        	String Suffix = (String)pData.get("suffix");
	        	if (Prefix != null) {
	        		Prefix = NametagUtils.formatColors(Prefix);
	        	}
	        	if (Suffix != null) {
	        		Suffix = NametagUtils.formatColors(Suffix);
	        	}
	        	if (Array.consolePrintEnabled) {
	        		System.out.println("Setting prefix/suffix for " + p.getName() + ": " + Prefix + ", " + Suffix + " (user)");
	        	}
	        	NametagManager.Overlap(p.getName(), Prefix, Suffix);
	        	SetarGrupo = false;
	        }
		 }
		}, 1L);
		 Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
			public void run() {
				acharTag(p);
			}
		}, 2L);
	}
	public static void checarConfig(Player p){
		if(cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".Nick") == null){
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".Nick", p.getName());
			cfConfig.salvarconfiguracao();
		}
			if(cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit") == null){
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".PadraoKit", "PvP");
			cfConfig.salvarconfiguracao();
			}
			if(cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".Tell") == null){
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".Tell", "Ativado");
			cfConfig.salvarconfiguracao();
			}
			cfConfig.salvarconfiguracao();
	}
	public static void checarPermissao(Player p){

		if(cfPermissão.pegarpermissao().get("permissões." + p.getUniqueId() + ".kit.monk") == null){
			cfPermissão.setarPermissao(p, "kit.monk", "false");
		}
		if(cfPermissão.pegarpermissao().get("permissões." + p.getUniqueId() + ".kit.ninja") == null){
			cfPermissão.setarPermissao(p, "kit.ninja", "false");
		}
		if(cfPermissão.pegarpermissao().get("permissões." + p.getUniqueId() + ".kit.antitower") == null){
			cfPermissão.setarPermissao(p, "kit.antitower", "false");
		}
		if(cfPermissão.pegarpermissao().get("permissões." + p.getUniqueId() + ".kit.phantom") == null){
			cfPermissão.setarPermissao(p, "kit.phantom", "false");
		}
		if(cfPermissão.pegarpermissao().get("permissões." + p.getUniqueId() + ".kit.grappler") == null){
			cfPermissão.setarPermissao(p, "kit.grappler", "false");
		}
		if(cfPermissão.pegarpermissao().get("permissões." + p.getUniqueId() + ".kit.anchor") == null){
			cfPermissão.setarPermissao(p, "kit.anchor", "false");
		}
		if(cfPermissão.pegarpermissao().get("permissões." + p.getUniqueId() + ".kit.viper") == null){
			cfPermissão.setarPermissao(p, "kit.viper", "false");
		}
		if(cfPermissão.pegarpermissao().get("permissões." + p.getUniqueId() + ".kit.snail") == null){
			cfPermissão.setarPermissao(p, "kit.snail", "false");
		}
		if(cfPermissão.pegarpermissao().get("permissões." + p.getUniqueId() + ".kit.hulk") == null){
			cfPermissão.setarPermissao(p, "kit.hulk", "false");
		}
		if(cfPermissão.pegarpermissao().get("permissões." + p.getUniqueId() + ".kit.timelord") == null){
			cfPermissão.setarPermissao(p, "kit.timelord", "false");
		}
		if(cfPermissão.pegarpermissao().get("permissões." + p.getUniqueId() + ".kit.thor") == null){
			cfPermissão.setarPermissao(p, "kit.thor", "false");
		}
		if(cfPermissão.pegarpermissao().get("permissões." + p.getUniqueId() + ".kit.switcher") == null){
			cfPermissão.setarPermissao(p, "kit.switcher", "false");
		}
		if(cfPermissão.pegarpermissao().get("permissões." + p.getUniqueId() + ".kit.gladiator") == null){
			cfPermissão.setarPermissao(p, "kit.gladiator", "false");
		}
		if(cfPermissão.pegarpermissao().get("permissões." + p.getUniqueId() + ".kit.endermage") == null){
			cfPermissão.setarPermissao(p, "kit.endermage", "false");
		}
		if(cfPermissão.pegarpermissao().get("permissões." + p.getUniqueId() + ".kit.stomper") == null){
			cfPermissão.setarPermissao(p, "kit.stomper", "false");
		}
		if(cfPermissão.pegarpermissao().get("permissões." + p.getUniqueId() + ".kit.magma") == null){
			cfPermissão.setarPermissao(p, "kit.magma", "false");
		}
		if(cfPermissão.pegarpermissao().get("permissões." + p.getUniqueId() + ".kit.grandpa") == null){
			cfPermissão.setarPermissao(p, "kit.grandpa", "false");
		}
		if(cfPermissão.pegarpermissao().get("permissões." + p.getUniqueId() + ".kit.ajnin") == null){
			cfPermissão.setarPermissao(p, "kit.ajnin", "false");
		}
		if(cfPermissão.pegarpermissao().get("permissões." + p.getUniqueId() + ".kit.firelauncher") == null){
			cfPermissão.setarPermissao(p, "kit.firelauncher", "false");
		}
		if(cfPermissão.pegarpermissao().get("permissões." + p.getUniqueId() + ".kit.strong") == null){
			cfPermissão.setarPermissao(p, "kit.strong", "false");
		}
		if(cfPermissão.pegarpermissao().get("permissões." + p.getUniqueId() + ".kit.forcefield") == null){
			cfPermissão.setarPermissao(p, "kit.forcefield", "false");
		}
		if(cfPermissão.pegarpermissao().get("permissões." + p.getUniqueId() + ".kit.sumo") == null){
			cfPermissão.setarPermissao(p, "kit.sumo", "false");
			
		}
	}
public static void AutomaticMessage() {
		
		Random random = new Random();
		switch (random.nextInt(6)) {
		case 1:
			Bukkit.broadcastMessage("§c§lSPEED§f§lMC §8§l;;§f §fO servidor está em fase §1§lBETA§f. Caso você encontre algum §4§lERRO§f, reporte em nosso Twitter!");
			break;
		case 2:
			Bukkit.broadcastMessage("§c§lSPEED§f§lMC §8§l;;§f §fPara fazer uma denúncia, use: §c/report (nick) (motivo)");
			break;
		case 3:
			Bukkit.broadcastMessage("§c§lSPEED§f§lMC §8§l;;§f §fQuer saber seu status? use o comando §c/status §fpara saber seu status!");
			break;
		case 4:
			Bukkit.broadcastMessage("§c§lSPEED§f§lMC §8§l;;§f §fDeseja tag §b§lYT §fdigite §c/youtuber §fpara saber os requisitos");
			break;
		case 5:
			Bukkit.broadcastMessage("§c§lSPEED§f§lMC §8§l;;§f §fHá algum interesse em integrar à nossa §c§lEQUIPE§f, §facesse este link! §7(§chttp://bit.ly/speedmc§7)");
			break;
		case 6:
			Bukkit.broadcastMessage("§c§lSPEED§f§lMC §8§l;;§f §fSiga-nos no §b§lTWITTER §fe fique por dentro de nossas novidades! Acesse: §7(§c§nhttp://twitter.com/speedmc_§7) §fou §7(§c§nhttp://twitter.com/thauanpvp§7)");
			break;
		}
	}
	public static ItemStack criarItem(Player p, Material material, String nome, String[] lore, int quantidade, short cor){
		
		ItemStack item = new ItemStack(material, quantidade, cor);
		ItemMeta kitem = item.getItemMeta();
		kitem.setDisplayName(nome);
		kitem.setLore(Arrays.asList(lore));
		item.setItemMeta(kitem);
		
		return item;
	}
	private static HashMap<Player, String> Warp = new HashMap<>();
	
	public static String getWarp(Player p){
		
		if(Warp.containsKey(p)){
			return Warp.get(p);
		}else{
			return "Spawn";
		}
	}
	public static void setWarp(Player p, String warp){
		Warp.put(p, warp);
	}
	public static void sendItems(Player p){
		
		if(getWarp(p) == "Spawn"){
			
			p.getInventory().setArmorContents(null);
			Ajnin.a.remove(p);
			Ninja.a.remove(p);
			Ninja.b.remove(p);
			Strong.fulliron.remove(p);
			p.setFoodLevel(20);
			p.setFireTicks(0);
			cfStatus.RemoverKS(p);
			API.setWarp(p, "Spawn");
			
			
			ItemStack Kits = new ItemStack(Material.ENDER_CHEST);
			ItemMeta kKits = Kits.getItemMeta();
			kKits.setDisplayName("§bSeus Kits §7(Clique com direito)");
			kKits.setLore(Arrays.asList("§7Confira aqui os kits que você possui e afins!"));
			Kits.setItemMeta(kKits);
			
			ItemStack Warps = new ItemStack(Material.COMPASS);
			ItemMeta kWarps = Warps.getItemMeta();
			kWarps.setDisplayName("§bWarps §7(Clique com direito)");
			kWarps.setLore(Arrays.asList("§7Confira aqui as Warps disponíveis em nosso servidor!"));
			Warps.setItemMeta(kWarps);
			
			ItemStack Loja = new ItemStack(Material.DIAMOND);
			ItemMeta kLoja = Loja.getItemMeta();
			kLoja.setDisplayName("§bLoja §7(Clique com direito)");
			kLoja.setLore(Arrays.asList("§7Clique para visualizar a nossa loja!"));
			Loja.setItemMeta(kLoja);
			
			ItemStack Ranks = new ItemStack(Material.PAPER);
			ItemMeta kRanks = Ranks.getItemMeta();
			kRanks.setDisplayName("§bMenu §7(Clique com direito)");
			kRanks.setLore(Arrays.asList("§7Clique neste item para obter as informações do servidor"));
			Ranks.setItemMeta(kRanks);
			
			ItemStack Rank = new ItemStack(Material.ANVIL);
			ItemMeta kRank = Rank.getItemMeta();
			kRank.setDisplayName("§bPerfil §7(Clique com direito)");
			kRank.setLore(Arrays.asList("§7Ajuste as suas configurações pessoais!"));
			Rank.setItemMeta(kRank);
			
			@SuppressWarnings("deprecation")
			ItemStack Heads = new ItemStack(Material.getMaterial(58), 1, (short)3);
			ItemMeta kHeads = Heads.getItemMeta();
			kHeads.setDisplayName("§bHeads §7(Clique com direito)");
			kHeads.setLore(Arrays.asList("§7Selecione uma cabeça!"));
			Heads.setItemMeta(kHeads);
			
			ItemStack Caixas = new ItemStack(Material.ENDER_CHEST);
			ItemMeta kCaixas = Caixas.getItemMeta();
			kCaixas.setDisplayName("§cKit Diario §7(Clique com direito)");
			kCaixas.setLore(Arrays.asList("§7A cada 24 horas, receba um kit aleatório!"));
			Caixas.setItemMeta(kCaixas);
			
			@SuppressWarnings("deprecation")
			ItemStack KitPadrao = new ItemStack(Material.getMaterial(351), 1, (short)14);
			ItemMeta kKitPadrao = KitPadrao.getItemMeta();
			kKitPadrao.setDisplayName(" §a§lKIT PADRAO");
			kKitPadrao.setLore(Arrays.asList("§7Selecione um kit para ser único!"));
			KitPadrao.setItemMeta(kKitPadrao);
			
			ItemStack Vidro = new ItemStack(Material.AIR, 1, (short)7);
			ItemMeta kVidro = Caixas.getItemMeta();
			kVidro.setDisplayName("");
			kVidro.setLore(Arrays.asList(""));
			Vidro.setItemMeta(kVidro);

			
			p.getInventory().clear();
			p.getInventory().setArmorContents(null);
			
			Proteção.setImortal(p, true);
			
			p.setHealth(20.0D);
			p.setMaxHealth(20.0D);
			
			sScoreAPI.scoreboard(p);
			
			CooldownAPI.tirarCooldown(p);
			WarpsAPI.Ir(p, "Spawn");
			
			p.getInventory().setHeldItemSlot(4);
			p.getInventory().setItem(1, Warps);
			p.getInventory().setItem(5, Ranks);
			p.getInventory().setItem(7, Loja);
			p.getInventory().setItem(3, Kits);
			p.getInventory().setItem(5, Ranks);
		}
	}
	public static int getAmount(Player p, Material m) {
	     int amount = 0;
	     for (ItemStack item : p.getInventory().getContents()) {
	      if ((item != null) && (item.getType() == m) && (item.getAmount() > 0)) {
	       amount += item.getAmount();
	      }
	     }
	     return amount;
	 }
	public static void mandarTitulo(Player player, String titulo) {
	    if (((CraftPlayer)player).getHandle().playerConnection.networkManager.getVersion() < 45) {
	    	return;
	    }
	    ((CraftPlayer)player).getHandle().playerConnection.sendPacket(new ProtocolInjector.PacketTitle(ProtocolInjector.PacketTitle.Action.TITLE, ChatSerializer.a("{\"text\": \"\"}").a(titulo)));
	}
	public static void mandarSubTitulo(Player player, String titulo) {
	    if (((CraftPlayer)player).getHandle().playerConnection.networkManager.getVersion() < 45) {
	    	return;
	    }
	    ((CraftPlayer)player).getHandle().playerConnection.sendPacket(new ProtocolInjector.PacketTitle(ProtocolInjector.PacketTitle.Action.SUBTITLE, ChatSerializer.a("{\"text\": \"\"}").a(titulo)));
	}
	public static void mandarActionBar(Player player, String titulo) {
		  CraftPlayer p = (CraftPlayer) player;
		  if (p.getHandle().playerConnection.networkManager.getVersion() != 47) {
		   return;
		  }
		
		  IChatBaseComponent cbc = ChatSerializer.a("{\"text\": \"" + titulo + "\"}");
		  PacketPlayOutChat ppoc = new PacketPlayOutChat(cbc, 2);
		  ((CraftPlayer) p).getHandle().playerConnection.sendPacket(ppoc);
		  ((CraftPlayer) p).getHandle().playerConnection.sendPacket(ppoc);
	} 
	public static void clear(Player player) {
	    if (((CraftPlayer)player).getHandle().playerConnection.networkManager.getVersion() < 45) {
	    	return;
	    }
	    ((CraftPlayer)player).getHandle().playerConnection.sendPacket(new ProtocolInjector.PacketTitle(ProtocolInjector.PacketTitle.Action.CLEAR));
	}
	public static void setHotbar(Player p) {
		ItemStack Kits = new ItemStack(Material.ENDER_CHEST);
		ItemMeta kKits = Kits.getItemMeta();
		kKits.setDisplayName("§bSeus Kits §7(Clique com direito)");
		kKits.setLore(Arrays.asList("§7Confira aqui os kits que você possui e afins!"));
		Kits.setItemMeta(kKits);
		
		ItemStack Warps = new ItemStack(Material.COMPASS);
		ItemMeta kWarps = Warps.getItemMeta();
		kWarps.setDisplayName("§bWarps §7(Clique com direito)");
		kWarps.setLore(Arrays.asList("§7Confira aqui as Warps disponíveis em nosso servidor!"));
		Warps.setItemMeta(kWarps);
		
		ItemStack Loja = new ItemStack(Material.DIAMOND);
		ItemMeta kLoja = Loja.getItemMeta();
		kLoja.setDisplayName("§bLoja §7(Clique com direito)");
		kLoja.setLore(Arrays.asList("§7Clique para visualizar a nossa loja!"));
		Loja.setItemMeta(kLoja);
		
		ItemStack Ranks = new ItemStack(Material.PAPER);
		ItemMeta kRanks = Ranks.getItemMeta();
		kRanks.setDisplayName("§bMenu §7(Clique com direito)");
		kRanks.setLore(Arrays.asList("§7Clique neste item para obter as informações do servidor"));
		Ranks.setItemMeta(kRanks);
		
		ItemStack Rank = new ItemStack(Material.ANVIL);
		ItemMeta kRank = Rank.getItemMeta();
		kRank.setDisplayName("§bPerfil §7(Clique com direito)");
		kRank.setLore(Arrays.asList("§7Ajuste as suas configurações pessoais!"));
		Rank.setItemMeta(kRank);
		
		@SuppressWarnings("deprecation")
		ItemStack Heads = new ItemStack(Material.getMaterial(58), 1, (short)3);
		ItemMeta kHeads = Heads.getItemMeta();
		kHeads.setDisplayName("§bHeads §7(Clique com direito)");
		kHeads.setLore(Arrays.asList("§7Selecione uma cabeça!"));
		Heads.setItemMeta(kHeads);
		
		ItemStack Caixas = new ItemStack(Material.ENDER_CHEST);
		ItemMeta kCaixas = Caixas.getItemMeta();
		kCaixas.setDisplayName("§cKit Diario §7(Clique com direito)");
		kCaixas.setLore(Arrays.asList("§7A cada 24 horas, receba um kit aleatório!"));
		Caixas.setItemMeta(kCaixas);
		
		@SuppressWarnings("deprecation")
		ItemStack KitPadrao = new ItemStack(Material.getMaterial(351), 1, (short)14);
		ItemMeta kKitPadrao = KitPadrao.getItemMeta();
		kKitPadrao.setDisplayName(" §a§lKIT PADRAO");
		kKitPadrao.setLore(Arrays.asList("§7Selecione um kit para ser único!"));
		KitPadrao.setItemMeta(kKitPadrao);
		
		ItemStack Vidro = new ItemStack(Material.AIR, 1, (short)7);
		ItemMeta kVidro = Caixas.getItemMeta();
		kVidro.setDisplayName("");
		kVidro.setLore(Arrays.asList(""));
		Vidro.setItemMeta(kVidro);

		
		p.getInventory().clear();
		p.getInventory().setArmorContents(null);
		
		Proteção.setImortal(p, true);
		
		p.setHealth(20.0D);
		p.setMaxHealth(20.0D);
		
		sScoreAPI.scoreboard(p);
		
		CooldownAPI.tirarCooldown(p);
		WarpsAPI.Ir(p, "Spawn");
		
		p.getInventory().setHeldItemSlot(4);
		p.getInventory().setItem(1, Warps);
		p.getInventory().setItem(5, Ranks);
		p.getInventory().setItem(7, Loja);
		p.getInventory().setItem(3, Kits);
		p.getInventory().setItem(5, Ranks);
	}
	@SuppressWarnings("deprecation")
	public static void sendWarn(String msg) {
		for(Player todos : Bukkit.getOnlinePlayers()) {
			if(cfGrupo.ChecarGrupo(todos, "Dono") || cfGrupo.ChecarGrupo(todos, "Gerente")) {
				for(Player k : Bukkit.getOnlinePlayers()) {
					if(cfGrupo.ChecarGrupo(k, "Dono") || cfGrupo.ChecarGrupo(k, "Gerente") || cfGrupo.ChecarGrupo(k, "Admin") || cfGrupo.ChecarGrupo(k, "Mod+") || cfGrupo.ChecarGrupo(k, "Mod") || cfGrupo.ChecarGrupo(k, "Trial") || cfGrupo.ChecarGrupo(k, "Youtuber+")) {
						if(ArraysAPI.Monitor.contains(todos)) {
							todos.sendMessage(msg);
							return;
						}
					}
				}
			}
		}
	}
}
