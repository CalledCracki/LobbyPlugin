package at.Cracki.Lobby.Secrets;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class SignCreateListener implements Listener {
	
	public static File file = new File("plugins/Lobby", "Config.yml");
	YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	public String prefix = cfg.getString("Lobby.prefix").replace("&", "§");
	
	@EventHandler
	public void onCreateSecretSign(SignChangeEvent event) {
		Player player = event.getPlayer();
		if(player.hasPermission("lobby.admin") && 
				event.getLine(0).equalsIgnoreCase("[secret]")) {
			String CreateSecret = prefix + cfg.getString("Secrets.Messages.SecretErstellt").replace("&", "§");
			CreateSecret = CreateSecret.replace("%SECRET%", event.getLine(1));
			
			SignCreator.createSecret(event.getLine(1));
			player.sendMessage(CreateSecret);
			event.setLine(0, cfg.getString("Secrets.Schild.Zeile1").replace("&", "§"));
			event.setLine(2, cfg.getString("Secrets.Schild.Zeile3").replace("&", "§"));
		}
	}

}
