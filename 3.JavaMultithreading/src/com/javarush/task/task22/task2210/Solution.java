package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.StringTokenizer;

/* 
StringTokenizer
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer stringTokenizer = new StringTokenizer(query, delimiter);
        String[] result = new String[stringTokenizer.countTokens()];
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            result[i++] = stringTokenizer.nextToken();
        }
        return result;
    }
}

        /*if (query.equals("") || query == null) return null;
        ArrayList<String> array = new ArrayList<>();
        StringTokenizer tokenizer =  new StringTokenizer(query, delimiter);
        while (tokenizer.hasMoreTokens())
        {
            array.add(tokenizer.nextToken());

        }
        String[] getToken = new String[array.size()];
        for (int i = 0; i < getToken.length; i++) {
            getToken[i] = array.get(i);
        }
        return getToken;
    }
}*/
