package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnection {
	private static Connection connection;

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(                  //jdbc:mysql://dbserver:3306/oconstan
					"jdbc:mysql://dbserver.emi.u-bordeaux.fr/oconstan", "oconstan", 
					"U-bordeaux1");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return connection;
	}

}