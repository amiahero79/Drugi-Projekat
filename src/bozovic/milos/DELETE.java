package bozovic.milos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DELETE {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/biblioteke";
		String username = "root";
		String password = "";
		
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			
			System.out.println("Uspešno povezani sa bazom!");
			
			String sqldelete = "DELETE FROM bibliotekee WHERE naziv = ?";
			PreparedStatement ps = conn.prepareStatement(sqldelete);
			ps.setString(1, "Školska");
			
			int obrisanPodatak = ps.executeUpdate();
			
			if(obrisanPodatak > 0)
				System.out.println("Podatak je obrisan");
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		} 
	}

}
