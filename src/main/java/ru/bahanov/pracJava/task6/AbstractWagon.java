package ru.bahanov.pracJava.task6;

public abstract class AbstractWagon implements Wagon {
    protected String regNumber;
    protected String destination;
    protected String owner;
    protected String status;
    protected double tareWeight;

    @Override
    public String getRegNumber() {
        return regNumber;
    }

    @Override
    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
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
}
