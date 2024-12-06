package ru.bahanov.pracJava.task10.B;

import java.io.Serializable;

public abstract class Gem implements Serializable {
    private String name;
    private double weight;
    private double price;
    private double transparency;

    public Gem(String name, double weight, double price, double transparency) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.transparency = transparency;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    public double getTransparency() {
        return transparency;
    }

    public double getTotalValue() {
        return weight * price;
    }

    @Override
    public String toString() {
        return String.format("%s: вес=%.2f карат, цена=%.2f за карат, прозрачность=%.2f%%, общая стоимость=%.2f",
                name, weight, price, transparency, getTotalValue());
    }
}

