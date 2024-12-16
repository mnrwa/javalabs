package ru.bahanov.pracJava.task12;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CashRegister {
    private final Queue<Customer> queue = new LinkedList<>();
    private static int registerCounter = 1;
    private final int registerId;
    private final Lock lock = new ReentrantLock();
    private static final Random random = new Random(); // Генератор случайных чисел

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

    // Обслуживание клиента с рандомной задержкой
    public void serve(Customer customer) {
        lock.lock();
        try {
            queue.remove(customer);
            System.out.println("Начинаем обслуживание клиента " + customerCounter + ": " + customer.getName() + " на " + this);

            // Симуляция времени обслуживания от 1 до 5 секунд
            int delay = 1000 + random.nextInt(4000);
            Thread.sleep(delay);

            System.out.println("Завершено обслуживание клиента " + customerCounter + ": " + customer.getName() +
                    " на " + this + " (время: " + delay + " мс)");
            customerCounter++;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Восстанавливаем флаг прерывания
            System.out.println("Обслуживание клиента прервано");
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
