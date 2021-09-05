package me.thauandev.commands;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import me.thauandev.API.API;
import me.thauandev.API.ArraysAPI;
import me.thauandev.API.KitAPI;
import me.thauandev.configuração.cfGrupo;
import me.thauandev.invencivel.Proteção;
import me.thauandev.main.Main;
import me.thauandev.scoreboard.sScoreAPI;

public class BuilderCommand implements CommandExecutor, Listener {

	public static HashMap<Player, ItemStack[]> inventario = new HashMap<Player, ItemStack[]>();
	public static HashMap<Player, String> warp = new HashMap<Player, String>();
	public static HashMap<Player, String> kit = new HashMap<Player, String>();

	@EventHandler
	private void interact(PlayerInteractEvent e) {

		Player p = e.getPlayer();

		if (p.getItemInHand().getType() == Material.MAGMA_CREAM && ArraysAPI.Admin.contains(p)
				&& e.getAction() == Action.RIGHT_CLICK_AIR
				|| e.getAction() == Action.RIGHT_CLICK_BLOCK && p.getItemInHand().hasItemMeta()
						&& p.getItemInHand().getItemMeta().hasDisplayName()
						&& p.getItemInHand().getItemMeta().getDisplayName().equals("§aTroca Rapida")) {

			for (Player todos : Bukkit.getOnlinePlayers()) {

				todos.showPlayer(p);
				p.showPlayer(todos);
			}

			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
				public void run() {

					ArraysAPI.Admin.add(p);

					setAdmin(p);
				}
			}, 10L);
		}
	}

	@EventHandler
	public void autosoup(PlayerInteractEntityEvent e) {

		Player p = e.getPlayer();

		if (p instanceof Player && e.getRightClicked() instanceof Player) {

			if (p.getItemInHand().getType() == Material.MUSHROOM_SOUP && ArraysAPI.Admin.contains(p)) {

				Player t = (Player) e.getRightClicked();

				if (ArraysAPI.Checando.contains(t)) {
					p.sendMessage("§c§lSPEED§f§lMC §7Acesso negado!");
					return;

				}
				inventario.put(t, t.getInventory().getContents());
				t.getInventory().clear();
				t.setHealth(0.5D);
				ArraysAPI.Checando.add(t);

				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
					public void run() {

						ArraysAPI.Checando.remove(t);
						t.getInventory().clear();
						t.closeInventory();
						t.getInventory().setContents(inventario.get(t));
						t.setHealth(20.0D);

					}
				}, 1 * 60);
			}
		}
		if (p.getItemInHand().getType() == Material.IRON_FENCE && ArraysAPI.Admin.contains(p)) {
			Player t = (Player) e.getRightClicked();
			p.sendMessage("§a§l(!) §7Você prendeu o jogador: §6§l" + t.getName());
			t.getLocation().add(0.0D, 13.0D, 0.0D).getBlock().setType(Material.BEDROCK);
			t.getLocation().add(0.0D, 11.0D, 1.0D).getBlock().setType(Material.BEDROCK);
			t.getLocation().add(1.0D, 11.0D, 0.0D).getBlock().setType(Material.BEDROCK);
			t.getLocation().add(0.0D, 11.0D, -1.0D).getBlock().setType(Material.BEDROCK);
			t.getLocation().add(-1.0D, 11.0D, 0.0D).getBlock().setType(Material.BEDROCK);
			t.getLocation().add(0.0D, 10.0D, 0.0D).getBlock().setType(Material.BEDROCK);
			t.teleport(t.getLocation().add(0.0D, 11.0D, -0.05D));
			p.teleport(t.getLocation().add(3.0D, 0.0D, 0.05D));
		}
		if (p.getItemInHand().getType() == Material.AIR && ArraysAPI.Admin.contains(p)) {
			Player t = (Player) e.getRightClicked();
			p.openInventory(t.getInventory());
		}
	}

	@Override
	public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args) {

		Player p = (Player) Sender;

		if (Cmd.getName().equalsIgnoreCase("builder")) {

			if ((!cfGrupo.ChecarGrupo(p, "Dono")
					&& (!cfGrupo.ChecarGrupo(p, "Gerente") && (!cfGrupo.ChecarGrupo(p, "Admin")
							&& (!cfGrupo.ChecarGrupo(p, "Mod+") && (!cfGrupo.ChecarGrupo(p, "Builder")
									&& (!cfGrupo.ChecarGrupo(p, "Dono") && (!cfGrupo.ChecarGrupo(p, "Admin")
											&& (!cfGrupo.ChecarGrupo(p, "Gerente")))))))))) {
				p.sendMessage("§c§l(!) §cVocê não possui permissão para executar este comando!");
				return true;
			}
			if (!ArraysAPI.Admin.contains(p)) {
				ArraysAPI.Admin.add(p);

				kit.put(p, KitAPI.getKitAntes(p));
				warp.put(p, API.getWarp(p));

				inventario.put(p, p.getInventory().getContents());
				p.getInventory().clear();
				p.getInventory().setArmorContents(null);

				Proteção.setImortal(p, false);
				p.sendMessage("§2§lBUILDER: §fModo Builder: §aATIVADO");
				API.sendWarn("§7§o[" + p.getName() + "§7§o entrou no modo BUILDER]");
				KitAPI.setKitAntes(p, "Admin");
				API.setWarp(p, "Admin");
				p.setHealth(20.0D);
				p.setMaxHealth(20.0D);
				p.setGameMode(GameMode.CREATIVE);

				setAdmin(p);
				ArraysAPI.Jogando.remove(p);

				for (Player todos : Bukkit.getOnlinePlayers()) {
					sScoreAPI.scoreboard(todos);
				}
				sScoreAPI.scoreboard(p);
				return true;
			}
			if (ArraysAPI.Admin.contains(p)) {

				ArraysAPI.Admin.remove(p);
				p.sendMessage("§2§lBUILDER: §fModo Builder: §cDESATIVADO");
				API.sendWarn("§7§o[" + p.getName() + "§7§o saiu do modo BUILDER]");
				KitAPI.setKitAntes(p, kit.get(p));
				API.setWarp(p, warp.get(p));
				p.setGameMode(GameMode.SURVIVAL);
				p.getInventory().clear();
				p.getInventory().setArmorContents(null);
				p.getInventory().setContents(inventario.get(p));
				p.updateInventory();

				ArraysAPI.Jogando.add(p);

				for (Player todos : Bukkit.getOnlinePlayers()) {
					sScoreAPI.scoreboard(todos);
				}

				for (Player todos : Bukkit.getOnlinePlayers()) {

					todos.showPlayer(p);
					p.showPlayer(todos);
				}
				sScoreAPI.scoreboard(p);
			}
		}
		return false;
	}

	public static void setAdmin(Player p) {

		for (Player todos : Bukkit.getOnlinePlayers()) {
			if ((cfGrupo.ChecarGrupo(todos, "Dono")
					|| (cfGrupo.ChecarGrupo(todos, "Gerente") || (cfGrupo.ChecarGrupo(todos, "Admin")
							|| (cfGrupo.ChecarGrupo(todos, "Mod+") || (cfGrupo.ChecarGrupo(todos, "Builder"))))))) {
				todos.showPlayer(p);
				p.showPlayer(todos);
			} else {
				if (ArraysAPI.Admin.contains(p)) {
					todos.hidePlayer(p);
				}
			}
		}
	}

	public static void checarAdmin() {

		for (Player todos : Bukkit.getOnlinePlayers()) {
			if (ArraysAPI.Admin.contains(todos)) {

				setAdmin(todos);
			}
		}
	}
}
