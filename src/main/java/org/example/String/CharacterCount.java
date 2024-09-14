package org.example.String;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CharacterCount {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string:");
        String input = scanner.nextLine();

        Map<Character, Integer> charCount = countCharacters(input);
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()){
         System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }

    public static Map<Character, Integer> countCharacters(String input) {

        Map<Character, Integer> charCountMap = new HashMap<>();

        for (char c : input.toCharArray()){
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        return charCountMap;
    }


}