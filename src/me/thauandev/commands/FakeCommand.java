package me.thauandev.commands;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.PluginManager;

import me.thauandev.main.Main;
import me.thauandev.nametag.Array;
import me.thauandev.nametag.NameTagChangeEvento;
import me.thauandev.nametag.NameTagChangeEvento.NametagChangeReason;
import me.thauandev.nametag.NametagUtils;
import me.thauandev.nametag.PlayerLoader;
import me.thauandev.scoreboard.sScoreAPI;
import me.thauandev.configura��o.cfGrupo;
import net.minecraft.server.v1_7_R4.EntityPlayer;
import net.minecraft.server.v1_7_R4.PacketPlayOutNamedEntitySpawn;
import net.minecraft.util.com.mojang.authlib.GameProfile;

public class FakeCommand implements Listener, CommandExecutor {
	PluginManager pm = Bukkit.getServer().getPluginManager();
	protected NametagChangeReason reason;
	public static ArrayList<Player> usandoFake = new ArrayList<>();
	public static HashMap<String, String> fake = new HashMap<>();
	public static HashMap<Player, Player> nick = new HashMap<>();
	public static ArrayList<String> fakes = new ArrayList<>();

	public boolean onCommand(CommandSender sender, Command cmd, String label, final String[] args) {
		if ((sender instanceof Player)) {
			final Player p = (Player) sender;
			if (cmd.getName().equalsIgnoreCase("fake")) {
				if(cfGrupo.ChecarGrupo(p, "Dono") || cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Mod+") || cfGrupo.ChecarGrupo(p, "Mod") || cfGrupo.ChecarGrupo(p, "Youtuber+") || cfGrupo.ChecarGrupo(p, "Youtuber")){
					if (args.length == 0) {
						p.sendMessage("�1�lFAKE�f Voce nao selecionou um fake.");
						return false;
					} else if (args.length == 1) {
						if (args[0].equalsIgnoreCase("remove")) {
							if (usandoFake.contains(p)) {
								usandoFake.remove(p);
								fakes.remove(p.getName());
								p.setDisplayName((String) fake.get(p.getName()));
								p.setPlayerListName("�7" + (String) fake.get(p.getName()));
								
								String suffix = " �7(" + sScoreAPI.getRank(p) + "�7)";
						          reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
						          suffix = NametagUtils.formatColors(suffix);
						          
								mudarNome(p, (String) fake.get(p.getName()));
								p.sendMessage("�1�lFAKE�f Fake �e�lRESETADO�f Com sucesso!");
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(null), new Runnable() {
									public void run() {
									}
								}, 2L);
							} else {
							}
						} else if (!fakes.contains(args[0])) {
							if (usandoFake.contains(p)) {
								p.sendMessage(
										"�1�lFAKE�f Tire Seu Fake para colocar outro.");
								return true;
							}

							if (args[0].length() > 14) {
								p.sendMessage("�1�lFAKE�f O nick que voce escolheu nao esta desponivel.");
								return true;
							}
							String nome = p.getName();
							nick.put(p, p);
							mudarNome(p, args[0]);
							usandoFake.add(p);
							fakes.add(args[0]);
							fake.put(p.getName(), nome);
							p.setDisplayName(args[0]);
							p.setPlayerListName(args[0]);
							p.sendMessage("�1�lFAKE�f Fake Alterado Para " + args[0]);
							Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(null), new Runnable() {
								public void run() {
									String prefix = "�7";
									p.setDisplayName("�7" + p.getName());
									p.setPlayerListName("�7" + p.getName());
									  
									String suffix = " �7(" + sScoreAPI.getRank(p) + "�7)";
							          reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
							          suffix = NametagUtils.formatColors(suffix);
							          
							           Array.SetarNameTagSoft(p.getName(), prefix , suffix, reason);
							           PlayerLoader.update(p.getName(), prefix , suffix);

								}
							}, 2L);
						} else {
						}
					}
				} else {
					p.sendMessage("�3�lDEFAULT�f�lMC �fVoce nao �a�lPOSSUI �fpermissao para o �1�lFAKE");
				}
			}
		} else {
			sender.sendMessage("�7Apenas Players Podem Usar �aFake");
		}
		return false;
	}

	@EventHandler
	public void sair(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		if (usandoFake.contains(e.getPlayer())) {
			usandoFake.remove(p);
			fakes.remove(p.getName());

			p.setDisplayName((String) fake.get(p.getName()));
			p.setPlayerListName((String) fake.get(p.getName()));
			mudarNome(p, (String) fake.get(p.getName()));
		}
	}

	@SuppressWarnings("deprecation")
	public static void mudarNome(Player p, String nome) {
		EntityPlayer ep = ((CraftPlayer) p).getHandle();
		PacketPlayOutNamedEntitySpawn packet = new PacketPlayOutNamedEntitySpawn(ep);
		try {
			Field field = packet.getClass().getDeclaredField("b");
			field.setAccessible(true);
			GameProfile gameProfile = (GameProfile) field.get(packet);
			Field name = gameProfile.getClass().getDeclaredField("name");

			name.setAccessible(true);
			name.set(gameProfile, nome);
		} catch (Exception ex) {
			ex.printStackTrace();
			p.sendMessage("Erro");
		}
		Player[] arrayOfPlayer;
		int name = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
		for (int gameProfile = 0; gameProfile < name; gameProfile++) {
			Player p2 = arrayOfPlayer[gameProfile];
			if (p2 != p) {
				((org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer) p2).getHandle().playerConnection
						.sendPacket(packet);
			}
		}
	}
}
