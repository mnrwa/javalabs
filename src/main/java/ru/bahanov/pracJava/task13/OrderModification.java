package ru.bahanov.pracJava.task13;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderModification {

    public void deleteOrdersWithProductQuantity(int productId, int quantity) {
        String query = "DELETE FROM Orders " +
                "WHERE order_id IN (SELECT order_id FROM Order_Items " +
                "WHERE product_id = ? AND quantity = ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, productId);
            stmt.setInt(2, quantity);
            int rowsAffected = stmt.executeUpdate();
            System.out.println("Deleted " + rowsAffected + " orders.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
