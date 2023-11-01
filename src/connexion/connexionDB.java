/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connexion;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maeva
 */
public class connexionDB {
    private static final String url="jdbc:mysql://localhost:3306/quiz";
	private static final String user = "root";
	private static final String password ="";
	public static Connection connect() throws SQLException{
	
		try {
	
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=(Connection) DriverManager.getConnection(url, user, password);
	return con;
	
		}catch (ClassNotFoundException | SQLException e) {
			
			Logger.getLogger(connexionDB.class.getName()).log(Level.SEVERE, null, e);
			
			e.printStackTrace();
	}
	return null;
		
	}
}
