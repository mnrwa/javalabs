package ru.bahanov.pracJava.task10.B;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Necklace necklace = new Necklace();

        necklace.addGem(new PreciousGem("Алмаз", 1.5, 5000, 95.0));
        necklace.addGem(new SemiPreciousGem("Топаз", 3.0, 300, 85.0));
        necklace.addGem(new PreciousGem("Изумруд", 2.0, 4000, 90.0));
        necklace.addGem(new SemiPreciousGem("Аметист", 1.2, 200, 80.0));

        System.out.println("Исходное ожерелье:");
        System.out.println(necklace);

        String filePath = "necklace.dat";
        try {
            NecklaceConnector.saveNecklace(necklace, filePath);
        } catch (IOException e) {
            System.out.println("Ошибка сохранения ожерелья: " + e.getMessage());
        }

        try {
            Necklace loadedNecklace = NecklaceConnector.loadNecklace(filePath);
            System.out.println("Загруженное ожерелье:");
            System.out.println(loadedNecklace);

            System.out.printf("Общий вес: %.2f карат%n", loadedNecklace.getTotalWeight());
            System.out.printf("Общая стоимость: %.2f%n", loadedNecklace.getTotalPrice());

            loadedNecklace.sortByPrice();
            System.out.println("Ожерелье после сортировки по цене:");
            System.out.println(loadedNecklace);

            System.out.println("Камни с прозрачностью от 80% до 95%:");
            for (Gem gem : loadedNecklace.findGemsByTransparency(80, 95)) {
                System.out.println(gem);
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка загрузки ожерелья: " + e.getMessage());
        }
    }
}
