package ru.bahanov.pracJava.task6;

public class ForeightWagon implements Wagon {
    private String regNumber;
    private String destination;
    private String owner;
    private String status;
    private double tareWeight;
    private boolean fragileCargo;
    private boolean valuableCargo;
    private int passengerCapacity;

    @Override
    public String getRegNumber() {
        return regNumber;
    }

    @Override
    public void setRegNumber(String regNumber) {
        this.regNumber=regNumber;
    }

    @Override
    public String getDestination(){
        return destination;
    }

    @Override
    public void setDestination(String destination){
        this.destination=destination;
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
        this.status = status;
    }

    @Override
    public double getTareWeight() {
        return tareWeight;
    }

    @Override
    public void sendToDestination() {
        this.status = "В пути";
    }

    @Override
    public void service() {
        this.status = "Готов!";
    }

    @Override
    public void repair() {
        this.status = "В ремонте";
    }

    @Override
    public void load() {
        this.status = "Загрузка";
    }

    @Override
    public void unload() {
        this.status = "Разгрузка";
    }

    @Override
    public boolean isCargoFragile() {
        return fragileCargo;
    }

    public void setFragileCargo(boolean fragileCargo) {
        this.fragileCargo = fragileCargo;
    }

    @Override
    public boolean isCargoValuable() {
        return valuableCargo;
    }

    @Override
    public int getPassengerCapacity() {
        return 0;
    }

    @Override
    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public void setValuableCargo(boolean valuableCargo) {
        this.valuableCargo = valuableCargo;
    }
}
