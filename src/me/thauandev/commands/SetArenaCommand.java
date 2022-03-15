package me.thauandev.commands;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.github.caaarlowsz.speedmc.kitpvp.SpeedPvP;

public class SetArenaCommand implements Listener, CommandExecutor {
	public static SpeedPvP plugin;

	public SetArenaCommand() {

	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if ((p.hasPermission("myth.setarena")) && (label.equalsIgnoreCase("setarena"))) {
			if (args.length == 0) {
				p.sendMessage("�c�lSPEED�f�lMC �7Utilize /setarena (1-7");
				return true;
			}
			if (args[0].equalsIgnoreCase("1")) {
				SpeedPvP.getPlugin().getConfig();
				p.sendMessage("�c�lSPEED�f�lMC �7A Arena 1 Foi Setada Com Sucesso");
				plugin.getConfig().set("arena1.x", Double.valueOf(p.getLocation().getX()));
				plugin.getConfig().set("arena1.y", Double.valueOf(p.getLocation().getY()));
				plugin.getConfig().set("arena1.z", Double.valueOf(p.getLocation().getZ()));
				p.getWorld();
				plugin.getConfig().set("arena1.pitch", Float.valueOf(p.getLocation().getPitch()));
				plugin.getConfig().set("arena1.yaw", Float.valueOf(p.getLocation().getYaw()));
				plugin.getConfig().set("arena1.world", p.getLocation().getWorld().getName());
				SpeedPvP.plugin.saveConfig();
			}
			if (args[0].equalsIgnoreCase("2")) {
				SpeedPvP.getPlugin().getConfig();
				p.sendMessage("�c�lSPEED�f�lMC �7A Arena 2 Foi Setada Com Sucesso");
				plugin.getConfig().set("arena2.x", Double.valueOf(p.getLocation().getX()));
				plugin.getConfig().set("arena2.y", Double.valueOf(p.getLocation().getY()));
				plugin.getConfig().set("arena2.z", Double.valueOf(p.getLocation().getZ()));
				p.getWorld();
				plugin.getConfig().set("arena2.pitch", Float.valueOf(p.getLocation().getPitch()));
				plugin.getConfig().set("arena2.yaw", Float.valueOf(p.getLocation().getYaw()));
				plugin.getConfig().set("arena2.world", p.getLocation().getWorld().getName());
				SpeedPvP.plugin.saveConfig();
			}
			if (args[0].equalsIgnoreCase("3")) {
				SpeedPvP.getPlugin().getConfig();
				p.sendMessage("�c�lSPEED�f�lMC �7A Arena 3 Foi Setada Com Sucesso");
				plugin.getConfig().set("arena3.x", Double.valueOf(p.getLocation().getX()));
				plugin.getConfig().set("arena3.y", Double.valueOf(p.getLocation().getY()));
				plugin.getConfig().set("arena3.z", Double.valueOf(p.getLocation().getZ()));
				p.getWorld();
				plugin.getConfig().set("arena3.pitch", Float.valueOf(p.getLocation().getPitch()));
				plugin.getConfig().set("arena3.yaw", Float.valueOf(p.getLocation().getYaw()));
				plugin.getConfig().set("arena3.world", p.getLocation().getWorld().getName());
				SpeedPvP.plugin.saveConfig();
			}
			if (args[0].equalsIgnoreCase("4")) {
				SpeedPvP.getPlugin().getConfig();
				p.sendMessage("�c�lSPEED�f�lMC �7A Arena 4 Foi Setada Com Sucesso");
				plugin.getConfig().set("arena4.x", Double.valueOf(p.getLocation().getX()));
				plugin.getConfig().set("arena4.y", Double.valueOf(p.getLocation().getY()));
				plugin.getConfig().set("arena4.z", Double.valueOf(p.getLocation().getZ()));
				p.getWorld();
				plugin.getConfig().set("arena4.pitch", Float.valueOf(p.getLocation().getPitch()));
				plugin.getConfig().set("arena4.yaw", Float.valueOf(p.getLocation().getYaw()));
				plugin.getConfig().set("arena4.world", p.getLocation().getWorld().getName());
				SpeedPvP.plugin.saveConfig();
			}
			if (args[0].equalsIgnoreCase("5")) {
				SpeedPvP.getPlugin().getConfig();
				p.sendMessage("�c�lSPEED�f�lMC �7A Arena 5 Foi Setada Com Sucesso");
				plugin.getConfig().set("arena5.x", Double.valueOf(p.getLocation().getX()));
				plugin.getConfig().set("arena5.y", Double.valueOf(p.getLocation().getY()));
				plugin.getConfig().set("arena5.z", Double.valueOf(p.getLocation().getZ()));
				p.getWorld();
				plugin.getConfig().set("arena5.pitch", Float.valueOf(p.getLocation().getPitch()));
				plugin.getConfig().set("arena5.yaw", Float.valueOf(p.getLocation().getYaw()));
				plugin.getConfig().set("arena5.world", p.getLocation().getWorld().getName());
				SpeedPvP.plugin.saveConfig();
			}
			if (args[0].equalsIgnoreCase("6")) {
				SpeedPvP.getPlugin().getConfig();
				p.sendMessage("�c�lSPEED�f�lMC �7A Arena 6 Foi Setada Com Sucesso");
				plugin.getConfig().set("arena6.x", Double.valueOf(p.getLocation().getX()));
				plugin.getConfig().set("arena6.y", Double.valueOf(p.getLocation().getY()));
				plugin.getConfig().set("arena6.z", Double.valueOf(p.getLocation().getZ()));
				p.getWorld();
				plugin.getConfig().set("arena6.pitch", Float.valueOf(p.getLocation().getPitch()));
				plugin.getConfig().set("arena6.yaw", Float.valueOf(p.getLocation().getYaw()));
				plugin.getConfig().set("arena6.world", p.getLocation().getWorld().getName());
				SpeedPvP.plugin.saveConfig();
			}
			if (args[0].equalsIgnoreCase("7")) {
				SpeedPvP.getPlugin().getConfig();
				p.sendMessage("�c�lSPEED�f�lMC �7A Arena 7 Foi Setada Com Sucesso");
				plugin.getConfig().set("arena7.x", Double.valueOf(p.getLocation().getX()));
				plugin.getConfig().set("arena7.y", Double.valueOf(p.getLocation().getY()));
				plugin.getConfig().set("arena7.z", Double.valueOf(p.getLocation().getZ()));
				p.getWorld();
				plugin.getConfig().set("arena7.pitch", Float.valueOf(p.getLocation().getPitch()));
				plugin.getConfig().set("arena7.yaw", Float.valueOf(p.getLocation().getYaw()));
				plugin.getConfig().set("arena7.world", p.getLocation().getWorld().getName());
				SpeedPvP.plugin.saveConfig();
			}

		}
		return false;
	}

