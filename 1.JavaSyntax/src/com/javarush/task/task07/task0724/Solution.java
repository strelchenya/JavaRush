package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/


import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        ArrayList<Human> humans = new ArrayList<>();
        Human gradFather1 = new Human("Евгений", true, 70);
        Human gradFather2 = new Human("Владимир", true, 65);
        Human gradMother1 = new Human("Елизавета", false, 68);
        Human gradMother2 = new Human("Светлана", false, 63);
        Human father = new Human("Николай", true, 35, gradFather1, gradMother1);
        Human mother = new Human("Лиза", false, 33, gradFather2, gradMother2);
        Human kid1 = new Human("Света", false, 8, father, mother);
        Human kid2 = new Human("Витя", true, 6, father, mother);
        Human kid3 = new Human("Игорь", true, 6, father, mother);
        humans.add(gradFather1);
        humans.add(gradFather2);
        humans.add(gradMother1);
        humans.add(gradMother2);
        humans.add(father);
        humans.add(mother);
        humans.add(kid1);
        humans.add(kid2);
        humans.add(kid3);
        for (Human human: humans) {
            System.out.println(human);
        }




        /*System.out.println(gradFather1.toString());
        System.out.println(gradFather2.toString());
        System.out.println(gradMother1.toString());
        System.out.println(gradMother2.toString());
        System.out.println(father.toString());
        System.out.println(mother.toString());
        System.out.println(kid1.toString());
        System.out.println(kid2.toString());
        System.out.println(kid3.toString());*/

    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human (String name,boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human (String name,boolean sex, int age, Human father, Human mother){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }

            return text;
        }
    }
}