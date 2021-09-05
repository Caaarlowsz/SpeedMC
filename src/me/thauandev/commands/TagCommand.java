package me.thauandev.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thauandev.configuração.cfGrupo;
import me.thauandev.configuração.cfPermissão;
import me.thauandev.nametag.Array;
import me.thauandev.nametag.NameTagChangeEvento;
import me.thauandev.nametag.NametagUtils;
import me.thauandev.nametag.PlayerLoader;
import me.thauandev.scoreboard.sScoreAPI;


public class TagCommand implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if ((cmd.getName().equalsIgnoreCase("tag"))) {
			final Player p = (Player) sender;
			if (args.length == 0) {
				if(cfGrupo.ChecarGrupo(p, "Dono")){
					p.sendMessage(" ");
					p.sendMessage("§9§lTAGS §fSelecione sua §3§lTAG:");
					p.sendMessage("§7§lNORMAL");
					p.sendMessage("  ");
					p.sendMessage("§3§lTAGS§f de ultilidade §A§LVIP§f:");
					p.sendMessage("§b§lYOUTUBER");
					p.sendMessage("§d§lULTIMATE");
					p.sendMessage("§6§lPREMIUM");
					p.sendMessage("§a§lLIGHT");
					p.sendMessage("  ");
					p.sendMessage("§3§lTAGS§f de ultilidade §e§lSTAFF§f:");
					p.sendMessage("§9§lAJUDANTE");
					p.sendMessage("§5§lTRIAL");
					p.sendMessage("§3§lYOUTUBER+");
					p.sendMessage("§5§lMOD");
					p.sendMessage("§5§lMOD+");
					p.sendMessage("§c§lGERENTE");
					p.sendMessage("§c§lADMIN");
					p.sendMessage("§4§lDONO");
					
					return true;
				}
				if(cfGrupo.ChecarGrupo(p, "Admin")){
					p.sendMessage(" ");
					p.sendMessage("§9§lTAGS §fSelecione sua §3§lTAG:");
					p.sendMessage("§7§lNORMAL");
					p.sendMessage("  ");
					p.sendMessage("§3§lTAGS§f de ultilidade §A§LVIP§f:");
					p.sendMessage("§b§lYOUTUBER");
					p.sendMessage("§d§lULTIMATE");
					p.sendMessage("§6§lPREMIUM");
					p.sendMessage("§a§lLIGHT");
					p.sendMessage("  ");
					p.sendMessage("§3§lTAGS§f de ultilidade §e§lSTAFF§f:");
					p.sendMessage("§9§lAJUDANTE");
					p.sendMessage("§5§lTRIAL");
					p.sendMessage("§3§lYOUTUBER+");
					p.sendMessage("§5§lMOD");
					p.sendMessage("§5§lMOD+");
					p.sendMessage("§c§lGERENTE");
					p.sendMessage("§c§lADMIN");
					return true;
				}
				if(cfGrupo.ChecarGrupo(p, "Gerente")){
					p.sendMessage(" ");
					p.sendMessage("§9§lTAGS §fSelecione sua §3§lTAG:");
					p.sendMessage("§7§lNORMAL");
					p.sendMessage("  ");
					p.sendMessage("§3§lTAGS§f de ultilidade §A§LVIP§f:");
					p.sendMessage("§b§lYOUTUBER");
					p.sendMessage("§d§lULTIMATE");
					p.sendMessage("§6§lPREMIUM");
					p.sendMessage("§a§lLIGHT");
					p.sendMessage("  ");
					p.sendMessage("§3§lTAGS§f de ultilidade §e§lSTAFF§f:");
					p.sendMessage("§9§lAJUDANTE");
					p.sendMessage("§5§lTRIAL");
					p.sendMessage("§3§lYOUTUBER+");
					p.sendMessage("§5§lMOD");
					p.sendMessage("§5§lMOD+");
					p.sendMessage("§c§lGERENTE");
					return true;
				}
				if(cfGrupo.ChecarGrupo(p, "Mod+")){
					p.sendMessage(" ");
					p.sendMessage("§9§lTAGS §fSelecione sua §3§lTAG:");
					p.sendMessage("§7§lNORMAL");
					p.sendMessage("  ");
					p.sendMessage("§3§lTAGS§f de ultilidade §A§LVIP§f:");
					p.sendMessage("§b§lYOUTUBER");
					p.sendMessage("§d§lULTIMATE");
					p.sendMessage("§6§lPREMIUM");
					p.sendMessage("§a§lLIGHT");
					p.sendMessage("  ");
					p.sendMessage("§3§lTAGS§f de ultilidade §e§lSTAFF§f:");
					p.sendMessage("§9§lAJUDANTE");
					p.sendMessage("§5§lTRIAL");
					p.sendMessage("§3§lYOUTUBER+");
					p.sendMessage("§5§lMOD");
					p.sendMessage("§5§lMOD+");
					return true;
				}
				if(cfGrupo.ChecarGrupo(p, "Mod")){
					p.sendMessage(" ");
					p.sendMessage("§9§lTAGS §fSelecione sua §3§lTAG:");
					p.sendMessage("§7§lNORMAL");
					p.sendMessage("  ");
					p.sendMessage("§3§lTAGS§f de ultilidade §A§LVIP§f:");
					p.sendMessage("§b§lYOUTUBER");
					p.sendMessage("§d§lULTIMATE");
					p.sendMessage("§6§lPREMIUM");
					p.sendMessage("§a§lLIGHT");
					p.sendMessage("  ");
					p.sendMessage("§3§lTAGS§f de ultilidade §e§lSTAFF§f:");
					p.sendMessage("§9§lAJUDANTE");
					p.sendMessage("§5§lTRIAL");
					p.sendMessage("§3§lYOUTUBER+");
					p.sendMessage("§5§lMOD");
					return true;
				}
				if(cfGrupo.ChecarGrupo(p, "Trial")){
					p.sendMessage(" ");
					p.sendMessage("§9§lTAGS §fSelecione sua §3§lTAG:");
					p.sendMessage("§7§lNORMAL");
					p.sendMessage("  ");
					p.sendMessage("§3§lTAGS§f de ultilidade §A§LVIP§f:");
					p.sendMessage("§b§lYOUTUBER");
					p.sendMessage("§d§lULTIMATE");
					p.sendMessage("§6§lPREMIUM");
					p.sendMessage("§a§lLIGHT");
					p.sendMessage("  ");
					p.sendMessage("§3§lTAGS§f de ultilidade §e§lSTAFF§f:");
					p.sendMessage("§9§lAJUDANTE");
					p.sendMessage("§5§lTRIAL");
		
					return true;
				}
				if(cfGrupo.ChecarGrupo(p, "Builder")){
					p.sendMessage(" ");
					p.sendMessage("§9§lTAGS §fSelecione sua §3§lTAG:");
					p.sendMessage("§7§lNORMAL");
					p.sendMessage("  ");
					p.sendMessage("§3§lTAGS§f de ultilidade §A§LVIP§f:");
					p.sendMessage("§b§lYOUTUBER");
					p.sendMessage("§d§lULTIMATE");
					p.sendMessage("§6§lPREMIUM");
					p.sendMessage("§a§lLIGHT");
					p.sendMessage("  ");
					p.sendMessage("§3§lTAGS§f de ultilidade §e§lSTAFF§f:");
					p.sendMessage("§e§lBUILDER");
					return true;
				}
				if(cfGrupo.ChecarGrupo(p, "Helper")){
					p.sendMessage(" ");
					p.sendMessage("§9§lTAGS §fSelecione sua §3§lTAG:");
					p.sendMessage("§7§lNORMAL");
					p.sendMessage("  ");
					p.sendMessage("§3§lTAGS§f de ultilidade §A§LVIP§f:");
					p.sendMessage("§9§lAJUDANTE");
					return true;
				}
				if(cfGrupo.ChecarGrupo(p, "Youtuber+")){
					p.sendMessage(" ");
					p.sendMessage("§9§lTAGS §fSelecione sua §3§lTAG:");
					p.sendMessage("§7§lNORMAL");
					p.sendMessage("  ");
					p.sendMessage("§3§lTAGS§f de ultilidade §A§LVIP§f:");
					p.sendMessage("§b§lYOUTUBER");
					p.sendMessage("§d§lULTIMATE");
					p.sendMessage("§6§lPREMIUM");
					p.sendMessage("§a§lLIGHT");
					p.sendMessage("  ");
					p.sendMessage("§3§lTAGS§f de ultilidade §e§lSTAFF§f:");
					p.sendMessage("§3§lYOUTUBER+");
					return true;
				}
				if(cfGrupo.ChecarGrupo(p, "Youtuber")){
					p.sendMessage(" ");
					p.sendMessage("§9§lTAGS §fSelecione sua §3§lTAG:");
					p.sendMessage("§7§lNORMAL");
					p.sendMessage("  ");
					p.sendMessage("§3§lTAGS§f de ultilidade §A§LVIP§f:");
					p.sendMessage("§b§lYOUTUBER");
					p.sendMessage("§d§lULTIMATE");
					p.sendMessage("§6§lPREMIUM");
					p.sendMessage("§a§lLIGHT");
					return true;
				}
				if(cfGrupo.ChecarGrupo(p, "S-Pro")){
					p.sendMessage(" ");
					p.sendMessage("§9§lTAGS §fSelecione sua §3§lTAG:");
					p.sendMessage("§7§lNORMAL");
					p.sendMessage("  ");
					p.sendMessage("§3§lTAGS§f de ultilidade §A§LVIP§f:");
					p.sendMessage("§e§lPLATINUM");
					return true;
				}
				if(cfGrupo.ChecarGrupo(p, "Pro")){
					p.sendMessage(" ");
					p.sendMessage("§9§lTAGS §fSelecione sua §3§lTAG:");
					p.sendMessage("§7§lNORMAL");
					p.sendMessage("  ");
					p.sendMessage("§3§lTAGS§f de ultilidade §A§LVIP§f:");
					p.sendMessage("§d§lULTIMATE");
					p.sendMessage("§6§lPREMIUM");
					p.sendMessage("§a§lLIGHT");
					return true;
				}
				if(cfGrupo.ChecarGrupo(p, "Mvp")){
					p.sendMessage(" ");
					p.sendMessage("§9§lTAGS §fSelecione sua §3§lTAG:");
					p.sendMessage("§7§lNORMAL");
					p.sendMessage("  ");
					p.sendMessage("§3§lTAGS§f de ultilidade §A§LVIP§f:");
					p.sendMessage("§6§lPREMIUM");
					p.sendMessage("§a§lLIGHT");
					return true;
				}
				if(cfGrupo.ChecarGrupo(p, "Light")){
					p.sendMessage(" ");
					p.sendMessage("§9§lTAGS §fSelecione sua §3§lTAG:");
					p.sendMessage("§7§lNORMAL");
					p.sendMessage("  ");
					p.sendMessage("§3§lTAGS§f de ultilidade §A§LVIP§f:");
					p.sendMessage("§a§lLIGHT");
					return true;
				}
				if(cfGrupo.ChecarGrupo(p, "Winner")){
					p.sendMessage("§9§lTAGS §fSelecione sua §3§lTAG:");
					p.sendMessage("§7§lNORMAL");
					p.sendMessage("§3§lTAGS§f de ultilidade §A§LVIP§f:");
					return true;
				}
				
				if(cfGrupo.ChecarGrupo(p, "Membro")){
					p.sendMessage("§9§lTAGS §fSelecione sua §3§lTAG:");
					p.sendMessage("§7§lNORMAL");
					return true;
				}
				return false;
			}
			if(args[0].equalsIgnoreCase("coder")){
				if(cfGrupo.ChecarGrupo(p, "Dono") || cfGrupo.ChecarGrupo(p, "Admin") ||cfGrupo.ChecarGrupo(p, "Admin")){
					p.sendMessage(" ");
					p.sendMessage("§3§lTAG§f Voce esta §3§lULTILIZANDO§f A Tag §3§lCODER");
					p.sendMessage(" ");
					p.setDisplayName("§3§lCODER §3" + p.getName());
					 String prefix = "§3§lCODER §3";
					 NameTagChangeEvento.NametagChangeReason reason = null;
			          reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
			          prefix = NametagUtils.formatColors(prefix);
			          
			          String suffix = " §7(" + sScoreAPI.getRank(p) + "§7)";
			          reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
			          suffix = NametagUtils.formatColors(suffix);
			          
			           Array.SetarNameTagSoft(p.getName(), prefix , suffix, reason);
			           PlayerLoader.update(p.getName(), prefix , suffix);
				}else{
				p.sendMessage("§c§lSPEED§f§lMC §fVoce nao possui esta tag!");
				}
				return true;
			}
			if(args[0].equalsIgnoreCase("winner")){
				if(((cfPermissão.getPermissao(p, "tag.winner")))) {
					p.sendMessage(" ");
					p.sendMessage("§3§lTAG§f Voce esta §3§lULTILIZANDO§f A Tag §2§lWINNER");
					p.sendMessage(" ");
					p.setDisplayName("§2§lWINNER §2" + p.getName());
					 String prefix = "§2§lWINNER §2";
					 NameTagChangeEvento.NametagChangeReason reason = null;
			          reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
			          prefix = NametagUtils.formatColors(prefix);
			          
			          String suffix = " §7(" + sScoreAPI.getRank(p) + "§7)";
			          reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
			          suffix = NametagUtils.formatColors(suffix);
			          
			           Array.SetarNameTagSoft(p.getName(), prefix , suffix, reason);
			           PlayerLoader.update(p.getName(), prefix , suffix);
				}else{
				p.sendMessage("§c§lSPEED§f§lMC §fVoce nao possui esta tag!");
				}
				return true;
			}
			if(args[0].equalsIgnoreCase("builder+")){
				if(((cfPermissão.getPermissao(p, "tag.builder+")))) {
					p.sendMessage(" ");
					p.sendMessage("§3§lTAG§f Voce esta §3§lULTILIZANDO§f A Tag §e§lBUILDER+");
					p.sendMessage(" ");
					p.setDisplayName("§e§lBUILDER+ §e" + p.getName());
					 String prefix = "§e§lBUILDER+ §e";
					 NameTagChangeEvento.NametagChangeReason reason = null;
			          reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
			          prefix = NametagUtils.formatColors(prefix);
			          
			          String suffix = " §7(" + sScoreAPI.getRank(p) + "§7)";
			          reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
			          suffix = NametagUtils.formatColors(suffix);
			          
			           Array.SetarNameTagSoft(p.getName(), prefix , suffix, reason);
			           PlayerLoader.update(p.getName(), prefix , suffix);
				}else{
				p.sendMessage("§cTag inexistente.");
				}
				return true;
			}
			if(args[0].equalsIgnoreCase("dono")){
				if(cfGrupo.ChecarGrupo(p, "Dono")){
					p.sendMessage(" ");
					p.sendMessage("§3§lTAG§f Voce esta §3§lULTILIZANDO§f A Tag §4§lDONO");
					p.sendMessage(" ");
					p.setDisplayName("§4§lDONO §4" + p.getName());
					 String prefix = "§4§lDONO §4";
					 NameTagChangeEvento.NametagChangeReason reason = null;
			          reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
			          prefix = NametagUtils.formatColors(prefix);
			          
			          String suffix = " §7(" + sScoreAPI.getRank(p) + "§7)";
			          reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
			          suffix = NametagUtils.formatColors(suffix);
			          
			           Array.SetarNameTagSoft(p.getName(), prefix , suffix, reason);
			           PlayerLoader.update(p.getName(), prefix , suffix);
				}else{
				p.sendMessage("§c§lSPEED§f§lMC §fVoce nao possui esta tag!");
				}
				return true;
			}
			if(args[0].equalsIgnoreCase("gerente")){
				if(cfGrupo.ChecarGrupo(p, "Dono") || cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Admin")){
					p.sendMessage(" ");
					p.sendMessage("§3§lTAG§f Voce esta §3§lULTILIZANDO§f A Tag §c§lGERENTE");
					p.sendMessage(" ");
					p.setDisplayName("§c§lGERENTE §c" + p.getName());
					 String prefix = "§c§lGERENTE §c";
					 NameTagChangeEvento.NametagChangeReason reason = null;
			          reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
			          prefix = NametagUtils.formatColors(prefix);
			          
			          String suffix = " §7(" + sScoreAPI.getRank(p) + "§7)";
			          reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
			          suffix = NametagUtils.formatColors(suffix);
			          
			           Array.SetarNameTagSoft(p.getName(), prefix , suffix, reason);
			           PlayerLoader.update(p.getName(), prefix , suffix);
				}else{
				p.sendMessage("§c§lSPEED§f§lMC §fVoce nao possui esta tag!");
				}
				return true;
			}
			if(args[0].equalsIgnoreCase("admin")){
				if(cfGrupo.ChecarGrupo(p, "Dono") || cfGrupo.ChecarGrupo(p, "Admin") ||cfGrupo.ChecarGrupo(p, "Admin")){
					p.sendMessage(" ");
					p.sendMessage("§3§lTAG§f Voce esta §3§lULTILIZANDO§f A Tag §c§lADMIN");
					p.sendMessage(" ");
					p.setDisplayName("§c§lADMIN §c" + p.getName());
					 String prefix = "§c§lADMIN §c";
					 NameTagChangeEvento.NametagChangeReason reason = null;
			          reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
			          prefix = NametagUtils.formatColors(prefix);
			          
			          String suffix = " §7(" + sScoreAPI.getRank(p) + "§7)";
			          reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
			          suffix = NametagUtils.formatColors(suffix);
			          
			           Array.SetarNameTagSoft(p.getName(), prefix , suffix, reason);
			           PlayerLoader.update(p.getName(), prefix , suffix);
				}else{
				p.sendMessage("§c§lSPEED§f§lMC §fVoce nao possui esta tag!");
				}
				return true;
			}
			if(args[0].equalsIgnoreCase("modplus")){
				if(cfGrupo.ChecarGrupo(p, "Dono") || cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Mod+")){
					p.sendMessage(" ");
					p.sendMessage("§3§lTAG§f Voce esta §3§lULTILIZANDO§f A Tag §5§lMOD+");
					p.sendMessage(" ");
					p.setDisplayName("§5§lMOD+ §5" + p.getName());
					 String prefix = "§5§lMOD+ §5";
					 NameTagChangeEvento.NametagChangeReason reason = null;
			          reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
			          prefix = NametagUtils.formatColors(prefix);
			          
			          String suffix = " §7(" + sScoreAPI.getRank(p) + "§7)";
			          reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
			          suffix = NametagUtils.formatColors(suffix);
			          
			           Array.SetarNameTagSoft(p.getName(), prefix , suffix, reason);
			           PlayerLoader.update(p.getName(), prefix , suffix);
				}else{
				p.sendMessage("§c§lSPEED§f§lMC §fVoce nao possui esta tag!");
				}
				return true;
			}
			if(args[0].equalsIgnoreCase("mod")){
				if(cfGrupo.ChecarGrupo(p, "Dono") || cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Mod+") || cfGrupo.ChecarGrupo(p, "Mod")){
					p.sendMessage(" ");
					p.sendMessage("§3§lTAG§f Voce esta §3§lULTILIZANDO§f A Tag §5§lMOD");
					p.sendMessage(" ");
					p.setDisplayName("§5§lMOD §5" + p.getName());
					 String prefix = "§5§lMOD §5";
					 NameTagChangeEvento.NametagChangeReason reason = null;
			          reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
			          prefix = NametagUtils.formatColors(prefix);
			          
			          String suffix = " §7("+ sScoreAPI.getRank(p) + "§7)";
			          reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
			          suffix = NametagUtils.formatColors(suffix);
			          
			           Array.SetarNameTagSoft(p.getName(), prefix , suffix, reason);
			           PlayerLoader.update(p.getName(), prefix , suffix);
				}else{
				p.sendMessage("§c§lSPEED§f§lMC §fVoce nao possui esta tag!");
				}
				return true;
			}
			if(args[0].equalsIgnoreCase("trial")){
				if(cfGrupo.ChecarGrupo(p, "Dono") || cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Mod+") || cfGrupo.ChecarGrupo(p, "Mod") || cfGrupo.ChecarGrupo(p, "Trial")){
					p.sendMessage(" ");
					p.sendMessage("§3§lTAG§f Voce esta §3§lULTILIZANDO§f A Tag §5§lTRIAL");
					p.sendMessage(" ");
					p.setDisplayName("§5§lTRIAL §5" + p.getName());
					 String prefix = "§5§lTRIAL §5";
					 NameTagChangeEvento.NametagChangeReason reason = null;
			          reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
			          prefix = NametagUtils.formatColors(prefix);
			          
			          String suffix = " §7(" + sScoreAPI.getRank(p) + "§7)";
			          reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
			          suffix = NametagUtils.formatColors(suffix);
			          
			           Array.SetarNameTagSoft(p.getName(), prefix , suffix, reason);
			           PlayerLoader.update(p.getName(), prefix , suffix);
				}else{
				p.sendMessage("§c§lSPEED§f§lMC §fVoce nao possui esta tag!");
				}
				return true;
			}
			if(args[0].equalsIgnoreCase("builder")){
				if(cfGrupo.ChecarGrupo(p, "Dono") || cfGrupo.ChecarGrupo(p, "Mod+") || cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Builder")){
					p.sendMessage(" ");
					p.sendMessage("§3§lTAG§f Voce esta §3§lULTILIZANDO§f A Tag §e§lBUILDER");
					p.sendMessage(" ");
					p.setDisplayName("§e§lBUILDER §7" + p.getName());
					 String prefix = "§e§lBUILDER §7";
					 NameTagChangeEvento.NametagChangeReason reason = null;
			          reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
			          prefix = NametagUtils.formatColors(prefix);
			          
			          String suffix = " §7(" + sScoreAPI.getRank(p) + "§7)";
			          reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
			          suffix = NametagUtils.formatColors(suffix);
			          
			           Array.SetarNameTagSoft(p.getName(), prefix , suffix, reason);
			           PlayerLoader.update(p.getName(), prefix , suffix);
				}else{
				p.sendMessage("§c§lSPEED§f§lMC §fVoce nao possui esta tag!");
				}
				return true;
			}
			if(args[0].equalsIgnoreCase("ajudante")){
				if(cfGrupo.ChecarGrupo(p, "Dono") || cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Mod+") || cfGrupo.ChecarGrupo(p, "Mod") || cfGrupo.ChecarGrupo(p, "Trial") ||cfGrupo.ChecarGrupo(p, "Helper")){
					p.sendMessage(" ");
					p.sendMessage("§3§lTAG§f Voce esta §3§lULTILIZANDO§f A Tag §9§lAJUDANTE");
					p.sendMessage(" ");
					p.setDisplayName("§9§lAJUDANTE §9" + p.getName());
					 String prefix = "§9§lAJUDANTE §9";
					 NameTagChangeEvento.NametagChangeReason reason = null;
			          reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
			          prefix = NametagUtils.formatColors(prefix);
			          
			          String suffix = " §7(" + sScoreAPI.getRank(p) + "§7)";
			          reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
			          suffix = NametagUtils.formatColors(suffix);
			          
			           Array.SetarNameTagSoft(p.getName(), prefix , suffix, reason);
			           PlayerLoader.update(p.getName(), prefix , suffix);
				}else{
				p.sendMessage("§c§lSPEED§f§lMC §fVoce nao possui esta tag!");
				}
				return true;
			}
			if(args[0].equalsIgnoreCase("youtuber+")){
				if(cfGrupo.ChecarGrupo(p, "Dono") || cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Youtuber+")){
					p.sendMessage(" ");
					p.sendMessage("§3§lTAG§f Voce esta §3§lULTILIZANDO§f A Tag §3§lYOUTUBER+");
					p.sendMessage(" ");
					p.setDisplayName("§3§lYT+ §3" + p.getName());
					 String prefix = "§3§lYT+ §3";
					 NameTagChangeEvento.NametagChangeReason reason = null;
			          reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
			          prefix = NametagUtils.formatColors(prefix);
			          
			          String suffix = " §7(" + sScoreAPI.getRank(p) + "§7)";
			          reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
			          suffix = NametagUtils.formatColors(suffix);
			          
			           Array.SetarNameTagSoft(p.getName(), prefix , suffix, reason);
			           PlayerLoader.update(p.getName(), prefix , suffix);
				}else{
				p.sendMessage("§c§lSPEED§f§lMC §fVoce nao possui esta tag!");
				}
				return true;
			}
			if(args[0].equalsIgnoreCase("exstaff")){
				if(cfPermissão.getPermissao(p, "tag.exstaff")) {
					p.sendMessage(" ");
					p.sendMessage("§3§lTAG§f Voce esta §3§lULTILIZANDO§f A Tag §8§lEX-STAFF");
					p.sendMessage(" ");
					p.setDisplayName("§8§lEX-STAFF §7" + p.getName());
					 String prefix = "§8";
					 NameTagChangeEvento.NametagChangeReason reason = null;
			          reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
			          prefix = NametagUtils.formatColors(prefix);
			          
			          String suffix = " §7(" + sScoreAPI.getRank(p) + "§7)";
			          reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
			          suffix = NametagUtils.formatColors(suffix);
			          
			           Array.SetarNameTagSoft(p.getName(), prefix , suffix, reason);
			           PlayerLoader.update(p.getName(), prefix , suffix);
				}else{
				p.sendMessage("§c§lSPEED§f§lMC §fVoce nao possui esta tag!");
				}
				return true;
			}
			if(args[0].equalsIgnoreCase("youtuber")){
				if(cfGrupo.ChecarGrupo(p, "Dono") || cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Youtuber+") || cfGrupo.ChecarGrupo(p, "Youtuber")){
					p.sendMessage(" ");
					p.sendMessage("§3§lTAG§f Voce esta §3§lULTILIZANDO§f A Tag §b§lYOUTUBER");
					p.sendMessage(" ");
					p.setDisplayName("§b§lYT §b" + p.getName());
					 String prefix = "§b§lYT §b";
					 NameTagChangeEvento.NametagChangeReason reason = null;
			          reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
			          prefix = NametagUtils.formatColors(prefix);
			          
			          String suffix = " §7(" + sScoreAPI.getRank(p) + "§7)";
			          reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
			          suffix = NametagUtils.formatColors(suffix);
			          
			           Array.SetarNameTagSoft(p.getName(), prefix , suffix, reason);
			           PlayerLoader.update(p.getName(), prefix , suffix);
				}else{
				p.sendMessage("§c§lSPEED§f§lMC §fVoce nao possui esta tag!");
				}
				return true;
			}
			if(args[0].equalsIgnoreCase("platinum")){
				if(cfGrupo.ChecarGrupo(p, "Dono") || cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "S-Pro")){
					p.sendMessage(" ");
					p.sendMessage("§3§lTAG§f Voce esta §3§lULTILIZANDO§f A Tag §e§lPLATINUM");
					p.sendMessage(" ");
					p.setDisplayName("§e§lPLATINUM §e" + p.getName());
					 String prefix = "§e§lPLATINUM §e";
					 NameTagChangeEvento.NametagChangeReason reason = null;
			          reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
			          prefix = NametagUtils.formatColors(prefix);
			          
			          String suffix = " §7(" + sScoreAPI.getRank(p) + "§7)";
			          reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
			          suffix = NametagUtils.formatColors(suffix);
			          
			           Array.SetarNameTagSoft(p.getName(), prefix , suffix, reason);
			           PlayerLoader.update(p.getName(), prefix , suffix);
				}else{
				p.sendMessage("§c§lSPEED§f§lMC §fVoce nao possui esta tag!");
				}
				return true;
			}
			if(args[0].equalsIgnoreCase("ultimate")){
				if(cfGrupo.ChecarGrupo(p, "Dono") || cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Builder") || cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Mod+") || cfGrupo.ChecarGrupo(p, "Youtuber+") ||cfGrupo.ChecarGrupo(p, "Youtuber") || cfGrupo.ChecarGrupo(p, "Mod")){
					p.sendMessage(" ");
					p.sendMessage("§3§lTAG§f Voce esta §3§lULTILIZANDO§f A Tag §d§lULTIMATE");
					p.sendMessage(" ");
					p.setDisplayName("§d§lULTIMATE §d" + p.getName());
					 String prefix = "§d§lULTIMATE §d";
					 NameTagChangeEvento.NametagChangeReason reason = null;
			          reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
			          prefix = NametagUtils.formatColors(prefix);
			          
			          String suffix = " §7(" + sScoreAPI.getRank(p) + "§7)";
			          reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
			          suffix = NametagUtils.formatColors(suffix);
			          
			           Array.SetarNameTagSoft(p.getName(), prefix , suffix, reason);
			           PlayerLoader.update(p.getName(), prefix , suffix);
				}else{
				p.sendMessage("§c§lSPEED§f§lMC §fVoce nao possui esta tag!");
				}
				return true;
			}
			if(args[0].equalsIgnoreCase("premium")){
				if(cfGrupo.ChecarGrupo(p, "Dono") || cfGrupo.ChecarGrupo(p, "Builder") || cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Youtuber") || cfGrupo.ChecarGrupo(p, "Youtuber+") || cfGrupo.ChecarGrupo(p, "Helper") || cfGrupo.ChecarGrupo(p, "Trial") || cfGrupo.ChecarGrupo(p, "Mvp") || cfGrupo.ChecarGrupo(p, "Mod+") || cfGrupo.ChecarGrupo(p, "Mod")){
					p.sendMessage(" ");
					p.sendMessage("§3§lTAG§f Voce esta §3§lULTILIZANDO§f A Tag §6§lPREMIUM");
					p.sendMessage(" ");
					p.setDisplayName("§6§lPREMIUM §6" + p.getName());
					 String prefix = "§6§lPREMIUM §6";
					 NameTagChangeEvento.NametagChangeReason reason = null;
			          reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
			          prefix = NametagUtils.formatColors(prefix);
			          
			          String suffix = " §7(" + sScoreAPI.getRank(p) + "§7)";
			          reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
			          suffix = NametagUtils.formatColors(suffix);
			          
			           Array.SetarNameTagSoft(p.getName(), prefix , suffix, reason);
			           PlayerLoader.update(p.getName(), prefix , suffix);
				}else{
				p.sendMessage("§c§lSPEED§f§lMC §fVoce nao possui esta tag!");
				}
				return true;
			}
			if(args[0].equalsIgnoreCase("light")){
				if(cfGrupo.ChecarGrupo(p, "Dono") || cfGrupo.ChecarGrupo(p, "Builder") || cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Light") || cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Mvp") || cfGrupo.ChecarGrupo(p, "Youtuber") || cfGrupo.ChecarGrupo(p, "Youtuber+") || cfGrupo.ChecarGrupo(p, "Mod+") || cfGrupo.ChecarGrupo(p, "Trial") || cfGrupo.ChecarGrupo(p, "Helper") || cfGrupo.ChecarGrupo(p, "Mod")){
					p.sendMessage(" ");
					p.sendMessage("§3§lTAG§f Voce esta §3§lULTILIZANDO§f A Tag §a§lLIGHT");
					p.sendMessage(" ");
					p.setDisplayName("§a§lLIGHT §a" + p.getName());
					 String prefix = "§a§lLIGHT §a";
					 NameTagChangeEvento.NametagChangeReason reason = null;
			          reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
			          prefix = NametagUtils.formatColors(prefix);
			          
			          String suffix = " §7(" + sScoreAPI.getRank(p) + "§7)";
			          reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
			          suffix = NametagUtils.formatColors(suffix);
			          
			           Array.SetarNameTagSoft(p.getName(), prefix , suffix, reason);
			           PlayerLoader.update(p.getName(), prefix , suffix);
				}else{
				p.sendMessage("§c§lSPEED§f§lMC §fVoce nao possui esta tag!");
				}
				return true;
			}
			if(args[0].equalsIgnoreCase("normal")){
				p.sendMessage(" ");
				p.sendMessage("§3§lTAG§f Voce esta §3§lULTILIZANDO§f A Tag §7§lNORMAL");
				p.sendMessage(" ");
				p.setDisplayName("§7§lMEMBRO §7" + p.getName());
				 String prefix = "§7§lMEMBRO §7";
				 NameTagChangeEvento.NametagChangeReason reason = null;
		          reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
		          prefix = NametagUtils.formatColors(prefix);
		          
			      String suffix = " §7(" + sScoreAPI.getRank(p) + "§7)";
		          reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
		          suffix = NametagUtils.formatColors(suffix);
		          
		           Array.SetarNameTagSoft(p.getName(), prefix , suffix , reason);
		           PlayerLoader.update(p.getName(), prefix , suffix);
			}else{
			p.sendMessage("§c§lSPEED§f§lMC §fTag inexitente!");
			}
			return true;
		}
		return false;
	}

}
