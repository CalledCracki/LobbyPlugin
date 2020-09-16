package at.Cracki.Lobby.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import at.Cracki.Lobby.Main.Lobby;
import at.Cracki.Lobby.Money.MoneyAPI;

public class CoinsCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		Player player = (Player) sender;
		if(player.hasPermission("lobby.coins")) {
			if(args.length == 0) {
				player.sendMessage(Lobby.pre + "§aDeine Coins: §e" + MoneyAPI.getCoins(player.getUniqueId().toString()));
			}else if(args.length == 3) {
				Integer amount = Integer.valueOf(args[2]);
				if(args[0].equalsIgnoreCase("add")) {
						Player target = Bukkit.getPlayerExact(args[1]);
						if(target != null) {
							MoneyAPI.addCoins(target.getUniqueId().toString(), amount);
							player.sendMessage(Lobby.pre + "§aDem Spieler §b" + target.getName() + " §awurden §e" + amount + " Coins §aüberwiesen.");
							target.sendMessage(Lobby.pre + "§aDeinem Konto wurden §e" + amount + " Coins §ahinzugefügt.");
							target.playSound(target.getLocation(), Sound.LEVEL_UP, 3F, 3F);
					}else
						player.sendMessage(Lobby.pre + "§cDieser Spieler ist nicht online!");
						return true;
				}else if(args[0].equalsIgnoreCase("remove")) {
						Player target = Bukkit.getPlayerExact(args[1]);
						if(target != null) {
							MoneyAPI.removeCoins(target.getUniqueId().toString(), amount);
							target.sendMessage(Lobby.pre + "§aDir wurden §e" + amount + " Coins §aabgezogen!"); 
							player.sendMessage(Lobby.pre + "§aDem Spieler §b" + target.getName() + " §awurden §e" + amount + " Coins §aabgezogen.");
							target.playSound(target.getLocation(), Sound.LEVEL_UP, 3F, 3F);
				}else
						player.sendMessage(Lobby.pre + "§cDieser Spieler ist nicht online!");	
						return true;
				}else if(args[0].equalsIgnoreCase("set")) {
						Player target = Bukkit.getPlayerExact(args[1]);
						if(target != null) {
							MoneyAPI.setCoins(target.getUniqueId().toString(), amount);
							player.sendMessage(Lobby.pre + "§aDer Kontostand von §b" + target.getName() + " §awurde auf §e" + amount + " Coins §agesetzt.");
							target.sendMessage(Lobby.pre + "§aDein Kontostand wurde auf §e" + amount + " Coins §agesetzt");
							target.playSound(target.getLocation(), Sound.LEVEL_UP, 3F, 3F);
				}else
						player.sendMessage(Lobby.pre + "§cDieser Spieler ist nicht online!");
						return true;
				}else
					player.sendMessage(Lobby.pre + "§cVerwendung: /coins <add/remove/set> <Spieler> <Coins>");
			}else
				player.sendMessage(Lobby.pre + "§cVerwendung: /coins <add/remove/set> <Spieler> <Coins>");
		}else
			player.sendMessage(Lobby.noperms);
		return false;
	}
}
