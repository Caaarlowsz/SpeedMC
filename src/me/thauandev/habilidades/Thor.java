package me.thauandev.habilidades;


import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import me.thauandev.API.CooldownAPI;
import me.thauandev.API.KitAPI;

public class Thor implements Listener{
	
	  @SuppressWarnings("deprecation")
	@EventHandler
	  public void ThorKit(PlayerInteractEvent e)
	  {
	    Player p = e.getPlayer();
	    if ((p.getItemInHand().getType() == Material.WOOD_AXE) && (e.getAction() == Action.RIGHT_CLICK_BLOCK) && 
	      (KitAPI.getKit(p) == "Thor")) {
	      if (CooldownAPI.Cooldown.containsKey(p.getName())) {
	    		p.sendMessage("§fO seu §3§lCOOLDOWN §facaba em: §c§l" + CooldownAPI.Cooldown(p) + "s");
	        return;
	      }

	     CooldownAPI.addCooldown(p, 5);
	      Location loc = p.getTargetBlock(null, 25).getLocation();
	      p.getWorld().strikeLightning(loc);
	      e.setCancelled(true);
	      p.damage(0.0D);
	    }
	  }

}
