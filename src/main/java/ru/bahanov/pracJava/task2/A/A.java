package ru.bahanov.pracJava.task2.A;

import java.util.*;

public class A {
    public List<Integer> loadArr() {
        System.out.println("Введите n чисел с консоли.");

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println("Введите значение для " + i + "-го элемента: ");
            arr.add(sc.nextInt());
        }
        return arr;
    }

    public List<String> largeOrSmallLen(List<Integer> arr) {
        int minLen = String.valueOf(arr.get(0)).length();
        int maxLen = minLen;
        int minNum = arr.get(0);
        int maxNum = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            int currentLen = String.valueOf(arr.get(i)).length();

            if (currentLen < minLen) {
                minLen = currentLen;
                minNum = arr.get(i);
            }
            if (currentLen > maxLen) {
                maxLen = currentLen;
                maxNum = arr.get(i);
            }
        }

        List<String> res = new ArrayList<>();
        res.add("Самое короткое число: " + minNum + " (Длина: " + minLen + ")");
        res.add("Самое длинное число: " + maxNum + " (Длина: " + maxLen + ")");

        return res;
    }

    public void sortLen(List<Integer> arr) {
        int temp;
        for (int i = 0; i < arr.size() - 1; i++) {
            for (int j = 1; j < arr.size() - i; j++) {
                if (String.valueOf(arr.get(j - 1)).length() > String.valueOf(arr.get(j)).length()) {
                    temp = arr.get(j - 1);
                    arr.set(j - 1, arr.get(j));
                    arr.set(j, temp);
                }
            }
        }
        System.out.println(arr);
    }

    public void avgLen(List<Integer> arr) {
        int avrLenArr = 0;
        for (int a : arr) {
            avrLenArr += String.valueOf(a).length();
        }

        double averageLength = (double) avrLenArr / arr.size();
        System.out.println("Средняя длина чисел: " + averageLength);

        List<Integer> minThanAvg = new ArrayList<>();
        List<Integer> maxThanAvg = new ArrayList<>();

        for(int a: arr){
            int currentLen = String.valueOf(a).length();
            if(currentLen <= averageLength){
                minThanAvg.add(a);
            }
            else if (currentLen >= averageLength) {
                maxThanAvg.add(a);
            }
        }

        System.out.println("Числа с длиной меньше средней:");
        for (int num : minThanAvg) {
            System.out.println(num + " (Длина: " + String.valueOf(num).length() + ")");
        }

        System.out.println("Числа с длиной больше средней:");
        for (int num : maxThanAvg) {
            System.out.println(num + " (Длина: " + String.valueOf(num).length() + ")");
        }
    }

    public void findDublicate(List<Integer>arr){
        Integer result = 0;
        int minUniqueDigits = Integer.MAX_VALUE;

        for (Integer num : arr) {
            int uniqueDigits = new LinkedHashSet<>(Arrays.asList(Integer.toString(Math.abs(num)).split(""))).size();

            if (uniqueDigits < minUniqueDigits) {
                minUniqueDigits = uniqueDigits;
                result = num;
            }
        }
        System.out.println("Число, в котором число различных цифр минимально: " + result);
    }

    public void findEvenNumb(List<Integer>arr){
        List<Integer> res = new ArrayList<>();
        for(int a: arr){
            if(evenNumbers(a)){
                res.add(a);
            }
        }
        if (!res.isEmpty()) {
            System.out.println("Числа, в которых все цифры чётные: " + res);
        } else {
            System.out.println("Нет чисел, содержащих только чётные цифры.");
        }    }

    public boolean evenNumbers(int a){
        for (int i = 0; i < String.valueOf(a).length(); i++) {
            if (Integer.parseInt(String.valueOf(a).charAt(i) + "") % 2 != 0) {
                return false;
            }
        }

        return true;
    }

    public void sortNumb(List<Integer> arr) {
        List<Integer> res = new ArrayList<>();

        for (int a : arr) {
            String numberStr = String.valueOf(a);
            boolean flag = true;

            for (int i = 0; i < numberStr.length() - 1; i++) {
                int currentDigit = Character.getNumericValue(numberStr.charAt(i));
                int nextDigit = Character.getNumericValue(numberStr.charAt(i + 1));

                if (nextDigit != currentDigit + 1) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                res.add(a);
            }
        }
        System.out.println("Числа, у которых цифры идут строго по порядку: " + res);
    }

    public void someNum(List<Integer> arr) {
        LinkedHashSet<Character> hs = new LinkedHashSet<>();
        int res = 0;

        for (int a : arr) {
            hs.clear();
            String numStr = String.valueOf(a);

            for (char digit : numStr.toCharArray()) {
                hs.add(digit);
            }

            if (hs.size() == numStr.length()) {
                res = a;
                break;
            }
        }
        System.out.println("Число, состоящее только из различных цифр: " + res);
    }

    public void findSecondPalindrome(List<Integer> arr) {
        int count = 0;
        Integer secondPalindrome = null;

        for (int a : arr) {
            String numStr = String.valueOf(a);
            StringBuilder reversed = new StringBuilder(numStr).reverse();

            if (numStr.equals(reversed.toString())) {
                count++;
                if (count == 2) {
                    secondPalindrome = a;
                    break;
                }
            }
        }
        if (secondPalindrome != null) {
            System.out.println("Второе палиндромное число: " + secondPalindrome);
        } else {
            System.out.println("Второе палиндромное число не найдено.");
        }

    }

    public void findRoots() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Квадратное уравнение имеет вид:");
        System.out.println("ax^2 + bx + c = 0");
        System.out.println("Введите a, b и c:");

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int d = b * b - 4 * a * c;

        System.out.println(a+"x^2 + "+b+"x + "+c+" = 0");

        if (d > 0) {
            double x1 = (-b - Math.sqrt(d)) / (2 * a);
            double x2 = (-b + Math.sqrt(d)) / (2 * a);

            System.out.println("Корни уравнения: x1 = " + x1 + ", x2 = " + x2);
        } else if (d == 0) {
            double x = -b / (2 * a);
            System.out.println("Уравнение имеет единственный корень: x = " + x);
        } else {
            System.out.println("Уравнение не имеет действительных корней!");
        }
        sc.close();
    }

}