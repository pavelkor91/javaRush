package com.javarush.task.task05.task0526;

/* 
Мужчина и женщина
*/

public class Solution {
    public static void main(String[] args) {
        Man man1 = new Man("Вася", 15, "sasfaf");
        Man man2 = new Man("Петя", 25, "asfas");

        Woman woman1 = new Woman("Ася", 15, "qfwfwq");
        Woman woman2 = new Woman("Lbyf", 25, "safaf");

        System.out.println(man1);
        System.out.println(man2);
        System.out.println(woman1);
        System.out.println(woman2);

        //напишите тут ваш код
    }
    public static class Man{
        private String name;
        private int age;
        private String address;

        public Man(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public String toString(){
            return this.name + " " + this.age + " " + this.address;
        }
    }

    public static class Woman{
        private String name;
        private int age;
        private String address;

        public Woman(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public String toString(){
            return this.name + " " + this.age + " " + this.address;
        }
    }
    //напишите тут ваш код
}
