package ru.bahanov.pracJava.task13;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderQuery {

    private Connection connection;

    public OrderQuery() {
        try {
            this.connection = DBConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 1. Полная информация о заданном заказе
    public List<OrderDetail> getOrderDetails(int orderId) {
        String query = "SELECT o.order_id, o.date_order, " +
                "p.product_id, p.name, p.description, p.price, " +
                "oi.quantity, (p.price * oi.quantity) AS total_price " +
                "FROM orders o " +
                "JOIN order_items oi ON o.order_id = oi.order_id " +
                "JOIN products p ON oi.product_id = p.product_id " +
                "WHERE o.order_id = ?";

        List<OrderDetail> orderDetails = new ArrayList<>();

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, orderId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                OrderDetail detail = new OrderDetail(
                        rs.getInt("order_id"),
                        rs.getDate("date_order"),
                        rs.getInt("product_id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getInt("quantity"),
                        rs.getDouble("total_price")
                );
                orderDetails.add(detail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderDetails;
    }

    // 2. Заказы с суммой <= заданной и количеством товаров = заданному
    public List<Integer> getCrit(double minCount, int itemCount) {
        String query = "SELECT o.order_id " +
                "FROM orders o " +
                "JOIN order_items oi ON o.order_id = oi.order_id " +
                "JOIN products p ON oi.product_id = p.product_id " +
                "GROUP BY o.order_id " +
                "HAVING SUM(p.price * oi.quantity) > ? AND COUNT(oi.product_id) = ?";

        List<Integer> orders = new ArrayList<>();

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setDouble(1, minCount);
            stmt.setInt(2, itemCount);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                orders.add(rs.getInt("order_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    // 3. Заказы, содержащие заданный товар
    public List<Integer> getOrderCurr(String name) {
        String query = "select product_id from products where name = ?";
        List<Integer> prod = new ArrayList<>();
        int idProd = 0;

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                idProd = rs.getInt("product_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //System.out.println(idProd);

        String query1 = "select order_id from orders where product_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query1)) {
            statement.setInt(1, idProd);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                prod.add(rs.getInt("order_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prod;
    }
        /*List<Integer> orders = new ArrayList<>();

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                orders.add(rs.getInt("order_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }*/

    // 4. Заказы, не содержащие заданный товар и поступившие сегодня
    public List<Integer> getOrderToday(int productId, Date date) {
        String query = "SELECT order_id " +
                "FROM orders " +
                "WHERE date_order = ? " +
                "AND NOT product_id = ?";

        List<Integer> orders = new ArrayList<>();

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setDate(1, new java.sql.Date(date.getTime()));
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
    public List<Integer> createNewOrder(Date date) {
        String query = "SELECT product_id FROM orders WHERE date_order = ?";
        List<Integer> newProducts = new ArrayList<>();
        List<Integer> newOrderIds = new ArrayList<>();

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setDate(1, new java.sql.Date(date.getTime()));
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                newProducts.add(rs.getInt("product_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String createNewOrder = "INSERT INTO orders (product_id, date_order) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(createNewOrder, Statement.RETURN_GENERATED_KEYS)) {
            for (Integer productId : newProducts) {
                stmt.setInt(1, productId);
                stmt.setDate(2, new java.sql.Date(date.getTime()));
                stmt.executeUpdate();

                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        newOrderIds.add(generatedKeys.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return newOrderIds;
    }

    public void deleteQuan(int quantity) {
        String query = "DELETE FROM orders WHERE order_id IN (" +
                "SELECT order_id FROM order_items WHERE quantity = ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, quantity);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}