package at.Cracki.Lobby.Commands;

import java.io.File;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import at.Cracki.Lobby.Main.Lobby;

public class BuildCommand implements CommandExecutor {
	
	File file = new File("plugins/Lobby", "Config.yml");
	YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		Player player = (Player) sender;
		if(player.hasPermission("Lobby.build")) {
			if(args.length == 1) {
				if(args[0].equalsIgnoreCase("an")) {
					if(!(Lobby.build.contains(player))) {
						Lobby.build.add(player);
						player.sendMessage(Lobby.pre + cfg.getString("Lobby.Messages.Build.Aktiviert").replace("&", "§")); 
						player.playSound(player.getLocation(), Sound.LEVEL_UP, 3F, 3F);
					}else if(Lobby.build.contains(player)) {
						player.sendMessage(Lobby.pre + cfg.getString("Lobby.Messages.Build.Fehler1").replace("&", "§"));
						player.playSound(player.getLocation(), Sound.ANVIL_BREAK, 3F, 3F);
					}
				}else if(args[0].equalsIgnoreCase("aus")) {
					if(Lobby.build.contains(player)) {
						Lobby.build.remove(player);
						player.sendMessage(Lobby.pre + cfg.getString("Lobby.Messages.Build.Deaktiviert").replace("&", "§")); 
						player.playSound(player.getLocation(), Sound.LEVEL_UP, 3F, 3F);
					}else if(!(Lobby.build.contains(player))) {
						player.sendMessage(Lobby.pre + "§cDu bist nicht im §6§lBuild-Modus!"); 
						player.playSound(player.getLocation(), Sound.ANVIL_BREAK, 3F, 3F);
					}
				}else
					player.sendMessage(Lobby.pre + "§cVerwendung: /build <an/aus>");
			}else
				player.sendMessage(Lobby.pre + "§cVerwendung: /build <an/aus>");
		}else
			player.sendMessage(Lobby.noperms);
		
		
		return false;
	}

}
