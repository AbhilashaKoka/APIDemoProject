package org.example.String;
import java.util.HashMap;
import java.util.Map;

public class DuplicateWordFinder{
    public static void main(String args[]) {
        String sentence = "Java id a programming language and java is also a platform";
        System.out.println("Duplicate words in the string is:");
        findDuplicateWords(sentence);
    }

    public static void findDuplicateWords(String str) {
        String[] words = str.split("");
        Map<String, Integer> wordCountMap = new HashMap<>();

        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + ":" + entry.getValue() + "times");
            }
        }
    }
}
