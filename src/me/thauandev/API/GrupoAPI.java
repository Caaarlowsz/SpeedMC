package me.thauandev.API;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import me.thauandev.API.CalendarioAPI.Calendario;
��o.cfGrupo;
import me.thauandev.configura��o.cfTempGrupo;
import me.thauandev.events.CorGrupo;
import com.github.caaarlowsz.speedmc.kitpvp.SpeedPvP;
import me.thauandev.scoreboard.sScoreAPI;

public class GrupoAPI {

	public static boolean Checando;

	public static void expirar(Player p, int dia, int mes, int ano, int hora, int minutos, int segundos) {

		cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Nick", p.getName());
		cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Dia", dia);
		cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Mes", mes);
		cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Ano", ano);
		cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Hora", hora);
		cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Minuto", minutos);
		cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Segundos", segundos);
		cfTempGrupo.salvarconfiguracao();

		checarVip(p);

		if (cfGrupo.ChecarGrupo(p, "DONO")) {
			CorGrupo.setarTag(p, "�4�l");
		} else if (cfGrupo.ChecarGrupo(p, "GERENTE")) {
			CorGrupo.setarTag(p, "�3�l");
		} else if (cfGrupo.ChecarGrupo(p, "ADMIN")) {
			CorGrupo.setarTag(p, "�c�l");
		} else if (cfGrupo.ChecarGrupo(p, "MOD+")) {
			CorGrupo.setarTag(p, "�5�l");
		} else if (cfGrupo.ChecarGrupo(p, "MOD")) {
			CorGrupo.setarTag(p, "�5�l");
		} else if (cfGrupo.ChecarGrupo(p, "TRIAL")) {
			CorGrupo.setarTag(p, "�5�l");
		} else if (cfGrupo.ChecarGrupo(p, "YOUTUBER+")) {
			CorGrupo.setarTag(p, "�3�l");
		} else if (cfGrupo.ChecarGrupo(p, "HELPER")) {
			CorGrupo.setarTag(p, "�d�l");
		} else if (cfGrupo.ChecarGrupo(p, "YOUTUBER")) {
			CorGrupo.setarTag(p, "�b�l");
		} else if (cfGrupo.ChecarGrupo(p, "S-PRO")) {
			CorGrupo.setarTag(p, "�e�l");
		} else if (cfGrupo.ChecarGrupo(p, "PRO")) {
			CorGrupo.setarTag(p, "�d�l");
		} else if (cfGrupo.ChecarGrupo(p, "MVP")) {
			CorGrupo.setarTag(p, "�6�l");
		} else if (cfGrupo.ChecarGrupo(p, "LIGHT")) {
			CorGrupo.setarTag(p, "�a�l");
		} else if (cfGrupo.ChecarGrupo(p, "MEMBRO")) {
			CorGrupo.setarTag(p, "�7�l");
		}
		sScoreAPI.scoreboard(p);
		p.chat("/tag " + cfGrupo.pegargrupo().get("grupos." + p.getUniqueId() + ".grupo"));
	}

	public static void expirarOffline(OfflinePlayer p, int dia, int mes, int ano, int hora, int minutos, int segundos) {

		cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Nick", p.getName());
		cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Dia", dia);
		cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Mes", mes);
		cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Ano", ano);
		cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Hora", hora);
		cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Minuto", minutos);
		cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Segundos", segundos);
		cfTempGrupo.salvarconfiguracao();

		checarVipOffline(p);
	}

