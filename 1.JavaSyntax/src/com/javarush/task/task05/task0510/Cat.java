package com.javarush.task.task05.task0510;

/* 
Кошкоинициация
*/

public class Cat {
    String name = null;
    int weight = 2;
    int age = 1;
    String color;
    String address = null;

    public void initialize(String name){
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.color = "black";
        //this.address = address;
    }

    public void initialize(String name, int weight, int age){
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.color = "white";
        //this.address = address;
    }

    public void initialize(String name, int age){
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.color = color;
        //this.address = address;
    }

    public void initialize(int weight, String color){
        //this.name = name;
        this.weight = weight;
        this.age = age;
        this.color = color;
        //this.address = address;
    }

    public void initialize(int weight, String color, String address){
        //this.name = name;
        this.weight = weight;
        this.age = age;
        this.color = color;
        this.address = address;
    }
}
