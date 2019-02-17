package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        Human granny1 = new Human("Алла",false,65, null, null);
        Human granny2 = new Human("Маша",false,67);
        Human granny3 = new Human("Дима",true,65);
        Human granny4 = new Human("Едик",true,87);
        Human mother = new Human("Анна", false, 36, granny1, granny4);
        Human father = new Human("Денис", true, 42, granny2, granny3);
        Human child1 = new Human("Рома", true,10, father, mother);
        Human child2 = new Human("Петя", true,12, father, mother);
        Human child3 = new Human("Надя", false,15, father, mother);

        System.out.println(granny1);
        System.out.println(granny2);
        System.out.println(granny3);
        System.out.println(granny4);
        System.out.println(mother);
        System.out.println(father);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);
    }

    public static class Human {
        // напишите тут ваш код
        private String name;
        private boolean sex;
        private int age;
        private Human father;
        private Human mother;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}