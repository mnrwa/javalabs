package ru.bahanov.pracJava.task10.B;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Necklace implements Serializable {
    private List<Gem> gems = new ArrayList<>();

    public void addGem(Gem gem) {
        gems.add(gem);
    }

    public double getTotalWeight() {
        return gems.stream().mapToDouble(Gem::getWeight).sum();
    }

    public double getTotalPrice() {
        return gems.stream().mapToDouble(Gem::getTotalValue).sum();
    }

    public List<Gem> findGemsByTransparency(double min, double max) {
        List<Gem> result = new ArrayList<>();
        for (Gem gem : gems) {
            if (gem.getTransparency() >= min && gem.getTransparency() <= max) {
                result.add(gem);
            }
        }
        return result;
    }

    public void sortByPrice() {
        gems.sort((g1, g2) -> Double.compare(g1.getTotalValue(), g2.getTotalValue()));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Ожерелье состоит из камней:\n");
        for (Gem gem : gems) {
            sb.append(gem).append("\n");
        }
        return sb.toString();
    }
}
