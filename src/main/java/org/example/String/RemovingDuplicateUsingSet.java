package org.example.String;

import java.util.*;
import java.util.stream.Collectors;

public class RemovingDuplicateUsingSet {
    public static void main(String[] args){
        String input="Java is great and java is fun and java is powerful";

        String result =removeTheDuplicateWords(input);
        System.out.println(result);


    }

    public static String removeTheDuplicateWords(String input ){
        String normalizedStr=input.toLowerCase();
        String[] words=normalizedStr.split("\\s+");
         Set<String> wordset = new HashSet<>();
          StringBuilder result=new StringBuilder();

       for(String word:words){
               if(!wordset.contains(word)){
               wordset.add(word);
               result.append(word).append(" ");
           }
       }
        return result.toString().trim();
    }


    public static String removeduplicateWords(String input){
        Set<String> wordSet=Arrays.stream(input.split("\\s+"))
                .collect(Collectors.toCollection(LinkedHashSet::new));
        return String.join(" ",wordSet);

    }


}
