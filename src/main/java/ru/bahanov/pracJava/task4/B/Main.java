package ru.bahanov.pracJava.task4.B;

import ru.bahanov.pracJava.task4.B.models.PreciousGem;
import ru.bahanov.pracJava.task4.B.models.SemiPreciousGem;
import ru.bahanov.pracJava.task4.B.services.Necklace;

public class Main {
    public static void main(String[] args) {
        Necklace necklace = new Necklace();

        necklace.addGem(new PreciousGem("Алмаз", 1.2, 5000, 90));
        necklace.addGem(new SemiPreciousGem("Аметист", 2.5, 300, 70));

        System.out.println("Ожерелье содержит:");
        necklace.printGems();

        System.out.println("\nОбщий вес: " + necklace.calcTotalGramm() + " карат");
        System.out.println("Общая стоимость: " + necklace.calcTotalPrice() + " USD");
    }
}
