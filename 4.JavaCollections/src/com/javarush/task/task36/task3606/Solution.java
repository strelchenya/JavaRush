package com.javarush.task.task36.task3606;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* 
Осваиваем ClassLoader и Reflection
*/

public class Solution {
    private List<Class> hiddenClasses = new ArrayList<>();
    private String packageName;

    public Solution(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Solution solution = new Solution(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "com/javarush/task/task36/task3606/data/second");
        solution.scanFileSystem();
        System.out.println(solution.getHiddenClassObjectByKey("secondhiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("firsthiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("packa"));
    }

    public void scanFileSystem() throws ClassNotFoundException {
        /*File folder = new File(this.packageName);
        for (File f: folder.listFiles()){
            if (f.isFile() && f.getName().toLowerCase().contains(".class")){
                try (FileInputStream fileInputStream = new FileInputStream(f)){
                    byte[] fileToByte = Files.readAllBytes(f.toPath());

                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }*/

        File dir = new File(packageName);
        ClassLoader classLoader = Solution.class.getClassLoader();
        for (String fileName : dir.list()) {
            if (fileName.endsWith(".class")) {
                String className = packageName.replaceAll("[/\\\\]", ".").substring(packageName.lastIndexOf("ru/")) + "." + fileName.substring(0, fileName.length() - 6);
                System.out.println(className);
                Class<?> aClass = classLoader.loadClass(className);
                System.out.println(aClass);
                hiddenClasses.add(aClass);
            }
        }
    }

    public HiddenClass getHiddenClassObjectByKey(String key) {
       /* String lowerKey = key.toLowerCase();
        try {
            Class resultClass = null;
            for (Class aClass : hiddenClasses) {
                if (aClass.getSimpleName().toLowerCase().startsWith(lowerKey)) {
                    resultClass = aClass;
                    Constructor<?> declaredConstructor = resultClass.getDeclaredConstructor();
                    declaredConstructor.setAccessible(true);
                    return (HiddenClass) declaredConstructor.newInstance();
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }*/
        return null;
    }
}

