package me.thauandev.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import me.thauandev.API.API;
import me.thauandev.API.KitAPI;
import me.thauandev.API.WarpsAPI;
import me.thauandev.configuração.cfStatus;
import me.thauandev.scoreboard.sScoreAPI;

public class PlacaCHALLENGE implements Listener {
	
	@EventHandler
	public void Escrever(SignChangeEvent e) {
		if(e.getLine(0).equalsIgnoreCase("lcfacil")) {
			e.setLine(0, "");
			e.setLine(1, "§c§lCHALLENGE");
			e.setLine(2, "");
			e.setLine(3, "§7(Fácil)");
		}
		
		if(e.getLine(0).equalsIgnoreCase("lcmedio")) {
			e.setLine(0, "");
			e.setLine(1, "§c§lCHALLENGE");
			e.setLine(2, "");
			e.setLine(3, "§7(Médio)");
		}
		
		if(e.getLine(0).equalsIgnoreCase("lcdificil")) {
			e.setLine(0, "");
			e.setLine(1, "§c§lCHALLENGE");
			e.setLine(2, "");
			e.setLine(3, "§7(Difícil)");
		}
		
		if(e.getLine(0).equalsIgnoreCase("lcextremo")) {
			e.setLine(0, "");
			e.setLine(1, "§c§lCHALLENGE");
			e.setLine(2, "");
			e.setLine(3, "§7(Extremo)");
		}
	}
	
