package org.example.lamdaAndStream;

import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number:");
        String number = scanner.nextLine();
        sumOfAllDigits(number);
        scanner.close();
    }


    public static void sumOfAllDigits(String number){

         int sum=number.chars()
                 .map(Character::getNumericValue)
                 .sum();

        System.out.println("The sum of the digits is:"+sum);
    }
}
