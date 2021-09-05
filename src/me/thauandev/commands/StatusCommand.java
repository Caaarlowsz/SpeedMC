package me.thauandev.commands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thauandev.bans.API;
import me.thauandev.configuração.cfStatus;

public class StatusCommand implements CommandExecutor {

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

	public static String getNomerRankConfig1(Player p) {
		double a = cfStatus.getKills(p);
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

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("status") || cmd.getName().equalsIgnoreCase("stats")) {
			if (args.length == 0) {
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 20L, 20L);
				API.sendMsg(p, " ");
				API.sendMsg(p, "§c§lSPEED§f§lMC ");
				API.sendMsg(p, "§7§lSUAS §7§lKILLS§e: §a" + cfStatus.getKills(p));
				API.sendMsg(p, "§7§lSUAS §7§lMORTES§e: §c" + cfStatus.getDeaths(p));
				API.sendMsg(p, "§7§lSUAS §7§lMOEDAS§e: §6" + cfStatus.getMoney(p));
				API.sendMsg(p, "§7§lSEU RANK: " + getRank1(p) + " " + getNomeRank1(p));
			}
		}
		return false;
	}
}
