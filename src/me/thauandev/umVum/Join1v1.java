 package me.thauandev.umVum;

import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
 public class Join1v1 implements Listener{
	 
   private static Itens Item = new Itens();
   
 public static ItemStack Item_ = Item.createItem(Material.BLAZE_ROD, "BLAZE_ROD", "§eDesafie um jogador! §8(botão direito)", new String[0], 1, (short)0);
  public static ItemStack Cinza = Item.createItem(Material.INK_SACK, "INK_SACK", "§eDuelo rápido! §8(botão direito)", new String[0], 1, (short)8);
 public static ItemStack Verde1 = Item.createItem(Material.INK_SACK, "INK_SACK", "§eProcurando partidas", new String[0], 1, (short)10);
   public static ItemStack Verde2 = Item.createItem(Material.INK_SACK, "INK_SACK", "§eProcurando partidas", new String[0], 1, (short)10);
  public static ItemStack Verde3 = Item.createItem(Material.INK_SACK, "INK_SACK", "§eProcurando partidas", new String[0], 1, (short)10);


}
