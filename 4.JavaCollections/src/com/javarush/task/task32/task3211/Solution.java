package com.javarush.task.task32.task3211;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;

/* 
Целостность информации
*/

public class Solution {
    public static void main(String... args) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(new String("test string"));
        oos.flush();
        System.out.println(compareMD5(bos, "5a47d12a2e3f9fecf2d9ba1fd98152eb")); //true

    }

    public static boolean compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) throws Exception {

        MessageDigest messageDigest = MessageDigest.getInstance("MD5");

        byte[] fileByte = byteArrayOutputStream.toByteArray();

        messageDigest.update(fileByte);
        StringBuilder sb = new StringBuilder();
        byte[] bytesMd = messageDigest.digest();
        for (int i = 0; i < bytesMd.length; i++) {
            String s = Integer.toHexString(0xff & bytesMd[i]);
            s = (s.length() == 1) ? "0" + s : s;
            sb.append(s);
        }

        if (sb.toString().equals(md5)){
            return true;
        }

        return false;
    }
}
