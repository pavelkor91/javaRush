package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() throws ParseException {
        DateFormat df = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        HashMap<String, Date> map = new HashMap<String, Date>();

        map.put("Stallone", df.parse("December 1 1945"));
        map.put("Vagonne", df.parse("January 1 1913"));
        map.put("Malonne", df.parse("June 1 1980"));
        map.put("Brugbonne", df.parse("January 1 1910"));
        map.put("Liptonne", df.parse("December 3 1967"));
        map.put("Makaronne", df.parse("June 1 1912"));
        map.put("Markaponne", df.parse("September 1 1990"));
        map.put("Sillikonne", df.parse("June 1 1989"));
        map.put("Titikonne", df.parse("July 1 1980"));
        map.put("Molokonne", df.parse("June 1 1920"));

        return map;
        //напишите тут ваш код
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        //напишите тут ваш код
       map.values().removeIf(s -> s.toString().contains("Jul")
               || s.toString().contains("Jun")
               || s.toString().contains("Aug")
       );
    }

    public static void main(String[] args) {

    }
}
