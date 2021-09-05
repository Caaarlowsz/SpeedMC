package me.thauandev.bans;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thauandev.API.HorarioAPI;
import me.thauandev.bans.API;
import me.thauandev.bans.Config;
import me.thauandev.configuração.cfGrupo;

public class BanCommand implements CommandExecutor {

	@SuppressWarnings({ "deprecation" })
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (!(sender instanceof Player)) {
			return true;
		}
		final Player jogador = (Player)sender;	
		if (cmd.getName().equalsIgnoreCase("ban")) {
			if((!cfGrupo.ChecarGrupo(jogador, "Dono") && (!cfGrupo.ChecarGrupo(jogador, "Gerente") && (!cfGrupo.ChecarGrupo(jogador, "Admin") && (!cfGrupo.ChecarGrupo(jogador, "Mod+") && (!cfGrupo.ChecarGrupo(jogador, "Mod") && (!cfGrupo.ChecarGrupo(jogador, "Trial") && (!cfGrupo.ChecarGrupo(jogador, "Youtuber+"))))))))){
				API.sendMsg(jogador, "§c§lSPEED§f§lMC §fVocê não §fpossui §fpermissao para executar este comando!");
				return true;
			}
			if (args.length == 0) {
				API.sendMsg(jogador, "§c§lSPEED§f§lMC §fUtilize §c/ban §c(nick) (motivo)");
                
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			Player vitima = Bukkit.getPlayer(args[0]);
			if (vitima == null) {
				OfflinePlayer vitimaoff = Bukkit.getOfflinePlayer(args[0]);
				if (vitimaoff.getName() == jogador.getName()) {
					API.sendMsg(jogador, "§c§lSPEED§f§lMC §cVocê não pode banir a si mesmo!");
					API.sendSound(jogador, Sound.NOTE_PLING, 10);
					return true;
				}
				if (Config.getConfig().getBans().get("Bans." + vitimaoff.getUniqueId()) != null)  {
					 API.sendMsg(jogador, "§c§lSPEED§f§lMC §fO jogador §c§l" + vitimaoff.getName() + " §fjá está §4§lBANIDO§f!");
					 API.sendSound(jogador, Sound.NOTE_PLING, 10);
					 return true;
				}
				if (Config.getConfig().getIpBans().get("IPBans." + vitimaoff.getUniqueId()) != null)  {
					 API.sendMsg(jogador, "§c§lSPEED§f§lMC §fO jogador §c§l" + vitimaoff.getName() + " §fjá está §4§lBANIDO§4(IP)§f!");
					 API.sendSound(jogador, Sound.NOTE_PLING, 10);
					 return true;
				}
				if (Config.getConfig().getTempBans().get("TempBans." + vitimaoff.getUniqueId()) != null)  {
					 API.sendMsg(jogador, "§c§lSPEED§f§lMC §fO jogador §c§l" + vitimaoff.getName() + " §fjá está §9§lBANIDO§9(tempban)§f!");
					 API.sendSound(jogador, Sound.NOTE_PLING, 10);
					 return true;
					 
				}
				if(vitimaoff.getName() == "ThauanPvP") 
				API.sendMsg(jogador, "§fVocê não pode banir §4§lTHAUAN§f!"); {
				    
				   }
				String Motivo = "";
				for (int i = 1; i < args.length; i++) {
					Motivo = Motivo + args[i] + " ";
				}
				double l = Config.getConfig().getBans().getDouble("Players Banidos");
				API.sendBC("§b§l" + jogador.getName() + " §fbaniu §c§lPERMANENTEMENTE §fo jogador §c" + vitimaoff.getName() + " §fMotivo: §c" + Motivo);
				API.sendMsg(jogador, "§4§lBAN §fVocê baniu o jogador §c§l" + vitimaoff.getName() + "§f.");
				API.sendStaff("§4§lBAN §f" + jogador.getName() + " baniu o jogador §c" + vitimaoff.getName() + "§fMotivo: §c" + Motivo);
				
														 
				Config.getConfig().getBans().set("Players Banidos", Double.valueOf(l + 1.0D));
				Config.getConfig().getBans().set("Bans." + vitimaoff.getUniqueId() + ".Nome", vitimaoff.getName());
				Config.getConfig().getBans().set("Bans." + vitimaoff.getUniqueId() + ".Banido por", jogador.getName());
				Config.getConfig().getBans().set("Bans." + vitimaoff.getUniqueId() + ".Motivo", Motivo);
				Config.getConfig().getBans().set("Bans." + vitimaoff.getUniqueId() + ".Data do banimento", HorarioAPI.getHorario());
				Config.getConfig().saveBans();
				return true;
			}
			if (vitima.getName() == jogador.getName()) {
				API.sendMsg(jogador, "§cVocê não pode banir a si mesmo!");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			if (Config.getConfig().getBans().get("Bans." + vitima.getUniqueId()) != null)  {
				 API.sendMsg(jogador, "§fO jogador §c§l" + vitima.getName() + " §fjá está §4§lBANIDO§f!");
				 API.sendSound(jogador, Sound.NOTE_PLING, 10);
				 return true;
			}
			if (Config.getConfig().getIpBans().get("IPBans." + vitima.getUniqueId()) != null)  {
				 API.sendMsg(jogador, "§fO jogador §c§l" + vitima.getName() + " §fjá está §4§lBANIDO§4(IP)§f!");
				 API.sendSound(jogador, Sound.NOTE_PLING, 10);
				 return true;
			}
			if (Config.getConfig().getTempBans().get("TempBans." + vitima.getUniqueId()) != null)  {
				 API.sendMsg(jogador, "§fO jogador §c§l" + vitima.getName() + " §fjá está §4§lBANIDO§9(tempban)");
				 API.sendSound(jogador, Sound.NOTE_PLING, 10);
				 return true;
			}
			if (args.length == 1) {
				 API.sendMsg(jogador, "§4§lBAN §fUtilize §4/ban §4(JOGADOR) (MOTIVO)");
				 API.sendSound(jogador, Sound.NOTE_PLING, 10);
				 return true;
			}
			String Motivo = "";
			for (int i = 1; i < args.length; i++) {
				Motivo = Motivo + args[i] + " ";
			}
			double l = Config.getConfig().getBans().getDouble("Players Banidos");
			API.sendMsg(jogador, "§4§lBAN §fVocê baniu o jogador §c" + vitima.getName() + "§f.");
			API.sendBC("§c" + jogador.getName() + " §fbaniu §c§lPERMANENTEMENTE §fo jogador §c" + vitima.getName() + " §fMotivo: §c" + Motivo);
			API.sendStaff("§4§lBAN §f" + jogador.getName() + " baniu o jogador §c" + vitima.getName() + " Motivo: §c" + Motivo);
			vitima.kickPlayer("§7Você foi banido §4§lPERMANENTEMENTE §7do servidor!" + "\n" + "§7Username banido: §c" + vitima.getName() + "\n" + "§7Banido por: §c§l" + jogador.getName() + "\n" + "§7Motivo: §c" + Motivo + "\n" + "§7Expira em: §c§lNUNCA" + "\n" + "§7Data do banimento: §c" + HorarioAPI.getHorario() + "\n" + "§7Compre §e§lUNBAN §7em nossa loja: §cspeedmc.com.br" + "\n" + "§7Banimento incorreto? Contate-nos pelo Twitter §c@SpeedMC§7!");
			
									 
			Config.getConfig().getBans().set("Players Banidos", Double.valueOf(l + 1.0D));
			Config.getConfig().getBans().set("Bans." + vitima.getUniqueId() + ".Nome", vitima.getName());
			Config.getConfig().getBans().set("Bans." + vitima.getUniqueId() + ".Banido por", jogador.getName());
			Config.getConfig().getBans().set("Bans." + vitima.getUniqueId() + ".Motivo", Motivo);
			Config.getConfig().getBans().set("Bans." + vitima.getUniqueId() + ".Data do banimento", HorarioAPI.getHorario());
			Config.getConfig().saveBans();
			return true;							 
 		}
		return false;
	}
}
