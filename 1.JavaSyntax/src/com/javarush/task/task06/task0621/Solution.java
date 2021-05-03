package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String catGrandFatherName = reader.readLine();
        Cat catGrandFather = new Cat(catGrandFatherName);

        String catGrandMotherName = reader.readLine();
        Cat catGrandMother = new Cat(catGrandMotherName);

        String fatherName = reader.readLine();
        Cat catFather = new Cat(fatherName, null, catGrandFather);

        String motherName = reader.readLine();
        Cat catMother = new Cat(motherName, catGrandMother, null);

        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName, catMother, catFather);

        String sonName = reader.readLine();
        Cat catSon = new Cat(sonName, catMother, catFather);


        System.out.println(catGrandFather);
        System.out.println(catGrandMother);
        System.out.println(catFather);
        System.out.println(catMother);
        System.out.println(catDaughter);
        System.out.println(catSon);
    }

    public static class Cat {
        private String name;
        private Cat mom;
        private Cat pap;

        Cat(String name) {
            this.name = name;
        }

       /*Cat(String name, Cat parent1) {
            this.name = name;
            this.mom = mom;
        }*/

        Cat(String name, Cat mom, Cat pap) {
            this.name = name;
            this.mom = mom;
            this.pap = pap;
        }


        @Override
        public String toString() {
            if (mom == null && pap == null)
                return "The cat's name is " + name + ", no mother " + ", no father ";
            else if (pap == null)
                return "The cat's name is " + name + ", mother is " + mom.name + ", no father ";
            else if (mom == null)
                return "The cat's name is " + name + ", no mother " + ", father is " + pap.name;
            else return "The cat's name is " + name + ", mother is " + mom.name + ", father is " + pap.name;
        }
    }

}
