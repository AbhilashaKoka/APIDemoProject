package org.example.String;

import java.util.Scanner;

public class VowelConsonantCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your string:");
        String input = scanner.nextLine();
        int[] counts = countVowelsAndConsonants(input);
        System.out.println("Number of vowels: " + counts[0]);
        System.out.println("Number of consonants: " + counts[1]);
    }

    public static int[] countVowelsAndConsonants(String input) {
        int vowelsCount = 0, consonantsCount = 0;
        for (char c : input.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z')
            {
                // Ensure character is a letter
                if ("aeiou".indexOf(c) != -1) {
                    vowelsCount++;
                }
                else {
                    consonantsCount++;
                }
            }
        }

        return new int[]{vowelsCount, consonantsCount};
    }
}