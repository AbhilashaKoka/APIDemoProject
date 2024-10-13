package org.example.lamdaAndStream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMapExample {
    public static void main(String[] args) {
        List<String> items = List.of("apple", "banana", "cherry");
        listToMapconversion(items);

    }

    public static void listToMapconversion(List<String> items){
        Map<String, Integer> itemMap=items.stream()
                .collect(Collectors.toMap(item->item, item->item.length()));

        Map<String, Integer> itemMap2=items.stream()
                .collect(Collectors.toMap(item->item, String::length));

           System.out.println("List to map:"+itemMap2);
        itemMap.forEach((key,value)-> System.out.println(key+":"+value));
    }
}
