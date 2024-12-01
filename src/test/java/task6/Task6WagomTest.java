package task6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.bahanov.pracJava.task6.ForeightWagon;

import static org.junit.jupiter.api.Assertions.*;

class ForeightWagonTest {
    private ForeightWagon wagon;

    @BeforeEach
    void setUp() {
        wagon = new ForeightWagon();
    }

    @Test
    void testRegistrationNumber() {
        wagon.setRegNumber("FW123");
        assertEquals("FW123", wagon.getRegNumber(), "Регистрационный номер должен быть FW123");
    }

    @Test
    void testSetAndGetDestination() {
        wagon.setDestination("Москва");
        assertEquals("Москва", wagon.getDestination(), "Пункт назначения должен быть Москва");
    }

    @Test
    void testSetAndGetOwner() {
        wagon.setOwner("РЖД");
        assertEquals("РЖД", wagon.getOwner(), "Владелец должен быть РЖД");
    }

    @Test
    void testLoad() {
        wagon.load();
        assertEquals("Загрузка", wagon.getStatus(), "Статус должен быть 'Загрузка' после вызова load()");
    }

    @Test
    void testUnload() {
        wagon.unload();
        assertEquals("Разгрузка", wagon.getStatus(), "Статус должен быть 'Разгрузка' после вызова unload()");
    }

    @Test
    void testService() {
        wagon.service();
        assertEquals("Готов!", wagon.getStatus(), "Статус должен быть 'Готов!' после вызова service()");
    }

    @Test
    void testRepair() {
        wagon.repair();
        assertEquals("В ремонте", wagon.getStatus(), "Статус должен быть 'В ремонте' после вызова repair()");
    }

    @Test
    void testCargoFragile() {
        wagon.setFragileCargo(true);
        assertTrue(wagon.isCargoFragile(), "Груз должен быть хрупким");
    }

    @Test
    void testCargoValuable() {
        wagon.setValuableCargo(true);
        assertTrue(wagon.isCargoValuable(), "Груз должен быть ценным");
    }
}
