package ru.bahanov.pracJava.task11.A;

import java.util.HashSet;
import java.util.Set;

public class IntegerSet {
    private Set<Integer> set;

    public IntegerSet() {
        this.set = new HashSet<>();
    }

    public void add(int number) {
        set.add(number);
    }

    public void remove(int number) {
        set.remove(number);
    }

    public boolean contains(int number) {
        return set.contains(number);
    }

    public IntegerSet intersection(IntegerSet other) {
        IntegerSet resultSet = new IntegerSet();
        resultSet.set.addAll(this.set);
        resultSet.set.retainAll(other.set);
        return resultSet;
    }

    public IntegerSet union(IntegerSet other) {
        IntegerSet resultSet = new IntegerSet();
        resultSet.set.addAll(this.set);
        resultSet.set.addAll(other.set);
        return resultSet;
    }

    public void print() {
        System.out.println(set);
    }

    public static void main(String[] args) {
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);

        IntegerSet set2 = new IntegerSet();
        set2.add(3);
        set2.add(4);
        set2.add(5);
        set2.add(6);

        System.out.println("Множество 1:");
        set1.print();

        System.out.println("Множество 2:");
        set2.print();

        IntegerSet intersection = set1.intersection(set2);
        System.out.println("Пересечение множества 1 и множества 2:");
        intersection.print();

        IntegerSet union = set1.union(set2);
        System.out.println("Объединение множества 1 и множества 2:");
        union.print();
    }
}
