package me.thauandev.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thauandev.configuração.cfGrupo;
import me.thauandev.events.CorGrupo;
import me.thauandev.scoreboard.sScoreAPI;
import me.thauandev.v_1_8.TituloAPI;

public class GiveVipCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("giveVIP")) {
			if (!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Mod+")
					&& !cfGrupo.ChecarGrupo(p, "Gerente")) {
				p.sendMessage("§c§lSPEED§f§lMC §fVocê não possui permissão para executar este comando!");
				return true;
			}
			if (args.length == 0) {
				if ((sender instanceof Player)) {
					p.sendMessage("§c§lSPEED§f§lMC §fUtilize §c/givevip §6(nick) (vip)§f!");
					return true;
				}
			}
			if (args.length == 1) {
				if ((sender instanceof Player)) {
					p.sendMessage("§c§lSPEED§f§lMC §fUtilize §6§l/givevip §c(nick) (vip)§f!");
					return true;
				}
			}
			if (args.length == 2) {
				Player k = Bukkit.getPlayer(args[0]);
				String arg = args[1];
				if ((sender instanceof Player)) {
					if (k == null) {
						OfflinePlayer off = Bukkit.getOfflinePlayer(args[0]);
						if (arg.equalsIgnoreCase("Light")) {
							p.sendMessage("§c§lSPEED§f§lMC §7» §fVocê aplicou o VIP §a§lLIGHT §fpara o JOGADOR: §a§l"
									+ off.getName());

							cfGrupo.setarGrupo(off, "Light");
							cfGrupo.salvarconfiguracao();
							return true;
						}
						if (arg.equalsIgnoreCase("premium")) {
							p.sendMessage("§c§lSPEED§f§lMC §7» §fVocê aplicou o VIP §6§lPREMIUM §fpara o JOGADOR: §6§l"
									+ off.getName());

							cfGrupo.setarGrupo(off, "Mvp");
							cfGrupo.salvarconfiguracao();
							return true;
						}
						if (arg.equalsIgnoreCase("ultimate")) {
							p.sendMessage("§c§lSPEED§f§lMC §7» §fVocê aplicou o VIP §d§lULTIMATE §fpara o JOGADOR: §d§l"
									+ off.getName());

							cfGrupo.setarGrupo(off, "Pro");
							cfGrupo.salvarconfiguracao();
							return true;
						}
					}
					if (k != null) {
						if (arg.equalsIgnoreCase("light")) {
							p.sendMessage("§c§lSPEED§f§lMC §7» §fVocê aplicou o VIP §a§lLIGHT §fpara o JOGADOR: §a§l"
									+ k.getName());

							k.sendMessage("§eVocê recebeu o VIP Light Seu grupo foi alterado para LIGHT.");

							TituloAPI.MandarTitulo(k, "§a§lLIGHT");
							TituloAPI.MandarSubTitulo(k, "§7Você recebeu o VIP §a§lLIGHT");

							cfGrupo.setarGrupo(k, "Light");
							cfGrupo.salvarconfiguracao();

							if (cfGrupo.ChecarGrupo(k, "Dono")) {
								CorGrupo.setarTag(k, "§4§l");
							} else if (cfGrupo.ChecarGrupo(k, "Gerente")) {
								CorGrupo.setarTag(k, "§c§l");
							} else if (cfGrupo.ChecarGrupo(k, "Admin")) {
								CorGrupo.setarTag(k, "§c§l");
							} else if (cfGrupo.ChecarGrupo(k, "Mod+")) {
								CorGrupo.setarTag(k, "§5§l");
							} else if (cfGrupo.ChecarGrupo(k, "Mod")) {
								CorGrupo.setarTag(k, "§5§l");
							} else if (cfGrupo.ChecarGrupo(k, "Trial")) {
								CorGrupo.setarTag(k, "§5§l");
							} else if (cfGrupo.ChecarGrupo(k, "Youtuber+")) {
								CorGrupo.setarTag(k, "§3§l");
							} else if (cfGrupo.ChecarGrupo(k, "Builder")) {
								CorGrupo.setarTag(k, "§2§l");
							} else if (cfGrupo.ChecarGrupo(k, "Helper")) {
								CorGrupo.setarTag(k, "§9§l");
							} else if (cfGrupo.ChecarGrupo(k, "Youtuber")) {
								CorGrupo.setarTag(k, "§b§l");
							} else if (cfGrupo.ChecarGrupo(k, "S-Pro")) {
								CorGrupo.setarTag(k, "§e§l");
							} else if (cfGrupo.ChecarGrupo(k, "Pro")) {
								CorGrupo.setarTag(k, "§6§l");
							} else if (cfGrupo.ChecarGrupo(k, "Mvp")) {
								CorGrupo.setarTag(k, "§9§l");
							} else if (cfGrupo.ChecarGrupo(k, "Light")) {
								CorGrupo.setarTag(k, "§a§l");
							} else if (cfGrupo.ChecarGrupo(k, "Membro")) {
								CorGrupo.setarTag(k, "§7§l");
							}

							sScoreAPI.scoreboard(k);

							k.chat("/tag light");
							return true;
						}
						if (arg.equalsIgnoreCase("premium")) {
							p.sendMessage("§c§lSPEED§f§lMC §7» §fVocê aplicou o VIP §6§lPREMIUM §fpara o JOGADOR: §9§l"
									+ k.getName());

							k.sendMessage("§eVocê recebeu o VIP premium. Seu grupo foi alterado para premium.");

							TituloAPI.MandarTitulo(k, "§6§lPREMIUM");
							TituloAPI.MandarSubTitulo(k, "§7Você recebeu o VIP §6§lPREMIUM");

							cfGrupo.setarGrupo(k, "Mvp");
							cfGrupo.salvarconfiguracao();

							if (cfGrupo.ChecarGrupo(k, "Dono")) {
								CorGrupo.setarTag(k, "§4§l");
							} else if (cfGrupo.ChecarGrupo(k, "Gerente")) {
								CorGrupo.setarTag(k, "§c§l");
							} else if (cfGrupo.ChecarGrupo(k, "Admin")) {
								CorGrupo.setarTag(k, "§c§l");
							} else if (cfGrupo.ChecarGrupo(k, "Mod+")) {
								CorGrupo.setarTag(k, "§5§l");
							} else if (cfGrupo.ChecarGrupo(k, "Mod")) {
								CorGrupo.setarTag(k, "§5§l");
							} else if (cfGrupo.ChecarGrupo(k, "Trial")) {
								CorGrupo.setarTag(k, "§5§l");
							} else if (cfGrupo.ChecarGrupo(k, "Youtuber+")) {
								CorGrupo.setarTag(k, "§3§l");
							} else if (cfGrupo.ChecarGrupo(k, "Builder")) {
								CorGrupo.setarTag(k, "§2§l");
							} else if (cfGrupo.ChecarGrupo(k, "Helper")) {
								CorGrupo.setarTag(k, "§9§l");
							} else if (cfGrupo.ChecarGrupo(k, "Youtuber")) {
								CorGrupo.setarTag(k, "§b§l");
							} else if (cfGrupo.ChecarGrupo(k, "S-Pro")) {
								CorGrupo.setarTag(k, "§e§l");
							} else if (cfGrupo.ChecarGrupo(k, "Pro")) {
								CorGrupo.setarTag(k, "§6§l");
							} else if (cfGrupo.ChecarGrupo(k, "Mvp")) {
								CorGrupo.setarTag(k, "§9§l");
							} else if (cfGrupo.ChecarGrupo(k, "Light")) {
								CorGrupo.setarTag(k, "§a§l");
							} else if (cfGrupo.ChecarGrupo(k, "Membro")) {
								CorGrupo.setarTag(k, "§7§l");
							}

							sScoreAPI.scoreboard(k);

							k.chat("/tag premium");
							return true;
						}
						if (arg.equalsIgnoreCase("ultimate")) {
							p.sendMessage("§c§lSPEED§f§lMC §7» §fVocê aplicou o VIP §d§lULTIMATE §fpara o JOGADOR: §6§l"
									+ k.getName());

							k.sendMessage("§eVocê recebeu o VIP Ultimate. Seu grupo foi alterado para Ultimate.");

							TituloAPI.MandarTitulo(k, "§d§lULTIMATE");
							TituloAPI.MandarSubTitulo(k, "§7Você recebeu o VIP §d§lULTIMATE");

							cfGrupo.setarGrupo(k, "Pro");
							cfGrupo.salvarconfiguracao();

							if (cfGrupo.ChecarGrupo(k, "Dono")) {
								CorGrupo.setarTag(k, "§4§l");
							} else if (cfGrupo.ChecarGrupo(k, "Gerente")) {
								CorGrupo.setarTag(k, "§c§l");
							} else if (cfGrupo.ChecarGrupo(k, "Admin")) {
								CorGrupo.setarTag(k, "§c§l");
							} else if (cfGrupo.ChecarGrupo(k, "Mod+")) {
								CorGrupo.setarTag(k, "§5§l");
							} else if (cfGrupo.ChecarGrupo(k, "Mod")) {
								CorGrupo.setarTag(k, "§5§l");
							} else if (cfGrupo.ChecarGrupo(k, "Trial")) {
								CorGrupo.setarTag(k, "§5§l");
							} else if (cfGrupo.ChecarGrupo(k, "Youtuber+")) {
								CorGrupo.setarTag(k, "§3§l");
							} else if (cfGrupo.ChecarGrupo(k, "Builder")) {
								CorGrupo.setarTag(k, "§2§l");
							} else if (cfGrupo.ChecarGrupo(k, "Helper")) {
								CorGrupo.setarTag(k, "§9§l");
							} else if (cfGrupo.ChecarGrupo(k, "Youtuber")) {
								CorGrupo.setarTag(k, "§b§l");
							} else if (cfGrupo.ChecarGrupo(k, "S-Pro")) {
								CorGrupo.setarTag(k, "§e§l");
							} else if (cfGrupo.ChecarGrupo(k, "Pro")) {
								CorGrupo.setarTag(k, "§6§l");
							} else if (cfGrupo.ChecarGrupo(k, "Mvp")) {
								CorGrupo.setarTag(k, "§9§l");
							} else if (cfGrupo.ChecarGrupo(k, "Light")) {
								CorGrupo.setarTag(k, "§a§l");
							} else if (cfGrupo.ChecarGrupo(k, "Membro")) {
								CorGrupo.setarTag(k, "§7§l");
							}

							sScoreAPI.scoreboard(k);

							k.chat("/tag ultimate");
							return true;
						}
					}
				}
			}
		}
		return false;
	}
}
