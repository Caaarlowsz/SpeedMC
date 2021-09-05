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
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PlacaSopas implements Listener {
	
	@EventHandler
	public void Escrever(SignChangeEvent e) {
		if(e.getLine(0).equalsIgnoreCase("sopas")) {
			e.setLine(0, " ");
			e.setLine(1, "§c§lSPEED§f§lMC");
			e.setLine(2, " §7(Sopas)");
			e.setLine(3, " ");
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
			if ((lines.length > 0) && (lines[0].equals(" ")) && 
					(lines.length > 1) && (lines[1].equals("§c§lSPEED§f§lMC"))&&
					(lines.length > 2) && (lines[2].equals(" §7(Sopas)")) &&
					(lines.length > 3) && (lines[3].equals(" "))) {
				Inventory inv = Bukkit.createInventory(p, 54, "§bSopas");
				
				ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
				
				for(int i =0; i != 54; i++) {
					inv.setItem(i, sopa);
				}
				p.openInventory(inv);
			
		}}

	    }
} 