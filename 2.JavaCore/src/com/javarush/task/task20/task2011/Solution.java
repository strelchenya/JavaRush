package com.javarush.task.task20.task2011;

import java.io.*;

/* 
Externalizable для апартаментов
*/

public class Solution {

    public static class Apartment implements Externalizable{
        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
                out.writeObject(this.address);
                out.writeInt(this.year);
                out.close();
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
                this.address = (String) in.readObject();
                this.year = in.readInt();
                in.close();
        }

        private String address;
        private int year;

        /**
         * Mandatory public no-arg constructor.
         */
        public Apartment() {
            super();
        }

        public Apartment(String addr, int y) {
            address = addr;
            year = y;
        }

        /**
         * Prints out the fields used for testing!
         */
        public String toString() {
            return ("Address: " + address + "\n" + "Year: " + year);
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Apartment apt = new Apartment("г.Москва, Кутузовский просп., дом 18", 2017);
        ObjectOutputStream ou = new ObjectOutputStream(new FileOutputStream("D:/task2011.dat"));
        ou.writeObject(apt);
        ou.close();
        ObjectInputStream oi = new ObjectInputStream(new FileInputStream("D:/task2011.dat"));
        Apartment reApt = (Apartment) oi.readObject();
        System.out.println(reApt.toString());
        oi.close();
    }
}
