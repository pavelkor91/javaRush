package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {

        Human child1 = new Human("afsgd", true,21, new ArrayList<>());
        Human child2 = new Human("afsgg", true,21, new ArrayList<>());
        Human child3 = new Human("dqdwq", false,16, new ArrayList<>());
        ArrayList<Human> grands = new ArrayList<>();
        grands.add(child1);
        grands.add(child2);
        grands.add(child3);
        Human mother = new Human("asf", true, 45, new ArrayList<>(grands));
        Human father = new Human("dfv", false, 41, new ArrayList<>(grands));
        grands.clear();
        grands.add(mother);
        Human granny1 = new Human("Asd", true, 65, new ArrayList<>(grands));
        Human granny3 = new Human("Basd", false, 68, new ArrayList<>(grands));
        grands.clear();
        grands.add(father);
        Human granny2 = new Human("Asdsd", true, 66, new ArrayList<>(grands));
        Human granny4 = new Human("Bids", false, 63, new ArrayList<>(grands));

        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);
        System.out.println(mother);
        System.out.println(father);

        System.out.println(granny1);
        System.out.println(granny2);
        System.out.println(granny3);
        System.out.println(granny4);

    }

    public static class Human {
        //напишите тут ваш код
         String name;
         boolean sex;
         int age;
         ArrayList<Human> children;

        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
