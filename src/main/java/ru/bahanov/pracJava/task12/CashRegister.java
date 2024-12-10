package ru.bahanov.pracJava.task12;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CashRegister {
    private final Queue<Customer> queue = new LinkedList<>();
    private static int registerCounter = 1;
    private final int registerId;
    private final Lock lock = new ReentrantLock(); // Блокировка вместо synchronized

    public CashRegister() {
        this.registerId = registerCounter++;
    }

    public void addCustomerToQueue(Customer customer) {
        lock.lock();
        try {
            queue.add(customer);
            System.out.println(customer.getName() + " встал в очередь на " + this);
        } finally {
            lock.unlock();
        }
    }

    private static int customerCounter = 1;

    // Обслуживание клиента
    public void serve(Customer customer) {
        lock.lock();
        try {
            queue.remove(customer);
            System.out.println("Обслуживаем клиента " + customerCounter + ": " + customer.getName() + " на " + this);
            customerCounter++;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        return "Касса " + registerId;
    }

    public int queueSize() {
        return queue.size();
    }
}
