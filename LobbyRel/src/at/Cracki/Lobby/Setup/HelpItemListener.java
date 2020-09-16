package at.Cracki.Lobby.Setup;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import at.Cracki.Lobby.Commands.SetupCommand;

public class HelpItemListener implements Listener {
	
	@EventHandler
	public void onInteract(InventoryClickEvent event) {
		if(!(event.getWhoClicked() instanceof Player)) return;
		Player player = (Player) event.getWhoClicked();	
		if(event.getClickedInventory().getTitle().equals(SetupCommand.setupname)) {
			event.setCancelled(true);
			switch(event.getCurrentItem().getType()) {
			case PAPER:
				player.closeInventory();
				player.sendMessage("§7------------------------------------");
				player.sendMessage(" ");
				player.sendMessage("§f» §6§lCommands §f«");
				player.sendMessage(" ");
				player.sendMessage("§f/build <an/aus> §7» §6(De-)aktiviert den Build-Modus.");
				player.sendMessage("§f/gm <0/1/2/3> §7» §6Ändert deinen Gamemode.");
				player.sendMessage("§f/fly <an/aus> §7» §6(De-)aktiviert den Fly-Modus.");
				player.sendMessage("§f/setup §7» §6Öffnet das Setup-Menü.");
				player.sendMessage("§f/setwarp <CB/KO/...> §7» §6Setzt die Spawnpunkte.");
				player.sendMessage("§f/spawn §7» §6Teleportiert dich zum Spawn.");
				player.sendMessage(" ");
				player.sendMessage("§7------------------------------------");
				break;
				
				default:
					break;
			}
		}
	}

}
