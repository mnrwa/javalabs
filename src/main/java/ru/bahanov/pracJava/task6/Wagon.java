package ru.bahanov.pracJava.task6;

public interface Wagon {
    String getRegNumber();
    void setRegNumber(String regNumber);

    String getDestination();
    void setDestination(String destination);

    String getOwner();
    void setOwner(String owner);

    String getStatus();
    void setStatus(String status);

    double getTareWeight();

    void sendToDestination();
    void service();
    void repair();
    void load();
    void unload();

    boolean isCargoFragile();
    boolean isCargoValuable();

    int getPassengerCapacity();

    void setPassengerCapacity(int passengerCapacity);
}


