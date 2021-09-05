package me.thauandev.scoreboard;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.thauandev.API.KitAPI;
import me.thauandev.account.CheckUtils;
import me.thauandev.configuração.cfStatus;

public class sScoreAPI {

	public static ArrayList<Player> Score = new ArrayList<>();
	public static ArrayList<Player> Delay = new ArrayList<>();

	public static String getRank(Player p) {
		double a = cfStatus.getKills(p);
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

	public static String getRankConfig(Player p) {
		double a = cfStatus.getKills(p);
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

	public static String getNomeRank(Player p) {
		double a = cfStatus.getKills(p);
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

	public static String getNomerRankConfig(Player p) {
		double a = cfStatus.getKills(p);
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

	public static void scoreboard(Player p) {
		int online = Bukkit.getOnlinePlayers().length;

		uScore scoreboard = new uScore("      §c§lSPEED§f§lMC     ");
		scoreboard.addLine("§a ", Integer.valueOf(12));
		scoreboard.addLine("§7Rank: " + CheckUtils.Grupo(p), Integer.valueOf(11));
		scoreboard.addLine("§7Liga: " + getRank(p) + " " + getNomeRank(p), Integer.valueOf(10));
		scoreboard.addLine("§7 ", Integer.valueOf(9));
		scoreboard.addLine("§7Kills: §b" + cfStatus.getKills(p), Integer.valueOf(8));
		scoreboard.addLine("§7Deaths: §b" + cfStatus.getDeaths(p), Integer.valueOf(7));
		scoreboard.addLine("§7Coins: §6" + cfStatus.getMoney(p), Integer.valueOf(6));
		scoreboard.addLine("§8 ", Integer.valueOf(5));
		scoreboard.addLine("§7Kit: §3" + KitAPI.getKitAntes(p), Integer.valueOf(4));
		scoreboard.addLine("§7Jogadores: §e" + online + "/120", Integer.valueOf(3));
		scoreboard.addLine("§2 ", Integer.valueOf(2));
		scoreboard.addLine("§6speedmc.com.br ", Integer.valueOf(1));

		if (Score.contains(p)) {
			scoreboard.setScoreboard();
			p.setScoreboard(scoreboard.getScoreboard());
		} else {
			scorenull(p);
		}
	}

	public static void scorenull(Player p) {

		uScore scoreboard = new uScore("");

		scoreboard.setScoreboard();
		p.setScoreboard(scoreboard.getScoreboard());
	}
}