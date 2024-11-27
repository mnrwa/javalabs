package ru.bahanov.pracJava.task4.A;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Planet{
    private String name;
    public List<Moon> moons;

    public Planet(String name){
        this.name=name;
        this.moons = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Moon> getMoons() {
        return moons;
    }

    public void addMoon(Moon moon) {
        moons.add(moon);
    }

    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;
        if(o == null || getClass()!=o.getClass())
            return false;
        Planet planet = (Planet) o;
        return Objects.equals(name, planet.name);

    }

    @Override
    public int hashCode(){
        return Objects.hashCode(name);
    }

    @Override
    public String toString(){
        return "Planet{name='" + name + "', moons=" + moons + '}';
    }
}
