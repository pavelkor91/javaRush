package com.javarush.task.task05.task0514;

/* 
Программист создает человека
*/

public class Solution {
    public static void main(String[] args) {
        Person person = new Person();
        person.initialize("Павел", 27);
        //напишите тут ваш код
    }

    static class Person {
        //напишите тут ваш код
        private String name;
        private int age;

        public void initialize(String name, int age){
            this.age = age;
            this.name = name;
        }
    }
}
