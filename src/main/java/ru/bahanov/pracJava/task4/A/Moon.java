package ru.bahanov.pracJava.task4.A;

import java.util.Objects;

public class Moon{
    private String name;

    public Moon(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;
        if(o == null || getClass()!= o.getClass())
            return false;
        Moon moon = (Moon) o;
        return Objects.equals(name,moon.name);
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(name);
    }

    @Override
    public String toString(){
        return "Moon{name='"+name+"'}";
    }
}
