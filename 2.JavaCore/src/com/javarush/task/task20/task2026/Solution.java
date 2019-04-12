package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {
        int count = 0;
        int corners = 0;
        int lines = 0;
        int dots = 0;
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a.length; j++) {
                int sum = 0;
                if (a[i][j] == 1) {
                    for (int n = i - 1; n <= i + 1; n++) {
                        for (int m = j - 1; m <= j + 1; m++) {
                            try {
                                sum += a[n][m];
                            } catch (ArrayIndexOutOfBoundsException e) {
                                continue;
                            }
                        }
                    }
                    sum = sum - a[i][j];
                    if (sum == 3)
                        corners++;
                    if (sum == 1)
                        lines++;
                    if (sum == 0)
                        dots++;
                }
            }
        }
        count = corners / 4 + lines / 2 + dots;
        return count;
    }
}
