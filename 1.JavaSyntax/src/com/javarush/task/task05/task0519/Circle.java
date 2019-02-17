package com.javarush.task.task05.task0519;

/* 
Ходим по кругу
*/


public class Circle {
    //напишите тут ваш код
    private int centerX;
    private int centerY;
    private int radius;
    private int width;
    private int color;

    public Circle(int centerX, int centerY, int radius, int width, int color) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.width = width;
        this.color = color;
    }

    public Circle(int centerX, int centerY, int radius, int width) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.width = width;
    }

    public Circle(int centerX, int centerY, int radius) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    public static void main(String[] args) {

    }
}
