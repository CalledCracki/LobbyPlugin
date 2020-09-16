package at.Cracki.Lobby.Items;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import at.Cracki.Lobby.Listener.Item;
import at.Cracki.Lobby.Main.Lobby;

public class LobbyItem implements Listener {
	
	public void openGUI(Player player) {
		Inventory lob = Bukkit.createInventory(null, 9*2, "§fLobby wechseln");
		
		ItemStack l1 = new ItemStack(Material.STAINED_GLASS, 1, (byte) 0);
		ItemMeta l1m = l1.getItemMeta();
		l1m.setDisplayName("§aLobby 1");
		l1m.setLore(Arrays.asList("§b" + Bukkit.getOnlinePlayers().size() + " §fSpieler online"));
		l1m.addEnchant(Enchantment.DAMAGE_ALL, 1, false);
		l1m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		l1m.addItemFlags(ItemFlag.HIDE_DESTROYS);
		l1m.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		l1m.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		l1.setItemMeta(l1m);
		
		ItemStack l2 = new Item(Material.STAINED_GLASS, 1, (byte) 0).setDisplayName("§aLobby 2").
				setLore(Arrays.asList("§cDemnächst verfügbar!")).build();
		
		ItemStack l3 = new Item(Material.STAINED_GLASS, 1, (byte) 0).setDisplayName("§aLobby 3").
				setLore(Arrays.asList("§cDemnächst verfügbar!")).build();
		
		ItemStack lp = new Item(Material.GOLD_BLOCK, 1).setDisplayName("§6Premium Lobby").
				setLore(Arrays.asList("§cDemnächst verfügbar!")).build();
		
		lob.setItem(0, lp);
		lob.setItem(9, l1);
		lob.setItem(10, l2);
		lob.setItem(11, l3);
		player.openInventory(lob);
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		if(event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			try {
				if(event.getPlayer().getItemInHand().getType() != Material.NETHER_STAR) return;
					openGUI(event.getPlayer());
				}catch(Exception e) {
					e.printStackTrace();
				}
			} 
		}
	
	@EventHandler
	public void handleNavClick(InventoryClickEvent event) {
		if(!(event.getWhoClicked() instanceof Player)) return;
			Player player = (Player) event.getWhoClicked();
			if(event.getInventory().getTitle().equalsIgnoreCase("§fLobby wechseln")) {
					if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aLobby 1")) {
						player.sendMessage(Lobby.pre + "§cDu bist bereits auf dieser Lobby!");
						player.closeInventory();
						return;
					}else if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aLobby 2")) {
						player.sendMessage(Lobby.pre + "§cDiese Lobby ist demnächst verfügbar!");
						player.closeInventory();
						return;
					}else if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aLobby 3")) {
						player.sendMessage(Lobby.pre + "§cDiese Lobby ist demnächst verfügbar!");
						player.closeInventory();
						return;
					}else if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Premium Lobby")) {
						player.sendMessage(Lobby.pre + "§cDiese Lobby ist demnächst verfügbar!");
						player.closeInventory();
						return;
					}
			}
	}
}
