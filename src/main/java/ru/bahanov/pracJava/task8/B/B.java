package ru.bahanov.pracJava.task8.B;

import java.util.*;

class B {
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
        String inputText = "Влюбленность начинается с того, что человек обманывает себя, а кончается тем, что он обманывает другого.";

        inputText = inputText.replaceAll("\\s+", " ").trim();

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
