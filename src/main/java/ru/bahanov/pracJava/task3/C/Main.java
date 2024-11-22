package ru.bahanov.pracJava.task3.C;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Circle> circles = new ArrayList<>();

        circles.add(new Circle(new Rational(1, 1), new Rational(2, 1), 5.0)); // Центр (1,2), радиус 5
        circles.add(new Circle(new Rational(1, 1), new Rational(4, 1), 3.0)); // Центр (1,4), радиус 3
        circles.add(new Circle(new Rational(2, 1), new Rational(3, 1), 4.0)); // Центр (2,3), радиус 4
        circles.add(new Circle(new Rational(1, 1), new Rational(6, 1), 2.0)); // Центр (1,6), радиус 2

        System.out.println("Все окружности:");
        for (Circle circle : circles) {
            System.out.println(circle);
        }

        List<Circle> sameVerticalCircles = findCirclesOnSameVerticalLine(circles);
        System.out.println("\nОкружности, центры которых лежат на одной вертикальной прямой:");
        for (Circle circle : sameVerticalCircles) {
            System.out.println(circle);
        }

        Circle largestByArea = getLargestByArea(circles);
        Circle smallestByArea = getSmallestByArea(circles);

        System.out.println("\nНаибольшая окружность по площади: " + largestByArea);
        System.out.println("Наименьшая окружность по площади: " + smallestByArea);
    }

    public static List<Circle> findCirclesOnSameVerticalLine(List<Circle> circles) {
        List<Circle> result = new ArrayList<>();
        Rational firstX = circles.get(0).getCenterX();

        for (Circle circle : circles) {
            if (circle.getCenterX().equals(firstX)) {
                result.add(circle);
            }
        }
        return result;
    }

    public static Circle getLargestByArea(List<Circle> circles) {
        Circle largest = circles.get(0);
        for (Circle circle : circles) {
            if (circle.getArea() > largest.getArea()) {
                largest = circle;
            }
        }
        return largest;
    }

    public static Circle getSmallestByArea(List<Circle> circles) {
        Circle smallest = circles.get(0);
        for (Circle circle : circles) {
            if (circle.getArea() < smallest.getArea()) {
                smallest = circle;
            }
        }
        return smallest;
    }
}
