package me.thauandev.events;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.spigotmc.ProtocolInjector;

import me.thauandev.main.Main;
import net.minecraft.server.v1_7_R4.ChatSerializer;
import net.minecraft.server.v1_7_R4.IChatBaseComponent;
import net.minecraft.server.v1_7_R4.PlayerConnection;

public class eTab implements Listener {
	private static int VERSION = 47;

	@EventHandler
	void TabDoServidor(PlayerJoinEvent evento) {
		final Player jogador = evento.getPlayer();
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
			public void run() {

				PlayerConnection connect = ((CraftPlayer) jogador).getHandle().playerConnection;
				IChatBaseComponent top = ChatSerializer.a(
						"{'extra': [{text: '', color: 'aqua'}],'color': gold, 'text': '   §c§lSPEED§f§lMC  \n        §cInformações§7 do servidor   '}");

				IChatBaseComponent bottom = ChatSerializer.a(
						"{'extra': [{'color': 'aqua', 'text': ' \n        §7Nosso site: §cwww.speedmc.com.br \n§7Nosso Twitter: §c@SpeedMC_ "
								+ "', 'underline': 'true'}], 'color': 'gold', 'text': ''}");
				if (((CraftPlayer) jogador).getHandle().playerConnection.networkManager.getVersion() < eTab.VERSION) {
					return;
				}
				connect.sendPacket(new ProtocolInjector.PacketTabHeader(top, bottom));
			}
		}, 1L, 20L);
	}
}