package at.Cracki.Lobby.Commands;

import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import at.Cracki.Lobby.Main.Lobby;

public class GMCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		Player player = (Player) sender;
		if(player.hasPermission("lobby.gamemode")) {
			if(args.length == 1) {
				if(args[0].equalsIgnoreCase("0")) {
					player.setGameMode(GameMode.SURVIVAL);
					player.playSound(player.getLocation(), Sound.LEVEL_UP, 3F, 3F);
					player.sendMessage(Lobby.pre + "§7Du bist nun im §aSurvival Modus!");
				}else if(args[0].equalsIgnoreCase("1")) {
					player.setGameMode(GameMode.CREATIVE);
					player.playSound(player.getLocation(), Sound.LEVEL_UP, 3F, 3F);
					player.sendMessage(Lobby.pre + "§7Du bist nun im §aCreative Modus!");
				}else if(args[0].equalsIgnoreCase("2")) {
					player.setGameMode(GameMode.ADVENTURE);
					player.playSound(player.getLocation(), Sound.LEVEL_UP, 3F, 3F);
					player.sendMessage(Lobby.pre + "§7Du bist nun im §aAdventure Modus!");
				}else if(args[0].equalsIgnoreCase("3")) {
					player.setGameMode(GameMode.SPECTATOR);
					player.playSound(player.getLocation(), Sound.LEVEL_UP, 3F, 3F);
					player.sendMessage(Lobby.pre + "§7Du bist nun im §aSpectator Modus!");
				}
			}else
				player.sendMessage(Lobby.pre + "§cVerwendung: /gm <0/1/2/3>");
		}else
			player.sendMessage(Lobby.noperms);
		
		
		
		return false;
	}

}
