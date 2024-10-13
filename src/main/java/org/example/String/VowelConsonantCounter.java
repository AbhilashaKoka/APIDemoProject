package org.example.String;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class VowelConsonantCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your string:");
        String input = scanner.nextLine();
        int[] counts = countVowelsAndConsonants(input);
        System.out.println("Number of vowels: " + counts[0]);
        System.out.println("Number of consonants: " + counts[1]);

        String str = "Abhilasha Koka Koka";
        nonRepeatedCharacter(str);
    }

    public static void nonRepeatedCharacter(String str) {
        String[] arr = str.split("\\s+");
        Map<String, Integer> map = new Hashtable<>();
        for (String str2 : arr) {
            map.put(str2, map.getOrDefault(str2, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        int vowelCount = 0;
        int consonentsCount = 0;
        for (char ch : str.toLowerCase().toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                if ("aeiou".indexOf(ch) != -1) {
                    vowelCount++;
                }
                consonentsCount++;
            }
        }
        System.out.println("Vowel count:" + vowelCount + ":" + "Consonent Count:" + consonentsCount);
    }


    public static int[] countVowelsAndConsonants(String input) {
        int vowelsCount = 0, consonantsCount = 0;
        for (char c : input.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                // Ensure character is a letter
                if ("aeiou".indexOf(c) != -1) {
                    vowelsCount++;
                } else {
                    consonantsCount++;
                }
            }
        }

        return new int[]{vowelsCount, consonantsCount};
    }
}
