package org.example.javaDemo.Arrays;

import java.util.Scanner;

public class SmallestOfThreeNumber {
    public static void main(String[] args) {
        int a, b, c, largest;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first Number");
        a = sc.nextInt();
        System.out.println("Enter the Second Number");
        b = sc.nextInt();
        System.out.println("Enter the third Number");
        c = sc.nextInt();
        largest=c<(a<b?a:b)?c:((a<b)?a:b);
        System.out.println("The smallest number is :"+largest);

    }
}
