package com.javarush.task.task19.task1904;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("E:\\javarush\\JavaRushTasks\\resources\\file.txt");
        Scanner fileScanner = new Scanner(file);
        Person person = new PersonScannerAdapter(fileScanner).read();
        System.out.println(person);

    }

    public static class PersonScannerAdapter implements PersonScanner{

        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner){
            this.fileScanner =  fileScanner;
        }

        @Override
        public Person read() {
            String[] allData = fileScanner.nextLine().split(" ");
            System.out.println(allData.toString());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM yyyy");
            StringBuilder sb = new StringBuilder();
            for(int i = 3; i <= 5; i++)
                sb.append(allData[i]).append(" ");
            Date date = null;
            try {
                date = simpleDateFormat.parse(sb.toString());
            }
            catch (ParseException e){}


           return new Person(allData[1], allData[2], allData[0], date);
        }

        @Override
        public void close() {
            this.fileScanner.close();
        }
    }
}
