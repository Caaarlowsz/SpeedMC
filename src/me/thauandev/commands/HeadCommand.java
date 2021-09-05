package me.thauandev.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import me.thauandev.bans.API;
import me.thauandev.configuração.cfGrupo;

public class HeadCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("head")) {
			if ((!cfGrupo.ChecarGrupo(p, "Dono")
					&& (!cfGrupo.ChecarGrupo(p, "Gerente") && (!cfGrupo.ChecarGrupo(p, "Admin"))))) {
				API.sendMsg(p, "§c§lSPEED§f§lMC §cVocê não possui permissão para executar este comando.");
				return true;
			}
			if (args.length == 0) {
				p.sendMessage("§c§lSPEED§f§lMC §fUtilize §b/head §b(JOGADOR)§f!");
				return true;
			}
			if (args.length == 1) {
				String jogador = args[0];
				ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
				SkullMeta itemm = (SkullMeta) item.getItemMeta();
				itemm.setOwner(jogador);
				item.setItemMeta(itemm);
				p.getInventory().addItem(item);
				p.updateInventory();
				p.sendMessage("§fVocê pegou a cabeça de: §a§l" + jogador);
				return true;
			}
		}
		return false;
	}
}
