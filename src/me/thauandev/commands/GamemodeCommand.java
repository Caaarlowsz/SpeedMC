package me.thauandev.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thauandev.configuração.cfGrupo;

public class GamemodeCommand implements CommandExecutor {

	public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args) {

		Player p = (Player) Sender;

		if (Cmd.getName().equalsIgnoreCase("gamemode") || Cmd.getName().equalsIgnoreCase("gm")) {
			if ((!cfGrupo.ChecarGrupo(p, "Dono") && (!cfGrupo.ChecarGrupo(p, "Gerente")
					&& (!cfGrupo.ChecarGrupo(p, "Admin") && (!cfGrupo.ChecarGrupo(p, "Mod+")
							&& (!cfGrupo.ChecarGrupo(p, "Mod") && (!cfGrupo.ChecarGrupo(p, "Dono")))))))) {
				p.sendMessage("§c§lSPEED§f§lMC §fVoce nao possui §fpermissao para o gamemode§f!");
				return true;
			}
			if (Args.length == 0) {
				p.sendMessage("§c§lSPEED§f§lMC §fUse §c/gamemode (1) (0) §fou §c/gm (1) (0)");
				return true;
			}
			if (Args[0].equalsIgnoreCase("1")) {

				p.setGameMode(GameMode.CREATIVE);
				p.sendMessage("§c§lSPEED§f§lMC §fO seu gamemode §ffoi alterado para o modo §a§lCRIATIVO");
			}
			if (Args[0].equalsIgnoreCase("0")) {

				p.setGameMode(GameMode.SURVIVAL);
				p.sendMessage("§c§lSPEED§f§lMC §fO seu gamemode §ffoi alterado para o modo §c§lSOBREVIVENCIA");
			}
		}
		return false;
	}
}
