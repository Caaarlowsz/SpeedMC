package me.thauandev.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thauandev.configuração.cfGrupo;
import me.thauandev.configuração.cfPermissão;

public class GiveKitCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("givekit")) {
			if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Mod+")  && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Gerente")){
				p.sendMessage("§c§lSPEED§f§lMC §fVocê não possui permissão para executar este comando!");
				return true;
			}
			if(args.length == 0) {
				p.sendMessage("§c§lSPEED§f§lMC §fUtilize §c/givekit §6(jogador) (kit)§f.");
				return true;
			}
			if(args.length == 1) {
				
			}
			if(args.length == 2) {
				String kit = args[1];
				Player k = Bukkit.getPlayer(args[0]);
				if(kit.equalsIgnoreCase("pvp")) {
					p.sendMessage("§c§lSPEED§f§lMC §7Você aplicou o kit §c§lPVP §7para o jogador: §c§l" + k.getName());
					k.sendMessage("§c§lSPEED§f§lMC §7Você recebeu o kit: §c§lPVP§7!");
					cfPermissão.setarPermissao(k, "kit.pvp", "true");
					return true;
				}
				if(kit.equalsIgnoreCase("archer")) {
					p.sendMessage("§c§lSPEED§f§lMC §7Você aplicou o kit §c§lARCHER §7para o jogador: §c§l" + k.getName());
					k.sendMessage("§c§lSPEED§f§lMC §7Você recebeu o kit: §c§lARCHER§7!");
					cfPermissão.setarPermissao(k, "kit.archer", "true");
					return true;
				}
				if(kit.equalsIgnoreCase("kangaroo")) {
					p.sendMessage("§c§lSPEED§f§lMC §7Você aplicou o kit §c§lKANGAROO §7para o jogador: §c§l" + k.getName());
					k.sendMessage("§c§lSPEED§f§lMC §7Você recebeu o kit: §c§lKANGAROO§7!");
					cfPermissão.setarPermissao(k, "kit.kangaroo", "true");
					return true;
				}
				if(kit.equalsIgnoreCase("fisherman")) {
					p.sendMessage("§c§lSPEED§f§lMC §7Você aplicou o kit §c§lFISHERMAN §7para o jogador: §c§l" + k.getName());
					k.sendMessage("§c§lSPEED§f§lMC §7Você recebeu o kit: §c§lFISHERMAN§7!");
					cfPermissão.setarPermissao(k, "kit.fisherman", "true");
					return true;
				}
				if(kit.equalsIgnoreCase("anchor")) {
					p.sendMessage("§c§lSPEED§f§lMC §7Você aplicou o kit §c§lANCHOR §7para o jogador: §c§l" + k.getName());
					k.sendMessage("§c§lSPEED§f§lMC §7Você recebeu o kit: §c§lANCHOR§7!");
					cfPermissão.setarPermissao(k, "kit.anchor", "true");
					return true;
				}
				if(kit.equalsIgnoreCase("cactus")) {
					p.sendMessage("§c§lSPEED§f§lMC §7Você aplicou o kit §c§lCACTUS §7para o jogador: §c§l" + k.getName());
					k.sendMessage("§c§lSPEED§f§lMC §7Você recebeu o kit: §c§lCACTUS§7!");
					cfPermissão.setarPermissao(k, "kit.cactus", "true");
					return true;
				}
				if(kit.equalsIgnoreCase("monk")) {
					p.sendMessage("§c§lSPEED§f§lMC §7Você aplicou o kit §c§lMONK §7para o jogador: §c§l" + k.getName());
					k.sendMessage("§c§lSPEED§f§lMC §7Você recebeu o kit: §c§lMONK§7!");
					cfPermissão.setarPermissao(k, "kit.", "true");
					return true;
				}
				if(kit.equalsIgnoreCase("ninja")) {
					p.sendMessage("§c§lSPEED§f§lMC §7Você aplicou o kit §c§lNINJA §7para o jogador: §c§l" + k.getName());
					k.sendMessage("§c§lSPEED§f§lMC §7Você recebeu o kit: §c§lNINJA§7!");
					cfPermissão.setarPermissao(k, "kit.ninja", "true");
					return true;
				}
				if(kit.equalsIgnoreCase("antitower")) {
					p.sendMessage("§c§lSPEED§f§lMC §7Você aplicou o kit §c§lANTITOWER §7para o jogador: §c§l" + k.getName());
					k.sendMessage("§c§lSPEED§f§lMC §7Você recebeu o kit: §c§lANTITOWER§7!");
					cfPermissão.setarPermissao(k, "kit.antitower", "true");
					return true;
				}
				if(kit.equalsIgnoreCase("phantom")) {
					p.sendMessage("§c§lSPEED§f§lMC §7Você aplicou o kit §c§lPHANTOM §7para o jogador: §c§l" + k.getName());
					k.sendMessage("§c§lSPEED§f§lMC §7Você recebeu o kit: §c§lPHANTOM§7!");
					cfPermissão.setarPermissao(k, "kit.phantom", "true");
					return true;
				}
				if(kit.equalsIgnoreCase("grappler")) {
					p.sendMessage("§c§lSPEED§f§lMC §7Você aplicou o kit §c§lGRAPPLER §7para o jogador: §c§l" + k.getName());
					k.sendMessage("§c§lSPEED§f§lMC §7Você recebeu o kit: §c§lGRAPPLER§7!");
					cfPermissão.setarPermissao(k, "kit.grappler", "true");
					return true;
				}
				if(kit.equalsIgnoreCase("viper")) {
					p.sendMessage("§c§lSPEED§f§lMC §7Você aplicou o kit §c§lVIPER §7para o jogador: §c§l" + k.getName());
					k.sendMessage("§c§lSPEED§f§lMC §7Você recebeu o kit: §c§lVIPER§7!");
					cfPermissão.setarPermissao(k, "kit.viper", "true");
					return true;
				}
				if(kit.equalsIgnoreCase("snail")) {
					p.sendMessage("§c§lSPEED§f§lMC §7Você aplicou o kit §c§lSNAIL §7para o jogador: §c§l" + k.getName());
					k.sendMessage("§c§lSPEED§f§lMC §7Você recebeu o kit: §c§lSNAIL7!");
					cfPermissão.setarPermissao(k, "kit.snail", "true");
					return true;
				}
				if(kit.equalsIgnoreCase("hulk")) {
					p.sendMessage("§c§lSPEED§f§lMC §7Você aplicou o kit §c§lHULK §7para o jogador: §c§l" + k.getName());
					k.sendMessage("§c§lSPEED§f§lMC §7Você recebeu o kit: §c§lHULK§7!");
					cfPermissão.setarPermissao(k, "kit.hulk", "true");
					return true;
				}
				if(kit.equalsIgnoreCase("timelord")) {
					p.sendMessage("§c§lSPEED§f§lMC §7Você aplicou o kit §c§lTIMELORD §7para o jogador: §c§l" + k.getName());
					k.sendMessage("§c§lSPEED§f§lMC §7Você recebeu o kit: §c§lTIMELORD§7!");
					cfPermissão.setarPermissao(k, "kit.timelord", "true");
					return true;
				}
				if(kit.equalsIgnoreCase("thor")) {
					p.sendMessage("§c§lSPEED§f§lMC §7Você aplicou o kit §c§lTHOR §7para o jogador: §c§l" + k.getName());
					k.sendMessage("§6§lNew§f§lPvP §6» §7Voce ganhou o KIT §6Thor");
					cfPermissão.setarPermissao(k, "kit.thor", "true");
					return true;
				}
				if(kit.equalsIgnoreCase("switcher")) {
					p.sendMessage("§c§lSPEED§f§lMC §7Você aplicou o kit §c§lSWITCHER §7para o jogador: §c§l" + k.getName());
					k.sendMessage("§c§lSPEED§f§lMC §7Você recebeu o kit: §c§lSWITCHER§7!");
					cfPermissão.setarPermissao(k, "kit.switcher", "true");
					return true;
				}
				if(kit.equalsIgnoreCase("gladiator")) {
					p.sendMessage("§c§lSPEED§f§lMC §7Você aplicou o kit §c§lGLADIATOR §7para o jogador: §c§l" + k.getName());
					k.sendMessage("§c§lSPEED§f§lMC §7Você recebeu o kit: §c§lGLADIATOR§7!");
					cfPermissão.setarPermissao(k, "kit.gladiator", "true");
					return true;
				}
				if(kit.equalsIgnoreCase("stomper")) {
					p.sendMessage("§c§lSPEED§f§lMC §7Você aplicou o kit §c§lSTOMPER §7para o jogador: §c§l" + k.getName());
					k.sendMessage("§c§lSPEED§f§lMC §7Você recebeu o kit: §c§lSTOMPER");
					cfPermissão.setarPermissao(k, "kit.stomper", "true");
					return true;
				}
				if(kit.equalsIgnoreCase("magma")) {
					p.sendMessage("§c§lSPEED§f§lMC §7Você aplicou o kit §c§lMAGMA §7para o jogador: §c§l" + k.getName());
					k.sendMessage("§c§lSPEED§f§lMC §7Você recebeu o kit: §c§lMAGMA§7!");
					cfPermissão.setarPermissao(k, "kit.magma", "true");
					return true;
				}
				if(kit.equalsIgnoreCase("grandpa")) {
					p.sendMessage("§c§lSPEED§f§lMC §7Você aplicou o kit §c§lGRANDPA §7para o jogador: §c§l" + k.getName());
					k.sendMessage("§c§lSPEED§f§lMC §7Você recebeu o kit: §c§lGRANDPA§7!");
					cfPermissão.setarPermissao(k, "kit.grandpa", "true");
					return true;
				}
				if(kit.equalsIgnoreCase("ajnin")) {
					p.sendMessage("§c§lSPEED§f§lMC §7Você aplicou o kit §c§lAJNIN §7para o jogador: §c§l" + k.getName());
					k.sendMessage("§c§lSPEED§f§lMC §7Você recebeu o kit: §c§lAJNIN§7!");
					cfPermissão.setarPermissao(k, "kit.ajnin", "true");
					return true;
				}
				if(kit.equalsIgnoreCase("firelauncher")) {
					p.sendMessage("§c§lSPEED§f§lMC §7Você aplicou o kit §c§lFIRELAUNCHER §7para o jogador: §c§l" + k.getName());
					k.sendMessage("§c§lSPEED§f§lMC §7Você recebeu o kit: §c§lFIRELAUNCHER§7!");
					cfPermissão.setarPermissao(k, "kit.firelauncher", "true");
					return true;
				}
				if(kit.equalsIgnoreCase("strong")) {
					p.sendMessage("§c§lSPEED§f§lMC §7Você aplicou o kit §c§lSTRONG §7para o jogador: §c§l" + k.getName());
					k.sendMessage("§c§lSPEED§f§lMC §7Você recebeu o kit: §c§lSTRONG§7!");
					cfPermissão.setarPermissao(k, "kit.strong", "true");
					return true;
				}
				if(kit.equalsIgnoreCase("sumo")) {
					p.sendMessage("§c§lSPEED§f§lMC §7Você aplicou o kit §c§lSUMO §7para o jogador: §c§l" + k.getName());
					k.sendMessage("§c§lSPEED§f§lMC §7Você recebeu o kit: §c§lSUMO§7!");
					cfPermissão.setarPermissao(k, "kit.sumo", "true");
					return true;
				} else {
					p.sendMessage("§c§lSPEED§f§lMC §fkit inexistente!");
					return true;
				}
			}
		}
		return false;
	}
}
