package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> words = detectAllWords(crossword, "home", "same");
        for(Word word: words)
            System.out.println(word);

        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> allWords = new ArrayList<>();
        for(String word: words){
            for(int i = 0; i < crossword.length; i++){
                for(int j = 0; j < crossword[i].length; j++){
                    if(crossword[i][j] == word.charAt(0)){
                        fillWordsArray(checkN(crossword,word, i, j), allWords);
                        fillWordsArray(checkS(crossword, word, i, j), allWords);
                        fillWordsArray(checkE(crossword, word, i, j), allWords);
                        fillWordsArray(checkW(crossword, word, i, j), allWords);
                        fillWordsArray(checkSE(crossword, word, i, j), allWords);
                        fillWordsArray(checkSW(crossword, word, i, j), allWords);
                        fillWordsArray(checkWN(crossword, word, i, j), allWords);
                        fillWordsArray(checkNE(crossword, word, i, j), allWords);
                    }
                }
            }
        }
        return allWords;
    }

    public static void fillWordsArray(Word word, List<Word> list){
        if(word != null) {
            list.add(word);
        }
    }

    public static Word checkN(int[][] crossword, String word, int startY, int startX){
        Word newWord = null;
        boolean nextTrue = true;
        for(int i = 0; i < word.length(); i++){
            try {
                if (crossword[startY - i][startX] == word.charAt(i)) {
                    continue;
                } else {
                    nextTrue = false;
                    break;
                }
            }
            catch (ArrayIndexOutOfBoundsException e){
                nextTrue = false;
                break;
            }
        }
        if(nextTrue == true){
            newWord = new Word(word);
            newWord.setStartPoint(startX, startY);
            newWord.setEndPoint(startX, startY - (word.length() - 1));
        }
        return newWord;
    }

    public static Word checkS(int[][] crossword, String word, int startY, int startX){
        Word newWord = null;
        boolean nextTrue = true;
        for(int i = 0; i < word.length(); i++){
            try {
                if (crossword[startY + i][startX] == word.charAt(i)) {
                    continue;
                } else {
                    nextTrue = false;
                    break;
                }
            }
            catch (ArrayIndexOutOfBoundsException e){
                nextTrue = false;
                break;
            }
        }
        if(nextTrue == true){
            newWord = new Word(word);
            newWord.setStartPoint(startX, startY);
            newWord.setEndPoint(startX, startY + (word.length() - 1));
        }
        return newWord;

    }
    public static Word checkE(int[][] crossword, String word, int startY, int startX){
        Word newWord = null;
        boolean nextTrue = true;
        for(int i = 0; i < word.length(); i++){
            try {
                if (crossword[startY][startX + i] == word.charAt(i)) {
                    continue;
                } else {
                    nextTrue = false;
                    break;
                }
            }
            catch (ArrayIndexOutOfBoundsException e){
                nextTrue = false;
                break;
            }
        }
        if(nextTrue == true){
            newWord = new Word(word);
            newWord.setStartPoint(startX, startY);
            newWord.setEndPoint(startX + (word.length() - 1), startY);
        }
        return newWord;
    }

    public static Word checkW(int[][] crossword, String word, int startY, int startX){
        Word newWord = null;
        boolean nextTrue = true;
        for(int i = 0; i < word.length(); i++){
            try {
                if (crossword[startY][startX - i] == word.charAt(i)) {
                    continue;
                } else {
                    nextTrue = false;
                    break;
                }
            }
            catch (ArrayIndexOutOfBoundsException e){
                nextTrue = false;
                break;
            }
        }
        if(nextTrue == true){
            newWord = new Word(word);
            newWord.setStartPoint(startX, startY);
            newWord.setEndPoint(startX - (word.length() - 1), startY);
        }
        return newWord;
    }
    public static Word checkSE(int[][] crossword, String word, int startY, int startX){
        Word newWord = null;
        boolean nextTrue = true;
        for(int i = 0; i < word.length(); i++){
            try {
                if (crossword[startY + i][startX + i] == word.charAt(i)) {
                    continue;
                } else {
                    nextTrue = false;
                    break;
                }
            }
            catch (ArrayIndexOutOfBoundsException e){
                nextTrue = false;
                break;
            }
        }
        if(nextTrue == true){
            newWord = new Word(word);
            newWord.setStartPoint(startX, startY);
            newWord.setEndPoint(startX + (word.length() - 1), startY + (word.length() - 1));
        }
        return newWord;
    }
    public static Word checkSW(int[][] crossword, String word, int startY, int startX){
        Word newWord = null;
        boolean nextTrue = true;
        for(int i = 0; i < word.length(); i++){
            try {
                if (crossword[startY + i][startX - i] == word.charAt(i)) {
                    continue;
                } else {
                    nextTrue = false;
                    break;
                }
            }
            catch (ArrayIndexOutOfBoundsException e){
                nextTrue = false;
                break;
            }
        }
        if(nextTrue == true){
            newWord = new Word(word);
            newWord.setStartPoint(startX, startY);
            newWord.setEndPoint(startX - (word.length() - 1), startY + (word.length() - 1));
        }
        return newWord;
    }
    public static Word checkWN(int[][] crossword, String word, int startY, int startX){
        Word newWord = null;
        boolean nextTrue = true;
        for(int i = 0; i < word.length(); i++){
            try {
                if (crossword[startY - i][startX - i] == word.charAt(i)) {
                    continue;
                } else {
                    nextTrue = false;
                    break;
                }
            }
            catch (ArrayIndexOutOfBoundsException e){
                nextTrue = false;
                break;
            }
        }
        if(nextTrue == true){
            newWord = new Word(word);
            newWord.setStartPoint(startX, startY);
            newWord.setEndPoint(startX - (word.length() - 1), startY - (word.length() - 1));
        }
        return newWord;
    }
    public static Word checkNE(int[][] crossword, String word, int startY, int startX){
        Word newWord = null;
        boolean nextTrue = true;
        for(int i = 0; i < word.length(); i++){
            try {
                if (crossword[startY - i][startX + i] == word.charAt(i)) {
                    continue;
                } else {
                    nextTrue = false;
                    break;
                }
            }
            catch (ArrayIndexOutOfBoundsException e){
                nextTrue = false;
                break;
            }
        }
        if(nextTrue == true){
            newWord = new Word(word);
            newWord.setStartPoint(startX, startY);
            newWord.setEndPoint(startX + (word.length() - 1), startY - (word.length() - 1));
        }
        return newWord;
    }



    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
