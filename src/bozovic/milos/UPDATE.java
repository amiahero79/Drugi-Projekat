package bozovic.milos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UPDATE {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/biblioteke";
		String username = "root";
		String password = "";
		
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			
			System.out.println("Uspešno povezani sa bazom!");
			
			String sqlupdate = "UPDATE bibliotekee SET naziv = ?, ulica = ?, broj = ?, mesto = ? WHERE telefon = 011333333";
			PreparedStatement ps = conn.prepareStatement(sqlupdate);
			ps.setString(1, "Univerzitetska");
			ps.setString(2, "Bulevar");
			ps.setString(3, "122");
			ps.setString(4, "Beograd");
			
			int promenjenPodatak = ps.executeUpdate();
			
			if(promenjenPodatak > 0)
				System.out.println("Podatak je izmenjen");
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}	
		
		
	}

}
