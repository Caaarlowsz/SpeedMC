package me.thauandev.account;

import org.bukkit.OfflinePlayer;

import me.thauandev.configuração.cfGrupo;
import me.thauandev.configuração.cfStatus;

public class AccountUtils {

	public static String getRankOffline(OfflinePlayer p) {
		double a = cfStatus.getKillsOff(p); // MySQL
		if (a <= 100) {
			return "§f-";
		}
		if (a <= 200) {
			return "§a=";
		}
		if (a <= 300) {
			return "§e✴";
		}
		if (a <= 400) {
			return "§6✷";
		}
		if (a <= 500) {
			return "§b✦";
		}
		if (a <= 600) {
			return "§5✹";
		}
		if (a <= 700) {
			return "§c✫";
		}
		if (a <= 1000) {
			return "§4✪";
		}
		return "§4✪";
	}

	public static String getRankNomeOffline(OfflinePlayer p) {
		double a = cfStatus.getKillsOff(p);
		if (a <= 100) {
			return "§fUNRANKED";
		}
		if (a <= 200) {
			return "§aPRYMARY";
		}
		if (a <= 300) {
			return "§eBRONZE";
		}
		if (a <= 400) {
			return "§6OURO";
		}
		if (a <= 500) {
			return "§7DIAMOND";
		}
		if (a <= 600) {
			return "§6ELITE";
		}
		if (a <= 700) {
			return "§bMASTER";
		}
		if (a <= 1000) {
			return "§4RUBY";
		}
		return "§4RUBY";
	}

	public static String getGrupo(OfflinePlayer p) {
		if (cfGrupo.ChecarGrupo(p, "Membro")) {
			return "§7MEMBRO";
		}
		if (cfGrupo.ChecarGrupo(p, "light")) {
			return "§aLIGHT";
		}
		if (cfGrupo.ChecarGrupo(p, "Mvp")) {
			return "§6PREMIUM";
		}
		if (cfGrupo.ChecarGrupo(p, "Pro")) {
			return "§dULTIMATE";
		}
		if (cfGrupo.ChecarGrupo(p, "S-Pro")) {
			return "§ePLATINUM";
		}
		if (cfGrupo.ChecarGrupo(p, "Youtuber")) {
			return "§bYOUTUBER";
		}
		if (cfGrupo.ChecarGrupo(p, "Youtuber+")) {
			return "§3YOUTUBER+";
		}
		if (cfGrupo.ChecarGrupo(p, "Helper")) {
			return "§9AJUDANTE";
		}
		if (cfGrupo.ChecarGrupo(p, "Builder")) {
			return "§2BUILDER";
		}
		if (cfGrupo.ChecarGrupo(p, "Trial")) {
			return "§5TRIAL";
		}
		if (cfGrupo.ChecarGrupo(p, "Mod")) {
			return "§5MOD";
		}
		if (cfGrupo.ChecarGrupo(p, "Mod+")) {
			return "§5MOD+";
		}
		if (cfGrupo.ChecarGrupo(p, "Gerente")) {
			return "§cGERENTE";
		}
		if (cfGrupo.ChecarGrupo(p, "Admin")) {
			return "§cADMIN";
		}
		if (cfGrupo.ChecarGrupo(p, "Dono")) {
			return "§4DONO";
		}
		return "§4DONO";
	}

}
