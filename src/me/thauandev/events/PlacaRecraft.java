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
import org.bukkit.inventory.meta.ItemMeta;

public class PlacaRecraft implements Listener {

	@EventHandler
	public void Escrever(SignChangeEvent e) {
		if (e.getLine(0).equalsIgnoreCase("recraft")) {
			e.setLine(0, "");
			e.setLine(1, "§c§lSPEED§f§lMC");
			e.setLine(2, " §7(Recraft)");
			e.setLine(3, "");
		}

	}

	@EventHandler
	public void Inv(PlayerInteractEvent e) {
		Player p = (Player) e.getPlayer();
		if ((e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& (e.getClickedBlock() != null && (e.getClickedBlock().getType() == Material.WALL_SIGN)
						|| (e.getClickedBlock().getType() == Material.SIGN_POST))) {
			Sign s = (Sign) e.getClickedBlock().getState();
			String[] lines = s.getLines();
			if ((lines.length > 0) && (lines[0].equals("")) && (lines.length > 1)
					&& (lines[1].equals("§c§lSPEED§f§lMC")) && (lines.length > 2) && (lines[2].equals(" §7(Recraft)"))
					&& (lines.length > 3) && (lines[3].equals(""))) {
				Inventory inv = Bukkit.createInventory(p, 27, "§3§lRecraft");
				ItemStack cogu1 = new ItemStack(Material.RED_MUSHROOM, 64);
				ItemMeta cogu1meta = cogu1.getItemMeta();
				cogu1meta.setDisplayName("§cCogumelo");
				cogu1.setItemMeta(cogu1meta);

				ItemStack cogu2 = new ItemStack(Material.BROWN_MUSHROOM, 64);
				ItemMeta cogu2meta = cogu2.getItemMeta();
				cogu2meta.setDisplayName("§eCogumelo");
				cogu2.setItemMeta(cogu2meta);

				ItemStack potes = new ItemStack(Material.BOWL, 64);
				ItemMeta potesmeta = potes.getItemMeta();
				potesmeta.setDisplayName("§9Pote");
				potes.setItemMeta(potesmeta);

				inv.setItem(0, cogu2);
				inv.setItem(1, potes);
				inv.setItem(2, cogu1);
				inv.setItem(5, cogu1);
				inv.setItem(4, potes);
				inv.setItem(3, cogu2);
				inv.setItem(6, cogu2);
				inv.setItem(7, potes);
				inv.setItem(8, cogu1);
				inv.setItem(9, cogu2);
				inv.setItem(10, potes);
				inv.setItem(11, cogu1);
				inv.setItem(12, cogu2);
				inv.setItem(13, potes);
				inv.setItem(14, cogu1);
				inv.setItem(15, cogu2);
				inv.setItem(16, potes);
				inv.setItem(17, cogu1);
				inv.setItem(18, cogu2);
				inv.setItem(19, potes);
				inv.setItem(20, cogu1);
				inv.setItem(21, cogu2);
				inv.setItem(22, potes);
				inv.setItem(23, cogu1);
				inv.setItem(24, cogu2);
				inv.setItem(25, potes);
				inv.setItem(26, cogu1);

				p.openInventory(inv);
			}
		}
	}
}