package org.example.Number;

import java.util.Scanner;

public class NaturalNumberSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number up to which you want the sum:");
        int n = scanner.nextInt();

        int sum = calculateSum(n);
        System.out.println("The sum of the first " + n + " natural numbers is: " + sum);
    }

    public static int calculateSum(int n) {
        return n * (n + 1) / 2;
    }
}