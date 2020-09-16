package at.Cracki.Lobby.Commands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import at.Cracki.Lobby.Main.Lobby;

public class FlyCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		Player player = (Player) sender;
		if(player.hasPermission("Lobby.fly")) {
			if(args.length == 1) {
				if(args[0].equalsIgnoreCase("an")) {
					if(!(Lobby.fly.contains(player))) {
						Lobby.fly.add(player);
						player.setAllowFlight(true);
						player.sendMessage(Lobby.pre + "§aDu bist nun im §6§lFly-Modus."); 
						player.playSound(player.getLocation(), Sound.LEVEL_UP, 3F, 3F);
					}else if(Lobby.fly.contains(player)) {
						player.sendMessage(Lobby.pre + "§cDu bist bereits im §6§lFly-Modus!"); 
						player.playSound(player.getLocation(), Sound.ANVIL_BREAK, 3F, 3F);
					}
				}else if(args[0].equalsIgnoreCase("aus")) {
					if(Lobby.fly.contains(player)) {
						Lobby.fly.remove(player);
						player.setAllowFlight(false);
						player.sendMessage(Lobby.pre + "§aDu bist nun nicht länger im §6§lFly-Modus."); 
						player.playSound(player.getLocation(), Sound.LEVEL_UP, 3F, 3F);
					}else if(!(Lobby.fly.contains(player))) {
						player.sendMessage(Lobby.pre + "§cDu bist nicht im §6§lFly-Modus!"); 
						player.playSound(player.getLocation(), Sound.ANVIL_BREAK, 3F, 3F);
					}
			}else
				player.sendMessage(Lobby.pre + "§cVerwendung: /fly <an/aus>");
		}else
			player.sendMessage(Lobby.pre + "§cVerwendung: /fly <an/aus>");		
	}else
		player.sendMessage(Lobby.noperms);
		
		return false;
	}

}
