package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (true)
            arrayList.add(Integer.parseInt(bufferedReader.readLine()));
        }
        catch (IOException e){
            System.out.println(e);
        }
        catch (NumberFormatException e){
            arrayList.forEach(System.out::println);
        }
        //напишите тут ваш код
    }
}
