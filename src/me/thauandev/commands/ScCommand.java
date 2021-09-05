package me.thauandev.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.thauandev.bans.API;
import me.thauandev.configuração.cfGrupo;
import me.thauandev.scoreboard.sScoreAPI;

public class ScCommand implements Listener, CommandExecutor {
	@SuppressWarnings({ "unchecked", "rawtypes" })

	public static ArrayList<String> staff = new ArrayList();

	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		for (Player online : Bukkit.getOnlinePlayers()) {
			if (!isStaffChatting(p))
				continue;
			e.setCancelled(true);
			if ((cfGrupo.ChecarGrupo(online, "Dono") || (cfGrupo.ChecarGrupo(online, "Gerente") || (cfGrupo
					.ChecarGrupo(online, "Admin")
					|| (cfGrupo.ChecarGrupo(online, "Mod+") || (cfGrupo.ChecarGrupo(online, "Mod")
							|| (cfGrupo.ChecarGrupo(online, "Trial") || (cfGrupo.ChecarGrupo(online, "Youtuber+")
									|| (cfGrupo.ChecarGrupo(p, "Helper")) || (isStaffChatting(online))))))))))
				online.sendMessage("§c§l[SC] " + p.getDisplayName() + "§7(" + sScoreAPI.getRank(p) + "§7)" + "§7:§f "
						+ e.getMessage());
		}
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("sc")) {
			if ((!cfGrupo.ChecarGrupo(p, "Dono") && (!cfGrupo.ChecarGrupo(p, "Gerente")
					&& (!cfGrupo.ChecarGrupo(p, "Builder"))
					&& (!cfGrupo.ChecarGrupo(p, "Admin")
							&& (!cfGrupo.ChecarGrupo(p, "Mod+") && (!cfGrupo.ChecarGrupo(p, "Mod")
									&& (!cfGrupo.ChecarGrupo(p, "Trial") && (!cfGrupo.ChecarGrupo(p, "Youtuber+")
											&& (!cfGrupo.ChecarGrupo(p, "Helper")))))))))) {
				API.sendMsg(p, "§c§lSPEED§f§lMC §fVocê não possui permissão para executar este comando!");
				return true;
			}
			if (isStaffChatting(p)) {
				staff.remove(p.getName());
				p.sendMessage("§c§l[SC] §fVoce saiu §fdo chat da §e§lSTAFF§f!");
			} else {
				staff.add(p.getName());
				p.sendMessage("§c§l[SC] §fVoce entrou §fno chat da §e§lSTAFF§f!");
			}
		}
		return true;
	}

	public boolean isStaffChatting(Player player) {
		return staff.contains(player.getName());
	}
}