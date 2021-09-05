package me.thauandev.account;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import me.thauandev.API.API;
import me.thauandev.API.KitAPI;
import me.thauandev.API.cfStatus;
import me.thauandev.commands.FlyCommand;
import me.thauandev.configuração.cfGrupo;
import me.thauandev.scoreboard.sScoreAPI;

public class CheckUtils {
	
	public static String Grupo(Player p) {
		if(cfGrupo.ChecarGrupo(p, "Membro")) {
			return "§7    ";
		}
		if(cfGrupo.ChecarGrupo(p, "Light")) {
			return "§aLIGHT";
		}
		if(cfGrupo.ChecarGrupo(p, "Mvp")) {
			return "§6PREMIUM";
		}
		if(cfGrupo.ChecarGrupo(p, "Pro")) {
			return "§dULTIMATE";
		}
		if(cfGrupo.ChecarGrupo(p, "S-Pro")) {
			return "§ePLATINUM";
		}
		if(cfGrupo.ChecarGrupo(p, "Youtuber")) {
			return "§bYOUTUBER";
		}
		if(cfGrupo.ChecarGrupo(p, "Youtuber+")) {
			return "§3YOUTUBER+";
		}
		if(cfGrupo.ChecarGrupo(p, "Helper")) {
			return "§9AJUDANTE";
		}
		if(cfGrupo.ChecarGrupo(p, "Builder")) {
			return "§2BUILDER";
		}
		if(cfGrupo.ChecarGrupo(p, "Trial")) {
			return "§5TRIAL";
		}
		if(cfGrupo.ChecarGrupo(p, "Mod")) {
			return "§5MOD";
		}
		if(cfGrupo.ChecarGrupo(p, "Mod+")) {
			return "§5MOD+";
		}
		if(cfGrupo.ChecarGrupo(p, "Gerente")) {
			return "§cGERENTE";
		}
		if(cfGrupo.ChecarGrupo(p, "Admin")) {
			return "§cADMIN";
		}
		if(cfGrupo.ChecarGrupo(p, "Dono")) {
			return "§4DONO";
		}
		return "§4DONO";
	}
	
	public static String Nickname(Player p) {
		return "§c" + p.getName();
	}
	
	public static String UUID(Player p) {
		return "§c" + p.getUniqueId().toString();
	}
	
	public static String IP(Player p) {
		return "§c" + p.getAddress().getHostString();
	}
	
	public static String IPReverso(Player p) {
		return "§c" + p.getAddress().getHostName();
	}
	
	public static String GeoIP(Player p) {
		return "§7https://www.geoiptool.com/pt/?ip=" + p.getAddress().getHostString();
	}
	
	public static String Gamemode(Player p) {
		if(p.getGameMode() == GameMode.CREATIVE) {
			return "§b§lCRIATIVO";
		}
		if(p.getGameMode() == GameMode.SURVIVAL) {
			return "§b§lSOBREVIVENCIA";
		}
		if(p.getGameMode() == GameMode.ADVENTURE) {
			return "§b§lAVENTURA";
		}
		return "§b§lAVENTURA";
	}
	
	public static String Fly(Player p) {
		if(FlyCommand.Fly.contains(p)) {
			return "§a§lON";
		}
		if(!FlyCommand.Fly.contains(p)) {
			return "§c§lOFF";
		}
		return "§c§lOFF";
	}
	
	public static String Vida(Player p) {
		return "§c" + p.getHealthScale();
	}
	
	public static String Fome(Player p) {
		return "§c" + p.getFoodLevel();
	}
	
	public static String Kit(Player p) {
		return "§c" + KitAPI.getKitAntes(p);
	}
	
	public static String Warp(Player p) {
		return "§c" + API.getWarp(p);
	}
	
	public static String Rank(Player p) {
		return "§c" + sScoreAPI.getRank(p) + " " + sScoreAPI.getNomeRank(p);
	}
	
	public static String Coins(Player p) {
		return "§c" + cfStatus.getMoney(p);
	}
	
	public static String Kills(Player p) {
		return "§c" + cfStatus.getKills(p);
	}
	
	public static String Deaths(Player p) {
		return "§c" + cfStatus.getDeaths(p);
	}
	
	public static String KillStreak(Player p) {
		return "§c" + cfStatus.getKillStreak(p);
	}
}
