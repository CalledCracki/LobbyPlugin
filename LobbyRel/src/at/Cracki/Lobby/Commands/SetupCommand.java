package at.Cracki.Lobby.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import at.Cracki.Lobby.Listener.Item;
import at.Cracki.Lobby.Main.Lobby;

public class SetupCommand implements CommandExecutor {
	
	public static String setupname = "§e§lLobby-Setup";
	public int TaskID;

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		Player player = (Player) sender;
		if(player.hasPermission("lobby.admin")) {
			if(Lobby.setupisopened == false) {
				if(args.length == 0) {
					Inventory setup = Bukkit.createInventory(null, 9*1, setupname);
					
					ItemStack help = new Item(Material.PAPER, 1).setDisplayName("§fHilfe anzeigen").build();
					ItemStack players = new Item(Material.SKULL_ITEM, 1, (short) 3)
														.setDisplayName("§fSpieler anzeigen").build();
					ItemStack progress = new Item(Material.REDSTONE_COMPARATOR, 1)
												.setDisplayName("§fFortschritt anzeigen").build();
					
					Lobby.setupisopened = true;
					player.openInventory(setup);
					
					TaskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Lobby.getPlugin(), new Runnable() {
						
						int countdown = 3;
						
						@Override
						public void run() {
							if(countdown == 2) {
								player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 3F, 3F);
								setup.setItem(1, help);
							}else if(countdown == 1) {
								player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 3F, 3F);
								setup.setItem(4, players);
							}else if(countdown == 0) {
								player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 3F, 3F);
								setup.setItem(7, progress);
								Bukkit.getScheduler().cancelTask(TaskID);
								Lobby.setupisopened = false;
								return;
							}
							countdown--;
						}
					}, 0, 20);
					
					player.openInventory(setup);
				}else
					player.sendMessage(Lobby.pre + "§cVerwendung: /setup");
			}else
				player.sendMessage(Lobby.pre + "§cBitte warte einen Moment...");
		}else
			player.sendMessage(Lobby.noperms);
		
		
		
		return false;
	}

}