	public static void TeleportArenaRandom(Player p) {
		Random dice = new Random();

		int number = dice.nextInt(4);
		switch (number) {
		case 0:
			World w = Bukkit.getServer().getWorld(plugin.getConfig().getString("arena1.world"));
			double x = plugin.getConfig().getDouble("arena1.x");
			double y = plugin.getConfig().getDouble("arena1.y");
			double z = plugin.getConfig().getDouble("arena1.z");
			Location lobby = new Location(w, x, y, z);
			lobby.setPitch((float) plugin.getConfig().getDouble("arena1.pitch"));
			lobby.setYaw((float) plugin.getConfig().getDouble("arena1.yaw"));

			p.teleport(lobby);

			break;
		case 1:
			World w2 = Bukkit.getServer().getWorld(plugin.getConfig().getString("arena2.world"));
			double x2 = plugin.getConfig().getDouble("arena2.x");
			double y2 = plugin.getConfig().getDouble("arena2.y");
			double z2 = plugin.getConfig().getDouble("arena2.z");
			Location lobby2 = new Location(w2, x2, y2, z2);
			lobby2.setPitch((float) plugin.getConfig().getDouble("arena2.pitch"));
			lobby2.setYaw((float) plugin.getConfig().getDouble("arena2.yaw"));

			p.teleport(lobby2);

			break;
		case 2:
			World w3 = Bukkit.getServer().getWorld(plugin.getConfig().getString("arena3.world"));
			double x3 = plugin.getConfig().getDouble("arena3.x");
			double y3 = plugin.getConfig().getDouble("arena3.y");
			double z3 = plugin.getConfig().getDouble("arena3.z");
			Location lobby3 = new Location(w3, x3, y3, z3);
			lobby3.setPitch((float) plugin.getConfig().getDouble("arena3.pitch"));
			lobby3.setYaw((float) plugin.getConfig().getDouble("arena3.yaw"));

			p.teleport(lobby3);

			break;
		case 3:
			World w4 = Bukkit.getServer().getWorld(plugin.getConfig().getString("arena4.world"));
			double x4 = plugin.getConfig().getDouble("arena4.x");
			double y4 = plugin.getConfig().getDouble("arena4.y");
			double z4 = plugin.getConfig().getDouble("arena4.z");
			Location lobby4 = new Location(w4, x4, y4, z4);
			lobby4.setPitch((float) plugin.getConfig().getDouble("arena4.pitch"));
			lobby4.setYaw((float) plugin.getConfig().getDouble("arena4.yaw"));

			p.teleport(lobby4);

			break;
		case 4:
			World w5 = Bukkit.getServer().getWorld(plugin.getConfig().getString("arena5.world"));
			double x5 = plugin.getConfig().getDouble("arena5.x");
			double y5 = plugin.getConfig().getDouble("arena5.y");
			double z5 = plugin.getConfig().getDouble("arena5.z");
			Location lobby5 = new Location(w5, x5, y5, z5);
			lobby5.setPitch((float) plugin.getConfig().getDouble("arena5.pitch"));
			lobby5.setYaw((float) plugin.getConfig().getDouble("arena5.yaw"));
			p.teleport(lobby5);

			break;
		case 5:
			World w6 = Bukkit.getServer().getWorld(plugin.getConfig().getString("arena6.world"));
			double x6 = plugin.getConfig().getDouble("arena6.x");
			double y6 = plugin.getConfig().getDouble("arena6.y");
			double z6 = plugin.getConfig().getDouble("arena6.z");
			Location lobby6 = new Location(w6, x6, y6, z6);
			lobby6.setPitch((float) plugin.getConfig().getDouble("arena6.pitch"));
			lobby6.setYaw((float) plugin.getConfig().getDouble("arena6.yaw"));
			p.teleport(lobby6);

			break;
		case 6:
			World w7 = Bukkit.getServer().getWorld(plugin.getConfig().getString("arena7.world"));
			double x7 = plugin.getConfig().getDouble("arena7.x");
			double y7 = plugin.getConfig().getDouble("arena7.y");
			double z7 = plugin.getConfig().getDouble("arena7.z");
			Location lobby7 = new Location(w7, x7, y7, z7);
			lobby7.setPitch((float) plugin.getConfig().getDouble("arena7.pitch"));
			lobby7.setYaw((float) plugin.getConfig().getDouble("arena7.yaw"));
			p.teleport(lobby7);
		}
	}
}
