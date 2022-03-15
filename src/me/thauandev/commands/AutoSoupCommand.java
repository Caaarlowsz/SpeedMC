package me.thauandev.commands;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.thauandev.API.API;
import me.thauandev.API.ArraysAPI;
import me.thauandev.configura��o.cfGrupo;
import com.github.caaarlowsz.speedmc.kitpvp.SpeedPvP;

public class AutoSoupCommand implements CommandExecutor {

	public static HashMap<Player, ItemStack[]> inventario = new HashMap<Player, ItemStack[]>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("autosoup")) {
			if ((!cfGrupo.ChecarGrupo(p, "Dono")
					&& (!cfGrupo.ChecarGrupo(p, "Gerente") && (!cfGrupo.ChecarGrupo(p, "Admin")
							&& (!cfGrupo.ChecarGrupo(p, "Mod+") && (!cfGrupo.ChecarGrupo(p, "Mod")
									&& (!cfGrupo.ChecarGrupo(p, "Trial") && (!cfGrupo.ChecarGrupo(p, "Youtuber+")
											&& (!cfGrupo.ChecarGrupo(p, "Helper")))))))))) {
				p.sendMessage("Voc� n�o possui permiss�o para executar este comando!");
				return true;
			}
			if (args.length == 0) {
				p.sendMessage("�c�lSPEED�f�lMC �fUtilize �b/autosoup (JOGADOR)");
				p.sendMessage(
						"�4�lATENCAO �7Verifique se o jogador n�o est� em duelo com algu�m pois o teste de autosoup poder� prejudic�-lo.");
				return true;
			}
			if (args.length == 1) {
				Player t = Bukkit.getPlayer(args[0]);
				if (t == null) {
					p.sendMessage("�cO jogador �c�l " + args[0] + " �7est� offline.");
					return true;
				}
				if (t.getName() == p.getName()) {
					p.sendMessage("�cVoc� n�o pode testar �c�lAutosoup �cem si mesmo!");
					return true;
				}
				if (ArraysAPI.Checando.contains(t)) {
					p.sendMessage(
							"�4�lAUTOSOUP �7Outro membro da equipe j� est� testando �c�lAutosoup �7neste jogador. Tente novamente!");
				}
				inventario.put(t, t.getInventory().getContents());
				t.getInventory().clear();
				t.setHealth(0.5D);
				ArraysAPI.Checando.add(t);

				p.openInventory(t.getInventory());
				t.getInventory().setItem(20,
						API.criarItem(p, Material.MUSHROOM_SOUP, "�f�oSopa", new String[] { "" }, 1, (short) 0));
				t.getInventory().setItem(21,
						API.criarItem(p, Material.MUSHROOM_SOUP, "�f�oSopa", new String[] { "" }, 1, (short) 0));
				t.getInventory().setItem(22,
						API.criarItem(p, Material.MUSHROOM_SOUP, "�f�oSopa", new String[] { "" }, 1, (short) 0));

				p.sendMessage("�aChecando...");
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(SpeedPvP.getPlugin(), new Runnable() {
					public void run() {

						if (API.getAmount(t, Material.BOWL) >= 1) {
							p.closeInventory();
							p.sendMessage(" ");
							p.sendMessage(
									"�4�lPROBABILIDADE: �fA probabilidade do jogador estar de Autosoup �: �4�lCERTEZA");
							p.sendMessage(" ");
						} else if (API.getAmount(t, Material.BOWL) == 0) {
							p.closeInventory();
							p.sendMessage(" ");
							p.sendMessage(
									"�4�lPROBABILIDADE: �fA probabilidade do jogador estar de Autosoup �: �a�lNENHUMA");
							p.sendMessage(" ");
						}
						ArraysAPI.Checando.remove(t);
						t.getInventory().clear();
						t.closeInventory();
						t.getInventory().setContents(inventario.get(t));
						t.setHealth(20.0D);

					}
				}, 1 * 60);
			}
		}
		return false;
	}
}
