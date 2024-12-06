package ru.bahanov.pracJava.task11.B;

public class ParkingLot {
    private boolean[] parkingSpaces;

    public ParkingLot(int size) {
        parkingSpaces = new boolean[size];
    }

    public boolean parkCar() {
        for (int i = 0; i < parkingSpaces.length; i++) {
            if (!parkingSpaces[i]) {
                parkingSpaces[i] = true;
                System.out.println("Машина припарковалась на место: " + (i + 1));
                return true;
            }
        }
        System.out.println("Нет свободных мест для парковки.");
        return false;
    }

    public boolean removeCar(int spot) {
        if (spot < 1 || spot > parkingSpaces.length) {
            System.out.println("Неверный номер места.");
            return false;
        }
        int index = spot - 1;
        if (parkingSpaces[index]) {
            parkingSpaces[index] = false;
            System.out.println("Машина уехала с места: " + spot);
            return true;
        } else {
            System.out.println("Место уже свободно.");
            return false;
        }
    }

    public void printParkingStatus() {
        for (int i = 0; i < parkingSpaces.length; i++) {
            System.out.print("Место " + (i + 1) + ": ");
            if (parkingSpaces[i]) {
                System.out.println("Занято");
            } else {
                System.out.println("Свободно");
            }
        }
    }

    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(5);

        parkingLot.parkCar();
        parkingLot.parkCar();
        parkingLot.parkCar();
        parkingLot.printParkingStatus();

        parkingLot.removeCar(2);
        parkingLot.printParkingStatus();
    }

    public boolean[] getParkingStatus() {
        return parkingSpaces;
    }

}