	public static void checarVip(Player p) {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(SpeedPvP.getPlugin(), new Runnable() {
			public void run() {

				if (cfTempGrupo.pegargrupo().get("tempgrupos." + p.getUniqueId() + ".Dia") != null) {
					if (cfTempGrupo.pegargrupo().get("tempgrupos." + p.getUniqueId() + ".Mes") != null) {
						if (cfTempGrupo.pegargrupo().get("tempgrupos." + p.getUniqueId() + ".Ano") != null) {
							if (cfTempGrupo.pegargrupo().get("tempgrupos." + p.getUniqueId() + ".Hora") != null) {
								if (cfTempGrupo.pegargrupo().get("tempgrupos." + p.getUniqueId() + ".Minuto") != null) {
									if (cfTempGrupo.pegargrupo()
											.get("tempgrupos." + p.getUniqueId() + ".Segundos") != null) {
										if ((cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId()
												+ ".Dia") < CalendarioAPI.PegarCalendario(Calendario.Dia)
												|| ((cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId()
														+ ".Dia") == CalendarioAPI.PegarCalendario(Calendario.Dia)
														&& (cfGrupo.ChecarGrupo(p, "Pro")
																|| cfGrupo.ChecarGrupo(p, "Mvp")
																|| cfGrupo.ChecarGrupo(p, "Light")))))) {

											if ((cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId()
													+ ".Mes") < CalendarioAPI.PegarCalendario(Calendario.Mes)
													|| ((cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId()
															+ ".Mes") == CalendarioAPI.PegarCalendario(Calendario.Mes)
															&& (cfGrupo.ChecarGrupo(p, "Pro")
																	|| cfGrupo.ChecarGrupo(p, "Mvp")
																	|| cfGrupo.ChecarGrupo(p, "Light")))))) {

												if ((cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId()
														+ ".Ano") < CalendarioAPI.PegarCalendario(Calendario.Ano)
														|| ((cfTempGrupo.pegargrupo()
																.getInt("tempgrupos." + p.getUniqueId()
																		+ ".Ano") == CalendarioAPI
																				.PegarCalendario(Calendario.Ano)
																&& (cfGrupo.ChecarGrupo(p, "Pro")
																		|| cfGrupo.ChecarGrupo(p, "Mvp")
																		|| cfGrupo.ChecarGrupo(p, "Light")))))) {

													if ((cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId()
															+ ".Hora") < CalendarioAPI.PegarCalendario(Calendario.Hora)
															|| ((cfTempGrupo.pegargrupo()
																	.getInt("tempgrupos." + p.getUniqueId()
																			+ ".Hora") == CalendarioAPI
																					.PegarCalendario(Calendario.Hora)
																	&& (cfGrupo.ChecarGrupo(p, "Pro")
																			|| cfGrupo.ChecarGrupo(p, "Mvp")
																			|| cfGrupo.ChecarGrupo(p, "Light")))))) {

														if ((cfTempGrupo.pegargrupo()
																.getInt("tempgrupos." + p.getUniqueId()
																		+ ".Minuto") < CalendarioAPI
																				.PegarCalendario(Calendario.Minuto)
																|| ((cfTempGrupo.pegargrupo()
																		.getInt("tempgrupos." + p.getUniqueId()
																				+ ".Minuto") == CalendarioAPI
																						.PegarCalendario(
																								Calendario.Minuto)
																		&& (cfGrupo.ChecarGrupo(p, "Pro")
																				|| cfGrupo.ChecarGrupo(p, "Mvp")
																				|| cfGrupo.ChecarGrupo(p,
																						"Light")))))) {

															if ((cfTempGrupo.pegargrupo()
																	.getInt("tempgrupos." + p.getUniqueId()
																			+ ".Segundos") < CalendarioAPI
																					.PegarCalendario(Calendario.Segundo)
																	|| ((cfTempGrupo.pegargrupo()
																			.getInt("tempgrupos." + p.getUniqueId()
																					+ ".Segundos") == CalendarioAPI
																							.PegarCalendario(
																									Calendario.Segundo)
																			&& (cfGrupo.ChecarGrupo(p, "Pro")
																					|| cfGrupo.ChecarGrupo(p, "Mvp")
																					|| cfGrupo.ChecarGrupo(p,
																							"Light")))))) {

																API.mandarTitulo(p, "�c�lSPEED�f�lMC");
																API.mandarSubTitulo(p, "�7Seu VIP [�6�l"
																		+ cfGrupo.pegargrupo().getString(
																				"grupos." + p.getUniqueId() + ".grupo")
																		+ "�7] expirou");
																cfGrupo.salvarconfiguracao();
																Bukkit.getConsoleSender().sendMessage(
																		"�c�lSPEED�f�lMC �7� �fO Vip do jogador �6�l"
																				+ p.getName() + " �fexpirou.");
																p.sendMessage("�c�lSPEED�f�lMC �7� �fO seu Vip �7(�d�l"
																		+ cfGrupo.pegargrupo().getString(
																				"grupos." + p.getUniqueId() + ".grupo")
																		+ "�7) �fexpirou");
																cfTempGrupo.pegargrupo().set(
																		"tempgrupos." + p.getUniqueId() + ".Nick",
																		null);
																cfTempGrupo.pegargrupo().set(
																		"tempgrupos." + p.getUniqueId() + ".grupo",
																		null);
																cfTempGrupo.pegargrupo().set(
																		"tempgrupos." + p.getUniqueId() + ".Dia", null);
																cfTempGrupo.pegargrupo().set(
																		"tempgrupos." + p.getUniqueId() + ".Mes", null);
																cfTempGrupo.pegargrupo().set(
																		"tempgrupos." + p.getUniqueId() + ".Ano", null);
																cfTempGrupo.pegargrupo().set(
																		"tempgrupos." + p.getUniqueId() + ".Hora",
																		null);
																cfTempGrupo.pegargrupo().set(
																		"tempgrupos." + p.getUniqueId() + ".Minuto",
																		null);
																cfTempGrupo.pegargrupo().set(
																		"tempgrupos." + p.getUniqueId() + ".Segundos",
																		null);

																cfTempGrupo.salvarconfiguracao();

																for (Player todos : Bukkit.getOnlinePlayers()) {

																	if (cfGrupo.ChecarGrupo(todos, "Dono")
																			|| cfGrupo.ChecarGrupo(todos, "Gerente")
																			|| cfGrupo.ChecarGrupo(todos, "Admin")) {
																		todos.sendMessage(
																				"�c�lSPEED�f�lMC �6� �7O VIP [�6�l"
																						+ cfGrupo.pegargrupo()
																								.getString("grupos." + p
																										.getUniqueId()
																										+ ".grupo")
																						+ "�7] do jogador �6"
																						+ p.getName() + " �7expirou");
																	}
																}
																cfGrupo.setarGrupo(p, "MEMBRO");
																if (cfGrupo.ChecarGrupo(p, "DONO")) {
																	CorGrupo.setarTag(p, "�4�l");
																} else if (cfGrupo.ChecarGrupo(p, "GERENTE")) {
																	CorGrupo.setarTag(p, "�c�l");
																} else if (cfGrupo.ChecarGrupo(p, "ADMIN")) {
																	CorGrupo.setarTag(p, "�c�l");
																} else if (cfGrupo.ChecarGrupo(p, "MOD+")) {
																	CorGrupo.setarTag(p, "�5�l");
																} else if (cfGrupo.ChecarGrupo(p, "MOD")) {
																	CorGrupo.setarTag(p, "�5�l");
																} else if (cfGrupo.ChecarGrupo(p, "TRIAL")) {
																	CorGrupo.setarTag(p, "�5�l");
																} else if (cfGrupo.ChecarGrupo(p, "YOUTUBER+")) {
																	CorGrupo.setarTag(p, "�3�l");
																} else if (cfGrupo.ChecarGrupo(p, "BUILDER")) {
																	CorGrupo.setarTag(p, "�2�l");
																} else if (cfGrupo.ChecarGrupo(p, "HELPER")) {
																	CorGrupo.setarTag(p, "�e�l");
																} else if (cfGrupo.ChecarGrupo(p, "YOUTUBER")) {
																	CorGrupo.setarTag(p, "�b�l");
																} else if (cfGrupo.ChecarGrupo(p, "S-PRO")) {
																	CorGrupo.setarTag(p, "�e�l");
																} else if (cfGrupo.ChecarGrupo(p, "PRO")) {
																	CorGrupo.setarTag(p, "�d�l");
																} else if (cfGrupo.ChecarGrupo(p, "MVP")) {
																	CorGrupo.setarTag(p, "�6�l");
																} else if (cfGrupo.ChecarGrupo(p, "LIGHT")) {
																	CorGrupo.setarTag(p, "�a�l");
																} else if (cfGrupo.ChecarGrupo(p, "MEMBRO")) {
																	CorGrupo.setarTag(p, "�7�l");
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
		}, 0L, 20L);
	}

	public static void checarVipOffline(OfflinePlayer p) {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(SpeedPvP.getPlugin(), new Runnable() {
			public void run() {

				if ((cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Dia") < CalendarioAPI
						.PegarCalendario(Calendario.Dia)
						|| ((cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Dia") == CalendarioAPI
								.PegarCalendario(Calendario.Dia) && (!cfGrupo.ChecarGrupo(p, "Membro")))))) {

					if ((cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Mes") < CalendarioAPI
							.PegarCalendario(Calendario.Mes)
							|| ((cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId()
									+ ".Mes") == CalendarioAPI.PegarCalendario(Calendario.Mes)
									&& (!cfGrupo.ChecarGrupo(p, "Membro")))))) {

						if ((cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Ano") < CalendarioAPI
								.PegarCalendario(Calendario.Ano)
								|| ((cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId()
										+ ".Ano") == CalendarioAPI.PegarCalendario(Calendario.Ano)
										&& (!cfGrupo.ChecarGrupo(p, "Membro")))))) {

							if ((cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId()
									+ ".Hora") < CalendarioAPI.PegarCalendario(Calendario.Hora)
									|| ((cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId()
											+ ".Hora") == CalendarioAPI.PegarCalendario(Calendario.Hora)
											&& (!cfGrupo.ChecarGrupo(p, "Membro")))))) {

								if ((cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId()
										+ ".Minuto") < CalendarioAPI.PegarCalendario(Calendario.Minuto)
										|| ((cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId()
												+ ".Minuto") == CalendarioAPI.PegarCalendario(Calendario.Minuto)
												&& (!cfGrupo.ChecarGrupo(p, "Membro")))))) {

									if ((cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId()
											+ ".Segundos") < CalendarioAPI.PegarCalendario(Calendario.Segundo)
											|| ((cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId()
													+ ".Segundos") == CalendarioAPI.PegarCalendario(Calendario.Segundo)
													&& (!cfGrupo.ChecarGrupo(p, "Membro")))))) {

										if (cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Mvp")
												|| cfGrupo.ChecarGrupo(p, "Light")) {
											cfGrupo.salvarconfiguracao();
											Bukkit.getConsoleSender()
													.sendMessage("�c�lSPEED�f�lMC �7� �7O VIP do jogador �6"
															+ p.getName() + " �7expirou");
											cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Nick",
													null);
											cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".grupo",
													null);
											cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Dia",
													null);
											cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Mes",
													null);
											cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Ano",
													null);
											cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Hora",
													null);
											cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Minuto",
													null);
											cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Segundos",
													null);

											cfTempGrupo.salvarconfiguracao();
											for (Player todos : Bukkit.getOnlinePlayers()) {

												if (cfGrupo.ChecarGrupo(todos, "Dono")
														|| cfGrupo.ChecarGrupo(todos, "Gerente")
														|| cfGrupo.ChecarGrupo(todos, "Admin")) {
													todos.sendMessage("�c�lSPEED�f�lMC �7O VIP [�6�l"
															+ cfGrupo.pegargrupo()
																	.getString("grupos." + p.getUniqueId() + ".grupo")
															+ "�7] do jogador �6" + p.getName() + " �7expirou");
												}
											}
											cfGrupo.setarGrupo(p, "Membro");
										}
									}
								}
							}
						}
					}
				}
			}
		}, 0L, 20L);
	}
}
