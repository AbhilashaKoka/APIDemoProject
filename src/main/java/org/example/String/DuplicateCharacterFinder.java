package org.example.String;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DuplicateCharacterFinder {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the String:");
        String str=scanner.nextLine();
        duplicateCharacterCount(str);
        String sentence = "Java id a programming language and java is also a platform";
        System.out.println("Duplicate words in the string is:");
        findDuplicateCharacter2(sentence);

    }

    public static void duplicateCharacterCount(String input){
        String[] strings=input.split("");
        Map<String, Integer> strCount=new HashMap<>();
        for(String str:strings){
            strCount.put(str,strCount.getOrDefault(str,0)+1);
        }
        for(Map.Entry<String, Integer> entry:strCount.entrySet()){
            if(entry.getValue()>1)
             {
              System.out.println("Duplicate Character:"+entry.getKey()+":"+entry.getValue());
             }
           }
    }

    public static void findDuplicateCharacter2(String str) {
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
