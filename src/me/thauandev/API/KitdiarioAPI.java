package me.thauandev.API;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.thauandev.API.CalendarioAPI.Calendario;
��o.cfGrupo;
import me.thauandev.configura��o.cfKitdiario;
��o.cfPermiss�o;
import com.github.caaarlowsz.speedmc.kitpvp.SpeedPvP;

public class KitdiarioAPI {

	public static void iniciarContagem(Player p) {

		Bukkit.getScheduler().scheduleSyncRepeatingTask(SpeedPvP.getPlugin(), new Runnable() {
			public void run() {

				if (cfKitdiario.pegargrupo().get("kitdiario." + p.getUniqueId() + ".dia") != null) {
					if ((CalendarioAPI.PegarCalendario(Calendario.Dia) > cfKitdiario.pegargrupo()
							.getInt("kitdiario." + p.getUniqueId() + ".dia") + 1)
							|| (CalendarioAPI.PegarCalendario(Calendario.Dia) == cfKitdiario.pegargrupo()
									.getInt("kitdiario." + p.getUniqueId() + ".dia") + 1)) {

						if (cfKitdiario.pegargrupo().get("kitdiario." + p.getUniqueId() + ".kit").equals("Ajnin")) {
							cfPermiss�o.setarPermissao(p, "kit.ajnin", "false");
						}
						if (cfKitdiario.pegargrupo().get("kitdiario." + p.getUniqueId() + ".kit").equals("Monk")) {
							cfPermiss�o.setarPermissao(p, "kit.monk", "false");
						}
						if (cfKitdiario.pegargrupo().get("kitdiario." + p.getUniqueId() + ".kit").equals("Hulk")) {
							cfPermiss�o.setarPermissao(p, "kit.hulk", "false");
						}
						if (cfKitdiario.pegargrupo().get("kitdiario." + p.getUniqueId() + ".kit").equals("Timelord")) {
							cfPermiss�o.setarPermissao(p, "kit.timelord", "false");
						}
						if (cfKitdiario.pegargrupo().get("kitdiario." + p.getUniqueId() + ".kit").equals("Grappler")) {
							cfPermiss�o.setarPermissao(p, "kit.grappler", "false");
						}
						if (cfKitdiario.pegargrupo().get("kitdiario." + p.getUniqueId() + ".kit").equals("Phantom")) {
							cfPermiss�o.setarPermissao(p, "kit.phantom", "false");
						}
						if (cfKitdiario.pegargrupo().get("kitdiario." + p.getUniqueId() + ".kit").equals("Ninja")) {
							cfPermiss�o.setarPermissao(p, "kit.ninja", "false");
						}
						if (cfKitdiario.pegargrupo().get("kitdiario." + p.getUniqueId() + ".kit").equals("Viper")) {
							cfPermiss�o.setarPermissao(p, "kit.viper", "false");
						}
						if (cfKitdiario.pegargrupo().get("kitdiario." + p.getUniqueId() + ".kit").equals("Snail")) {
							cfPermiss�o.setarPermissao(p, "kit.snail", "false");
						}
						if (cfKitdiario.pegargrupo().get("kitdiario." + p.getUniqueId() + ".kit").equals("Magma")) {
							cfPermiss�o.setarPermissao(p, "kit.magma", "false");
						}
						cfPermiss�o.salvarconfiguracao();
						cfKitdiario.pegargrupo().set("kitdiario." + p.getUniqueId() + ".Nick", null);
						cfKitdiario.pegargrupo().set("kitdiario." + p.getUniqueId() + ".kit", null);
						cfKitdiario.pegargrupo().set("kitdiario." + p.getUniqueId() + ".dia", null);
						cfKitdiario.pegargrupo().set("kitdiario." + p.getUniqueId() + ".hora", null);
						cfKitdiario.pegargrupo().set("kitdiario." + p.getUniqueId() + ".minuto", null);
						cfKitdiario.pegargrupo().set("kitdiario." + p.getUniqueId() + ".segundos", null);
						cfKitdiario.salvarconfiguracao();
					}
				}
			}
		}, 0L, 20L);
	}

