package at.Cracki.Lobby.Commands;

import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import at.Cracki.Lobby.Main.Lobby;

public class DiscordCMD implements CommandExecutor {
	
	public static HashMap<String, Long> cooldown = new HashMap<>();

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		Player player = (Player) sender;
		if(args.length == 0) {
			long jetzt = System.currentTimeMillis();
			
			if(cooldown.containsKey(player.getName())) {
				long be = cooldown.get(player.getName());
				int rest = (int) ((be + (5*1000)) - jetzt);
				
				if(rest > 0) {
					player.sendMessage(Lobby.pre + "§cBitte warte kurz, bevor du diesen Befehl erneut ausführst!");
					return true;
				}
			}
			
			player.sendMessage(Lobby.pre + "§aUnser §fDiscord §aServer: §bdc.craftergang.de");
			cooldown.put(player.getName(), jetzt);
		}
		
		return false;
	}

}
