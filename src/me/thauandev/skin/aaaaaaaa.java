package me.thauandev.skin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thauandev.skin.FakePlayerUtils;


public class aaaaaaaa extends CommandBase {

	@SuppressWarnings({ "deprecation" })
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (cmd.getName().equalsIgnoreCase("changeskin")) {

			if (!(sender instanceof Player))
				return true;

			Player p = (Player) sender;
			
			if (args.length == 0) {
				p.sendMessage("§c§lSPEED§f§lMC §fUse §c/chageskin (player)");
				return true;
			}

				String skin = args[0];
				FakePlayerUtils.changePlayerSkin(p, skin, Bukkit.getOfflinePlayer(args[0]).getUniqueId());
				p.sendMessage("§c§lSPEED§f§lMC §fSua skin §ffoi alterada com §a§lSUCESSO§f!");
				p.sendMessage("§c§lSPEED§f§lMC §fApenas os outros jogadores §a§lVERAO§f!");
				return true;
		}

		return false;
	}

}
