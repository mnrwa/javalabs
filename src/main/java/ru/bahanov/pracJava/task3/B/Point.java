package ru.bahanov.pracJava.task3.B;

public class Point {
    private double x, y, z, time;
    private double speedX, speedY, speedZ;
    private double accelerationX, accelerationY, accelerationZ;

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", t=" + time +
                '}';
    }

    public Point(double x, double y, double z, double time) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.time = time;
        this.speedX = 0;
        this.speedY = 0;
        this.speedZ = 0;
        this.accelerationX = 0;
        this.accelerationY = 0;
        this.accelerationZ = 0;
    }

    public void move(double ax, double ay, double az, double dt) {
        // Обновляем ускорение
        this.accelerationX = ax;
        this.accelerationY = ay;
        this.accelerationZ = az;

        // Обновляем скорость
        this.speedX += ax * dt;
        this.speedY += ay * dt;
        this.speedZ += az * dt;

        // Обновляем положение
        this.x += speedX * dt + 0.5 * ax * dt * dt;
        this.y += speedY * dt + 0.5 * ay * dt * dt;
        this.z += speedZ * dt + 0.5 * az * dt * dt;

        // Обновляем время
        this.time += dt;
    }

    public double getSpeed() {
        return Math.sqrt(speedX * speedX + speedY * speedY + speedZ * speedZ);
    }

    public double getAcceleration() {
        return Math.sqrt(accelerationX * accelerationX + accelerationY * accelerationY + accelerationZ * accelerationZ);
    }

    public static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2) + Math.pow(p2.z - p1.z, 2));
    }

    public static boolean canIntersect(Point p1, Point p2) {
        return p1.x == p2.x && p1.y == p2.y && p1.z == p2.z;
    }

    public static void main(String[] args) {
        Point p1 = new Point(0, 0, 0, 0);
        Point p2 = new Point(1, 1, 1, 0);

        p1.move(1, 1, 1, 1);

        p2.move(0, 0, 1, 1);


        System.out.println("Точка 1: " + p1);
        System.out.println("Точка 2: " + p2);


        System.out.println("Расстояние между точками: " + Point.distance(p1, p2));


        System.out.println("Могут ли точки пересечься: " + Point.canIntersect(p1, p2));


        System.out.println("Скорость точки 1: " + p1.getSpeed());
        System.out.println("Скорость точки 2: " + p2.getSpeed());
        System.out.println("Ускорение точки 1: " + p1.getAcceleration());
        System.out.println("Ускорение точки 2: " + p2.getAcceleration());
    }
}
