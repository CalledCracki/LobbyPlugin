package at.Cracki.Lobby.Listener;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class StartInventory implements Listener {
	
	@EventHandler
	public void handlePlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		
		ItemStack kompass = new Item(Material.COMPASS, 1).setDisplayName("§6§lNavigator §7(Rechtsklick)").
				setLore(Arrays.asList("§7§oHiermit kommst du zu allen Spielmodi", "§7§ooder wieder zurück zum Spawn")).build();
		ItemStack hider = new Item(Material.BLAZE_ROD, 1).setDisplayName("§6Spieler verstecken").
				setLore(Arrays.asList("§7§oHiermit kannst du dir alle Spieler anzeigen", "§7§ooder verstecken lassen")).build();
		ItemStack stern = new Item(Material.NETHER_STAR, 1).setDisplayName("§aLobby wechseln").
				setLore(Arrays.asList("§7§oHiermit kannst du deine Lobby wechseln.")).build();
		ItemStack tag = new Item(Material.NAME_TAG, 1).setDisplayName("§cAuto-Nick §7(Rechtsklick)").
				setLore(Arrays.asList("§7§oHiermit kannst du dir einen zufälligen", "§7§oNicknamen geben.", 
						"§cDemnächst verfügbar!")).build();
//		ItemStack tnt = new Item(Material.TNT, 1).setDisplayName("§c§lSilent-Lobby").build();
		ItemStack auge = new Item(Material.EYE_OF_ENDER, 1).setDisplayName("§5Schild aktivieren §7(Rechtsklick)").
				setLore(Arrays.asList("§7§oHiermit kannst du einen Schild aktivieren", "§7§owelcher Spieler von dir fernhält")).build();
		ItemStack admin = new Item(Material.REDSTONE_COMPARATOR, 1).setDisplayName("§cAdmin-Tools").
				setLore(Arrays.asList("§7§oHiermit kannst du die Lobby-Server verwalten.")).build();
		ItemStack extras = new Item(Material.ENDER_CHEST, 1).setDisplayName("§eExtras §7(Rechtsklick)").
				setLore(Arrays.asList("§7§oHiermit kannst du kosmetische Extras auswählen.")).build();
		ItemStack profil = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
		SkullMeta pm = (SkullMeta) profil.getItemMeta();
		pm.setOwner(player.getName());
		pm.setDisplayName("§aDein Profil §7(Rechtsklick)");
		pm.setLore(Arrays.asList("§7§oZeigt dein Profil und Einstellungen an."));
		profil.setItemMeta(pm);
		
		
		if(player.hasPermission("lobby.admin")) {
			player.getInventory().clear();
			player.getInventory().setItem(7, stern);
			player.getInventory().setItem(2, auge);
			player.getInventory().setItem(0, kompass);
			player.getInventory().setItem(6, admin);
			player.getInventory().setItem(1, hider);
			player.getInventory().setItem(2, extras);
			player.getInventory().setItem(8, profil);
		}else if(player.hasPermission("lobby.yter")) {
			player.getInventory().clear();
			player.getInventory().setItem(4, auge);
			player.getInventory().setItem(7, stern);
			player.getInventory().setItem(0, kompass);
			player.getInventory().setItem(2, tag);
			player.getInventory().setItem(1, hider);
			player.getInventory().setItem(6, extras);
			player.getInventory().setItem(8, profil);
		}else {
			player.getInventory().clear();
			player.getInventory().setItem(1, hider);
			player.getInventory().setItem(0, kompass);
			player.getInventory().setItem(4, extras);
			player.getInventory().setItem(7, stern);
			player.getInventory().setItem(8, profil);
		}
	}

}
