package com.javarush.task.task35.task3507;

import java.io.*;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.Set;


/* 
ClassLoader - что это такое?
*/

public class Solution extends ClassLoader {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals =
                getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() +
                        Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        File folder = new File(pathToAnimals);
        Set<Animal> setAnimal = new HashSet<>();
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isFile()) {
                try {
                    ClassLoader loader = new ClassLoader() {
                        @Override
                        protected Class<?> findClass(String name) throws ClassNotFoundException {
                            try {
                                byte[] classBytes = Files.readAllBytes(fileEntry.toPath());
                                return defineClass(null, classBytes, 0, classBytes.length);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            return super.findClass(name);
                        }
                    };
                    String classSimpleName = fileEntry.getName().replace(".class", "");
                    Class<?> clazz = loader.loadClass(classSimpleName);
                    setAnimal.add((Animal) clazz.newInstance());

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                }
            }
        }
        return setAnimal;
    }
}
