package me.thauandev.events;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.help.HelpTopic;
import org.bukkit.potion.PotionEffectType;

import me.thauandev.API.API;
import me.thauandev.API.ArraysAPI;
import me.thauandev.API.KitAPI;
import me.thauandev.API.TopKillStreak;
import me.thauandev.API.WarpsAPI;
import me.thauandev.bans.Config;
import me.thauandev.commands.AdminCommand;
��o.cfGrupo;
import me.thauandev.configura��o.cfStatus;
��o;
import com.github.caaarlowsz.speedmc.kitpvp.SpeedPvP;
import me.thauandev.scoreboard.sScoreAPI;

public class eEvents implements Listener {

	@SuppressWarnings("static-access")
	@EventHandler
	public void login(PlayerLoginEvent e) {

		Player p = e.getPlayer();
		if (e.getResult() != e.getResult().KICK_WHITELIST) {
			API.checarNameTag(p);
		}
	}

	@EventHandler
	public void join(PlayerJoinEvent e) {

		e.setJoinMessage(null);

		Player p = e.getPlayer();

		Config.getConfig().getJogadores().set("Jogadores." + p.getUniqueId() + ".Nome", p.getName());
		Config.getConfig().getJogadores().set("Jogadores." + p.getUniqueId() + ".Grupo",
				cfGrupo.pegargrupo().get("grupos." + p.getUniqueId() + ".grupo"));
		Config.getConfig().getJogadores().set("Jogadores." + p.getUniqueId() + ".Coins", cfStatus.getMoney(p));
		Config.getConfig().getJogadores().set("Jogadores." + p.getUniqueId() + ".Kills", cfStatus.getKills(p));
		Config.getConfig().getJogadores().set("Jogadores." + p.getUniqueId() + ".Deaths", cfStatus.getDeaths(p));
		Config.getConfig().saveJogadores();

		p.setWalkSpeed(0.2F);
		Prote��o.setImortal(p, true);
		Prote��o.isImortal(p);
		p.getInventory().clear();
		p.getInventory().setArmorContents(null);
		p.setGameMode(GameMode.ADVENTURE);

		sScoreAPI.Score.add(p);
		ArraysAPI.Jogando.add(p);
		ArraysAPI.Admin.remove(p);

		API.setWarp(p, "Spawn");
		WarpsAPI.Ir(p, "Spawn");

		API.mandarTitulo(p, "�c�lSPEED�f�lMC");
		API.mandarSubTitulo(p, "�7Seja bem-vindo, �c" + p.getName());

		API.checarPermissao(p);

		API.checarGrupo(p);
		API.corGrupo(p);
		API.checarConfig(p);
		API.checarAlgumasCoisas(p);

		ArraysAPI.CooldownChat.remove(p);

		KitAPI.removeKits(p);
		AdminCommand.checarAdmin();

		p.removePotionEffect(PotionEffectType.SPEED);
		p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);

		p.setHealth(20.0D);
		p.setMaxHealth(20.0D);

		sScoreAPI.scoreboard(p);

		Bukkit.getScheduler().scheduleSyncDelayedTask(SpeedPvP.getPlugin(), new Runnable() {
			public void run() {
				API.sendItems(p);
			}
		}, 1L);

		for (int i = 1; i < 100; i++) {
			p.sendMessage(" ");
		}
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");

		p.sendMessage("�c�lSPEED�f�lMC");
		p.sendMessage(" ");
		p.sendMessage("�7Seja bem vindo ao servidor de �e�lKITPVP");
		p.sendMessage("�7Siga-nos no nosso �b�lTWITTER �7para saber as novidades �7(�chttp://twitter.com/speedmc_�7)");

