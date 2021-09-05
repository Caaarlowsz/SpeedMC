package me.thauandev.bans;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thauandev.API.HorarioAPI;
import me.thauandev.bans.API;
import me.thauandev.bans.Config;
import me.thauandev.configuração.cfGrupo;

public class MuteCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label,  String[] args) {
		
		if (!(sender instanceof Player)) {
			return true;
		}
		Player jogador = (Player)sender;
		if (cmd.getName().equalsIgnoreCase("mute")) {
			if((!cfGrupo.ChecarGrupo(jogador, "Dono") && (!cfGrupo.ChecarGrupo(jogador, "Gerente") && (!cfGrupo.ChecarGrupo(jogador, "Admin") && (!cfGrupo.ChecarGrupo(jogador, "Mod+") && (!cfGrupo.ChecarGrupo(jogador, "Mod") && (!cfGrupo.ChecarGrupo(jogador, "Trial") && (!cfGrupo.ChecarGrupo(jogador, "Youtuber+") && (!cfGrupo.ChecarGrupo(jogador, "Helper")))))))))){
				API.sendMsg(jogador, "§c§l(!) §cVocê não possui permissão para executar este comando!");
				return true;
			}
			if (args.length == 0) {
				API.sendMsg(jogador, "§9§lMUTE §fUtilize §9§l/mute §9(jogador) (motivo)");
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
				API.sendMsg(jogador, "§cVocê não pode mutar a si mesmo!");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			if (Config.getConfig().getBans().get("Mute." + vitima.getUniqueId()) != null)  {
				 API.sendMsg(jogador, "§fO jogador §6§l" + vitima.getName() + " §fjá está §9§lMUTADO§f!");
				 API.sendSound(jogador, Sound.NOTE_PLING, 10);
				 return true;
			}
			if (Config.getConfig().getIpBans().get("TempMute." + vitima.getUniqueId()) != null)  {
				 API.sendMsg(jogador, "§fO jogador §6§l" + vitima.getName() + " §fjá está §9§lMUTADO§f!");
				 API.sendSound(jogador, Sound.NOTE_PLING, 10);
				 return true;
			}
			if (args.length == 1) {
				 API.sendMsg(jogador, "§9§lMUTE §fUtilize §9§l/mute §9(jogador) (motivo)");
				 API.sendSound(jogador, Sound.NOTE_PLING, 10);
				 return true;
			}
			String Motivo = "";
			for (int i = 1; i < args.length; i++) {
				Motivo = Motivo + args[i] + " ";
			}
			API.sendMsg(jogador, "§9§lMUTE §fVocê mutou o jogador §c§l" + vitima.getName() + "§f.");
			API.sendStaff("§9§lMUTE §f" + jogador.getName() + " mutou o jogador §c§l" + vitima.getName() + "§f. Motivo: §6§l" + Motivo);
			API.sendMsg(vitima, "§fVocê foi §9§lMUTADO §fpor: §4§l" + jogador.getName() + "§f. Motivo: §3§l" + Motivo);
			
									 
			Config.getConfig().getMute().set("Mute." + vitima.getUniqueId() + ".Nome", vitima.getName());
			Config.getConfig().getMute().set("Mute." + vitima.getUniqueId() + ".Mutado por", jogador.getName());
			Config.getConfig().getMute().set("Mute." + vitima.getUniqueId() + ".Motivo", Motivo);
			Config.getConfig().getMute().set("Mute." + vitima.getUniqueId() + ".Data do mute", HorarioAPI.getHorario());
			Config.getConfig().saveMute();
			return true;
		}
		return false;
		
	}
}
