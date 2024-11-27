package ru.bahanov.pracJava.task4.A;

import java.util.ArrayList;
import java.util.List;

public class StarSystem {
    private Star star;
    private List<Planet> planets;

    public StarSystem(Star star) {
        this.star = star;
        this.planets = new ArrayList<>();
    }

    public void addPlanet(Planet planet) {
        planets.add(planet);
    }

    public void printPlanetCount() {
        System.out.println("Количество планет в системе: " + planets.size());
    }

    public void printStarName() {
        System.out.println("Название звезды: " + star.getName());
    }

    @Override
    public String toString() {
        return "StarSystem{" +
                "star=" + star +
                ", planets=" + planets +
                '}';
    }

}
