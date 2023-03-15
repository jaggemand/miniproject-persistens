package test;

import java.sql.Connection;
import java.sql.SQLException;

import dal.DBConnection;
import org.junit.Test;
import static org.junit.Assert.*;

public class DatabaseConnectionTest {

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

