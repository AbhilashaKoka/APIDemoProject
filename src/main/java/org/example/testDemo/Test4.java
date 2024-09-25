package org.example.testDemo;

public class Test4 {
    public static void foo(Integer i){
        System.out.println("foo(Integer)");

    }
    public static void foo(short i){
        System.out.println("foo(short)");
    }
    public static void foo(long i){
        System.out.println("foo(long)");
    }
    public static void foo(int...i){
        System.out.println("foo(int...)");
    }
    public static void main(String[] args){
        foo(10);

    }

}
