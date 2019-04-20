package com.javarush.task.task22.task2208;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name","Ivanov");
        map.put("country","Ukraine");
        map.put("city","Kiev");
        map.put("age",null);

        System.out.println(getQuery(map));

    }
    public static String getQuery(Map<String, String> params) {

        StringBuilder sb = new StringBuilder();

        String result;

        for(Map.Entry<String, String> entry: params.entrySet()){
            if(entry.getValue() != null){
                sb.append(entry.getKey()).append(" = '").append(entry.getValue()).append("' and ");
            }
        }

        if(sb.length() < 1){
            return "";
        }
        result = sb.substring(0, sb.length()-5);
        return result;
    }
}
