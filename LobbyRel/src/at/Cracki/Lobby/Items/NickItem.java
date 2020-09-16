package at.Cracki.Lobby.Items;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import at.Cracki.Lobby.Main.Lobby;

public class NickItem implements Listener {
	
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		if(event.getItem() == null) return;
			if(event.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cAuto-Nick §7(Rechtsklick)")) {
				if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
					event.getPlayer().sendMessage(Lobby.pre + "§cDas Nickname Feature ist bald verfügbar!");
					return;
					}
				}
		}

}
