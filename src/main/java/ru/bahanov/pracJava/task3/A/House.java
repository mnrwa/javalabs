package ru.bahanov.pracJava.task3.A;
// 6 Вариант


import java.util.ArrayList;
import java.util.List;

public class House {
    private int id;
    private int apartmentNumber;
    private double area;
    private int floor;
    private int numberOfRooms;
    private String street;
    private String buildingType;
    private int exploitationPeriod;

    public House(int id, int apartmentNumber, double area, int floor, int numberOfRooms, String street, String buildingType, int exploitationPeriod) {
        this.id = id;
        this.apartmentNumber = apartmentNumber;
        this.area = area;
        this.floor = floor;
        this.numberOfRooms = numberOfRooms;
        this.street = street;
        this.buildingType = buildingType;
        this.exploitationPeriod = exploitationPeriod;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public int getFloor() {
        return floor;
    }

    public double getArea() {
        return area;
    }

    @Override
    public String toString(){
        return "House{" +
                "id= " + id +
                ", Номер квартиры " + apartmentNumber +
                ", Площадь " + area +
                ", Этаж " + floor +
                ", Количество комнат " + numberOfRooms +
                ", Улица " + street +
                ", Тип здания, " + buildingType +
                ", Срок эксплуатации " + exploitationPeriod +
                "}";
    }

    public static void printContOfRooms(List<House>houses,int countRooms){
        System.out.println("Список квартир, имеющих заданное число комнат");

        for(House house: houses){
            if(house.getNumberOfRooms() == countRooms){
                System.out.println(house);
            }
        }
    }

    public static void printRangeFloor(List<House>houses,int rooms ,int startRange, int finishRange){
        System.out.println("список квартир, имеющих заданное число комнат и расположенных на между "+ startRange+ " и " + finishRange);

        for(House house: houses){
            if(house.getNumberOfRooms() == rooms && house.getFloor() >= startRange && house.getFloor() <= finishRange){
                System.out.println(house);
            }
        }
    }

    public static void printAppartArea(List<House>houses, double overArea){
        System.out.println("Список квартир, имеющих площадь, превосходящую " + overArea);

        for(House house : houses){
            if(house.getArea()>=overArea){
                System.out.println(house);
            }
        }

    }

    public static void main(String[]args) {
        List<House> houses = new ArrayList<>();

        houses.add(new House(1, 101, 45.5, 3, 2, "Ленина", "Многоквартирный", 10));
        houses.add(new House(2, 202, 60.0, 5, 3, "Пушкина", "Коттедж", 5));
        houses.add(new House(3, 303, 75.0, 7, 4, "Гагарина", "Многоквартирный", 15));
        houses.add(new House(4, 404, 50.0, 2, 2, "Мира", "Панельный", 20));
        houses.add(new House(5, 505, 80.0, 9, 2, "Советская", "Блочный", 8));

        printContOfRooms(houses,2);
        System.out.println();

        printRangeFloor(houses,2,2,3);
        System.out.println();

        printAppartArea(houses,50);

    }
}
