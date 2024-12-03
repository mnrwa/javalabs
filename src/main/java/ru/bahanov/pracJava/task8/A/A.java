package ru.bahanov.pracJava.task8.A;

import java.util.Scanner;

/* sample text
Ни одно доброе дело, каким бы маленьким оно ни было, никогда не бывает напрасным
*/

public class A {

    public static String processText(String input, char symbol, int position, int choice) {
        if (choice == 0) {
            return input.replace(Character.toString(symbol), "");
        } else if (choice == 1 && position < input.length()) {
            return input.substring(0, position + 1) + symbol + input.substring(position + 1);
        }
        return input;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите текст:");
        String[] textLines = scanner.nextLine().split("\\n");
        System.out.println("Введите признак (0 - удалить символ, 1 - вставить символ):");
        int choice = scanner.nextInt();
        System.out.println("Введите символ:");
        char symbol = scanner.next().charAt(0);
        int k = 0;

        if (choice == 1) {
            System.out.println("Введите позицию (k):");
            k = scanner.nextInt();
        }

        for (int i = 0; i < textLines.length; i++) {
            if (choice == 0) {
                textLines[i] = textLines[i].replace(Character.toString(symbol), "");
            } else if (choice == 1 && k < textLines[i].length()) {
                textLines[i] = textLines[i].substring(0, k + 1) + symbol + textLines[i].substring(k + 1);
            }
        }


        System.out.println("Результат:");
        for (String line : textLines) {
            System.out.println(line);
        }

        scanner.close();
    }
}