package at.Cracki.Lobby.Main;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import at.Cracki.Lobby.Commands.BuildCommand;
import at.Cracki.Lobby.Commands.CoinsCMD;
import at.Cracki.Lobby.Commands.DiscordCMD;
import at.Cracki.Lobby.Commands.FlyCommand;
import at.Cracki.Lobby.Commands.GMCommand;
import at.Cracki.Lobby.Commands.ReloadCFGCMD;
import at.Cracki.Lobby.Commands.SecretsCMD;
import at.Cracki.Lobby.Commands.SetWarpCommand;
import at.Cracki.Lobby.Commands.SetupCommand;
import at.Cracki.Lobby.Commands.TSComand;
import at.Cracki.Lobby.Items.LobbyItem;
import at.Cracki.Lobby.Items.Navigator;
//import at.Cracki.Lobby.Items.NickItem;
import at.Cracki.Lobby.Items.PlayerHider;
import at.Cracki.Lobby.Items.Schild;
import at.Cracki.Lobby.Listener.AFKTimer;
//import at.Cracki.Lobby.Commands.HelpCommand;
//import at.Cracki.Lobby.Commands.SetWarpCommand;
//import at.Cracki.Lobby.Commands.SpawnCommand;
import at.Cracki.Lobby.Listener.EventsListener;
import at.Cracki.Lobby.Listener.PlayerConnectionListener;
import at.Cracki.Lobby.Listener.StatusConnectionListener;
import at.Cracki.Lobby.Money.MySQL;
import at.Cracki.Lobby.Money.MySQLFile;
import at.Cracki.Lobby.SB.JoinListener;
import at.Cracki.Lobby.Secrets.InvClickListener;
import at.Cracki.Lobby.Secrets.SignClickListener;
import at.Cracki.Lobby.Secrets.SignCreateListener;
import at.Cracki.Lobby.Setup.HelpItemListener;
import at.Cracki.Lobby.Setup.PlayerConnector;
import at.Cracki.Lobby.Setup.PlayersInventory;
import at.Cracki.Lobby.Setup.PlayersItemListener;
import at.Cracki.Lobby.config.ConfigurationFile;
import at.Cracki.Lobby.config.WarpsConfig;
import at.Cracki.Lobby.Listener.StartInventory;

public class Lobby extends JavaPlugin {
	
	public static ArrayList<Player> build = new ArrayList<>();
	public static ArrayList<Player> fly = new ArrayList<>();
	public static boolean setupisopened = false;
	public static String pre;
	public static final String ver = "v2.5";
	public static String noperms;
	public static Lobby plugin;
	
	@Override
	public void onEnable() {
		plugin = this;
		
		Bukkit.getWorld("world").setPVP(false);
		Bukkit.getWorld("world").setDifficulty(Difficulty.PEACEFUL);
		Bukkit.getWorld("world").setAnimalSpawnLimit(0);
		
		AFKTimer.start();
		Bukkit.getConsoleSender().sendMessage(pre + "§aPlugin wurde geladen!");
		Bukkit.getConsoleSender().sendMessage(pre + "§aLobby System §fby CalledCracki");
		Bukkit.getConsoleSender().sendMessage(pre + "§fVersion: §b" + ver);
		
		MySQLFile file = new MySQLFile();
		file.readData();
		file.setStandard();
		
		ConfigurationFile cfg = new ConfigurationFile();
		cfg.setStandard();
		cfg.readData();
		
		WarpsConfig cfg2 = new WarpsConfig();
		cfg2.setStandard();
		
		MySQL.connect();
		MySQL.createTable();
		
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new EventsListener(), this);
		pm.registerEvents(new HelpItemListener(), this);
		pm.registerEvents(new PlayersItemListener(), this);
		pm.registerEvents(new PlayersInventory(), this);
		pm.registerEvents(new PlayerConnector(), this);
		pm.registerEvents(new StatusConnectionListener(), this);
		pm.registerEvents(new AFKTimer(), this);
		pm.registerEvents(new StartInventory(), this);
		pm.registerEvents(new Navigator(), this);
		pm.registerEvents(new Schild(), this);
		pm.registerEvents(new JoinListener(), this);
		pm.registerEvents(new PlayerConnectionListener(), this);
		pm.registerEvents(new PlayerHider(), this);
		pm.registerEvents(new LobbyItem(), this);
//		pm.registerEvents(new NickItem(), this);
		pm.registerEvents(new InvClickListener(), this);
		pm.registerEvents(new SignClickListener(), this);
		pm.registerEvents(new SignCreateListener(), this);
		
		getCommand("build").setExecutor(new BuildCommand());
		getCommand("fly").setExecutor(new FlyCommand());
		getCommand("gm").setExecutor(new GMCommand());
		getCommand("setup").setExecutor(new SetupCommand());
		getCommand("setwarp").setExecutor(new SetWarpCommand());
//		getCommand("spawn").setExecutor(new SpawnCommand());
		getCommand("discord").setExecutor(new DiscordCMD());
		getCommand("ts").setExecutor(new TSComand());
		getCommand("teamspeak").setExecutor(new TSComand());
		getCommand("Coins").setExecutor(new CoinsCMD());
		getCommand("reloadcfg").setExecutor(new ReloadCFGCMD());
		getCommand("Secrets").setExecutor(new SecretsCMD());
	}
	
	@Override
	public void onDisable() {
		MySQL.disconnect();
		Bukkit.getConsoleSender().sendMessage(pre + "§cPlugin wurde gestoppt!");
	}
	
	public static Lobby getPlugin() {
		return plugin;
	}

}
