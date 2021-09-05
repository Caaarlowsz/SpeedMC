package me.thauandev.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thauandev.configura��o.cfGrupo;

public class GiveAllCommand implements CommandExecutor {

	public static boolean pro;
	public static boolean mvp;
	public static boolean light;
	public static boolean winner;
	public static boolean fullkit;

	@Override
	public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args) {

		Player p = (Player) Sender;

		if (!cfGrupo.ChecarGrupo(p, "Dono")) {
			p.sendMessage("�c�lSPEED�f�lMC �fVoce nao �a�lPOSSUI �fpermissao para �e�lGIVEALL�f!");
			return true;
		}

		if (Args.length == 0) {
			p.sendMessage("�c�lSPEED�f�lMC �fUse �c/giveall (winner) (light) (premium) (ultimate) (fullkit)�f!");
			return true;
		}
		if (Args[0].equalsIgnoreCase("utlimate")) {

			if (mvp) {
				p.sendMessage("�c�lSPEED�f�lMC �7Retire a fun��o do �6�lPREMIUM �7para ativar outra!");
				return true;
			}
			if (winner) {
				p.sendMessage("�c�lSPEED�f�lMC �7Retire a fun��o do �2�lWINNER �7para ativar outra!");
				return true;
			}
			if (light) {
				p.sendMessage("�c�lSPEED�f�lMC �7Retire a fun��o do �a�lLIGHT �7para ativar outra!");
				return true;
			}
			if (fullkit) {
				p.sendMessage("�c�lSPEED�f�lMC �7Retire a fun��o do �e�lFULLKIT �7para ativar outra!");
				return true;
			}
			if (pro) {
				p.sendMessage("�c�lSPEED�f�lMC �7O �d�lULTIMATE �7j� est� liberado a �9�lTODOS�f!");
			} else {
				p.sendMessage("�c�lSPEED�f�lMC �7Voc� liberou o �d�lULTIMATE �7a �9�lTODOS�f");
				Bukkit.broadcastMessage("�c�lSPEED�f�lMC �7O Player �a(" + p.getName()
						+ ") �7liberou o �d�lULTIMATE �7para �9�lTODOS�f.");
				pro = true;
				return true;
			}
		}
		if (Args[0].equalsIgnoreCase("premium")) {

			if (pro) {
				p.sendMessage("�c�lSPEED�f�lMC �7Retire a fun��o do �d�lULTIMATE �7para ativar outra!");
				return true;
			}
			if (winner) {
				p.sendMessage("�c�lSPEED�f�lMC �7Retire a fun��o do �2�lWINNER �7para ativar outra!");
				return true;
			}
			if (light) {
				p.sendMessage("�c�lSPEED�f�lMC �7Retire a fun��o do �a�lLIGHT �7para ativar outra!");
				return true;
			}
			if (fullkit) {
				p.sendMessage("�c�lSPEED�f�lMC �7Retire a fun��o do �e�lFULLKIT �7para ativar outra!");
				return true;
			}
			if (mvp) {
				p.sendMessage("�c�lSPEED�f�lMC �7O �9�MVP �7j� est� liberado a �9�lTODOS�f!");
			} else {
				p.sendMessage("�c�lSPEED�f�lMC �7Voc� liberou o �6�lPREMIUM �7a �9�lTODOS�f");
				Bukkit.broadcastMessage("�c�lSPEED�f�lMC �7O Player �a(" + p.getName()
						+ ") �7liberou o �6�lPREMIUM �7para �9�lTODOS�f.");
				mvp = true;
				return true;
			}
		}
		if (Args[0].equalsIgnoreCase("winner")) {

			if (pro) {
				p.sendMessage("�c�lSPEED�f�lMC �7Retire a fun��o do �a�lLIGHT �7para ativar outra!");
				return true;
			}
			if (mvp) {
				p.sendMessage("�c�lSPEED�f�lMC �7Retire a fun��o do �6�lPREMIUM �7para ativar outra!");
				return true;
			}
			if (fullkit) {
				p.sendMessage("�c�lSPEED�f�lMC �7Retire a fun��o do �e�lFULLKIT �7para ativar outra!");
				return true;
			}
			if (light) {
				p.sendMessage("�c�lSPEED�f�lMC �7O �a�lLIGHT �7j� est� liberado a �9�lTODOS�f!");
			} else {
				p.sendMessage("�c�lSPEED�f�lMC �7Voc� liberou o �2�lWINNER �7a �9�lTODOS�f");
				Bukkit.broadcastMessage("�c�lSPEED�f�lMC �7O Player �a(" + p.getName()
						+ ") �7liberou o �2�lWINNER �7para �9�lTODOS�f.");
				winner = true;
				return true;
			}
		}
		if (Args[0].equalsIgnoreCase("light")) {

			if (pro) {
				p.sendMessage("�c�lSPEED�f�lMC �7Retire a fun��o do �a�lLIGHT �7para ativar outra!");
				return true;
			}
			if (winner) {
				p.sendMessage("�c�lSPEED�f�lMC �7Retire a fun��o do �2�lWINNER �7para ativar outra!");
				return true;
			}
			if (mvp) {
				p.sendMessage("�c�lSPEED�f�lMC �7Retire a fun��o do �6�lPREMIUM �7para ativar outra!");
				return true;
			}
			if (fullkit) {
				p.sendMessage("�c�lSPEED�f�lMC �7Retire a fun��o do �e�lFULLKIT �7para ativar outra!");
				return true;
			}
			if (light) {
				p.sendMessage("�c�lSPEED�f�lMC �7O �a�lLIGHT �7j� est� liberado a �9�lTODOS�f!");
			} else {
				p.sendMessage("�c�lSPEED�f�lMC �7Voc� liberou o �a�lLIGHT �7a �9�lTODOS�f");
				Bukkit.broadcastMessage(
						"�c�lSPEED�f�lMC �7O Player �a(" + p.getName() + ") �7liberou o �a�lLIGHT �7para �9�lTODOS�f.");
				light = true;
				return true;
			}
		}
		if (Args[0].equalsIgnoreCase("fullkit")) {

			if (pro) {
				p.sendMessage("�c�lSPEED�f�lMC �7Retire a fun��o do �d�lULTIMATE �7para ativar outra!");
				return true;
			}
			if (winner) {
				p.sendMessage("�c�lSPEED�f�lMC �7Retire a fun��o do �2�lWINNER �7para ativar outra!");
				return true;
			}
			if (light) {
				p.sendMessage("�c�lSPEED�f�lMC �7Retire a fun��o do �a�lLIGHT �7para ativar outra!");
				return true;
			}
			if (mvp) {
				p.sendMessage("�c�lSPEED�f�lMC �7Retire a fun��o do �6�lPREMIUM �7para ativar outra!");
				return true;
			}
			if (fullkit) {
				p.sendMessage("�c�lSPEED�f�lMC �7O �e�lFULLKIT �7j� est� liberado a �9�lTODOS�f�f!");
			} else {
				p.sendMessage("�c�lSPEED�f�lMC �7Voc� liberou o �e�lFULLKIT �7a �9�lTODOS�f");
				Bukkit.broadcastMessage("�c�lSPEED�f�lMC �7O Player �a(" + p.getName()
						+ ") �7liberou o �e�lFULLKIT �7para �9�lTODOS�f!");
				fullkit = true;
				return true;
			}
		}
		return false;
	}

}
