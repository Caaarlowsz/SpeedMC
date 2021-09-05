package me.thauandev.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thauandev.account.AccountUtils;
import me.thauandev.bans.API;
import me.thauandev.bans.Config;

public class AccountCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("account") || cmd.getName().equalsIgnoreCase("acc")) {
			if(args.length == 0) {
				p.sendMessage("§c§lSPEED§f§lMC §fUtilize o comando §c/acc (nick)§f!");
				API.sendSound(p, Sound.NOTE_PLING, 10);
				return true;
			}
			Player acc = Bukkit.getPlayer(args[0]);
			if(acc == null) {
				@SuppressWarnings("deprecation")
				OfflinePlayer off = Bukkit.getOfflinePlayer(args[0]);
				if(Config.getConfig().getJogadores().get("Jogadores." + off.getUniqueId()) == null) {
					API.sendMsg(p, "§c§lSPEED§f§lMC  §7» §fO jogador §c" + off.getName() + "§f nunca entrou no servidor!");
					API.sendSound(p, Sound.NOTE_PLING, 10);
					return true;
				}
				if(Config.getConfig().getJogadores().get("Jogadores." + off.getUniqueId()) != null) {
					API.sendMsg(p, "              ");
					API.sendMsg(p, "              §c§lACCOUNT      ");
					API.sendMsg(p, "             ");
					API.sendMsg(p, "§7Checando informações de: §c" + off.getName());
					API.sendMsg(p, "  ");
					API.sendMsg(p, "§7Ranking: " + AccountUtils.getGrupo(off));
					API.sendMsg(p, "§7Status: §c§lOFFLINE");
					API.sendMsg(p, "§7Nickname: §7" + Config.getConfig().getJogadores().get("Jogadores." + off.getUniqueId() + ".Nome"));
					API.sendMsg(p, "§7Elo: " + AccountUtils.getRankOffline(off) + " " + AccountUtils.getRankNomeOffline(off));
					API.sendMsg(p, "§7XP: §7" + Config.getConfig().getJogadores().get("Jogadores." + off.getUniqueId() + ".Coins"));
					API.sendMsg(p, "                             ");
					API.sendMsg(p, "  ");
				}
			}
			if(acc != null) {
				API.sendMsg(p, "                               ");
				API.sendMsg(p, "              §c§lACCOUNT      ");
				API.sendMsg(p, "                               ");				API.sendMsg(p, "");
				API.sendMsg(p, "§7Checando informações de: §c" + acc.getName());
				API.sendMsg(p, "  ");
				API.sendMsg(p, "§7Ranking: " + AccountUtils.getGrupo(acc));
				API.sendMsg(p, "§7Status: §a§lONLINE");
				API.sendMsg(p, "§7Nickname: §7" + Config.getConfig().getJogadores().get("Jogadores." + acc.getUniqueId() + ".Nome"));
				API.sendMsg(p, "§7Elo: " + AccountUtils.getRankOffline(acc) + " " + AccountUtils.getRankNomeOffline(acc));
				API.sendMsg(p, "§7XP: §7" + Config.getConfig().getJogadores().get("Jogadores." + acc.getUniqueId() + ".Coins"));
				API.sendMsg(p, "                               ");
				API.sendMsg(p, "  ");
			}
		}
		return false;
	}
}
