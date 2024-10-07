package org.example.String;

public class StringMethodInJAVA11 {
    public static void main(String[] args){
        String str="JAVA11";
        System.out.println(str.isBlank());
        System.out.println(str.strip());
        System.out.println(str.stripLeading());
        System.out.println(str.stripTrailing());
        System.out.println("java\nKotlin\nScala".lines().count());
        System.out.println("Hello".repeat(3));

    }
}
