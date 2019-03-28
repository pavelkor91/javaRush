package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filename = null;
        try {
            while (!(filename = bufferedReader.readLine()).equals("exit")){
                new ReadThread(filename).start();
            }
            bufferedReader.close();
        }
        catch (IOException e){}

    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void run() {
            int[] array = new int[255];
            byte[] fileData = null;
            try {
                FileInputStream fileReader = new FileInputStream(fileName);
                fileData = new byte[fileReader.available()];
                fileReader.read(fileData);
                fileReader.close();
            }
            catch (FileNotFoundException e){}
            catch (IOException e){}

            int max = array[0];
            for(int i = 0; i < fileData.length; i++){
               array[fileData[i]]++;
            }
            int result = 0;
            for(int i = 0; i < array.length; i++){
                if(array[i] > max){
                    max = array[i];
                    result = i;
                }
            }
            resultMap.put(fileName, result);
        }

        // implement file reading here - реализуйте чтение из файла тут
    }
}
