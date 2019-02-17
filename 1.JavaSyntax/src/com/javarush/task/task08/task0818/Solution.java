package com.javarush.task.task08.task0818;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        HashMap<String,Integer> hashMap = new HashMap<>();
        hashMap.put("Попов",900);
        hashMap.put("Семенов",365);
        hashMap.put("Сверидов",1000);
        hashMap.put("Габенов",550);
        hashMap.put("Антропов",435);
        hashMap.put("Филатов",1500);
        hashMap.put("Демидов",200);
        hashMap.put("Денисов",924);
        hashMap.put("Иванов",250);
        hashMap.put("Алексеев",555);

        return hashMap;

    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        HashMap<String, Integer> copy = new HashMap<String, Integer>(map);
        for (Map.Entry<String, Integer> pair : copy.entrySet()) {
            if (pair.getValue() < 500)
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {

    }
}