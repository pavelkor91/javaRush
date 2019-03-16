package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
            reader.close();
        }
        catch (IOException e){
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface{

        private String fileName;
        private String result = "";

        public void setFileName(String fullFileName){
            this.fileName = fullFileName;
        }

        public String getFileContent(){
            return result;
        }
        @Override
        public void run() {
            try (FileInputStream fileInputStream = new FileInputStream(fileName)){
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                String string;
                while ((string = bufferedReader.readLine()) != null){
                    result += string + " ";
                }

                bufferedReader.close();
            }
            catch (IOException e){}
        }
    }
}
