package me.thauandev.habilidades;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import me.thauandev.API.CooldownAPI;
import me.thauandev.API.KitAPI;
import com.github.caaarlowsz.speedmc.kitpvp.SpeedPvP;

public class Ajnin implements Listener {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static HashMap<Player, Player> a = new HashMap();

	@EventHandler
	public void a(EntityDamageByEntityEvent e) {
		if (((e.getDamager() instanceof Player)) && ((e.getEntity() instanceof Player))) {
			final Player hitou = (Player) e.getDamager();
			Player hitado = (Player) e.getEntity();
			if (KitAPI.getKit(hitou) == "Ajnin" && !a.containsKey(hitou)) {
				a.put(hitou, hitado);

				Bukkit.getScheduler().scheduleSyncDelayedTask(SpeedPvP.getPlugin(), new Runnable() {
					public void run() {
						a.remove(hitou);
						a.remove(hitado);
					}
				}, 11 * 20);
			}
		}
	}

	@EventHandler
	public void a(PlayerToggleSneakEvent e) {
		Player hitou = e.getPlayer();
		if ((e.isSneaking()) && (KitAPI.getKit(hitou) == "Ajnin")
				&& (CooldownAPI.Cooldown.containsKey(hitou.getName()))) {
			hitou.sendMessage("�fO seu �3�lCOOLDOWN �facaba em: �c�l" + CooldownAPI.Cooldown(hitou) + "s");
			return;
		}

		if ((e.isSneaking()) && (KitAPI.getKit(hitou) == "Ajnin") && (a.containsKey(hitou))) {
			Player hitado = (Player) a.get(hitou);

			if ((hitado != null)) {
				if (Gladiator.noExecut.contains(hitado)) {
					hitou.sendMessage("�cEste jogador est� em um duelo nas alturas!");
					return;
				}
				if (Gladiator.noExecut.contains(hitou)) {
					hitou.sendMessage("�cVoc� n�o pode utilizar o kit Ninja durante um duelo no Gladiator!");
					return;
				}
				if (hitou.getLocation().distance(hitado.getLocation()) < 40.0D) {

					hitado.teleport(hitou.getLocation());
					CooldownAPI.addCooldown(hitou, 7);
				} else {
					hitou.sendMessage("�cO �ltimo jogador hitado est� muito longe!");
				}
			}
		}
	}
}