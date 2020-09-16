package at.Cracki.Lobby.Items;

import java.io.File;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import at.Cracki.Lobby.Commands.SetWarpCommand;
import at.Cracki.Lobby.Listener.Item;
import at.Cracki.Lobby.Main.Lobby;


public class Navigator implements Listener {
	
	public static File file = new File("plugins/Lobby", "Warps.yml");
	public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	public void openGUI(Player player) {
		Inventory kompassinv = Bukkit.createInventory(null, 9*5, "§6§lNavigator");
		
		ItemStack spawn = new Item(Material.MAGMA_CREAM, 1).setDisplayName("§a§lSpawn").setLore(Arrays.asList(
				"§7Zum Spawn")).build();
		ItemStack cb = new Item(Material.IRON_AXE, 1).setDisplayName("§aCitybuild").build();					
		ItemStack hof = new Item(Material.SKULL_ITEM, 1, (byte) 3).setDisplayName("§d§lHall of Fame").build();
		ItemStack gg = new Item(Material.WOOD_AXE, 1).setDisplayName("§eGunGame").build();
		ItemStack spvp = new Item(Material.IRON_SWORD, 1).setDisplayName("§cSkyPVP").build();
		ItemStack jr = new Item(Material.GOLD_BOOTS, 1).setDisplayName("§bJump-Rush").build();
		ItemStack ko = new Item(Material.BLAZE_ROD, 1).setDisplayName("§6KnockOut").build();
		ItemStack soon = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
		SkullMeta snm = (SkullMeta) soon.getItemMeta();
		snm.setDisplayName("§c§lCOMING SOON");
		snm.setOwner("MHF_Question");
		soon.setItemMeta(snm);
		
		kompassinv.setItem(4, soon);
		kompassinv.setItem(12, jr);
		kompassinv.setItem(14, ko);
		kompassinv.setItem(20, gg);
		kompassinv.setItem(24, spvp);
		kompassinv.setItem(30, hof);
		kompassinv.setItem(32, cb);
		kompassinv.setItem(40, spawn);
		player.openInventory(kompassinv);
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		if(event.getPlayer().getItemInHand().getType() != Material.COMPASS) return;
			if(event.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lNavigator §7(Rechtsklick)")) {
				if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
					openGUI(event.getPlayer());
					}
				}
		}

	@EventHandler
	public void handleNavClick(InventoryClickEvent event) {
		if(!(event.getWhoClicked() instanceof Player)) return;
			Player player = (Player) event.getWhoClicked();
			if(event.getInventory().getTitle().equalsIgnoreCase("§6§lNavigator")) {
					if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lCOMING SOON")) {
						player.sendMessage("§cKeine Ahnung was das wird.");
						player.closeInventory();
						return;
					}
				
					switch(event.getCurrentItem().getType()) {
					case MAGMA_CREAM:
						if(cfg.getBoolean("Warps.Spawn.status") == true) {
							String w = cfg.getString("Warps.Spawn.World");
							double x = cfg.getDouble("Warps.Spawn.X");
							double y = cfg.getDouble("Warps.Spawn.Y");
							double z = cfg.getDouble("Warps.Spawn.Z");
							float Yaw = (float) cfg.getDouble("Warps.Spawn.Yaw");
							float Pitch = (float) cfg.getDouble("Warps.Spawn.Pitch");
							Location loc = new Location(Bukkit.getWorld(w), x, y, z, Yaw, Pitch);
							player.teleport(loc);
							player.closeInventory();
							player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 3F, 3F);
							break;
					}else {
						player.sendMessage(Lobby.pre + "§cDieser Spawnpunkt wurde nicht gesetzt!");
						player.closeInventory();
						player.playSound(player.getLocation(), Sound.ANVIL_BREAK, 3F, 3F);
						return;
					}
					
					case IRON_AXE:
						if(SetWarpCommand.eins == true) {
							File file2 = new File("plugins/Lobby", "Warps.yml");
							YamlConfiguration cfg2 = YamlConfiguration.loadConfiguration(file2);
							String w2 = cfg2.getString("Warps.1.World");
							double x2 = cfg2.getDouble("Warps.1.X");
							double y2 = cfg2.getDouble("Warps.1.Y");
							double z2 = cfg2.getDouble("Warps.1.Z");
							float Yaw2 = (float) cfg2.getDouble("Warps.1.Yaw");
							float Pitch2 = (float) cfg2.getDouble("Warps.1.Pitch");
							Location loc2 = new Location(Bukkit.getWorld(w2), x2, y2, z2, Yaw2, Pitch2);
							player.teleport(loc2);
							player.closeInventory();
							player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 3F, 3F);
							break;
						}else {
							player.sendMessage(Lobby.pre + "§cDieser Spawnpunkt wurde nicht gesetzt!");
							player.closeInventory();
							player.playSound(player.getLocation(), Sound.ANVIL_BREAK, 3F, 3F);
							return;
						}
							
						
					case IRON_SWORD:
						if(SetWarpCommand.zwei == true) {
							File file4 = new File("plugins/Lobby", "Warps.yml");
							YamlConfiguration cfg4 = YamlConfiguration.loadConfiguration(file4);
							String w4 = cfg4.getString("Warps.2.World");
							double x4 = cfg4.getDouble("Warps.2.X");
							double y4 = cfg4.getDouble("Warps.2.Y");
							double z4 = cfg4.getDouble("Warps.2.Z");
							float Yaw4 = (float) cfg4.getDouble("Warps.2.Yaw");
							float Pitch4 = (float) cfg4.getDouble("Warps.2.Pitch");
							Location loc4 = new Location(Bukkit.getWorld(w4), x4, y4, z4, Yaw4, Pitch4);
							player.teleport(loc4);
							player.closeInventory();
							break;
						}else {
							player.sendMessage(Lobby.pre + "§cDieser Spawnpunkt wurde nicht gesetzt!");
							player.closeInventory();
							player.playSound(player.getLocation(), Sound.ANVIL_BREAK, 3F, 3F);
							player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 3F, 3F);
							return;
						}
						
					case WOOD_AXE:
						if(SetWarpCommand.drei == true) {
							File file5 = new File("plugins/Lobby", "Warps.yml");
							YamlConfiguration cfg5 = YamlConfiguration.loadConfiguration(file5);
							String w5 = cfg5.getString("Warps.3.World");
							double x5 = cfg5.getDouble("Warps.3.X");
							double y5 = cfg5.getDouble("Warps.3.Y");
							double z5 = cfg5.getDouble("Warps.3.Z");
							float Yaw5 = (float) cfg5.getDouble("Warps.3.Yaw");
							float Pitch5 = (float) cfg5.getDouble("Warps.3.Pitch");
							Location loc5 = new Location(Bukkit.getWorld(w5), x5, y5, z5, Yaw5, Pitch5);
							player.teleport(loc5);
							player.closeInventory();
							player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 3F, 3F);
							break;
						}else {
							player.sendMessage(Lobby.pre + "§cDieser Spawnpunkt wurde nicht gesetzt!");
							player.closeInventory();
							player.playSound(player.getLocation(), Sound.ANVIL_BREAK, 3F, 3F);
							return;
						}
						
					case GOLD_BOOTS:
						if(SetWarpCommand.vier == true) {
							File file6 = new File("plugins/Lobby", "Warps.yml");
							YamlConfiguration cfg6 = YamlConfiguration.loadConfiguration(file6);
							String w6 = cfg6.getString("Warps.4.World");
							double x6 = cfg6.getDouble("Warps.4.X");
							double y6 = cfg6.getDouble("Warps.4.Y");
							double z6 = cfg6.getDouble("Warps.4.Z");
							float Yaw6 = (float) cfg6.getDouble("Warps.4.Yaw");
							float Pitch6 = (float) cfg6.getDouble("Warps.4.Pitch");
							Location loc6 = new Location(Bukkit.getWorld(w6), x6, y6, z6, Yaw6, Pitch6);
							player.teleport(loc6);
							player.closeInventory();
							player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 3F, 3F);
							break;
						}else {
							player.sendMessage(Lobby.pre + "§cDieser Spawnpunkt wurde nicht gesetzt!");
							player.closeInventory();
							player.playSound(player.getLocation(), Sound.ANVIL_BREAK, 3F, 3F);
							return;
						}
						
					case SKULL_ITEM:
						if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§d§lHall of Fame")) {
							if(SetWarpCommand.fünf == true) {
								File file7 = new File("plugins/Lobby", "Warps.yml");
								YamlConfiguration cfg7 = YamlConfiguration.loadConfiguration(file7);
								String w7 = cfg7.getString("Warps.5.World");
								double x7 = cfg7.getDouble("Warps.5.X");
								double y7 = cfg7.getDouble("Warps.5.Y");
								double z7 = cfg7.getDouble("Warps.5.Z");
								float Yaw7 = (float) cfg7.getDouble("Warps.5.Yaw");
								float Pitch7 = (float) cfg7.getDouble("Warps.5.Pitch");
								Location loc7 = new Location(Bukkit.getWorld(w7), x7, y7, z7, Yaw7, Pitch7);
								player.teleport(loc7);
								player.closeInventory();
								player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 3F, 3F);
								break;
							}else {
								player.sendMessage(Lobby.pre + "§cDieser Spawnpunkt wurde nicht gesetzt!");
								player.closeInventory();
								player.playSound(player.getLocation(), Sound.ANVIL_BREAK, 3F, 3F);
								return;
							}
						}
					case BLAZE_ROD:
						if(SetWarpCommand.sechs == true) {
							File file8 = new File("plugins/Lobby", "Warps.yml");
							YamlConfiguration cfg8 = YamlConfiguration.loadConfiguration(file8);
							String w8 = cfg8.getString("Warps.6.World");
							double x8 = cfg8.getDouble("Warps.6.X");
							double y8 = cfg8.getDouble("Warps.6.Y");
							double z8 = cfg8.getDouble("Warps.6.Z");
							float Yaw8 = (float) cfg8.getDouble("Warps.6.Yaw");
							float Pitch8 = (float) cfg8.getDouble("Warps.6.Pitch");
							Location loc8 = new Location(Bukkit.getWorld(w8), x8, y8, z8, Yaw8, Pitch8);
							player.teleport(loc8);
							player.closeInventory();
							player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 3F, 3F);
							break;
						}else {
							player.sendMessage(Lobby.pre + "§cDieser Spawnpunkt wurde nicht gesetzt!");
							player.closeInventory();
							player.playSound(player.getLocation(), Sound.ANVIL_BREAK, 3F, 3F);
							return;
							
						
						}
						
						
					default:
						return;
				}
			}
	}
}
