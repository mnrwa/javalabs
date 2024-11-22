package ru.bahanov.pracJava.task3.C;

public class Circle {
    private Rational centerX, centerY;
    private double radius;

    public Circle(Rational centerX, Rational centerY, double radius) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public Rational getCenterX() {
        return centerX;
    }

    public Rational getCenterY() {
        return centerY;
    }

    @Override
    public String toString() {
        return "Circle{centerX=" + centerX + ", centerY=" + centerY + ", radius=" + radius + "}";
    }

    public static boolean areCentersOnSameVerticalLine(Circle c1, Circle c2) {
        return c1.centerX.equals(c2.centerX);
    }
}
