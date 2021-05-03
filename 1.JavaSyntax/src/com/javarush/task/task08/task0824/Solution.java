package com.javarush.task.task08.task0824;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Собираем семейство
*/

public class Solution {
    public static void main(String[] args) {

        Human children1 = new Human("Костя", true, 16);
        Human children2 = new Human("Оля", false, 15);
        Human children3 = new Human("Олег", true, 6);

        Human father = new Human("Александр", true, 45, new Human[]{children1, children2, children3});
        Human mother = new Human("Александра", true, 43, new Human[]{children1, children2, children3});

        Human grandFather1 = new Human("Алексей", true, 70, father);
        Human grandFather2 = new Human("Инокентий", true, 65, mother);
        Human grandMother1 = new Human("Зинаида", false, 68, father);
        Human grandMother2 = new Human("Елена", false, 63, mother);

        /*System.out.println(grandFather1);
        System.out.println(grandFather2);
        System.out.println(grandMother1);
        System.out.println(grandMother2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(children1);
        System.out.println(children2);
        System.out.println(children3);*/

    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        List<Human> children = new ArrayList<>();

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            //this.children = new ArrayList<>();
            System.out.println(this.toString());
        }

     /*   public Human(String name, boolean sex, int age, ArrayList<Human> children){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }*/

        public Human(String name, boolean sex, int age, Human... children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            //this.children = new ArrayList<>();
            Collections.addAll(this.children, children);
            System.out.println(this.toString());
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}
