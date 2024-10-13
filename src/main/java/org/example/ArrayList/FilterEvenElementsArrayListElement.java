package org.example.ArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilterEvenElementsArrayListElement {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
       List<Integer> filterarr= filterEvenNumberArrayList(numbers);
       for(int element:filterarr){
           System.out.println(element);
       }
    }
    public static List<Integer> filterEvenNumberArrayList(ArrayList<Integer> numbers){
        List<Integer> filteredNumbers= numbers.stream()
                .filter(number->number%2==0)
                .collect(Collectors.toList());

        return filteredNumbers;

    }
}
