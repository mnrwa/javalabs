package task12;

import org.junit.jupiter.api.*;
import ru.bahanov.pracJava.task12.CashRegister;
import ru.bahanov.pracJava.task12.Customer;
import ru.bahanov.pracJava.task12.Restaurant;

import java.util.concurrent.*;
import static org.junit.jupiter.api.Assertions.*;

class RestaurantTest {

    @Test
    void testCustomerQueuesAndServing() throws InterruptedException, ExecutionException, TimeoutException {
        Restaurant restaurant = new Restaurant(3);

        // Добавляем клиентов в очереди
        for (int i = 0; i < 10; i++) {
            restaurant.addCustomer(new Customer("Клиент " + (i + 1), restaurant.getCashRegisters().get(i % 3)));
        }

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Void> future = executorService.submit(() -> {
            try {
                restaurant.serveCustomers();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        });

        future.get(10, TimeUnit.SECONDS);

        restaurant.stop();

        // Проверяем, что все очереди пусты после обслуживания
        for (CashRegister register : restaurant.getCashRegisters()) {
            assertEquals(0, register.queueSize(), "Очередь должна быть пустой после обслуживания");
        }

        executorService.shutdown();
    }

    @Test
    void testNoCustomerWaitingAfterServing() throws InterruptedException {
        Restaurant restaurant = new Restaurant(2);

        // Добавляем клиентов
        restaurant.addCustomer(new Customer("Клиент 1", restaurant.getCashRegisters().get(0)));
        restaurant.addCustomer(new Customer("Клиент 2", restaurant.getCashRegisters().get(1)));

        // Обслуживаем клиентов
        restaurant.serveCustomers();

        // Проверяем, что обе кассы освободились после обслуживания
        assertTrue(restaurant.getCashRegisters().get(0).queueSize() == 0, "Очередь кассы 1 должна быть пустой");
        assertTrue(restaurant.getCashRegisters().get(1).queueSize() == 0, "Очередь кассы 2 должна быть пустой");

        restaurant.stop();
    }

    @Test
    void testNoOvercrowdingAtCashRegisters() throws InterruptedException {
        Restaurant restaurant = new Restaurant(2);

        for (int i = 0; i < 5; i++) {
            restaurant.addCustomer(new Customer("Клиент " + (i + 1), restaurant.getCashRegisters().get(i % 2)));
        }

        restaurant.serveCustomers();

        for (CashRegister register : restaurant.getCashRegisters()) {
            assertTrue(register.queueSize() <= 3, "Очередь в каждой кассе не должна превышать 3 клиента");
        }

        restaurant.stop();
    }
}
