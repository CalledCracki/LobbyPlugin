package at.Cracki.Lobby.Setup;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import at.Cracki.Lobby.Commands.SetupCommand;

public class PlayersItemListener implements Listener {
	
	@EventHandler
	public void handlerPlayersItem(InventoryClickEvent event) {
		if(event.getWhoClicked() instanceof Player) {
			Player player = (Player) event.getWhoClicked();
			if(event.getClickedInventory().getTitle().equals(SetupCommand.setupname)) {
				event.setCancelled(true);
				switch(event.getCurrentItem().getType()) {
				case SKULL_ITEM:
					player.closeInventory();
					
					Inventory players = Bukkit.createInventory(null, 9*5, "§6§lSpieler: §fOnline: "
							+ "§a" + Bukkit.getOnlinePlayers().size());
					players.setContents(PlayersInventory.getContents());
					player.openInventory(players);
					
					break;
					
				default:
					break;
				}
			}
		}
	}

}
