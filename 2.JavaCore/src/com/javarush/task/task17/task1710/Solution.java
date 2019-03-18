package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        if(args[0].equals("-c")){
            if(args[2].equals("м")) {
                try {
                    allPeople.add(Person.createMale(args[1], new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[3])));
                    System.out.println(allPeople.size() - 1);
                } catch (ParseException e) {
                    System.out.println(e);
                }
            }
            if(args[2].equals("ж")) {
                try {
                    allPeople.add(Person.createFemale(args[1], new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[3])));
                    System.out.println(allPeople.size() - 1);
                } catch (ParseException e) {
                    System.out.println(e);
                }
            }
        }
        else if(args[0].equals("-u")){
            allPeople.get(Integer.parseInt(args[1])).setName(args[2]);
            if(args[3].equals("м"))
                allPeople.get(Integer.parseInt(args[1])).setSex(Sex.MALE);
            if(args[3].equals("ж"))
                allPeople.get(Integer.parseInt(args[1])).setSex(Sex.FEMALE);
            try {
                allPeople.get(Integer.parseInt(args[1])).setBirthDate(new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[4]));
            }
            catch (ParseException e){
                System.out.println(e);
            }
        }
        else if (args[0].equals("-d")){
            allPeople.get(Integer.parseInt(args[1])).setBirthDate(null);
            allPeople.get(Integer.parseInt(args[1])).setSex(null);
            allPeople.get(Integer.parseInt(args[1])).setName(null);

        }
        else if (args[0].equals("-i")){
            SimpleDateFormat modifyDate = new SimpleDateFormat("d-MMM-y", Locale.ENGLISH);
            String result = allPeople.get(Integer.parseInt(args[1])).getName();
            if(allPeople.get(Integer.parseInt(args[1])).getSex() == Sex.FEMALE)
                result += " ж ";
            else
                result += " м ";
            result += modifyDate.format(allPeople.get(Integer.parseInt(args[1])).getBirthDate());

            System.out.println(result);
        }

        else
            System.out.println("unknow argument");


    }
}
