package com.javarush.task.task21.task2105;

import java.util.HashSet;
import java.util.Set;

/* 
Исправить ошибку. Сравнение объектов
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public int hashCode() {

        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (last != null ? last.hashCode() : 0);
        return result;
    }

    public boolean equals(Object o) {
        if (o == null)
            return false;
        if(this == o) return true;
        if (!(o instanceof Solution))
            return false;

        Solution n = (Solution) o;

        if (first != null ? !first.equals(n.first) : n.first != null) return false;
        if (last != null ? !last.equals(n.last) : n.last != null) return false;

        return true;

    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
