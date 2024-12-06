package task11.B;

import org.junit.jupiter.api.*;
import ru.bahanov.pracJava.task11.B.ParkingLot;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ParkingLotTest {

    private ParkingLot parkingLot;

    @BeforeEach
    void setUp() {
        parkingLot = new ParkingLot(5);
    }

    @Test
    void testParkCar() {
        assertTrue(parkingLot.parkCar(), "Машина должна припарковаться");
        assertTrue(parkingLot.parkCar(), "Машина должна припарковаться");
        assertTrue(parkingLot.parkCar(), "Машина должна припарковаться");
    }

    @Test
    void testParkCarWhenFull() {
        parkingLot.parkCar();
        parkingLot.parkCar();
        parkingLot.parkCar();
        parkingLot.parkCar();
        parkingLot.parkCar();

        assertFalse(parkingLot.parkCar(), "Не должно быть свободных мест для парковки");
    }

    @Test
    void testRemoveCar() {
        parkingLot.parkCar();
        assertTrue(parkingLot.removeCar(1), "Машина должна уехать с места 1");
    }

    @Test
    void testRemoveCarWhenAlreadyFree() {
        assertFalse(parkingLot.removeCar(1), "Место должно быть свободно, так как нет машины");
    }

    @Test
    void testRemoveCarWithInvalidSpot() {
        assertFalse(parkingLot.removeCar(6), "Неверный номер места, должно быть возвращено false");
    }

    @Test
    void testParkingLotStatus() {
        parkingLot.parkCar();
        parkingLot.parkCar();
        parkingLot.parkCar();

        assertEquals("Место 1 должно быть занято", parkingLot.getParkingStatus()[0], true);
        assertEquals("Место 2 должно быть занято", parkingLot.getParkingStatus()[1], true);
        assertEquals("Место 3 должно быть занято", parkingLot.getParkingStatus()[2], true);
        assertEquals("Место 4 должно быть свободно", parkingLot.getParkingStatus()[3], false);
        assertEquals("Место 5 должно быть свободно", parkingLot.getParkingStatus()[4], false);
    }
}
