package org.example.lamdaAndStream;

import java.sql.SQLOutput;

public class ReverseString {
    public static void main(String[] args){
        String originalString="Hello";
        String reverseString=new StringBuilder(originalString).reverse().toString();

        System.out.println("Original String:"+originalString);
        System.out.println("Reversed String:"+reverseString);
    }
}
