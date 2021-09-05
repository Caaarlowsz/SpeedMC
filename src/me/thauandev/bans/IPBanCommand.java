package me.thauandev.bans;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thauandev.API.HorarioAPI;
import me.thauandev.configuração.cfGrupo;

public class IPBanCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (!(sender instanceof Player)) {
			return true;
		}
		final Player jogador = (Player)sender;	
		if (cmd.getName().equalsIgnoreCase("ipban")) {
			if((!cfGrupo.ChecarGrupo(jogador, "Dono") && (!cfGrupo.ChecarGrupo(jogador, "Gerente") && (!cfGrupo.ChecarGrupo(jogador, "Admin") && (!cfGrupo.ChecarGrupo(jogador, "Mod+") && (!cfGrupo.ChecarGrupo(jogador, "Mod") && (!cfGrupo.ChecarGrupo(jogador, "Trial") && (!cfGrupo.ChecarGrupo(jogador, "Youtuber+"))))))))){
				API.sendMsg(jogador, "§c§lSPEED§f§lMC §fVocê não possui permissão para executar este comando!");
				return true;
			}
			if (args.length == 0) {
				API.sendMsg(jogador, "§4§lIPBAN §fUtilize §c/ipban §c(jogador) (motivo)");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			Player vitima = Bukkit.getPlayer(args[0]);
			if (vitima == null) {
				API.sendMsg(jogador, "§cO jogador em questão está offline ou nunca entrou no servidor!");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			if (vitima.getName() == jogador.getName()) {
				API.sendMsg(jogador, "§cVocê não pode banir a si mesmo!");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			if (Config.getConfig().getBans().get("Bans." + vitima.getUniqueId()) != null)  {
				 API.sendMsg(jogador, "§fO Jogador §6§l" + vitima.getName() + " §fjá está §4§lBANIDO§f! ");
				 API.sendSound(jogador, Sound.NOTE_PLING, 10);
				 return true;
			}
			if (Config.getConfig().getIpBans().get("IPBans." + vitima.getUniqueId()) != null)  {
				 API.sendMsg(jogador, "§fO Jogador §6§l" + vitima.getName() + " §fjá está §6§lBANIDO§4(IP)§f!");
				 API.sendSound(jogador, Sound.NOTE_PLING, 10);
				 return true;
			}
			if (Config.getConfig().getTempBans().get("TempBans." + vitima.getUniqueId()) != null)  {
				 API.sendMsg(jogador, "§fO Jogador §6§l" + vitima.getName() + " §7já está §6§lBANIDO§4(tempban)§f!");
				 API.sendSound(jogador, Sound.NOTE_PLING, 10);
				 return true;
			}
			if (args.length == 1) {
				 API.sendMsg(jogador, "§4§lIPBAN §fUtilize §c/ipban §c(jogador) (motivo)");
				 API.sendSound(jogador, Sound.NOTE_PLING, 10);
				 return true;
			}
			String Motivo = "";
			for (int i = 1; i < args.length; i++) {
				Motivo = Motivo + args[i] + " ";
			}
			API.sendMsg(jogador, "§4§lIPBAN §fVocê baniu o IP de §c" + vitima.getName() + "");
			API.sendStaff("§4§lIPBAN §f" + jogador.getName() + " baniu o IP do jogador §c" + vitima.getName() + "§fMotivo: §c" + Motivo);
			vitima.kickPlayer("§fVocê teve o seu IP §4§lBANIDO PERMANENTEMENTE §f do servidor!" + "\n" + "§7Username banido: §c" + vitima.getName() + "\n" + "§7IP banido: §c" + vitima.getAddress().getHostString() + "\n" + "§7Banido por: §c" + jogador.getName() + "\n" + "§7Motivo: §c" + Motivo + "\n" + "§7Expira em: §c§lNUNCA" + "\n" + "§cData do banimento: §c" + HorarioAPI.getHorario() + "\n" + "§fCompre §e§lUNBAN §fem nossa loja: §6§nspeedmc.com.br" + "\n" + "§fBanimento incorreto? Contate-nos pelo Twitter §c@SpeedMC§f!");
			
									 
			Config.getConfig().getIpBans().set("IPBans." + vitima.getUniqueId() + ".Nome", vitima.getName());
			Config.getConfig().getIpBans().set("IPBans." + vitima.getUniqueId() + ".Banido por", jogador.getName());
			Config.getConfig().getIpBans().set("IPBans." + vitima.getUniqueId() + ".Motivo", Motivo);
			Config.getConfig().getIpBans().set("IPBans." + vitima.getUniqueId() + ".IP do Jogador", vitima.getAddress().getHostString());
			Config.getConfig().getIpBans().set("IPBans." + vitima.getUniqueId() + ".Data do banimento", HorarioAPI.getHorario());
			Config.getConfig().saveIpBans();
			Bukkit.banIP(vitima.getAddress().getHostString());
			return true;						 
 		}
		return false;
	}
}
