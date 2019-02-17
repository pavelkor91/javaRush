package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("Попов","Алеша");
        hashMap.put("Семенов","Дима");
        hashMap.put("Сверидов","Денис");
        hashMap.put("Габенов","Габен");
        hashMap.put("Антропов","Санек");
        hashMap.put("Филатов","Филипп");
        hashMap.put("Демидов","Демид");
        hashMap.put("Денисов","Денис");
        hashMap.put("Иванов","Иван");
        hashMap.put("Алексеев","Алеша");
        return hashMap;

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        int count = 0;
        for(Map.Entry<String, String> entry: map.entrySet())
            if(entry.getValue().equals(name))
                count++;

            return count;


    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        return map.containsKey(lastName) ? 1 : 0;

    }

    public static void main(String[] args) {

    }
}
