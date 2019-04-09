package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception{
        //implement this method - реализуйте этот метод
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = bufferedReader.readLine();
        FileInputStream fileInputStream = new FileInputStream(filePath);
        load(fileInputStream);
        fileInputStream.close();
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        save(fileOutputStream);
        fileOutputStream.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        Properties prop = new Properties();
        for(Map.Entry<String, String> entry: properties.entrySet()){
            prop.setProperty(entry.getKey(), entry.getValue());
        }
        prop.store(outputStream, null);
    }

    public void load(InputStream inputStream) throws Exception {
        Properties prop = new Properties();
        prop.load(inputStream);

        for(String name: prop.stringPropertyNames()){
            properties.put(name, prop.getProperty(name));
        }
    }

    public static void main(String[] args) {

    }
}
