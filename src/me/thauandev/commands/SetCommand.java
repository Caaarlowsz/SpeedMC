package me.thauandev.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thauandev.API.WarpsAPI;
import me.thauandev.configuração.cfGrupo;

public class SetCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("set")) {
			if ((!cfGrupo.ChecarGrupo(p, "Dono")
					&& (!cfGrupo.ChecarGrupo(p, "Gerente") && (!cfGrupo.ChecarGrupo(p, "Builder"))))) {
				p.sendMessage("§c§lSPEED§f§lMC §fVoce nao possui §fAcesso ao §cSET§f!");
				return true;
			}
			if (args.length == 0) {
				p.sendMessage("§c§lSPEED§f§lMC §fUse §b/set (local)");
				p.sendMessage("§aAlguns locais... ");
				p.sendMessage(" ");
				p.sendMessage("§cSPAWN");
				p.sendMessage("§cLOC1");
				p.sendMessage("§cLOC2");
				p.sendMessage("§cLOC3");
				p.sendMessage("§cLOC4");
				p.sendMessage("§cLOC5");
				p.sendMessage("§cEVENTO");
				p.sendMessage("§cPARKOUR");
				p.sendMessage("§cVILLAGERPARKOUR");
				p.sendMessage("§cFPS");
				p.sendMessage("§c1v1LOC1");
				p.sendMessage("§c1v1LOC2");
				p.sendMessage("§cCHALLENGE");
				p.sendMessage("§cFISHERMAN");
				return true;
			}
			if (args[0].equalsIgnoreCase("spawn")) {
				WarpsAPI.Set(p, "Spawn");
				p.sendMessage("§c§lSPEED§f§lMC §cSPAWN §fFoi setado com §a§lSUCESSO§f!");
				return true;
			}
			if (args[0].equalsIgnoreCase("parkour")) {
				WarpsAPI.Set(p, "Spawn");
				p.sendMessage("§c§lSPEED§f§lMC §cPARKOUR §fFoi setado com §a§lSUCESSO§f!");
				return true;
			}
			if (args[0].equalsIgnoreCase("evento")) {
				WarpsAPI.Set(p, "Evento");
				p.sendMessage("§c§lSPEED§f§lMC §cEVENTO §fFoi setado com §a§lSUCESSO§f!");
				return true;
			}
			if (args[0].equalsIgnoreCase("loc1")) {
				WarpsAPI.Set(p, "Loc1");
				p.sendMessage("§c§lSPEED§f§lMC §cLOC1 §fFoi setado com §a§lSUCESSO§f!");
				return true;
			}
			if (args[0].equalsIgnoreCase("loc2")) {
				WarpsAPI.Set(p, "Loc2");
				p.sendMessage("§c§lSPEED§f§lMC §cLOC2 §fFoi setado com §a§lSUCESSO§f!");
				return true;
			}
			if (args[0].equalsIgnoreCase("loc3")) {
				WarpsAPI.Set(p, "Loc3");
				p.sendMessage("§c§lSPEED§f§lMC §cLOC3 §7§fFoi setado com §a§lSUCESSO§f!");
				return true;
			}
			if (args[0].equalsIgnoreCase("loc4")) {
				WarpsAPI.Set(p, "Loc4");
				p.sendMessage("§c§lSPEED§f§lMC §cLOC4 §fFoi setado com §a§lSUCESSO§f!");
				return true;
			}
			if (args[0].equalsIgnoreCase("loc5")) {
				WarpsAPI.Set(p, "Loc5");
				p.sendMessage("§c§lSPEED§f§lMC §cLOC5 §fFoi setado com §a§lSUCESSO§f!");
				return true;
			}
			if (args[0].equalsIgnoreCase("textura")) {
				WarpsAPI.Set(p, "Loc5");
				p.sendMessage("§c§lSPEED§f§lMC §cTEXTURA §fFoi setado com §a§lSUCESSO§f!");
				return true;
			}
			if (args[0].equalsIgnoreCase("parkour")) {
				WarpsAPI.Set(p, "Parkour");
				p.sendMessage("§c§lSPEED§f§lMC §cPARKOUR §fFoi setado com §a§lSUCESSO§f!");
				return true;
			}
			if (args[0].equalsIgnoreCase("villagerparkour")) {
				WarpsAPI.Set(p, "VillagerParkour");
				p.sendMessage("§c§lSPEED§f§lMC §cVILLAGERPARKOUR §fFoi setado com §a§lSUCESSO§f!");
				return true;
			}
			if (args[0].equalsIgnoreCase("fps")) {
				WarpsAPI.Set(p, "Fps");
				p.sendMessage("§7A §cFPS §ffoi setada com §a§lSUCESSO§f!");
				return true;
			}
			if (args[0].equalsIgnoreCase("1v1")) {
				WarpsAPI.Set(p, "1v1");
				p.sendMessage("§7A §c1v1 §ffoi setada com §a§lSUCESSO§f!");
				return true;
			}
			if (args[0].equalsIgnoreCase("1v1loc1")) {
				WarpsAPI.Set(p, "1v1loc1");
				p.sendMessage("§c§lSPEED§f§lMC §c1v1LOC1 §fFoi setado com §a§lSUCESSO§f!");
				return true;
			}
			if (args[0].equalsIgnoreCase("1v1loc2")) {
				WarpsAPI.Set(p, "1v1loc2");
				p.sendMessage("§c§lSPEED§f§lMC §c1v1LOC2 §fFoi setado com §a§lSUCESSO§f!");
				return true;
			}
			if (args[0].equalsIgnoreCase("challenge")) {
				WarpsAPI.Set(p, "Challenge");
				p.sendMessage("§c§lSPEED§f§lMC §fA Warp §cLAVACHALLENGE §ffoi setada com §a§lSUCESSO§f!");
				return true;
			}
			if (args[0].equalsIgnoreCase("knockback")) {
				WarpsAPI.Set(p, "Knockback");
				p.sendMessage("§c§lSPEED§f§lMC §fA Warp §cKNOCKBACK §ffoi setada com §a§lSUCESSO§f!");
				return true;
			}
			if (args[0].equalsIgnoreCase("main")) {
				WarpsAPI.Set(p, "Main");
				p.sendMessage("§c§lSPEED§f§lMC §fA Warp §cMAIN §ffoi setada com §a§lSUCESSO§f!");
				return true;
			}
			if (args[0].equalsIgnoreCase("fisherman")) {
				WarpsAPI.Set(p, "Fisherman");
				p.sendMessage("§c§lSPEED§f§lMC §fA Warp §cFISHERMAN §ffoi setada com §a§lSUCESSO§f!");
				return true;
			}
		}
		return false;
	}
}
