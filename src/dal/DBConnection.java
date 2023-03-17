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

	/**

	The DBConnection class represents a singleton instance for connecting to the database.
	*/
	private DBConnection() {
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

	/**
	Closes the database connection and sets the instance of the DBConnection class to null.
	This method should be called when the application is closing or when the connection is no longer needed.
	*/
	public static void closeConnection() {
		try {
			con.close();
			instance = null;
			System.out.println("The connection is closed");
		} catch (Exception e) {
			System.out.println("Error trying to close the database " + e.getMessage());
		}
	}

	/**
	Returns the database connection.
	@return The database connection
	*/
	public Connection getDBcon() {
		return con;
	}

	/**
	Returns a boolean value indicating whether the DBConnection instance is null or not.
	@return true if the instance is null, false otherwise
	*/
	public static boolean instanceIsNull() {
		return (instance == null);
	}

	/**
	Singleton method for obtaining a database connection instance. If an instance
	already exists, it will be returned; otherwise, a new instance will be created.
	@return the database connection instance
	*/
	public static DBConnection getInstance() {
		if (instance == null) {
			instance = new DBConnection();
		}
		return instance;
	}

	/**
	Returns the current open status of the database connection.
	@return boolean value indicating whether the connection is open or closed
	*/
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