package com.javarush.task.task26.task2613;

import java.util.HashMap;
import java.util.Map;

public class CurrencyManipulatorFactory {

    private static Map<String, CurrencyManipulator> map = new HashMap<>();

    private CurrencyManipulatorFactory() {
    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode){
        if (currencyCode == null || currencyCode.isEmpty()){
            return null;
        }
        currencyCode = currencyCode.toUpperCase();

        map.putIfAbsent(currencyCode, new CurrencyManipulator(currencyCode));

        return map.get(currencyCode);
    }


}
