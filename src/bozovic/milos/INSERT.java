package bozovic.milos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;


public class INSERT {

	public static void main(String[] args) {

	String url = "jdbc:mysql://localhost:3306/biblioteke";
	String username = "root";
	String password = "";
	
	try (Connection conn = DriverManager.getConnection(url, username, password)) {
		
		System.out.println("Uspešno povezani sa bazom!");
		
		String sqlinsert = "INSERT INTO bibliotekee(naziv, ulica, broj, mesto, telefon) VALUES ( ?, ?, ?, ?, ?)";
		
		PreparedStatement ps = conn.prepareStatement(sqlinsert);
		ps.setString(1, "Školska");
		ps.setString(2, "Crveno Barjače");
		ps.setString(3, "78");
		ps.setString(4, "Beograd");
		ps.setString(5, "011444444");
		
		int unetPodatak = ps.executeUpdate();
		
		if(unetPodatak > 0)
			System.out.println("Podatak je upisan");
		
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
		
		
	}

}
