package me.thauandev.bans;

import java.util.Iterator;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.spigotmc.ProtocolInjector;
import org.spigotmc.event.entity.EntityMountEvent;

import net.minecraft.server.v1_7_R4.ChatSerializer;
import net.minecraft.server.v1_7_R4.EntityPlayer;
import net.minecraft.server.v1_7_R4.EnumClientCommand;
import net.minecraft.server.v1_7_R4.IChatBaseComponent;
import net.minecraft.server.v1_7_R4.PacketPlayInClientCommand;
import net.minecraft.server.v1_7_R4.PlayerConnection;
import me.thauandev.bans.API;
import me.thauandev.bans.Config;
import me.thauandev.main.Main;

@SuppressWarnings({ "unused", "deprecation" })
public class Eventos implements Listener {

	@EventHandler
	void chatevent(PlayerChatEvent evento) {
		
		Player jogador = evento.getPlayer();
		
		if (Config.getConfig().getMute().get("Mute." + jogador.getUniqueId()) != null) {
			API.sendMsg(jogador, "§c§lSPEED§f§lMC §fVocê está mutado §fDuração §c§lPERMANTEMENTE");
			API.sendSound(jogador, Sound.ANVIL_USE, 10);
			evento.setCancelled(true);
		}
		else if (Config.getConfig().getTempMute().get("TempMute." + jogador.getUniqueId()) != null) {
			API.sendMsg(jogador, "§c§lSPEED§f§lMC §fVocê está §9§lMUTADO §fDuração §e§lTEMPORARIAMENTE§f.");
			API.sendSound(jogador, Sound.ANVIL_USE, 10);
			evento.setCancelled(true);
		}
	}
	@EventHandler
	public void loginEvent(PlayerLoginEvent evento) {
		
		Player jogador = evento.getPlayer();
		if (Config.getConfig().getBans().get("Bans." + jogador.getUniqueId()) != null) {
			evento.disallow(PlayerLoginEvent.Result.KICK_OTHER, ChatColor.GRAY + "§fVocê está banido §4§lPERMANENTEMENTE §fdo servidor!" + "\n" + "§fUsername banido: §c" + Config.getConfig().getBans().get("Bans." + jogador.getUniqueId() + ".Nome") + "\n" + "§fBanido por: §c§l" + Config.getConfig().getBans().get("Bans." + jogador.getUniqueId() + ".Banido por") + "\n" + "§fMotivo: §c§l" + Config.getConfig().getBans().get("Bans." + jogador.getUniqueId() + ".Motivo") + "\n" + "§fExpira em: §c§lNUNCA" + "\n" + "§fData do banimento: §c§l" + Config.getConfig().getBans().get("Bans." + jogador.getUniqueId() + ".Data do banimento") + "\n" + "§fCompre §e§lUNBAN §fem nossa loja §6§ndefaultmc.com.br" + "\n" + "§fBanimento incorreto? Contate-nos pelo Twitter §3§l@DefaultNT§f!");
		}
		else if (Config.getConfig().getTempBans().get("TempBans." + jogador.getUniqueId()) != null) {
			evento.disallow(PlayerLoginEvent.Result.KICK_OTHER, ChatColor.GRAY + "§fVocê está banido §9§lTEMPORARIAMENTE §f do servidor!" + "\n" + "§fUsername banido §c: " + Config.getConfig().getTempBans().get("TempBans." + jogador.getUniqueId() + ".Nome") + "\n" + "§fBanido por: §c§l" + Config.getConfig().getTempBans().get("TempBans." + jogador.getUniqueId() + ".Banido por") + "\n" + "§fMotivo: §c§l" + Config.getConfig().getTempBans().get("TempBans." + jogador.getUniqueId() + ".Motivo") + "\n" + "§fExpira em: §c§l" + Config.getConfig().getTempBans().get("TempBans." + jogador.getUniqueId() + ".Tempo do Ban") + "\n" + "§fData do banimento: §c§l" + Config.getConfig().getTempBans().get("TempBans." + jogador.getUniqueId() + ".Data do banimento") + "\n" + "§fCompre §9§lUNBAN §fem nossa loja §6§ndefaultmc.com.br" + "\n" + "§fBanimento incorreto? Contate-nos pelo Twitter §c@SpeedMC§f!");
		}
		else if (Config.getConfig().getIpBans().get("IPBans." + jogador.getUniqueId()) != null) {
			evento.disallow(PlayerLoginEvent.Result.KICK_OTHER, ChatColor.GRAY + "§fVocê está banido  §4§lPERMANENTEMENTE§f do servidor!" + "\n" + "§fUsername banido: §c " + Config.getConfig().getIpBans().get("IPBans." + jogador.getUniqueId() + ".Nome") + "\n" + "§fIP banido: §c§l" + Config.getConfig().getIpBans().get("IPBans." + jogador.getUniqueId() + ".IP do Jogador") + "\n" + "§fBanido por: §c§l" + Config.getConfig().getIpBans().get("IPBans." + jogador.getUniqueId() + ".Banido por") + "\n" + "§c§lMotivo: §c§l" + Config.getConfig().getIpBans().get("IPBans." + jogador.getUniqueId() + ".Motivo") + "\n" + "§fExpira em: §c§lNUNCA" + "\n" + "§cData do banimento: " + Config.getConfig().getIpBans().get("IPBans." + jogador.getUniqueId() + ".Data do banimento") + "\n" + "§fCompre §2§lUNBAN §fem: §c§ndefaultmc.com.br" + "\n" + "§cFoi banido injustamente? Contate-nos via Twitter §c@SpeedMC§f!");
		}
		else if (evento.getResult() == PlayerLoginEvent.Result.KICK_WHITELIST) {
			evento.setKickMessage("§c§lWHITELIST ATIVADA..." + "\n" + "§fEstamos em manutenção!"); 
 		}
	}
}