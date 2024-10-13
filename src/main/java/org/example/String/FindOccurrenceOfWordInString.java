package org.example.String;
import java.util.Hashtable;
import java.util.Map;

public class FindOccurrenceOfWordInString {

    public static void main(String[] args) {
        String text = "this is a test this is only a test";
        findOccurrenceOfWordInStr(text);
        String str = "This is an example string, an example of a string.";
        String word = "example";
        findOccurOfWordInStr(str,word);

    }
        public static void findOccurrenceOfWordInStr(String text) {
            String[] words = text.split(" ");
            Map<String, Integer> wordCount = new Hashtable<>();
            for (String word : words) {
                if (wordCount.containsKey(word)) {
                    wordCount.put(word, wordCount.get(word) + 1);
                } else {
                    wordCount.put(word, 1);
                }
            }

            System.out.println("word Occurrence");
            for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }
        }


    public static void findOccurOfWordInStr(String str, String word){
        int count = 0;
    // Convert string to lower case to make the search case-insensitive
    String lowerCaseStr = str.toLowerCase();
    String lowerCaseWord = word.toLowerCase();
    // Split the string into words
    String[] words = lowerCaseStr.split("\\s+");
    // Count the occurrence of the word
        for (String w : words)
        {
        if (w.equals(lowerCaseWord))
        {
            count++;
        }
    }
        System.out.println("The word '" + word + "' appears " + count + " times in the string.");
}
    }

