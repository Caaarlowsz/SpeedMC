package me.thauandev.bans;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thauandev.API.HorarioAPI;
import me.thauandev.configuração.cfGrupo;
import me.thauandev.main.Main;

public class TempMuteCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player)) {
			return true;
		}
		Player jogador = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("tempmute")) {
			if ((!cfGrupo.ChecarGrupo(jogador, "Dono") && (!cfGrupo.ChecarGrupo(jogador, "Gerente") && (!cfGrupo
					.ChecarGrupo(jogador, "Admin")
					&& (!cfGrupo.ChecarGrupo(jogador, "Mod+") && (!cfGrupo.ChecarGrupo(jogador, "Mod")
							&& (!cfGrupo.ChecarGrupo(jogador, "Trial") && (!cfGrupo.ChecarGrupo(jogador, "Youtuber+")
									&& (!cfGrupo.ChecarGrupo(jogador, "Helper")))))))))) {
				API.sendMsg(jogador, "§c§l(!) §cVocê não possui permissão para utilizar este comando!");
				return true;
			}
			if (args.length == 0) {
				API.sendMsg(jogador, "§b§lTEMPMUTE §fUtilize §b§l/tempmute §b(jogador) (sigla)");
				API.sendMsg(jogador, " ");
				API.sendMsg(jogador, "§2§lSIGLAS §fAbaixo segue a lista de siglas e seus significados...");
				API.sendMsg(jogador, " ");
				API.sendMsg(jogador, "§6• §3§lflood §f- §8(Floodar os chats do servidor) ");
				API.sendMsg(jogador,
						"§6• §3§lpdvip §f- §8(Solicitar VIP para algum membro da equipe sem qualquer propósito) ");
				API.sendMsg(jogador,
						"§6• §3§lpdstaff §f- §8(Solicitar algum cargo na equipe sem a necessidade de formulários) ");
				API.sendMsg(jogador, "§6• §3§lofj §f- §8(Ofensa aos jogadores)");
				API.sendMsg(jogador,
						"§6• §3§lcitch §f- §8(Citar qualquer canal do Youtube com o intuito de divulgar o próprio ou terceiros)");
				API.sendMsg(jogador, "§6• §3§lcitsv §f- §8(Citar o nome de qualquer outro servidor)");
				API.sendMsg(jogador,
						"§6• §3§lcomercio §f- §8(Comercialização: Venda ou troca de produtos materiais ou virtuais)");
				API.sendMsg(jogador,
						"§6• §3§lspam §f- §8(Spammar nos chats do servidor. Falar coisas sem fundamento com a finalidade de atingir)");
				API.sendMsg(jogador,
						"§6• §3§lcplk §f- §8(Falar continuamente com a tecla Caps-Lock ativada, mesmo após alguma advertência)");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			final Player vitima = Bukkit.getPlayer(args[0]);
			if (vitima == null) {
				API.sendMsg(jogador, "§cO jogador em questão está offline ou nunca entrou no servidor!");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			if (vitima.getName() == jogador.getName()) {
				API.sendMsg(jogador, "§cVocê não pode mutar a si mesmo!");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			if (Config.getConfig().getMute().get("Mute." + vitima.getUniqueId()) != null) {
				API.sendMsg(jogador, "§fO jogador §6§l" + vitima.getName() + "§f já está §9§lMUTADO§f!");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			if (Config.getConfig().getTempMute().get("TempMute." + vitima.getUniqueId()) != null) {
				API.sendMsg(jogador, "§fO jogador §6§l" + vitima.getName() + " §fjá está §9§lMUTADO§f! ");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			if (args.length == 1) {
				API.sendMsg(jogador, "§b§lTEMPMUTE §fUtilize §b§l/tempmute §b(jogador) (sigla)");
				API.sendMsg(jogador, " ");
				API.sendMsg(jogador, "§2§lSILAS §fAbaixo segue a lista de siglas e seus significados...");
				API.sendMsg(jogador, " ");
				API.sendMsg(jogador, "§6• §3§lflood §f- §8(Floodar os chats do servidor) ");
				API.sendMsg(jogador,
						"§6• §3§lpdvip §f- §8(Solicitar VIP para algum membro da equipe sem qualquer propósito) ");
				API.sendMsg(jogador,
						"§6• §3§lpdstaff §f- §8(Solicitar algum cargo na equipe sem a necessidade de formulários) ");
				API.sendMsg(jogador, "§6• §3§lofj §f- §8(Ofensa aos jogadores)");
				API.sendMsg(jogador,
						"§6• §3§lcitch §f- §8(Citar qualquer canal do Youtube com o intuito de divulgar o próprio ou terceiros)");
				API.sendMsg(jogador, "§6• §3§lcitsv §f- §8(Citar o nome de qualquer outro servidor)");
				API.sendMsg(jogador,
						"§6• §3§lcomercio §f- §8(Comercialização: Venda ou troca de produtos materiais ou virtuais)");
				API.sendMsg(jogador,
						"§6• §3§lspam §f- §8(Spammar nos chats do servidor. Falar coisas sem fundamento; com a finalidade de atingir)");
				API.sendMsg(jogador,
						"§6• §3§lcplk §f- §8(Falar continuamente com a tecla Caps-Lock ativada, mesmo após alguma advertência)");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			if (args[1].equalsIgnoreCase("flood")) {
				API.sendMsg(jogador, "§b§lTEMPMUTE §fVocê mutou o jogador §6§l" + vitima.getName()
						+ " §b§lTEMPORARIAMENTE§f. Motivo: §c§lFlood");
				API.sendStaff("§b§lTEMPMUTE §f" + jogador.getName() + " mutou o jogador §6§l" + vitima.getName()
						+ "§b§l TEMPORARIAMENTE§f. Motivo: §c§lFlood");
				API.sendMsg(vitima, "§b§lTEMPMUTE §fVocê foi §b§lMUTADO TEMPORARIAMENTE§f. Por: §4§l"
						+ jogador.getName() + "§f. Motivo §c§lFlood§f.");
				API.sendMsg(vitima, "§b§lTEMPMUTE §fO seu §b§lTEMPMUTE §facaba em §3§l2 dias§f.");

				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Nome", vitima.getName());
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Mutado por",
						jogador.getName());
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Motivo", "Flood");
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Tempo do Mute", "2 dias");
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Data do mute",
						HorarioAPI.getHorario());
				Config.getConfig().saveTempMute();
				Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), new Runnable() {
					public void run() {
						if (Config.getConfig().getTempMute().get("TempMute." + vitima.getUniqueId()) != null) {
							API.sendStaff("§6§lPARDON §f" + vitima.getName() + " foi desmutado por: §c§lCONSOLE");
							API.sendMsg(vitima, "§fVocê foi §6§lDESMUTADO §fautomaticamente!");
							Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId(), null);
							Config.getConfig().saveTempMute();
						}
					}
				}, 3456000L);
				return true;
			}
			if (args[1].equalsIgnoreCase("pdvip")) {
				API.sendMsg(jogador, "§b§lTEMPMUTE §fVocê mutou o jogador §6§l" + vitima.getName()
						+ " §b§lTEMPORARIAMENTE§f. Motivo: §c§lPedir Vip");
				API.sendStaff("§b§lTEMPMUTE §f" + jogador.getName() + " mutou o jogador §6§l" + vitima.getName()
						+ "§b§l TEMPORARIAMENTE§f. Motivo: §c§l");
				API.sendMsg(vitima, "§b§lTEMPMUTE §fVocê foi §b§lMUTADO TEMPORARIAMENTE§f. Por: §4§l"
						+ jogador.getName() + "§f. Motivo §c§lPedir Vip§f.");
				API.sendMsg(vitima, "§b§lTEMPMUTE §fO seu §b§lTEMPMUTE §facaba em §3§l2 dias§f.");

				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Nome", vitima.getName());
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Mutado por",
						jogador.getName());
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Motivo", "Pedir VIP");
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Tempo do Mute", "2 dias");
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Data do mute",
						HorarioAPI.getHorario());
				Config.getConfig().saveTempMute();
				Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), new Runnable() {
					public void run() {
						if (Config.getConfig().getTempMute().get("TempMute." + vitima.getUniqueId()) != null) {
							API.sendStaff("§6§lPARDON §f" + vitima.getName() + " foi desmutado por: §c§lCONSOLE");
							API.sendMsg(vitima, "§fVocê foi §6§lDESMUTADO §fautomaticamente!");
							Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId(), null);
							Config.getConfig().saveTempMute();
						}
					}
				}, 3456000L);
				return true;
			}
			if (args[1].equalsIgnoreCase("pdstaff")) {
				API.sendMsg(jogador, "§b§lTEMPMUTE §fVocê mutou o jogador §6§l" + vitima.getName()
						+ " §b§lTEMPORARIAMENTE§f. Motivo: §c§lPedir Staff");
				API.sendStaff("§b§lTEMPMUTE §f" + jogador.getName() + " mutou o jogador §6§l" + vitima.getName()
						+ "§b§l TEMPORARIAMENTE§f. Motivo: §c§lPedir Staff");
				API.sendMsg(vitima, "§b§lTEMPMUTE §fVocê foi §b§lMUTADO TEMPORARIAMENTE§f. Por: §4§l"
						+ jogador.getName() + "§f. Motivo §c§lPedir Staff§f.");
				API.sendMsg(vitima, "§b§lTEMPMUTE §fO seu §b§lTEMPMUTE §facaba em §3§l3 dias§f.");

				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Nome", vitima.getName());
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Mutado por",
						jogador.getName());
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Motivo", "Pedir Staff");
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Tempo do Mute", "3 dias");
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Data do mute",
						HorarioAPI.getHorario());
				Config.getConfig().saveTempMute();
				Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), new Runnable() {
					public void run() {
						if (Config.getConfig().getTempMute().get("TempMute." + vitima.getUniqueId()) != null) {
							API.sendStaff("§6§lPARDON §f" + vitima.getName() + " foi desmutado por: §c§lCONSOLE");
							API.sendMsg(vitima, "§fVocê foi §6§lDESMUTADO §fautomaticamente!");
							Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId(), null);
							Config.getConfig().saveTempMute();
						}
					}
				}, 5184000L);
				return true;
			}
			if (args[1].equalsIgnoreCase("ofj")) {
				API.sendMsg(jogador, "§b§lTEMPMUTE §fVocê mutou o jogador §6§l" + vitima.getName()
						+ " §b§lTEMPORARIAMENTE§f. Motivo: §c§lOfensa a Jogador");
				API.sendStaff("§b§lTEMPMUTE §f" + jogador.getName() + " mutou o jogador §6§l" + vitima.getName()
						+ "§b§l TEMPORARIAMENTE§f. Motivo: §c§lOfensa a Jogador");
				API.sendMsg(vitima, "§b§lTEMPMUTE §fVocê foi §b§lMUTADO TEMPORARIAMENTE§f. Por: §4§l"
						+ jogador.getName() + "§f. Motivo §c§lOfensa a Jogador§f.");
				API.sendMsg(vitima, "§b§lTEMPMUTE §fO seu §b§lTEMPMUTE §facaba em §3§l2 dias§f.");

				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Nome", vitima.getName());
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Mutado por",
						jogador.getName());
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Motivo",
						"Ofensa a Jogador(es)");
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Tempo do Mute", "2 dias");
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Data do mute",
						HorarioAPI.getHorario());
				Config.getConfig().saveTempMute();
				Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), new Runnable() {
					public void run() {
						if (Config.getConfig().getTempMute().get("TempMute." + vitima.getUniqueId()) != null) {
							API.sendStaff("§6§lPARDON §f" + vitima.getName() + " foi desmutado por: §c§lCONSOLE");
							API.sendMsg(vitima, "§fVocê foi §6§lDESMUTADO §fautomaticamente!");
							Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId(), null);
							Config.getConfig().saveTempMute();
						}
					}
				}, 3456000L);
				return true;
			}
			if (args[1].equalsIgnoreCase("citch")) {
				API.sendMsg(jogador, "§b§lTEMPMUTE §fVocê mutou o jogador §6§l" + vitima.getName()
						+ " §b§lTEMPORARIAMENTE§f. Motivo: §c§lCitação de Canais");
				API.sendStaff("§b§lTEMPMUTE §f" + jogador.getName() + " mutou o jogador §6§l" + vitima.getName()
						+ "§b§l TEMPORARIAMENTE§f. Motivo: §c§lCitação de Canais");
				API.sendMsg(vitima, "§b§lTEMPMUTE §fVocê foi §b§lMUTADO TEMPORARIAMENTE§f. Por: §4§l"
						+ jogador.getName() + "§f. Motivo §c§lCitação de Canais§f.");
				API.sendMsg(vitima, "§b§lTEMPMUTE §fO seu §b§lTEMPMUTE §facaba em §3§l2 dias§f.");

				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Nome", vitima.getName());
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Mutado por",
						jogador.getName());
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Motivo", "Citar canais");
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Tempo do Mute", "2 dias");
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Data do mute",
						HorarioAPI.getHorario());
				Config.getConfig().saveTempMute();
				Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), new Runnable() {
					public void run() {
						if (Config.getConfig().getTempMute().get("TempMute." + vitima.getUniqueId()) != null) {
							API.sendStaff("§6§lPARDON §f" + vitima.getName() + " foi desmutado por: §c§lCONSOLE");
							API.sendMsg(vitima, "§fVocê foi §6§lDESMUTADO §fautomaticamente!");
							Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId(), null);
							Config.getConfig().saveTempMute();
						}
					}
				}, 3456000L);
				return true;
			}
			if (args[1].equalsIgnoreCase("citsv")) {
				API.sendMsg(jogador, "§b§lTEMPMUTE §fVocê mutou o jogador §6§l" + vitima.getName()
						+ " §b§lTEMPORARIAMENTE§f. Motivo: §c§lCitação de Servidores");
				API.sendStaff("§b§lTEMPMUTE §f" + jogador.getName() + " mutou o jogador §6§l" + vitima.getName()
						+ "§b§l TEMPORARIAMENTE§f. Motivo: §c§lCitação de Servidores");
				API.sendMsg(vitima, "§b§lTEMPMUTE §fVocê foi §b§lMUTADO TEMPORARIAMENTE§f. Por: §4§l"
						+ jogador.getName() + "§f. Motivo §c§lCitação de Servidores§f.");
				API.sendMsg(vitima, "§b§lTEMPMUTE §fO seu §b§lTEMPMUTE §facaba em §3§l2 dias§f.");

				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Nome", vitima.getName());
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Mutado por",
						jogador.getName());
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Motivo",
						"Citar servidores");
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Tempo do Mute", "2 dias");
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Data do mute",
						HorarioAPI.getHorario());
				Config.getConfig().saveTempMute();
				Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), new Runnable() {
					public void run() {
						if (Config.getConfig().getTempMute().get("TempMute." + vitima.getUniqueId()) != null) {
							API.sendStaff("§6§lPARDON §f" + vitima.getName() + " foi desmutado por: §c§lCONSOLE");
							API.sendMsg(vitima, "§fVocê foi §6§lDESMUTADO §fautomaticamente!");
							Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId(), null);
							Config.getConfig().saveTempMute();
						}
					}
				}, 3456000L);
				return true;
			}
			if (args[1].equalsIgnoreCase("comercio")) {
				API.sendMsg(jogador, "§b§lTEMPMUTE §fVocê mutou o jogador §6§l" + vitima.getName()
						+ " §b§lTEMPORARIAMENTE§f. Motivo: §c§lComercialização");
				API.sendStaff("§b§lTEMPMUTE §f" + jogador.getName() + " mutou o jogador §6§l" + vitima.getName()
						+ "§b§l TEMPORARIAMENTE§f. Motivo: §c§lComercialização");
				API.sendMsg(vitima, "§b§lTEMPMUTE §fVocê foi §b§lMUTADO TEMPORARIAMENTE§f. Por: §4§l"
						+ jogador.getName() + "§f. Motivo §c§lComercialização§f.");
				API.sendMsg(vitima, "§b§lTEMPMUTE §fO seu §b§lTEMPMUTE §facaba em §3§l2 dias§f.");

				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Nome", vitima.getName());
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Mutado por",
						jogador.getName());
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Motivo",
						"Comercio no servidor");
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Tempo do Mute", "2 dias");
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Data do mute",
						HorarioAPI.getHorario());
				Config.getConfig().saveTempMute();
				Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), new Runnable() {
					public void run() {
						if (Config.getConfig().getTempMute().get("TempMute." + vitima.getUniqueId()) != null) {
							API.sendStaff("§6§lPARDON §f" + vitima.getName() + " foi desmutado por: §c§lCONSOLE");
							API.sendMsg(vitima, "§fVocê foi §6§lDESMUTADO §fautomaticamente!");
							Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId(), null);
							Config.getConfig().saveTempMute();
						}
					}
				}, 3456000L);
				return true;
			}
			if (args[1].equalsIgnoreCase("spam")) {
				API.sendMsg(jogador, "§b§lTEMPMUTE §fVocê mutou o jogador §6§l" + vitima.getName()
						+ " §b§lTEMPORARIAMENTE§f. Motivo: §c§lSpam");
				API.sendStaff("§b§lTEMPMUTE §f" + jogador.getName() + " mutou o jogador §6§l" + vitima.getName()
						+ "§b§l TEMPORARIAMENTE§f. Motivo: §c§lSpam");
				API.sendMsg(vitima, "§b§lTEMPMUTE §fVocê foi §b§lMUTADO TEMPORARIAMENTE§f. Por: §4§l"
						+ jogador.getName() + "§f. Motivo §c§lSpam§f.");
				API.sendMsg(vitima, "§b§lTEMPMUTE §fO seu §b§lTEMPMUTE §facaba em §3§l2 dias§f.");

				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Nome", vitima.getName());
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Mutado por",
						jogador.getName());
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Motivo", "Spam");
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Tempo do Mute", "2 dias");
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Data do mute",
						HorarioAPI.getHorario());
				Config.getConfig().saveTempMute();
				Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), new Runnable() {
					public void run() {
						if (Config.getConfig().getTempMute().get("TempMute." + vitima.getUniqueId()) != null) {
							API.sendStaff("§6§lPARDON §f" + vitima.getName() + " foi desmutado por: §c§lCONSOLE");
							API.sendMsg(vitima, "§fVocê foi §6§lDESMUTADO §fautomaticamente!");
							Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId(), null);
							Config.getConfig().saveTempMute();
						}
					}
				}, 3456000L);
				return true;
			}
			if (args[1].equalsIgnoreCase("caps")) {
				API.sendMsg(jogador, "§b§lTEMPMUTE §fVocê mutou o jogador §6§l" + vitima.getName()
						+ " §b§lTEMPORARIAMENTE§f. Motivo: §c§lCaps-Lock");
				API.sendStaff("§b§lTEMPMUTE §f" + jogador.getName() + " mutou o jogador §6§l" + vitima.getName()
						+ "§b§l TEMPORARIAMENTE§f. Motivo: §c§lCaps-Lock");
				API.sendMsg(vitima, "§b§lTEMPMUTE §fVocê foi §b§lMUTADO TEMPORARIAMENTE§f. Por: §4§l"
						+ jogador.getName() + "§f. Motivo §c§lCaps-Lock§f.");
				API.sendMsg(vitima, "§b§lTEMPMUTE §fO seu §b§lTEMPMUTE §facaba em §3§l2 dias§f.");

				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Nome", vitima.getName());
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Mutado por",
						jogador.getName());
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Motivo", "CapsLock");
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Tempo do Mute", "2 dias");
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Data do mute",
						HorarioAPI.getHorario());
				Config.getConfig().saveTempMute();
				Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), new Runnable() {
					public void run() {
						if (Config.getConfig().getTempMute().get("TempMute." + vitima.getUniqueId()) != null) {
							API.sendStaff("§6§lPARDON §f" + vitima.getName() + " foi desmutado por: §c§lCONSOLE");
							API.sendMsg(vitima, "§fVocê foi §6§lDESMUTADO §fautomaticamente!");
							Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId(), null);
							Config.getConfig().saveTempMute();
						}
					}
				}, 3456000L);
				return true;
			}
			API.sendMsg(jogador, "§b§lTEMPMUTE §fUtilize §b§l/tempmute §b(jogador) (sigla)");
			API.sendMsg(jogador, " ");
			API.sendMsg(jogador, "§2§lSILAS §fAbaixo segue a lista de siglas e seus significados...");
			API.sendMsg(jogador, " ");
			API.sendMsg(jogador, "§6• §3§lflood §f- §8(Floodar os chats do servidor) ");
			API.sendMsg(jogador,
					"§6• §3§lpdvip §f- §8(Solicitar VIP para algum membro da equipe sem qualquer propósito) ");
			API.sendMsg(jogador,
					"§6• §3§lpdstaff §f- §8(Solicitar algum cargo na equipe sem a necessidade de formulários) ");
			API.sendMsg(jogador, "§6• §3§lofj §f- §8(Ofensa aos jogadores)");
			API.sendMsg(jogador,
					"§6• §3§lcitch §f- §8(Citar qualquer canal do Youtube com o intuito de divulgar o próprio ou terceiros)");
			API.sendMsg(jogador, "§6• §3§lcitsv §f- §8(Citar o nome de qualquer outro servidor)");
			API.sendMsg(jogador,
					"§6• §3§lcomercio §f- §8(Comercialização: Venda ou troca de produtos materiais ou virtuais)");
			API.sendMsg(jogador,
					"§6• §3§lspam §f- §8(Spammar nos chats do servidor. Falar coisas sem fundamento; com a finalidade de atingir)");
			API.sendMsg(jogador,
					"§6• §3§lcplk §f- §8(Falar continuamente com a tecla Caps-Lock ativada, mesmo após alguma advertência)");
			API.sendSound(jogador, Sound.NOTE_PLING, 10);
			return true;
		}

		return false;
	}
}
