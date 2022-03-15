package me.thauandev.bans;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thauandev.API.HorarioAPI;
import me.thauandev.configura��o.cfGrupo;
import com.github.caaarlowsz.speedmc.kitpvp.SpeedPvP;

public class TempBanCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player)) {
			return true;
		}
		Player jogador = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("tempban")) {
			if ((!cfGrupo.ChecarGrupo(jogador, "Dono") && (!cfGrupo.ChecarGrupo(jogador, "Gerente")
					&& (!cfGrupo.ChecarGrupo(jogador, "Admin") && (!cfGrupo.ChecarGrupo(jogador, "Mod+")
							&& (!cfGrupo.ChecarGrupo(jogador, "Mod") && (!cfGrupo.ChecarGrupo(jogador, "Trial")
									&& (!cfGrupo.ChecarGrupo(jogador, "Youtuber+"))))))))) {
				API.sendMsg(jogador, "�c�l(!) �cVoc� n�o possui permiss�o para executar este comando!");
				return true;
			}
			if (args.length == 0) {
				API.sendMsg(jogador, "�3�lTEMPBAN �fUtilize �3�l/tempban �3(jogador) (sigla)");
				API.sendMsg(jogador, " ");
				API.sendMsg(jogador, "�2�lSIGLAS �fAbaixo segue a lista de siglas e seus significados...");
				API.sendMsg(jogador, " ");
				API.sendMsg(jogador, "�6� �3�lftell �f- �8(Flood no tell)");
				API.sendMsg(jogador, "�6� �3�lffa �f- �8(Free for all)");
				API.sendMsg(jogador, "�6� �3�ltfps �f- �8(Time na fps)");
				API.sendMsg(jogador, "�6� �3�lfkill �f- �8(Freekill)");
				API.sendMsg(jogador, "�6� �3�lofs �f- �8(Ofensa a staff)");
				API.sendMsg(jogador, "�6� �3�loftell �f- �8(Ofensa pelo tell)");
				API.sendMsg(jogador, "�6� �3�labug �f- �8(Abuso de bugs)");
				API.sendMsg(jogador, "�6� �3�lcitlink �f- �8(Cita��o de links externos)");
				API.sendMsg(jogador, "�6� �3�lident �f- �8(Falsidade ideol�gica)");

				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			final Player vitima = Bukkit.getPlayer(args[0]);
			if (vitima == null) {
				API.sendMsg(jogador, "�cO jogador em quest�o est� offline!");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			if (Config.getConfig().getTempBans().get("TempBans." + vitima.getUniqueId()) != null) {
				API.sendMsg(jogador, "�3�lTEMPBAN �fUtilize �3�l/tempban �3(jogador) (sigla)");
				API.sendMsg(jogador, " ");
				API.sendMsg(jogador, "�2�lSIGLAS �fAbaixo segue a lista de siglas e seus significados...");
				API.sendMsg(jogador, " ");
				API.sendMsg(jogador, "�6� �3�lftell �f- �8(Flood no tell)");
				API.sendMsg(jogador, "�6� �3�lffa �f- �8(Free for all)");
				API.sendMsg(jogador, "�6� �3�ltfps �f- �8(Time na fps)");
				API.sendMsg(jogador, "�6� �3�lfkill �f- �8(Freekill)");
				API.sendMsg(jogador, "�6� �3�lofs �f- �8(Ofensa a staff)");
				API.sendMsg(jogador, "�6� �3�loftell �f- �8(Ofensa pelo tell)");
				API.sendMsg(jogador, "�6� �3�labug �f- �8(Abuso de bugs)");
				API.sendMsg(jogador, "�6� �3�lcitlink �f- �8(Cita��o de links externos)");
				API.sendMsg(jogador, "�6� �3�lident �f- �8(Falsidade ideol�gica)");

				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			if (Config.getConfig().getIpBans().get("IPBans." + vitima.getUniqueId()) != null) {
				API.sendMsg(jogador, "�fO jogador �6�l" + args[0] + " �fj� est� �4�lBANIDO�f!");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			if (Config.getConfig().getBans().get("Bans." + vitima.getUniqueId()) != null) {
				API.sendMsg(jogador, "�fO jogador �6�l" + args[0] + " �fj� est� �4�lBANIDO�f!");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			if (vitima.getName() == jogador.getName()) {
				API.sendMsg(jogador, "�cVoc� n�o pode banir a si mesmo!");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			if (args.length == 1) {
				API.sendMsg(jogador, "�3�lTEMPBAN �fUtilize �3�l/tempban �3(jogador) (sigla)");
				API.sendMsg(jogador, "�3�lTEMPBAN �fUtilize �3�l/tempban �3(jogador) (sigla)");
				API.sendMsg(jogador, " ");
				API.sendMsg(jogador, "�2�lSIGLAS �fAbaixo segue a lista de siglas e seus significados...");
				API.sendMsg(jogador, " ");
				API.sendMsg(jogador, "�6� �3�lftell �f- �8(Flood no tell)");
				API.sendMsg(jogador, "�6� �3�lffa �f- �8(Free for all)");
				API.sendMsg(jogador, "�6� �3�ltfps �f- �8(Time na fps)");
				API.sendMsg(jogador, "�6� �3�lfkill �f- �8(Freekill)");
				API.sendMsg(jogador, "�6� �3�lofs �f- �8(Ofensa a staff)");
				API.sendMsg(jogador, "�6� �3�loftell �f- �8(Ofensa pelo tell)");
				API.sendMsg(jogador, "�6� �3�labug �f- �8(Abuso de bugs)");
				API.sendMsg(jogador, "�6� �3�lcitlink �f- �8(Cita��o de links externos)");
				API.sendMsg(jogador, "�6� �3�lident �f- �8(Falsidade ideol�gica)");

				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			if (args[1].equalsIgnoreCase("ftell")) {
				API.sendMsg(jogador,
						"�3�lTEMPBAN �fVoc� baniu �3�lTEMPORARIAMENTE �fo jogador: �6�l" + vitima.getName() + "�f.");
				API.sendStaff("�3�lTEMPBAN �f" + jogador.getName() + " baniu �3�lTEMPORARIAMENTE �fo jogador �6�l"
						+ vitima.getName() + ". Motivo: �c�lFlood no Tell");
				vitima.kickPlayer("�fVoc� foi banido �9�lTEMPORARIAMENTE�f do servidor!" + "\n"
						+ "�7Username banido: �c�l" + vitima.getName() + "\n" + "�7Banido por: �c�l" + jogador.getName()
						+ "\n" + "�7Motivo: �c�lFlood no tell" + "\n" + "�7Expira em: �c�l2 dias" + "\n"
						+ "�7Data do banimento: �c�l" + HorarioAPI.getHorario() + "\n"
						+ "�fCompre �9�lUNBAN �fem nossa loja: �3�ndefaultmc.com.br" + "\n"
						+ "�fBanimento incorreto? Contate-nos pelo Twitter �b�l@DefaultNT�f!");

				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Nome", vitima.getName());
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Banido por",
						jogador.getName());
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Motivo", "Flood no Tell");
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Tempo do Ban", "2 dias");
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Data do banimento",
						HorarioAPI.getHorario());

				Config.getConfig().saveTempBans();
				Bukkit.getScheduler().scheduleAsyncDelayedTask(SpeedPvP.getPlugin(), new Runnable() {
					public void run() {
						if (Config.getConfig().getTempBans().get("TempBans." + vitima.getUniqueId()) != null) {
							Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId(), null);
							Config.getConfig().saveTempBans();
							API.sendStaff("�6�lPARDON �f" + vitima.getName() + " foi desbanido por: �c�lCONSOLE");
							API.sendMsg(vitima, "�fVoc� foi �6�DESBANIDO �fautomaticamente!");
						}
					}
				}, 3456000L);
				return true;
			}
			if (args[1].equalsIgnoreCase("ffa")) {
				API.sendMsg(jogador,
						"�3�lTEMPBAN �fVoc� baniu �3�lTEMPORARIAMENTE �fo jogador: �6�l" + vitima.getName() + "�f.");
				API.sendStaff("�3�lTEMPBAN �f" + jogador.getName() + " baniu �3�lTEMPORARIAMENTE �fo jogador �6�l"
						+ vitima.getName() + ". Motivo: �c�lFree for all");
				vitima.kickPlayer("�fVoc� foi banido �9�lTEMPORARIAMENTE�f do servidor!" + "\n"
						+ "�7Jogador banido: �c�l" + vitima.getName() + "\n" + "�7Banido por: �c�l" + jogador.getName()
						+ "\n" + "�7Motivo: �c�lFree for all" + "\n" + "�7Expira em: �c�l2 dias" + "\n"
						+ "�7Data do banimento: �c�l" + HorarioAPI.getHorario() + "\n"
						+ "�fCompre �9�lUNBAN �fem nossa loja: �3�defaultmc.com.br" + "\n"
						+ "�fBanimento incorreto? Contate-nos pelo Twitter �b�l@DefaultNT�f!");

				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Nome", vitima.getName());
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Banido por",
						jogador.getName());
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Motivo", "Free for All");
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Tempo do Ban", "2 dias");
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Data do banimento",
						HorarioAPI.getHorario());

				Config.getConfig().saveTempBans();
				Bukkit.getScheduler().scheduleAsyncDelayedTask(SpeedPvP.getPlugin(), new Runnable() {
					public void run() {
						if (Config.getConfig().getTempBans().get("TempBans." + vitima.getUniqueId()) != null) {
							Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId(), null);
							Config.getConfig().saveTempBans();
							API.sendStaff("�6�lPARDON �f" + vitima.getName() + " foi desbanido por: �c�lCONSOLE");
							API.sendMsg(vitima, "�fVoc� foi �6�DESBANIDO �fautomaticamente!");
						}
					}
				}, 3456000L);
				return true;
			}
			if (args[1].equalsIgnoreCase("fkill")) {
				API.sendMsg(jogador,
						"�3�lTEMPBAN �fVoc� baniu �3�lTEMPORARIAMENTE �fo jogador: �6�l" + vitima.getName() + "�f.");
				API.sendStaff("�3�lTEMPBAN �f" + jogador.getName() + " baniu �3�lTEMPORARIAMENTE �fo jogador �6�l"
						+ vitima.getName() + ". Motivo: �c�lFree Kill");
				vitima.kickPlayer("�fVoc� foi banido �9�lTEMPORARIAMENTE�f do servidor!" + "\n"
						+ "�7Jogador banido: �c�l" + vitima.getName() + "\n" + "�7Banido por: �c�l" + jogador.getName()
						+ "\n" + "�7Motivo: �c�lFree kill" + "\n" + "�7Expira em: �c�l4 dias" + "\n"
						+ "�7Data do banimento: �c�l" + HorarioAPI.getHorario() + "\n"
						+ "�fCompre �9�lUNBAN �fem nossa loja: �6�ndefaultmc.com.br" + "\n"
						+ "�fBanimento incorreto? Contate-nos pelo Twitter �b�l@DefaultNT�f!");

				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Nome", vitima.getName());
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Banido por",
						jogador.getName());
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Motivo", "FreeKill");
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Tempo do Ban", "4 dias");
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Data do banimento",
						HorarioAPI.getHorario());

				Config.getConfig().saveTempBans();
				Bukkit.getScheduler().scheduleAsyncDelayedTask(SpeedPvP.getPlugin(), new Runnable() {
					public void run() {
						if (Config.getConfig().getTempBans().get("TempBans." + vitima.getUniqueId()) != null) {
							Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId(), null);
							Config.getConfig().saveTempBans();
							API.sendStaff("�6�lPARDON �f" + vitima.getName() + " foi desbanido por: �c�lCONSOLE");
							API.sendMsg(vitima, "�fVoc� foi �6�DESBANIDO �fautomaticamente!");
						}
					}
				}, 6912000L);
				return true;
			}
			if (args[1].equalsIgnoreCase("ofs")) {
				API.sendMsg(jogador,
						"�3�lTEMPBAN �fVoc� baniu �3�lTEMPORARIAMENTE �fo jogador: �6�l" + vitima.getName() + "�f.");
				API.sendStaff("�3�lTEMPBAN �f" + jogador.getName() + " baniu �3�lTEMPORARIAMENTE �fo jogador �6�l"
						+ vitima.getName() + ". Motivo: �c�lOfensa a Staff");
				vitima.kickPlayer("�fVoc� foi banido �9�lTEMPORARIAMENTE�f do servidor!" + "\n"
						+ "�7Jogador banido: �c�l" + vitima.getName() + "\n" + "�7Banido por: �c�l" + jogador.getName()
						+ "\n" + "�7Motivo: �c�lOfensa a staff" + "\n" + "�7Expira em: �c�l2 dias" + "\n"
						+ "�7Data do banimento: �c�l" + HorarioAPI.getHorario() + "\n"
						+ "�fCompre �9�lUNBAN �fem nossa loja: �6�nldefaultmc.com.br" + "\n"
						+ "�fBanimento incorreto? Contate-nos pelo Twitter �b�l@DefaultNT�f!");

				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Nome", vitima.getName());
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Banido por",
						jogador.getName());
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Motivo",
						"Ofensa a Staffer");
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Tempo do Ban", "4 dias");
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Data do banimento",
						HorarioAPI.getHorario());

				Config.getConfig().saveTempBans();
				Bukkit.getScheduler().scheduleAsyncDelayedTask(SpeedPvP.getPlugin(), new Runnable() {
					public void run() {
						if (Config.getConfig().getTempBans().get("TempBans." + vitima.getUniqueId()) != null) {
							Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId(), null);
							Config.getConfig().saveTempBans();
							API.sendStaff("�6�lPARDON �f" + vitima.getName() + " foi desbanido por: �c�lCONSOLE");
							API.sendMsg(vitima, "�fVoc� foi �6�DESBANIDO �fautomaticamente!");
						}
					}
				}, 6912000L);
				return true;
			}
			if (args[1].equalsIgnoreCase("abug")) {
				API.sendMsg(jogador,
						"�3�lTEMPBAN �fVoc� baniu �3�lTEMPORARIAMENTE �fo jogador: �6�l" + vitima.getName() + "�f.");
				API.sendStaff("�3�lTEMPBAN �f" + jogador.getName() + " baniu �3�lTEMPORARIAMENTE �fo jogador �6�l"
						+ vitima.getName() + ". Motivo: �c�lAbuso de Bugs");
				vitima.kickPlayer("�fVoc� foi banido �9�lTEMPORARIAMENTE�f do servidor!" + "\n"
						+ "�7Jogador banido: �c�l" + vitima.getName() + "\n" + "�7Banido por: �c�l" + jogador.getName()
						+ "\n" + "�7Motivo: �c�lAbuso de Bugs" + "\n" + "�7Expira em: �c�l2 dias" + "\n"
						+ "�7Data do banimento: �c�l" + HorarioAPI.getHorario() + "\n"
						+ "�fCompre �9�lUNBAN �fem nossa loja: �6�ndefaultmc.com.br" + "\n"
						+ "�fBanimento incorreto? Contate-nos pelo Twitter �b�l@DefaultNT�f!");

				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Nome", vitima.getName());
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Banido por",
						jogador.getName());
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Motivo", "Abuso de Bugs");
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Tempo do Ban", "7 dias");
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Data do banimento",
						HorarioAPI.getHorario());

				Config.getConfig().saveTempBans();
				Bukkit.getScheduler().scheduleAsyncDelayedTask(SpeedPvP.getPlugin(), new Runnable() {
					public void run() {
						if (Config.getConfig().getTempBans().get("TempBans." + vitima.getUniqueId()) != null) {
							Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId(), null);
							Config.getConfig().saveTempBans();
							API.sendStaff("�6�lPARDON �f" + vitima.getName() + " foi desbanido por: �c�lCONSOLE");
							API.sendMsg(vitima, "�fVoc� foi �6�DESBANIDO �fautomaticamente!");
						}
					}
				}, 12096000L);
				return true;
			}
			if (args[1].equalsIgnoreCase("tfps")) {
				if (args.length == 2) {
					API.sendMsg(jogador, "�3�lTEMPBAN �fUtilize �3�l/tempban (jogador1) tfps (jogador2)");
					API.sendSound(jogador, Sound.NOTE_PLING, 10);
					return true;
				}
				final Player vitimatime = Bukkit.getPlayer(args[2]);
				if (vitimatime == null) {
					API.sendMsg(jogador, "�cO jogador em quest�o est� offline ou nunca entrou no servidor!");
					API.sendSound(jogador, Sound.NOTE_PLING, 10);
					return true;
				}
				if (vitima.getName() == vitimatime.getName()) {
					API.sendMsg(jogador, "�cAmbos os nicknames devem ser diferentes!");
					API.sendSound(jogador, Sound.NOTE_PLING, 10);
					return true;
				}
				if (Config.getConfig().getTempBans().get("TempBans." + vitimatime.getUniqueId()) != null) {
					API.sendMsg(jogador, "�fO jogador �6�l" + vitimatime.getName() + " �fj� est� �4�lBANIDO�f!");
					API.sendSound(jogador, Sound.NOTE_PLING, 10);
					return true;
				}
				if (Config.getConfig().getIpBans().get("IPBans." + vitimatime.getUniqueId()) != null) {
					API.sendMsg(jogador, "�fO jogador �6�l" + vitimatime.getName() + " �fj� est� �4�lBANIDO�f!");
					API.sendSound(jogador, Sound.NOTE_PLING, 10);
					return true;
				}
				if (Config.getConfig().getBans().get("Bans." + vitimatime.getUniqueId()) != null) {
					API.sendMsg(jogador, "�fO jogador �6�l" + vitimatime.getName() + " �fj� est� �4�lBANIDO�f!");
					API.sendSound(jogador, Sound.NOTE_PLING, 10);
					return true;
				}
				if (vitima.getName() == jogador.getName()) {
					API.sendMsg(jogador, "�cVoc� n�o pode banir a si mesmo!");
					API.sendSound(jogador, Sound.NOTE_PLING, 10);
					return true;
				}
				if (vitimatime.getName() == jogador.getName()) {
					API.sendMsg(jogador, "�cVoc� n�o pode banir a si mesmo!");
					API.sendSound(jogador, Sound.NOTE_PLING, 10);
					return true;
				}
				API.sendMsg(jogador,
						"�3�lTEMPBAN �fVoc� baniu �3�lTEMPORARIAMENTE �fo jogador: �6�l" + vitima.getName() + "�f.");
				API.sendStaff("�3�lTEMPBAN �f" + jogador.getName() + " baniu �3�lTEMPORARIAMENTE �fo jogador �6�l"
						+ vitima.getName() + ". Motivo: �c�lTime na warp Fps");
				vitima.kickPlayer("�fVoc� foi banido �9�lTEMPORARIAMENTE�f do servidor!" + "\n"
						+ "�7Jogador banido: �c�l" + vitima.getName() + "\n" + "�7Banido por: �c�l" + jogador.getName()
						+ "\n" + "�7Motivo: �c�lTime na warp Fps" + "\n" + "�7Expira em: �c�l2 dias" + "\n"
						+ "�7Data do banimento: �c�l" + HorarioAPI.getHorario() + "\n"
						+ "�fCompre �9�lUNBAN �fem nossa loja: �6�ldefaultmc.com.br" + "\n"
						+ "�fBanimento incorreto? Contate-nos pelo Twitter �b�l@DefaultNT�f!");
				vitimatime.kickPlayer("�fVoc� foi banido �9�lTEMPORARIAMENTE�f do servidor!" + "\n"
						+ "�7Jogador banido: �c�l" + vitima.getName() + "\n" + "�7Banido por: �c�l" + jogador.getName()
						+ "\n" + "�7Motivo: �c�lTime na warp Fps" + "\n" + "�7Expira em: �c�l2 dias" + "\n"
						+ "�7Data do banimento: �c�l" + HorarioAPI.getHorario() + "\n"
						+ "�fCompre �9�lUNBAN �fem nossa loja: �6�ldefaultmc.com.br" + "\n"
						+ "�fBanimento incorreto? Contate-nos pelo Twitter �b�l@DefaultNT�f!");

				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Nome", vitima.getName());
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Banido por",
						jogador.getName());
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Motivo", "Time na FPS");
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Tempo do Ban", "2 dias");
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Data do banimento",
						HorarioAPI.getHorario());

				Config.getConfig().getTempBans().set("TempBans." + vitimatime.getUniqueId() + ".Nome",
						vitimatime.getName());
				Config.getConfig().getTempBans().set("TempBans." + vitimatime.getUniqueId() + ".Banido por",
						jogador.getName());
				Config.getConfig().getTempBans().set("TempBans." + vitimatime.getUniqueId() + ".Motivo", "Time na FPS");
				Config.getConfig().getTempBans().set("TempBans." + vitimatime.getUniqueId() + ".Tempo do Ban",
						"2 dias");
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Data do banimento",
						HorarioAPI.getHorario());

				Config.getConfig().saveTempBans();
				Bukkit.getScheduler().scheduleAsyncDelayedTask(SpeedPvP.getPlugin(), new Runnable() {
					public void run() {
						if ((Config.getConfig().getTempBans().get("TempBans." + vitima.getUniqueId()) == null)
								&& (Config.getConfig().getTempBans()
										.get("TempBans." + vitimatime.getUniqueId()) != null)) {
							Config.getConfig().getTempBans().set("TempBans." + vitimatime.getUniqueId(), null);
							Config.getConfig().saveTempBans();
							API.sendBC("�cO jogador " + vitimatime.getName() + " foi desbanido automaticamente.");
							API.sendStaff("�7O jogador " + vitimatime.getName() + " foi desbanido automaticamente");
						} else if ((Config.getConfig().getTempBans().get("TempBans." + vitima.getUniqueId()) != null)
								&& (Config.getConfig().getTempBans()
										.get("TempBans." + vitimatime.getUniqueId()) == null)) {
							Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId(), null);
							Config.getConfig().saveTempBans();
							API.sendBC("�cO jogador " + vitima.getName() + " foi desbanido automaticamente");
							API.sendStaff("�7O jogador " + vitima.getName() + " foi desbanido automaticamente");
						} else if ((Config.getConfig().getTempBans().get("TempBans." + vitima.getUniqueId()) != null)
								&& (Config.getConfig().getTempBans()
										.get("TempBans." + vitimatime.getUniqueId()) != null)) {
							Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId(), null);
							Config.getConfig().getTempBans().set("TempBans." + vitimatime.getUniqueId(), null);
							Config.getConfig().saveTempBans();
							API.sendStaff("�c" + vitima.getName() + " e " + vitimatime.getName()
									+ " foram desbanidos pelo CONSOLE");
						}
					}
				}, 3456000L);
				return true;
			}
			if (args[1].equalsIgnoreCase("oftell")) {
				API.sendMsg(jogador,
						"�3�lTEMPBAN �fVoc� baniu �3�lTEMPORARIAMENTE �fo jogador: �6�l" + vitima.getName() + "�f.");
				API.sendStaff("�3�lTEMPBAN �f" + jogador.getName() + " baniu �3�lTEMPORARIAMENTE �fo jogador �6�l"
						+ vitima.getName() + ". Motivo: �c�lOfensa por Tell");
				;
				vitima.kickPlayer("�fVoc� foi banido �9�lTEMPORARIAMENTE�f do servidor!" + "\n"
						+ "�7Jogador banido: �c�l" + vitima.getName() + "\n" + "�7Banido por: �c�l" + jogador.getName()
						+ "\n" + "�7Motivo: �c�lOfensa por tell" + "\n" + "�7Expira em: �c�l2 dias" + "\n"
						+ "�7Data do banimento: �c�l" + HorarioAPI.getHorario() + "\n"
						+ "�fCompre �9�lUNBAN �fem nossa loja: �6�ldefaultmc.com.br" + "\n"
						+ "�fBanimento incorreto? Contate-nos pelo Twitter �b�l@DefaultNT�f!");

				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Nome", vitima.getName());
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Banido por",
						jogador.getName());
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Motivo",
						"Ofensa pelo Tell");
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Tempo do Ban", "2 dias");
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Data do banimento",
						HorarioAPI.getHorario());

				Config.getConfig().saveTempBans();
				Bukkit.getScheduler().scheduleAsyncDelayedTask(SpeedPvP.getPlugin(), new Runnable() {
					public void run() {
						if (Config.getConfig().getTempBans().get("TempBans." + vitima.getUniqueId()) != null) {
							Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId(), null);
							API.sendStaff("�6�lPARDON �f" + vitima.getName() + " foi desbanido por: �c�lCONSOLE");
							API.sendMsg(vitima, "�fVoc� foi �6�DESBANIDO �fautomaticamente!");
						}
					}
				}, 3456000L);
				return true;
			}
			if (args[1].equalsIgnoreCase("citlink")) {
				API.sendMsg(jogador,
						"�3�lTEMPBAN �fVoc� baniu �3�lTEMPORARIAMENTE �fo jogador: �6�l" + vitima.getName() + "�f.");
				API.sendStaff("�3�lTEMPBAN �f" + jogador.getName() + " baniu �3�lTEMPORARIAMENTE �fo jogador �6�l"
						+ vitima.getName() + ". Motivo: �c�lCita��o de links externos");
				vitima.kickPlayer("�fVoc� foi banido �9�lTEMPORARIAMENTE�f do servidor!" + "\n"
						+ "�7Jogador banido: �c�l" + vitima.getName() + "\n" + "�7Banido por: �c�l" + jogador.getName()
						+ "\n" + "�7Motivo: �c�lCita��o de links externos" + "\n" + "�7Expira em: �c�l2 dias" + "\n"
						+ "�7Data do banimento: �c�l" + HorarioAPI.getHorario() + "\n"
						+ "�fCompre �9�lUNBAN �fem nossa loja: �6�ldefaultmc.com.br" + "\n"
						+ "�fBanimento incorreto? Contate-nos pelo Twitter �b�l@DefaultNT�f!");

				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Nome", vitima.getName());
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Banido por",
						jogador.getName());
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Motivo",
						"Citar links externos");
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Tempo do Ban", "2 dias");
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Data do banimento",
						HorarioAPI.getHorario());

				Config.getConfig().saveTempBans();
				Bukkit.getScheduler().scheduleAsyncDelayedTask(SpeedPvP.getPlugin(), new Runnable() {
					public void run() {
						if (Config.getConfig().getTempBans().get("TempBans." + vitima.getUniqueId()) != null) {
							Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId(), null);
							Config.getConfig().saveTempBans();
							API.sendStaff("�6�lPARDON �f" + vitima.getName() + " foi desbanido por: �c�lCONSOLE");
							API.sendMsg(vitima, "�fVoc� foi �6�DESBANIDO �fautomaticamente!");
						}
					}
				}, 3456000L);
				return true;
			}
			if (args[1].equalsIgnoreCase("fident")) {
				API.sendMsg(jogador,
						"�3�lTEMPBAN �fVoc� baniu �3�lTEMPORARIAMENTE �fo jogador: �6�l" + vitima.getName() + "�f.");
				API.sendStaff("�3�lTEMPBAN �f" + jogador.getName() + " baniu �3�lTEMPORARIAMENTE �fo jogador �6�l"
						+ vitima.getName() + ". Motivo: �c�lFalsidade ideol�gica");
				vitima.kickPlayer("�fVoc� foi banido �9�lTEMPORARIAMENTE�f do servidor!" + "\n"
						+ "�7Jogador banido: �c�l" + vitima.getName() + "\n" + "�7Banido por: �c�l" + jogador.getName()
						+ "\n" + "�7Motivo: �c�lFalsidade ideol�gica" + "\n" + "�7Expira em: �c�l2 dias" + "\n"
						+ "�7Data do banimento: �c�l" + HorarioAPI.getHorario() + "\n"
						+ "�fCompre �9�lUNBAN �fem nossa loja: �6�ldefaultmc.com.br" + "\n"
						+ "�fBanimento incorreto? Contate-nos pelo Twitter �b�l@DefaultNT�f!");

				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Nome", vitima.getName());
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Banido por",
						jogador.getName());
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Motivo",
						"Falsa identidade");
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Tempo do Ban", "7 dias");
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Data do banimento",
						HorarioAPI.getHorario());

				Config.getConfig().saveTempBans();
				Bukkit.getScheduler().scheduleAsyncDelayedTask(SpeedPvP.getPlugin(), new Runnable() {
					public void run() {
						if (Config.getConfig().getTempBans().get("TempBans." + vitima.getUniqueId()) != null) {
							Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId(), null);
							Config.getConfig().saveTempBans();
							API.sendStaff("�6�lPARDON �f" + vitima.getName() + " foi desbanido por: �c�lCONSOLE");
							API.sendMsg(vitima, "�fVoc� foi �6�DESBANIDO �fautomaticamente!");
						}
					}
				}, 12096000L);
				return true;
			}
			API.sendMsg(jogador, "�3�lTEMPBAN �fUtilize �3�l/tempban �3(jogador) (sigla)");
			API.sendMsg(jogador, " ");
			API.sendMsg(jogador, "�2�lSIGLAS �fAbaixo segue a lista de siglas e seus significados...");
			API.sendMsg(jogador, " ");
			API.sendMsg(jogador, "�6� �3�lftell �f- �8(Flood no tell)");
			API.sendMsg(jogador, "�6� �3�lffa �f- �8(Free for all)");
			API.sendMsg(jogador, "�6� �3�ltfps �f- �8(Time na fps)");
			API.sendMsg(jogador, "�6� �3�lfkill �f- �8(Freekill)");
			API.sendMsg(jogador, "�6� �3�lofs �f- �8(Ofensa a staff)");
			API.sendMsg(jogador, "�6� �3�loftell �f- �8(Ofensa pelo tell)");
			API.sendMsg(jogador, "�6� �3�labug �f- �8(Abuso de bugs)");
			API.sendMsg(jogador, "�6� �3�lcitlink �f- �8(Cita��o de links externos)");
			API.sendMsg(jogador, "�6� �3�lident �f- �8(Falsidade ideol�gica)");
			API.sendSound(jogador, Sound.NOTE_PLING, 10);
			return true;
		}
		return false;
	}
}
