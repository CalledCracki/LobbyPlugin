package at.Cracki.Lobby.Items;

import java.util.HashMap;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import at.Cracki.Lobby.Main.Lobby;

public class Schild implements Listener {
	
	public HashMap<Player, BukkitRunnable> run = new HashMap<>();

	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		final Player player = event.getPlayer();
		if(event.getItem() == null) return;
		if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if(event.getItem().getType() == Material.EYE_OF_ENDER) {
				event.setCancelled(true);
				
				if(run.containsKey(player)) {
					player.sendMessage(Lobby.pre + "§cSchutzschild deaktiviert!");
					run.get(player).cancel();
					run.remove(player);
				}else if(!run.containsKey(player)) {
					run.put(player, new BukkitRunnable() {
						
						@Override
						public void run() {
							player.getWorld().playEffect(player.getLocation(), Effect.ENDER_SIGNAL, 3);
						}
					});
					run.get(player).runTaskTimer(Lobby.getPlugin(), 20L, 20L);
					player.sendMessage(Lobby.pre + "§aSchutzschild aktiviert!"); 
				}
			}
		}
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		if(run.containsKey(event.getPlayer())) {
			run.get(event.getPlayer()).cancel();
			run.remove(event.getPlayer());
		}
	}
	
	@EventHandler
	public void onMove(PlayerMoveEvent event) {
		Player player  = event.getPlayer();
		
		for(Player all : run.keySet()) {
			if(player != all && !player.hasPermission("lobby.schild.bypass")) {
				if(player.getLocation().distance(all.getLocation()) <= 4) {
					
					double Ax = player.getLocation().getX();
					double Ay = player.getLocation().getY();
					double Az = player.getLocation().getZ();
					
					double Bx = all.getLocation().getX();
					double By = all.getLocation().getY();
					double Bz = all.getLocation().getZ();
					
					double x = Ax - Bx;
					double y = Ay - By;
					double z = Az - Bz;
					Vector v = new Vector(x, y, z).normalize().multiply(1D).setY(0.2D);
					player.setVelocity(v);
				}
			}
		}
		
		if(run.containsKey(player)) {
		
			for(Entity ent : player.getNearbyEntities(5, 5, 5)) {
				if(ent instanceof Player) {
					Player target = (Player) ent;
						if(player != target) {
							if(!target.hasPermission("lobby.schild.bypass")) {
							
								double Ax = player.getLocation().getX();
								double Ay = player.getLocation().getY();
								double Az = player.getLocation().getZ();
								
								double Bx = target.getLocation().getX();
								double By = target.getLocation().getY();
								double Bz = target.getLocation().getZ();
								
								double x = Bx - Ax;
								double y = By - Ay;
								double z = Bz - Az;
								Vector v = new Vector(x, y, z).normalize().multiply(1D).setY(0.2D);
								target.setVelocity(v);
							}	
						}
					}
				}
			}
	}
}