package task13;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.bahanov.pracJava.task13.OrderQuery;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DBTest {

    private OrderQuery orderQuery;

    @BeforeEach
    void setUp() {
        orderQuery = new OrderQuery();
    }

    @Test
    void testPrintOrderDetails() {
        assertDoesNotThrow(() -> orderQuery.printOrderDetails(1));
    }

    @Test
    void testGetCrit() {
        List<Integer> orders = orderQuery.getCrit(100.0, 2);
        assertNotNull(orders);
    }

    @Test
    void testGetOrderCurr() {
        List<Integer> orders = orderQuery.getOrderCurr("Product Name");
        assertNotNull(orders);
    }

    @Test
    void testGetOrderToday() {
        LocalDate today = LocalDate.now();
        List<Integer> orders = orderQuery.getOrderToday(1, java.sql.Date.valueOf(today));
        assertNotNull(orders);
    }

    @Test
    void testCreateNewOrder() {
        LocalDate today = LocalDate.now();
        assertDoesNotThrow(() -> orderQuery.createNewOrder(java.sql.Date.valueOf(today)));
    }

    @Test
    void testDeleteQuan() {
        assertDoesNotThrow(() -> orderQuery.deleteQuan(5));
    }
}
