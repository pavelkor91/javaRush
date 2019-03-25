package com.javarush.task.task18.task1814;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {
    private FileInputStream fileInputStream;

    public TxtInputStream(String fileName) throws FileNotFoundException, UnsupportedFileNameException{
        super(fileName);
        String[] parts = fileName.split("\\.");
        if(parts[parts.length-1].equals("txt")){
            fileInputStream = new FileInputStream(fileName);
        }
        else {
            try {
                super.close();
            }
            catch (IOException e){}
            throw new UnsupportedFileNameException();
        }
    }

    @Override
    public int read() throws IOException {
        return fileInputStream.read();
    }

    @Override
    public int read(byte[] b) throws IOException {
        return fileInputStream.read(b);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        return fileInputStream.read(b, off, len);
    }

    @Override
    public long skip(long n) throws IOException {
        return fileInputStream.skip(n);
    }

    @Override
    public int available() throws IOException {
        return fileInputStream.available();
    }

    @Override
    public void close() throws IOException {
        fileInputStream.close();
    }

    @Override
    public FileChannel getChannel() {
        return fileInputStream.getChannel();
    }

    public static void main(String[] args) {
        try {
            TxtInputStream txtInputStream = new TxtInputStream("E:\\javarush\\JavaRushTasks\\resources\\file.txt");
            TxtInputStream txtInputStream2 = new TxtInputStream("E:\\javarush\\JavaRushTasks\\resources\\file.png");
        }
        catch (UnsupportedFileNameException e){}
        catch (FileNotFoundException e){}
    }
}

