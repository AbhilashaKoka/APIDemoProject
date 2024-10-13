package org.example.Number;

import java.util.Scanner;

public class DiamondShapePattern {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Diamond Shape Pattern Generator");
        System.out.print("Enter the number of rows for half of the diamond: ");
        int numRows = scanner.nextInt();
        diamondPattern(numRows);
         scanner.close();
    }

    public static void diamondPattern(int numRows){
              for (int i = 1; i <= numRows; i++)
              {
                       for (int j = numRows - i; j >= 1; j--){
                        System.out.print(" ");
            }

            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = numRows - 1; i >= 1; i--) {

            for (int j = 1; j <= numRows - i; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }


    }
}