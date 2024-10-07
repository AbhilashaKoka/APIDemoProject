package org.example.String;

import io.cucumber.java.sl.In;

import java.util.HashMap;
import java.util.Map;

public class DuplicateWordCounter {
    public static void main(String[] args){
        String Input="Java is great and java is fun, Programming in java is great";
        String normalizedStr=Input.toLowerCase();
        String[] words=normalizedStr.split("\\W+");

        Map<String, Integer> wordCountMap=new HashMap<>();
        for(String word:words){
            if(wordCountMap.containsKey(word)){
                wordCountMap.put(word,wordCountMap.get(word)+1);
            }
            else {
                wordCountMap.put(word,1);
            }
        }


        System.out.println("Duplicate words in the String:");
            for(Map.Entry<String, Integer> entry:wordCountMap.entrySet()){

             if(entry.getValue()>1)
             {
                System.out.println(entry.getKey()+":"+entry.getValue());
             }
        }
    }
}
