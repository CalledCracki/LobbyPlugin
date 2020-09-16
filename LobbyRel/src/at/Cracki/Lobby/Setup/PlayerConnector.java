package at.Cracki.Lobby.Setup;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerConnector implements Listener {
	
	@EventHandler
	public void handlePlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		PlayersInventory.add(player);
	}
	
	@EventHandler
	public void handlePlayerQuit(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		PlayersInventory.remove(player);
	}

}
