package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {

        FileReader fileReader = new FileReader(args[0]);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Map<String, Double> treeMap = new TreeMap<>();

        while (bufferedReader.ready()) {
            String[] pair = bufferedReader.readLine().split(" ");

            StringBuilder date = new StringBuilder();
            date.append(pair[pair.length - 3]); date.append(" ");
            date.append(pair[pair.length - 2]); date.append(" ");
            date.append(pair[pair.length - 1]); date.append(" ");

            Date personDate = null;
            try {
                personDate = new SimpleDateFormat("dd MM yyyy").parse(date.toString());
            }
            catch (ParseException e){}

            StringBuilder name = new StringBuilder();
            for (int i = 0; i < pair.length - 3; i++) {
                name.append(pair[i]);
                name.append(" ");
            }
            PEOPLE.add(new Person(name.toString().trim(), personDate));
        }
        fileReader.close();

        for(Person person: PEOPLE)
            System.out.println(person.getName() + " " + person.getBirthDate().toString());
    }
}
