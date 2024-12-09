package ru.bahanov.pracJava.task6;

public class Main {
    public static void main(String[] args) {
        ForeightWagon foreightWagon = new ForeightWagon();

        foreightWagon.setRegNumber("X12-1");
        foreightWagon.setDestination("Владивосток");
        foreightWagon.setOwner("РЖД");
        foreightWagon.setStatus("В пути");
        foreightWagon.setFragileCargo(true);

        System.out.println("Грузовой вагон:");
        System.out.println("Регистрационный номер: " + foreightWagon.getRegNumber());
        System.out.println("Пункт назначения: " + foreightWagon.getDestination());
        System.out.println("Владелец: " + foreightWagon.getOwner());
        System.out.println("Статус: " + foreightWagon.getStatus());
        System.out.println("Хрупкий груз: " + (foreightWagon.isCargoFragile() ? "Да" : "Нет"));

        foreightWagon.service();
        System.out.println("Статус после обслуживания: " + foreightWagon.getStatus());

        PassengerWagon passengerWagon = new PassengerWagon();
        passengerWagon.setRegNumber("021-1");
        passengerWagon.setDestination("Москва");
        passengerWagon.setOwner("РЖД");
        passengerWagon.setStatus("Готов к отправке!");
        passengerWagon.setPassengerCapacity(40);

        System.out.println("Пассажирский вагон:");
        System.out.println("Регистрационный номер: " + passengerWagon.getRegNumber());
        System.out.println("Пункт назначения: " + passengerWagon.getDestination());
        System.out.println("Владелец: " + passengerWagon.getOwner());
        System.out.println("Статус: " + passengerWagon.getStatus());
        System.out.println("Вместимость пассажиров: " + passengerWagon.getPassengerCapacity());

        passengerWagon.load();
        System.out.println("Статус после загрузки: " + passengerWagon.getStatus());
    }
}
