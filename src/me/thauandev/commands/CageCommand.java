package me.thauandev.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thauandev.configuração.cfGrupo;

public class CageCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("cage")) {
			if((!cfGrupo.ChecarGrupo(p, "Dono") && (!cfGrupo.ChecarGrupo(p, "Gerente") && (!cfGrupo.ChecarGrupo(p, "Admin") && (!cfGrupo.ChecarGrupo(p, "Mod+") && (!cfGrupo.ChecarGrupo(p, "Mod") && (!cfGrupo.ChecarGrupo(p, "Trial") && (!cfGrupo.ChecarGrupo(p, "Youtuber+") && (!cfGrupo.ChecarGrupo(p, "Helper")))))))))){
				p.sendMessage("§c§lSPEED§f§lMC §fVocê não possui permissão para executar esse comando!");
				return true;
			}
			if(args.length == 0) {
				p.sendMessage("§c§lSPEED§f§lMC §7Por favor utilize §c/cage (nick) §7para prender um jogador. Lembre-se: É necessário que você seja no mínimo §3§lYOUTUBER+ §7ou §5§lMOD+ §7para executar este comando por espontânea vontade ou poderá sofrer consequências graves!");
				return true;
			}
			if(args.length == 1) {
				Player t = Bukkit.getPlayer(args[0]);
				if(t == null) {
					p.sendMessage("§c§lSPEED§f§lMC §fJogador offline!");
					return true;
				}
				if(t.getName() == p.getName()) {
					p.sendMessage("§c§lSPEED§f§lMC §fVocê não pode prender a si mesmo!");
					return true;
				}
		        t.getLocation().add(0.0D, 13.0D, 0.0D).getBlock().setType(Material.BEDROCK);
		        t.getLocation().add(0.0D, 11.0D, 1.0D).getBlock().setType(Material.BEDROCK);
		        t.getLocation().add(1.0D, 11.0D, 0.0D).getBlock().setType(Material.BEDROCK);
		        t.getLocation().add(0.0D, 11.0D, -1.0D).getBlock().setType(Material.BEDROCK);
		        t.getLocation().add(-1.0D, 11.0D, 0.0D).getBlock().setType(Material.BEDROCK);
		        t.getLocation().add(0.0D, 10.0D, 0.0D).getBlock().setType(Material.BEDROCK);
		        t.teleport(t.getLocation().add(0.0D, 11.0D, -0.05D));
		        p.teleport(t.getLocation().add(3.0D, 0.0D, 0.05D));
				p.sendMessage("§c§lSPEED§f§lMC §fVocê prendeu o jogador: §c" + t.getName());
				t.sendMessage("§c§lSPEED§f§lMC §fAlgum §5§lMODERADOR §fDesconfia que voçê está utilizando programas ilegais por favor permaneça na cage até segunda ordem, caso delogue será banido §c§lPERMANENTEMENTE§f!");
				return true;
			}
		}
		return false;
	}
}
