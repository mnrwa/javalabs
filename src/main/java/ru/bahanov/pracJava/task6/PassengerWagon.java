package ru.bahanov.pracJava.task6;

public class PassengerWagon extends AbstractWagon {
    private int passengerCapacity;

    @Override
    public boolean isCargoFragile() {
        return false;
    }

    @Override
    public boolean isCargoValuable() {
        return false;
    }

    @Override
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    @Override
    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public void load() {
        this.status = "Посадка пассажиров!";
    }

    @Override
    public void unload() {
        this.status = "Высадка пассажиров!";
    }
}
