package me.thauandev.commands;

import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import me.thauandev.configuração.cfGrupo;

public class SKitCommand
implements Listener, CommandExecutor
{
	  @SuppressWarnings({ "unchecked", "rawtypes" })
	public HashMap<String, ItemStack[]> kit = new HashMap();
	  @SuppressWarnings({ "unchecked", "rawtypes" })
	public HashMap<String, ItemStack[]> armadura = new HashMap();
	  
	  public boolean isInt(String s)
	  {
	    try
	    {
	      Integer.parseInt(s);
	      return true;
	    } catch (NumberFormatException localNumberFormatException) {
	    }
	    return false;
	  }
	
	  @SuppressWarnings({ })
	public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] args){
	    Player p = (Player)sender;
	    if ((cmd.getName().equalsIgnoreCase("skit")) && (
	        ((cfGrupo.ChecarGrupo(p, "Dono") || ((cfGrupo.ChecarGrupo(p, "Gerente") || ((cfGrupo.ChecarGrupo(p, "Admin") || ((cfGrupo.ChecarGrupo(p, "Mod+") || ((cfGrupo.ChecarGrupo(p, "Mod") || ((cfGrupo.ChecarGrupo(p, "Youtuber+"))))))))))))))){
	      if (args.length == 0){
	        p.sendMessage("§c§lSPEED§f§lMC §7Use §c/skit (criar) (aplicar) (nome) (blocos)");
	        return true;
	      }
	      if (args[0].equalsIgnoreCase("criar")){
	        if (args.length == 1){
	          p.sendMessage("§c§lSPEED§f§lMC §fUse §c/skit criar (nome)");
	          return true;
	        }
	        String name = args[1];
	       kit.put(name, p.getInventory().getContents());
	       armadura.put(name, p.getInventory().getArmorContents());
	        p.sendMessage("§c§lSPEED§f§lMC §aO kit " + args[1] + " foi criado com sucesso!");
	        return true;
	      }
	      if (args[0].equalsIgnoreCase("aplicar")){
	        if (args.length <= 2){
	          p.sendMessage("§c§lSPEED§f§lMC §7Use §c/skit aplicar (kit) (blocos)");
	          return true;
	        }
	        String name = args[1];
	        if ((!this.kit.containsKey(name)) && (!this.armadura.containsKey(name))){
	          p.sendMessage("§c§lSPEED§f§lMC §fO kit " + name + " se encontra inexistente no sistema!");
	          return true;
	        }
	        if (isInt(args[2])){
	          int numero = Integer.parseInt(args[2]);
	          for (Entity ent : p.getNearbyEntities(numero, numero, numero)) {
	            if (!(ent instanceof Player))
	              continue;
	            Player plr = (Player)ent;
	            plr.getInventory().setArmorContents((ItemStack[])this.armadura.get(name));
	            plr.getInventory().setContents((ItemStack[])this.kit.get(name));
	          }
	          p.sendMessage("§c§lSPEED§f§lMC §7O kit foi setado §7para os jogadores!");
	          return true;
	        }
	      }
	    }
		return true;
	  }
}