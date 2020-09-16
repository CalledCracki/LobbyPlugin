package at.Cracki.Lobby.Money;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.Bukkit;

import at.Cracki.Lobby.Main.Lobby;

public class MySQL {
	
	public static String host;//	Host-Adresse deines SQL-Servers (Bei lokalen: 'localhost').
	public static String port;//	Der Port deines SQL-Servers (Standard: '3306').
	public static String db;//		Der Name der von dir erstellten Datenbank.
	public static String username;//Dein Username (Bei lokalen: 'root').
	public static String pass;//	Dein Passwort (Bei lokalen standard. leer).
	public static Connection con;
	
	public static void connect() {//	Baut Verbindung zum MySQL-Server auf
		if(!isConnected()) {
			try {
				con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + db, username, pass);
				Bukkit.getConsoleSender().sendMessage(Lobby.pre + "ßaMit MySQL verbunden!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void disconnect() {//	Schlieﬂt die MySQL-Verbindung
		if(isConnected()) {
			try {
				con.close();
				Bukkit.getConsoleSender().sendMessage(Lobby.pre + "ßcMySQL Verbindung wurde getrennt!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static boolean isConnected() {// Abfrage ob bereits mit MySQL verbunden.
		return(con == null ? false : true);
	}
	
	public static void update(String query) {// MySQL Update Befehl.
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(query);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static ResultSet getResult(String query) {
		try {
			PreparedStatement ps = con.prepareStatement(query);
			return ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void createTable() {// Methode um Tabelle zu erstellen.
		if(isConnected()) {
			update("CREATE TABLE IF NOT EXISTS coinTable (UUID VARCHAR(100), coins INT(16))");
		}
	}
}
