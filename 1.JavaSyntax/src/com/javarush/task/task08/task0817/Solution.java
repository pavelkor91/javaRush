package com.javarush.task.task08.task0817;

import java.util.*;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String,String> hashMap = new HashMap<>();
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

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        ArrayList<String> arrayList = new ArrayList<>(map.values());
        for(String str: arrayList)
            if (Collections.frequency(arrayList, str) > 1){
                removeItemFromMapByValue(map, str);
            }
    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {
            removeTheFirstNameDuplicates(createMap());

    }
}
