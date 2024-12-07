package ru.bahanov.pracJava.task13;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderQuery {

    public void printOrderDetails(int orderId) {
        String query = "SELECT o.order_id, o.order_date, p.name, p.price, i.quantity " +
                "FROM Orders o " +
                "JOIN Order_Items i ON o.order_id = i.order_id " +
                "JOIN Products p ON i.product_id = p.product_id " +
                "WHERE o.order_id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, orderId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println("Order ID: " + rs.getInt("order_id"));
                System.out.println("Order Date: " + rs.getDate("order_date"));
                System.out.println("Product: " + rs.getString("name"));
                System.out.println("Price: " + rs.getDouble("price"));
                System.out.println("Quantity: " + rs.getInt("quantity"));
                System.out.println("-----");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Integer> getOrdersContainingProduct(int productId) {
        String query = "SELECT DISTINCT order_id FROM Order_Items WHERE product_id = ?";
        List<Integer> orders = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, productId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                orders.add(rs.getInt("order_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

}

