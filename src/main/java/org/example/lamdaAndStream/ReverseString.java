package org.example.lamdaAndStream;

public class ReverseString {
    public static void main(String[] args) {
        String originalString = "Hello";
        reverseString(originalString);
    }
    public static  void reverseString(String originalString){
        String reverseString=new StringBuilder(originalString).reverse().toString();

        System.out.println("Original String:"+originalString);
        System.out.println("Reversed String:"+reverseString);
    }
}
