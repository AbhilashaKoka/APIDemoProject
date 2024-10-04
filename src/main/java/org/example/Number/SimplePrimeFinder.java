package org.example.Number;

public class SimplePrimeFinder {


    public static void main(String[] args) {
        int number = 17;
        if (isPrime(number)){
            System.out.println(number + " is a prime number!");
        }
        else {
            System.out.println(number + " is not a prime number.");
        }
    }

    public static boolean isPrime(int num) {
        // Step 1: Basic check for numbers less than 2
        if (num < 2) {
            return false;
        }
        // Step 2: Check divisibility
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;  // num is divisible by i, so it's not prime
            }
        }
        return true;  // if we made it here, num is prime
    }
}