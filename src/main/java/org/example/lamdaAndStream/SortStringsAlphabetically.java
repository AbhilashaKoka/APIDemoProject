package org.example.lamdaAndStream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortStringsAlphabetically {
    public static void main(String args[]){
        List<String> strings= Arrays.asList("Banana","Apple","Orange","Mango","Grape");

        List<String> sortStrings=strings.stream().sorted().collect(Collectors.toList());

        System.out.println("sorted list of string:");
        sortStrings.forEach(System.out::println);
    }
}
