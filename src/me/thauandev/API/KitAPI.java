package me.thauandev.API;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.thauandev.commands.FlyCommand;
import me.thauandev.invencivel.Proteção;
import me.thauandev.main.Main;
import me.thauandev.scoreboard.sScoreAPI;

public class KitAPI{
	private static HashMap<Player, String> Kit = new HashMap<>();
	private static HashMap<Player, String> KitAntes = new HashMap<>();
	
	public static String getKit(Player p){
	
		if (Kit.containsKey(p)) {
			return Kit.get(p);
		} else {
			return "Nenhum";
		}
	}
	public static String getKitAntes(Player p){
		
		if (KitAntes.containsKey(p)) {
			return KitAntes.get(p);
		} else {
			return "Nenhum";
		}
	}
	
	public static void setKit(Player p, String kit){
		Kit.put(p, kit);
	}
	public static void setKitAntes(Player p, String kit){
		KitAntes.put(p, kit);
	}
	public static void removeKits(Player p){
		Kit.remove(p);
		KitAntes.remove(p);
	}
	
	public static void darKit(Player p, String kit){

		if(p.getLocation().getY() < 160){
		p.setGameMode(GameMode.SURVIVAL);
		p.setAllowFlight(false);
		p.getInventory().setArmorContents(null);
		p.getInventory().clear();
		   API.setWarp(p, "Arena");
		sScoreAPI.scoreboard(p);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(),new Runnable() {
			public void run() {
		Proteção.setImortal(p, false);
			}
		}, 20L);
		FlyCommand.Fly.remove(p);
		
		ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
        for(int i = 0; i < 36; i++){
     	   p.getInventory().setItem(i, sopa);
     	   p.updateInventory();
		}
		p.getInventory().setItem(14, API.criarItem(p, Material.RED_MUSHROOM, "§cCogumelo", new String[] {""}, 64, (short)0));
		p.getInventory().setItem(15, API.criarItem(p, Material.BROWN_MUSHROOM, "§eCogumelo", new String[] {""}, 64, (short)0));
		p.getInventory().setItem(13, API.criarItem(p, Material.BOWL, "§9Pote", new String[] {""}, 64, (short)0));
		p.getInventory().setItem(8, API.criarItem(p, Material.COMPASS, "§bBússola", new String[] {""}, 1, (short)0));
		
		if (getKitAntes(p) == "PvP"){
			
			ItemStack Espada = new ItemStack(Material.STONE_SWORD);
			ItemMeta kEspada = Espada.getItemMeta();
			kEspada.setDisplayName("§bEspada");
			Espada.setItemMeta(kEspada);
			
            p.getInventory().setItem(0, Espada);  
           
		}else{
			ItemStack Espada = new ItemStack(Material.STONE_SWORD);
			ItemMeta kEspada = Espada.getItemMeta();
			kEspada.setDisplayName("§bEspada");
			Espada.setItemMeta(kEspada);
			
            p.getInventory().setItem(0, Espada);  
		}
		   if (getKitAntes(p) == "Kangaroo"){
				
				ItemStack Item = new ItemStack(Material.FIREWORK);
				ItemMeta kItem = Item.getItemMeta();
				kItem.setDisplayName("§b" + KitAPI.getKitAntes(p));
				Item.setItemMeta(kItem);
				
	            p.getInventory().setItem(1, Item);  
				}
		   if (getKitAntes(p) == "MiniGun"){
				
				ItemStack Item = new ItemStack(Material.ARROW);
				ItemMeta kItem = Item.getItemMeta();
				kItem.setDisplayName("§b" + KitAPI.getKitAntes(p));
				Item.setItemMeta(kItem);
				
	            p.getInventory().setItem(1, Item);  
				}
			   if (getKitAntes(p) == "Archer"){
				
				ItemStack Item = new ItemStack(Material.BOW);
				Item.addEnchantment(Enchantment.ARROW_INFINITE, 1);
				ItemMeta kItem = Item.getItemMeta();
				kItem.setDisplayName("§b" + KitAPI.getKitAntes(p));
				Item.setItemMeta(kItem);
				
				ItemStack Item1 = new ItemStack(Material.ARROW);
				ItemMeta kItem1 = Item1.getItemMeta();
				kItem1.setDisplayName("§b" + KitAPI.getKitAntes(p));
				Item1.setItemMeta(kItem1);
				
	            p.getInventory().setItem(1, Item); 
	            p.getInventory().setItem(9, Item1); 
				}
			   if (getKitAntes(p) == "Grappler"){
				
				ItemStack Item = new ItemStack(Material.LEASH);
				ItemMeta kItem = Item.getItemMeta();
				kItem.setDisplayName("§b" + KitAPI.getKitAntes(p));
				Item.setItemMeta(kItem);
				
	            p.getInventory().setItem(1, Item); 
			   }
			   if (getKitAntes(p) == "Specialist"){
				
				ItemStack Item = new ItemStack(Material.ENCHANTED_BOOK);
				ItemMeta kItem = Item.getItemMeta();
				kItem.setDisplayName("§b" + KitAPI.getKitAntes(p));
				Item.setItemMeta(kItem);
				
	            p.getInventory().setItem(1, Item); 
				}
			   if (getKitAntes(p) == "Gladiator"){
				
				ItemStack Item = new ItemStack(Material.IRON_FENCE);
				ItemMeta kItem = Item.getItemMeta();
				kItem.setDisplayName("§b" + KitAPI.getKitAntes(p));
				Item.setItemMeta(kItem);
				
	            p.getInventory().setItem(1, Item); 
				}
			   if (getKitAntes(p) == "Fisherman"){
				
				ItemStack Item = new ItemStack(Material.FISHING_ROD);
				ItemMeta kItem = Item.getItemMeta();
				kItem.setDisplayName("§b" + KitAPI.getKitAntes(p));
				Item.setItemMeta(kItem);
				
	            p.getInventory().setItem(1, Item); 
				}
			   if (getKitAntes(p) == "Monk"){
				
				ItemStack Item = new ItemStack(Material.BLAZE_ROD);
				ItemMeta kItem = Item.getItemMeta();
				kItem.setDisplayName("§b" + KitAPI.getKitAntes(p));
				Item.setItemMeta(kItem);
				
	            p.getInventory().setItem(1, Item); 
				}
			   if (getKitAntes(p) == "Phantom"){
				
				ItemStack Item = new ItemStack(Material.FEATHER);
				ItemMeta kItem = Item.getItemMeta();
				kItem.setDisplayName("§b" + KitAPI.getKitAntes(p));
				Item.setItemMeta(kItem);
				
	            p.getInventory().setItem(1, Item); 
				}
			   if (getKitAntes(p) == "Thor"){
				
				ItemStack Item = new ItemStack(Material.WOOD_AXE);
				ItemMeta kItem = Item.getItemMeta();
				kItem.setDisplayName("§b" + KitAPI.getKitAntes(p));
				Item.setItemMeta(kItem);
				
	            p.getInventory().setItem(1, Item); 
				}
			   if (getKitAntes(p) == "Stomper"){
				
				ItemStack Item = new ItemStack(Material.GOLDEN_APPLE);
				ItemMeta kItem = Item.getItemMeta();
				kItem.setDisplayName("§b" + KitAPI.getKitAntes(p));
				Item.setItemMeta(kItem);
				
	            p.getInventory().setItem(1, Item); 
				}
			   if (getKitAntes(p) == "Timelord"){
				
				ItemStack Item = new ItemStack(Material.WATCH);
				ItemMeta kItem = Item.getItemMeta();
				kItem.setDisplayName("§b" + KitAPI.getKitAntes(p));
				Item.setItemMeta(kItem);
				
	            p.getInventory().setItem(1, Item); 
				}
			   if (getKitAntes(p) == "Cactus"){
				
				ItemStack Item = new ItemStack(Material.CACTUS);
				ItemMeta kItem = Item.getItemMeta();
				kItem.addEnchant(Enchantment.THORNS, 2, true);
				kItem.setDisplayName("§b" + KitAPI.getKitAntes(p));
				Item.setItemMeta(kItem);
				
	            p.getInventory().setHelmet(Item);
				}
			   if (getKitAntes(p) == "Grandpa"){
				
				ItemStack Item = new ItemStack(Material.STICK);
				ItemMeta kItem = Item.getItemMeta();
				kItem.addEnchant(Enchantment.KNOCKBACK, 3, true);
				kItem.setDisplayName("§b" + KitAPI.getKitAntes(p));
				Item.setItemMeta(kItem);
				
	            p.getInventory().setItem(1, Item); 
				}
			   if (getKitAntes(p) == "Switcher"){
				
				ItemStack Item = new ItemStack(Material.SNOW_BALL, 10);
				ItemMeta kItem = Item.getItemMeta();
				kItem.setDisplayName("§b" + KitAPI.getKitAntes(p));
				Item.setItemMeta(kItem);
				
				  p.getInventory().setItem(1, Item); 
			   }
			   if (getKitAntes(p) == "FireLauncher"){
				
				ItemStack Item = new ItemStack(Material.BLAZE_POWDER);
				ItemMeta kItem = Item.getItemMeta();
				kItem.setDisplayName("§b" + KitAPI.getKitAntes(p));
				Item.setItemMeta(kItem);
				
	            p.getInventory().setItem(1, Item); 
				}
			   if (getKitAntes(p) == "Strong"){
				
				ItemStack Item = new ItemStack(Material.WATCH);
				ItemMeta kItem = Item.getItemMeta();
				kItem.setDisplayName("§b" + KitAPI.getKitAntes(p));
				Item.setItemMeta(kItem);
				
	            p.getInventory().setItem(1, Item); 
				}
			   if (getKitAntes(p) == "Forcefield"){
				
				ItemStack Item = new ItemStack(Material.IRON_FENCE);
				ItemMeta kItem = Item.getItemMeta();
				kItem.setDisplayName("§b" + KitAPI.getKitAntes(p));
				Item.setItemMeta(kItem);
				
	            p.getInventory().setItem(1, Item); 
				}
			   if (getKitAntes(p) == "Sumo"){
				
				ItemStack Item = new ItemStack(Material.APPLE);
				ItemMeta kItem = Item.getItemMeta();
				kItem.setDisplayName("§b" + KitAPI.getKitAntes(p));
				Item.setItemMeta(kItem);
				
	            p.getInventory().setItem(1, Item); 
			   }
			}
		}
	}