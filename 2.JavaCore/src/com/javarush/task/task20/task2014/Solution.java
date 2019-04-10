package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable{
    public static void main(String[] args) throws IOException {

        Solution savedObject = new Solution(5);
        File your_file_name = File.createTempFile("tmp_file_serial.txt", null);
        FileOutputStream fileOutput = new FileOutputStream(your_file_name);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutput);

        objectOutputStream.writeObject(savedObject);
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream(your_file_name);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        try {
            Solution loadedObject = (Solution) objectInputStream.readObject();
            if(savedObject.string.equals(loadedObject.string)){
                System.out.println("Равны");
            }
            else
                System.out.println("Не равны");
        }
        catch (ClassNotFoundException e){
            System.out.println("smth wrong");
        }
        System.out.println(new Solution(4));



    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
