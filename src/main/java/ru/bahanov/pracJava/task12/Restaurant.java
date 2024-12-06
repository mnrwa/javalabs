package ru.bahanov.pracJava.task12;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import java.util.concurrent.*;

public class Restaurant {
    private final List<CashRegister> cashRegisters;
    private final List<Customer> customers;

    public Restaurant(int numberOfCashRegisters) {
        cashRegisters = new ArrayList<>();
        customers = new ArrayList<>();

        for (int i = 0; i < numberOfCashRegisters; i++) {
            cashRegisters.add(new CashRegister());
        }
    }

    public List<CashRegister> getCashRegisters() {
        return cashRegisters;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
        customer.getCashRegister().addCustomerToQueue(customer);
    }

    public void serveCustomers() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(customers.size());  // Синхронизация для ожидания завершения всех клиентов
        ExecutorService executorService = Executors.newFixedThreadPool(cashRegisters.size());

        // Обслуживание каждого клиента в отдельном потоке
        for (Customer customer : customers) {
            executorService.submit(() -> {
                try {
                    CashRegister register = customer.getCashRegister();
                    System.out.println("Обслуживаем клиента " + customer.getName() + " на кассе " + register);
                    register.serve(customer); // Обслуживаем клиента
                } finally {
                    latch.countDown(); // Уменьшаем счетчик после обслуживания
                }
            });
        }

        executorService.shutdown();
        latch.await();
    }

    public void stop() {
    }
}
