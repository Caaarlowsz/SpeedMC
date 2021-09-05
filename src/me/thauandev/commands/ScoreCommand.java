package me.thauandev.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thauandev.main.Main;
import me.thauandev.scoreboard.sScoreAPI;

public class ScoreCommand implements CommandExecutor{

	public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args) {
		
		Player p = (Player)Sender;
		
		if(Cmd.getName().equalsIgnoreCase("score")){
			if(sScoreAPI.Delay.contains(p)){
				p.sendMessage("§c§lSPEED§f§lMC §fAguarde para executar este comando novamente!");
				return true;
			}
			if(sScoreAPI.Score.contains(p)){
				p.sendMessage("§c§lSPEED§f§lMC §fA scoreboard foi desativada, para ativá-la novamente use §c/score");
				sScoreAPI.Score.remove(p);
				sScoreAPI.scorenull(p);
				sScoreAPI.Delay.add(p);
				
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
					public void run() {
						sScoreAPI.Delay.remove(p);
					}
				}, 6 * 20);
			}
			else if(!sScoreAPI.Score.contains(p)){
				p.sendMessage("§c§lSPEED§f§lMC §fA scoreboard foi ativada, para desativá-la novamente use §c/score");
				sScoreAPI.Score.add(p);
				sScoreAPI.scoreboard(p);
				sScoreAPI.Delay.add(p);
				
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
					public void run() {
						sScoreAPI.Delay.remove(p);
					}
				}, 6 * 20);
			}
		}
		return false;
	}
}
