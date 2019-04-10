package com.javarush.task.task20.task2017;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* 
Десериализация
*/
public class Solution {
    public A getOriginalObject(ObjectInputStream objectStream) throws IOException {
        try {
            Object object;
            object =  objectStream.readObject();
            if(!object.getClass().equals(A.class)){
                return null;
            }
            else
            return (A) object;
        }
        catch ( Exception e){
            return null;
        }
        //return null;
    }

    public class A implements Serializable {
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args) {

    }
}
