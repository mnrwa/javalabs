package task13;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DBTest {

    private Connection connection;

    @BeforeEach
    void setUp() throws Exception {
        String url = "jdbc:postgresql://localhost:5432/javalabs13";
        String user = "postgres";
        String password = "dbpass";

        connection = DriverManager.getConnection(url, user, password);

        try (Statement stmt = connection.createStatement()) {
            stmt.execute("DROP TABLE IF EXISTS Orders CASCADE");
            stmt.execute("CREATE TABLE Orders (" +
                    "order_id SERIAL PRIMARY KEY, " +
                    "amount DOUBLE PRECISION, " +
                    "item_count INT)");

            stmt.execute("INSERT INTO Orders (amount, item_count) VALUES (400.0, 2)");
            stmt.execute("INSERT INTO Orders (amount, item_count) VALUES (500.0, 3)");
        }
    }

    @Test
    void testGetOrdersByAmountAndItemCount() throws SQLException {
        String query = "SELECT order_id FROM Orders WHERE amount <= ? AND item_count = ?";
        List<Integer> orderIds = new ArrayList<>();

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setDouble(1, 500.0);
            stmt.setInt(2, 3);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                orderIds.add(rs.getInt("order_id"));
            }
        }

        assertEquals(1, orderIds.size());
        assertEquals(2, orderIds.get(0)); // Порядок вставки соответствует order_id
    }
}
