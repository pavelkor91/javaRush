package com.javarush.task.task12.task1225;

/* 
Посетители
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getObjectType(new Cat()));
        System.out.println(getObjectType(new Tiger()));
        System.out.println(getObjectType(new Lion()));
        System.out.println(getObjectType(new Bull()));
        System.out.println(getObjectType(new Cow()));
        System.out.println(getObjectType(new Animal()));
    }

    public static String getObjectType(Object o) {
        //напишите тут ваш код
        Animal animal = (Animal) o;
        return animal.getType();
    }

    public static class Cat extends Animal   //<--Классы наследуются!!
    {
        public String getType(){
            return "Кот";
        }
    }

    public static class Tiger extends Cat {
        public String getType(){
            return "Тигр";
        }
    }

    public static class Lion extends Cat {
        public String getType(){
            return "Лев";
        }
    }

    public static class Bull extends Animal {
        public String getType(){
            return "Бык";
        }
    }

    public static class Cow extends Animal {
        public String getType(){
            return "Корова";
        }
    }

    public static class Animal {
        public String getType(){
            return "Животное";
        }
    }
}
