package at.Cracki.Lobby.Listener;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerConnectionListener implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		event.getPlayer().setGameMode(GameMode.ADVENTURE);
	}
	

}
