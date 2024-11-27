package ru.bahanov.pracJava.task4.A;

import java.util.Objects;

public class Star{
    private String name;

    public Star(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;
        if(o == null || getClass()!=o.getClass())
            return false;
        Star star = (Star) o;
        return Objects.equals(name,star.name);
    }

    @Override
    public int hashCode(){
        return Objects.hash(name);
    }

    @Override
    public String toString(){
        return "Star{name= '" + name+"'}";
    }
}
