package at.Cracki.Lobby.Listener;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.Listener;

public class StatusConnectionListener implements Listener {
	
	public static ArrayList<Player> online = new ArrayList<>();
	public static ArrayList<Player> afk = new ArrayList<>();
	
	@EventHandler
	public void handlePlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		online.add(player);
		
	}
	
	@EventHandler
	public void handlePlayerQuit(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		if(online.contains(player)) {
			online.remove(player);
		}else if(afk.contains(player)) {
			afk.remove(player);
		}
		
	}
}
