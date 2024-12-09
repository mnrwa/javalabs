package ru.bahanov.pracJava.task6;

public class ForeightWagon extends AbstractWagon {
    private boolean fragileCargo;
    private boolean valuableCargo;

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

    public void setValuableCargo(boolean valuableCargo) {
        this.valuableCargo = valuableCargo;
    }

    @Override
    public int getPassengerCapacity() {
        return 0;
    }

    @Override
    public void setPassengerCapacity(int passengerCapacity) {
        throw new UnsupportedOperationException("Грузовой вагон не поддерживает пассажиров.");
    }
}
