package ru.bahanov.pracJava.task4.A;

public class Main {

    public static void main(String[] args) {
        Star sun = new Star("Солнце");
        StarSystem solarSystem = new StarSystem(sun);

        Planet earth = new Planet("Земля");
        earth.addMoon(new Moon("Луна"));

        Planet mars = new Planet("Марс");
        mars.addMoon(new Moon("Фобос"));
        mars.addMoon(new Moon("Деймос"));

        solarSystem.addPlanet(earth);
        solarSystem.addPlanet(mars);

        solarSystem.printStarName();
        solarSystem.printPlanetCount();

        System.out.println(solarSystem);
    }
}









