package me.thauandev.commands;

import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thauandev.API.API;
import me.thauandev.API.KitAPI;
import me.thauandev.configuração.cfGrupo;
import me.thauandev.configuração.cfPermissão;
import me.thauandev.menus.KitsMenu;
import me.thauandev.scoreboard.sScoreAPI;

public class KitCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args) {

		Player p = (Player) Sender;
		if (Cmd.getName().equalsIgnoreCase("kit")) {

			if (API.getWarp(p) != "Spawn") {
				p.sendMessage("§c§lSPEED§f§lMC §fVocê só pode selecionar um §9§lKIT §fno §a§lSPAWN§f!");
				return true;
			}
			if (Args.length == 0) {
				KitsMenu.inventory(p);
				return true;
			}
			if (KitAPI.getKit(p) != "Nenhum") {
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 20L, 20L);
				p.sendMessage("§7Você selecionou o kit: §c" + KitAPI.getKit(p));
				p.sendMessage("§c§lSPEED§f§lMC §fAgora pule do lobby para receber os itens do kit");
				return true;
			}
			if (Args[0].equalsIgnoreCase("pvp")) {
				if ((cfGrupo.ChecarGrupo(p, "Membro") || (cfGrupo.ChecarGrupo(p, "Winner") || (cfGrupo.ChecarGrupo(p,
						"Light")
						|| (cfGrupo.ChecarGrupo(p, "S-Pro") || (cfGrupo.ChecarGrupo(p, "Builder") || (cfGrupo
								.ChecarGrupo(p, "Mvp")
								|| (cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo
										.ChecarGrupo(p, "Trial")
										|| (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo
												.ChecarGrupo(p, "Gerente")
												|| (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p,
														"Admin")
														|| (cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit
																|| GiveAllCommand.light || GiveAllCommand.mvp
																|| GiveAllCommand.pro)))))))))))))))) {
					KitAPI.setKitAntes(p, "PvP");
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 20L, 20L);
					p.sendMessage("§c§lSPEED§f§lMC §fVocê selecionou o kit: §c" + KitAPI.getKitAntes(p));
					p.sendMessage("§c§lSPEED§f§lMC §fAgora pule do lobby para receber os itens do kit");

					sScoreAPI.scoreboard(p);

					if (p.getGameMode() == GameMode.CREATIVE) {
						p.setGameMode(GameMode.SURVIVAL);
					}
				} else {
					p.sendMessage("§c§lSPEED§f§lMC §fVoce não possui este kit!");
					return true;
				}
			}
			if (Args[0].equalsIgnoreCase("archer")) {
				if ((cfGrupo.ChecarGrupo(p, "Membro") || (cfGrupo.ChecarGrupo(p, "Winner") || (cfGrupo.ChecarGrupo(p,
						"Light")
						|| (cfGrupo.ChecarGrupo(p, "S-Pro") || (cfGrupo.ChecarGrupo(p, "Builder") || (cfGrupo
								.ChecarGrupo(p, "Mvp")
								|| (cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo
										.ChecarGrupo(p, "Trial")
										|| (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo
												.ChecarGrupo(p, "Gerente")
												|| (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p,
														"Admin")
														|| (cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit
																|| GiveAllCommand.light || GiveAllCommand.mvp
																|| GiveAllCommand.pro)))))))))))))))) {
					KitAPI.setKitAntes(p, "Archer");
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 20L, 20L);
					p.sendMessage("§c§lSPEED§f§lMC §fVocê selecionou o kit: §c" + KitAPI.getKitAntes(p));
					p.sendMessage("§c§lSPEED§f§lMC §fAgora pule do lobby para receber os itens do kit");

					sScoreAPI.scoreboard(p);

					if (p.getGameMode() == GameMode.CREATIVE) {
						p.setGameMode(GameMode.SURVIVAL);
					}
				} else {
					p.sendMessage("§c§lSPEED§f§lMC §fVoce não possui este kit!");
					return true;
				}
			}
			if (Args[0].equalsIgnoreCase("kangaroo")) {
				if ((cfGrupo.ChecarGrupo(p, "Membro") || (cfGrupo.ChecarGrupo(p, "Winner") || (cfGrupo.ChecarGrupo(p,
						"Light")
						|| (cfGrupo.ChecarGrupo(p, "S-Pro") || (cfGrupo.ChecarGrupo(p, "Builder") || (cfGrupo
								.ChecarGrupo(p, "Mvp")
								|| (cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo
										.ChecarGrupo(p, "Trial")
										|| (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo
												.ChecarGrupo(p, "Gerente")
												|| (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p,
														"Admin")
														|| (cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit
																|| GiveAllCommand.light || GiveAllCommand.mvp
																|| GiveAllCommand.pro)))))))))))))))) {
					KitAPI.setKitAntes(p, "Kangaroo");
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 20L, 20L);
					p.sendMessage("§c§lSPEED§f§lMC §fVocê selecionou o kit: §c" + KitAPI.getKitAntes(p));
					p.sendMessage("§c§lSPEED§f§lMC §fAgora pule do lobby para receber os itens do kit");

					sScoreAPI.scoreboard(p);
					if (p.getGameMode() == GameMode.CREATIVE) {
						p.setGameMode(GameMode.SURVIVAL);
					}
				} else {
					p.sendMessage("§c§lSPEED§f§lMC §fVoce não possui este kit!");
					return true;
				}
			}
			if (Args[0].equalsIgnoreCase("fisherman")) {
				if ((cfGrupo.ChecarGrupo(p, "Membro") || (cfGrupo.ChecarGrupo(p, "Winner") || (cfGrupo.ChecarGrupo(p,
						"Light")
						|| (cfGrupo.ChecarGrupo(p, "S-Pro") || (cfGrupo.ChecarGrupo(p, "Builder") || (cfGrupo
								.ChecarGrupo(p, "Mvp")
								|| (cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo
										.ChecarGrupo(p, "Trial")
										|| (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo
												.ChecarGrupo(p, "Gerente")
												|| (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p,
														"Admin")
														|| (cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit
																|| GiveAllCommand.light || GiveAllCommand.mvp
																|| GiveAllCommand.pro)))))))))))))))) {
					KitAPI.setKitAntes(p, "Fisherman");
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 20L, 20L);
					p.sendMessage("§c§lSPEED§f§lMC §fVocê selecionou o kit: §c" + KitAPI.getKitAntes(p));
					p.sendMessage("§c§lSPEED§f§lMC §fAgora pule do lobby para receber os itens do kit");

					sScoreAPI.scoreboard(p);
					if (p.getGameMode() == GameMode.CREATIVE) {
						p.setGameMode(GameMode.SURVIVAL);
					}
				} else {
					p.sendMessage("§c§lSPEED§f§lMC §fVoce não possui este kit!");
					return true;
				}
			}
			if (Args[0].equalsIgnoreCase("specialist")) {
				if ((cfGrupo.ChecarGrupo(p, "Membro") || (cfGrupo.ChecarGrupo(p, "Winner") || (cfGrupo.ChecarGrupo(p,
						"Light")
						|| (cfGrupo.ChecarGrupo(p, "S-Pro") || (cfGrupo.ChecarGrupo(p, "Builder") || (cfGrupo
								.ChecarGrupo(p, "Mvp")
								|| (cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo
										.ChecarGrupo(p, "Trial")
										|| (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo
												.ChecarGrupo(p, "Gerente")
												|| (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p,
														"Admin")
														|| (cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit
																|| GiveAllCommand.light || GiveAllCommand.mvp
																|| GiveAllCommand.pro)))))))))))))))) {
					KitAPI.setKitAntes(p, "Specialist");
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 20L, 20L);
					p.sendMessage("§c§lSPEED§f§lMC §fVocê selecionou o kit: §c" + KitAPI.getKitAntes(p));
					p.sendMessage("§c§lSPEED§f§lMC §fAgora pule do lobby para receber os itens do kit");

					sScoreAPI.scoreboard(p);
					if (p.getGameMode() == GameMode.CREATIVE) {
						p.setGameMode(GameMode.SURVIVAL);
					}
				} else {
					p.sendMessage("§c§lSPEED§f§lMC §fVoce não possui este kit!");
					return true;
				}
			}
			if (Args[0].equalsIgnoreCase("Turtle")) {
				if ((cfGrupo.ChecarGrupo(p, "Membro") || (cfGrupo.ChecarGrupo(p, "Winner") || (cfGrupo.ChecarGrupo(p,
						"Light")
						|| (cfGrupo.ChecarGrupo(p, "S-Pro") || (cfGrupo.ChecarGrupo(p, "Builder") || (cfGrupo
								.ChecarGrupo(p, "Mvp")
								|| (cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo
										.ChecarGrupo(p, "Trial")
										|| (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo
												.ChecarGrupo(p, "Gerente")
												|| (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p,
														"Admin")
														|| (cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit
																|| GiveAllCommand.light || GiveAllCommand.mvp
																|| GiveAllCommand.pro)))))))))))))))) {
					KitAPI.setKitAntes(p, "Turtle");
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 20L, 20L);
					p.sendMessage("§c§lSPEED§f§lMC §fVocê selecionou o kit: §c" + KitAPI.getKitAntes(p));
					p.sendMessage("§c§lSPEED§f§lMC §fAgora pule do lobby para receber os itens do kit");

					sScoreAPI.scoreboard(p);
					if (p.getGameMode() == GameMode.CREATIVE) {
						p.setGameMode(GameMode.SURVIVAL);
					}
				} else {
					p.sendMessage("§c§lSPEED§f§lMC §fVoce não possui este kit!");
					return true;
				}
			}
			if (Args[0].equalsIgnoreCase("MiniGun")) {
				if ((cfGrupo.ChecarGrupo(p, "Membro") || (cfGrupo.ChecarGrupo(p, "Winner") || (cfGrupo.ChecarGrupo(p,
						"Light")
						|| (cfGrupo.ChecarGrupo(p, "S-Pro") || (cfGrupo.ChecarGrupo(p, "Builder") || (cfGrupo
								.ChecarGrupo(p, "Mvp")
								|| (cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo
										.ChecarGrupo(p, "Trial")
										|| (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo
												.ChecarGrupo(p, "Gerente")
												|| (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p,
														"Admin")
														|| (cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit
																|| GiveAllCommand.light || GiveAllCommand.mvp
																|| GiveAllCommand.pro)))))))))))))))) {
					KitAPI.setKitAntes(p, "MiniGun");
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 20L, 20L);
					p.sendMessage("§c§lSPEED§f§lMC §fVocê selecionou o kit: §c" + KitAPI.getKitAntes(p));
					p.sendMessage("§c§lSPEED§f§lMC §fAgora pule do lobby para receber os itens do kit");

					sScoreAPI.scoreboard(p);
					if (p.getGameMode() == GameMode.CREATIVE) {
						p.setGameMode(GameMode.SURVIVAL);
					}
				} else {
					p.sendMessage("§c§lSPEED§f§lMC §fVoce não possui este kit!");
					return true;
				}
			}
			if (Args[0].equalsIgnoreCase("cactus")) {
				if ((cfGrupo.ChecarGrupo(p, "Winner") || (cfGrupo.ChecarGrupo(p, "Light") || (cfGrupo.ChecarGrupo(p,
						"S-Pro")
						|| (cfGrupo.ChecarGrupo(p, "Builder") || (cfGrupo.ChecarGrupo(p, "Mvp") || (cfGrupo
								.ChecarGrupo(p, "Pro")
								|| (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Trial") || (cfGrupo
										.ChecarGrupo(p, "Mod")
										|| (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente")
												|| (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p,
														"Admin")
														|| (cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit
																|| GiveAllCommand.light || GiveAllCommand.mvp
																|| GiveAllCommand.pro))))))))))))))) {
					KitAPI.setKitAntes(p, "Cactus");
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 20L, 20L);
					p.sendMessage("§c§lSPEED§f§lMC §fVocê selecionou o kit: §c" + KitAPI.getKitAntes(p));
					p.sendMessage("§c§lSPEED§f§lMC §fAgora pule do lobby para receber os itens do kit");

					sScoreAPI.scoreboard(p);
					if (p.getGameMode() == GameMode.CREATIVE) {
						p.setGameMode(GameMode.SURVIVAL);
					}
				} else {
					p.sendMessage("§c§lSPEED§f§lMC §fVoce não possui este kit!");
					return true;
				}
			}
			if (Args[0].equalsIgnoreCase("monk")) {
				if ((cfGrupo.ChecarGrupo(p, "Membro") || (cfGrupo.ChecarGrupo(p, "Winner") || (cfGrupo.ChecarGrupo(p,
						"Light")
						|| (cfGrupo.ChecarGrupo(p, "S-Pro") || (cfGrupo.ChecarGrupo(p, "Builder") || (cfGrupo
								.ChecarGrupo(p, "Mvp")
								|| (cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo
										.ChecarGrupo(p, "Trial")
										|| (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo
												.ChecarGrupo(p, "Gerente")
												|| (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p,
														"Admin")
														|| (cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit
																|| GiveAllCommand.light || GiveAllCommand.mvp
																|| GiveAllCommand.pro)))))))))))))))) {
					KitAPI.setKitAntes(p, "Monk");
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 20L, 20L);
					p.sendMessage("§c§lSPEED§f§lMC §fVocê selecionou o kit: §c" + KitAPI.getKitAntes(p));
					p.sendMessage("§c§lSPEED§f§lMC §fAgora pule do lobby para receber os itens do kit");

					sScoreAPI.scoreboard(p);
					if (p.getGameMode() == GameMode.CREATIVE) {
						p.setGameMode(GameMode.SURVIVAL);
					}
				} else {
					p.sendMessage("§c§lSPEED§f§lMC §fVoce não possui este kit!");
					return true;
				}
			}
			if (Args[0].equalsIgnoreCase("ninja")) {
				if (((cfPermissão.getPermissao(p, "kit.ninja") || (cfGrupo.ChecarGrupo(p, "Winner")
						|| cfGrupo.ChecarGrupo(p, "Light")
						|| (cfGrupo.ChecarGrupo(p, "S-Pro") || (cfGrupo.ChecarGrupo(p, "Builder") || (cfGrupo
								.ChecarGrupo(p, "Mvp")
								|| (cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo
										.ChecarGrupo(p, "Trial")
										|| (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo
												.ChecarGrupo(p, "Gerente")
												|| (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p,
														"Admin")
														|| (cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit
																|| GiveAllCommand.light || GiveAllCommand.mvp
																|| GiveAllCommand.pro)))))))))))))))) {
					KitAPI.setKitAntes(p, "Ninja");
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 20L, 20L);
					p.sendMessage("§c§lSPEED§f§lMC §fVocê selecionou o kit: §c" + KitAPI.getKitAntes(p));
					p.sendMessage("§c§lSPEED§f§lMC §fAgora pule do lobby para receber os itens do kit");

					sScoreAPI.scoreboard(p);
					if (p.getGameMode() == GameMode.CREATIVE) {
						p.setGameMode(GameMode.SURVIVAL);
					}
				} else {
					p.sendMessage("§c§lSPEED§f§lMC §fVoce não possui este kit!");
					return true;
				}
			}
			if (Args[0].equalsIgnoreCase("antitower")) {
				if (((cfPermissão.getPermissao(p, "kit.antitower") || (cfGrupo.ChecarGrupo(p, "Winner")
						|| cfGrupo.ChecarGrupo(p, "Light")
						|| (cfGrupo.ChecarGrupo(p, "S-Pro") || (cfGrupo.ChecarGrupo(p, "Builder") || (cfGrupo
								.ChecarGrupo(p, "Mvp")
								|| (cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo
										.ChecarGrupo(p, "Trial")
										|| (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo
												.ChecarGrupo(p, "Gerente")
												|| (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p,
														"Admin")
														|| (cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit
																|| GiveAllCommand.light || GiveAllCommand.mvp
																|| GiveAllCommand.pro)))))))))))))))) {
					KitAPI.setKitAntes(p, "AntiTower");
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 20L, 20L);
					p.sendMessage("§c§lSPEED§f§lMC §fVocê selecionou o kit: §c" + KitAPI.getKitAntes(p));
					p.sendMessage("§c§lSPEED§f§lMC §fAgora pule do lobby para receber os itens do kit");

					sScoreAPI.scoreboard(p);
					if (p.getGameMode() == GameMode.CREATIVE) {
						p.setGameMode(GameMode.SURVIVAL);
					}
				} else {
					p.sendMessage("§c§lSPEED§f§lMC §fVoce não possui este kit!");
					return true;
				}
			}
			if (Args[0].equalsIgnoreCase("phantom")) {
				if (((cfPermissão.getPermissao(p, "kit.phantom") || (cfGrupo.ChecarGrupo(p, "Winner")
						|| cfGrupo.ChecarGrupo(p, "Light")
						|| (cfGrupo.ChecarGrupo(p, "S-Pro") || (cfGrupo.ChecarGrupo(p, "Builder") || (cfGrupo
								.ChecarGrupo(p, "Mvp")
								|| (cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo
										.ChecarGrupo(p, "Trial")
										|| (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo
												.ChecarGrupo(p, "Gerente")
												|| (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p,
														"Admin")
														|| (cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit
																|| GiveAllCommand.light || GiveAllCommand.mvp
																|| GiveAllCommand.pro)))))))))))))))) {
					KitAPI.setKitAntes(p, "Phantom");
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 20L, 20L);
					p.sendMessage("§c§lSPEED§f§lMC §fVocê selecionou o kit: §c" + KitAPI.getKitAntes(p));
					p.sendMessage("§c§lSPEED§f§lMC §fAgora pule do lobby para receber os itens do kit");

					sScoreAPI.scoreboard(p);
					if (p.getGameMode() == GameMode.CREATIVE) {
						p.setGameMode(GameMode.SURVIVAL);
					}
				} else {
					p.sendMessage("§c§lSPEED§f§lMC §fVoce não possui este kit!");
					return true;
				}
			}
			if (Args[0].equalsIgnoreCase("grappler")) {
				if (((cfPermissão.getPermissao(p, "kit.grappler") || cfGrupo.ChecarGrupo(p, "Light") || (cfGrupo
						.ChecarGrupo(p, "S-Pro")
						|| (cfGrupo.ChecarGrupo(p, "Builder") || (cfGrupo.ChecarGrupo(p, "Mvp") || (cfGrupo
								.ChecarGrupo(p, "Pro")
								|| (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Trial") || (cfGrupo
										.ChecarGrupo(p, "Mod")
										|| (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente")
												|| (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p,
														"Admin")
														|| (cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit
																|| GiveAllCommand.light || GiveAllCommand.mvp
																|| GiveAllCommand.pro))))))))))))))) {
					KitAPI.setKitAntes(p, "Grappler");
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 20L, 20L);
					p.sendMessage("§c§lSPEED§f§lMC §fVocê selecionou o kit: §c" + KitAPI.getKitAntes(p));
					p.sendMessage("§c§lSPEED§f§lMC §fAgora pule do lobby para receber os itens do kit");

					sScoreAPI.scoreboard(p);
					if (p.getGameMode() == GameMode.CREATIVE) {
						p.setGameMode(GameMode.SURVIVAL);
					}
				} else {
					p.sendMessage("§c§lSPEED§f§lMC §fVoce não possui este kit!");
					return true;
				}
			}
			if (Args[0].equalsIgnoreCase("anchor")) {
				if ((cfGrupo.ChecarGrupo(p, "Membro") || (cfGrupo.ChecarGrupo(p, "Light") || (cfGrupo.ChecarGrupo(p,
						"S-Pro")
						|| (cfGrupo.ChecarGrupo(p, "Builder") || (cfGrupo.ChecarGrupo(p, "Mvp") || (cfGrupo
								.ChecarGrupo(p, "Pro")
								|| (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Trial") || (cfGrupo
										.ChecarGrupo(p, "Mod")
										|| (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente")
												|| (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p,
														"Admin")
														|| (cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit
																|| GiveAllCommand.light || GiveAllCommand.mvp
																|| GiveAllCommand.pro))))))))))))))) {
					KitAPI.setKitAntes(p, "Anchor");
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 20L, 20L);
					p.sendMessage("§c§lSPEED§f§lMC §fVocê selecionou o kit: §c" + KitAPI.getKitAntes(p));
					p.sendMessage("§c§lSPEED§f§lMC §fAgora pule do lobby para receber os itens do kit");

					sScoreAPI.scoreboard(p);
					if (p.getGameMode() == GameMode.CREATIVE) {
						p.setGameMode(GameMode.SURVIVAL);
					}
				} else {
					p.sendMessage("§c§lSPEED§f§lMC §fVoce não possui este kit!");
					return true;
				}
			}
			if (Args[0].equalsIgnoreCase("viper")) {
				if (((cfPermissão.getPermissao(p, "kit.viper") || cfGrupo.ChecarGrupo(p, "Light") || (cfGrupo
						.ChecarGrupo(p, "S-Pro")
						|| (cfGrupo.ChecarGrupo(p, "Builder") || (cfGrupo.ChecarGrupo(p, "Mvp") || (cfGrupo
								.ChecarGrupo(p, "Pro")
								|| (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Trial") || (cfGrupo
										.ChecarGrupo(p, "Mod")
										|| (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente")
												|| (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p,
														"Admin")
														|| (cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit
																|| GiveAllCommand.light || GiveAllCommand.mvp
																|| GiveAllCommand.pro))))))))))))))) {
					KitAPI.setKitAntes(p, "Viper");
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 20L, 20L);
					p.sendMessage("§c§lSPEED§f§lMC §fVocê selecionou o kit: §c" + KitAPI.getKitAntes(p));
					p.sendMessage("§c§lSPEED§f§lMC §fAgora pule do lobby para receber os itens do kit");

					sScoreAPI.scoreboard(p);
					if (p.getGameMode() == GameMode.CREATIVE) {
						p.setGameMode(GameMode.SURVIVAL);
					}
				} else {
					p.sendMessage("§c§lSPEED§f§lMC §fVoce não possui este kit!");
					return true;
				}
			}
			if (Args[0].equalsIgnoreCase("snail")) {
				if (((cfPermissão.getPermissao(p, "kit.snail") || cfGrupo.ChecarGrupo(p, "Light") || (cfGrupo
						.ChecarGrupo(p, "S-Pro")
						|| (cfGrupo.ChecarGrupo(p, "Builder") || (cfGrupo.ChecarGrupo(p, "Mvp") || (cfGrupo
								.ChecarGrupo(p, "Pro")
								|| (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Trial") || (cfGrupo
										.ChecarGrupo(p, "Mod")
										|| (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente")
												|| (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p,
														"Admin")
														|| (cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit
																|| GiveAllCommand.light || GiveAllCommand.mvp
																|| GiveAllCommand.pro))))))))))))))) {
					KitAPI.setKitAntes(p, "Snail");
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 20L, 20L);
					p.sendMessage("§c§lSPEED§f§lMC §fVocê selecionou o kit: §c" + KitAPI.getKitAntes(p));
					p.sendMessage("§c§lSPEED§f§lMC §fAgora pule do lobby para receber os itens do kit");

					sScoreAPI.scoreboard(p);
					if (p.getGameMode() == GameMode.CREATIVE) {
						p.setGameMode(GameMode.SURVIVAL);
					}
				} else {
					p.sendMessage("§c§lSPEED§f§lMC §fVoce não possui este kit!");
					return true;
				}
			}
			if (Args[0].equalsIgnoreCase("hulk")) {
				if ((((cfPermissão.getPermissao(p, "kit.hulk") || cfGrupo.ChecarGrupo(p, "Mvp") || (cfGrupo
						.ChecarGrupo(p, "S-Pro")
						|| (cfGrupo.ChecarGrupo(p, "Builder") || (cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo
								.ChecarGrupo(p, "Youtuber")
								|| (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo
										.ChecarGrupo(p, "Gerente")
										|| (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p, "Admin")
												|| (cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit
														|| GiveAllCommand.mvp || GiveAllCommand.pro)))))))))))))) {
					KitAPI.setKitAntes(p, "Hulk");
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 20L, 20L);
					p.sendMessage("§c§lSPEED§f§lMC §fVocê selecionou o kit: §c" + KitAPI.getKitAntes(p));
					p.sendMessage("§c§lSPEED§f§lMC §fAgora pule do lobby para receber os itens do kit");

					sScoreAPI.scoreboard(p);
					if (p.getGameMode() == GameMode.CREATIVE) {
						p.setGameMode(GameMode.SURVIVAL);
					}
				} else {
					p.sendMessage("§c§lSPEED§f§lMC §fVoce não possui este kit!");
					return true;
				}
			}
			if (Args[0].equalsIgnoreCase("timelord")) {
				if ((((cfPermissão.getPermissao(p, "kit.timelord") || cfGrupo.ChecarGrupo(p, "Mvp") || (cfGrupo
						.ChecarGrupo(p, "S-Pro")
						|| (cfGrupo.ChecarGrupo(p, "Builder") || (cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo
								.ChecarGrupo(p, "Youtuber")
								|| (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo
										.ChecarGrupo(p, "Gerente")
										|| (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p, "Admin")
												|| (cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit
														|| GiveAllCommand.mvp || GiveAllCommand.pro)))))))))))))) {
					KitAPI.setKitAntes(p, "Timelord");
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 20L, 20L);
					p.sendMessage("§c§lSPEED§f§lMC §fVocê selecionou o kit: §c" + KitAPI.getKitAntes(p));
					p.sendMessage("§c§lSPEED§f§lMC §fAgora pule do lobby para receber os itens do kit");

					sScoreAPI.scoreboard(p);
					if (p.getGameMode() == GameMode.CREATIVE) {
						p.setGameMode(GameMode.SURVIVAL);
					}
				} else {
					p.sendMessage("§c§lSPEED§f§lMC §fVoce não possui este kit!");
					return true;
				}
			}
			if (Args[0].equalsIgnoreCase("thor")) {
				if ((((cfPermissão.getPermissao(p, "kit.thor") || cfGrupo.ChecarGrupo(p, "Mvp") || (cfGrupo
						.ChecarGrupo(p, "Builder")
						|| (cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo
								.ChecarGrupo(p, "Mod")
								|| (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente")
										|| (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p, "Admin")
												|| (cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit
														|| GiveAllCommand.mvp || GiveAllCommand.pro))))))))))))) {
					KitAPI.setKitAntes(p, "Thor");
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 20L, 20L);
					p.sendMessage("§c§lSPEED§f§lMC §fVocê selecionou o kit: §c" + KitAPI.getKitAntes(p));
					p.sendMessage("§c§lSPEED§f§lMC §fAgora pule do lobby para receber os itens do kit");

					sScoreAPI.scoreboard(p);
					if (p.getGameMode() == GameMode.CREATIVE) {
						p.setGameMode(GameMode.SURVIVAL);
					}
				} else {
					p.sendMessage("§c§lSPEED§f§lMC §fVoce não possui este kit!");
					return true;
				}
			}
			if (Args[0].equalsIgnoreCase("switcher")) {
				if ((((cfPermissão.getPermissao(p, "kit.switcher") || cfGrupo.ChecarGrupo(p, "Mvp") || (cfGrupo
						.ChecarGrupo(p, "Builder")
						|| (cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo
								.ChecarGrupo(p, "Mod")
								|| (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente")
										|| (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p, "Admin")
												|| (cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit
														|| GiveAllCommand.mvp || GiveAllCommand.pro))))))))))))) {
					KitAPI.setKitAntes(p, "Switcher");
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 20L, 20L);
					p.sendMessage("§c§lSPEED§f§lMC §fVocê selecionou o kit: §c" + KitAPI.getKitAntes(p));
					p.sendMessage("§c§lSPEED§f§lMC §fAgora pule do lobby para receber os itens do kit");

					sScoreAPI.scoreboard(p);
					if (p.getGameMode() == GameMode.CREATIVE) {
						p.setGameMode(GameMode.SURVIVAL);
					}
				} else {
					p.sendMessage("§c§lSPEED§f§lMC §fVoce não possui este kit!");
					return true;
				}
			}
			if (Args[0].equalsIgnoreCase("gladiator")) {
				if ((((cfPermissão.getPermissao(p, "kit.gladiator") || cfGrupo.ChecarGrupo(p, "Mvp") || (cfGrupo
						.ChecarGrupo(p, "Builder")
						|| (cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo
								.ChecarGrupo(p, "Mod")
								|| (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente")
										|| (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p, "Admin")
												|| (cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit
														|| GiveAllCommand.mvp || GiveAllCommand.pro))))))))))))) {
					KitAPI.setKitAntes(p, "Gladiator");
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 20L, 20L);
					p.sendMessage("§c§lSPEED§f§lMC §fVocê selecionou o kit: §c" + KitAPI.getKitAntes(p));
					p.sendMessage("§c§lSPEED§f§lMC §fAgora pule do lobby para receber os itens do kit");

					sScoreAPI.scoreboard(p);
					if (p.getGameMode() == GameMode.CREATIVE) {
						p.setGameMode(GameMode.SURVIVAL);
					}
				} else {
					p.sendMessage("§c§lSPEED§f§lMC §fVoce não possui este kit!");
					return true;
				}
			}
			if (Args[0].equalsIgnoreCase("stomper")) {
				if (((((cfPermissão.getPermissao(p, "kit.stomper") || cfGrupo.ChecarGrupo(p, "Pro")
						|| (cfGrupo.ChecarGrupo(p, "Builder") || (cfGrupo.ChecarGrupo(p, "Youtuber")
								|| (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+")
										|| (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+")
												|| (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono")
														|| GiveAllCommand.fullkit || GiveAllCommand.pro))))))))))))) {
					KitAPI.setKitAntes(p, "Stomper");
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 20L, 20L);
					p.sendMessage("§c§lSPEED§f§lMC §fVocê selecionou o kit: §c" + KitAPI.getKitAntes(p));
					p.sendMessage("§c§lSPEED§f§lMC §fAgora pule do lobby para receber os itens do kit");

					sScoreAPI.scoreboard(p);
					if (p.getGameMode() == GameMode.CREATIVE) {
						p.setGameMode(GameMode.SURVIVAL);
					}
				} else {
					p.sendMessage("§c§lSPEED§f§lMC §fVoce não possui este kit!");
					return true;
				}
			}
			if (Args[0].equalsIgnoreCase("magma")) {
				if (((((cfPermissão.getPermissao(p, "kit.magma") || cfGrupo.ChecarGrupo(p, "Pro")
						|| (cfGrupo.ChecarGrupo(p, "Builder") || (cfGrupo.ChecarGrupo(p, "Youtuber")
								|| (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+")
										|| (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+")
												|| (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono")
														|| GiveAllCommand.fullkit || GiveAllCommand.pro))))))))))))) {
					KitAPI.setKitAntes(p, "Magma");
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 20L, 20L);
					p.sendMessage("§c§lSPEED§f§lMC §fVocê selecionou o kit: §c" + KitAPI.getKitAntes(p));
					p.sendMessage("§c§lSPEED§f§lMC §fAgora pule do lobby para receber os itens do kit");

					sScoreAPI.scoreboard(p);
					if (p.getGameMode() == GameMode.CREATIVE) {
						p.setGameMode(GameMode.SURVIVAL);
					}
				} else {
					p.sendMessage("§c§lSPEED§f§lMC §fVoce não possui este kit!");
					return true;
				}
			}
			if (Args[0].equalsIgnoreCase("grandpa")) {
				if (((((cfPermissão.getPermissao(p, "kit.grandpa") || (cfGrupo.ChecarGrupo(p, "Builder")
						|| cfGrupo.ChecarGrupo(p, "Pro")
						|| (cfGrupo.ChecarGrupo(p, "Youtuber")
								|| (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+")
										|| (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+")
												|| (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono")
														|| GiveAllCommand.fullkit || GiveAllCommand.pro))))))))))))) {
					KitAPI.setKitAntes(p, "Grandpa");
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 20L, 20L);
					p.sendMessage("§c§lSPEED§f§lMC §fVocê selecionou o kit: §c" + KitAPI.getKitAntes(p));
					p.sendMessage("§c§lSPEED§f§lMC §fAgora pule do lobby para receber os itens do kit");

					sScoreAPI.scoreboard(p);
				} else {
					p.sendMessage("§c§lSPEED§f§lMC §fVoce não possui este kit!");
					return true;
				}
			}
			if (Args[0].equalsIgnoreCase("ajnin")) {
				if (((((cfPermissão.getPermissao(p, "kit.ajnin") || cfGrupo.ChecarGrupo(p, "Pro")
						|| (cfGrupo.ChecarGrupo(p, "Builder") || (cfGrupo.ChecarGrupo(p, "Youtuber")
								|| (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+")
										|| (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+")
												|| (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono")
														|| GiveAllCommand.fullkit || GiveAllCommand.pro))))))))))))) {
					KitAPI.setKitAntes(p, "Ajnin");
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 20L, 20L);
					p.sendMessage("§c§lSPEED§f§lMC §fVocê selecionou o kit: §c" + KitAPI.getKitAntes(p));
					p.sendMessage("§c§lSPEED§f§lMC §fAgora pule do lobby para receber os itens do kit");

					sScoreAPI.scoreboard(p);
					if (p.getGameMode() == GameMode.CREATIVE) {
						p.setGameMode(GameMode.SURVIVAL);
					}
				} else {
					p.sendMessage("§cVocê não possui esta permissão.");
					return true;
				}
			}
			if (Args[0].equalsIgnoreCase("firelauncher")) {
				if (((((cfPermissão.getPermissao(p, "kit.firelauncher") || cfGrupo.ChecarGrupo(p, "Pro")
						|| (cfGrupo.ChecarGrupo(p, "Builder") || (cfGrupo.ChecarGrupo(p, "Youtuber")
								|| (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+")
										|| (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+")
												|| (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono")
														|| GiveAllCommand.fullkit || GiveAllCommand.pro))))))))))))) {
					KitAPI.setKitAntes(p, "FireLauncher");
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 20L, 20L);
					p.sendMessage("§c§lSPEED§f§lMC §fVocê selecionou o kit: §c" + KitAPI.getKitAntes(p));
					p.sendMessage("§c§lSPEED§f§lMC §fAgora pule do lobby para receber os itens do kit");

					sScoreAPI.scoreboard(p);
					if (p.getGameMode() == GameMode.CREATIVE) {
						p.setGameMode(GameMode.SURVIVAL);
					}
				} else {
					p.sendMessage("§c§lSPEED§f§lMC §fVoce não possui este kit!");
					return true;
				}
			}
			if (Args[0].equalsIgnoreCase("strong")) {
				if (((((cfPermissão.getPermissao(p, "kit.strong") || cfGrupo.ChecarGrupo(p, "Pro")
						|| (cfGrupo.ChecarGrupo(p, "Builder") || (cfGrupo.ChecarGrupo(p, "Youtuber")
								|| (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+")
										|| (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+")
												|| (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono")
														|| GiveAllCommand.fullkit || GiveAllCommand.pro))))))))))))) {
					KitAPI.setKitAntes(p, "Strong");
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 20L, 20L);
					p.sendMessage("§c§lSPEED§f§lMC §fVocê selecionou o kit: §c" + KitAPI.getKitAntes(p));
					p.sendMessage("§c§lSPEED§f§lMC §fAgora pule do lobby para receber os itens do kit");

					sScoreAPI.scoreboard(p);
					if (p.getGameMode() == GameMode.CREATIVE) {
						p.setGameMode(GameMode.SURVIVAL);
					}
				} else {
					p.sendMessage("§c§lSPEED§f§lMC §fVoce não possui este kit!");
					return true;
				}
			}
			if (Args[0].equalsIgnoreCase("sumo")) {
				if (((((cfPermissão.getPermissao(p, "kit.sumo") || cfGrupo.ChecarGrupo(p, "Pro")
						|| (cfGrupo.ChecarGrupo(p, "Builder") || (cfGrupo.ChecarGrupo(p, "Youtuber")
								|| (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+")
										|| (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+")
												|| (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono")
														|| GiveAllCommand.fullkit || GiveAllCommand.pro))))))))))))) {
					KitAPI.setKitAntes(p, "Sumo");
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 20L, 20L);
					p.sendMessage("§c§lSPEED§f§lMC §fVocê selecionou o kit: §c" + KitAPI.getKitAntes(p));
					p.sendMessage("§c§lSPEED§f§lMC §fAgora pule do lobby para receber os itens do kit");

					sScoreAPI.scoreboard(p);
					if (p.getGameMode() == GameMode.CREATIVE) {
						p.setGameMode(GameMode.SURVIVAL);
					}
				} else {
					p.sendMessage("§c§lSPEED§f§lMC §fVoce não possui este kit!");
					return true;
				}
			}
		}
		return false;
	}

}
