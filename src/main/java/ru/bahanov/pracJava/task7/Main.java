package ru.bahanov.pracJava.task7;

@FunctionalInterface
interface DiscriminantCalculator {
    double calculate(double a, double b, double c);
}

public class Main {
    public static void main(String[] args) {
        DiscriminantCalculator discriminant = (a, b, c) -> (b * b) - (4 * a * c);

        double a = 2.0, b = 5.0, c = -3.0;
        double result = discriminant.calculate(a, b, c);

        System.out.println("Дискриминант: " + result);
    }
}