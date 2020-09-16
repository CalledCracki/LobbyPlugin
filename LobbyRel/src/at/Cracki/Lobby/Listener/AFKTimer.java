package at.Cracki.Lobby.Listener;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitTask;

import at.Cracki.Lobby.Main.Lobby;

public class AFKTimer implements Listener {
  private static ExecutorService executorService = Executors.newSingleThreadExecutor();
  private static HashMap<String, Integer> movingTime = new HashMap<>();
  public static HashMap<Player, String> afk = new HashMap<>();
  public static BukkitTask TaskID;

  
  @EventHandler
  public void onJoin(PlayerJoinEvent event) { movingTime.put(event.getPlayer().getUniqueId().toString(), Integer.valueOf(0)); }

  
  @EventHandler
  public void onQuit(PlayerQuitEvent event) {
    if (movingTime.containsKey(event.getPlayer().getUniqueId().toString()))
      movingTime.remove(event.getPlayer().getUniqueId().toString()); 
  }
  
  @EventHandler
  public void onMove(PlayerMoveEvent event) {
    if(movingTime.containsKey(event.getPlayer().getUniqueId().toString()) && (
      (Integer)movingTime.get(event.getPlayer().getUniqueId().toString())).intValue() != 0) {
      movingTime.put(event.getPlayer().getUniqueId().toString(), Integer.valueOf(0));
      if(StatusConnectionListener.afk.contains(event.getPlayer())) {
    	  StatusConnectionListener.afk.remove(event.getPlayer());
    	  StatusConnectionListener.online.add(event.getPlayer());
    	  event.getPlayer().sendMessage(Lobby.pre + "§aDu bist nun nicht mehr AFK.");
      }
    }
  }
  
  @EventHandler
  public void onChat(AsyncPlayerChatEvent event) {
	  Player player = event.getPlayer();
	    if(movingTime.containsKey(event.getPlayer().getUniqueId().toString()) && (
	    	 (Integer)movingTime.get(event.getPlayer().getUniqueId().toString())).intValue() != 0) {
	    	movingTime.put(event.getPlayer().getUniqueId().toString(), Integer.valueOf(0));
	  if(StatusConnectionListener.afk.contains(player)) {
		  StatusConnectionListener.online.add(player);
		  player.sendMessage(Lobby.pre + "§aDu bist nun nicht mehr AFK.");
	  		}
	    }
  }

  
  public static void start() {
	  executorService.execute(new Runnable()
        {
          public void run() {
        	  TaskID = Bukkit.getScheduler().runTaskTimer(Lobby.getPlugin(), new Runnable() {
                  public void run() {
                    Bukkit.getOnlinePlayers().forEach(target -> {
                          if (!target.hasPermission("Lobby.afk")) {
                            if (movingTime.containsKey(target.getUniqueId().toString())) {
                              movingTime.put(target.getUniqueId().toString(), Integer.valueOf(((Integer)movingTime.get(target.getUniqueId().toString())).intValue() + 1));
                              
                              if (((Integer)movingTime.get(target.getUniqueId().toString())).intValue() >= 90) {
	                            	  if(StatusConnectionListener.online.contains(target)) {
		                            	  StatusConnectionListener.online.remove(target);
		                            	  StatusConnectionListener.afk.add(target);
		                            	  target.sendMessage(Lobby.pre + "§aDu wurdest als AFK markiert!");
		                            	  return;    
                            	  }
                              }
                            } 
                          } else {
                            
                            movingTime.put(target.getUniqueId().toString(), Integer.valueOf(0));
                          } 
                        });
                  }
                }, 20L, 20L);
          }
        });
  }
}