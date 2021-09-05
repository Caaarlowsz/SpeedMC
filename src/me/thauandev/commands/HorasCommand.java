package me.thauandev.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thauandev.API.HorarioAPI;

public class HorasCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("horas")) {
			if (args.length == 0) {
				p.sendMessage("�7Checando hor�rio atual do �a�lBrasil ");
				p.sendMessage(" ");
				p.sendMessage("�7Data e hor�rio atual: �b" + HorarioAPI.getHorario());
				p.sendMessage(" ");
				return true;
			}
		}
		return false;
	}
}
