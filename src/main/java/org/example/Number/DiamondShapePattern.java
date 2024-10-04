package org.example.Number;

import java.util.Scanner;

public class DiamondShapePattern {

    public static void main(String[] args) {
        // Initialize scanner to read from the console
        Scanner scanner = new Scanner(System.in);
        // Display the program title
        System.out.println("Diamond Shape Pattern Generator");
        // Ask the user for the number of rows (half of the diamond height)
        System.out.print("Enter the number of rows for half of the diamond: ");
        int numRows = scanner.nextInt(); // Read the number of rows from user input
        // Print the upper half of the diamond
        for (int i = 1; i <= numRows; i++) {
            // Print leading spaces
            for (int j = numRows - i; j >= 1; j--) {
                System.out.print(" ");
            }
            // Print stars
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println(); // Move to the next line
        }
        // Print the lower half of the diamond
        for (int i = numRows - 1; i >= 1; i--) {
            // Print leading spaces
            for (int j = 1; j <= numRows - i; j++) {
                System.out.print(" ");
            }
            // Print stars
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println(); // Move to the next line
        }
        // Close the scanner
        scanner.close();
    }
}