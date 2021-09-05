package me.thauandev.main;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import me.thauandev.anticheat.hacks.AutoSoup;
import me.thauandev.anticheat.hacks.FastClick;
import me.thauandev.anticheat.hacks.ForceField;
import me.thauandev.anticheat.hacks.Macro;
import me.thauandev.anticheat.hacks.flyspeed.FlySpeed;
import me.thauandev.anticheat.hacks.flyspeed.MoveCheck;
import me.thauandev.authme.Block;
import me.thauandev.authme.Logar;
import me.thauandev.authme.Login;
import me.thauandev.authme.Mudar;
import me.thauandev.authme.Register;
import me.thauandev.API.API;
import me.thauandev.API.GrupoAPI;
import me.thauandev.API.WarpsAPI;
import me.thauandev.bans.Eventos;
import me.thauandev.bans.PunishCheckCommand;
import me.thauandev.bans.WarnCommand;
import me.thauandev.bans.BanCommand;
import me.thauandev.bans.Config;
import me.thauandev.bans.IPBanCommand;
import me.thauandev.bans.KickCommand;
import me.thauandev.bans.MuteCommand;
import me.thauandev.bans.PardonCommand;
import me.thauandev.bans.TempBanCommand;
import me.thauandev.bans.TempMuteCommand;
import me.thauandev.combatlog.CombatLog;
import me.thauandev.commands.AccountCommand;
import me.thauandev.commands.AddPermissaoCommand;
import me.thauandev.commands.AdminCommand;
import me.thauandev.commands.AplicarCommand;
import me.thauandev.commands.AutoSoupCommand;
import me.thauandev.commands.BcCommand;
import me.thauandev.commands.BuilderCommand;
import me.thauandev.commands.CageCommand;
import me.thauandev.commands.ChatCommand;
import me.thauandev.commands.ClearAllCommand;
import me.thauandev.commands.DanoCommand;
import me.thauandev.commands.DicaCommand;
import me.thauandev.commands.FakeCommand;
import me.thauandev.commands.FlyCommand;
import me.thauandev.commands.GamemodeCommand;
import me.thauandev.commands.GetIPCommand;
import me.thauandev.commands.GiveCommand;
import me.thauandev.commands.GiveKitCommand;
import me.thauandev.commands.GiveVipCommand;
import me.thauandev.commands.GroupSetCommand;
import me.thauandev.commands.HeadCommand;
import me.thauandev.commands.HelpopCommand;
import me.thauandev.commands.HgCommand;
import me.thauandev.commands.HorasCommand;
import me.thauandev.commands.InvisCommand;
import me.thauandev.commands.InvseeCommand;
import me.thauandev.commands.IpCommand;
import me.thauandev.commands.KickAllCommand;
import me.thauandev.commands.KillsCommand;
import me.thauandev.commands.KitCommand;
import me.thauandev.commands.LigaCommand;
import me.thauandev.commands.LojaCommand;
import me.thauandev.commands.GiveAllCommand;
import me.thauandev.commands.ManutencaoCommand;
import me.thauandev.commands.MoneyCommand;
import me.thauandev.commands.MonitorarCommand;
import me.thauandev.commands.PerfilCommand;
import me.thauandev.commands.PingCommand;
import me.thauandev.commands.PvPCommand;
import me.thauandev.commands.RankCommand;
import me.thauandev.commands.RegrasCommand;
import me.thauandev.commands.cRemoveHead;
import me.thauandev.commands.ReportCommand;
import me.thauandev.commands.RemoveAllCommand;
import me.thauandev.commands.ScCommand;
import me.thauandev.commands.ScoreCommand;
import me.thauandev.commands.SetArenaCommand;
import me.thauandev.commands.SetCommand;
import me.thauandev.commands.SpawnCommand;
import me.thauandev.commands.SpecCommand;
import me.thauandev.commands.StatusCommand;
import me.thauandev.commands.StopServerCommand;
import me.thauandev.commands.TellCommand;
import me.thauandev.commands.TagCommand;
import me.thauandev.commands.TpCommand;
import me.thauandev.commands.TpAllCommand;
import me.thauandev.commands.TpHereCommand;
import me.thauandev.commands.VisCommand;
import me.thauandev.commands.WarpCommand;
import me.thauandev.commands.YoutuberCommand;
import me.thauandev.commands.SKitCommand;
import me.thauandev.configuração.WarpsConfig;
import me.thauandev.configuração.cfConfig;
import me.thauandev.configuração.cfEntrou;
import me.thauandev.configuração.cfGrupo;
import me.thauandev.configuração.cfKitdiario;
import me.thauandev.configuração.cfPermissão;
import me.thauandev.configuração.cfStatus;
import me.thauandev.configuração.cfTempGrupo;
import me.thauandev.events.ColorSigns;
import me.thauandev.events.PlacaCHALLENGE;
import me.thauandev.events.PlacaRecraft;
import me.thauandev.events.PlacaSopas;
import me.thauandev.events.PlacaVIP;
import me.thauandev.events.eEvents;
import me.thauandev.events.eMoveSpawn;
import me.thauandev.events.eTab;
import me.thauandev.events.eUtills;
import me.thauandev.habilidades.Ajnin;
import me.thauandev.habilidades.Anchor;
import me.thauandev.habilidades.AntiTower;
import me.thauandev.habilidades.FireLauncher;
import me.thauandev.habilidades.Fisherman;
import me.thauandev.habilidades.Gladiator;
import me.thauandev.habilidades.Grappler;
import me.thauandev.habilidades.Hulk;
import me.thauandev.habilidades.Kangaroo;
import me.thauandev.habilidades.Magma;
import me.thauandev.habilidades.MiniGun;
import me.thauandev.habilidades.Monk;
import me.thauandev.habilidades.Ninja;
import me.thauandev.habilidades.Phantom;
import me.thauandev.habilidades.Snail;
import me.thauandev.habilidades.Specialist;
import me.thauandev.habilidades.Stomper;
import me.thauandev.habilidades.Strong;
import me.thauandev.habilidades.Sumo;
import me.thauandev.habilidades.Switcher;
import me.thauandev.habilidades.Thor;
import me.thauandev.habilidades.Timelord;
import me.thauandev.habilidades.Turtle;
import me.thauandev.habilidades.Viper;
import me.thauandev.invencivel.Proteção;
import me.thauandev.jumps.Diamante;
import me.thauandev.jumps.EndPortal;
import me.thauandev.jumps.Esponja;
import me.thauandev.jumps.Ferro;
import me.thauandev.menus.CliqueInventory;
import me.thauandev.menus.HeadsMenu;
import me.thauandev.menus.LojaItemMenu;
import me.thauandev.menus.OpenInventory;
import me.thauandev.nametag.Array;
import me.thauandev.nametag.PlayerLoader;
import me.thauandev.packets.Cancellable;
import me.thauandev.packets.Injector;
import me.thauandev.packets.PacketHandler;
import me.thauandev.packets.PacketReceiveEvent;
import me.thauandev.packets.PacketSendEvent;
import me.thauandev.packets.ReceivedPacket;
import me.thauandev.packets.SentPacket;
import me.thauandev.skin.ChangeSkinCommand;
import me.thauandev.umVum.CmdsSpeed;
import me.thauandev.umVum.Events1v1;
import me.thauandev.umVum.Speed1v1;

