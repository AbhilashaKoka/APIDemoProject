package org.example.lamdaAndStream;

import java.util.Arrays;
import java.util.List;

public class PrintEvenNumbers{
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 5, 7, 9, 10);
     printEvenNumber(numbers);
    }

    public static void printEvenNumber(List<Integer> numbers){
        System.out.println("Even numbers:");
        numbers.stream().filter(n->n%2==0).forEach(System.out::println);
    }
}
