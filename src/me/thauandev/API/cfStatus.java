
package me.thauandev.API;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import me.thauandev.main.Main;

public class cfStatus {

	public static File file;
	public static FileConfiguration cfile;

	public cfStatus() {
		Plugin plugin = Main.getPlugin();

		if (plugin.getDataFolder().exists() == false) {
			plugin.getDataFolder().mkdir();
		}
		file = new File(plugin.getDataFolder(), "NADAAQUI.yml");
		if (file.exists() == false) {
			try {
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		cfile = YamlConfiguration.loadConfiguration(file);
	}

	public static void FirstJoin(Player jogador) {
		if (cfile.getString(jogador.getName() + ".UUID") == null) {
			cfile.set(jogador.getName() + ".UUID", jogador.getUniqueId().toString());
			Save();
		}
	}

	public static void setKills(Player p) {
		cfile.set(p.getName() + ".Kills", getKills(p) + 1);
		cfile.set(p.getName() + ".Ks", getKillStreak(p) + 1);
		TopKillStreak.Ks.put(p, Integer.valueOf(TopKillStreak.Ks.get(p) + 1));
		Save();
	}

	public static int getKills(Player p) {
		return cfile.getInt(p.getName() + ".Kills");
	}

	public static int getKillStreak(Player p) {
		return cfile.getInt(p.getName() + ".Ks");
	}

	public static void setDeaths(Player p) {
		cfile.set(p.getName() + ".Deaths", getDeaths(p) + 1);
		Save();
	}

	public static int getDeaths(Player p) {
		return cfile.getInt(p.getName() + ".Deaths");
	}

	public static void setMoney(Player p, int Money) {
		cfile.set(p.getName() + ".Money", getMoney(p) + Money);
		Save();
	}

	public static void RemoveMoney(Player p, int Money) {
		if (getMoney(p) <= 0) {
			return;
		}
		cfile.set(p.getName() + ".Money", getMoney(p) - Money);
		Save();
	}

	public static void RemoverKS(Player p) {
		cfile.set(p.getName() + ".Ks", getKillStreak(p) - getKillStreak(p));

		TopKillStreak.Ks.put(p, Integer.valueOf(0));
		for (Player players : Bukkit.getOnlinePlayers()) {
			TopKillStreak.createTopKillStreak(players);
		}
		Save();
	}

	public static int getMoney(Player p) {
		return cfile.getInt(p.getName() + ".Money");
	}

	public static void Save() {
		try {
			cfile.save(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void addKills(Player p) {
	}
}
