package me.thauandev.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thauandev.configuração.cfConfig;
import me.thauandev.configuração.cfGrupo;
import me.thauandev.events.CorGrupo;
import me.thauandev.scoreboard.sScoreAPI;
import me.thauandev.v_1_8.TituloAPI;

public class GroupSetCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args) {

		if (Cmd.getName().equalsIgnoreCase("setgroup")) {
			if (Sender instanceof Player) {
				Player p = (Player) Sender;
				if (!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Admin")
						&& !cfGrupo.ChecarGrupo(p, "Gerente")) {
					p.sendMessage("§c§lSPEED§f§lMC §fVoce nao possui permissao para o setgroup!");
					return true;
				}
				if (Args.length == 0) {
					p.sendMessage("§c§lSPEED§f§lMC §fUtilize §c/setgroup (nick) (group)");

					return true;
				}
				Player target = Bukkit.getPlayerExact(Args[0]);

				if (target == null) {
					OfflinePlayer targetoff = Bukkit.getOfflinePlayer(Args[0]);

					if (Args.length == 1) {
						p.sendMessage("§c§lSPEED§f§lMC §fUtilize §c/setgroup (nick) (group)");
						return true;
					}
					if (Args[1].equalsIgnoreCase("membro")) {

						p.sendMessage("§3§lGROUPSET §7Voce Alterou o grupo de §c" + targetoff.getName()
								+ " §7para: §7§lMEMBRO");

						cfGrupo.setarGrupo(targetoff, "Membro");
						cfGrupo.salvarconfiguracao();
						cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".Silent", "OFF");
						cfConfig.salvarconfiguracao();
						return true;
					}
					if (Args[1].equalsIgnoreCase("winner")) {

						p.sendMessage("§3§lGROUPSET §7Voce Alterou o grupo de §c" + targetoff.getName()
								+ " §7para: §2§lWINNER");

						cfGrupo.setarGrupo(targetoff, "Winner");
						cfGrupo.salvarconfiguracao();
						cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".Silent", "OFF");
						cfConfig.salvarconfiguracao();
						return true;
					}
					if (Args[1].equalsIgnoreCase("light")) {

						p.sendMessage("§3§lGROUPSET §7Voce Alterou o grupo de §c" + targetoff.getName()
								+ " §7para: §a§lLIGHT");

						cfGrupo.setarGrupo(targetoff, "Light");
						cfGrupo.salvarconfiguracao();
						return true;
					}
					if (Args[1].equalsIgnoreCase("premium")) {

						p.sendMessage("§3§lGROUPSET §7Voce Alterou o grupo de §c" + targetoff.getName()
								+ " §7para: §6§lPREMIUM");

						cfGrupo.setarGrupo(targetoff, "Mvp");
						cfGrupo.salvarconfiguracao();
						return true;
					}
					if (Args[1].equalsIgnoreCase("platinum")) {

						p.sendMessage("§3§lGROUPSET §7Voce Alterou o grupo de §c" + targetoff.getName()
								+ " §7para: §e§lPLATINUM");

						cfGrupo.setarGrupo(targetoff, "S-Pro");
						cfGrupo.salvarconfiguracao();
						return true;
					}
					if (Args[1].equalsIgnoreCase("ultimate")) {

						p.sendMessage("§3§lGROUPSET §7Voce Alterou o grupo de §c" + targetoff.getName()
								+ " §7para: §d§lULTIMATE");

						cfGrupo.setarGrupo(targetoff, "Pro");
						cfGrupo.salvarconfiguracao();
						return true;
					}
					if (Args[1].equalsIgnoreCase("youtuber")) {

						p.sendMessage("§3§lGROUPSET §7Voce Alterou o grupo de §c" + targetoff.getName()
								+ " §7para: §b§lYOUTUBER");

						cfGrupo.setarGrupo(targetoff, "Youtuber");
						cfGrupo.salvarconfiguracao();
						return true;
					}
					if (Args[1].equalsIgnoreCase("youtuber+")) {

						p.sendMessage("§3§lGROUPSET §7Voce Alterou o grupo de §c" + targetoff.getName()
								+ " §7para: §3§lYOUTUBER+");

						cfGrupo.setarGrupo(targetoff, "Youtuber+");
						cfGrupo.salvarconfiguracao();
						return true;
					}
					if (Args[1].equalsIgnoreCase("ajudante")) {

						p.sendMessage("§3§lGROUPSET §7Voce Alterou o grupo de §c" + targetoff.getName()
								+ " §7para: §9§lAJUDANTE");

						cfGrupo.setarGrupo(targetoff, "Helper");
						cfGrupo.salvarconfiguracao();
						return true;
					}
					if (Args[1].equalsIgnoreCase("builder")) {

						p.sendMessage("§3§lGROUPSET §7Voce Alterou o grupo de §c" + targetoff.getName()
								+ " §7para: §2§lBUILDER");

						cfGrupo.setarGrupo(targetoff, "Builder");
						cfGrupo.salvarconfiguracao();
						return true;
					}
					if (Args[1].equalsIgnoreCase("trial")) {

						p.sendMessage("§3§lGROUPSET §7Voce Alterou o grupo de §c" + targetoff.getName()
								+ " §7para: §5§lTRIAL");

						cfGrupo.setarGrupo(targetoff, "Trial");
						cfGrupo.salvarconfiguracao();
						return true;
					}
					if (Args[1].equalsIgnoreCase("mod")) {

						p.sendMessage(
								"§3§lGROUPSET §7Voce Alterou o grupo de §c" + targetoff.getName() + " §7para: §5§lMOD");

						cfGrupo.setarGrupo(targetoff, "Mod");
						cfGrupo.salvarconfiguracao();
						return true;
					}
					if (Args[1].equalsIgnoreCase("modplus")) {

						p.sendMessage("§3§lGROUPSET §7Voce Alterou o grupo de §c" + targetoff.getName()
								+ " §7para: §5§lMOD+");

						cfGrupo.setarGrupo(targetoff, "Mod+");
						cfGrupo.salvarconfiguracao();
						return true;
					}
					if (Args[1].equalsIgnoreCase("admin")) {

						p.sendMessage("§3§lGROUPSET §7Voce Alterou o grupo de §c" + targetoff.getName()
								+ " §7para: §c§lADMIN");

						cfGrupo.setarGrupo(targetoff, "Admin");
						cfGrupo.salvarconfiguracao();
						return true;
					}
					if (Args[1].equalsIgnoreCase("gerente")) {

						p.sendMessage("§3§lGROUPSET §7Voce Alterou o grupo de §c" + targetoff.getName()
								+ " §7para: §c§lGERENTE");

						cfGrupo.setarGrupo(targetoff, "Gerente");
						cfGrupo.salvarconfiguracao();
						return true;
					}
					if (Args[1].equalsIgnoreCase("dono")) {

						p.sendMessage("§3§lGROUPSET §7Voce Alterou o grupo de §c" + targetoff.getName()
								+ " §7para: §4§lDONO");

						cfGrupo.setarGrupo(targetoff, "Dono");
						cfGrupo.salvarconfiguracao();
						return true;
					}
					p.sendMessage("§eEsse grupo não existe!");
				}
				if (Args.length == 1) {
					p.sendMessage("§3§lGROUPSET §fUtilize §3/groupset §3(JOGADOR) (GRUPO)");
					return true;
				}
				if (Args[1].equalsIgnoreCase("membro")) {

					p.sendMessage(
							"§3§lGROUPSET §7Voce Alterou o grupo de §c" + target.getName() + " §7para: §7§lMEMBRO");
					target.sendMessage("§3§lGROUP §fseu group foi §a§lALTERADO §fpara: Membro!");

					cfConfig.pegarconfig().set("configuração." + target.getUniqueId() + ".Silent", "OFF");
					cfConfig.salvarconfiguracao();

					TituloAPI.MandarTitulo(target, "§3§lGROUP");
					TituloAPI.MandarSubTitulo(target, "§7Você teve o seu group alterado para: §7§lMEMBRO");

					cfConfig.pegarconfig().set("configuração." + target.getUniqueId() + ".Silent", "OFF");
					cfConfig.salvarconfiguracao();

					cfGrupo.setarGrupo(target, "Membro");
					cfGrupo.salvarconfiguracao();

					if (cfGrupo.ChecarGrupo(target, "Dono")) {
						CorGrupo.setarTag(target, "§4§l");
					} else if (cfGrupo.ChecarGrupo(target, "Gerente")) {
						CorGrupo.setarTag(target, "§3§l");
					} else if (cfGrupo.ChecarGrupo(target, "Admin")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod+")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Trial")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber+")) {
						CorGrupo.setarTag(target, "§3§l");
					} else if (cfGrupo.ChecarGrupo(target, "Builder")) {
						CorGrupo.setarTag(target, "§2§l");
					} else if (cfGrupo.ChecarGrupo(target, "Helper")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber")) {
						CorGrupo.setarTag(target, "§b§l");
					} else if (cfGrupo.ChecarGrupo(target, "S-Pro")) {
						CorGrupo.setarTag(target, "§e§l");
					} else if (cfGrupo.ChecarGrupo(target, "Pro")) {
						CorGrupo.setarTag(target, "§6§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mvp")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Light")) {
						CorGrupo.setarTag(target, "§a§l");
					} else if (cfGrupo.ChecarGrupo(target, "Membro")) {
						CorGrupo.setarTag(target, "§7§l");
					}
					sScoreAPI.scoreboard(target);
					target.chat("/tag normal");
					return true;
				}
				if (Args[1].equalsIgnoreCase("winner")) {

					p.sendMessage(
							"§3§lGROUPSET §7Voce Alterou o grupo de §c" + target.getName() + " §7para: §2§lWINNER");
					target.sendMessage("§3§lGROUP §fseu group foi §a§lALTERADO §fpara: Winner!");

					cfConfig.pegarconfig().set("configuração." + target.getUniqueId() + ".Silent", "OFF");
					cfConfig.salvarconfiguracao();

					TituloAPI.MandarTitulo(target, "§3§lGROUP");
					TituloAPI.MandarSubTitulo(target, "§7Você teve o seu group alterado para: §7§lMEMBRO");

					cfConfig.pegarconfig().set("configuração." + target.getUniqueId() + ".Silent", "OFF");
					cfConfig.salvarconfiguracao();

					cfGrupo.setarGrupo(target, "Membro");
					cfGrupo.salvarconfiguracao();

					if (cfGrupo.ChecarGrupo(target, "Dono")) {
						CorGrupo.setarTag(target, "§4§l");
					} else if (cfGrupo.ChecarGrupo(target, "Gerente")) {
						CorGrupo.setarTag(target, "§3§l");
					} else if (cfGrupo.ChecarGrupo(target, "Admin")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod+")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Trial")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber+")) {
						CorGrupo.setarTag(target, "§3§l");
					} else if (cfGrupo.ChecarGrupo(target, "Builder")) {
						CorGrupo.setarTag(target, "§2§l");
					} else if (cfGrupo.ChecarGrupo(target, "Helper")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber")) {
						CorGrupo.setarTag(target, "§b§l");
					} else if (cfGrupo.ChecarGrupo(target, "S-Pro")) {
						CorGrupo.setarTag(target, "§e§l");
					} else if (cfGrupo.ChecarGrupo(target, "Pro")) {
						CorGrupo.setarTag(target, "§6§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mvp")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Light")) {
						CorGrupo.setarTag(target, "§a§l");
					} else if (cfGrupo.ChecarGrupo(target, "Membro")) {
						CorGrupo.setarTag(target, "§7§l");
					}
					sScoreAPI.scoreboard(target);
					target.chat("/tag winner");
					return true;
				}
				if (Args[1].equalsIgnoreCase("light")) {

					p.sendMessage(
							"§3§lGROUPSET §7Voce Alterou o grupo de §c" + target.getName() + " §7para: §a§lLIGHT");
					target.sendMessage("§3§lGROUP §fseu group foi §a§lALTERADO §fpara: Light!");

					TituloAPI.MandarTitulo(target, "§3§lGROUP");
					TituloAPI.MandarSubTitulo(target, "§7Você teve o seu group alterado para: §a§lLIGHT");

					cfGrupo.setarGrupo(target, "Light");
					cfGrupo.salvarconfiguracao();

					if (cfGrupo.ChecarGrupo(target, "Dono")) {
						CorGrupo.setarTag(target, "§4§l");
					} else if (cfGrupo.ChecarGrupo(target, "Gerente")) {
						CorGrupo.setarTag(target, "§3§l");
					} else if (cfGrupo.ChecarGrupo(target, "Admin")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod+")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Trial")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber+")) {
						CorGrupo.setarTag(target, "§3§l");
					} else if (cfGrupo.ChecarGrupo(target, "Builder")) {
						CorGrupo.setarTag(target, "§2§l");
					} else if (cfGrupo.ChecarGrupo(target, "Helper")) {
						CorGrupo.setarTag(target, "§e§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber")) {
						CorGrupo.setarTag(target, "§b§l");
					} else if (cfGrupo.ChecarGrupo(target, "S-Pro")) {
						CorGrupo.setarTag(target, "§e§l");
					} else if (cfGrupo.ChecarGrupo(target, "Pro")) {
						CorGrupo.setarTag(target, "§6§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mvp")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Light")) {
						CorGrupo.setarTag(target, "§a§l");
					} else if (cfGrupo.ChecarGrupo(target, "Membro")) {
						CorGrupo.setarTag(target, "§7§l");
					}
					sScoreAPI.scoreboard(target);
					target.chat("/tag light");
					return true;
				}
				if (Args[1].equalsIgnoreCase("premium")) {

					p.sendMessage(
							"§3§lGROUPSET §7Voce Alterou o grupo de §c" + target.getName() + " §7para: §6§lPREMIUM");
					target.sendMessage("§3§lGROUP §fseu group foi §a§lALTERADO §fpara: Mvp!");

					TituloAPI.MandarTitulo(target, "§3§lGROUP");
					TituloAPI.MandarSubTitulo(target, "§7Você teve o seu group alterado para: §6§lPREMIUM");

					cfGrupo.setarGrupo(target, "Mvp");
					cfGrupo.salvarconfiguracao();

					if (cfGrupo.ChecarGrupo(target, "Dono")) {
						CorGrupo.setarTag(target, "§4§l");
					} else if (cfGrupo.ChecarGrupo(target, "Gerente")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Admin")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod+")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Trial")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber+")) {
						CorGrupo.setarTag(target, "§3§l");
					} else if (cfGrupo.ChecarGrupo(target, "Builder")) {
						CorGrupo.setarTag(target, "§2§l");
					} else if (cfGrupo.ChecarGrupo(target, "Helper")) {
						CorGrupo.setarTag(target, "§e§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber")) {
						CorGrupo.setarTag(target, "§b§l");
					} else if (cfGrupo.ChecarGrupo(target, "S-Pro")) {
						CorGrupo.setarTag(target, "§e§l");
					} else if (cfGrupo.ChecarGrupo(target, "Pro")) {
						CorGrupo.setarTag(target, "§6§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mvp")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Light")) {
						CorGrupo.setarTag(target, "§a§l");
					} else if (cfGrupo.ChecarGrupo(target, "Membro")) {
						CorGrupo.setarTag(target, "§7§l");
					}
					sScoreAPI.scoreboard(target);
					target.chat("/tag premium");
					return true;
				}
				if (Args[1].equalsIgnoreCase("platinum")) {

					p.sendMessage("§3§lGROUPSET §7Voce Alterou o grupo de §c" + target.getName() + " §e§lPLATINUM");
					target.sendMessage("§3§lGROUP §fseu group foi §a§lALTERADO §fpara: SemiPro!");

					TituloAPI.MandarTitulo(target, "§3§lGROUP");
					TituloAPI.MandarSubTitulo(target, "§7Você teve o seu group alterado para: §e§lPLATINUM");

					cfGrupo.setarGrupo(target, "S-Pro");
					cfGrupo.salvarconfiguracao();

					if (cfGrupo.ChecarGrupo(target, "Dono")) {
						CorGrupo.setarTag(target, "§4§l");
					} else if (cfGrupo.ChecarGrupo(target, "Gerente")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Admin")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod+")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Trial")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber+")) {
						CorGrupo.setarTag(target, "§3§l");
					} else if (cfGrupo.ChecarGrupo(target, "Builder")) {
						CorGrupo.setarTag(target, "§2§l");
					} else if (cfGrupo.ChecarGrupo(target, "Helper")) {
						CorGrupo.setarTag(target, "§e§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber")) {
						CorGrupo.setarTag(target, "§b§l");
					} else if (cfGrupo.ChecarGrupo(target, "S-Pro")) {
						CorGrupo.setarTag(target, "§e§l");
					} else if (cfGrupo.ChecarGrupo(target, "Pro")) {
						CorGrupo.setarTag(target, "§6§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mvp")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Light")) {
						CorGrupo.setarTag(target, "§a§l");
					} else if (cfGrupo.ChecarGrupo(target, "Membro")) {
						CorGrupo.setarTag(target, "§7§l");
					}
					sScoreAPI.scoreboard(target);
					target.chat("/tag semipro");
					return true;
				}
				if (Args[1].equalsIgnoreCase("ultimate")) {

					p.sendMessage(
							"§3§lGROUPSET §7Voce Alterou o grupo de §c" + target.getName() + " §7para: §d§lULTIMATE");
					target.sendMessage("§3§lGROUP §fseu group foi §a§lALTERADO §fpara: Ultimate!");

					TituloAPI.MandarTitulo(target, "§3§lGROUP");
					TituloAPI.MandarSubTitulo(target, "§7Você teve o seu group alterado para: §d§lULTIMATE");

					cfGrupo.setarGrupo(target, "Pro");
					cfGrupo.salvarconfiguracao();

					if (cfGrupo.ChecarGrupo(target, "Dono")) {
						CorGrupo.setarTag(target, "§4§l");
					} else if (cfGrupo.ChecarGrupo(target, "Gerente")) {
						CorGrupo.setarTag(target, "§3§l");
					} else if (cfGrupo.ChecarGrupo(target, "Admin")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod+")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Trial")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber+")) {
						CorGrupo.setarTag(target, "§3§l");
					} else if (cfGrupo.ChecarGrupo(target, "Builder")) {
						CorGrupo.setarTag(target, "§2§l");
					} else if (cfGrupo.ChecarGrupo(target, "Helper")) {
						CorGrupo.setarTag(target, "§e§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber")) {
						CorGrupo.setarTag(target, "§b§l");
					} else if (cfGrupo.ChecarGrupo(target, "S-Pro")) {
						CorGrupo.setarTag(target, "§e§l");
					} else if (cfGrupo.ChecarGrupo(target, "Pro")) {
						CorGrupo.setarTag(target, "§6§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mvp")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Light")) {
						CorGrupo.setarTag(target, "§a§l");
					} else if (cfGrupo.ChecarGrupo(target, "Membro")) {
						CorGrupo.setarTag(target, "§7§l");
					}
					sScoreAPI.scoreboard(target);
					target.chat("/tag ultimate");
					return true;
				}
				if (Args[1].equalsIgnoreCase("youtuber")) {

					p.sendMessage(
							"§3§lGROUPSET §7Voce Alterou o grupo de §c" + target.getName() + " §7para: §b§lYOUTUBER");
					target.sendMessage("§3§lGROUP §fseu group foi §a§lALTERADO §fpara: Youtuber!");

					TituloAPI.MandarTitulo(target, "§3§lGROUP");
					TituloAPI.MandarSubTitulo(target, "§7Você teve o seu group alterado para: §b§lYOUTUBER");

					cfGrupo.setarGrupo(target, "Youtuber");
					cfGrupo.salvarconfiguracao();

					if (cfGrupo.ChecarGrupo(target, "Dono")) {
						CorGrupo.setarTag(target, "§4§l");
					} else if (cfGrupo.ChecarGrupo(target, "Gerente")) {
						CorGrupo.setarTag(target, "§3§l");
					} else if (cfGrupo.ChecarGrupo(target, "Admin")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod+")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Trial")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber+")) {
						CorGrupo.setarTag(target, "§3§l");
					} else if (cfGrupo.ChecarGrupo(target, "Builder")) {
						CorGrupo.setarTag(target, "§2§l");
					} else if (cfGrupo.ChecarGrupo(target, "Helper")) {
						CorGrupo.setarTag(target, "§e§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber")) {
						CorGrupo.setarTag(target, "§b§l");
					} else if (cfGrupo.ChecarGrupo(target, "S-Pro")) {
						CorGrupo.setarTag(target, "§e§l");
					} else if (cfGrupo.ChecarGrupo(target, "Pro")) {
						CorGrupo.setarTag(target, "§6§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mvp")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Light")) {
						CorGrupo.setarTag(target, "§a§l");
					} else if (cfGrupo.ChecarGrupo(target, "Membro")) {
						CorGrupo.setarTag(target, "§7§l");
					}
					sScoreAPI.scoreboard(target);
					target.chat("/tag youtuber");
					return true;
				}
				if (Args[1].equalsIgnoreCase("youtuber+")) {

					p.sendMessage(
							"§3§lGROUPSET §7Voce Alterou o grupo de §c" + target.getName() + " §7para: §3§lYOUTUBER+");
					target.sendMessage("§3§lGROUP §fseu group foi §a§lALTERADO §fpara: Youtuberplus");

					TituloAPI.MandarTitulo(target, "§a§lGROUP");
					TituloAPI.MandarSubTitulo(target, "§7Você teve o seu group alterado para: §3§lYOUTUBER+");

					cfGrupo.setarGrupo(target, "Youtuber+");
					cfGrupo.salvarconfiguracao();

					if (cfGrupo.ChecarGrupo(target, "Dono")) {
						CorGrupo.setarTag(target, "§4§l");
					} else if (cfGrupo.ChecarGrupo(target, "Gerente")) {
						CorGrupo.setarTag(target, "§3§l");
					} else if (cfGrupo.ChecarGrupo(target, "Admin")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod+")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Trial")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber+")) {
						CorGrupo.setarTag(target, "§3§l");
					} else if (cfGrupo.ChecarGrupo(target, "Builder")) {
						CorGrupo.setarTag(target, "§2§l");
					} else if (cfGrupo.ChecarGrupo(target, "Helper")) {
						CorGrupo.setarTag(target, "§e§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber")) {
						CorGrupo.setarTag(target, "§b§l");
					} else if (cfGrupo.ChecarGrupo(target, "S-Pro")) {
						CorGrupo.setarTag(target, "§e§l");
					} else if (cfGrupo.ChecarGrupo(target, "Pro")) {
						CorGrupo.setarTag(target, "§6§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mvp")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Light")) {
						CorGrupo.setarTag(target, "§a§l");
					} else if (cfGrupo.ChecarGrupo(target, "Membro")) {
						CorGrupo.setarTag(target, "§7§l");
					}
					sScoreAPI.scoreboard(target);
					target.chat("/tag youtuber+");
					return true;
				}
				if (Args[1].equalsIgnoreCase("builder")) {

					p.sendMessage(
							"§3§lGROUPSET §7Voce Alterou o grupo de §c" + target.getName() + " §7para: §e§lBUILDER");
					target.sendMessage("§3§lGROUP §fseu group foi §a§lALTERADO §fpara: Builder!");

					TituloAPI.MandarTitulo(target, "§a§lGROUP");
					TituloAPI.MandarSubTitulo(target, "§7Você teve o seu group alterado para: §e§lBUILDER");

					cfGrupo.setarGrupo(target, "Builder");
					cfGrupo.salvarconfiguracao();

					if (cfGrupo.ChecarGrupo(target, "Dono")) {
						CorGrupo.setarTag(target, "§4§l");
					} else if (cfGrupo.ChecarGrupo(target, "Gerente")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Admin")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod+")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Trial")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber+")) {
						CorGrupo.setarTag(target, "§3§l");
					} else if (cfGrupo.ChecarGrupo(target, "Builder")) {
						CorGrupo.setarTag(target, "§2§l");
					} else if (cfGrupo.ChecarGrupo(target, "Helper")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber")) {
						CorGrupo.setarTag(target, "§b§l");
					} else if (cfGrupo.ChecarGrupo(target, "S-Pro")) {
						CorGrupo.setarTag(target, "§e§l");
					} else if (cfGrupo.ChecarGrupo(target, "Pro")) {
						CorGrupo.setarTag(target, "§6§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mvp")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Light")) {
						CorGrupo.setarTag(target, "§a§l");
					} else if (cfGrupo.ChecarGrupo(target, "Membro")) {
						CorGrupo.setarTag(target, "§7§l");
					}
					sScoreAPI.scoreboard(target);
					target.chat("/tag builder");
					return true;
				}
				if (Args[1].equalsIgnoreCase("ajudante")) {

					p.sendMessage(
							"§3§lGROUPSET §7Voce Alterou o grupo de §c" + target.getName() + " §7para: §9§lAJUDANTE");
					target.sendMessage("§3§lGROUP §fseu group foi §a§lALTERADO §fpara: Ajudante!");

					TituloAPI.MandarTitulo(target, "§3§lGROUP");
					TituloAPI.MandarSubTitulo(target, "§7Você teve o seu group alterado para: §9§lAJUDANTE");

					cfGrupo.setarGrupo(target, "Helper");
					cfGrupo.salvarconfiguracao();

					if (cfGrupo.ChecarGrupo(target, "Dono")) {
						CorGrupo.setarTag(target, "§4§l");
					} else if (cfGrupo.ChecarGrupo(target, "Gerente")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Admin")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod+")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Trial")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber+")) {
						CorGrupo.setarTag(target, "§3§l");
					} else if (cfGrupo.ChecarGrupo(target, "Builder")) {
						CorGrupo.setarTag(target, "§2§l");
					} else if (cfGrupo.ChecarGrupo(target, "Helper")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber")) {
						CorGrupo.setarTag(target, "§b§l");
					} else if (cfGrupo.ChecarGrupo(target, "S-Pro")) {
						CorGrupo.setarTag(target, "§e§l");
					} else if (cfGrupo.ChecarGrupo(target, "Pro")) {
						CorGrupo.setarTag(target, "§6§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mvp")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Light")) {
						CorGrupo.setarTag(target, "§a§l");
					} else if (cfGrupo.ChecarGrupo(target, "Membro")) {
						CorGrupo.setarTag(target, "§7§l");
					}
					sScoreAPI.scoreboard(target);
					target.chat("/tag ajudante");
					return true;
				}
				if (Args[1].equalsIgnoreCase("trial")) {

					p.sendMessage(
							"§3§lGROUPSET §7Voce Alterou o grupo de §c" + target.getName() + " §7para: §5§lTRIAL");
					target.sendMessage("§3§lGROUP §fseu group foi §a§lALTERADO §fpara: Trial!");

					TituloAPI.MandarTitulo(target, "§3§lGROUP");
					TituloAPI.MandarSubTitulo(target, "§7Você teve o seu group alterado para: §5§lTRIAL");

					cfGrupo.setarGrupo(target, "Trial");
					cfGrupo.salvarconfiguracao();

					if (cfGrupo.ChecarGrupo(target, "Dono")) {
						CorGrupo.setarTag(target, "§4§l");
					} else if (cfGrupo.ChecarGrupo(target, "Gerente")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Admin")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod+")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Trial")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber+")) {
						CorGrupo.setarTag(target, "§3§l");
					} else if (cfGrupo.ChecarGrupo(target, "Helper")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Builder")) {
						CorGrupo.setarTag(target, "§2§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber")) {
						CorGrupo.setarTag(target, "§b§l");
					} else if (cfGrupo.ChecarGrupo(target, "S-Pro")) {
						CorGrupo.setarTag(target, "§e§l");
					} else if (cfGrupo.ChecarGrupo(target, "Pro")) {
						CorGrupo.setarTag(target, "§6§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mvp")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Light")) {
						CorGrupo.setarTag(target, "§a§l");
					} else if (cfGrupo.ChecarGrupo(target, "Membro")) {
						CorGrupo.setarTag(target, "§7§l");
					}
					sScoreAPI.scoreboard(target);
					target.chat("/tag trial");
					return true;
				}
				if (Args[1].equalsIgnoreCase("mod")) {

					p.sendMessage("§3§lGROUPSET §7Voce Alterou o grupo de §c" + target.getName() + " §7para: §5§lMOD");
					target.sendMessage("§3§lGROUP §fseu group foi §a§lALTERADO §fpara: Mod!");

					TituloAPI.MandarTitulo(target, "§3§lGROUP");
					TituloAPI.MandarSubTitulo(target, "§7Você teve o seu group alterado para: §5§lMOD");

					cfGrupo.setarGrupo(target, "Mod");
					cfGrupo.salvarconfiguracao();

					if (cfGrupo.ChecarGrupo(target, "Dono")) {
						CorGrupo.setarTag(target, "§4§l");
					} else if (cfGrupo.ChecarGrupo(target, "Gerente")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Admin")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod+")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Trial")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber+")) {
						CorGrupo.setarTag(target, "§3§l");
					} else if (cfGrupo.ChecarGrupo(target, "Builder")) {
						CorGrupo.setarTag(target, "§2§l");
					} else if (cfGrupo.ChecarGrupo(target, "Helper")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber")) {
						CorGrupo.setarTag(target, "§b§l");
					} else if (cfGrupo.ChecarGrupo(target, "S-Pro")) {
						CorGrupo.setarTag(target, "§e§l");
					} else if (cfGrupo.ChecarGrupo(target, "Pro")) {
						CorGrupo.setarTag(target, "§6§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mvp")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Light")) {
						CorGrupo.setarTag(target, "§a§l");
					} else if (cfGrupo.ChecarGrupo(target, "Membro")) {
						CorGrupo.setarTag(target, "§7§l");
					}
					sScoreAPI.scoreboard(target);
					target.chat("/tag mod");
					return true;
				}
				if (Args[1].equalsIgnoreCase("modplus")) {

					p.sendMessage("§3§lGROUPSET §7Voce Alterou o grupo de §c" + target.getName() + " §7para: §5§lMOD+");
					target.sendMessage("§3§lGROUP §fseu group foi §a§lALTERADO §fpara: Mod+!");

					TituloAPI.MandarTitulo(target, "§3§lGROUP");
					TituloAPI.MandarSubTitulo(target, "§7Você teve o seu group alterado para: §5§lMOD+");

					cfGrupo.setarGrupo(target, "Mod+");
					cfGrupo.salvarconfiguracao();

					if (cfGrupo.ChecarGrupo(target, "Dono")) {
						CorGrupo.setarTag(target, "§4§l");
					} else if (cfGrupo.ChecarGrupo(target, "Gerente")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Admin")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod+")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Trial")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber+")) {
						CorGrupo.setarTag(target, "§3§l");
					} else if (cfGrupo.ChecarGrupo(target, "Builder")) {
						CorGrupo.setarTag(target, "§2§l");
					} else if (cfGrupo.ChecarGrupo(target, "Helper")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber")) {
						CorGrupo.setarTag(target, "§b§l");
					} else if (cfGrupo.ChecarGrupo(target, "S-Pro")) {
						CorGrupo.setarTag(target, "§e§l");
					} else if (cfGrupo.ChecarGrupo(target, "Pro")) {
						CorGrupo.setarTag(target, "§6§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mvp")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Light")) {
						CorGrupo.setarTag(target, "§a§l");
					} else if (cfGrupo.ChecarGrupo(target, "Membro")) {
						CorGrupo.setarTag(target, "§7§l");
					}
					sScoreAPI.scoreboard(target);
					target.chat("/tag modplus");
					return true;
				}
				if (Args[1].equalsIgnoreCase("admin")) {

					p.sendMessage(
							"§3§lGROUPSET §7Voce Alterou o grupo de §c" + target.getName() + " §7para: §c§lADMIN");
					target.sendMessage("§3§lGROUP §fseu group foi §a§lALTERADO §fpara: Admin!");

					TituloAPI.MandarTitulo(target, "§3§lGROUP");
					TituloAPI.MandarSubTitulo(target, "§7Você teve o seu group alterado para: §c§lADMIN");

					cfGrupo.setarGrupo(target, "Admin");
					cfGrupo.salvarconfiguracao();

					if (cfGrupo.ChecarGrupo(target, "Dono")) {
						CorGrupo.setarTag(target, "§4§l");
					} else if (cfGrupo.ChecarGrupo(target, "Gerente")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Admin")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod+")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Trial")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber+")) {
						CorGrupo.setarTag(target, "§3§l");
					} else if (cfGrupo.ChecarGrupo(target, "Builder")) {
						CorGrupo.setarTag(target, "§2§l");
					} else if (cfGrupo.ChecarGrupo(target, "Helper")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber")) {
						CorGrupo.setarTag(target, "§b§l");
					} else if (cfGrupo.ChecarGrupo(target, "S-Pro")) {
						CorGrupo.setarTag(target, "§e§l");
					} else if (cfGrupo.ChecarGrupo(target, "Pro")) {
						CorGrupo.setarTag(target, "§6§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mvp")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Light")) {
						CorGrupo.setarTag(target, "§a§l");
					} else if (cfGrupo.ChecarGrupo(target, "Membro")) {
						CorGrupo.setarTag(target, "§7§l");
					}
					sScoreAPI.scoreboard(target);
					target.chat("/tag admin");
					return true;
				}
				if (Args[1].equalsIgnoreCase("gerente")) {

					p.sendMessage(
							"§3§lGROUPSET §7Voce Alterou o grupo de §c" + target.getName() + " §7para: §c§lGERENTE");
					target.sendMessage("§3§lGROUP §fseu group foi §a§lALTERADO §fpara: Gerente!");

					TituloAPI.MandarTitulo(target, "§3§lGROUP");
					TituloAPI.MandarSubTitulo(target, "§7Você teve o seu group alterado para: §c§lGERENTE");

					cfGrupo.setarGrupo(target, "Gerente");
					cfGrupo.salvarconfiguracao();

					if (cfGrupo.ChecarGrupo(target, "Dono")) {
						CorGrupo.setarTag(target, "§4§l");
					} else if (cfGrupo.ChecarGrupo(target, "Gerente")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Admin")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod+")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Trial")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber+")) {
						CorGrupo.setarTag(target, "§3§l");
					} else if (cfGrupo.ChecarGrupo(target, "Helper")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Builder")) {
						CorGrupo.setarTag(target, "§2§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber")) {
						CorGrupo.setarTag(target, "§b§l");
					} else if (cfGrupo.ChecarGrupo(target, "S-Pro")) {
						CorGrupo.setarTag(target, "§e§l");
					} else if (cfGrupo.ChecarGrupo(target, "Pro")) {
						CorGrupo.setarTag(target, "§6§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mvp")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Light")) {
						CorGrupo.setarTag(target, "§a§l");
					} else if (cfGrupo.ChecarGrupo(target, "Membro")) {
						CorGrupo.setarTag(target, "§7§l");
					}
					sScoreAPI.scoreboard(target);
					target.chat("/tag gerente");
					return true;
				}
				if (Args[1].equalsIgnoreCase("dono")) {

					p.sendMessage("§3§lGROUPSET §7Voce Alterou o grupo de §c" + target.getName() + " §7para: §4§lDONO");
					target.sendMessage("§3§lGROUP §fseu group foi §a§lALTERADO §fpara: Dono!");

					TituloAPI.MandarTitulo(target, "§3§lGROUP");
					TituloAPI.MandarSubTitulo(target, "§7Você teve o seu group alterado para: §4§lDONO");

					cfGrupo.setarGrupo(target, "Dono");
					cfGrupo.salvarconfiguracao();

					if (cfGrupo.ChecarGrupo(target, "Dono")) {
						CorGrupo.setarTag(target, "§4§l");
					} else if (cfGrupo.ChecarGrupo(target, "Gerente")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Admin")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod+")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Trial")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber+")) {
						CorGrupo.setarTag(target, "§3§l");
					} else if (cfGrupo.ChecarGrupo(target, "Builder")) {
						CorGrupo.setarTag(target, "§2§l");
					} else if (cfGrupo.ChecarGrupo(target, "Helper")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber")) {
						CorGrupo.setarTag(target, "§b§l");
					} else if (cfGrupo.ChecarGrupo(target, "S-Pro")) {
						CorGrupo.setarTag(target, "§e§l");
					} else if (cfGrupo.ChecarGrupo(target, "Pro")) {
						CorGrupo.setarTag(target, "§6§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mvp")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Light")) {
						CorGrupo.setarTag(target, "§a§l");
					} else if (cfGrupo.ChecarGrupo(target, "Membro")) {
						CorGrupo.setarTag(target, "§7§l");
					}
					sScoreAPI.scoreboard(target);
					target.chat("/tag dono");
					return true;
				}
				p.sendMessage("§cEsse grupo não existe!");
			}
		}
		if (!(Sender instanceof Player)) {
			if (Args.length == 0) {
				Sender.sendMessage("§c§lSPEED§f§lMC §fUtilize §c/setgroup (nick) (group)");
				return true;
			}
			Player target = Bukkit.getPlayerExact(Args[0]);
			if (target == null) {
				OfflinePlayer targetoff = Bukkit.getOfflinePlayer(Args[0]);
				if (Args.length == 1) {
					Sender.sendMessage("§c§lSPEED§f§lMC §fUtilize §c/setgroup (nick) (group)");
					return true;
				}
				if (Args[1].equalsIgnoreCase("membro")) {

					Sender.sendMessage(
							"§3§lGROUPSET §7Voce Alterou o grupo de §c" + targetoff.getName() + " §7para: §7§lMEMBRO");

					cfConfig.pegarconfig().set("configuração." + targetoff.getUniqueId() + ".Silent", "OFF");
					cfConfig.salvarconfiguracao();

					cfGrupo.setarGrupo(targetoff, "Membro");
					cfGrupo.salvarconfiguracao();
					return true;
				}
				if (Args[1].equalsIgnoreCase("winner")) {

					Sender.sendMessage(
							"§3§lGROUPSET §7Voce Alterou o grupo de §c" + targetoff.getName() + " §7para: §2§lWINNER");

					cfConfig.pegarconfig().set("configuração." + targetoff.getUniqueId() + ".Silent", "OFF");
					cfConfig.salvarconfiguracao();

					cfGrupo.setarGrupo(targetoff, "Winner");
					cfGrupo.salvarconfiguracao();
					return true;
				}
				if (Args[1].equalsIgnoreCase("light")) {

					Sender.sendMessage(
							"§3§lGROUPSET §7Voce Alterou o grupo de §c" + targetoff.getName() + " §7para: §a§lLIGHT");

					cfGrupo.setarGrupo(targetoff, "Light");
					cfGrupo.salvarconfiguracao();
					return true;
				}
				if (Args[1].equalsIgnoreCase("premium")) {

					Sender.sendMessage(
							"§3§lGROUPSET §7Voce Alterou o grupo de §c" + targetoff.getName() + " §7para: §6§lPREMIUM");

					cfGrupo.setarGrupo(targetoff, "Mvp");
					cfGrupo.salvarconfiguracao();
					return true;
				}
				if (Args[1].equalsIgnoreCase("platinum")) {

					Sender.sendMessage("§3§lGROUPSET §7Voce Alterou o grupo de §c" + targetoff.getName()
							+ " §7para: §e§lPLATINUM");

					cfGrupo.setarGrupo(targetoff, "S-Pro");
					cfGrupo.salvarconfiguracao();
					return true;
				}
				if (Args[1].equalsIgnoreCase("ultimate")) {

					Sender.sendMessage("§3§lGROUPSET §7Voce Alterou o grupo de §c" + targetoff.getName()
							+ " §7para: §d§lULTIMATE");

					cfGrupo.setarGrupo(targetoff, "Pro");
					cfGrupo.salvarconfiguracao();
					return true;
				}
				if (Args[1].equalsIgnoreCase("youtuber")) {

					Sender.sendMessage("§3§lGROUPSET §7Voce Alterou o grupo de §c" + targetoff.getName()
							+ " §7para: §b§lYOUTUBER");

					cfGrupo.setarGrupo(targetoff, "Youtuber");
					cfGrupo.salvarconfiguracao();
					return true;
				}
				if (Args[1].equalsIgnoreCase("youtuber+")) {

					Sender.sendMessage("§3§lGROUPSET §7Voce Alterou o grupo de §c" + targetoff.getName()
							+ " §7para: §3§lYOUTUBER+");

					cfGrupo.setarGrupo(targetoff, "Youtuber+");
					cfGrupo.salvarconfiguracao();
					return true;
				}
				if (Args[1].equalsIgnoreCase("builder")) {

					Sender.sendMessage(
							"§3§lGROUPSET §7Voce Alterou o grupo de §c" + targetoff.getName() + " §7para: §e§lBUILDER");

					cfGrupo.setarGrupo(targetoff, "Builder");
					cfGrupo.salvarconfiguracao();
					return true;
				}
				if (Args[1].equalsIgnoreCase("helper")) {

					Sender.sendMessage("§3§lGROUPSET §7Voce Alterou o grupo de §c" + targetoff.getName()
							+ " §7para: §9§lAJUDANTE");

					cfGrupo.setarGrupo(targetoff, "Helper");
					cfGrupo.salvarconfiguracao();
					return true;
				}
				if (Args[1].equalsIgnoreCase("trial")) {

					Sender.sendMessage(
							"§3§lGROUPSET §7Voce Alterou o grupo de §c" + targetoff.getName() + " §7para: §5§lTRIAL");

					cfGrupo.setarGrupo(targetoff, "Trial");
					cfGrupo.salvarconfiguracao();
					return true;
				}
				if (Args[1].equalsIgnoreCase("mod")) {

					Sender.sendMessage(
							"§3§lGROUPSET §7Voce Alterou o grupo de §c" + targetoff.getName() + " §7para: §5§lMOD");

					cfGrupo.setarGrupo(targetoff, "Mod");
					cfGrupo.salvarconfiguracao();
					return true;
				}
				if (Args[1].equalsIgnoreCase("modplus")) {

					Sender.sendMessage(
							"§3§lGROUPSET §7Voce Alterou o grupo de §c" + targetoff.getName() + " §7para: §5§lMOD+");

					cfGrupo.setarGrupo(targetoff, "Mod+");
					cfGrupo.salvarconfiguracao();
					return true;
				}
				if (Args[1].equalsIgnoreCase("admin")) {

					Sender.sendMessage(
							"§3§lGROUPSET §7Voce Alterou o grupo de §c" + targetoff.getName() + " §7para: §c§lADMIN");

					cfGrupo.setarGrupo(targetoff, "Admin");
					cfGrupo.salvarconfiguracao();
					return true;
				}
				if (Args[1].equalsIgnoreCase("gerente")) {

					Sender.sendMessage(
							"§3§lGROUPSET §7Voce Alterou o grupo de §c" + targetoff.getName() + " §7para: §c§lGERENTE");

					cfGrupo.setarGrupo(targetoff, "Gerente");
					cfGrupo.salvarconfiguracao();
					return true;
				}
				if (Args[1].equalsIgnoreCase("dono")) {

					Sender.sendMessage(
							"§3§lGROUPSET §7Voce Alterou o grupo de §c" + targetoff.getName() + " §7para: §4§lDONO");

					cfGrupo.setarGrupo(targetoff, "Dono");
					cfGrupo.salvarconfiguracao();
					return true;
				}
				Sender.sendMessage("§cEsse grupo não existe!");
			}

			if (target != null) {
				if (Args.length == 1) {
					Sender.sendMessage("§c§lSPEED§f§lMC §fUtilize §c/setgroup (nick) (group)");
					return true;
				}
				if (Args[1].equalsIgnoreCase("membro")) {

					Sender.sendMessage(
							"§3§lGROUPSET §7Voce Alterou o grupo de §c" + target.getName() + " §7para: §7§lMEMBRO");
					target.sendMessage("§3§lGROUP §fseu group foi §a§lALTERADO §fpara: §7§lMEMBRO");

					cfConfig.pegarconfig().set("configuração." + target.getUniqueId() + ".Silent", "OFF");
					cfConfig.salvarconfiguracao();

					TituloAPI.MandarTitulo(target, "§3§lGROUP");
					TituloAPI.MandarSubTitulo(target, "§7Você teve o seu group alterado para: §7§lMEMBRO");

					cfGrupo.setarGrupo(target, "Membro");
					cfGrupo.salvarconfiguracao();

					if (cfGrupo.ChecarGrupo(target, "Dono")) {
						CorGrupo.setarTag(target, "§4§l");
					} else if (cfGrupo.ChecarGrupo(target, "Gerente")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Admin")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod+")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber+")) {
						CorGrupo.setarTag(target, "§3§l");
					} else if (cfGrupo.ChecarGrupo(target, "Builder")) {
						CorGrupo.setarTag(target, "§2§l");
					} else if (cfGrupo.ChecarGrupo(target, "Helper")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber")) {
						CorGrupo.setarTag(target, "§b§l");
					} else if (cfGrupo.ChecarGrupo(target, "S-Pro")) {
						CorGrupo.setarTag(target, "§e§l");
					} else if (cfGrupo.ChecarGrupo(target, "Pro")) {
						CorGrupo.setarTag(target, "§6§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mvp")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Light")) {
						CorGrupo.setarTag(target, "§a§l");
					} else if (cfGrupo.ChecarGrupo(target, "Trial")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Membro")) {
						CorGrupo.setarTag(target, "§7§l");
					}
					sScoreAPI.scoreboard(target);
					target.chat("/tag normal");
					return true;
				}
				if (Args[1].equalsIgnoreCase("membro")) {

					Sender.sendMessage(
							"§3§lGROUPSET §7Voce Alterou o grupo de §c" + target.getName() + " §7para: §2§lWINNER");
					target.sendMessage("§3§lGROUP §fseu group foi §a§lALTERADO §fpara: §2§lWINNER");

					cfConfig.pegarconfig().set("configuração." + target.getUniqueId() + ".Silent", "OFF");
					cfConfig.salvarconfiguracao();

					TituloAPI.MandarTitulo(target, "§3§lGROUP");
					TituloAPI.MandarSubTitulo(target, "§7Você teve o seu group alterado para: §2§lWINNER");

					cfGrupo.setarGrupo(target, "Membro");
					cfGrupo.salvarconfiguracao();

					if (cfGrupo.ChecarGrupo(target, "Dono")) {
						CorGrupo.setarTag(target, "§4§l");
					} else if (cfGrupo.ChecarGrupo(target, "Gerente")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Admin")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod+")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber+")) {
						CorGrupo.setarTag(target, "§3§l");
					} else if (cfGrupo.ChecarGrupo(target, "Builder")) {
						CorGrupo.setarTag(target, "§2§l");
					} else if (cfGrupo.ChecarGrupo(target, "Helper")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber")) {
						CorGrupo.setarTag(target, "§b§l");
					} else if (cfGrupo.ChecarGrupo(target, "S-Pro")) {
						CorGrupo.setarTag(target, "§e§l");
					} else if (cfGrupo.ChecarGrupo(target, "Pro")) {
						CorGrupo.setarTag(target, "§6§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mvp")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Light")) {
						CorGrupo.setarTag(target, "§a§l");
					} else if (cfGrupo.ChecarGrupo(target, "Trial")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Membro")) {
						CorGrupo.setarTag(target, "§7§l");
					}
					sScoreAPI.scoreboard(target);
					target.chat("/tag winner");
					return true;
				}
				if (Args[1].equalsIgnoreCase("light")) {

					Sender.sendMessage(
							"§3§lGROUPSET §7Voce Alterou o grupo de §c" + target.getName() + " §7para: §a§lLIGHT");
					target.sendMessage("§3§lGROUP §fseu group foi §a§lALTERADO §fpara: §a§lLIGHT");

					TituloAPI.MandarTitulo(target, "§3§lGROUP");
					TituloAPI.MandarSubTitulo(target, "§7Você teve o seu group alterado para: §a§lLIGHT");

					cfGrupo.setarGrupo(target, "Light");
					cfGrupo.salvarconfiguracao();

					if (cfGrupo.ChecarGrupo(target, "Dono")) {
						CorGrupo.setarTag(target, "§4§l");
					} else if (cfGrupo.ChecarGrupo(target, "Gerente")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Admin")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod+")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber+")) {
						CorGrupo.setarTag(target, "§3§l");
					} else if (cfGrupo.ChecarGrupo(target, "Builder")) {
						CorGrupo.setarTag(target, "§2§l");
					} else if (cfGrupo.ChecarGrupo(target, "Helper")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber")) {
						CorGrupo.setarTag(target, "§b§l");
					} else if (cfGrupo.ChecarGrupo(target, "S-Pro")) {
						CorGrupo.setarTag(target, "§e§l");
					} else if (cfGrupo.ChecarGrupo(target, "Pro")) {
						CorGrupo.setarTag(target, "§6§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mvp")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Light")) {
						CorGrupo.setarTag(target, "§a§l");
					} else if (cfGrupo.ChecarGrupo(target, "Trial")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Membro")) {
						CorGrupo.setarTag(target, "§7§l");
					}
					sScoreAPI.scoreboard(target);
					target.chat("/tag light");
					return true;
				}
				if (Args[1].equalsIgnoreCase("premium")) {

					Sender.sendMessage(
							"§3§lGROUPSET §7Voce Alterou o grupo de §c" + target.getName() + " §7para: §6§lPREMIUM");
					target.sendMessage("§3§lGROUP §fseu group foi §a§lALTERADO §fpara: §6§lPREMIUM");

					TituloAPI.MandarTitulo(target, "§3§lGROUP");
					TituloAPI.MandarSubTitulo(target, "§7Você teve o seu group alterado para: §6§lPREMIUM");

					cfGrupo.setarGrupo(target, "Mvp");
					cfGrupo.salvarconfiguracao();

					if (cfGrupo.ChecarGrupo(target, "Dono")) {
						CorGrupo.setarTag(target, "§4§l");
					} else if (cfGrupo.ChecarGrupo(target, "Gerente")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Admin")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod+")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber+")) {
						CorGrupo.setarTag(target, "§3§l");
					} else if (cfGrupo.ChecarGrupo(target, "Builder")) {
						CorGrupo.setarTag(target, "§2§l");
					} else if (cfGrupo.ChecarGrupo(target, "Helper")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber")) {
						CorGrupo.setarTag(target, "§b§l");
					} else if (cfGrupo.ChecarGrupo(target, "S-Pro")) {
						CorGrupo.setarTag(target, "§e§l");
					} else if (cfGrupo.ChecarGrupo(target, "Pro")) {
						CorGrupo.setarTag(target, "§6§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mvp")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Light")) {
						CorGrupo.setarTag(target, "§a§l");
					} else if (cfGrupo.ChecarGrupo(target, "Trial")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Membro")) {
						CorGrupo.setarTag(target, "§7§l");
					}
					sScoreAPI.scoreboard(target);
					target.chat("/tag premium");
					return true;
				}
				if (Args[1].equalsIgnoreCase("platinum")) {

					Sender.sendMessage(
							"§3§lGROUPSET §7Voce Alterou o grupo de §c" + target.getName() + " §7para: §e§lPLATINUM");
					target.sendMessage("§3§lGROUP §fseu group foi §a§lALTERADO §fpara: §e§lPLATINUM");

					TituloAPI.MandarTitulo(target, "§3§lGROUP");
					TituloAPI.MandarSubTitulo(target, "§7Você teve o seu group alterado para: §e§lPLATINUM");

					cfGrupo.setarGrupo(target, "S-Pro");
					cfGrupo.salvarconfiguracao();

					if (cfGrupo.ChecarGrupo(target, "Dono")) {
						CorGrupo.setarTag(target, "§4§l");
					} else if (cfGrupo.ChecarGrupo(target, "Gerente")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Admin")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod+")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber+")) {
						CorGrupo.setarTag(target, "§3§l");
					} else if (cfGrupo.ChecarGrupo(target, "Builder")) {
						CorGrupo.setarTag(target, "§2§l");
					} else if (cfGrupo.ChecarGrupo(target, "Helper")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber")) {
						CorGrupo.setarTag(target, "§b§l");
					} else if (cfGrupo.ChecarGrupo(target, "S-Pro")) {
						CorGrupo.setarTag(target, "§e§l");
					} else if (cfGrupo.ChecarGrupo(target, "Pro")) {
						CorGrupo.setarTag(target, "§6§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mvp")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Light")) {
						CorGrupo.setarTag(target, "§a§l");
					} else if (cfGrupo.ChecarGrupo(target, "Trial")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Membro")) {
						CorGrupo.setarTag(target, "§7§l");
					}
					sScoreAPI.scoreboard(target);
					target.chat("/tag platinum");
					return true;
				}
				if (Args[1].equalsIgnoreCase("ultimate")) {

					Sender.sendMessage(
							"§3§lGROUPSET §7Voce Alterou o grupo de §c" + target.getName() + " §7para: §d§lULTIMATE");
					target.sendMessage("§3§lGROUP §fseu group foi §a§lALTERADO §fpara: §d§lULTIMATE");

					TituloAPI.MandarTitulo(target, "§3§lGROUP");
					TituloAPI.MandarSubTitulo(target, "§7Você teve o seu group alterado para: §d§lULTIMATE");

					cfGrupo.setarGrupo(target, "Pro");
					cfGrupo.salvarconfiguracao();

					if (cfGrupo.ChecarGrupo(target, "Dono")) {
						CorGrupo.setarTag(target, "§4§l");
					} else if (cfGrupo.ChecarGrupo(target, "Gerente")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Admin")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod+")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber+")) {
						CorGrupo.setarTag(target, "§3§l");
					} else if (cfGrupo.ChecarGrupo(target, "Builder")) {
						CorGrupo.setarTag(target, "§2§l");
					} else if (cfGrupo.ChecarGrupo(target, "Helper")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber")) {
						CorGrupo.setarTag(target, "§b§l");
					} else if (cfGrupo.ChecarGrupo(target, "S-Pro")) {
						CorGrupo.setarTag(target, "§e§l");
					} else if (cfGrupo.ChecarGrupo(target, "Pro")) {
						CorGrupo.setarTag(target, "§6§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mvp")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Light")) {
						CorGrupo.setarTag(target, "§a§l");
					} else if (cfGrupo.ChecarGrupo(target, "Trial")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Membro")) {
						CorGrupo.setarTag(target, "§7§l");
					}
					sScoreAPI.scoreboard(target);
					target.chat("/tag ultimate");
					return true;
				}
				if (Args[1].equalsIgnoreCase("youtuber")) {

					Sender.sendMessage(
							"§3§lGROUPSET §7Voce Alterou o grupo de §c" + target.getName() + " §7para: §b§lYOUTUBER");
					target.sendMessage("§3§lGROUP §fseu group foi §a§lALTERADO §fpara: §b§lYOUTUBER");

					TituloAPI.MandarTitulo(target, "§3§lGROUP");
					TituloAPI.MandarSubTitulo(target, "§7Você teve o seu group foi alterado para: §b§lYOUTUBER");

					cfGrupo.setarGrupo(target, "Youtuber");
					cfGrupo.salvarconfiguracao();

					if (cfGrupo.ChecarGrupo(target, "Dono")) {
						CorGrupo.setarTag(target, "§4§l");
					} else if (cfGrupo.ChecarGrupo(target, "Gerente")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Admin")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod+")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber+")) {
						CorGrupo.setarTag(target, "§3§l");
					} else if (cfGrupo.ChecarGrupo(target, "Builder")) {
						CorGrupo.setarTag(target, "§2§l");
					} else if (cfGrupo.ChecarGrupo(target, "Helper")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber")) {
						CorGrupo.setarTag(target, "§b§l");
					} else if (cfGrupo.ChecarGrupo(target, "S-Pro")) {
						CorGrupo.setarTag(target, "§e§l");
					} else if (cfGrupo.ChecarGrupo(target, "Pro")) {
						CorGrupo.setarTag(target, "§6§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mvp")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Light")) {
						CorGrupo.setarTag(target, "§a§l");
					} else if (cfGrupo.ChecarGrupo(target, "Trial")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Membro")) {
						CorGrupo.setarTag(target, "§7§l");
					}
					sScoreAPI.scoreboard(target);
					target.chat("/tag youtuber");
					return true;
				}
				if (Args[1].equalsIgnoreCase("youtuber+")) {

					Sender.sendMessage(
							"§3§lGROUPSET §7Voce Alterou o grupo de §c" + target.getName() + " §7para: §3§lYOUTUBER+");
					target.sendMessage("§3§lGROUP §fseu group foi §a§lALTERADO §fpara: §3§lYOUTUBER+");

					TituloAPI.MandarTitulo(target, "§3§lGROUP");
					TituloAPI.MandarSubTitulo(target, "§7Você teve o seu group alterado para: §3§lYOUTUBER+");

					cfGrupo.setarGrupo(target, "Youtuber+");
					cfGrupo.salvarconfiguracao();

					if (cfGrupo.ChecarGrupo(target, "Dono")) {
						CorGrupo.setarTag(target, "§4§l");
					} else if (cfGrupo.ChecarGrupo(target, "Gerente")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Admin")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod+")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber+")) {
						CorGrupo.setarTag(target, "§3§l");
					} else if (cfGrupo.ChecarGrupo(target, "Builder")) {
						CorGrupo.setarTag(target, "§2§l");
					} else if (cfGrupo.ChecarGrupo(target, "Helper")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber")) {
						CorGrupo.setarTag(target, "§b§l");
					} else if (cfGrupo.ChecarGrupo(target, "S-Pro")) {
						CorGrupo.setarTag(target, "§e§l");
					} else if (cfGrupo.ChecarGrupo(target, "Pro")) {
						CorGrupo.setarTag(target, "§6§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mvp")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Light")) {
						CorGrupo.setarTag(target, "§a§l");
					} else if (cfGrupo.ChecarGrupo(target, "Trial")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Membro")) {
						CorGrupo.setarTag(target, "§7§l");
					}
					sScoreAPI.scoreboard(target);
					target.chat("/tag youtuber+");
					return true;
				}
				if (Args[1].equalsIgnoreCase("builder")) {

					Sender.sendMessage(
							"§3§lGROUPSET §7Voce Alterou o grupo de §c" + target.getName() + " §7para: §e§lBUILDER");
					target.sendMessage("§3§lGROUP §fseu group foi §a§lALTERADO §fpara: §e§lBUILDER");

					TituloAPI.MandarTitulo(target, "§3§lGROUP");
					TituloAPI.MandarSubTitulo(target, "§7Você teve o seu group alterado para: §e§lBUILDER");

					cfGrupo.setarGrupo(target, "Builder");
					cfGrupo.salvarconfiguracao();

					if (cfGrupo.ChecarGrupo(target, "Dono")) {
						CorGrupo.setarTag(target, "§4§l");
					} else if (cfGrupo.ChecarGrupo(target, "Gerente")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Admin")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod+")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber+")) {
						CorGrupo.setarTag(target, "§3§l");
					} else if (cfGrupo.ChecarGrupo(target, "Builder")) {
						CorGrupo.setarTag(target, "§2§l");
					} else if (cfGrupo.ChecarGrupo(target, "Helper")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber")) {
						CorGrupo.setarTag(target, "§b§l");
					} else if (cfGrupo.ChecarGrupo(target, "S-Pro")) {
						CorGrupo.setarTag(target, "§e§l");
					} else if (cfGrupo.ChecarGrupo(target, "Pro")) {
						CorGrupo.setarTag(target, "§6§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mvp")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Light")) {
						CorGrupo.setarTag(target, "§a§l");
					} else if (cfGrupo.ChecarGrupo(target, "Trial")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Membro")) {
						CorGrupo.setarTag(target, "§7§l");
					}
					sScoreAPI.scoreboard(target);
					target.chat("/tag builder");
					return true;
				}
				if (Args[1].equalsIgnoreCase("ajudante")) {

					Sender.sendMessage(
							"§3§lGROUPSET §7Voce Alterou o grupo de §c" + target.getName() + " §7para: §9§lAJUDANTE");
					target.sendMessage("§3§lGROUP §fseu group foi §a§lALTERADO §fpara: §9§lAJUDANTE");

					TituloAPI.MandarTitulo(target, "§3§lGROUP");
					TituloAPI.MandarSubTitulo(target, "§7Você teve o seu group alterado para: §9§lAJUDANTE");

					cfGrupo.setarGrupo(target, "Helper");
					cfGrupo.salvarconfiguracao();

					if (cfGrupo.ChecarGrupo(target, "Dono")) {
						CorGrupo.setarTag(target, "§4§l");
					} else if (cfGrupo.ChecarGrupo(target, "Gerente")) {
						CorGrupo.setarTag(target, "§3§l");
					} else if (cfGrupo.ChecarGrupo(target, "Admin")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod+")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber+")) {
						CorGrupo.setarTag(target, "§3§l");
					} else if (cfGrupo.ChecarGrupo(target, "Builder")) {
						CorGrupo.setarTag(target, "§2§l");
					} else if (cfGrupo.ChecarGrupo(target, "Helper")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber")) {
						CorGrupo.setarTag(target, "§b§l");
					} else if (cfGrupo.ChecarGrupo(target, "S-Pro")) {
						CorGrupo.setarTag(target, "§e§l");
					} else if (cfGrupo.ChecarGrupo(target, "Pro")) {
						CorGrupo.setarTag(target, "§6§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mvp")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Light")) {
						CorGrupo.setarTag(target, "§a§l");
					} else if (cfGrupo.ChecarGrupo(target, "Trial")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Membro")) {
						CorGrupo.setarTag(target, "§7§l");
					}
					sScoreAPI.scoreboard(target);
					target.chat("/tag ajudante");
					return true;
				}
				if (Args[1].equalsIgnoreCase("trial")) {

					Sender.sendMessage(
							"§3§lGROUPSET §7Voce Alterou o grupo de §c" + target.getName() + " §7para: §5§lTRIAL");
					target.sendMessage("§3§lGROUP §fseu group foi §a§lALTERADO §fpara: §5§lTRIAL");

					TituloAPI.MandarTitulo(target, "§3§lGROUP");
					TituloAPI.MandarSubTitulo(target, "§7Você teve o seu group alterado para: §5§lTRIAL");

					cfGrupo.setarGrupo(target, "Trial");
					cfGrupo.salvarconfiguracao();

					if (cfGrupo.ChecarGrupo(target, "Dono")) {
						CorGrupo.setarTag(target, "§4§l");
					} else if (cfGrupo.ChecarGrupo(target, "Gerente")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Admin")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod+")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber+")) {
						CorGrupo.setarTag(target, "§3§l");
					} else if (cfGrupo.ChecarGrupo(target, "Builder")) {
						CorGrupo.setarTag(target, "§2§l");
					} else if (cfGrupo.ChecarGrupo(target, "Helper")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber")) {
						CorGrupo.setarTag(target, "§b§l");
					} else if (cfGrupo.ChecarGrupo(target, "S-Pro")) {
						CorGrupo.setarTag(target, "§e§l");
					} else if (cfGrupo.ChecarGrupo(target, "Pro")) {
						CorGrupo.setarTag(target, "§6§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mvp")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Light")) {
						CorGrupo.setarTag(target, "§a§l");
					} else if (cfGrupo.ChecarGrupo(target, "Trial")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Membro")) {
						CorGrupo.setarTag(target, "§7§l");
					}
					sScoreAPI.scoreboard(target);
					target.chat("/tag trial");
					return true;
				}
				if (Args[1].equalsIgnoreCase("mod")) {

					Sender.sendMessage(
							"§3§lGROUPSET §7Voce Alterou o grupo de §c" + target.getName() + " §7para: §5§lMOD");
					target.sendMessage("§3§lGROUP §fseu group foi §a§lALTERADO §fpara: §5§lMOD");

					TituloAPI.MandarTitulo(target, "§3§lGROUP");
					TituloAPI.MandarSubTitulo(target, "§7Você teve o seu group alterado para: §5§lMOD");

					cfGrupo.setarGrupo(target, "Mod");
					cfGrupo.salvarconfiguracao();

					if (cfGrupo.ChecarGrupo(target, "Dono")) {
						CorGrupo.setarTag(target, "§4§l");
					} else if (cfGrupo.ChecarGrupo(target, "Gerente")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Admin")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod+")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber+")) {
						CorGrupo.setarTag(target, "§3§l");
					} else if (cfGrupo.ChecarGrupo(target, "Builder")) {
						CorGrupo.setarTag(target, "§2§l");
					} else if (cfGrupo.ChecarGrupo(target, "Helper")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber")) {
						CorGrupo.setarTag(target, "§b§l");
					} else if (cfGrupo.ChecarGrupo(target, "S-Pro")) {
						CorGrupo.setarTag(target, "§e§l");
					} else if (cfGrupo.ChecarGrupo(target, "Pro")) {
						CorGrupo.setarTag(target, "§6§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mvp")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Light")) {
						CorGrupo.setarTag(target, "§a§l");
					} else if (cfGrupo.ChecarGrupo(target, "Trial")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Membro")) {
						CorGrupo.setarTag(target, "§7§l");
					}
					sScoreAPI.scoreboard(target);
					target.chat("/tag mod");
					return true;
				}
				if (Args[1].equalsIgnoreCase("modplus")) {

					Sender.sendMessage(
							"§3§lGROUPSET §7Voce Alterou o grupo de §c" + target.getName() + " §7para: §5§lMOD+");
					target.sendMessage("§3§lGROUP §fseu group foi §a§lALTERADO §fpara: §5§lMOD+!");

					TituloAPI.MandarTitulo(target, "§3§lGROUP");
					TituloAPI.MandarSubTitulo(target, "§7Você teve o seu group alterado para: §5§lMOD+");

					cfGrupo.setarGrupo(target, "Mod+");
					cfGrupo.salvarconfiguracao();

					if (cfGrupo.ChecarGrupo(target, "Dono")) {
						CorGrupo.setarTag(target, "§4§l");
					} else if (cfGrupo.ChecarGrupo(target, "Gerente")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Admin")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod+")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber+")) {
						CorGrupo.setarTag(target, "§3§l");
					} else if (cfGrupo.ChecarGrupo(target, "Builder")) {
						CorGrupo.setarTag(target, "§2§l");
					} else if (cfGrupo.ChecarGrupo(target, "Helper")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber")) {
						CorGrupo.setarTag(target, "§b§l");
					} else if (cfGrupo.ChecarGrupo(target, "S-Pro")) {
						CorGrupo.setarTag(target, "§e§l");
					} else if (cfGrupo.ChecarGrupo(target, "Pro")) {
						CorGrupo.setarTag(target, "§6§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mvp")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Light")) {
						CorGrupo.setarTag(target, "§a§l");
					} else if (cfGrupo.ChecarGrupo(target, "Trial")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Membro")) {
						CorGrupo.setarTag(target, "§7§l");
					}
					sScoreAPI.scoreboard(target);
					target.chat("/tag modplus");
					return true;
				}
				if (Args[1].equalsIgnoreCase("admin")) {

					Sender.sendMessage(
							"§3§lGROUPSET §7Voce Alterou o grupo de §c" + target.getName() + " §7para: §c§lADMIN");
					target.sendMessage("§3§lGROUP §fseu group foi §a§lALTERADO §fpara: §c§lADMIN");

					TituloAPI.MandarTitulo(target, "§3§lGROUP");
					TituloAPI.MandarSubTitulo(target, "§7Você teve o seu group alterado para: §c§lADMIN");

					cfGrupo.setarGrupo(target, "Admin");
					cfGrupo.salvarconfiguracao();

					if (cfGrupo.ChecarGrupo(target, "Dono")) {
						CorGrupo.setarTag(target, "§4§l");
					} else if (cfGrupo.ChecarGrupo(target, "Gerente")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Admin")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod+")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber+")) {
						CorGrupo.setarTag(target, "§3§l");
					} else if (cfGrupo.ChecarGrupo(target, "Builder")) {
						CorGrupo.setarTag(target, "§2§l");
					} else if (cfGrupo.ChecarGrupo(target, "Helper")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber")) {
						CorGrupo.setarTag(target, "§b§l");
					} else if (cfGrupo.ChecarGrupo(target, "S-Pro")) {
						CorGrupo.setarTag(target, "§e§l");
					} else if (cfGrupo.ChecarGrupo(target, "Pro")) {
						CorGrupo.setarTag(target, "§6§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mvp")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Light")) {
						CorGrupo.setarTag(target, "§a§l");
					} else if (cfGrupo.ChecarGrupo(target, "Trial")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Membro")) {
						CorGrupo.setarTag(target, "§7§l");
					}
					sScoreAPI.scoreboard(target);
					target.chat("/tag admin");
					return true;
				}
				if (Args[1].equalsIgnoreCase("gerente")) {

					Sender.sendMessage(
							"§3§lGROUPSET §7Voce Alterou o grupo de §c" + target.getName() + " §7para: §c§lGERENTE");
					target.sendMessage("§3§lGROUP §fseu group foi §a§lALTERADO §fpara: §c§lGERENTE");

					TituloAPI.MandarTitulo(target, "§3§lGROUP");
					TituloAPI.MandarSubTitulo(target, "§7Você teve o seu group alterado para: §c§lGERENTE");

					cfGrupo.setarGrupo(target, "Gerente");
					cfGrupo.salvarconfiguracao();

					if (cfGrupo.ChecarGrupo(target, "Dono")) {
						CorGrupo.setarTag(target, "§4§l");
					} else if (cfGrupo.ChecarGrupo(target, "Gerente")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Admin")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod+")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber+")) {
						CorGrupo.setarTag(target, "§3§l");
					} else if (cfGrupo.ChecarGrupo(target, "Builder")) {
						CorGrupo.setarTag(target, "§2§l");
					} else if (cfGrupo.ChecarGrupo(target, "Helper")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber")) {
						CorGrupo.setarTag(target, "§b§l");
					} else if (cfGrupo.ChecarGrupo(target, "S-Pro")) {
						CorGrupo.setarTag(target, "§e§l");
					} else if (cfGrupo.ChecarGrupo(target, "Pro")) {
						CorGrupo.setarTag(target, "§6§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mvp")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Light")) {
						CorGrupo.setarTag(target, "§a§l");
					} else if (cfGrupo.ChecarGrupo(target, "Trial")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Membro")) {
						CorGrupo.setarTag(target, "§7§l");
					}
					sScoreAPI.scoreboard(target);
					target.chat("/tag gerente");
					return true;
				}
				if (Args[1].equalsIgnoreCase("dono")) {

					Sender.sendMessage(
							"§3§lGROUPSET §7Voce Alterou o grupo de §c" + target.getName() + " §7para: §4§lDONO");
					target.sendMessage("§3§lGROUP §fseu group foi §a§lALTERADO §fpara: §4§lDONO");

					TituloAPI.MandarTitulo(target, "§3§lGROUP");
					TituloAPI.MandarSubTitulo(target, "§7Você teve o seu group alterado para: §4§lDONO");

					cfGrupo.setarGrupo(target, "Dono");
					cfGrupo.salvarconfiguracao();

					if (cfGrupo.ChecarGrupo(target, "Dono")) {
						CorGrupo.setarTag(target, "§4§l");
					} else if (cfGrupo.ChecarGrupo(target, "Gerente")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Admin")) {
						CorGrupo.setarTag(target, "§c§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod+")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mod")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber+")) {
						CorGrupo.setarTag(target, "§3§l");
					} else if (cfGrupo.ChecarGrupo(target, "Builder")) {
						CorGrupo.setarTag(target, "§2§l");
					} else if (cfGrupo.ChecarGrupo(target, "Helper")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Youtuber")) {
						CorGrupo.setarTag(target, "§b§l");
					} else if (cfGrupo.ChecarGrupo(target, "S-Pro")) {
						CorGrupo.setarTag(target, "§e§l");
					} else if (cfGrupo.ChecarGrupo(target, "Pro")) {
						CorGrupo.setarTag(target, "§6§l");
					} else if (cfGrupo.ChecarGrupo(target, "Mvp")) {
						CorGrupo.setarTag(target, "§9§l");
					} else if (cfGrupo.ChecarGrupo(target, "Light")) {
						CorGrupo.setarTag(target, "§a§l");
					} else if (cfGrupo.ChecarGrupo(target, "Trial")) {
						CorGrupo.setarTag(target, "§5§l");
					} else if (cfGrupo.ChecarGrupo(target, "Membro")) {
						CorGrupo.setarTag(target, "§7§l");
					}
					sScoreAPI.scoreboard(target);
					target.chat("/tag dono");
					return true;
				}
				Sender.sendMessage("§3§lGROUPSET §fEsse grupo nao existe!");
			}
		}
		return false;
	}
}
