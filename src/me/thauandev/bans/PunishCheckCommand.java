package me.thauandev.bans;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thauandev.configuração.cfGrupo;

public class PunishCheckCommand implements CommandExecutor {
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		final Player jogador = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("bancheck")) {
			if((!cfGrupo.ChecarGrupo(jogador, "Dono") && (!cfGrupo.ChecarGrupo(jogador, "Gerente") && (!cfGrupo.ChecarGrupo(jogador, "Admin") && (!cfGrupo.ChecarGrupo(jogador, "Mod+") && (!cfGrupo.ChecarGrupo(jogador, "Mod") && !cfGrupo.ChecarGrupo(jogador, "Dono"))))))){
				API.sendMsg(jogador, "§b§lSLASH§f§lMC §fVoce nao §a§lPOSSUI §fAcesso ae §b§lCHECK§f!");
				return true;
			}
			if(args.length == 0) {
				API.sendMsg(jogador, "§b§lSLASH§f§lMC §fO §b/bancheck §fserve para checar o histórico de punições de um certo jogador. Use: §b/bancheck (JOGADOR)§f!");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			Player check = Bukkit.getPlayer(args[0]);
			if(check == null) {
				OfflinePlayer checkoff = Bukkit.getOfflinePlayer(args[0]);
				if(Config.getConfig().getJogadores().get("Jogadores." + checkoff.getUniqueId()) == null) {
					API.sendMsg(jogador, "§fO jogador §6§l" + checkoff.getName() + " §fnunca entrou no servidor!");
					API.sendSound(jogador, Sound.NOTE_PLING, 10);
					return true;
				}
				if(Config.getConfig().getJogadores().get("Jogadores." + checkoff.getUniqueId()) != null) {
					if(Config.getConfig().getBans().get("Bans." + checkoff.getUniqueId()) == null && Config.getConfig().getTempBans().get("TempBans." + checkoff.getUniqueId()) == null && Config.getConfig().getIpBans().get("IPBans." + checkoff.getUniqueId()) == null) {
						API.sendMsg(jogador, "§aChecando informações de" + checkoff.getName());
						API.sendMsg(jogador, " ");
						API.sendMsg(jogador, "§7Banido §4§lPERMANENTEMENTE§f: §c§lNAO");
						API.sendMsg(jogador, "§7Banido §9§lTEMPORARIAMENTE§f: §c§lNAO");
						API.sendMsg(jogador, "§7Banido por §8§lIP§7: §c§lNAO");
						return true;
					}
					if(Config.getConfig().getBans().get("Bans." + checkoff.getUniqueId()) != null && Config.getConfig().getTempBans().get("TempBans." + checkoff.getUniqueId()) == null && Config.getConfig().getIpBans().get("IPBans." + checkoff.getUniqueId()) == null) {
						API.sendMsg(jogador, "§aChecando informações de " + checkoff.getName());
						API.sendMsg(jogador, " ");
						API.sendMsg(jogador, "§7Banido §4§lPERMANENTEMENTE§f: §a§lSIM");
						API.sendMsg(jogador, "§7Banido por: §5§l" + Config.getConfig().getBans().get("Bans." + checkoff.getUniqueId() + ".Banido por"));
						API.sendMsg(jogador, "§7Motivo: §6§l" + Config.getConfig().getBans().get("Bans." + checkoff.getUniqueId() + ".Motivo"));
						API.sendMsg(jogador, "§7Data do banimento: §a" + Config.getConfig().getBans().get("Bans." + checkoff.getUniqueId() + ".Data do banimento"));
						API.sendMsg(jogador, "§7Banido §9§lTEMPORARIAMENTE§f: §c§lNAO");
						API.sendMsg(jogador, "§7Banido por §8§lIP§7: §c§lNAO");
						return true;
					}
					if(Config.getConfig().getBans().get("Bans." + checkoff.getUniqueId()) == null && Config.getConfig().getTempBans().get("TempBans." + checkoff.getUniqueId()) != null && Config.getConfig().getIpBans().get("IPBans." + checkoff.getUniqueId()) == null) {
						API.sendMsg(jogador, "§aChecando informações de " + checkoff.getName());
						API.sendMsg(jogador, " ");
						API.sendMsg(jogador, "§7Banido §4§lPERMANENTEMENTE§7: §c§lNAO");
						API.sendMsg(jogador, "§7Banido §9§lTEMPORARIAMENTE§7: §a§lSIM");
						API.sendMsg(jogador, "§7Banido por: §5§l" + Config.getConfig().getTempBans().get("TempBans." + checkoff.getUniqueId() + ".Banido por"));
						API.sendMsg(jogador, "§7Motivo: §6§l" + Config.getConfig().getTempBans().get("TempBans." + checkoff.getUniqueId() + ".Motivo"));
						API.sendMsg(jogador, "§7Expira em: §a" + Config.getConfig().getTempBans().get("TempBans." + checkoff.getUniqueId() + ".Tempo do Ban"));
						API.sendMsg(jogador, "§7Data do banimento: §e" + Config.getConfig().getTempBans().get("TempBans." + checkoff.getUniqueId() + ".Data do banimento"));
						API.sendMsg(jogador, "§7Banido §8IP§7: §c§lNAO");
						return true;
					}
					if(Config.getConfig().getBans().get("Bans." + checkoff.getUniqueId()) == null && Config.getConfig().getTempBans().get("TempBans." + checkoff.getUniqueId()) == null && Config.getConfig().getIpBans().get("IPBans." + checkoff.getUniqueId()) != null) {
						API.sendMsg(jogador, "§aChecando informações de " + checkoff.getName());
						API.sendMsg(jogador, " ");
						API.sendMsg(jogador, "§7Banido §4§lPERMANENTEMENTE§7: §c§lNAO");
						API.sendMsg(jogador, "§7Banido §9§lTEMPORARIAMENTE§7: §c§lNAO");
						API.sendMsg(jogador, "§7Banido por §8§lIP§7: §a§lSIM");
						API.sendMsg(jogador, "§7Banido por: §e§l" + Config.getConfig().getIpBans().get("IPBans." + checkoff.getUniqueId() + ".Banido por"));
						API.sendMsg(jogador, "§7Motivo: §6§l" + Config.getConfig().getIpBans().get("IPBans." + checkoff.getUniqueId() + ".Motivo"));
						API.sendMsg(jogador, "§7Data do banimento: §a" + Config.getConfig().getIpBans().get("IPBans." + checkoff.getUniqueId() + ".Data do banimento"));
						API.sendMsg(jogador, "§7IP banido: §8" + Config.getConfig().getIpBans().get("IPBans." + checkoff.getUniqueId() + ".IP do Jogador"));
						return true;
					}
				}
			}
			if(Config.getConfig().getBans().get("Bans." + check.getUniqueId()) == null && Config.getConfig().getTempBans().get("TempBans." + check.getUniqueId()) == null && Config.getConfig().getIpBans().get("IPBans." + check.getUniqueId()) == null) {
				API.sendMsg(jogador, "§aChecando informações de " + check.getName());
				API.sendMsg(jogador, " ");
				API.sendMsg(jogador, "§7Banido §4§lPERMANENTEMENTE§7: §c§lNAO");
				API.sendMsg(jogador, "§7Banido §9§lTEMPORARIAMENTE§7: §c§lNAO");
				API.sendMsg(jogador, "§7Banido por §8§lIP§7: §c§lNAO");
				return true;
			}
			if(Config.getConfig().getBans().get("Bans." + check.getUniqueId()) != null && Config.getConfig().getTempBans().get("TempBans." + check.getUniqueId()) == null && Config.getConfig().getIpBans().get("IPBans." + check.getUniqueId()) == null) {
				API.sendMsg(jogador, "§aChecando informações de " + check.getName());
				API.sendMsg(jogador, " ");
				API.sendMsg(jogador, "§7Banido §4§lPERMANENTEMENTE§7: §a§lSIM");
				API.sendMsg(jogador, "§7Banido por: §5§l" + Config.getConfig().getBans().get("Bans." + check.getUniqueId() + ".Banido por"));
				API.sendMsg(jogador, "§7Motivo: §6§l" + Config.getConfig().getBans().get("Bans." + check.getUniqueId() + ".Motivo"));
				API.sendMsg(jogador, "§7Data do banimento: §a" + Config.getConfig().getBans().get("Bans." + check.getUniqueId() + ".Data do banimento"));
				API.sendMsg(jogador, "§7Banido §9§lTEMPORARIAMENTE§7: §c§lNAO");
				API.sendMsg(jogador, "§7Banido por §8§lIP§7: §c§lNAO");
				return true;
			}
			if(Config.getConfig().getBans().get("Bans." + check.getUniqueId()) == null && Config.getConfig().getTempBans().get("TempBans." + check.getUniqueId()) != null && Config.getConfig().getIpBans().get("IPBans." + check.getUniqueId()) == null) {
				API.sendMsg(jogador, "§aChecando informações de " + check.getName());
				API.sendMsg(jogador, "§7Banido §4§lPERMANENTEMENTE: §c§lNAO");
				API.sendMsg(jogador, "§7Banido §9§lTEMPORARIAMENTE§7: §a§lSIM");
				API.sendMsg(jogador, "§7Banido por: §5§l" + Config.getConfig().getTempBans().get("TempBans." + check.getUniqueId() + ".Banido por"));
				API.sendMsg(jogador, "§7Motivo: §6§l " + Config.getConfig().getTempBans().get("TempBans." + check.getUniqueId() + ".Motivo"));
				API.sendMsg(jogador, "§7Expira em: §a" + Config.getConfig().getTempBans().get("TempBans." + check.getUniqueId() + ".Tempo do Ban"));
				API.sendMsg(jogador, "§7Data do banimento: §e" + Config.getConfig().getTempBans().get("TempBans." + check.getUniqueId() + ".Data do banimento"));
				API.sendMsg(jogador, "§7Banido por §8§lIP§7: §c§lNAO");
				return true;
			}
			if(Config.getConfig().getBans().get("Bans." + check.getUniqueId()) == null && Config.getConfig().getTempBans().get("TempBans." + check.getUniqueId()) == null && Config.getConfig().getIpBans().get("IPBans." + check.getUniqueId()) != null) {
				API.sendMsg(jogador, "§eChecando informações de " + check.getName());
				API.sendMsg(jogador, " ");
				API.sendMsg(jogador, "§7Banido §4§lPERMANENTEMENTE§7: §c§lNAO");
				API.sendMsg(jogador, "§7Banido §9§LTEMPORARIAMENTE: §c§lNAO");
				API.sendMsg(jogador, "§7Banido por §8§lIP: §a§lSIM");
				API.sendMsg(jogador, "§7Banido por: §5§l" + Config.getConfig().getIpBans().get("IPBans." + check.getUniqueId() + ".Banido por"));
				API.sendMsg(jogador, "§7Motivo: §6§l" + Config.getConfig().getIpBans().get("IPBans." + check.getUniqueId() + ".Motivo"));
				API.sendMsg(jogador, "§7Data do banimento: §a" + Config.getConfig().getIpBans().get("IPBans." + check.getUniqueId() + ".Data do banimento"));
				API.sendMsg(jogador, "§7IP banido: §8" + Config.getConfig().getIpBans().get("IPBans." + check.getUniqueId() + ".IP do Jogador"));
				return true;
			}
		}
		if(cmd.getName().equalsIgnoreCase("mutecheck")) {
			if((!cfGrupo.ChecarGrupo(jogador, "Dono") && (!cfGrupo.ChecarGrupo(jogador, "Gerente") && (!cfGrupo.ChecarGrupo(jogador, "Admin") && (!cfGrupo.ChecarGrupo(jogador, "Mod+") && (!cfGrupo.ChecarGrupo(jogador, "Mod"))))))){
				API.sendMsg(jogador, "§cVocê não possui permissão para executar este comando!");
				return true;
			}
			if(args.length == 0) {
				API.sendMsg(jogador, "§fO §b§l/mutecheck §fserve para checar o histórico de punições de um certo jogador. Use: §b§l/mutecheck <nickname>§f!");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			Player check = Bukkit.getPlayer(args[0]);
			if(check == null) {
				OfflinePlayer checkoff = Bukkit.getOfflinePlayer(args[0]);
				if(Config.getConfig().getJogadores().get("Jogadores." + checkoff.getUniqueId()) == null) {
					API.sendMsg(jogador, "§fO jogador §6§l" + checkoff.getName() + " §fnunca entrou no servidor!");				API.sendSound(jogador, Sound.NOTE_PLING, 10);
					return true;
				}
				if(Config.getConfig().getJogadores().get("Jogadores." + checkoff.getUniqueId()) != null) {
					if(Config.getConfig().getMute().get("Mute." + checkoff.getUniqueId()) == null && Config.getConfig().getTempMute().get("TempMute." + checkoff.getUniqueId()) == null) {
						API.sendMsg(jogador, "§a" + checkoff.getName());
						API.sendMsg(jogador, " ");
						API.sendMsg(jogador, "§7Mutado §4§lPERMANENTEMENTE§7: §c§lNAO");
						API.sendMsg(jogador, "§7Mutado §9§lTEMPORARIAMENTE: §c§lNAO");
						return true;
					}
					if(Config.getConfig().getMute().get("Mute." + checkoff.getUniqueId()) != null && Config.getConfig().getTempMute().get("TempMute." + checkoff.getUniqueId()) == null) {
						API.sendMsg(jogador, "§7Checando informacoes de " + checkoff.getName());
						API.sendMsg(jogador, " ");
						API.sendMsg(jogador, "§7Mutado §4§lPERMANENTEMENTE§7: §a§lSIM");
						API.sendMsg(jogador, "§7Mutado por: §5§l" + Config.getConfig().getMute().get("Mute." + checkoff.getUniqueId() + ".Mutado por"));
						API.sendMsg(jogador, "§7Motivo: §6§l" + Config.getConfig().getMute().get("Mute." + checkoff.getUniqueId() + ".Motivo"));
						API.sendMsg(jogador, "§7Data do mute: §e" + Config.getConfig().getMute().get("Mute." + checkoff.getUniqueId() + ".Data do mute"));
						API.sendMsg(jogador, "§7Mutado §9§lTEMPORARIAMENTE§7: §c§lNAO");
						return true;
					}
					if(Config.getConfig().getMute().get("Mute." + checkoff.getUniqueId()) == null && Config.getConfig().getTempMute().get("TempMute." + checkoff.getUniqueId()) != null) {
						API.sendMsg(jogador, "§7Checando informacoes de " + checkoff.getName());
						API.sendMsg(jogador, " ");
						API.sendMsg(jogador, "§7Mutado §4§lPERMANENTEMENTE§7: §c§lNAO");
						API.sendMsg(jogador, "§7Mutado §9§lTEMPORARIAMENTE§7: §a§lSIM");
						API.sendMsg(jogador, "§7Mutado por: §5§l" + Config.getConfig().getTempMute().get("TempMute." + checkoff.getUniqueId() + ".Mutado por"));
						API.sendMsg(jogador, "§7Motivo: §6§l" + Config.getConfig().getTempMute().get("TempMute." + checkoff.getUniqueId() + ".Motivo"));
						API.sendMsg(jogador, "§7Expira em: §a" + Config.getConfig().getTempMute().get("TempMute." + checkoff.getUniqueId() + ".Tempo do Mute"));
						API.sendMsg(jogador, "§7Data do mute: §e" + Config.getConfig().getTempMute().get("TempMute." + checkoff.getUniqueId() + ".Data do mute"));
						return true;
					}
				}
			}
			if(Config.getConfig().getMute().get("Mute." + check.getUniqueId()) == null && Config.getConfig().getTempMute().get("TempMute." + check.getUniqueId()) == null) {
				API.sendMsg(jogador, "§aChecando informações de " + check.getName());
				API.sendMsg(jogador, "");
				API.sendMsg(jogador, "§7Mutado §4§lPERMANENTEMENTE§7: §c§lNAO");
				API.sendMsg(jogador, "§7Mutado §9§lTEMPORARIAMENTE§7: §c§lNAO");
				return true;
			}
			if(Config.getConfig().getMute().get("Mute." + check.getUniqueId()) != null && Config.getConfig().getTempMute().get("TempMute." + check.getUniqueId()) == null) {
				API.sendMsg(jogador, "§aChecando informações de " + check.getName());
				API.sendMsg(jogador, " ");
				API.sendMsg(jogador, "§7Mutado §4§lPERMANENTEMENTE: §a§lSIM");
				API.sendMsg(jogador, "§7Mutado por: §5§l" + Config.getConfig().getMute().get("Mute." + check.getUniqueId() + ".Mutado por"));
				API.sendMsg(jogador, "§7Motivo: §6§l" + Config.getConfig().getMute().get("Mute." + check.getUniqueId() + ".Motivo"));
				API.sendMsg(jogador, "§7Data do mute: §a" + Config.getConfig().getMute().get("Mute." + check.getUniqueId() + ".Data do mute"));
				API.sendMsg(jogador, "§7Mutado §9§lTEMPORARIAMENTE: §c§lNAO");
				return true;
			}
			if(Config.getConfig().getMute().get("Mute." + check.getUniqueId()) == null && Config.getConfig().getTempMute().get("TempMute." + check.getUniqueId()) != null) {
				API.sendMsg(jogador, "§aChecando informações de " + check.getName());
				API.sendMsg(jogador, " ");
				API.sendMsg(jogador, "§7Mutado §4§lPERMANENTEMENTE§7: §c§lNAO");
				API.sendMsg(jogador, "§7Mutado §9§lTEMPORARIAMENTE§7: §a§lSIM");
				API.sendMsg(jogador, "§7Mutado por: §5§l" + Config.getConfig().getTempMute().get("TempMute." + check.getUniqueId() + ".Mutado por"));
				API.sendMsg(jogador, "§7Motivo: §6§l" + Config.getConfig().getTempMute().get("TempMute." + check.getUniqueId() + ".Motivo"));
				API.sendMsg(jogador, "§7Expira em: §a" + Config.getConfig().getTempMute().get("TempMute." + check.getUniqueId() + ".Tempo do Mute"));
				API.sendMsg(jogador, "§7Data do mute: §e" + Config.getConfig().getTempMute().get("TempMute." + check.getUniqueId() + ".Data do mute"));
				return true;
			}
		}
		return false;
	}
}
