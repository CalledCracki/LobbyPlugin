package at.Cracki.Lobby.Secrets;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class SignCreator {
	
	public static File cmd = new File("plugins/Lobby", "Secrets.yml");
	public static FileConfiguration cfg = (FileConfiguration) YamlConfiguration.loadConfiguration(cmd);

	public static void createSecret(String name) {
		List<String> list = cfg.getStringList("Secrets");
		list.add(name);
		cfg.set("Secrets", list);
		try {
			cfg.save(cmd);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
