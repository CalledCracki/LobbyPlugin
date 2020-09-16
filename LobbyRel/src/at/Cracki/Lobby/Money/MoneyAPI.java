package at.Cracki.Lobby.Money;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MoneyAPI {
	
	public static int getCoins(String UUID) {
		try {
			PreparedStatement ps = MySQL.con.prepareStatement("SELECT coins FROM coinTable WHERE UUID=?");
			ps.setString(1, UUID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return rs.getInt("coins");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static void setCoins(String UUID, int Coins) {
		if(getCoins(UUID) == 0) {
			try {
				PreparedStatement ps = MySQL.con.prepareStatement("INSERT INTO coinTable (UUID,coins) VALUES (?,?)");
				ps.setString(1, UUID);
				ps.setInt(2, Coins);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else{
            PreparedStatement st = null;
            try {
                st = MySQL.con.prepareStatement("UPDATE coinTable SET coins = ? WHERE UUID = ?");
                st.setString(2, UUID);
                st.setInt(1, Coins);
                st.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}
	
	public static void addCoins(String UUID, int Coins) {
        int current = getCoins(UUID);
        setCoins(UUID, Coins + current);
		
	}

	public static void removeCoins(String UUID, int Coins) {
		setCoins(UUID, getCoins(UUID) - Coins);
	}
	
}
