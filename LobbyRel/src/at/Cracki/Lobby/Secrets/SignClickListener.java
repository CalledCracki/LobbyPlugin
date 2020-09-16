package at.Cracki.Lobby.Secrets;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.block.Sign;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class SignClickListener implements Listener {
	
	File file = new File("plugins/Lobby", "Config.yml");
	YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	public String prefix = cfg.getString("Lobby.prefix").replace("&", "§");
	
	@EventHandler
	public void handleInteractEvent(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		File CMD = new File("plugins/Lobby", "Secrets.yml");
		YamlConfiguration cfg2 = YamlConfiguration.loadConfiguration(CMD);
		File Data = new File("plugins/Lobby", "Users.yml");
		YamlConfiguration cfg3 = YamlConfiguration.loadConfiguration(Data);
		if(event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getClickedBlock().getState() instanceof Sign) {
			Sign s = (Sign) event.getClickedBlock().getState();
			String L1 = cfg.getString("Secrets.Schild.Zeile1").replace("&", "§");
			if(s.getLine(0).equalsIgnoreCase(L1)) {
				String Secretname = s.getLine(1);
				List<String> list = cfg2.getStringList("Secrets");
				if(list.contains(Secretname)) {
					if(!Data.exists()) {
						cfg3.set("active", Boolean.valueOf(true));
					}try {
						cfg3.save(Data);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				if(!cfg3.contains(player.getName())) {
					cfg3.set(player.getName(), "value");
					List<String> userlist = cfg3.getStringList(player.getName());
					String SecretGefunden = prefix + cfg.getString("Secrets.Messages.SecretGefunden").replace("%SECRET%", Secretname);
					SecretGefunden = SecretGefunden.replace("&", "§");
					String GefundenCMD = cfg.getString("Secrets.Settings.Command").replace("%PLAYER%", player.getName());
					
					Bukkit.dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), GefundenCMD);
					player.sendMessage(SecretGefunden);
					player.playSound(player.getLocation(), Sound.LEVEL_UP, 3F, 3F);
					userlist.add(Secretname);
					cfg3.set(player.getName(), userlist);
					try {
						cfg3.save(Data);
					} catch(IOException e1) {
						e1.printStackTrace();
					}
				}else {
					List<String> userlist = cfg3.getStringList(player.getName());
					if(userlist.contains(Secretname)) {
						String Bereitsgefunden = prefix + cfg.getString("Secrets.Messages.BereitsGefunden").replace("&", "§");
						player.sendMessage(Bereitsgefunden);
						return;
					}
					String SecretGefunden = prefix + cfg.getString("Secrets.Messages.SecretGefunden").replace("&", "§");
					SecretGefunden = SecretGefunden.replace("%SECRET%", Secretname);
					String GefundenCMD = prefix + cfg.getString("Secrets.Settings.Command").replace("%PLAYER%", player.getName());
					GefundenCMD = GefundenCMD.replace("&", "§");
					
					Bukkit.dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), GefundenCMD);
					player.sendMessage(SecretGefunden);
					player.playSound(player.getLocation(), Sound.LEVEL_UP, 3F, 3F);
					userlist.add(Secretname);
					cfg3.set(player.getName(), userlist);
					try {
						cfg3.save(Data);
					} catch(IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
	}

}
