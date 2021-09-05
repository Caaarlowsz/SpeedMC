package me.thauandev.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import me.thauandev.API.ArraysAPI;
import me.thauandev.configuração.cfConfig;

public class TellCommand implements CommandExecutor, Listener {

	public static ArrayList<Player> cooldown = new ArrayList<>();

	@EventHandler
	public void flodar(PlayerCommandPreprocessEvent e) {

		Player p = e.getPlayer();
		if (cooldown.contains(p) && (cooldown.contains(p) && (e.getMessage().toLowerCase().startsWith("/tell")))) {
			e.setCancelled(true);
			p.sendMessage("§cAguarde antes de enviar outra mensagem...");

		}
	}

	public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args) {
		final Player p = (Player) Sender;
		if (Cmd.getName().equalsIgnoreCase("tell")) {
			if (Args.length == 0) {
				p.sendMessage("§c§lSPEED§f§lMC §fUtilize o §9§lCOMANDO §b/tell (JOGADOR) (MENSAGEM)");
				p.sendMessage("§fOu §b/tell (ON) (OFF)");
				return true;
			}
			if (Args[0].equalsIgnoreCase("on")) {
				if (cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".Tell").equals("Desativado")) {
					p.sendMessage("§aSeu tell foi ativado.");
					cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".Tell", "Ativado");
					cfConfig.salvarconfiguracao();
				} else {
					p.sendMessage("§c§lSPEED§f§lMC §fO seu §9§lTELL §fja está §a§lATIVADO§f!");
				}
				return true;
			}
			if (Args[0].equalsIgnoreCase("off")) {
				if (cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".Tell").equals("Ativado")) {
					p.sendMessage("§cSeu tell foi desativado.");
					cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".Tell", "Desativado");
					cfConfig.salvarconfiguracao();
				} else {
					p.sendMessage("§c§lSPEED§f§lMC §fO seu §9§lTELL §fja está §c§lDESATIVADO§f!");
				}
				return true;
			}
			Player tell = Bukkit.getPlayer(Args[0]);
			if (tell == null) {
				p.sendMessage("§c§lSPEED§f§lMC §fJogador §c§lOFFLINE§f!");
				return true;
			}
			if (tell == p) {
				p.sendMessage("§cÉ impossível enviar mensagens a si mesmo!");
				return true;
			}
			if (cfConfig.pegarconfig().get("configuração." + tell.getUniqueId() + ".Tell").equals("Desativado")) {
				p.sendMessage(
						"§c§lSPEED§f§lMC  §7Este jogador está com o tell §c§lDESATIVADO§f! Tente novamente mais tarde.");
				return true;
			}
			if (ArraysAPI.Admin.contains(tell)) {
				p.sendMessage("§cJogador offline!");
				return true;
			}
			String message = " ";
			for (int i = 1; i < Args.length; i++) {
				if (i == Args.length - 1) {
					message = message + Args[i];
				} else {
					message = message + Args[i] + " ";
				}
			}
			p.sendMessage("§e§lTELL §7De Você para §7" + tell.getName() + " §8" + message);
			tell.sendMessage("§e§lTELL §7De §7" + p.getName() + " §7para você :§8" + message);
		}
		return false;
	}
}
