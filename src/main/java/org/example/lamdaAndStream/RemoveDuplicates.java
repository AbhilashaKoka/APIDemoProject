package org.example.lamdaAndStream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicates {
    public static void main(String[] args) {
        List<Integer> numberWithDuplicates = Arrays.asList(1, 2, 3, 4, 4, 5, 6, 7, 7, 8, 9, 10);
        System.out.println("Original list with duplicates:" + numberWithDuplicates);
removeDuplicateElement(numberWithDuplicates);
    }


    public static void removeDuplicateElement(List<Integer> numberWithDuplicates){
        List<Integer>  numbersWithoutDuplicates=numberWithDuplicates.stream().distinct().collect(Collectors.toList());
        System.out.println("List without duplicates:"+numbersWithoutDuplicates);

    }
}
