package ru.bahanov.pracJava.task13;

import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        OrderQuery queries = new OrderQuery();
        OrderModification modifications = new OrderModification();

        Connection conn1 = DBConnection.getConnection();
        Connection conn2 = DBConnection.getConnection();

        System.out.println(conn1 == conn2);

        System.out.println("Полная информация о заказе:");
        queries.printOrderDetails(1);

        System.out.println("\nЗаказы с товаром ID 2:");
        List<Integer> ordersWithProduct = queries.getOrdersContainingProduct(2);
        System.out.println(ordersWithProduct);

        DBConnection.closeConnection();
    }
}

