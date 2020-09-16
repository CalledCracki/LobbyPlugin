package at.Cracki.Lobby.config;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import at.Cracki.Lobby.Main.Lobby;

public class ConfigurationFile {
	
	public void setStandard() {
		FileConfiguration cfg = getFileConfiguration();
		
		cfg.options().copyDefaults(true);
		cfg.options().header("LobbySystem by CalledCracki");
		
		cfg.addDefault("Lobby.prefix", "&7[&eLobby&7] ");
		cfg.addDefault("Lobby.Messages.NoPerms", "&cDazu hast du keine Rechte!");
		cfg.addDefault("Lobby.Messages.Build.Aktiviert", "&aDu bist nun im &6&lBuild-Modus.");
		cfg.addDefault("Lobby.Messages.Build.Fehler1", "&cDu bist bereits im &6&lBuild-Modus!");
		cfg.addDefault("Lobby.Messages.Build.Deaktiviert", "&aDu bist nun nicht laenger im &6&lBuild-Modus.");
		
		//	Secrets System
		
		cfg.addDefault("Lobby.Secrets.Schild.Zeile1", "&7[&aSecrets&7]");
		cfg.addDefault("Lobby.Secrets.Schild.Zeile3", "&f<Rechtsklick>");
		cfg.addDefault("Lobby.Secrets.Schild.Zeile4", " ");
		
		cfg.addDefault("Lobby.Secrets.Messages.SecretGefunden", "&aDu hast das Secret %SECRET% gefunden!");
		cfg.addDefault("Lobby.Secrets.Messages.BereitsGefunden", "&cDieses Secret hast du bereits gefunden!");
		cfg.addDefault("Lobby.Secrets.Messages.SecretErstellt", "&aDu hast erfolgreich das Secret &f%SECRET% &aerstellt!");
		
		cfg.addDefault("Lobby.Secrets.Settings.Command", "say %PLAYER% hier bitte den Befehl einfuegen!");
		
		//=======================================================
		
		try {
			cfg.save(getFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readData() {
		FileConfiguration cfg2 = getFileConfiguration();
		Lobby.pre = cfg2.getString("Lobby.prefix").replace("&", "§");
		Lobby.noperms = Lobby.pre + cfg2.getString("Lobby.Messages.NoPerms").replace("&", "§");
	}
	
	private File getFile() {
		return new File("plugins/Lobby", "Config.yml");
	}
	
	private FileConfiguration getFileConfiguration() {
		return YamlConfiguration.loadConfiguration(getFile());
	}

}