	@EventHandler
	public void inv(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if((e.getAction() == Action.RIGHT_CLICK_BLOCK))
			if(e.getClickedBlock() != null)
			   if (e.getClickedBlock().getType() == Material.WALL_SIGN || (e.getClickedBlock().getType() == Material.SIGN_POST)) {
			Sign s = (Sign)e.getClickedBlock().getState();
			String[] lines = s.getLines();
			if ((lines.length > 0) && (lines[0].equals("")) && 
					(lines.length > 1) && (lines[1].equals("§c§lCHALLENGE"))&&
					(lines.length > 2) && (lines[2].equals("")) &&
					(lines.length > 3) && (lines[3].equals("§7(Fácil)") &&  	
							API.getWarp(p) == "Challenge")) {
				
				p.sendMessage("§c§lCHALLENGE §7Você completou o §e§lChallenge §ffácil!");
				
				cfStatus.setMoney(p, 200);
				
				p.getInventory().clear();
				p.getInventory().setArmorContents(null);
				
				KitAPI.removeKits(p);
				
				WarpsAPI.Ir(p, "Challenge");
				API.setWarp(p, "Challenge");
				KitAPI.setKitAntes(p, "Challenge");
				
				ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		        for(int i = 0; i < 36; i++){
		     	   p.getInventory().setItem(i, sopa);
		     	   p.updateInventory();
				}
				p.getInventory().setItem(13, API.criarItem(p, Material.RED_MUSHROOM, "", new String[] {}, 64, (short)0));
				p.getInventory().setItem(14, API.criarItem(p, Material.BROWN_MUSHROOM, "", new String[] {}, 64, (short)0));
				p.getInventory().setItem(15, API.criarItem(p, Material.BOWL, "", new String[] {}, 64, (short)0));
				
				sScoreAPI.scoreboard(p);
				
				p.sendMessage("§c§lCHALLENGE §7Você ganhou §9§l200XP§f.");
				
		}
			if ((lines.length > 0) && (lines[0].equals("")) && 
					(lines.length > 1) && (lines[1].equals("§c§lCHALLENGE"))&&
					(lines.length > 2) && (lines[2].equals("")) &&
					(lines.length > 3) && (lines[3].equals("§7(Médio)") &&
							API.getWarp(p) == "Challenge")) {
				
				p.sendMessage("§c§lCHALLENGE §7Você completou o §e§lChallenge §fmédio!");
				
				cfStatus.setMoney(p, 300);
				
				p.getInventory().clear();
				p.getInventory().setArmorContents(null);
				
				KitAPI.removeKits(p);
				
				WarpsAPI.Ir(p, "Challenge");
				API.setWarp(p, "Challenge");
				KitAPI.setKitAntes(p, "Challenge");
				
				ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		        for(int i = 0; i < 36; i++){
		     	   p.getInventory().setItem(i, sopa);
		     	   p.updateInventory();
				}
				p.getInventory().setItem(13, API.criarItem(p, Material.RED_MUSHROOM, "", new String[] {}, 64, (short)0));
				p.getInventory().setItem(14, API.criarItem(p, Material.BROWN_MUSHROOM, "", new String[] {}, 64, (short)0));
				p.getInventory().setItem(15, API.criarItem(p, Material.BOWL, "", new String[] {}, 64, (short)0));
				
				sScoreAPI.scoreboard(p);
				
				p.sendMessage("§c§lCHALLENGE §7Você ganhou §9§l300XP§f.");
				
		}
			if ((lines.length > 0) && (lines[0].equals("")) && 
					(lines.length > 1) && (lines[1].equals("§c§lCHALLENGE"))&&
					(lines.length > 2) && (lines[2].equals("")) &&
					(lines.length > 3) && (lines[3].equals("§7(Difícil)") &&
							API.getWarp(p) == "Challenge")) {
				
				p.sendMessage("§c§lCHALLENGE §7Você completou o §e§lChallenge §fdifícil!");
				
				
				cfStatus.setMoney(p, 500);
				
				p.getInventory().clear();
				p.getInventory().setArmorContents(null);
				
				KitAPI.removeKits(p);
				
				WarpsAPI.Ir(p, "Challenge");
				API.setWarp(p, "Challenge");
				KitAPI.setKitAntes(p, "Challenge");
				
				ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		        for(int i = 0; i < 36; i++){
		     	   p.getInventory().setItem(i, sopa);
		     	   p.updateInventory();
				}
				p.getInventory().setItem(13, API.criarItem(p, Material.RED_MUSHROOM, "", new String[] {}, 64, (short)0));
				p.getInventory().setItem(14, API.criarItem(p, Material.BROWN_MUSHROOM, "", new String[] {}, 64, (short)0));
				p.getInventory().setItem(15, API.criarItem(p, Material.BOWL, "", new String[] {}, 64, (short)0));
				
				sScoreAPI.scoreboard(p);
				
				p.sendMessage("§c§lCHALLENGE §7Você ganhou §9§l500XP§f.");
				
		}
			
			if ((lines.length > 0) && (lines[0].equals("")) && 
					(lines.length > 1) && (lines[1].equals("§c§lCHALLENGE"))&&
					(lines.length > 2) && (lines[2].equals("")) &&
					(lines.length > 3) && (lines[3].equals("§7(Extremo)") &&
							API.getWarp(p) == "Challenge")) {
				
				p.sendMessage("§c§lCHALLENGE §7Você completou o §e§lChallenge §fExtremo");
				
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage("§c§lCHALLENGE §7Parabens §c" + p.getName() + " §7Por Completou o nível §e§lExtremo §fdo §c§lChallende§f!");
				Bukkit.broadcastMessage(" ");
				
				cfStatus.setMoney(p, 1000);
				
				
				p.getInventory().clear();
				p.getInventory().setArmorContents(null);
				
				KitAPI.removeKits(p);
				
				WarpsAPI.Ir(p, "Challenge");
				API.setWarp(p, "Challenge");
				KitAPI.setKitAntes(p, "Challenge");
				
				ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		        for(int i = 0; i < 36; i++){
		     	   p.getInventory().setItem(i, sopa);
		     	   p.updateInventory();
				}
				p.getInventory().setItem(13, API.criarItem(p, Material.RED_MUSHROOM, "", new String[] {}, 64, (short)0));
				p.getInventory().setItem(14, API.criarItem(p, Material.BROWN_MUSHROOM, "", new String[] {}, 64, (short)0));
				p.getInventory().setItem(15, API.criarItem(p, Material.BOWL, "", new String[] {}, 64, (short)0));
				
				sScoreAPI.scoreboard(p);
				
				p.sendMessage("§c§lCHALLENGE §7Você ganhou §9§l1000XP§f.");
				
		}
			
			}

	    }
}
