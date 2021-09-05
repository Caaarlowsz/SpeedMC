package me.thauandev.skin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thauandev.configuração.cfGrupo;

public class ChangeSkinCommand extends CommandBase {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (cmd.getName().equalsIgnoreCase("changeskin")) {

			if (!(sender instanceof Player))
				return true;

			Player p = (Player) sender;

			if (args.length == 0) {
				p.sendMessage("§c§lSPEED§f§lMC §7Use §c/chageskin (player)");
				return true;
			}

			if (cfGrupo.ChecarGrupo(p, "Dono") || cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Admin")
					|| cfGrupo.ChecarGrupo(p, "Mod+") || cfGrupo.ChecarGrupo(p, "Mod")
					|| cfGrupo.ChecarGrupo(p, "youtuber+") || cfGrupo.ChecarGrupo(p, "youtuber")) {

				String skin = args[0];
				FakePlayerUtils.changePlayerSkin(p, skin, Bukkit.getOfflinePlayer(args[0]).getUniqueId());
				p.sendMessage("§c§lSPEED§f§lMC §fSua possui §ffoi alterada com §a§lSUCESSO§f!");
				p.sendMessage("§c§lSPEED§f§lMC §fApenas os outros jogadores §9§lVERAO§f!");
				return true;
			}
			p.sendMessage("§c§lSPEED§f§lMC §fVoce nao possui permissao para §e§lCHANGESKIN§f!");
		}

		return false;
	}

}
