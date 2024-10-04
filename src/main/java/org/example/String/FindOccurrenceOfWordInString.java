package org.example.String;
import java.util.Hashtable;
import java.util.Map;

public class FindOccurrenceOfWordInString {

        public static void main(String[] args) {
        String text="this is a test this is only a test";
        String[] words=text.split(" ");

        Map<String ,Integer> wordCount=new Hashtable<>();

        for(String word:words)
        {
            if(wordCount.containsKey(word))
            {
             wordCount.put(word, wordCount.get(word)+1);
            }
            else
            {
             wordCount.put(word,1);
            }
        }

        System.out.println("word Occurrence");
        for(Map.Entry<String, Integer> entry:wordCount.entrySet())
        {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
}
