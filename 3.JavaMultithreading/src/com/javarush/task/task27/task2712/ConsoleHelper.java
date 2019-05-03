package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws IOException{
        return bufferedReader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException{
        List<Dish> array = new ArrayList<>();
        ConsoleHelper.writeMessage("Наши блюда:");
        ConsoleHelper.writeMessage(Dish.allDishesToString());
        ConsoleHelper.writeMessage("Введите блюда для заказа");
        while (true){
            String s = readString();
            if(s.equals("exit"))
                break;
            else {
                try {
                    array.add(Dish.valueOf(s));
                }
                catch (IllegalArgumentException e){
                    ConsoleHelper.writeMessage("Блюда " + s + " нету в меню");
                }
            }
        }
        return array;
    }
}
