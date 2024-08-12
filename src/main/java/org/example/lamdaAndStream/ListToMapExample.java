package org.example.lamdaAndStream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMapExample {
    public static void main(String[] args){
        //Create a list of Strings
        List<String> items= List.of("apple","banana","cherry");

        //Converting a List to a Map where the key is a string and the value is its length
        Map<String, Integer> itemMap=items.stream()
                .collect(Collectors.toMap(item->item, item->item.length()));

        Map<String, Integer> itemMap2=items.stream()
                .collect(Collectors.toMap(item->item, String::length));

        //


        System.out.println("List to map:"+itemMap2);
        itemMap.forEach((key,value)-> System.out.println(key+":"+value));
    }
}
