package me.thauandev.anticheat;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import me.thauandev.configuração.cfGrupo;

public class Utills {

	public static HashMap<Player, Integer> FastAttackClicks = new HashMap<Player, Integer>();
	public static HashMap<Player, Integer> MacroClicks = new HashMap<Player, Integer>();
	public static ArrayList<Player> fly = new ArrayList<>();
	public static String FastAttack = null;
	public static String Forcefield = null;
	public static String Macro = null;
	public static String Fly = null;
	public static String Speed = null;
	public static String ForjandoAutoSoup = null;
	public static String AutoSoup = null;
	
	public static HashMap<Player, Integer> ClicksFastClicks = new HashMap<Player, Integer>();
	public static HashMap<Player, Integer> ClicksMacro = new HashMap<Player, Integer>();
	
	public static HashMap<Player, Integer> AvisosForcefield = new HashMap<Player, Integer>();
	public static HashMap<Player, Integer> AvisosFastClick = new HashMap<Player, Integer>();
	public static HashMap<Player, Integer> AvisosFly = new HashMap<Player, Integer>();
	public static HashMap<Player, Integer> AvisosSpeed = new HashMap<Player, Integer>();
	public static HashMap<Player, Integer> AvisosMacro = new HashMap<Player, Integer>();
	public static HashMap<Player, Integer> AvisosAutoSoup = new HashMap<Player, Integer>();
	
	public static enum Hack {
		
		FASTCLICKTALVEZ(ChatColor.RED + "§c§lANTICHEAT§c " + "nick" + " está [TALVEZ] clicando rápido demais! (CPS: clicks) [" + "avisos" + "]"),
		FASTCLICKPROVAVELMENTE(ChatColor.RED + "§c§lANTICHEAT§c " + "nick" + " está [PROVAVELMENTE] clicando rápido demais (CPS: clicks) [" + "avisos" + "]"),
		FASTCLICKDEFINITIVAMENTE(ChatColor.RED + "§c§lANTICHEAT§c " + "nick" + " está [DEFINITIVAMENTE] clicando rápido demais (CPS: clicks) [" + "avisos" + "]"),
		
		MACROTALVEZ(ChatColor.RED + "§c§lANTICHEAT§c " + "nick" + " está [TALVEZ] utilizando Macro/Autoclick (CPS: clicks) [" + "avisos" + "]"),
		MACROPROVAVELMENTE(ChatColor.RED + "§c§lANTICHEAT§c " + "nick" + " está [PROVAVELMENTE] utilizando Macro/Autoclick (CPS: clicks) [" + "avisos" + "]"),
		MACRODEFINITIVAMENTE(ChatColor.RED + "nick" + " está [DEFINITIVAMENTE] utilizando Macro/Autoclick (CPS: clicks) [" + "avisos" + "]"),
		
		FORCEFIELDTALVEZ(ChatColor.RED + "§c§l§c§lANTICHEAT§c " + "nick" + " está [TALVEZ] utilizando TriggerBot [" + "avisos" + "]"),
		FORCEFIELDPROVAVELMENTE(ChatColor.RED + "§c§lANTICHEAT§c " + "nick" + " está [PROVAVELMENTE] utilizando TriggerBot [" + "avisos" + "]"),
		FORCEFIELDDEFINITIVAMENTE(ChatColor.RED + "nick" + " está [DEFINITIVAMENTE] utilizando TriggerBot [" + "avisos" + "]"),
		
		FLY(ChatColor.RED + "§c§lANTICHEAT§c " + "nick" + " está utilizando Flight (MS: ping) [" + "avisos" + "]"),
		
		SPEED(ChatColor.RED + "§c§lANTICHEAT§c " + "nick" + " está utilizando Speed (MS: ping) [" + "avisos" + "]"),
		
		AUTOSOUPTALVEZ(ChatColor.RED + "§c§lANTICHEAT§c " + "nick" + " esta [TALVEZ] utilizando AUTOSOUP [" + "avisos" + "]"),
		AUTOSOUPPROVAVELMENTE(ChatColor.RED + "§c§lANTICHEAT§c " + "nick" + " está [PROVAVELMENTE] utilizando AUTOSOUP [" + "avisos" + "]"),
		AUTOSOUPDEFINITIVAMENTE(ChatColor.RED + "§c§lANTICHEAT§c " + "nick" + " está [DEFINITIVAMENTE] utilizando AUTOSOUP [" + "avisos" + "]");
		
		private String Menssagem;
		
		private Hack(String Menssagem) { this.Menssagem = Menssagem; }

		public String getMenssagem() {
			return this.Menssagem;
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void sendAntiCheat(String Menssagem) {
		
		for (Player playeres : Bukkit.getOnlinePlayers()) {
			if(cfGrupo.ChecarGrupo(playeres, "Dono") || cfGrupo.ChecarGrupo(playeres, "Gerente") || cfGrupo.ChecarGrupo(playeres, "Admin") || cfGrupo.ChecarGrupo(playeres, "Mod+") || cfGrupo.ChecarGrupo(playeres, "Mod") || cfGrupo.ChecarGrupo(playeres, "Trial") || cfGrupo.ChecarGrupo(playeres, "Youtuber+")){
			playeres.sendMessage(Menssagem);
			}
		}
	}

	public static boolean Flight(Player playeres) {
		return (playeres.getGameMode() == GameMode.CREATIVE) || (playeres.getAllowFlight());
	}

	public static boolean Speeding(Player playeres) {
	    return (playeres.getGameMode() == GameMode.CREATIVE) || (playeres.getAllowFlight());
	}

	public static void setPlayer(Player player) {
		AvisosFastClick.put(player, Integer.valueOf(1));
		AvisosMacro.put(player, Integer.valueOf(1));
		AvisosFly.put(player, Integer.valueOf(1));
		AvisosSpeed.put(player, Integer.valueOf(1));
		AvisosForcefield.put(player, Integer.valueOf(1));
		AvisosAutoSoup.put(player, Integer.valueOf(1));
		
		ClicksFastClicks.put(player, Integer.valueOf(1));
		ClicksMacro.put(player, Integer.valueOf(1));
	}
}
