package me.thauandev.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thauandev.bans.API;
import me.thauandev.configuração.cfGrupo;
import me.thauandev.configuração.cfPermissão;

public class AddPermissaoCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("addpermission")) {
			if ((!cfGrupo.ChecarGrupo(p, "Dono") && (!cfGrupo.ChecarGrupo(p, "Admin")))) {
				API.sendMsg(p, "§c§lSPEED§f§lMC §cVocê não possui permissão para executar este comando!");
				return true;
			}
			if (args.length == 0) {
				p.sendMessage("§c§lSPEED§f§lMC §7Utilize §c/addpermission (nick) (perm)");
				return true;
			}
			if (args.length == 1) {
				p.sendMessage("§c§lSPEED§f§lMC §7Utilize §c/addpermission (nick) (perm)");
				return true;
			}
			Player k = Bukkit.getPlayer(args[0]);
			String permissao = args[1];
			cfPermissão.setarPermissao(k, permissao, "true");
			p.sendMessage("§c§lSPEED§f§lMC §7Permissão §c" + permissao + " §7adicionada ao jogador §c" + k.getName());
		}
		if (cmd.getName().equalsIgnoreCase("removepermission")) {
			if ((!cfGrupo.ChecarGrupo(p, "Dono") && (!cfGrupo.ChecarGrupo(p, "Admin")))) {
				API.sendMsg(p, "§c§lSPEED§f§lMC §cVocê não possui permissão para executar este comando!");
				return true;
			}
			if (args.length == 0) {
				p.sendMessage("§c§lSPEED§f§lMC §7Utilize §c/removepermission (nick) (perm)");
				return true;
			}
			if (args.length == 1) {
				p.sendMessage("§c§lSPEED§f§lMC §7Utilize §c/removepermission (nick) (perm)");
				return true;
			}
			Player k = Bukkit.getPlayer(args[0]);
			String permissao = args[1];
			cfPermissão.setarPermissao(k, permissao, "false");
			p.sendMessage("§c§lSPEED§f§lMC §7Permissão §c" + permissao + " §7retirada do jogador §c" + k.getName());

		}
		return false;
	}
}
