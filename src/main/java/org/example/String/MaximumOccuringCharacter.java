package org.example.String;

import java.util.HashMap;
import java.util.Map;

public class MaximumOccuringCharacter {
    public static void main(String[] args) {
        String str = "sample string";
        maxOccurOfChar(str);

    }
    public static void maxOccurOfChar(String str){
        Map<Character,Integer> charfrequencyMap=new HashMap();
        char maxOcurringChar=' ';
        int maxFequency=0;
        for(char c:str.toCharArray()){
            charfrequencyMap.put(c,charfrequencyMap.getOrDefault(c,0)+1);
        }
        for(Map.Entry<Character,Integer> entry:charfrequencyMap.entrySet()){
            if(entry.getValue()> maxFequency)
            {
                maxFequency=entry.getValue();
                maxOcurringChar= entry.getKey();
            }
        }
        System.out.println("Maximum Occuring character:'"+maxOcurringChar+"'with a frequency of"+maxFequency);

    }
}
