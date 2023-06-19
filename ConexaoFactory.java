

import java.sql.Connection;
import java.sql.DriverManager;



public class ConexaoFactory {
	public Connection conectar() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/coffee","root","123456");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}	