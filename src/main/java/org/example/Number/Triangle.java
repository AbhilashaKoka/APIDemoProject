package org.example.Number;

import java.util.Scanner;

public class Triangle {
    private int a;
    private int b;
    private int c;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void determineType() {
        if(a >= (b+c) || c >= (b+a) || b >= (a+c) ) {
            System.out.println( "Not a Triangle");
        } else if(a==b && b==c) {
            System.out.println( "Equilateral Triangle");
        } else if (((a * a) + (b * b)) == (c * c) || ((a * a) + (c * c)) == (b * b) || ((c * c) + (b * b)) == (a * a)) {
            System.out.println( "Right Triangle");
        } else if(a!=b && b!=c && c!=a) {
            System.out.println( "Scalene Triangle" );
        } else if ((a==b && b!=c ) || (a!=b && c==a) || (c==b && c!=a)) {
            System.out.println( "Isosceles Triangle");
        }
    }

    public static void main(String [] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the sides of Triangle");
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        Triangle t = new Triangle(a, b, c);
        t.determineType();
    }
}