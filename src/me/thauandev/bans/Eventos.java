package me.thauandev.bans;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerLoginEvent;

public class Eventos implements Listener {

	@EventHandler
	void chatevent(PlayerChatEvent evento) {

		Player jogador = evento.getPlayer();

		if (Config.getConfig().getMute().get("Mute." + jogador.getUniqueId()) != null) {
			API.sendMsg(jogador, "§c§lSPEED§f§lMC §fVocê está mutado §fDuração §c§lPERMANTEMENTE");
			API.sendSound(jogador, Sound.ANVIL_USE, 10);
			evento.setCancelled(true);
		} else if (Config.getConfig().getTempMute().get("TempMute." + jogador.getUniqueId()) != null) {
			API.sendMsg(jogador, "§c§lSPEED§f§lMC §fVocê está §9§lMUTADO §fDuração §e§lTEMPORARIAMENTE§f.");
			API.sendSound(jogador, Sound.ANVIL_USE, 10);
			evento.setCancelled(true);
		}
	}

	@EventHandler
	public void loginEvent(PlayerLoginEvent evento) {

		Player jogador = evento.getPlayer();
		if (Config.getConfig().getBans().get("Bans." + jogador.getUniqueId()) != null) {
			evento.disallow(PlayerLoginEvent.Result.KICK_OTHER, ChatColor.GRAY
					+ "§fVocê está banido §4§lPERMANENTEMENTE §fdo servidor!" + "\n" + "§fUsername banido: §c"
					+ Config.getConfig().getBans().get("Bans." + jogador.getUniqueId() + ".Nome") + "\n"
					+ "§fBanido por: §c§l"
					+ Config.getConfig().getBans().get("Bans." + jogador.getUniqueId() + ".Banido por") + "\n"
					+ "§fMotivo: §c§l" + Config.getConfig().getBans().get("Bans." + jogador.getUniqueId() + ".Motivo")
					+ "\n" + "§fExpira em: §c§lNUNCA" + "\n" + "§fData do banimento: §c§l"
					+ Config.getConfig().getBans().get("Bans." + jogador.getUniqueId() + ".Data do banimento") + "\n"
					+ "§fCompre §e§lUNBAN §fem nossa loja §6§ndefaultmc.com.br" + "\n"
					+ "§fBanimento incorreto? Contate-nos pelo Twitter §3§l@DefaultNT§f!");
		} else if (Config.getConfig().getTempBans().get("TempBans." + jogador.getUniqueId()) != null) {
			evento.disallow(PlayerLoginEvent.Result.KICK_OTHER, ChatColor.GRAY
					+ "§fVocê está banido §9§lTEMPORARIAMENTE §f do servidor!" + "\n" + "§fUsername banido §c: "
					+ Config.getConfig().getTempBans().get("TempBans." + jogador.getUniqueId() + ".Nome") + "\n"
					+ "§fBanido por: §c§l"
					+ Config.getConfig().getTempBans().get("TempBans." + jogador.getUniqueId() + ".Banido por") + "\n"
					+ "§fMotivo: §c§l"
					+ Config.getConfig().getTempBans().get("TempBans." + jogador.getUniqueId() + ".Motivo") + "\n"
					+ "§fExpira em: §c§l"
					+ Config.getConfig().getTempBans().get("TempBans." + jogador.getUniqueId() + ".Tempo do Ban") + "\n"
					+ "§fData do banimento: §c§l"
					+ Config.getConfig().getTempBans().get("TempBans." + jogador.getUniqueId() + ".Data do banimento")
					+ "\n" + "§fCompre §9§lUNBAN §fem nossa loja §6§ndefaultmc.com.br" + "\n"
					+ "§fBanimento incorreto? Contate-nos pelo Twitter §c@SpeedMC§f!");
		} else if (Config.getConfig().getIpBans().get("IPBans." + jogador.getUniqueId()) != null) {
			evento.disallow(PlayerLoginEvent.Result.KICK_OTHER,
					ChatColor.GRAY + "§fVocê está banido  §4§lPERMANENTEMENTE§f do servidor!" + "\n"
							+ "§fUsername banido: §c "
							+ Config.getConfig().getIpBans().get("IPBans." + jogador.getUniqueId() + ".Nome") + "\n"
							+ "§fIP banido: §c§l"
							+ Config.getConfig().getIpBans().get("IPBans." + jogador.getUniqueId() + ".IP do Jogador")
							+ "\n" + "§fBanido por: §c§l"
							+ Config.getConfig().getIpBans().get("IPBans." + jogador.getUniqueId() + ".Banido por")
							+ "\n" + "§c§lMotivo: §c§l"
							+ Config.getConfig().getIpBans().get("IPBans." + jogador.getUniqueId() + ".Motivo") + "\n"
							+ "§fExpira em: §c§lNUNCA" + "\n" + "§cData do banimento: "
							+ Config.getConfig().getIpBans()
									.get("IPBans." + jogador.getUniqueId() + ".Data do banimento")
							+ "\n" + "§fCompre §2§lUNBAN §fem: §c§ndefaultmc.com.br" + "\n"
							+ "§cFoi banido injustamente? Contate-nos via Twitter §c@SpeedMC§f!");
		} else if (evento.getResult() == PlayerLoginEvent.Result.KICK_WHITELIST) {
			evento.setKickMessage("§c§lWHITELIST ATIVADA..." + "\n" + "§fEstamos em manutenção!");
		}
	}
}