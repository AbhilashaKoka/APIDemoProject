package org.example.javaDemo.Arrays;
import java.util.Scanner;

public class PrimeNumberWithUserInput {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the first Number:");
        int start = s.nextInt();
        System.out.println("Enter the second Number:");
        int end = s.nextInt();
        System.out.println("List of prime numbers between" + start + "and" + end);
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}


