package test;

import java.sql.Connection;
import java.sql.SQLException;

import dal.DBConnection;
import org.junit.Test;
import static org.junit.Assert.*;

/**
Last updated: 17-03-2023

- Documentation and comments added and updated
*/

/**
This class contains a JUnit test case to test the database connection.
*/
public class DatabaseConnectionTest {

	/**
	This test case tests whether a database connection can be successfully established.
	It checks if the connection is not null after getting it from the DBConnection singleton class.
	If the connection is successful, the test case passes. Otherwise, it fails with an error message.
	*/
    @Test
    public void testDatabaseConnection() {
        try (Connection connection = DBConnection.getInstance().getDBcon()) {
            // If connection is successful, assert that the connection is not null
            assertNotNull(connection);
        } catch (SQLException e) {
            // If connection is not successful, fail the test
            fail("Database connection failed: " + e.getMessage());
        }
    }
}

