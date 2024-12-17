package ru.bahanov.pracJava.task13;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderQuery {

    // 1. Полная информация о заданном заказе
    public void printOrderDetails(int orderId) {
        String query = "SELECT o.order_id, o.date_order, " +
                "p.product_id, p.name, p.description, p.price, " +
                "oi.quantity, (p.price * oi.quantity) AS total_price " +
                "FROM orders o " +
                "JOIN order_items oi ON o.order_id = oi.order_id " +
                "JOIN products p ON oi.product_id = p.product_id " +
                "WHERE o.order_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, orderId);
            ResultSet rs = stmt.executeQuery();

            System.out.println("Детали заказа (Order ID: " + orderId + "):\n");

            boolean orderFound = false;
            while (rs.next()) {

                if (!orderFound) {
                    System.out.println("Дата заказа: " + rs.getDate("date_order"));
                    orderFound = true;
                }
                System.out.println("ID товара: " + rs.getInt("product_id"));
                System.out.println("Название товара: " + rs.getString("name"));
                System.out.println("Описание: " + rs.getString("description"));
                System.out.println("Цена за единицу: " + rs.getDouble("price"));
                System.out.println("Количество: " + rs.getInt("quantity"));
                System.out.println("Общая стоимость: " + rs.getDouble("total_price"));
                System.out.println("------------------------");

            }

            if (!orderFound) {
                System.out.println("Заказ с ID " + orderId + " не найден.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 2. Заказы с суммой <= заданной и количеством товаров = заданному
    public List<Integer> getCrit(double minCount, int itemCount) {
        String query = "SELECT o.order_id, SUM(p.price * oi.quantity) AS total_price, COUNT(oi.product_id) AS product_count " +
                "FROM orders o " +
                "JOIN order_items oi ON o.order_id = oi.order_id " +
                "JOIN products p ON oi.product_id = p.product_id " +
                "GROUP BY o.order_id " +
                "HAVING SUM(p.price * oi.quantity) > ? AND COUNT(oi.product_id) = ?";

        List<Integer> orders = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setDouble(1, minCount);
            stmt.setInt(2, itemCount);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int orderId = rs.getInt("order_id");
                double totalPrice = rs.getDouble("total_price");
                int productCount = rs.getInt("product_count");

                System.out.println("Заказ ID: " + orderId + ", Сумма: " + totalPrice + ", Количество товаров: " + productCount);

                orders.add(orderId);
            }

            if (orders.isEmpty()) {
                System.out.println("Заказы с заданными условиями не найдены.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }
    // 3. Заказы, содержащие заданный товар
    public List<Integer> getOrderCurr(String name) {
        String query = "SELECT DISTINCT o.order_id " +
                "FROM orders o " +
                "JOIN order_items oi ON o.order_id = oi.order_id " +
                "JOIN products p ON oi.product_id = p.product_id " +
                "WHERE p.name = ?";

        List<Integer> orders = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int orderId = rs.getInt("order_id");
                System.out.println("Заказ ID: " + orderId);

                orders.add(orderId);
            }

            if (orders.isEmpty()) {
                System.out.println("Заказы с товаром \"" + name + "\" не найдены.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    // 4. Заказы, не содержащие заданный товар и поступившие сегодня
    public List<Integer> getOrderToday(int productId, Date date) {
        String query = "SELECT order_id " +
                "FROM orders " +
                "WHERE date_order = ? " +
                "AND NOT product_id = ?";

        List<Integer> orders = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setDate(1, (java.sql.Date) date);
            stmt.setInt(2, productId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                orders.add(rs.getInt("order_id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }

    // 5. Создание нового заказа из товаров, заказанных сегодня
    public void createNewOrder(java.util.Date date) {
        String query = "SELECT product_id FROM orders WHERE date_order = ?";
        List<Integer> newProducts = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setDate(1, new java.sql.Date(date.getTime()));
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                newProducts.add(rs.getInt("product_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = currentDate.format(formatter);

        String createNewOrder = "INSERT INTO orders (product_id, date_order) VALUES (?, ?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(createNewOrder)) {

            for (Integer productId : newProducts) {
                stmt.setInt(1, productId);
                stmt.setDate(2, java.sql.Date.valueOf(formattedDate));
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteQuan(int quantity) {
        String query = "DELETE FROM orders WHERE order_id IN (" +
                "SELECT order_id FROM order_items WHERE quantity = ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, quantity);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}