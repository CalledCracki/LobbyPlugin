package at.Cracki.Lobby.Listener;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import at.Cracki.Lobby.Main.Lobby;

public class ChatMessages {
	
	public static File file = new File("plugins/Lobby", "Config.yml");
	public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	public static void startMessage1() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Lobby.getPlugin(), new Runnable() {
			
			int countdown = cfg.getInt("Lobby.Messages.AutoChat.1.Seconds");
			
			@Override
			public void run() {
				if(countdown <= 0) {
					for(Player all : Bukkit.getOnlinePlayers()) {
						all.sendMessage("§7------------- " + cfg.getString("Lobby.prefix").replace("&", "§") + "-------------");
						all.sendMessage(" ");
						all.sendMessage(cfg.getString("Lobby.Messages.AutoChat.1").replace("&", "§"));
						all.sendMessage(" ");
						all.sendMessage("§7------------- " + cfg.getString("Lobby.prefix").replace("&", "§") + "-------------");
						countdown = cfg.getInt("Lobby.Messages.AutoChat.1.Seconds");
					}
				}
				countdown--;
			}
		}, 0, 20);
	}
	
	public static void startMessage2() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Lobby.getPlugin(), new Runnable() {
			
			int countdown = cfg.getInt("Lobby.Messages.AutoChat.2.Seconds");
			
			@Override
			public void run() {
				if(countdown <= 0) {
					for(Player all : Bukkit.getOnlinePlayers()) {
						all.sendMessage("§7------------- " + cfg.getString("Lobby.prefix").replace("&", "§") + "-------------");
						all.sendMessage(" ");
						all.sendMessage(cfg.getString("Lobby.Messages.AutoChat.2").replace("&", "§"));
						all.sendMessage(" ");
						all.sendMessage("§7------------- " + cfg.getString("Lobby.prefix").replace("&", "§") + "-------------");
						countdown = cfg.getInt("Lobby.Messages.AutoChat.2.Seconds");
					}
				}
				countdown--;
			}
		}, 0, 20);
	}
}
