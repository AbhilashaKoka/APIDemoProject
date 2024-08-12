package org.example.String;

import java.util.HashMap;
import java.util.Map;

public class NonRepeatedCharacter {
    public static void main(String args[]) {
        String text = "Java Guides";

        char result = findNonRepeatedCharated(text);
        if (result != '\0'){
            System.out.println("The Non repeated character is:" + result);
        } else {
            System.out.println("All character  are repeated");
        }

    }
    public static char findNonRepeatedCharated(String input) {
        Map<Character, Integer> charCount = new HashMap<>();

        for (char c:input.toCharArray()){
            charCount.put(c,charCount.getOrDefault(c,0)+1);

        }
        for(char ch:input.toCharArray()){
            if(charCount.get(ch)==1){
                return ch;
            }
        }
        return '\0';
     }
    }