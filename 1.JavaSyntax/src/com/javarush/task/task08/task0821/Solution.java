package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("Попов","Алеша");
        hashMap.put("Семенов","Дима");
        hashMap.put("Попов","Алеша");
        hashMap.put("Габенов","Габен");
        hashMap.put("Антропов","Санек");
        hashMap.put("Попов","Филипп");
        hashMap.put("Демидов","Демид");
        hashMap.put("Денисов","Санек");
        hashMap.put("Иванов","Иван");
        hashMap.put("Габенов","Алеша");

        return hashMap;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
