package ru.bahanov.pracJava.task10.A;

import java.io.*;

public class A {

    public static void main(String[] args) {
        String inputFilePath = "D:\\prac\\prac1\\src\\main\\java\\ru\\bahanov\\pracJava\\task10\\data.txt";
        String[] wordList = {"жизнь", "Когда", "ты", "весна", "солнце"};
        int[] frequencies = new int[wordList.length];

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().replaceAll("[^а-яё\\s]", "").split("\\s+");
                for (String word : words) {
                    for (int i = 0; i < wordList.length; i++) {
                        if (word.equals(wordList[i])) {
                            frequencies[i]++;
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
            return;
        }

        System.out.println("Частота слов:");
        for (int i = 0; i < wordList.length; i++) {
            System.out.println(wordList[i] + ": " + frequencies[i]);
        }
    }
}
