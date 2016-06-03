package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOAcces {
	private Connection con = null;
	private static DAOAcces instance = null;

	public static DAOAcces getInstance() {
		if (instance == null) {
			instance = new DAOAcces();
		}
		return instance;
	}

	private DAOAcces() {
		// TODO Auto-generated constructor stub
		super();
		try {
			loadDriver();
		} catch (ClassNotFoundException e) {
			System.out.println("Driver inexistant");
		}
	}

	private void loadDriver() throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
	}

	public Connection connect() throws SQLException {
		String DBurl = "jdbc:mysql://localhost:3306/sys";
		return con = DriverManager.getConnection(DBurl, "root", "0000");
	}

	public Connection getConnection() {
		return con;
	}

	public void close() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erreur lors de la fermeture de connection");
		}
	}

}
