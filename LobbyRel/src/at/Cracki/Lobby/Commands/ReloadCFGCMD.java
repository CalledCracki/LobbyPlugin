package at.Cracki.Lobby.Commands;

import java.io.File;
import java.io.IOException;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import at.Cracki.Lobby.Main.Lobby;
import at.Cracki.Lobby.config.ConfigurationFile;

public class ReloadCFGCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		Player player = (Player) sender;
		if(player.hasPermission("lobby.admin")) {
			File file = new File("plugins/Lobby", "Config.yml");
			YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
			try {
				cfg.save(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			ConfigurationFile file2 = new ConfigurationFile();
			file2.readData();
			file2.setStandard();
			Lobby.getPlugin().saveConfig();
			player.sendMessage(Lobby.pre + "§aConfig.yml wurde erfolgreich neu geladen!");
			player.playSound(player.getLocation(), Sound.FIREWORK_BLAST, 3F, 3F);
		}
		
		return false;
	}

}
