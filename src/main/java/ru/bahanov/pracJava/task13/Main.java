package ru.bahanov.pracJava.task13;

import java.sql.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        OrderQuery queries = new OrderQuery();

        System.out.println("Полная информация о заказе:");
        List<OrderDetail> orderDetails = queries.getOrderDetails(2);
        for (OrderDetail detail : orderDetails) {
            System.out.println(detail);
        }
        List<Integer> ordersWithCriteria = queries.getCrit(10, 2);
        System.out.println("Номера заказов с заданными условиями: " + ordersWithCriteria);

        System.out.println("\nЗаказы с товаром Мышь:");
        List<Integer> ordersWithProduct = queries.getOrderCurr("Мышь");
        System.out.println(ordersWithProduct);

        System.out.println("\nЗаказы без товара ID 2 и поступившие 2024-01-02:");
        List<Integer> ordersExcludingProductToday = queries.getOrderToday(2, Date.valueOf("2024-01-02"));
        System.out.println(ordersExcludingProductToday);

        System.out.println("\nСоздание нового заказа из сегодняшних товаров:");
        System.out.println(queries.createNewOrder(Date.valueOf("2024-01-02")));

        System.out.println("\nУдаление заказов количеством 1:");
        queries.deleteQuan(1);
    }
}