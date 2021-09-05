package me.thauandev.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thauandev.API.ArraysAPI;
import me.thauandev.API.KitAPI;
import me.thauandev.bans.API;
import me.thauandev.configuração.cfGrupo;

public class ClearAllCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if ((!cfGrupo.ChecarGrupo(p, "Dono")
				&& (!cfGrupo.ChecarGrupo(p, "Gerente") && (!cfGrupo.ChecarGrupo(p, "Admin"))))) {
			API.sendMsg(p, "§c§lSPEED§f§lMC §cVocê não possui permissão para executar este comando!");
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("clearall")) {
			API.sendMsg(p, "§aVocê limpou o inventário de todos os jogadores!");
			for (Player todos : Bukkit.getOnlinePlayers()) {
				if (todos != p) {
					if (!ArraysAPI.Admin.contains(todos)) {
						todos.getInventory().clear();
						todos.getInventory().setArmorContents(null);
						todos.updateInventory();
						KitAPI.removeKits(p);
						me.thauandev.API.API.setWarp(todos, "Spawn");
						return true;
					}
				}
			}
			return true;
		}
		return false;
	}
}
