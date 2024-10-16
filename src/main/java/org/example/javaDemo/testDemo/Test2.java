package org.example.javaDemo.testDemo;

public class Test2 {
    public static void main(String[] args) {
        String s1="hello";
        String s2= "hello";

    //    s2=s2.intern();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1.equals(s2));
    }
}
