package ru.bahanov.pracJava.task12;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Restaurant restaurant = new Restaurant(3); // 3 кассы в ресторане

        for (int i = 0; i < 10; i++) {
            restaurant.addCustomer(new Customer("Клиент " + (i + 1), restaurant.getCashRegisters().get(i % 3)));
        }

        restaurant.serveCustomers();

        restaurant.stop();
    }
}