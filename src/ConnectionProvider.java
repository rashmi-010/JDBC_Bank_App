import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

	static Connection connection;
	
	
	public static Connection createConnection() {
		//load and register driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		//create connection
			final String url = "jdbc:mysql://localhost:3306/mydb";
			 final String USERNAME_STRING = "root";
			 final String PASSW_STRING = "pass123";
		    connection = DriverManager.getConnection(url, USERNAME_STRING, PASSW_STRING);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
	}
	
}
