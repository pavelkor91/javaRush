package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        File file = new File(bufferedReader.readLine());
        bufferedReader.close();

        FileReader fileReader = new FileReader(file);
        bufferedReader = new BufferedReader(fileReader);
        StringBuilder sb = new StringBuilder();
        while (bufferedReader.ready()){
            sb.append(bufferedReader.readLine());
            sb.append(" ");
        }
        String[] allWords = sb.toString().split("\\s+");
        for(int i = 0; i < allWords.length; i++){
            if(allWords[i] == null)
            {
                continue;
            }
            for(int j = i + 1; j < allWords.length - 1; j++){
                if(allWords[j] != null) {
                    StringBuilder tmp = new StringBuilder(allWords[j]);
                    if (allWords[i].equals(tmp.reverse().toString())) {
                        result.add(new Pair(allWords[i], allWords[j]));
                        allWords[i] = null;
                        allWords[j] = null;
                        break;
                    }
                }
            }
        }
        for(Pair pair: result)
            System.out.println(pair.toString());
    }

    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;
        }
    }

}
