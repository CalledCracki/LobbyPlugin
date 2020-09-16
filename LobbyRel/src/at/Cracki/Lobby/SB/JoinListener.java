package at.Cracki.Lobby.SB;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import at.Cracki.Lobby.Main.Lobby;

public class JoinListener implements Listener{
	

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		SBListener.setScoreboard(p);
		updateSB(p);
	}
	
	public void updateSB(Player p) {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Lobby.getPlugin(), new Runnable() {
			
			int countdown = 4;
			
			@Override
			public void run() {
				if(countdown <= 0) {
					if(countdown <= 4) {
						SBListener.setScoreboard(p);
					}else if(countdown == 1) {
						countdown = 4;
					}
				}
				countdown--;
			}
		}, 20, 20);
	}
	
}
