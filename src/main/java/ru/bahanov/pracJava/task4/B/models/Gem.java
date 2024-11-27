package ru.bahanov.pracJava.task4.B.models;

public abstract class Gem {
    private String name;
    private double gramme;
    private double price;
    private int trancparency;

    public Gem(String name, double gramme, double price, int trancparency){
        this.name = name;
        this.gramme = gramme;
        this.price = price;
        this.trancparency = trancparency;
    }

    public double getGramme() {
        return gramme;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return "Gem{name= "+name+", gramme= "+gramme+", price= "+price+", trancparency="+ trancparency+"%}";
    }

    public int getTransparency() {
        return trancparency;
    }


}

