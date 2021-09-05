package me.thauandev.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import me.thauandev.configuração.cfGrupo;
import me.thauandev.scoreboard.sScoreAPI;
import me.thauandev.v_1_8.TituloAPI;

public class PlacaVIP implements Listener {

	@EventHandler
	public void Escrever(SignChangeEvent e) {
		if (e.getLine(0).equalsIgnoreCase("viplight")) {
			e.setLine(0, "");
			e.setLine(1, "  §a§lLIGHT");
			e.setLine(2, " §7(Clique)");
			e.setLine(3, " ");
		}

		if (e.getLine(0).equalsIgnoreCase("vippremium")) {
			e.setLine(0, " ");
			e.setLine(1, "  §6§lPREMIUM");
			e.setLine(2, " §7(Clique)");
			e.setLine(3, " ");
		}

		if (e.getLine(0).equalsIgnoreCase("vipultimate")) {
			e.setLine(0, " ");
			e.setLine(1, "  §d§lULTIMATE");
			e.setLine(2, " §7(Clique)");
			e.setLine(3, " ");
		}

	}

	@EventHandler
	public void inv(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if ((e.getAction() == Action.RIGHT_CLICK_BLOCK))
			if (e.getClickedBlock() != null)
				if (e.getClickedBlock().getType() == Material.WALL_SIGN
						|| (e.getClickedBlock().getType() == Material.SIGN_POST)) {
					Sign s = (Sign) e.getClickedBlock().getState();
					String[] lines = s.getLines();
					if ((lines.length > 0) && (lines[0].equals(" ")) && (lines.length > 1)
							&& (lines[1].equals("  §a§lLIGHT ")) && (lines.length > 2)
							&& (lines[2].equals(" §7(Clique)")) && (lines.length > 3) && (lines[3].equals(" "))) {

						Bukkit.broadcastMessage(" ");
						Bukkit.broadcastMessage(
								"§fO jogador §5§l" + p.getName() + " §facaba de encontrar uma placa valendo VIP!");
						Bukkit.broadcastMessage(" ");

						p.sendMessage(
								"§fVocê §a§lACHOU §fuma placa valendo VIP. Seu grupo foi alterado para: §a§lLIGHT");

						s.getBlock().breakNaturally();

						p.sendMessage("§eO seu grupo foi alterado para Light!");

						TituloAPI.MandarTitulo(p, "§a§lGRUPO");
						TituloAPI.MandarSubTitulo(p, "§7Você teve o seu grupo alterado para: §a§lLIGHT");

						cfGrupo.setarGrupo(p, "Light");
						cfGrupo.salvarconfiguracao();

						if (cfGrupo.ChecarGrupo(p, "Dono")) {
							CorGrupo.setarTag(p, "§4§l");
						} else if (cfGrupo.ChecarGrupo(p, "Gerente")) {
							CorGrupo.setarTag(p, "§c§l");
						} else if (cfGrupo.ChecarGrupo(p, "Admin")) {
							CorGrupo.setarTag(p, "§c§l");
						} else if (cfGrupo.ChecarGrupo(p, "Mod+")) {
							CorGrupo.setarTag(p, "§5§l");
						} else if (cfGrupo.ChecarGrupo(p, "Mod")) {
							CorGrupo.setarTag(p, "§5§l");
						} else if (cfGrupo.ChecarGrupo(p, "Trial")) {
							CorGrupo.setarTag(p, "§5§l");
						} else if (cfGrupo.ChecarGrupo(p, "Youtuber+")) {
							CorGrupo.setarTag(p, "§3§l");
						} else if (cfGrupo.ChecarGrupo(p, "Builder")) {
							CorGrupo.setarTag(p, "§2§l");
						} else if (cfGrupo.ChecarGrupo(p, "Helper")) {
							CorGrupo.setarTag(p, "§9§l");
						} else if (cfGrupo.ChecarGrupo(p, "Youtuber")) {
							CorGrupo.setarTag(p, "§b§l");
						} else if (cfGrupo.ChecarGrupo(p, "S-Pro")) {
							CorGrupo.setarTag(p, "§e§l");
						} else if (cfGrupo.ChecarGrupo(p, "Pro")) {
							CorGrupo.setarTag(p, "§6§l");
						} else if (cfGrupo.ChecarGrupo(p, "Mvp")) {
							CorGrupo.setarTag(p, "§9§l");
						} else if (cfGrupo.ChecarGrupo(p, "Light")) {
							CorGrupo.setarTag(p, "§a§l");
						} else if (cfGrupo.ChecarGrupo(p, "Membro")) {
							CorGrupo.setarTag(p, "§7§l");
						}
						sScoreAPI.scoreboard(p);
						p.chat("/tag light");
					}

					if ((lines.length > 0) && (lines[0].equals(" ")) && (lines.length > 1)
							&& (lines[1].equals("  §6§lPREMIUM")) && (lines.length > 2)
							&& (lines[2].equals(" §7(Clique)")) && (lines.length > 3) && (lines[3].equals(" "))) {

						p.sendMessage(
								"§fVocê §a§lACHOU §fuma placa valendo VIP. Seu grupo foi alterado para: §6§lPREMIUM");

						Bukkit.broadcastMessage(" ");
						Bukkit.broadcastMessage(
								"§fO jogador §5§l" + p.getName() + " §facaba de encontrar uma placa valendo VIP!");
						Bukkit.broadcastMessage(" ");

						s.getBlock().breakNaturally();

						p.sendMessage("§eO seu grupo foi alterado para Premium!");

						TituloAPI.MandarTitulo(p, "§a§lGRUPO");
						TituloAPI.MandarSubTitulo(p, "§7Você teve o seu grupo alterado para: §6§lPREMIUM");

						cfGrupo.setarGrupo(p, "Mvp");
						cfGrupo.salvarconfiguracao();

						if (cfGrupo.ChecarGrupo(p, "Dono")) {
							CorGrupo.setarTag(p, "§4§l");
						} else if (cfGrupo.ChecarGrupo(p, "Gerente")) {
							CorGrupo.setarTag(p, "§c§l");
						} else if (cfGrupo.ChecarGrupo(p, "Admin")) {
							CorGrupo.setarTag(p, "§c§l");
						} else if (cfGrupo.ChecarGrupo(p, "Mod+")) {
							CorGrupo.setarTag(p, "§5§l");
						} else if (cfGrupo.ChecarGrupo(p, "Mod")) {
							CorGrupo.setarTag(p, "§5§l");
						} else if (cfGrupo.ChecarGrupo(p, "Trial")) {
							CorGrupo.setarTag(p, "§5§l");
						} else if (cfGrupo.ChecarGrupo(p, "Youtuber+")) {
							CorGrupo.setarTag(p, "§3§l");
						} else if (cfGrupo.ChecarGrupo(p, "Builder")) {
							CorGrupo.setarTag(p, "§2§l");
						} else if (cfGrupo.ChecarGrupo(p, "Helper")) {
							CorGrupo.setarTag(p, "§9§l");
						} else if (cfGrupo.ChecarGrupo(p, "Youtuber")) {
							CorGrupo.setarTag(p, "§b§l");
						} else if (cfGrupo.ChecarGrupo(p, "S-Pro")) {
							CorGrupo.setarTag(p, "§e§l");
						} else if (cfGrupo.ChecarGrupo(p, "Pro")) {
							CorGrupo.setarTag(p, "§6§l");
						} else if (cfGrupo.ChecarGrupo(p, "Mvp")) {
							CorGrupo.setarTag(p, "§9§l");
						} else if (cfGrupo.ChecarGrupo(p, "Light")) {
							CorGrupo.setarTag(p, "§a§l");
						} else if (cfGrupo.ChecarGrupo(p, "Membro")) {
							CorGrupo.setarTag(p, "§7§l");
						}
						sScoreAPI.scoreboard(p);
						p.chat("/tag premium");
					}

					if ((lines.length > 0) && (lines[0].equals(" ")) && (lines.length > 1)
							&& (lines[1].equals("  §d§lULTIMATE")) && (lines.length > 2)
							&& (lines[2].equals(" §7(Clique)")) && (lines.length > 3) && (lines[3].equals(" "))) {

						p.sendMessage(
								"§fVocê §a§lACHOU §fuma placa valendo VIP. Seu grupo foi alterado para: §d§lULTIMATE");

						Bukkit.broadcastMessage(" ");
						Bukkit.broadcastMessage(
								"§fO jogador §5§l" + p.getName() + " §facaba de encontrar uma placa valendo VIP!");
						Bukkit.broadcastMessage(" ");

						s.getBlock().breakNaturally();

						p.sendMessage("§eO seu grupo foi alterado para Ultimate!");

						TituloAPI.MandarTitulo(p, "§a§lGRUPO");
						TituloAPI.MandarSubTitulo(p, "§7Você teve o seu grupo alterado para: §d§lULTIMATE");

						cfGrupo.setarGrupo(p, "Pro");
						cfGrupo.salvarconfiguracao();

						if (cfGrupo.ChecarGrupo(p, "Dono")) {
							CorGrupo.setarTag(p, "§4§l");
						} else if (cfGrupo.ChecarGrupo(p, "Gerente")) {
							CorGrupo.setarTag(p, "§c§l");
						} else if (cfGrupo.ChecarGrupo(p, "Admin")) {
							CorGrupo.setarTag(p, "§c§l");
						} else if (cfGrupo.ChecarGrupo(p, "Mod+")) {
							CorGrupo.setarTag(p, "§5§l");
						} else if (cfGrupo.ChecarGrupo(p, "Mod")) {
							CorGrupo.setarTag(p, "§5§l");
						} else if (cfGrupo.ChecarGrupo(p, "Trial")) {
							CorGrupo.setarTag(p, "§5§l");
						} else if (cfGrupo.ChecarGrupo(p, "Youtuber+")) {
							CorGrupo.setarTag(p, "§3§l");
						} else if (cfGrupo.ChecarGrupo(p, "Builder")) {
							CorGrupo.setarTag(p, "§2§l");
						} else if (cfGrupo.ChecarGrupo(p, "Helper")) {
							CorGrupo.setarTag(p, "§9§l");
						} else if (cfGrupo.ChecarGrupo(p, "Youtuber")) {
							CorGrupo.setarTag(p, "§b§l");
						} else if (cfGrupo.ChecarGrupo(p, "S-Pro")) {
							CorGrupo.setarTag(p, "§e§l");
						} else if (cfGrupo.ChecarGrupo(p, "Pro")) {
							CorGrupo.setarTag(p, "§6§l");
						} else if (cfGrupo.ChecarGrupo(p, "Mvp")) {
							CorGrupo.setarTag(p, "§9§l");
						} else if (cfGrupo.ChecarGrupo(p, "Light")) {
							CorGrupo.setarTag(p, "§a§l");
						} else if (cfGrupo.ChecarGrupo(p, "Membro")) {
							CorGrupo.setarTag(p, "§7§l");
						}
						sScoreAPI.scoreboard(p);
						p.chat("/tag ultimate");
					}

				}
	}

}