package me.thauandev.umVum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;

import me.thauandev.API.API;
import me.thauandev.API.KitAPI;
import me.thauandev.API.WarpsAPI;
import me.thauandev.configura��o.cfGrupo;
import me.thauandev.invencivel.Prote��o;
import me.thauandev.main.Main;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class Events1v1 implements Listener {
	public static List<Player> ChamouDuelo = new ArrayList();
	public static List<Player> AceitarDuelo = new ArrayList();
	public static List<Player> Jogando1v1Player = new ArrayList();
	public static List<Player> congelar = new ArrayList();
	public static List<Player> inPvP = new ArrayList();
	public static HashMap<String, String> JogandoSair = new HashMap();

	@EventHandler
	public void PlayerInteractEntityEvent4(PlayerInteractEntityEvent event) {
		final Player p = event.getPlayer();

		if (!(event.getRightClicked() instanceof Player)) {
			return;
		}
		if (p.getItemInHand().equals(Join1v1.Item_)) {
			if (ChamouDuelo.contains(p)) {
				p.sendMessage("�cAguarde para desafiar outro jogador...");
				return;
			}
			final Player Player2 = (Player) event.getRightClicked();

			AceitarDuelo.add(Player2);
			ChamouDuelo.add(p);
			p.sendMessage("�c�lSPEED�f�lMC �fVoc� desafiou o jogador: �c" + Player2.getName() + " �fpara um duelo!");
			Player2.sendMessage("�c�lSPEED�f�lMC �fVoc� foi desafiado por: �c" + p.getName() + " �fpara um duelo!");
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
				public void run() {
					if (Events1v1.ChamouDuelo.contains(p)) {
						Events1v1.ChamouDuelo.remove(p);
						Events1v1.AceitarDuelo.remove(Player2);
					}
				}
			}, 100L);
		}
	}

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event) {
		final Player player = event.getPlayer();
		if (congelar.contains(player)) {
			event.setTo(player.getLocation());
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
				public void run() {
					Events1v1.congelar.remove(player);
				}
			}, 60L);
		}
	}

	@EventHandler
	public void PlayerInteractEntityEvent3(PlayerInteractEntityEvent event) {
		final Player p = event.getPlayer();

		if (!(event.getRightClicked() instanceof Player)) {
			return;
		}
		if (AceitarDuelo.contains(p)) {
			if (p.getItemInHand().equals(Join1v1.Item_)) {
				final Player Player2 = (Player) event.getRightClicked();
				if (ChamouDuelo.contains(Player2)) {
					Jogando1v1Player.add(p);
					Jogando1v1Player.add(Player2);
					JogandoSair.put(p.getName(), Player2.getName());
					JogandoSair.put(Player2.getName(), p.getName());
					congelar.add(p);
					congelar.add(Player2);

					Prote��o.setImortal(Player2, false);
					Prote��o.setImortal(p, false);

					WarpsAPI.Ir(Player2, "1v1loc2");
					WarpsAPI.Ir(p, "1v1loc1");

					ChamouDuelo.remove(Player2);
					AceitarDuelo.remove(Player2);
					ChamouDuelo.remove(p);
					AceitarDuelo.remove(p);

					inPvP.add(p);
					inPvP.add(Player2);

					p.getInventory().clear();
					Player2.getInventory().clear();
					ItemStack Espada = new ItemStack(Material.DIAMOND_SWORD);
					Espada.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
					ItemMeta Espada2 = Espada.getItemMeta();
					Espada2.setDisplayName("�5�oEspada");
					Espada.setItemMeta(Espada2);
					p.getInventory().addItem(new ItemStack[] { Espada });
					Player2.getInventory().addItem(new ItemStack[] { Espada });

					Player2.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
					Player2.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
					Player2.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
					Player2.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));

					p.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
					p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
					p.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
					p.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));

					for (int i = 1; i < 9; i++) {
						ItemStack Fisherman = new ItemStack(Material.MUSHROOM_SOUP);
						p.getInventory().addItem(new ItemStack[] { Fisherman });
						Player2.getInventory().addItem(new ItemStack[] { Fisherman });
						Player2.updateInventory();
						p.updateInventory();
						if (Speed1v1.Iniciou.contains(p)) {
							Speed1v1.Iniciou.remove(p);
							Speed1v1.Partida1 = false;
						}

						if (Speed1v1.Iniciou.contains(Player2)) {
							Speed1v1.Iniciou.remove(Player2);
							Speed1v1.Partida1 = false;
						}
						Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
							public void run() {
								for (Player plr : Bukkit.getOnlinePlayers()) {
									Player2.hidePlayer(plr);
									p.hidePlayer(plr);
									p.showPlayer(Player2);
									Player2.showPlayer(p);
								}
							}
						}, 2L);
						Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
							public void run() {
								if (Events1v1.congelar.contains(p)) {
									p.setMaxHealth(20);
									p.setHealth(20);
									Player2.setMaxHealth(20);
									Player2.setHealth(20);
								}
							}
						}, 20L);
						Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
							public void run() {
								if (Events1v1.congelar.contains(p)) {
									p.setMaxHealth(20);
									p.setHealth(20);
									Player2.setMaxHealth(20);
									Player2.setHealth(20);
								}
							}
						}, 40L);
						Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
							public void run() {
								if (Events1v1.congelar.contains(p)) {
									p.setMaxHealth(20);
									p.setHealth(20);
									Player2.setMaxHealth(20);
									Player2.setHealth(20);
									Events1v1.congelar.remove(p);
								}
							}
						}, 60L);
					}
				}
			}
		}
	}

	@EventHandler
	public void Morrer2(PlayerDeathEvent e) {
		Player v = e.getEntity();
		e.setDeathMessage("");
		if ((e.getEntity().getKiller() instanceof Player)) {
			Player m = e.getEntity().getKiller();
			if (m != v) {
				if ((Jogando1v1Player.contains(m)) || (Jogando1v1Player.contains(v))) {
					int amountv = itemsInInventory(v.getInventory(), new Material[] { Material.MUSHROOM_SOUP });
					int amountm = itemsInInventory(m.getInventory(), new Material[] { Material.MUSHROOM_SOUP });

					inPvP.remove(m);
					inPvP.remove(v);

					m.sendMessage("     ");
					m.sendMessage(
							"�aVoc� ganhou o duelo contra " + v.getName() + "�a com �a�l" + amountv + " �asopas.");
					m.sendMessage("     ");

					Prote��o.setImortal(v, true);
					Prote��o.setImortal(m, true);

					v.sendMessage("     ");
					v.sendMessage("�cVoc� perdeu o duelo contra " + m.getName() + ". �cO jogador estava com �c�l"
							+ amountm + " �csopas.");
					v.sendMessage("     ");

					WarpsAPI.Ir(m, "1v1");
					m.setGameMode(GameMode.SURVIVAL);
					m.getInventory().setArmorContents(null);
					m.getInventory().clear();

					for (PotionEffect effect : m.getActivePotionEffects()) {
						m.removePotionEffect(effect.getType());
					}
					Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
						public void run() {
							WarpsAPI.Ir(v, "1v1");
							v.setGameMode(GameMode.SURVIVAL);
							v.getInventory().setArmorContents(null);
							v.getInventory().clear();

							for (PotionEffect effect : v.getActivePotionEffects()) {
								v.removePotionEffect(effect.getType());
							}
						}
					}, 1L);
					KitAPI.setKit(m, "1v1");
					KitAPI.setKit(v, "1v1");
					Jogando1v1Player.remove(v);
					Jogando1v1Player.remove(m);
					JogandoSair.remove(m.getName());
					JogandoSair.remove(v.getName());

					Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
						public void run() {
							v.getInventory().clear();
							m.getInventory().clear();
							v.getInventory().setItem(3, Join1v1.Item_);
							v.getInventory().setItem(5, Join1v1.Cinza);
							m.getInventory().setItem(3, Join1v1.Item_);
							m.getInventory().setItem(5, Join1v1.Cinza);
							m.updateInventory();
							v.updateInventory();
							WarpsAPI.Ir(v, "1v1");
							API.setWarp(m, "1v1");
							KitAPI.setKit(m, "1v1");
							KitAPI.setKit(v, "1v1");
							API.setWarp(v, "1v1");
						}
					}, 2L);

					m.setHealth(20);
					v.setHealth(20);
					for (Player plr : Bukkit.getOnlinePlayers()) {
						v.showPlayer(plr);
						m.showPlayer(plr);
					}
				} else {
					Jogando1v1Player.remove(v);
					Jogando1v1Player.remove(m);
					return;
				}
			}
		}
	}

	@EventHandler
	public void Morrer3(PlayerDeathEvent e) {
		Player v = e.getEntity();
		if ((e.getEntity().getKiller() instanceof Player)) {
			Player m = e.getEntity().getKiller();
			if (m != v) {
				if ((Jogando1v1Player.contains(v)) || (Jogando1v1Player.contains(m))) {
					int amountv = itemsInInventory(v.getInventory(), new Material[] { Material.MUSHROOM_SOUP });
					int amountm = itemsInInventory(m.getInventory(), new Material[] { Material.MUSHROOM_SOUP });

					m.sendMessage("     ");
					m.sendMessage(
							"�aVoc� ganhou o duelo contra " + v.getName() + "�a com �a�l" + amountv + " �asopas.");
					m.sendMessage("     ");

					inPvP.remove(m);
					inPvP.remove(v);
					Prote��o.setImortal(v, true);
					Prote��o.setImortal(m, true);

					v.sendMessage("     ");
					v.sendMessage("�cVoc� perdeu o duelo contra " + m.getName() + ". �cO jogador estava com �c�l"
							+ amountm + " �csopas.");
					v.sendMessage("     ");

					WarpsAPI.Ir(m, "1v1");
					m.setGameMode(GameMode.SURVIVAL);
					m.getInventory().setArmorContents(null);
					m.getInventory().clear();

					for (PotionEffect effect : m.getActivePotionEffects()) {
						m.removePotionEffect(effect.getType());
					}
					Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
						public void run() {
							WarpsAPI.Ir(v, "1v1");
							v.setGameMode(GameMode.SURVIVAL);
							v.getInventory().setArmorContents(null);
							v.getInventory().clear();

							for (PotionEffect effect : v.getActivePotionEffects()) {
								v.removePotionEffect(effect.getType());
							}
						}
					}, 1L);
					Jogando1v1Player.remove(v);
					Jogando1v1Player.remove(m);
					JogandoSair.remove(m.getName());
					JogandoSair.remove(v.getName());
					Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
						public void run() {
							v.getInventory().clear();
							m.getInventory().clear();
							v.getInventory().setItem(3, Join1v1.Item_);
							v.getInventory().setItem(5, Join1v1.Cinza);
							m.getInventory().setItem(3, Join1v1.Item_);
							m.getInventory().setItem(5, Join1v1.Cinza);
							m.updateInventory();
							v.updateInventory();
							WarpsAPI.Ir(v, "1v1");
							API.setWarp(m, "1v1");
							API.setWarp(v, "1v1");
							KitAPI.setKit(m, "1v1");
							KitAPI.setKit(v, "1v1");
						}
					}, 2L);

					m.setHealth(20);
					v.setHealth(20);
					for (Player plr : Bukkit.getOnlinePlayers()) {
						v.showPlayer(plr);
						m.showPlayer(plr);
					}
				} else {
					Jogando1v1Player.remove(v);
					Jogando1v1Player.remove(m);
					return;
				}
			}
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerLeft(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		if (JogandoSair.containsKey(p.getName())) {
			Player t = Bukkit.getServer().getPlayer((String) JogandoSair.get(p.getName()));

			WarpsAPI.Ir(t, "1v1");

			JogandoSair.remove(t.getName());
			JogandoSair.remove(p.getName());
			Jogando1v1Player.remove(p);
			Jogando1v1Player.remove(t);
			inPvP.remove(p);
			inPvP.remove(t);
			t.setMaxHealth(20.0D);
			t.setHealth(20.0D);
			Prote��o.setImortal(t, true);
			t.setGameMode(GameMode.SURVIVAL);
			t.getInventory().setArmorContents(null);
			t.getInventory().clear();
			for (PotionEffect effect : t.getActivePotionEffects()) {
				t.removePotionEffect(effect.getType());
			}
			t.sendMessage("�fO jogador �e�l" + p.getName() + " �fdeslogou durante o duelo!");

			t.getInventory().setItem(3, Join1v1.Item_);
			t.getInventory().setItem(5, Join1v1.Cinza);
			KitAPI.setKit(t, "1v1");
			t.updateInventory();
			for (Player plr : Bukkit.getOnlinePlayers()) {
				t.showPlayer(plr);
				p.showPlayer(plr);
			}
		}
	}

	@EventHandler
	public void cmd(PlayerCommandPreprocessEvent event) {
		Player p = event.getPlayer();
		if ((API.getWarp(p) == "1v1" && !Jogando1v1Player.contains(p)) && (!event.getMessage().startsWith("/spawn")
				&& !event.getMessage().startsWith("/score") && !cfGrupo.ChecarGrupo(p, "Dono")
				&& !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Gerente")
				&& !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Trial")
				&& !cfGrupo.ChecarGrupo(p, "Youtuber+") && !cfGrupo.ChecarGrupo(p, "Helper"))) {
			event.getPlayer().sendMessage("�cVoc� n�o pode utilizar comandos na �6�l1V1�f. Use �3�l/SPAWN�f!");
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void cmda(PlayerCommandPreprocessEvent event) {
		Player p = event.getPlayer();
		if (Jogando1v1Player.contains(p) && API.getWarp(p) == "1v1") {
			if (!event.getMessage().startsWith("/score") && !cfGrupo.ChecarGrupo(p, "Dono")
					&& !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Gerente")
					&& !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Mod")
					&& !cfGrupo.ChecarGrupo(p, "Trial")) {
				event.getPlayer().sendMessage("�cVoc� est� impossibilitado de utilizar comandos durante o duelo!");
				event.setCancelled(true);
			}
		}
	}

	public int itemsInInventory(Inventory inventory, Material[] search) {
		List wanted = Arrays.asList(search);
		int found = 0;
		ItemStack[] arrayOfItemStack;
		int j = (arrayOfItemStack = inventory.getContents()).length;
		for (int i = 0; i < j; i++) {
			ItemStack item = arrayOfItemStack[i];
			if ((item != null) && (wanted.contains(item.getType()))) {
				found += item.getAmount();
			}
		}
		return found;
	}

	@EventHandler
	public void PlayerInteractEntityEvent2(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		for (Player pl : Bukkit.getOnlinePlayers())
			if (Jogando1v1Player.contains(pl)) {
				pl.hidePlayer(p);
			}
	}
}
