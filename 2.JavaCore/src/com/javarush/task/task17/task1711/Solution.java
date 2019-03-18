package com.javarush.task.task17.task1711;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        switch (args[0]){
            case "-c":
                synchronized (allPeople) {
                    create(args);
                    break;
                }
            case "-u":
                synchronized (allPeople) {
                    update(args);
                    break;
                }
            case "-d":
                synchronized (allPeople) {
                    delete(args);
                    break;
                }
            case "-i":
                synchronized (allPeople) {
                    info(args);
                    break;
                }
                default:
                    synchronized(allPeople){ }
                    System.out.println("unknow argument");
                    break;

        }
    }

    public static synchronized void create(String[] args){
        for(int i = 1; i < args.length; i += 3){
            if(args[i + 1].equals("м")){
                try {
                    allPeople.add(Person.createMale(args[i],new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[i + 2])));
                }
                catch (ParseException e){
                    System.out.println(e);
                }
            }
            if(args[i + 1].equals("ж")){
                try {
                    allPeople.add(Person.createFemale(args[i],new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[i + 2])));
                }
                catch (ParseException e){
                    System.out.println(e);
                }
            }
            System.out.println(allPeople.size() - 1);
        }
    }
    public static synchronized void update(String[] args){
        for(int i = 1; i < args.length; i += 4){
            allPeople.get(Integer.parseInt(args[i])).setName(args[i + 1]);
            if(args[i + 2].equals("м"))
                allPeople.get(Integer.parseInt(args[i])).setSex(Sex.MALE);
            if(args[i + 2].equals("ж"))
                allPeople.get(Integer.parseInt(args[i])).setSex(Sex.FEMALE);
            try {
                allPeople.get(Integer.parseInt(args[i])).setBirthDate(new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[i + 3]));
            }
            catch (ParseException e){
                System.out.println(e);
            }
        }
    }

    public static synchronized void delete(String[] args){
        for(int i = 1; i < args.length; i++){
            allPeople.get(Integer.parseInt(args[i])).setName(null);
            allPeople.get(Integer.parseInt(args[i])).setBirthDate(null);
            allPeople.get(Integer.parseInt(args[i])).setSex(null);
        }
    }

    public static synchronized void info(String[] args){
        SimpleDateFormat modifyDate = new SimpleDateFormat("d-MMM-y", Locale.ENGLISH);
        for(int i = 1; i < args.length; i++){
            String result = allPeople.get(Integer.parseInt(args[i])).getName();
            if(allPeople.get(Integer.parseInt(args[i])).getSex() == Sex.FEMALE)
                result += " ж ";
            else
                result += " м ";
            result += modifyDate.format(allPeople.get(Integer.parseInt(args[i])).getBirthDate());
            System.out.println(result);
        }
    }
}
