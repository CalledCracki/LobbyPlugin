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

public class SetWarpCommand implements CommandExecutor {
	
	public static File file2 = new File("plugins/Lobby", "Warps.yml");
	public static YamlConfiguration cfg2 = YamlConfiguration.loadConfiguration(file2);
	
	public static boolean Spawn = cfg2.getBoolean("Warps.Spawn.status");
	public static boolean eins = cfg2.getBoolean("Warps.Eins.status");
	public static boolean zwei = cfg2.getBoolean("Warps.Zwei.status");
	public static boolean drei = cfg2.getBoolean("Warps.Drei.status");
	public static boolean vier = cfg2.getBoolean("Warps.Vier.status");
	public static boolean fünf = cfg2.getBoolean("Warps.Fuenf.status");
	public static boolean sechs = cfg2.getBoolean("Warps.Sechs.status");

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		Player player = (Player) sender;
		if(player.hasPermission("lobby.admin")) {
			if(args.length == 1) {
				if(args[0].equalsIgnoreCase("1")) {
					File file = new File("plugins/Lobby", "Warps.yml");
					YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
					cfg.set("Warps.1.X", player.getLocation().getX());
					cfg.set("Warps.1.Y", player.getLocation().getY());
					cfg.set("Warps.1.Z", player.getLocation().getZ());
					cfg.set("Warps.1.Yaw", player.getLocation().getYaw());
					cfg.set("Warps.1.Pitch", player.getLocation().getPitch());
					cfg.set("Warps.1.World", player.getWorld().getName());
					player.playSound(player.getLocation(), Sound.LEVEL_UP, 3F, 3F);
					player.sendMessage(Lobby.pre + "§aWarp Punkt §c#1 §awurde gesetzt.");
					eins = true;
					try {
						cfg.save(file);
					}catch(IOException e1) {
						e1.printStackTrace();
						player.sendMessage(Lobby.pre + "§cEin Fehler ist aufgetreten. Bitte überprüfe die Console."); 
					}
				}else if(args[0].equalsIgnoreCase("2")) {
					File file = new File("plugins/Lobby", "Warps.yml");
					YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
					cfg.set("Warps.2.X", player.getLocation().getX());
					cfg.set("Warps.2.Y", player.getLocation().getY());
					cfg.set("Warps.2.Z", player.getLocation().getZ());
					cfg.set("Warps.2.Yaw", player.getLocation().getYaw());
					cfg.set("Warps.2.Pitch", player.getLocation().getPitch());
					cfg.set("Warps.2.World", player.getWorld().getName());
					player.playSound(player.getLocation(), Sound.LEVEL_UP, 3F, 3F);
					player.sendMessage(Lobby.pre + "§aWarp Punkt §c#2 §awurde gesetzt.");
					zwei = true;
					try {
						cfg.save(file);
					}catch(IOException e1) {
						e1.printStackTrace();
						player.sendMessage(Lobby.pre + "§cEin Fehler ist aufgetreten. Bitte überprüfe die Console."); 
					}
				}else if(args[0].equalsIgnoreCase("3")) {
					File file = new File("plugins/Lobby", "Warps.yml");
					YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
					cfg.set("Warps.3.X", player.getLocation().getX());
					cfg.set("Warps.3.Y", player.getLocation().getY());
					cfg.set("Warps.3.Z", player.getLocation().getZ());
					cfg.set("Warps.3.Yaw", player.getLocation().getYaw());
					cfg.set("Warps.3.Pitch", player.getLocation().getPitch());
					cfg.set("Warps.3.World", player.getWorld().getName());
					player.playSound(player.getLocation(), Sound.LEVEL_UP, 3F, 3F);
					player.sendMessage(Lobby.pre + "§aWarp Punkt §c#3 §awurde gesetzt.");
					drei = true;
					try {
						cfg.save(file);
					}catch(IOException e1) {
						e1.printStackTrace();
						player.sendMessage(Lobby.pre + "§cEin Fehler ist aufgetreten. Bitte überprüfe die Console."); 
					}
				}else if(args[0].equalsIgnoreCase("4")) {
					File file = new File("plugins/Lobby", "Warps.yml");
					YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
					cfg.set("Warps.4.X", player.getLocation().getX());
					cfg.set("Warps.4.Y", player.getLocation().getY());
					cfg.set("Warps.4.Z", player.getLocation().getZ());
					cfg.set("Warps.4.Yaw", player.getLocation().getYaw());
					cfg.set("Warps.4.Pitch", player.getLocation().getPitch());
					cfg.set("Warps.4.World", player.getWorld().getName());
					player.playSound(player.getLocation(), Sound.LEVEL_UP, 3F, 3F);
					player.sendMessage(Lobby.pre + "§aWarp Punkt §c#4 §awurde gesetzt.");
					vier = true;
					try {
						cfg.save(file);
					}catch(IOException e1) {
						e1.printStackTrace();
						player.sendMessage(Lobby.pre + "§cEin Fehler ist aufgetreten. Bitte überprüfe die Console."); 
					}
				}else if(args[0].equalsIgnoreCase("5")) {
					File file = new File("plugins/Lobby", "Warps.yml");
					YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
					cfg.set("Warps.5.X", player.getLocation().getX());
					cfg.set("Warps.5.Y", player.getLocation().getY());
					cfg.set("Warps.5.Z", player.getLocation().getZ());
					cfg.set("Warps.5.Yaw", player.getLocation().getYaw());
					cfg.set("Warps.5.Pitch", player.getLocation().getPitch());
					cfg.set("Warps.5.World", player.getWorld().getName());
					player.playSound(player.getLocation(), Sound.LEVEL_UP, 3F, 3F);
					player.sendMessage(Lobby.pre + "§aWarp Punkt §c#5 §awurde gesetzt.");
					fünf = true;
					try {
						cfg.save(file);
					}catch(IOException e1) {
						e1.printStackTrace();
						player.sendMessage(Lobby.pre + "§cEin Fehler ist aufgetreten. Bitte überprüfe die Console."); 
					}
				}else if(args[0].equalsIgnoreCase("6")) {
					File file = new File("plugins/Lobby", "Warps.yml");
					YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
					cfg.set("Warps.6.X", player.getLocation().getX());
					cfg.set("Warps.6.Y", player.getLocation().getY());
					cfg.set("Warps.6.Z", player.getLocation().getZ());
					cfg.set("Warps.6.Yaw", player.getLocation().getYaw());
					cfg.set("Warps.6.Pitch", player.getLocation().getPitch());
					cfg.set("Warps.6.World", player.getWorld().getName());
					player.playSound(player.getLocation(), Sound.LEVEL_UP, 3F, 3F);
					player.sendMessage(Lobby.pre + "§aWarp Punkt §c#6 §awurde gesetzt.");
					sechs = true;
					try {
						cfg.save(file);
					}catch(IOException e1) {
						e1.printStackTrace();
						player.sendMessage(Lobby.pre + "§cEin Fehler ist aufgetreten. Bitte überprüfe die Console."); 
					}
				}else if(args[0].equalsIgnoreCase("Spawn")) {
					File file = new File("plugins/Lobby", "Warps.yml");
					YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
					cfg.set("Warps.Spawn.X", player.getLocation().getX());
					cfg.set("Warps.Spawn.Y", player.getLocation().getY());
					cfg.set("Warps.Spawn.Z", player.getLocation().getZ());
					cfg.set("Warps.Spawn.Yaw", player.getLocation().getYaw());
					cfg.set("Warps.Spawn.Pitch", player.getLocation().getPitch());
					cfg.set("Warps.Spawn.World", player.getWorld().getName());
					player.playSound(player.getLocation(), Sound.LEVEL_UP, 3F, 3F);
					player.sendMessage(Lobby.pre + "§aWarp Punkt §c#7 §awurde gesetzt.");
					cfg.set("Warps.Spawn.status", true);
					try {
						cfg.save(file);
					}catch(IOException e1) {
						e1.printStackTrace();
						player.sendMessage(Lobby.pre + "§cEin Fehler ist aufgetreten. Bitte überprüfe die Console."); 
					}
				}
			}else
				player.sendMessage(Lobby.pre + "§cVerwendung: /setwarp <KO/GG/CB/..>");
		}else
			player.sendMessage(Lobby.noperms);
		
		
		return false;
	}

}
