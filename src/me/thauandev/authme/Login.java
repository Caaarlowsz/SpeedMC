package me.thauandev.authme;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.thauandev.main.Main;

public class Login implements Listener {

	public static boolean premium(String nome) {
		try {
			URL url = new URL("https://minecraft.net/haspaid.jsp?user=" + nome);

			String prem = new BufferedReader(new InputStreamReader(url.openStream())).readLine().toUpperCase();

			boolean premium = Boolean.valueOf(prem).booleanValue();

			if (premium) {
				return true;
			}

		} catch (Exception e) {
			return false;
		}

		return false;
	}

	@EventHandler
	public void aoLogin(PlayerJoinEvent e) {
		final Player p = e.getPlayer();
		Main.login.add(p.getName());
		if (Main.plugin.getConfig().contains("Login." + p.getName().toLowerCase() + ".senha")) {
			Main.plugin.getServer().getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable() {
				public void run() {
					if (Main.login.contains(p.getName())) {
						p.sendMessage("§c§lSPEED§f§lMC §fPara efetuar seu registro, digite §c/login (senha)");
					}
				}
			}, 0, 100);
		}
		if (!Main.plugin.getConfig().contains("Login." + p.getName().toLowerCase() + ".senha")) {
			Main.plugin.getServer().getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable() {
				public void run() {
					if (Main.login.contains(p.getName())) {
						p.sendMessage("§c§lSPEED§f§lMC §fPara efetuar seu registro, digite §c/register (senha)");
					}
				}
			}, 0, 100);
		}

	}

}
