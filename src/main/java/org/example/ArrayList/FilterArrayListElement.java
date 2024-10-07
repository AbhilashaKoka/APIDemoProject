package org.example.ArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilterArrayListElement {
    public static void main(String[] args){
        ArrayList<Integer> numbers=new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);


        List<Integer> filteredNumbers= numbers.stream()// Converting the ArrayList in to the Stream
                .filter(number->number%2==0) //Filter the even number
                .collect(Collectors.toList());//Collected the filter element back into the list
        System.out.println();

    }
}
