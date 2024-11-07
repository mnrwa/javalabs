package ru.bahanov.pracJava.task2;

import ru.bahanov.pracJava.task2.A.A;
import ru.bahanov.pracJava.task2.B.B;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main zad = new Main();
        //zad.A();
        zad.B();
    }

    public void A(){
        A task2 = new A();
        List<Integer> arr = task2.loadArr();
        List<String> minMax = task2.largeOrSmallLen(arr);
        System.out.println(minMax.get(0));
        System.out.println(minMax.get(1));

        task2.sortLen(arr);

        task2.avgLen(arr);

        task2.findDublicate(arr);

        task2.findEvenNumb(arr);

        task2.sortNumb(arr);

        task2.someNum(arr);

        task2.findSecondPalindrome(arr);

        task2.findRoots();
    }

    public void B(){
        B task2 = new B();

        task2.tableMult();

        List<Integer> arr = new ArrayList<>(task2.loadArr());


        System.out.println("Исходный массив: "+arr);
        System.out.println("Массив в обратном порядке: " + arr.reversed());

        //task2.intervalCheck();

        task2.splitOnThree();

        task2.sixQues(100,81);

        task2.convertSystem();

        task2.convertAnySys();

        task2.monthName();
    }


}