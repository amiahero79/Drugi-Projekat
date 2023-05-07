package bozovic.milos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SELECT {

	public static void main(String[] args) {
	
	String url = "jdbc:mysql://localhost:3306/biblioteke";
	String username = "root";
	String password = "";
	
	try(Connection conn = DriverManager.getConnection(url, username, password)) {
		
		System.out.println("Uspešno smo se povezali sa bazom");
		
		String sqlselect = "SELECT * FROM bibliotekee";
		Statement stmt = conn.createStatement();
		ResultSet result = stmt.executeQuery(sqlselect);
		
		while(result.next()) {
			String naziv = result.getString(2);
			String ulica = result.getString(3);
			String broj = result.getString(4);
			String mesto = result.getString(5);
			String telefon = result.getString(6);
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("Naziv: ");
		builder.append(naziv);
		builder.append("\nUlica: ");
		builder.append(ulica);
		builder.append("\nBroj: ");
		builder.append(broj);
		builder.append("\nMesto: ");
		builder.append(mesto);
		builder.append("\nTelefon: ");
		builder.append(telefon);
		
		System.out.println(builder.toString());
		System.out.println();
	}
		
	} catch(SQLException e) {
		e.printStackTrace();
	}
		

	}

}
