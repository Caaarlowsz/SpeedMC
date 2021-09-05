package me.thauandev.bans;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thauandev.bans.API;
import me.thauandev.bans.Config;
import me.thauandev.configuração.cfGrupo;

public class PardonCommand implements CommandExecutor {

	private static String ip(OfflinePlayer vitima) {
		return (String)Config.getConfig().getIpBans().get("IPBans." + vitima.getUniqueId() + ".IP do Jogador");
	}
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player jogador = (Player)sender;
		if (cmd.getName().equalsIgnoreCase("pardon")) {
			if((!cfGrupo.ChecarGrupo(jogador, "Dono") && (!cfGrupo.ChecarGrupo(jogador, "Gerente") && (!cfGrupo.ChecarGrupo(jogador, "Admin"))))){
				API.sendMsg(jogador, "§3§lDEFAULT§f§lMC §fVoce nao §possui §facesso ao §c§lSPEED§f§lMC§f!");
				return true;
			}
			if (args.length == 0) {
				API.sendMsg(jogador, "§c§lSPEED§f§lMC §fUtilize §c/pardon (ban) (ipban) (mute) (tempmute) (jogador) "); 
				return true;                                               
			}
			if (args[0].equalsIgnoreCase("ban")) {
				if (args.length == 1) {
					API.sendMsg(jogador, "§c§lSPEED§f§lMC §fUtilize §c/pardon (ban) (ipban) (mute) (tempmute) (jogador) ");
					return true;
				}
				OfflinePlayer vitima = Bukkit.getOfflinePlayer(args[1]);
				if (Config.getConfig().getBans().get("Bans." + vitima.getUniqueId()) == null) {
					API.sendMsg(jogador, "§fO jogador §b" + vitima.getName() + " §fnão está §4§lBANIDO§f! ");
					return true;
				}
				if (!(sender instanceof Player)) {
					API.sendStaff("§c§lSPEED§f§lMC §f" + vitima.getName() + " §7foi §b§DESBANIDO §fpor: §c§lCONSOLE");
				} else {
					API.sendMsg(jogador, "§c§lSPEED§f§lMC §fVocê desbaniu o jogador: §b" + vitima.getName());
					API.sendStaff("§c§lSPEED§f§lMC §f" + jogador.getName() + " desbaniu o jogador: §b" + vitima.getName());
				}
				double l = Config.getConfig().getBans().getDouble("Players Banidos");
				Config.getConfig().getBans().set("Players Banidos", Double.valueOf(l - 1.0D));
				Config.getConfig().getBans().set("Bans." + vitima.getUniqueId(), null);
				Config.getConfig().saveBans();
				return true;
			}
			if (args[0].equalsIgnoreCase("ipban")) {
				if (args.length == 1) {
					API.sendMsg(sender, "§c§lSPEED§f§lMC §fUtilize §2§l/pardon §2ipban (jogador)");
					return true;
				}
				OfflinePlayer vitima = Bukkit.getOfflinePlayer(args[1]);
				if (Config.getConfig().getIpBans().get("IPBans." + vitima.getUniqueId()) == null) {
					API.sendMsg(jogador, "§fO jogador §b" + vitima.getName() + " §fnão está §4§lBANIDO§f!");
					return true;
				}
				if (!(sender instanceof Player)) {
					API.sendStaff("§c§lSPEED§f§lMC §f" + vitima.getName() + " §ffoi §bDESBANIDO §fpor: §c§lCONSOLE");
				} else {
			
					API.sendMsg(jogador, "§c§lSPEED§f§lMC §fVocê desbaniu o jogador §b" + vitima.getName());
					API.sendStaff("§c§lSPEED§f§lMC §f" + jogador.getName() + " desbaniu o jogador " + vitima.getName());
				}
				Bukkit.unbanIP(ip(vitima));
				Config.getConfig().getIpBans().set("IPBans." + vitima.getUniqueId(), null);
				Config.getConfig().saveIpBans();
				return true;
			}
			if (args[0].equalsIgnoreCase("tempban")) {
				if (args.length == 1) {
					API.sendMsg(sender, "§c§lSPEED§f§lMC §fUtilize §3§l/pardon §3tempban (jogador)");
					return true;
				}
				OfflinePlayer vitima = Bukkit.getOfflinePlayer(args[1]);
				if (Config.getConfig().getTempBans().get("TempBans." + vitima.getUniqueId()) == null) {
					API.sendMsg(sender, "§7O jogador §b" + vitima.getName() + " §7não está §4§lBANIDO§f!");
					return true;
				}
				if (!(sender instanceof Player)) {
					API.sendStaff("§c§lSPEED§f§lMC §f" + vitima.getName() + " §7foi desbanido por: §c§lCONSOLE");
				} else {
					API.sendMsg(jogador, "§c§lSPEED§f§lMC §fVocê desbaniu o jogador: §b" + vitima.getName());
					API.sendStaff("§c§lSPEED§f§lMC §f" + jogador.getName() + " §fdesbaniu o jogador: §b" + vitima.getName());
				}
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId(), null);
				Config.getConfig().saveTempBans();
				return true;
			}
			if (args[0].equalsIgnoreCase("mute")) {
				if (args.length == 1) {
					API.sendMsg(jogador, "§c§lSPEED§f§lMC §fUtilize §9§l/pardon §bmute (JOGADOR)");
					return true;
				}
				Player vitima = Bukkit.getPlayer(args[1]);
				if (vitima == null) {
					OfflinePlayer vitimaoff = Bukkit.getOfflinePlayer(args[1]);
					if (Config.getConfig().getMute().get("Mute." + vitimaoff.getUniqueId()) == null) {
						API.sendMsg(jogador, "§fO jogador §b" + vitimaoff.getName() + "§f não está §9§lMUTADO§f!");
						return true;
					}
					if (!(sender instanceof Player)) {
						API.sendStaff("§c§lSPEED§f§lMC §fCONSOLE desmutou o jogador: §b" + vitimaoff.getName());
					} else {
						API.sendMsg(jogador, "§c§lSPEED§f§lMC §fVocê desmutou o jogador: §b" + vitimaoff.getName());
						API.sendStaff("§c§lSPEED§f§lMC §f" + jogador.getName() + " desmutou o jogador: §c§" + vitimaoff.getName());
					}
					Config.getConfig().getMute().set("Mute." + vitimaoff.getUniqueId(), null);
					Config.getConfig().saveMute();
					return true;
				}
				if (Config.getConfig().getMute().get("Mute." + vitima.getUniqueId()) == null) {
					API.sendMsg(jogador, "§fO jogador §b" + vitima.getName() + "§f não está §9§lMUTADO§f!");
					return true;
				}
				if (!(sender instanceof Player)) {
					API.sendStaff("§cCONSOLE desmutou " + vitima.getName());
				} else {
					API.sendMsg(jogador, "§c§lSPEED§f§lMC §fVocê desmutou o jogador: §c§l" + vitima.getName());
					API.sendStaff("§c§lSPEED§f§lMC §f" + jogador.getName() + " desmutou o jogador: §c§l" + vitima.getName());
				}
				Config.getConfig().getMute().set("Mute." + vitima.getUniqueId(), null);
				Config.getConfig().saveMute();
				return true;
			}
			if (args[0].equalsIgnoreCase("tempmute")) {
				if (args.length == 1) {
					API.sendMsg(jogador, "§c§lSPEED§f§lMC §fUtilize §b/pardon §btempmute (JOGADOR)");
					return true;
				}
				Player vitima = Bukkit.getPlayer(args[1]);
				if (vitima == null) {
					OfflinePlayer vitimaoff = Bukkit.getOfflinePlayer(args[1]);
					if (Config.getConfig().getTempMute().get("TempMute." + vitimaoff.getUniqueId()) == null) {
						API.sendMsg(jogador, "§fO jogador §b" + vitimaoff.getName() + "§f não está §4§lMUTADO§f! ");
						return true;
					}
					if (!(sender instanceof Player)) {
						API.sendStaff("§c§lSPEED§f§lMC §fCONSOLE desmutou o jogador: §c" + vitimaoff.getName());
					} else {
						API.sendMsg(jogador, "§c§lSPEED§f§lMC §fVocê desmutou o jogador: §c" + vitimaoff.getName());
						API.sendStaff("§c§lSPEED§f§lMC §f" + jogador.getName() + " desmutou o jogador: §c" + vitimaoff.getName());
					}
					Config.getConfig().getTempMute().set("TempMute." + vitimaoff.getUniqueId(), null);
					Config.getConfig().saveTempMute();
					return true;
				}
				if (Config.getConfig().getTempMute().get("TempMute." + vitima.getUniqueId()) == null) {
					API.sendMsg(jogador, "§fO jogador §b" + vitima.getName() + "§f não está §4§lMUTADO§f!");
					return true;
				}
				if (!(sender instanceof Player)) {
					API.sendStaff("§c§lSPEED§f§lMC §fCONSOLE desmutou o jogador: §c" + vitima.getName());
				} else {
					API.sendMsg(jogador, "§c§lSPEED§f§lMC §fVocê desmutou o jogador: §c" + vitima.getName());
					API.sendStaff("§c§lSPEED§f§lMC §f" + jogador.getName() + " desmutou o jogador: §c" + vitima.getName());
				}
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId(), null);
				Config.getConfig().saveTempMute();
				return true;
			}
			API.sendMsg(sender, "§c§lSPEED§f§lMC §fUtilize §c/pardon (ban) (ipban) (mute) (tempmute) (jogador) ");
			return true;
		}
		return false;
	}
}
