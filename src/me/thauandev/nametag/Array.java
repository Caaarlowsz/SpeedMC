package me.thauandev.nametag;

import java.util.LinkedHashMap;

import org.bukkit.Bukkit;

import com.github.caaarlowsz.speedmc.kitpvp.SpeedPvP;

public class Array {

	public static LinkedHashMap<String, LinkedHashMap<String, String>> groups = null;
	public static LinkedHashMap<String, LinkedHashMap<String, String>> config = null;
	public static boolean tabListDisabled = false;
	public static boolean deathMessageEnabled = false;
	public static boolean checkForUpdatesEnabled = false;
	public static boolean consolePrintEnabled = false;
	public String permissions = "";
	public static String name = "";
	public static String type = "";
	public static String version = "";
	public String link = "";

	public static void InciarTag() {
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(SpeedPvP.getPlugin(), new Runnable() {
			public void run() {
				LinkedHashMap<String, LinkedHashMap<String, String>> JogadorData2 = new LinkedHashMap<String, LinkedHashMap<String, String>>();

				if (JogadorData2 != null) {
					for (String JogadorNome : JogadorData2.keySet()) {
						LinkedHashMap<String, String> JogadorData = (LinkedHashMap<String, String>) JogadorData2
								.get(JogadorNome);
						String Prefix = (String) JogadorData.get("prefix");
						String Suffix = (String) JogadorData.get("suffix");
						if (Prefix != null) {
							Prefix = NametagUtils.formatColors(Prefix);
						}
						if (Suffix != null) {
							Suffix = NametagUtils.formatColors(Suffix);
						}
						NametagManager.Overlap(JogadorNome, Prefix, Suffix);
					}
				}
			}
		});
	}

	public static void SetarNameTagHard(String Jogador, String Prefix, String Suffix,
			NameTagChangeEvento.NametagChangeReason Reac�o) {
		NameTagChangeEvento e = new NameTagChangeEvento(Jogador, NametagAPI.PegarPrefix(Jogador),
				NametagAPI.PegarSuffix(Jogador), Prefix, Suffix, NameTagChangeEvento.NametagChangeType.HARD, Reac�o);

		Bukkit.getServer().getPluginManager().callEvent(e);
		if (!e.isCancelled()) {
			NametagManager.Overlap(Jogador, Prefix, Suffix);
		}
	}

	public static void SetarNameTagSoft(String Jogador, String Prefix, String Suffix,
			NameTagChangeEvento.NametagChangeReason Reac�o) {
		NameTagChangeEvento e = new NameTagChangeEvento(Jogador, NametagAPI.PegarPrefix(Jogador),
				NametagAPI.PegarSuffix(Jogador), Prefix, Suffix, NameTagChangeEvento.NametagChangeType.SOFT, Reac�o);
		Bukkit.getServer().getPluginManager().callEvent(e);
		if (!e.isCancelled()) {
			NametagManager.Overlap(Jogador, Prefix, Suffix);
		}
	}
}
