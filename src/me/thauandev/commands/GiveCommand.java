package me.thauandev.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thauandev.configuração.cfGrupo;
import me.thauandev.events.CorGrupo;
import me.thauandev.scoreboard.sScoreAPI;
import me.thauandev.v_1_8.TituloAPI;

public class GiveCommand implements CommandExecutor {
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("giveyoutuber")) {
			if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Gerente")){
				p.sendMessage("§c§lSPEED§f§lMC §cVocê não possui permissão para manipular este grupo!");
				return true;
			}
			if(args.length == 0) {
				if((sender instanceof Player)) {
					p.sendMessage("§c§lSPEED§f§lMC §7Use §b§l/giveyoutuber §7(JOGADOR)");
					return true;
				}
				if(!(sender instanceof Player)) {
					sender.sendMessage("§c§lSPEED§f§lMC §7Use §b§l/giveyoutuber §7(JOGADOR)");
					return true;
				}
			}
			if(args.length == 1) {
				Player k = Bukkit.getPlayer(args[0]);
				if((sender instanceof Player)) {
					if(k == null) {
						OfflinePlayer off = Bukkit.getOfflinePlayer(args[1]);
						
						p.sendMessage("§eVocê aplicou o grupo Youtuber para " + off.getName());
						
						cfGrupo.setarGrupo(off, "Youtuber");
						cfGrupo.salvarconfiguracao();
						return true;
					}
					if(k != null) {
						p.sendMessage("§eVocê aplicou o grupo Youtuber para " + k.getName());
						
						k.sendMessage("§eO seu grupo(Youtuber) foi alterdo para Youtuber com sucesso!");
						
						TituloAPI.MandarTitulo(k, "§b§lYOUTUBER");
						TituloAPI.MandarSubTitulo(k, "§7O seu grupo foi alterado para §b§lYOUTUBER§7!");
						
						cfGrupo.setarGrupo(k, "Youtuber");
						cfGrupo.salvarconfiguracao();
						
						if(cfGrupo.ChecarGrupo(k, "Dono")){
							CorGrupo.setarTag(k, "§4§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Gerente")){
							CorGrupo.setarTag(k, "§c§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Admin")){
							CorGrupo.setarTag(k, "§c§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Mod+")){
							CorGrupo.setarTag(k, "§5§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Mod")){
							CorGrupo.setarTag(k, "§5§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Trial")){
							CorGrupo.setarTag(k, "§5§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Youtuber+")){
							CorGrupo.setarTag(k, "§3§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Builder")){
							CorGrupo.setarTag(k, "§2§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Helper")){
							CorGrupo.setarTag(k, "§9§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Youtuber")){
							CorGrupo.setarTag(k, "§b§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "S-Pro")){
							CorGrupo.setarTag(k, "§e§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Pro")){
							CorGrupo.setarTag(k, "§6§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Mvp")){
							CorGrupo.setarTag(k, "§9§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Light")){
							CorGrupo.setarTag(k, "§a§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Membro")){
							CorGrupo.setarTag(k, "§7§l");
						}
						
						sScoreAPI.scoreboard(k);
						
						k.chat("/tag youtuber");
						return true;
					}
				}
				if(!(sender instanceof Player)) {
					if(k == null) {
						OfflinePlayer off = Bukkit.getOfflinePlayer(args[1]);
						
						sender.sendMessage("§eVocê aplicou o grupo Youtuber para" + off.getName());
						
						cfGrupo.setarGrupo(off, "Youtuber");
						cfGrupo.salvarconfiguracao();
						return true;
					}
					if(k != null) {
						sender.sendMessage("§eVocê aplicou o grupo Youtuber para" + k.getName());
						
						k.sendMessage("§eO seu grupo(Youtuber) foi alterado para Youtuber!");
						
						TituloAPI.MandarTitulo(k, "§b§lYOUTUBER");
						TituloAPI.MandarSubTitulo(k, "§7O seu grupo foi alterado para §b§lYOUTUBER§7!");
						
						cfGrupo.setarGrupo(k, "Youtuber");
						cfGrupo.salvarconfiguracao();
						
						if(cfGrupo.ChecarGrupo(k, "Dono")){
							CorGrupo.setarTag(k, "§4§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Gerente")){
							CorGrupo.setarTag(k, "§c§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Admin")){
							CorGrupo.setarTag(k, "§c§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Mod+")){
							CorGrupo.setarTag(k, "§5§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Mod")){
							CorGrupo.setarTag(k, "§5§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Trial")){
							CorGrupo.setarTag(k, "§5§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Youtuber+")){
							CorGrupo.setarTag(k, "§3§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Builder")){
							CorGrupo.setarTag(k, "§2§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Helper")){
							CorGrupo.setarTag(k, "§9§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Youtuber")){
							CorGrupo.setarTag(k, "§b§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "S-Pro")){
							CorGrupo.setarTag(k, "§e§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Pro")){
							CorGrupo.setarTag(k, "§6§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Mvp")){
							CorGrupo.setarTag(k, "§9§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Light")){
							CorGrupo.setarTag(k, "§a§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Membro")){
							CorGrupo.setarTag(k, "§7§l");
						}
						
						sScoreAPI.scoreboard(k);
						
						k.chat("/tag youtuber");
						return true;
					}
				}
			}
		}
		if(cmd.getName().equalsIgnoreCase("givebuilder")) {
			if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Gerente")){
				p.sendMessage("§c§lSPEED§f§lMC §cVocê não possui permissão para manipular este grupo!");
				return true;
			}
			if(args.length == 0) {
				if((sender instanceof Player)) {
					p.sendMessage("§c§lSPEED§f§lMC §7Use §2/givebuilder §7(JOGADOR)");
					return true;
				}
				if(!(sender instanceof Player)) {
					sender.sendMessage("§c§lSPEED§f§lMC §7Use §2/givebuilder §7(JOGADOR)");
					return true;
				}
			}
			if(args.length == 1) {
				Player k = Bukkit.getPlayer(args[0]);
				if((sender instanceof Player)) {
					if(k == null) {
						OfflinePlayer off = Bukkit.getOfflinePlayer(args[1]);
						
						p.sendMessage("§eVocê aplicou o grupo Builder para " + off.getName());
						
						cfGrupo.setarGrupo(off, "Builder");
						cfGrupo.salvarconfiguracao();
						return true;
					}
					if(k != null) {
						p.sendMessage("§eVocê aplicou o grupo Builder para " + k.getName());
						
						k.sendMessage("§eO seu grupo(Builder) foi alterado para Builder!");
						
						TituloAPI.MandarTitulo(k, "§a§lBUILDER");
						TituloAPI.MandarSubTitulo(k, "§7O seu grupo foi alterado para §2§BUILDER§7!");
						
						cfGrupo.setarGrupo(k, "Builder");
						cfGrupo.salvarconfiguracao();
						
						if(cfGrupo.ChecarGrupo(k, "Dono")){
							CorGrupo.setarTag(k, "§4§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Gerente")){
							CorGrupo.setarTag(k, "§c§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Admin")){
							CorGrupo.setarTag(k, "§c§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Mod+")){
							CorGrupo.setarTag(k, "§5§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Mod")){
							CorGrupo.setarTag(k, "§5§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Trial")){
							CorGrupo.setarTag(k, "§5§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Youtuber+")){
							CorGrupo.setarTag(k, "§3§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Builder")){
							CorGrupo.setarTag(k, "§2§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Helper")){
							CorGrupo.setarTag(k, "§9§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Youtuber")){
							CorGrupo.setarTag(k, "§b§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "S-Pro")){
							CorGrupo.setarTag(k, "§e§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Pro")){
							CorGrupo.setarTag(k, "§6§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Mvp")){
							CorGrupo.setarTag(k, "§9§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Light")){
							CorGrupo.setarTag(k, "§a§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Membro")){
							CorGrupo.setarTag(k, "§7§l");
						}
						
						sScoreAPI.scoreboard(k);
						
						k.chat("/tag builder");
						return true;
					}
				}
			}
		}
		return false;
	}
}
