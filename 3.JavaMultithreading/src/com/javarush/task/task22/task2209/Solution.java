package com.javarush.task.task22.task2209;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //...
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        File filePath = new File(bufferedReader.readLine());
        bufferedReader.close();

        FileReader fileReader = new FileReader(filePath);
        bufferedReader = new BufferedReader(fileReader);
        StringBuilder sb = new StringBuilder();

        while (bufferedReader.ready())
            sb.append(bufferedReader.readLine());

        String[] arrayWords = sb.toString().split(" ");
        StringBuilder result = getLine(arrayWords);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder sb = new StringBuilder();
        if (words == null || words.length == 0) return sb;
        if (words.length==1 || words[0].equals("")) return sb.append(words[0]);

        ArrayList<String> wordsList = new ArrayList<>();

        wordsList.addAll(Arrays.asList(words));
        while (wordsList.remove("")){
            wordsList.remove("");
        }
        while (isYes(wordsList)) {
            Collections.shuffle(wordsList);
        }
        for (String word: wordsList){
            sb.append(word).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb;
    }
    public static boolean isYes(ArrayList<String> wordsList) {
        for (int i = 0; i < wordsList.size() - 1; i++) {
            String firstWord = wordsList.get(i).toLowerCase();
            String secondWord = wordsList.get(i + 1).toLowerCase();
            if (firstWord.charAt(firstWord.length() - 1) != secondWord.charAt(0)) return true;
        }
        return false;
    }
}
