package ru.bahanov.pracJava.task1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        List<Integer> evenNum = new ArrayList<>();
        List<Integer> oddNum = new ArrayList<>();
        List<Integer> splitNineOrThree = new ArrayList<>();
        List<Integer> splitFiveAndSeven = new ArrayList<>();
        List<Integer> someNumbers = new ArrayList<>();
        List<Integer> primeNumber = new ArrayList<>();
        List<Integer> listLuckyNumbers = new ArrayList<>();
        List<Integer> palindrome = new ArrayList<>();

        System.out.println("Введи размер массива");
        int n = sc.nextInt();

        System.out.println("Укажите максимальный диапозон чисел: ");
        int maxRange =sc.nextInt();

        int[] array = new int[n];
        int max = 0;

        System.out.println("Заполнение массива из " + n + " элементов");

        for (int i = 0; i < n; i++) {
            System.out.println((array[i] = random.nextInt(1, maxRange))+" индекс-["+i+"]");

        }

        int min = array[0];


        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                evenNum.add(array[i]);
            } else {
                oddNum.add(array[i]);
            }

            if (array[i] > max) {
                max = array[i];
            }

            if (array[i] < min) {
                min = array[i];
            }

            if (array[i] % 3 == 0 || array[i] % 9 == 0) {
                splitNineOrThree.add(array[i]);
            }

            if (array[i] % 5 == 0 && array[i] % 7 == 0) {
                splitFiveAndSeven.add(array[i]);
            }

            if ((array[i] > 100 && array[i] < 1000) &&
                    (array[i] / 100 != (array[i] % 100) / 10) &&
                    ((array[i] % 100) / 10 != array[i] % 10) &&
                    (array[i] % 10 != array[i] / 100)) {
                someNumbers.add(array[i]);
            }

            if(Main.luckyNumbers(array[i])){
                listLuckyNumbers.add(array[i]);
            }

            if(array[i]==Main.reverse(array[i])){
                palindrome.add(array[i]);
            }
        }

        for (int i = 0; i < array.length; i++) {
            boolean isPrime = true;
            if (array[i] < 2) {
                isPrime = false;
            } else {
                for (int j = 2; j <= Math.sqrt(array[i]); j++) {
                    if (array[i] % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }

            if (isPrime) {
                primeNumber.add(array[i]);
            }
        }

        int tmp = 0;

        int[] cloneArraySorted = array.clone();

        for (int i = 0; i < cloneArraySorted.length; i++) {
            for (int j = 1; j < (cloneArraySorted.length - i); j++) {
                if (cloneArraySorted[j - 1] > cloneArraySorted[j]) {
                    tmp = cloneArraySorted[j - 1];
                    cloneArraySorted[j - 1] = cloneArraySorted[j];
                    cloneArraySorted[j] = tmp;
                }
            }
        }

        System.out.println("Четные числа: " + evenNum);
        System.out.println("Нечетные числа: " + oddNum);

        System.out.println("Минимальное число в массиве: " + min);
        System.out.println("Максимальное число в массиве: " + max);

        System.out.println("Числа, которые делятся на 3 или на 9" + splitNineOrThree);
        System.out.println("Числа, которые делятся на 5 и на 7" + splitFiveAndSeven);

        System.out.println("Трехзначные числа, в десятичной записи которых нет одинаковых цифр: " + someNumbers);

        System.out.println("Простые числа: " + primeNumber);

        System.out.println("Массив в порядке возростания: " + Arrays.toString(cloneArraySorted));
        System.out.println("Массив в порядке убывания: " + Arrays.toString(reverse(cloneArraySorted)));

        System.out.println("Числа в порядке убывания частоты встречаемости чисел: "+frequency(cloneArraySorted));

        System.out.println("«Счастливые» числа: "+ listLuckyNumbers);

        System.out.println("«Числа-палиндромы: "+ palindrome);

        System.out.println("Элементы, которые равны полусумме соседних элементов: "+ halfNeighbourSum(array));

    }

    static int[] reverse(int[] array) {
        int[] newArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            newArray[array.length - 1 - i] = array[i];
        }
        return newArray;
    }

    static int reverse(int num) {
        StringBuilder n = new StringBuilder();
        for (int i = (String.valueOf(num)).length()-1; i >= 0; i--) {
            n.append((String.valueOf(num)).charAt(i));
        }
        return Integer.parseInt(n.toString());
    }

    static HashSet<Integer> frequency(int[] array) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : array) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        List<Integer> numberList = new ArrayList<>();
        for (int num : array) {
            numberList.add(num);
        }
        numberList.sort((a, b) -> {
            int freqCompare = frequencyMap.get(b).compareTo(frequencyMap.get(a));
            if (freqCompare == 0) {
                return Integer.compare(a, b);
            }
            return freqCompare;
        });

        HashSet<Integer> sortedUniqueNumbers = new HashSet<>(numberList);
        return sortedUniqueNumbers;
    }

    static boolean luckyNumbers(int num){
        int lenNum = String.valueOf(num).length();
        if(lenNum % 2 != 0)
            return false;
        int mid = (int) Math.pow(10, lenNum / 2);
        return (num / mid == num % mid);
    }

    static List<String> halfNeighbourSum(int [] arr){
        List<String> result = new ArrayList<>();
        for(int i = 1;i<arr.length-1;i++){
            int halfSum = (arr[i - 1] + arr[i + 1]) / 2;
            if(arr[i]==halfSum){
                result.add(arr[i]+" индекс-["+i+"]");
            }
        }
        return result;
    }
}