package com.javarush.task.task33.task3303;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

/* 
Десериализация JSON объекта
*/
public class Solution {
    public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz) throws IOException {
        T result = null;
        ObjectMapper mapper = new ObjectMapper();
        StringReader stringReader;

        result = mapper.readValue(new FileReader(new File(fileName)), clazz);
        return result;
    }

    public static void main(String[] args) {

    }
}
