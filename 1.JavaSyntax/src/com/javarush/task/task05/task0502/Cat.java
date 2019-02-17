package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        if (this.weight > anotherCat.weight)
            return true;
        if(this.weight == anotherCat.weight) {
            if (this.strength > anotherCat.strength)
                return true;
            else if (this.strength == anotherCat.strength)
                if (this.age < anotherCat.age)
                    return true;
                else return false;
        }
        return  false;

        //напишите тут ваш код
    }

    public static void main(String[] args) {

    }
}
