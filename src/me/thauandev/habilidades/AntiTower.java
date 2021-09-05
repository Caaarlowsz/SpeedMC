package me.thauandev.habilidades;

import org.bukkit.event.entity.*;

import me.thauandev.API.KitAPI;

import org.bukkit.entity.*;
import org.bukkit.event.*;

public class AntiTower implements Listener
{
    @EventHandler
    public void aogalinha(final EntityDamageEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }
        if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
            final Player p = (Player)e.getEntity();
            if (KitAPI.getKit(p) == "AntiTower"){
                e.setDamage(6.0D);
            }
        }
    }
}