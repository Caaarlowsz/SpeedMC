package me.thauandev.configuração;

import java.io.File;
import java.io.IOException;

import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class cfGrupo {

	private static FileConfiguration player_grupo;
	private static File playergrupo;

	public static void setarconfig(Plugin plugin) {

		if (!plugin.getDataFolder().exists()) {
			plugin.getDataFolder().mkdir();
		}
		playergrupo = new File(plugin.getDataFolder(), "grupos.yml");
		if (playergrupo.exists()) {
			try {
				playergrupo.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		player_grupo = YamlConfiguration.loadConfiguration(playergrupo);
	}

	public static FileConfiguration pegargrupo() {
		return player_grupo;
	}

	public static void salvarconfiguracao() {
		try {
			player_grupo.save(playergrupo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static boolean ChecarGrupo(Player p, String Grupo) {
		if (pegargrupo().get("grupos." + p.getUniqueId() + ".grupo").equals(Grupo)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean ChecarGrupo(OfflinePlayer p, String Grupo) {
		if (pegargrupo().get("grupos." + p.getUniqueId() + ".grupo").equals(Grupo)) {
			return true;
		} else {
			return false;
		}
	}

	public static void setarGrupo(Player p, String Grupo) {

		pegargrupo().set("grupos." + p.getUniqueId() + ".Nick", p.getName());
		pegargrupo().set("grupos." + p.getUniqueId() + ".grupo", Grupo);
		cfGrupo.salvarconfiguracao();
	}

	public static void setarGrupo(OfflinePlayer p, String Grupo) {

		pegargrupo().set("grupos." + p.getUniqueId() + ".Nick", p.getName());
		pegargrupo().set("grupos." + p.getUniqueId() + ".grupo", Grupo);
		cfGrupo.salvarconfiguracao();
	}
}
