package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // Напишите тут ваши переменные и конструкторы
        private int age;
        private String name;
        private String lastName;
        private boolean sex;
        private Human mother;
        private Human father;

        public Human(int age) {
            this.age = age;
        }

        public Human(int age, String name, String lastName, boolean sex, Human mother, Human father) {
            this.age = age;
            this.name = name;
            this.lastName = lastName;
            this.sex = sex;
            this.mother = mother;
            this.father = father;
        }

        public Human() {
        }

        public Human(int age, String name, String lastName) {
            this.age = age;
            this.name = name;
            this.lastName = lastName;
        }

        public Human(boolean sex, Human mother, Human father) {
            this.sex = sex;
            this.mother = mother;
            this.father = father;
        }

        public Human(Human mother, Human father) {
            this.mother = mother;
            this.father = father;
        }

        public Human(String name, String lastName) {
            this.name = name;
            this.lastName = lastName;
        }

        public Human(int age, String name, String lastName, boolean sex, Human mother) {
            this.age = age;
            this.name = name;
            this.lastName = lastName;
            this.sex = sex;
            this.mother = mother;
        }

        public Human(int age, String name, boolean sex) {
            this.age = age;
            this.name = name;
            this.sex = sex;
        }

        public Human(String lastName, Human mother) {
            this.lastName = lastName;
            this.mother = mother;
        }
    }
}
