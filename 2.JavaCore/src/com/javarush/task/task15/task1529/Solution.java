package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }
    
    static {
        try {
            reset();
        }
        catch (IOException e){
            System.out.println(e);
        }
    }

    public static CanFly result;

    public static void reset() throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String param = bufferedReader.readLine();
        //add your code here - добавьте код тут
        if (param.equals("helicopter"))
            result = new Helicopter();
        if (param.equals("plane"))
        {
            int count = Integer.parseInt(bufferedReader.readLine());
            result = new Plane(count);
        }
        bufferedReader.close();
    }
}
