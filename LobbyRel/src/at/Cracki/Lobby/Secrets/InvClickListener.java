package at.Cracki.Lobby.Secrets;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InvClickListener implements Listener {
	
	@EventHandler
	public void onInvClick(InventoryClickEvent event) {
		if(event.getClickedInventory().getTitle().equals("§6§lSecrets")) {
			event.setCancelled(true);
			}
		if(event.getClickedInventory() == null) {
			return;
		}
	}

}
