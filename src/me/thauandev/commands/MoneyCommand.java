package me.thauandev.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thauandev.configuração.cfGrupo;
import me.thauandev.configuração.cfStatus;

public class MoneyCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player p = (Player) sender;
		if (!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Admin")) {
			p.sendMessage("§6§lMONEY §fConsiga Money Matando §e§lPLAYERS §fNao abusando!");
			return true;
		}

		if (args.length < 3) {
			p.sendMessage("§c§lSPEED§f§lMC §fUse §c/money add (nick) (money)");
			return true;
		}

		int tanto = Integer.valueOf(args[2]);
		Player t = Bukkit.getPlayer(args[1]);

		if (args[0].equalsIgnoreCase("add")) {

			try {
				cfStatus.addMoney(t, tanto);
				p.sendMessage("§6§lMONEY §fVoce Deu §c" + tanto + " §fMoney Para O Jogador §c" + t.getName());
				t.sendMessage("§6§lMONEY §c " + tanto + " §fMoney Foi Adicionadaa A Sua §a§lCONTA§f!");
			} catch (Exception e) {
				p.sendMessage("§cUse Somente Numeros!");
			}

		} else {
			p.sendMessage("§c§lSPEED§f§lMC §fUse §c/money add (nick) (money)");
		}

		return false;
	}

}
