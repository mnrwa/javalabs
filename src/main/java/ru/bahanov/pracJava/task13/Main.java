package ru.bahanov.pracJava.task13;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        OrderQuery queries = new OrderQuery();
        OrderModification modifications = new OrderModification();

        // Вывод полной информации о заказе
        System.out.println("Полная информация о заказе:");
        queries.printOrderDetails(1);

        // Получение заказов с заданным товаром
        System.out.println("\nЗаказы с товаром ID 2:");
        List<Integer> ordersWithProduct = queries.getOrdersContainingProduct(2);
        System.out.println(ordersWithProduct);


        // Удаление заказов с товаром ID 2 и количеством 5
        System.out.println("\nУдаление заказов с товаром ID 2 и количеством 5:");
        modifications.deleteOrdersWithProductQuantity(2, 5);
    }
}