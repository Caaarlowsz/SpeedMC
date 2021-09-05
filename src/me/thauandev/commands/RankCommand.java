package me.thauandev.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thauandev.bans.API;
import me.thauandev.configuração.cfStatus;

public class RankCommand implements CommandExecutor {

	public static String getRank1(Player p) {
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

	public static String getRankConfig1(Player p) {
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

	public static String getNomeRank1(Player p) {
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

	public static String getNomerRankConfig1(Player p) {
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

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("rank") || cmd.getName().equalsIgnoreCase("liga")) {
			if (args.length == 0) {
				API.sendMsg(p, " ");
				p.sendMessage(
						"§6§lLIGA§f As ligas sao divisoes, voce pode lutar por elas, observe a abaixo algumas das ligas:");
				p.sendMessage("                              ");
				p.sendMessage("§4✪  RUBY");
				p.sendMessage("§c✫  MASTER");
				p.sendMessage("§5✹  ELITE");
				p.sendMessage("§b✦  DIAMOND");
				p.sendMessage("§6✷  OURO");
				p.sendMessage("§e✴  BRONZE");
				p.sendMessage("§a=   PRIMARY");
				p.sendMessage("§f-   UNRANKED");
				p.sendMessage("                              ");
				p.sendMessage(
						"§6§lLIGA§f Voce pode adiquirir estas ligas, matando players. Apos matar os jogadores voce ganhar kills, é com essas kills voce ira upar! Boa sorte!");
			}
		}
		return false;
	}
}