		TopKillStreak.Ks.put(p, Integer.valueOf(0));
		for (Player players : Bukkit.getOnlinePlayers()) {
			TopKillStreak.KsTop.put(p, TopKillStreak.getKsTop(players));
			TopKillStreak.Name.put(p, TopKillStreak.getNameTop(players));
		}
		if (cfGrupo.ChecarGrupo(p, "Dono") || cfGrupo.ChecarGrupo(p, "Gerente")) {
			ArraysAPI.Monitor.add(p);
		}
		ArraysAPI.CooldownChat.remove(p);
	}

	@EventHandler
	public void death(PlayerDeathEvent e) {

		Player p = e.getEntity();
		Player d = e.getEntity().getKiller();
		WarpsAPI.Ir(p, "Spawn");
		API.setWarp(p, "Spawn");

		Bukkit.getScheduler().scheduleSyncDelayedTask(SpeedPvP.getPlugin(), new Runnable() {
			public void run() {
				p.spigot().respawn();
			}
		}, 1L);

		Bukkit.getScheduler().scheduleSyncDelayedTask(SpeedPvP.getPlugin(), new Runnable() {
			public void run() {
				API.sendItems(p);
			}
		}, 2L);

		if (KitAPI.getKit(p) != "1v1") {
			WarpsAPI.Ir(p, "Spawn");
			API.setWarp(p, "Spawn");
			KitAPI.removeKits(p);

			if (d != null) {

				p.sendMessage("�c�lSPEED�f�lMC �7Voce morreu para �c" + d.getName());
				p.sendMessage("�7� �6- �e50 moedas.");

				d.sendMessage("�c�lSPEED�f�lMC �7Voce matou �c" + p.getName());
				d.sendMessage("�7� �2+ �a1 XP�s. ");
				d.sendMessage("�7� �6+ �e100 moedas.");

				cfStatus.setKills(d);
				cfStatus.setDeaths(p);
				cfStatus.setMoney(d, 100);
				cfStatus.RemoveMoney(p, 50);
				cfStatus.RemoverKS(p);

				TopKillStreak.createTopKillStreak(d);

				sScoreAPI.scoreboard(p);
				sScoreAPI.scoreboard(d);

				e.setDeathMessage(null);
				e.getDrops().clear();

				if (TopKillStreak.getKsTop(p) == 5) {
					Bukkit.broadcastMessage("�3" + d.getName() + " �fest� com um �4�lKILLSTREAK �fde �3�l5");
				}
				if (TopKillStreak.getKsTop(p) == 10) {
					Bukkit.broadcastMessage("�3" + d.getName() + " �fest� com um �4�lKILLSTREAK �fde �3�l10");
				}
				if (TopKillStreak.getKsTop(p) == 15) {
					Bukkit.broadcastMessage("�3" + d.getName() + " �fest� com um �4�lKILLSTREAK �fde �3�l15");
				}
				if (TopKillStreak.getKsTop(p) == 20) {
					Bukkit.broadcastMessage("�3" + d.getName() + " �fest� com um �4�lKILLSTREAK �fde �3�l20");
				}
				if (TopKillStreak.getKsTop(p) == 25) {
					Bukkit.broadcastMessage("�3" + d.getName() + " �fest� com um �4�lKILLSTREAK �fde �3�l25");
				}
				if (TopKillStreak.getKsTop(p) == 30) {
					Bukkit.broadcastMessage("�3" + d.getName() + " �fest� com um �4�lKILLSTREAK �fde �3�l30");
				}
				if (TopKillStreak.getKsTop(p) == 35) {
					Bukkit.broadcastMessage("�3" + d.getName() + " �fest� com um �4�lKILLSTREAK �fde �3�l35");
				}
				if (TopKillStreak.getKsTop(p) == 40) {
					Bukkit.broadcastMessage("�3" + d.getName() + " �fest� com um �4�lKILLSTREAK �fde �3�l40");
				}
				if (TopKillStreak.getKsTop(p) == 45) {
					Bukkit.broadcastMessage("�3" + d.getName() + " �fest� com um �4�lKILLSTREAK �fde �3�l45");
				}
				if (TopKillStreak.getKsTop(p) == 50) {
					Bukkit.broadcastMessage("�3" + d.getName() + " �fest� com um �4�lKILLSTREAK �fde �3�l50");
				}
				if (TopKillStreak.getKsTop(p) == 55) {
					Bukkit.broadcastMessage("�3" + d.getName() + " �fest� com um �4�lKILLSTREAK �fde �3�l55");
				}
				if (TopKillStreak.getKsTop(p) == 60) {
					Bukkit.broadcastMessage("�3" + d.getName() + " �fest� com um �4�lKILLSTREAK �fde �3�l60");
				}
				if (TopKillStreak.getKsTop(p) == 65) {
					Bukkit.broadcastMessage("�3" + d.getName() + " �fest� com um �4�lKILLSTREAK �fde �3�l65");
				}
				if (TopKillStreak.getKsTop(p) == 70) {
					Bukkit.broadcastMessage("�3" + d.getName() + " �fest� com um �4�lKILLSTREAK �fde �3�l70");
				}
				if (TopKillStreak.getKsTop(p) == 75) {
					Bukkit.broadcastMessage("�3" + d.getName() + " �fest� com um �4�lKILLSTREAK �fde �3�l75");
				}
				if (TopKillStreak.getKsTop(p) == 80) {
					Bukkit.broadcastMessage("�3" + d.getName() + " �fest� com um �4�lKILLSTREAK �fde �3�l80");
				}
				if (TopKillStreak.getKsTop(p) == 85) {
					Bukkit.broadcastMessage("�3" + d.getName() + " �fest� com um �4�lKILLSTREAK �fde �3�l85");
				}
				if (TopKillStreak.getKsTop(p) == 90) {
					Bukkit.broadcastMessage("�3" + d.getName() + " �fest� com um �4�lKILLSTREAK �fde �3�l90");
				}
				if (TopKillStreak.getKsTop(p) == 95) {
					Bukkit.broadcastMessage("�3" + d.getName() + " �fest� com um �4�lKILLSTREAK �fde �3�l95");
				}
				if (TopKillStreak.getKsTop(p) == 100) {
					Bukkit.broadcastMessage("�3" + d.getName() + " �falcan�ou o �4�lKILLSTREAK �fm�ximo de �3�l100�f!");
				} else {
					e.setDeathMessage(null);
					e.getDrops().clear();

					TopKillStreak.Ks.put(p, Integer.valueOf(0));
					for (Player players : Bukkit.getOnlinePlayers()) {
						TopKillStreak.createTopKillStreak(players);
					}
				}
			}
		}
	}

	@EventHandler
	public void quit(PlayerQuitEvent e) {
		Player p = e.getPlayer();

		ArraysAPI.Jogando.remove(p);
		KitAPI.removeKits(p);
		e.setQuitMessage(null);

	}

	@EventHandler
	public void cmdnotfound(PlayerCommandPreprocessEvent e) {
		if (e.isCancelled()) {
			return;
		}
		Player p = e.getPlayer();
		String msg = e.getMessage().split(" ")[0];
		HelpTopic t = Bukkit.getServer().getHelpMap().getHelpTopic(msg);
		if (t == null) {
			e.setCancelled(true);
			p.sendMessage("�c�lSPEED�f�lMC �fEste comando nao existe�f!");
		}
	}

	@EventHandler
	void BuildConstruct(BlockPlaceEvent evento) {

		Player jogador = evento.getPlayer();
		if (jogador.getGameMode() != GameMode.CREATIVE) {
			evento.setCancelled(true);
		} else {
			evento.setCancelled(false);
		}
	}

	@EventHandler
	void BuildBreak(BlockBreakEvent evento) {

		Player jogador = evento.getPlayer();
		if (jogador.getGameMode() != GameMode.CREATIVE) {
			evento.setCancelled(true);
		} else {
			if ((jogador.getItemInHand().getTypeId() == 268) || (jogador.getItemInHand().getTypeId() == 272)
					|| (jogador.getItemInHand().getTypeId() == 267) || (jogador.getItemInHand().getTypeId() == 276)
					|| (jogador.getItemInHand().getTypeId() == 283)) {
				evento.setCancelled(true);
			} else {
				evento.setCancelled(false);
			}
		}
	}
}