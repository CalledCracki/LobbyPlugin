package at.Cracki.Lobby.SB;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import at.Cracki.Lobby.Money.MoneyAPI;
import net.minecraft.server.v1_8_R3.IScoreboardCriteria;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutScoreboardDisplayObjective;
import net.minecraft.server.v1_8_R3.PacketPlayOutScoreboardObjective;
import net.minecraft.server.v1_8_R3.PacketPlayOutScoreboardScore;
import net.minecraft.server.v1_8_R3.Scoreboard;
import net.minecraft.server.v1_8_R3.ScoreboardObjective;
import net.minecraft.server.v1_8_R3.ScoreboardScore;

public class SBListener {
	
	public static void setScoreboard(Player p) {
		Scoreboard scoreboard = new Scoreboard();
		ScoreboardObjective obj = scoreboard.registerObjective("zagd", IScoreboardCriteria.b);
		obj.setDisplayName("§3§lCrafter§b§lgang§f.§cde"); //Name des Scoreboards
		PacketPlayOutScoreboardObjective createPacket = new PacketPlayOutScoreboardObjective(obj, 0);
		PacketPlayOutScoreboardDisplayObjective display = new PacketPlayOutScoreboardDisplayObjective(1, obj);
		
		ScoreboardScore a1 = new ScoreboardScore(scoreboard, obj, "§f     ");//Leerzeile
		ScoreboardScore a2 = new ScoreboardScore(scoreboard, obj, "§7» §aServer§8:");//1 Zeile
		ScoreboardScore a3 = new ScoreboardScore(scoreboard, obj, "§7» §fLobby-1");//2 Zeile usw.
		ScoreboardScore a4 = new ScoreboardScore(scoreboard, obj, "§b ");
		ScoreboardScore a5 = new ScoreboardScore(scoreboard, obj, "§7» §aDiscord§8:");
		ScoreboardScore a6 = new ScoreboardScore(scoreboard, obj, "§7» §f/discord");
		ScoreboardScore a7 = new ScoreboardScore(scoreboard, obj, "§f ");
		ScoreboardScore a8 = new ScoreboardScore(scoreboard, obj, "§7» §aTeamspeak§8:");
		ScoreboardScore a9 = new ScoreboardScore(scoreboard, obj, "§7» §3Crafter§bgang§f.§cde");
		ScoreboardScore a10 = new ScoreboardScore(scoreboard, obj, "§c   ");
		ScoreboardScore a11 = new ScoreboardScore(scoreboard, obj, "§7» §aCoins§8:");
		ScoreboardScore a12 = new ScoreboardScore(scoreboard, obj, "§7» §e" + MoneyAPI.getCoins(p.getUniqueId().toString()));
		ScoreboardScore a13 = new ScoreboardScore(scoreboard, obj, "§7 ");
		a1.setScore(12);
		a2.setScore(11);
		a3.setScore(10);
		a4.setScore(9);
		a5.setScore(8);
		a6.setScore(7);
		a7.setScore(6);
		a8.setScore(5);
		a9.setScore(4);
		a10.setScore(3);
		a11.setScore(2);
		a12.setScore(1);
		a13.setScore(0);
		
		PacketPlayOutScoreboardObjective removePacket = new PacketPlayOutScoreboardObjective(obj, 1);
		PacketPlayOutScoreboardScore pa1 = new PacketPlayOutScoreboardScore(a1);
		PacketPlayOutScoreboardScore pa2 = new PacketPlayOutScoreboardScore(a2);
		PacketPlayOutScoreboardScore pa3 = new PacketPlayOutScoreboardScore(a3);
		PacketPlayOutScoreboardScore pa4 = new PacketPlayOutScoreboardScore(a4);
		PacketPlayOutScoreboardScore pa5 = new PacketPlayOutScoreboardScore(a5);
		PacketPlayOutScoreboardScore pa6 = new PacketPlayOutScoreboardScore(a6);
		PacketPlayOutScoreboardScore pa7 = new PacketPlayOutScoreboardScore(a7);
		PacketPlayOutScoreboardScore pa8 = new PacketPlayOutScoreboardScore(a8);
		PacketPlayOutScoreboardScore pa9 = new PacketPlayOutScoreboardScore(a9);
		PacketPlayOutScoreboardScore pa10 = new PacketPlayOutScoreboardScore(a10);
		PacketPlayOutScoreboardScore pa11 = new PacketPlayOutScoreboardScore(a11);
		PacketPlayOutScoreboardScore pa12 = new PacketPlayOutScoreboardScore(a12);
		PacketPlayOutScoreboardScore pa13 = new PacketPlayOutScoreboardScore(a13);
		
		sendPacket(removePacket, p);
		sendPacket(createPacket, p);
		sendPacket(display, p);
		
		sendPacket(pa1, p);
		sendPacket(pa2, p);
		sendPacket(pa3, p);
		sendPacket(pa4, p);
		sendPacket(pa5, p);
		sendPacket(pa6, p);
		sendPacket(pa7, p);
		sendPacket(pa8, p);
		sendPacket(pa9, p);
		sendPacket(pa10, p);
		sendPacket(pa11, p);
		sendPacket(pa12, p);
		sendPacket(pa13, p);
	}
	
	private static void sendPacket(Packet<?> packet, Player p) {
		((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	}
}
