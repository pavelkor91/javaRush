package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Cat grandFather = new Cat(reader.readLine());
        Cat granMother = new Cat(reader.readLine());
        Cat father = new Cat(reader.readLine(),null, grandFather);
        Cat mother = new Cat(reader.readLine(), granMother, null);
        Cat son = new Cat(reader.readLine(), mother, father);
        Cat daughter = new Cat(reader.readLine(), mother, father);

        System.out.println(grandFather);
        System.out.println(granMother);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(son);
        System.out.println(daughter);

    }

    public static class Cat {
        private String name;
        private Cat mother;
        private Cat father;

        Cat(String name) {
            this.name = name;
        }


        Cat (String name, Cat mother, Cat father){
            this.name = name;
            this.father = father;
            this.mother = mother;
        }

        @Override
        public String toString() {
            if (this.mother == null && this.father == null)
                return "The cat's name is " + this.name + ", no mother, no father";
            else if (this.mother == null && this.father != null)
                return "The cat's name is " + this.name + ", no mother, father is " + this.father.name;
            else if (this.mother != null && this.father == null)
                return "The cat's name is " + this.name + ", mother is " + this.mother.name + ", no father";
            else
                return "The cat's name is " + this.name + ", mother is " + this.mother.name + ", father is " + this.father.name;
        }
    }

}
