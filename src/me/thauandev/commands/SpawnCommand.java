package me.thauandev.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.thauandev.API.API;
import me.thauandev.API.KitAPI;
import me.thauandev.API.TopKillStreak;
import me.thauandev.API.WarpsAPI;
import me.thauandev.main.Main;
import me.thauandev.scoreboard.sScoreAPI;

public class SpawnCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args) {
		
		Player p = (Player)Sender;
		if(Cmd.getName().equalsIgnoreCase("spawn")){

			p.sendMessage("§c§lSPEED§f§lMC §fVocê está sendo teleportado §fpara o Spawn!");
			p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 9999, 9999));
			p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 9999, 9999));
			
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
				@SuppressWarnings("deprecation")
				public void run() {
					
					  TopKillStreak.Ks.put(p, Integer.valueOf(0));
					  for (Player players : Bukkit.getOnlinePlayers()) {
						  TopKillStreak.KsTop.put(p, TopKillStreak.getKsTop(players));
						  TopKillStreak.Name.put(p, TopKillStreak.getNameTop(players));
						  sScoreAPI.scoreboard(players);
					 }
						WarpsAPI.Ir(p, "Spawn");
						API.setWarp(p, "Spawn");
						API.sendItems(p);
						KitAPI.removeKits(p);
						sScoreAPI.scoreboard(p);
					
					p.removePotionEffect(PotionEffectType.SLOW);
					p.removePotionEffect(PotionEffectType.BLINDNESS);
					
					p.setHealth(20.0D);
					p.setMaxHealth(20.0D);

				}
			}, 3*20);
		}
		return false;
	}

}