	public static void kitdiario(Player p) {

		if (!cfGrupo.ChecarGrupo(p, "Membro") && !cfGrupo.ChecarGrupo(p, "Light") && !cfGrupo.ChecarGrupo(p, "Mvp")
				&& !cfGrupo.ChecarGrupo(p, "Trial")) {
			p.sendMessage("�c�lSPEED�f�lMC �fVoc� j� possui �ftodos os �9�lKITS�f!");
			return;
		}

		Random random = new Random();
		if ((cfPermiss�o.getPermissao(p, "kit.monk") && (cfPermiss�o.getPermissao(p, "kit.ajnin") && (cfPermiss�o
				.getPermissao(p, "kit.hulk")
				&& (cfPermiss�o.getPermissao(p, "kit.gladiator") && (cfPermiss�o.getPermissao(p, "kit.timelord")
						&& (cfPermiss�o.getPermissao(p, "kit.grappler") && (cfPermiss�o.getPermissao(p, "kit.phantom")
								&& (cfPermiss�o.getPermissao(p, "kit.ninja")
										&& (cfPermiss�o.getPermissao(p, "kit.viper")
												&& (cfPermiss�o.getPermissao(p, "kit.snail")
														&& (cfPermiss�o.getPermissao(p, "kit.magma"))))))))))))) {
			p.sendMessage("�c�lSPEED�f�lMC �fVoc� j� �a�lPOSSUI �ftodos os �9�lKITS�f!");
		} else {

			switch (random.nextInt(11)) {

			case 1:
				p.sendMessage("�c�lSPEED�f�lMC �fVoc� recebeu o kit: �3�lMONK");
				cfPermiss�o.setarPermissao(p, "kit.monk", "true");

				cfKitdiario.setarTempo(p, "Monk");
				iniciarContagem(p);
				break;
			case 2:

				p.sendMessage("�c�lSPEED�f�lMC �fVoc� recebeu o kit: �3�lAJNIN");
				cfPermiss�o.setarPermissao(p, "kit.ajnin", "true");

				cfKitdiario.setarTempo(p, "Ajnin");
				iniciarContagem(p);
				break;
			case 3:

				p.sendMessage("�c�lSPEED�f�lMC �fVoc� recebeu o kit: �3�lHULK");
				cfPermiss�o.setarPermissao(p, "kit.hulk", "true");

				cfKitdiario.setarTempo(p, "Hulk");
				iniciarContagem(p);
				break;
			case 4:

				p.sendMessage("�c�lSPEED�f�lMC �fVoc� recebeu o kit: �3�lTIMELORD");
				cfPermiss�o.setarPermissao(p, "kit.timelord", "true");

				cfKitdiario.setarTempo(p, "Timelord");
				iniciarContagem(p);
				break;
			case 5:

				p.sendMessage("�c�lSPEED�f�lMC �fVoc� recebeu o kit: �3�lGRAPPLER");
				cfPermiss�o.setarPermissao(p, "kit.grappler", "true");

				cfKitdiario.setarTempo(p, "Grappler");
				iniciarContagem(p);
				break;
			case 6:

				p.sendMessage("�c�lSPEED�f�lMC �fVoc� recebeu o kit: �3�lPHANTOM");
				cfPermiss�o.setarPermissao(p, "kit.phantom", "true");

				cfKitdiario.setarTempo(p, "Phantom");
				iniciarContagem(p);
				break;
			case 7:

				p.sendMessage("�c�lSPEED�f�lMC �fVoc� recebeu o kit: �3�lNINJA");
				cfPermiss�o.setarPermissao(p, "kit.ninja", "true");

				cfKitdiario.setarTempo(p, "Ninja");
				iniciarContagem(p);
				break;
			case 8:

				p.sendMessage("�c�lSPEED�f�lMC �fVoc� recebeu o kit: �3�lVIPER");
				cfPermiss�o.setarPermissao(p, "kit.viper", "true");

				cfKitdiario.setarTempo(p, "Viper");
				iniciarContagem(p);
				break;
			case 9:

				p.sendMessage("�c�lSPEED�f�lMC �fVoc� recebeu o kit: �3�lSNAIL");
				cfPermiss�o.setarPermissao(p, "kit.snail", "true");

				cfKitdiario.setarTempo(p, "Snail");
				iniciarContagem(p);
				break;
			case 10:

				p.sendMessage("�c�lSPEED�f�lMC �fVoc� recebeu o kit: �3�lMAGMA");
				cfPermiss�o.setarPermissao(p, "kit.magma", "true");

				cfKitdiario.setarTempo(p, "Magma");
				iniciarContagem(p);
				break;
			case 11:

				p.sendMessage("�c�lSPEED�f�lMC �fVoc� recebeu o kit: �3�lGLADIATOR");
				cfPermiss�o.setarPermissao(p, "kit.gladiator", "true");

				cfKitdiario.setarTempo(p, "Gladiator");
				iniciarContagem(p);
				break;
			}
		}
	}
}
