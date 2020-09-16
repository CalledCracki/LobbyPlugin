package at.Cracki.Lobby.Listener;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

import at.Cracki.Lobby.Main.Lobby;

public class EventsListener implements Listener {
	
	public ArrayList<Player> build = Lobby.build;
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event) {
		Player player = event.getPlayer();
		if(build.contains(player)) {
			event.setCancelled(false);
		}else if(!build.contains(player)) {
			event.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		Player player = event.getPlayer();
		if(build.contains(player)) {
			event.setCancelled(false);
		}else if(!build.contains(player)) {
			event.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onItemDrop(PlayerDropItemEvent event) {
		Player player = event.getPlayer();
		if(build.contains(player)) {
			event.setCancelled(false);
		}else if(!build.contains(player)) {
			event.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onItemPickup(PlayerPickupItemEvent event) {
		Player player = event.getPlayer();
		if(build.contains(player)) {
			event.setCancelled(false);
		}else if(!build.contains(player)) {
			event.setCancelled(true);
		}
	}
	
	@EventHandler
	public void foodChange(FoodLevelChangeEvent event) {
		event.setCancelled(true);
	}
	
	@EventHandler(priority = EventPriority.MONITOR)
	public void onInvClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		if(build.contains(player)) {
			event.setCancelled(false);
		}else if(!build.contains(player)) {
			event.setCancelled(true);
		}
	}

}
