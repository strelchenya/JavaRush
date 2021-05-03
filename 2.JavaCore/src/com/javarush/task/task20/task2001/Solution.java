package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human
*/

public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            System.out.println(ivanov.equals(somePerson));
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }
        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.println(this.name);
            if (this.assets.size() > 0) {
                for (Asset current : this.assets) {
                    printWriter.println(current.getName());
                    printWriter.println(current.getPrice());
                }
            }
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            this.name = reader.readLine();
            while (reader.ready()) {
                String assetName = reader.readLine();
                double assetPrice = Double.parseDouble(reader.readLine());
                this.assets.add(new Asset(assetName, assetPrice));
            }
            reader.close();
        }
        /*public void save(OutputStream outputStream) throws Exception {
            StringBuilder sb = new StringBuilder();
            sb.append("name: ").append(this.name).append('\n');
            for (Asset asset : assets) {
                sb.append('\t' + "assetName: ").append(asset.getName()).append('\n');
                sb.append('\t' + "assetPrice: ").append(asset.getPrice()).append('\n');
            }

            char[] chars = sb.toString().toCharArray();
            byte[] buff = new byte[chars.length];
            for (int i = 0; i < sb.toString().length(); i++) {
                buff[i] = (byte) chars[i];
            }
            outputStream.write(buff);

        }

        public void load(InputStream inputStream) throws Exception {

            StringBuilder sb = new StringBuilder();
            int b;
            while ((b = inputStream.read()) != -1){
                sb.append((char) b);
            }
            String[] strs = sb.toString().split("\n");
            int i = 0;
            while (i < strs.length) {
                //нашли имя
                if (strs[i].startsWith("name: ")) {
                    strs[i] = strs[i].replace("name: ", "");
                    this.name = strs[i];
                    i = i + 1;
                    continue;
                }
                //нешли ассет
                if (strs[i].startsWith("\tassetName: ")) {
                    strs[i] = strs[i].replace("\tassetName: ", "");
                    strs[i + 1] = strs[i + 1].replace("\tassetPrice: ", "");
                    Asset asset = new Asset(strs[i], Double.parseDouble(strs[i + 1]));
                    this.assets.add(asset);
                    i = i + 2;
                    continue;
                }
            }
        }*/
    }
}