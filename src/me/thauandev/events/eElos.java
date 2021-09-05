package me.thauandev.events;

import org.bukkit.OfflinePlayer;

import me.thauandev.configuração.cfStatus;

public class eElos {

	public static String getRankOffline(OfflinePlayer p) {
		double a = cfStatus.getKillsOff(p); // MySQL
		if (a <= 100) {
			return "§7-";
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
			return "§7UNRANKED";
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
}
