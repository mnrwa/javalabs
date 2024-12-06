package ru.bahanov.pracJava.task12;


public class Customer {
    private final String name;
    private final CashRegister cashRegister;

    public Customer(String name, CashRegister cashRegister) {
        this.name = name;
        this.cashRegister = cashRegister;
    }

    public String getName() {
        return name;
    }

    public CashRegister getCashRegister() {
        return cashRegister;
    }
}
