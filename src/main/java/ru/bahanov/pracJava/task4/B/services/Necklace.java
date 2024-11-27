package ru.bahanov.pracJava.task4.B.services;

import ru.bahanov.pracJava.task4.B.models.Gem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Necklace {
    List<Gem> gems = new ArrayList<>();

    public void addGem(Gem gem){
        gems.add(gem);
    }

    public double calcTotalGramm(){
        double totalWeight = 0.0;
        for (Gem gem : gems) {
            totalWeight += gem.getGramme();
        }
        return totalWeight;
    }

    public double calcTotalPrice(){
        double totalPrice = 0.0;
        for(Gem gem : gems){
            totalPrice += gem.getPrice();
        }
        return totalPrice;
    }

    public void sortByPrice(){
        int n = gems.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (gems.get(j).getPrice() < gems.get(j + 1).getPrice()) {
                    Gem temp = gems.get(j);
                    gems.set(j, gems.get(j + 1));
                    gems.set(j + 1, temp);
                }
            }
        }
    }

    public List<Gem> findGemsByTransparencyRange(int min, int max) {
        List<Gem> result = new ArrayList<>();
        for (Gem gem : gems) {
            if (gem.getTransparency() >= min && gem.getTransparency() <= max) {
                result.add(gem);
            }
        }
        return result;
    }

    public void printGems() {
        for (Gem gem : gems) {
            System.out.println(gem);
        }
    }

}
