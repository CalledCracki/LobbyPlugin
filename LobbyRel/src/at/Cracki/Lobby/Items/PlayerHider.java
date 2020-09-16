package at.Cracki.Lobby.Items;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import at.Cracki.Lobby.Listener.Item;
import at.Cracki.Lobby.Main.Lobby;

public class PlayerHider implements Listener {
	
	public static ArrayList<Player> ashow = new ArrayList<>();
	public static ArrayList<Player> ashowvip = new ArrayList<>();
	public static ArrayList<Player> ahide = new ArrayList<>();
	public static Inventory hideinv = Bukkit.createInventory(null, 9*1, "§6§lSpieler verstecken");
	
	@EventHandler
	public void openGUI(Player player) {
				ItemStack hide = new Item(Material.INK_SACK, 1, (byte) 8).setDisplayName("§8§lAlle Spieler verstecken §7(Rechtsklick)").build();
				ItemStack show = new Item(Material.INK_SACK, 1, (byte) 10).setDisplayName("§a§lAlle Spieler anzeigen §a(Rechtsklick)").build();
				ItemStack showvip = new Item(Material.INK_SACK, 1, (byte) 5).setDisplayName("§5§lNur VIP's anzeigen §d(Rechtsklick)").
						setLore(Arrays.asList("§cDemnächst verfügbar!")).build();
				ItemStack glas = new Item(Material.STAINED_GLASS_PANE, 1, (byte) 8).setDisplayName(" ").build();
				
				hideinv.setItem(2, show);
				hideinv.setItem(4, hide);
				hideinv.setItem(6, showvip);
				hideinv.setItem(0, glas);
				hideinv.setItem(1, glas);
				hideinv.setItem(3, glas);
				hideinv.setItem(5, glas);
				hideinv.setItem(8, glas);
				hideinv.setItem(7, glas);
				
				
				player.openInventory(hideinv);
			}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		if(event.getPlayer().getItemInHand().getType() != Material.BLAZE_ROD) return;
			if(event.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Spieler verstecken")) {
				if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
					openGUI(event.getPlayer());
				}
			}
		}

	@EventHandler
	public void onInvClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		if(event.getClickedInventory().getTitle().equalsIgnoreCase("§6§lSpieler verstecken")) {
			if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8§lAlle Spieler verstecken §7(Rechtsklick)")) {
				for(Player all : Bukkit.getOnlinePlayers()) {
					player.hidePlayer(all);
					player.sendMessage(Lobby.pre + "§7§lAlle Spieler sind nun unsichtbar.");
					player.playSound(player.getLocation(), Sound.LEVEL_UP, 3F, 3F);
					player.closeInventory();
					
				}
			}else if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lAlle Spieler anzeigen §a(Rechtsklick)")) {
				for(Player all : Bukkit.getOnlinePlayers()) {
					player.showPlayer(all);
					player.sendMessage(Lobby.pre + "§a§lAlle Spieler sind nun sichtbar.");
					player.playSound(player.getLocation(), Sound.LEVEL_UP, 3F, 3F);
					player.closeInventory();
				}
			}else if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§5§lNur VIP's anzeigen §d(Rechtsklick)")) {
				for(Player all : Bukkit.getOnlinePlayers()) {
					if(!all.hasPermission("lobby.hide.bypass")) {
						player.showPlayer(all);
						player.sendMessage(Lobby.pre + "§d§lAlle VIP's sind nun sichtbar.");
						player.playSound(player.getLocation(), Sound.LEVEL_UP, 3F, 3F);
						player.closeInventory();
					
					}
				}
			}
		}
	}
}
