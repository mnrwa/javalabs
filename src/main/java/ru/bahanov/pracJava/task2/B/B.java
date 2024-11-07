package ru.bahanov.pracJava.task2.B;

import ru.bahanov.pracJava.task2.A.A;
import ru.bahanov.pracJava.task2.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class B {
    public void tableMult() {
        System.out.print("    |");
        for (int j = 1; j < 10; j++) {
            System.out.printf("%4d", j);
        }
        System.out.println();
        System.out.println("----+------------------------------------");

        for (int i = 1; i < 10; i++) {
            System.out.printf("%3d |", i);
            for (int j = 1; j < 10; j++) {
                System.out.printf("%4d", i * j);
            }
            System.out.println();
        }
        System.out.println();
    }

    public List<Integer> loadArr() {
        List<Integer> arr = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            arr.add(random.nextInt(1, 100));
        }
        return arr;
    }

    public void intervalCheck() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите значение n: ");
        int n = sc.nextInt();
        System.out.print("Введите значение m: ");
        int m = sc.nextInt();
        System.out.print("Введите значение k: ");
        int k = sc.nextInt();

        boolean a = k > n && k < m;
        boolean b = k > n && k <= m;
        boolean c = k >= n && k < m;
        boolean d = k >= n && k <= m;

        if (a) {
            System.out.println("k принадлежит интервалу (" + n + ", " + m + "]");
        } else if (b) {
            System.out.println("k принадлежит интервалу [" + n + ", " + m + ")");
        } else if (c) {
            System.out.println("k принадлежит интервалу (" + n + ", " + m + ")");
        } else if (d) {
            System.out.println("k принадлежит интервалу [" + n + ", " + m + "]");
        } else {
            System.out.println("k не принадлежит ни одному из интервалов (" + n + ", " + m + ")");
        }
    }

    public void splitOnThree() {
        System.out.println("Числа, которые делятся на 3 без остатка: ");
        for (int i = 1; i < 100; i++) {
            if (i % 3 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public void sixQues(int numb, int base) {
        int ans = 0;
        String numStr = String.valueOf(numb);
        int len = numStr.length();

        for (int i = 0; i < len; i++) {
            int digit = Character.getNumericValue(numStr.charAt(i));
            ans += digit * Math.pow(base, len - i - 1);
        }

        System.out.println("Результат: " + ans);
    }

    public void convertSystem() {
        System.out.println("Напишите число в 10сс: ");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        System.out.println("Введите сс, в которую вы хотите перевести число " + number + ": ");
        int base = sc.nextInt();

        StringBuilder ans = new StringBuilder();

        while (number > 0) {
            int temp = number % base;
            if (temp < 10) {
                ans.append((char) ('0' + temp));
            } else {
                ans.append((char) ('A' + (temp - 10)));
            }
            number /= base;
        }
        System.out.println("Результат: " + ans);
    }

    public void convertAnySys() {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Введите число для конвертации: ");
            String numb = sc.nextLine();

            System.out.print("Введите исходную систему счисления");
            int base = sc.nextInt();

            System.out.print("Введите конечную систему счисления  ");
            int targetBase = sc.nextInt();

            int decimalValue = Integer.parseInt(numb, base);
            String result = Integer.toString(decimalValue, targetBase);

            System.out.println("Результат в системе счисления " + targetBase + ": " + result);

        } catch (NumberFormatException e) {
            System.out.println("Ошибка: введенное число не соответствует исходной системе счисления.");
        }

    }

    public void monthName() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите число от 1 до 12: ");
        int monthNumber = sc.nextInt();

        String monthName = "";

        switch (monthNumber)
        {
            case 1:
                monthName = "Январь";
                break;
            case 2:
                monthName = "Февраль";
                break;
            case 3:
                monthName = "Март";
                break;
            case 4:
                monthName = "Апрель";
                break;
            case 5:
                monthName = "Май";
                break;
            case 6:
                monthName = "Июнь";
                break;
            case 7:
                monthName = "Июль";
                break;
            case 8:
                monthName = "Август";
                break;
            case 9:
                monthName = "Сентябрь";
                break;
            case 10:
                monthName = "Октябрь";
                break;
            case 11:
                monthName = "Ноябрь";
                break;
            case 12:
                monthName = "Декабрь";
                break;
        }
        System.out.println("Месяц: " + monthName);
    }



}
