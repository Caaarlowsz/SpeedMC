package me.thauandev.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import me.thauandev.bans.Config;
import me.thauandev.configuração.cfGrupo;

public class ManutencaoCommand implements CommandExecutor, Listener {

	public static boolean manutencao = false;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player p = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("manutencao")) {
			if (!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Admin")) {
				p.sendMessage("§c§lSPEED§f§lMC §fVocê nao possui permissao para executar este comando.");
				return true;
			}
			if (args.length == 0) {
				p.sendMessage("§c§lSPEED§f§lMC §f» §fUse §c/manutencao (on) (off)");
				return true;
			}
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("on")) {
					if ((manutencao)) {
						p.sendMessage("§cO modo manutenção já está ativado!");
						return true;
					} else {
						manutencao = true;
						p.sendMessage("§c§lSPEED§f§lMC §fVocê ativou §fo modo manutenção!");
						for (Player todos : Bukkit.getOnlinePlayers()) {
							if (!cfGrupo.ChecarGrupo(todos, "Dono") && !cfGrupo.ChecarGrupo(todos, "Gerente")
									&& !cfGrupo.ChecarGrupo(todos, "Admin")) {
								todos.kickPlayer("§c§lSERVIDOR FECHADO!" + "\n"
										+ "   §7O servidor acabou de ser fechado para manutenções" + "\n"
										+ "Assim que possível, nós estaremos de volta!" + "\n"
										+ "§7Atenciosamente, SpeedMC.");
								return true;
							}
						}
						Config.getConfig().saveManutencao();
						return true;
					}
				}
				if (args[0].equalsIgnoreCase("off")) {
					if (!(manutencao)) {
						p.sendMessage("§cO modo manutenção já está desativado!");
						return true;
					} else {
						manutencao = false;
						p.sendMessage("§fVocê §c§lDESATIVOU §fo modo manutenção!");
						return true;
					}
				}
			}
		}

		return false;
	}

	@EventHandler
	public void aoEntrarManutencao(PlayerLoginEvent e) {
		Player p = e.getPlayer();
		if ((manutencao) && !cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente")
				&& !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Mod")
				&& !cfGrupo.ChecarGrupo(p, "Trial") && !cfGrupo.ChecarGrupo(p, "Builder")) {
			e.disallow(PlayerLoginEvent.Result.KICK_OTHER,
					"§c§lMANUTENCAO..." + "\n" + "§7O servidor está em manutenção. Estamos com certeza aprimorando"
							+ "\n" + "§7a sua jogatina. Contamos com a compreensão de todos" + "\n"
							+ "§7Atenciosamente, §c§lSPEED§f§lMC");
		}
	}
}
