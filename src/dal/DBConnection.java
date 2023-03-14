package dal;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class DBConnection {
	// Constants used to get access to the database

	private static final String serverAddress = "jdbc:sqlserver://" + Login.HOSTNAME;
	private static final String databaseName = ";databaseName=" + Login.DATABASENAME;

	private static String userName = ";user=" + Login.USERNAME;
	private static String password = ";password=" + Login.PASSWORD;
	private static String encryption = ";encrypt=false";

	private DatabaseMetaData dma;
	private static Connection con;

	// An instance of the class is generated
	private static DBConnection instance = null;

	// The constructor is private to ensure that only one object of this class is created
	public DBConnection() {
		String url = serverAddress + databaseName + userName + password + encryption;
		System.out.println("URL: " + url);

		try {
			// Load of driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("Driver class loaded ok");

		} catch (Exception e) {
			System.out.println("Cannot find the driver");
			System.out.println(e.getMessage());
		}
		try {
			// Connection to the database
			con = DriverManager.getConnection(url);
			con.setAutoCommit(true);
			dma = con.getMetaData(); // Get metadata
			System.out.println("Connection to " + dma.getURL());
			System.out.println("Driver " + dma.getDriverName());
			System.out.println("Database product name " + dma.getDatabaseProductName());
		}
		catch (Exception e) {
			System.out.println("Problems with the connection to the database:");
			System.out.println(e.getMessage());
			System.out.println(url);
		}
	}

	// CloseDb: closes the connection to the database
	public static void closeConnection() {
		try {
			con.close();
			instance = null;
			System.out.println("The connection is closed");
		} catch (Exception e) {
			System.out.println("Error trying to close the database " + e.getMessage());
		}
	}

	// GetDBcon: returns the singleton instance of the DB connection
	public Connection getDBcon() {
		return con;
	}

	// GetDBcon: returns the singleton instance of the DB connection
	public static boolean instanceIsNull() {
		return (instance == null);
	}

	// This method is used to get the instance of the connection
	public static DBConnection getInstance() {
		if (instance == null) {
			instance = new DBConnection();
		}
		return instance;
	}

	public static boolean getOpenStatus() {
		boolean isOpen = false;
		try {
			isOpen = (!con.isClosed());
		} catch (Exception sclExc) {
			isOpen = false;
		}
		return isOpen;
	}

}