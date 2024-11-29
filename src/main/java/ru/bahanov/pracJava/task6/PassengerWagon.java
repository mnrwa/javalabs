package ru.bahanov.pracJava.task6;

public class PassengerWagon implements Wagon{
    private String regNumer;
    private String destination;
    private String owner;
    private String status;
    private double tareWeight;
    private int passengerCapacity;


    @Override
    public String getRegNumber() {
        return regNumer;
    }

    @Override
    public void setRegNumber(String regNumber) {
        this.regNumer = regNumber;
    }

    @Override
    public String getDestination() {
        return destination;
    }

    @Override
    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String getOwner() {
        return owner;
    }

    @Override
    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public void setStatus(String status) {
        this.status=status;
    }

    @Override
    public double getTareWeight() {
        return tareWeight;
    }

    @Override
    public void sendToDestination() {
        this.status = "В пути!";
    }

    @Override
    public void service() {
        this.status="Готов!";
    }

    @Override
    public void repair() {
        this.status = "В ремонте!";
    }

    @Override
    public void load() {
        this.status = "Посадка пассажиров!";
    }

    @Override
    public void unload() {
        this.status = "Высадка пассажиров!";
    }

    @Override
    public boolean isCargoFragile() {
        return false;
    }

    @Override
    public boolean isCargoValuable() {
        return false;
    }

    @Override
    public int getPassengerCapacity(){
        return passengerCapacity;
    }

    @Override
    public void setPassengerCapacity(int passengerCapacity){
        this.passengerCapacity = passengerCapacity;
    }
}
