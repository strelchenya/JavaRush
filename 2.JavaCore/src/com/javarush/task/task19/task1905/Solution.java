package com.javarush.task.task19.task1905;


import java.util.HashMap;

import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }


    public static void main(String[] args) {

    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;
        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            String s = "";
            for (Map.Entry<String,String> entry: countries.entrySet()) {
                if (entry.getValue().equals(customer.getCountryName())) s = entry.getKey();
            }
            return s;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String firstName = contact.getName().split(" ")[1];
            return firstName;
        }

        @Override
        public String getContactLastName() {
            String lastName = contact.getName().split(" ")[0];
            return lastName.substring(0, lastName.length() - 1);
        }

        @Override
        public String getDialString() {
            char[] charsNumber = contact.getPhoneNumber().toCharArray();
            String number = "+";
            for (int i = 0; i < charsNumber.length; i++) {
                if ((int)charsNumber[i] > 47 && (int)charsNumber[i] < 58) number += charsNumber[i];
            }
                String PhoneNumber = String.format("callto://%s",number);
            return PhoneNumber;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //For example: UA                           +

        String getCompany();            //For example: JavaRush Ltd.                +

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        String getDialString();         //For example: callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.                +

        String getCountryName();        //For example: Ukraine                      +
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }
}