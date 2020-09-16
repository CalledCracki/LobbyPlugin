package at.Cracki.Lobby.config;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class WarpsConfig {
	
	public void setStandard() {
		FileConfiguration cfg = getFileConfiguration();
		
		cfg.options().copyDefaults(true);
		cfg.options().header("Navigator Warps");
		
		cfg.addDefault("Warps.1.X", 0);
		cfg.addDefault("Warps.1.Y", 0);
		cfg.addDefault("Warps.1.Z", 0);
		cfg.addDefault("Warps.1.Yaw", 0);
		cfg.addDefault("Warps.1.Pitch", 0);
		cfg.addDefault("Warps.1.World", "world");
		
		cfg.addDefault("Warps.2.X", 0);
		cfg.addDefault("Warps.2.Y", 0);
		cfg.addDefault("Warps.2.Z", 0);
		cfg.addDefault("Warps.2.Yaw", 0);
		cfg.addDefault("Warps.2.Pitch", 0);
		cfg.addDefault("Warps.2.World", "world");
		
		cfg.addDefault("Warps.3.X", 0);
		cfg.addDefault("Warps.3.Y", 0);
		cfg.addDefault("Warps.3.Z", 0);
		cfg.addDefault("Warps.3.Yaw", 0);
		cfg.addDefault("Warps.3.Pitch", 0);
		cfg.addDefault("Warps.3.World", "world");
		
		cfg.addDefault("Warps.4.X", 0);
		cfg.addDefault("Warps.4.Y", 0);
		cfg.addDefault("Warps.4.Z", 0);
		cfg.addDefault("Warps.4.Yaw", 0);
		cfg.addDefault("Warps.4.Pitch", 0);
		cfg.addDefault("Warps.4.World", "world");
		
		cfg.addDefault("Warps.5.X", 0);
		cfg.addDefault("Warps.5.Y", 0);
		cfg.addDefault("Warps.5.Z", 0);
		cfg.addDefault("Warps.5.Yaw", 0);
		cfg.addDefault("Warps.5.Pitch", 0);
		cfg.addDefault("Warps.5.World", "world");
		
		cfg.addDefault("Warps.6.X", 0);
		cfg.addDefault("Warps.6.Y", 0);
		cfg.addDefault("Warps.6.Z", 0);
		cfg.addDefault("Warps.6.Yaw", 0);
		cfg.addDefault("Warps.6.Pitch", 0);
		cfg.addDefault("Warps.6.World", "world");
		
		cfg.addDefault("Warps.Spawn.X", 0);
		cfg.addDefault("Warps.Spawn.Y", 0);
		cfg.addDefault("Warps.Spawn.Z", 0);
		cfg.addDefault("Warps.Spawn.Yaw", 0);
		cfg.addDefault("Warps.Spawn.Pitch", 0);
		cfg.addDefault("Warps.Spawn.World", "world");
		
		cfg.addDefault("Warps.1.status", false);
		cfg.addDefault("Warps.2.status", false);
		cfg.addDefault("Warps.3.status", false);
		cfg.addDefault("Warps.4.status", false);
		cfg.addDefault("Warps.5.status", false);
		cfg.addDefault("Warps.6.status", false);
		cfg.addDefault("Warps.Spawn.status", false);
		
		//=======================================================
		
		try {
			cfg.save(getFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private File getFile() {
		return new File("plugins/Lobby", "Warps.yml");
	}
	
	private FileConfiguration getFileConfiguration() {
		return YamlConfiguration.loadConfiguration(getFile());
	}

}
