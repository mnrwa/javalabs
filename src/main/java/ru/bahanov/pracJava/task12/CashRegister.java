package ru.bahanov.pracJava.task12;

import java.util.LinkedList;
import java.util.Queue;

public class CashRegister {
    private final Queue<Customer> queue = new LinkedList<>();
    private static int registerCounter = 1;
    private final int registerId;

    public CashRegister() {
        this.registerId = registerCounter++;
    }

    public void addCustomerToQueue(Customer customer) {
        queue.add(customer);
        System.out.println(customer.getName() + " встал в очередь на " + this);
    }

    private static int customerCounter = 1;

    // Обслуживание клиента
    public void serve(Customer customer) {
        synchronized (this) {  // Защищаем очередь кассы
            queue.remove(customer);  // Убираем клиента из очереди
        }
        // Выводим информацию о обслуживаемом клиенте
        System.out.println("Обслуживаем клиента " + customerCounter + ": " + customer.getName() + " на " + this);
        customerCounter++;  // Увеличиваем счетчик для следующего клиента
    }

    @Override
    public String toString() {
        return "Касса " + registerId;
    }

    public int queueSize() {
        return queue.size();
    }
}
