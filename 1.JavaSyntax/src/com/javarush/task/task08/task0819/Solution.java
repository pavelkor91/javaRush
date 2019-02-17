package com.javarush.task.task08.task0819;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Set из котов
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();

        //напишите тут ваш код. step 3 - пункт 3
        Iterator cat = cats.iterator();
        cats.remove(cat.next());
        printCats(cats);
    }

    public static Set<Cat> createCats() {
        Set<Cat> cats = new HashSet<>();
        for(int i = 0; i < 3; i++)
            cats.add(new Cat());
        return cats;
    }

    public static void printCats(Set<Cat> cats) {
        cats.forEach(System.out::println);
    }
    public static class Cat{

    }
    // step 1 - пункт 1
}
