package at.Cracki.Lobby.Setup;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class PlayersInventory implements Listener {

	private static Map<Player, ItemStack> contentMap = new HashMap<>();
	
	public static ItemStack[] getContents() {
		return contentMap.values().toArray(new ItemStack[contentMap.size()]);
	}
	
	public static void add(Player player) {
		ItemStack is = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
		SkullMeta meta = (SkullMeta) is.getItemMeta();
		meta.setOwner(player.getName());
		meta.setDisplayName("§a" + player.getName());
		meta.setLore(Arrays.asList("§7Klicken für mehr Informationen."));
		is.setItemMeta(meta);
		contentMap.put(player, is);
	}
	
	public static void remove(Player player) {
		contentMap.remove(player);
	}
	
}