@SuppressWarnings("deprecation")
public class Main extends JavaPlugin{
	
	public static final String Menssagens = null;

	public static Main main;
	public static Main getInstance() {
		return main;
	}
	
	public static Plugin plugin;
	public static Plugin getPlugin(){
		return plugin;
	}
	
	public static Injector injector;
	public static boolean disableEvents = false;
	public static BukkitRunnable cleanupTask;
	
	public static ArrayList<String> JogadoresLogados = new ArrayList<>();

	public static ArrayList<String> login = new ArrayList<>();
	
	public void onEnable(){
		plugin = this;
		Bukkit.getConsoleSender().sendMessage("§b§l§m-------------------------------------");
		Bukkit.getConsoleSender().sendMessage("                                     ");
		Bukkit.getConsoleSender().sendMessage("          §c§lSPEED§f§lMC        ");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("                                         ");
		Bukkit.getConsoleSender().sendMessage("§3§lPLUGIN §fO Plugin registrou o Evento §4§lKILL");
		Bukkit.getConsoleSender().sendMessage("§3§lPLUGIN §fO Plugin registrou o Evento §4§lDEATH");
		Bukkit.getConsoleSender().sendMessage("§3§lPLUGIN §fO Plugin registrou o Evento §4§lSELECT KIT");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("§3§lPLUGIN §fO Plugin registrou com §a§lSUCESSO §fTodos os eventos!");
		Bukkit.getConsoleSender().sendMessage("                                             ");
		Bukkit.getConsoleSender().sendMessage("§b§l§m---------------------------------------------");
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new MoveCheck(), 41L, 40L);
		for(Player todos : Bukkit.getOnlinePlayers()){
			todos.kickPlayer("   §c§lSERVIDOR REINICIANDO... \n§7Aguarde! \n§7Estamos melhorando a sua jogabilidade, espero que entenda!");
		}
		

		
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
			public void run() {
				API.AutomaticMessage();
			}
		}, 0L, 120 * 20);
		
		LoadConfig();
		GrupoAPI.Checando = true;
		for (OfflinePlayer jogadores : getServer().getOfflinePlayers()) {
			if (Config.getConfig().kTempBans.get("TempBans." + jogadores.getUniqueId()) != null) {
				Config.getConfig().kTempBans.set("TempBans." + jogadores.getUniqueId(), null);
				Config.getConfig().saveTempBans();	
			}
			if (Config.getConfig().kTempMute.get("TempMute." + jogadores.getUniqueId()) != null) {
				Config.getConfig().kTempMute.set("TempMute." + jogadores.getUniqueId(), null);
				Config.getConfig().saveTempMute();	
			}
	}
		
			
		
		PacketsIniciar();
		PlayerLoader.load(this);
		Array.InciarTag();
		LoadEvents();
		testandoauth();
		LoadCommands();
		DanoCommand.dano = true;
		PvPCommand.pvp = true;
	}

	public void onDisable(){
		PacketsDesabilitar();
		Bukkit.getConsoleSender().sendMessage("§b§l§m-------------------------------------");
		Bukkit.getConsoleSender().sendMessage("                                     ");
		Bukkit.getConsoleSender().sendMessage("          §c§lSPEED§f§lMC        ");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("                                         ");
		Bukkit.getConsoleSender().sendMessage("§3§lPLUGIN §fO Plugin desregistrou o Evento §4§lKILL");
		Bukkit.getConsoleSender().sendMessage("§3§lPLUGIN §fO Plugin desregistrou o Evento §4§lDEATH");
		Bukkit.getConsoleSender().sendMessage("§3§lPLUGIN §fO Plugin desregistrou o Evento §4§lSELECT KIT");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("§3§lPLUGIN §fO Plugin Desregistrou com §a§lSUCESSO §fTodos os eventos!");
		Bukkit.getConsoleSender().sendMessage("                                             ");
		Bukkit.getConsoleSender().sendMessage("§b§l§m---------------------------------------------");
		
	}
	
	public void onLoad() {
		
		injector = new Injector();
		boolean injected = injector.inject();
		if (injected) {
			injector.addServerConnectionChannel();
		} else {
		}
	}
	
	private void LoadEvents(){
		
		PluginManager pm = getServer().getPluginManager();
		
		pm.registerEvents(new Eventos(), this);
		pm.registerEvents(new eEvents(), this);
		pm.registerEvents(new eUtills(), this);
		pm.registerEvents(new Proteção(), this);
		pm.registerEvents(new OpenInventory(), this);
		pm.registerEvents(new CliqueInventory(), this);
		pm.registerEvents(new HeadsMenu(), this);
		pm.registerEvents(new WarpsAPI(), this);
		pm.registerEvents(new PlacaRecraft(), this);
		pm.registerEvents(new PlacaSopas(), this);
		pm.registerEvents(new PlacaCHALLENGE(), this);
		pm.registerEvents(new eMoveSpawn(), this);
		pm.registerEvents(new eTab(), this);
		pm.registerEvents(new LojaItemMenu(), this);
		pm.registerEvents(new ColorSigns(), this);
		pm.registerEvents(new PlacaVIP(), this);
		
		pm.registerEvents(new AdminCommand(), this);
		pm.registerEvents(new ChatCommand(), this);
		pm.registerEvents(new ScCommand(), this);
		pm.registerEvents(new ManutencaoCommand(), this);
		pm.registerEvents(new DanoCommand(), this);
		pm.registerEvents(new PvPCommand(), this);
		
		pm.registerEvents(new EndPortal(), this);
		pm.registerEvents(new Esponja(), this);
		pm.registerEvents(new Diamante(), this);
		pm.registerEvents(new Ferro(), this);
		
		pm.registerEvents(new Ajnin(), this);
		pm.registerEvents(new AntiTower(), this);
		pm.registerEvents(new Anchor(), this);
		pm.registerEvents(new Fisherman(), this);
		pm.registerEvents(new MiniGun(), this);
		pm.registerEvents(new Gladiator(), this);
		pm.registerEvents(new Grappler(), this);
		pm.registerEvents(new Turtle(), this);
		pm.registerEvents(new Hulk(), this);
		pm.registerEvents(new Kangaroo(), this);
		pm.registerEvents(new Magma(), this);
		pm.registerEvents(new Monk(), this);
		pm.registerEvents(new Ninja(), this);
		pm.registerEvents(new Phantom(), this);
		pm.registerEvents(new Specialist(), this);
		pm.registerEvents(new Snail(), this);
		pm.registerEvents(new Stomper(), this);
		pm.registerEvents(new Switcher(), this);
		pm.registerEvents(new Thor(), this);
		pm.registerEvents(new Timelord(), this);
		pm.registerEvents(new Viper(), this);
		pm.registerEvents(new FireLauncher(), this);
		pm.registerEvents(new Strong(), this);
		pm.registerEvents(new Sumo(), this);
		
		pm.registerEvents(new Events1v1(), this);
		pm.registerEvents(new Speed1v1(), this);
		pm.registerEvents(new me.thauandev.anticheat.Events(), this);
		pm.registerEvents(new AutoSoup(), this);
		pm.registerEvents(new FastClick(), this);
		pm.registerEvents(new Macro(), this);
		pm.registerEvents(new ForceField(), this);
		pm.registerEvents(new FlySpeed(), this);
		pm.registerEvents(new CombatLog(), this);
		pm.registerEvents(new WarpCommand(), this);
		
	}

	void testandoauth() {
		Bukkit.getPluginManager().registerEvents(new Block(), this);
		Bukkit.getPluginManager().registerEvents(new Login(), this);
		getCommand("register").setExecutor(new Register());
		getCommand("login").setExecutor(new Logar());
		getCommand("mudarsenha").setExecutor(new Mudar());
		
	}
	
	private void LoadCommands(){
		
		
		getCommand("ban").setExecutor(new BanCommand());
		getCommand("helpop").setExecutor(new HelpopCommand());
		getCommand("ipban").setExecutor(new IPBanCommand());
		getCommand("tempban").setExecutor(new TempBanCommand());
		getCommand("tempmute").setExecutor(new TempMuteCommand());
		getCommand("kick").setExecutor(new KickCommand());
		getCommand("Pardon").setExecutor(new PardonCommand());
		getCommand("mute").setExecutor(new MuteCommand());
		getCommand("sc").setExecutor(new ScCommand());
		getCommand("setgroup").setExecutor(new GroupSetCommand());
		getCommand("admin").setExecutor(new AdminCommand());
		getCommand("kit").setExecutor(new KitCommand());
		getCommand("builder").setExecutor(new BuilderCommand());
		getCommand("aviso").setExecutor(new WarnCommand());
		getCommand("giveall").setExecutor(new GiveAllCommand());
		getCommand("removeall").setExecutor(new RemoveAllCommand());
		getCommand("fly").setExecutor(new FlyCommand());
		getCommand("score").setExecutor(new ScoreCommand());
		getCommand("regras").setExecutor(new RegrasCommand());
		getCommand("tag").setExecutor(new TagCommand());
		getCommand("perfil").setExecutor(new PerfilCommand());
		getCommand("tp").setExecutor(new TpCommand());
		getCommand("gamemode").setExecutor(new GamemodeCommand());
		getCommand("gm").setExecutor(new GamemodeCommand());
		getCommand("youtuber").setExecutor(new YoutuberCommand());
		getCommand("chat").setExecutor(new ChatCommand());
		getCommand("dica").setExecutor(new DicaCommand());
		getCommand("report").setExecutor(new ReportCommand());
		getCommand("set").setExecutor(new SetCommand());
		getCommand("spawn").setExecutor(new SpawnCommand());
		getCommand("warp").setExecutor(new WarpCommand());
		getCommand("setarena").setExecutor(new SetArenaCommand());
		getCommand("speed1v1").setExecutor(new CmdsSpeed());
		getCommand("tell").setExecutor(new TellCommand());
		getCommand("specs").setExecutor(new SpecCommand());
		getCommand("bancheck").setExecutor(new PunishCheckCommand());
		getCommand("mutecheck").setExecutor(new PunishCheckCommand());
		getCommand("loja").setExecutor(new LojaCommand());
		getCommand("store").setExecutor(new LojaCommand());
		getCommand("bc").setExecutor(new BcCommand());
		getCommand("account").setExecutor(new AccountCommand());
		getCommand("inv").setExecutor(new InvseeCommand());
		getCommand("invsee").setExecutor(new InvseeCommand());
		getCommand("aplicar").setExecutor(new AplicarCommand());
		getCommand("changeskin").setExecutor(new ChangeSkinCommand());
		getCommand("getip").setExecutor(new GetIPCommand());
		getCommand("horas").setExecutor(new HorasCommand());
		getCommand("rank").setExecutor(new RankCommand());
		getCommand("liga").setExecutor(new LigaCommand());
		getCommand("ranks").setExecutor(new RankCommand());
		getCommand("fake").setExecutor(new FakeCommand());
		getCommand("ping").setExecutor(new PingCommand());
		getCommand("acc").setExecutor(new AccountCommand());
		getCommand("tpall").setExecutor(new TpAllCommand());
		getCommand("vis").setExecutor(new VisCommand());
		getCommand("invis").setExecutor(new InvisCommand());
		getCommand("hg").setExecutor(new HgCommand());
		getCommand("removerhead").setExecutor(new cRemoveHead());
		getCommand("removerhat").setExecutor(new cRemoveHead());
		getCommand("removehead").setExecutor(new cRemoveHead());
		getCommand("manutencao").setExecutor(new ManutencaoCommand());
		getCommand("cage").setExecutor(new CageCommand());
		getCommand("autosoup").setExecutor(new AutoSoupCommand());
		getCommand("ip").setExecutor(new IpCommand());
		getCommand("tphere").setExecutor(new TpHereCommand());
		getCommand("s").setExecutor(new TpHereCommand());
		getCommand("stopserver").setExecutor(new StopServerCommand());
		getCommand("kickall").setExecutor(new KickAllCommand());
		getCommand("monitorar").setExecutor(new MonitorarCommand());
		getCommand("skit").setExecutor(new SKitCommand());
		getCommand("status").setExecutor(new StatusCommand());
		getCommand("stats").setExecutor(new StatusCommand());
		getCommand("kills").setExecutor(new KillsCommand());
		getCommand("money").setExecutor(new MoneyCommand());
		getCommand("dano").setExecutor(new DanoCommand());
		getCommand("pvp").setExecutor(new PvPCommand());
		getCommand("clearall").setExecutor(new ClearAllCommand());
		getCommand("head").setExecutor(new HeadCommand());
		getCommand("addpermission").setExecutor(new AddPermissaoCommand());
		getCommand("removepermission").setExecutor(new AddPermissaoCommand());
		getCommand("givevip").setExecutor(new GiveVipCommand());
		getCommand("giveyoutuber").setExecutor(new GiveCommand());
		getCommand("givebuilder").setExecutor(new GiveCommand());
		getCommand("givekit").setExecutor(new GiveKitCommand());
		
	}
	
	private void LoadConfig(){
		
		WarpsConfig.getConfig().ConfigEnable(this);
		Config.getConfig().setupConfig(this);
		cfEntrou.setarConfig(this);
		cfEntrou.setarConfig1(this);
		cfGrupo.setarconfig(this);
		cfKitdiario.setarconfig(this);
		cfTempGrupo.setarconfig(this);
		cfPermissão.setarconfig(this);
		cfConfig.setarConfig(this);
		new cfStatus();
		new WarnCommand();
	}
	
	 public static void PacketsIniciar(){
		 
		 if (cleanupTask == null) { (cleanupTask = new BukkitRunnable() {
			 @Override
			 public void run() {
				 // System.out.println("[PacketListenerAPI] Running cleanup task...");
				 int handlers = PacketHandler.getHandlers().size();
				 int plugins = Bukkit.getPluginManager().getPlugins().length;
				 if (handlers > plugins) {
				 }
			 }
		 }).runTaskTimer(getPlugin(), 20 * 300, 20 * 300);
		 }
	 }
	 
	 public static void PacketsDesabilitar(){

		 for (Player p : Bukkit.getOnlinePlayers()) {
			injector.removeChannel(p);
		 }
		 
		 while (!PacketHandler.getHandlers().isEmpty()) {
			 PacketHandler.removeHandler(PacketHandler.getHandlers().get(0));
		 }
	 }
	 
	 public static boolean addPacketHandler(PacketHandler handler) {
		 return PacketHandler.addHandler(handler);
	 }

	 public static boolean removePacketHandler(PacketHandler handler) {
		 return PacketHandler.removeHandler(handler);
	 }

	 private void callEvent(final Event e) {
		 
		 if (disableEvents) return;
		 if (!this.isEnabled()) return;
		 Bukkit.getScheduler().runTaskAsynchronously(this, new Runnable() {

			 @Override
			 public void run() {
				 try {
					 Bukkit.getPluginManager().callEvent(e);
				 } catch (IllegalStateException ex) {
					 System.out.println("[PacketListenerAPI] Error while calling event (" + e.getEventName() + ")");
					 ex.printStackTrace();
				 }
			 }
		 });
	 }

	 public Object onPacketReceive(Player p, Object packet, Cancellable cancellable) {
		 if (!packet.getClass().getName().startsWith("net.minecraft.server.")) return packet;
		 if (!disableEvents) {
			 PacketReceiveEvent event = new PacketReceiveEvent(packet, cancellable, p);
			 this.callEvent(event);
		 }

		 ReceivedPacket pckt = new ReceivedPacket(packet, cancellable, p);
		 PacketHandler.notifyHandlers(pckt);
		 return pckt.getPacket();
	 }

	 public Object onPacketSend(Player p, Object packet, Cancellable cancellable) {
		 if (!packet.getClass().getName().startsWith("net.minecraft.server.")) return packet;
		 if (!disableEvents) {
			 PacketSendEvent event = new PacketSendEvent(packet, cancellable, p);
			 this.callEvent(event);
		 }

		 SentPacket pckt = new SentPacket(packet, cancellable, p);
		 PacketHandler.notifyHandlers(pckt);
		 return pckt.getPacket();
	 }
}