package com.javarush.task.task20.task2021;

import java.io.*;

/* 
Сериализация под запретом
*/
public class Solution implements Serializable {
    public static class SubSolution extends Solution {
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException{
            throw new NotSerializableException();
        }
        private void readObject(ObjectInputStream objectInputStream) throws IOException{
            throw new NotSerializableException();
        }
    }

    public static void main(String[] args) {

    }
}
