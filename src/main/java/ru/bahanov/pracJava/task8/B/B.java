package ru.bahanov.pracJava.task8.B;

import java.util.*;

public class B {

    public static String cleanText(String input) {
        return input.replaceAll("\\s+", " ").trim();
    }

    public static List<String> sortWords(List<String> words) {
        words.sort(Comparator.comparing(word -> Character.toLowerCase(word.charAt(0))));
        return words;
    }

    static class Word {
        String word;

        Word(String word) {
            this.word = word;
        }

        public char getFirstLetter() {
            return Character.toLowerCase(word.charAt(0));
        }

        @Override
        public String toString() {
            return word;
        }
    }

    public static void main(String[] args) {
        String inputText = "Ни одно доброе дело, каким бы маленьким оно ни было, никогда не бывает напрасным";

        inputText = cleanText(inputText);

        String[] wordsArray = inputText.split("[\\s.,;!?]+");
        List<Word> words = new ArrayList<>();

        for (String w : wordsArray) {
            words.add(new Word(w));
        }

        words.sort(Comparator.comparing(Word::getFirstLetter));

        char currentLetter = '\0';
        for (Word word : words) {
            if (word.getFirstLetter() != currentLetter) {
                currentLetter = word.getFirstLetter();
                System.out.println();
            }
            System.out.println(word);
        }
    }
}
