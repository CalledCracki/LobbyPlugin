package at.Cracki.Lobby.Commands;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import at.Cracki.Lobby.Listener.Item;
import at.Cracki.Lobby.Main.Lobby;

public class SecretsCMD implements CommandExecutor {
	
	File file = new File("plugins/Lobby", "Config.yml");
	YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		Player player = (Player) sender;
		if(args.length == 0) {
			File cmd = new File("plugins/Lobby", "Secrets.yml");
			YamlConfiguration cfg2 = YamlConfiguration.loadConfiguration(cmd);
			File data = new File("plugins/Lobby", "Users.yml");
			YamlConfiguration cfg3= YamlConfiguration.loadConfiguration(data);	
			List<String> userlist = cfg3.getStringList(player.getName());
			List<String> list = cfg2.getStringList("Secrets");
			Inventory inv = Bukkit.createInventory(null, 54, "§6§lSecrets");
			if(!cfg3.contains(player.getName())) {
				Inventory ninv = Bukkit.createInventory(null, 27, "§6§lSecrets");
				ItemStack nichts = new Item(Material.INK_SACK, 1, (byte) 1).setDisplayName("§cNichts gefunden").
						setLore(Arrays.asList("§7Du hast bisher noch keine Secrets gefunden!")).build();
				ninv.setItem(13, nichts);
				player.openInventory(ninv);
				return false;
			}
			int i = -1;
			for(String all : userlist) {
				i++;
				ItemStack secret = new Item(Material.INK_SACK, 1, (byte) 10).setDisplayName("§a" + all).
						setLore(Arrays.asList("§7Dieses Secret hast du bereits gefunden!")).build();
				inv.setItem(i, secret);
				if(i == 53) {
					break;
				}
			}
			int max = list.size();
			int amount = userlist.size();
			ItemStack amountitem = new Item(Material.NETHER_STAR, 1).setDisplayName("§fDeine gefundenen Secrets:").
					setLore(Arrays.asList("§e" + amount + "§7 von §e" + max + "§7 Secrets.")).build();
			inv.setItem(53, amountitem);
			player.openInventory(inv);
		} else
			player.sendMessage(Lobby.pre + "§cVerwendung: /secrets");
		return false;
	}

}
