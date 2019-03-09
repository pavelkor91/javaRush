package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String url = bufferedReader.readLine();

        url = url.substring(url.indexOf("?") + 1, url.length());

        List<String> paramList = new ArrayList<>();

        for(String param : url.split("&"))
            paramList.add(param);

        Object obj = null;
        for(String params : paramList) {
            if (params.contains("obj")) {
                System.out.print(params.substring(0, params.indexOf("=")) + " ");
                try{
                    obj = Double.parseDouble(params.substring(params.indexOf("=") + 1, params.length()));
                    }
                catch (NumberFormatException e) {
                    obj = params.substring(params.indexOf("=") + 1, params.length());
                }

            } else if (params.contains("="))
                System.out.print(params.substring(0, params.indexOf("=")) + " ");
            else
                System.out.print(params + " ");
        }
        System.out.println();
        if (obj instanceof String)
            alert((String)obj);
        if (obj instanceof Double)
            alert((Double)obj);

        //add your code here
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
