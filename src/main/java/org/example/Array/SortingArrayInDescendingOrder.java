package org.example.Array;
import java.util.Arrays;
import java.util.Collections;

public class SortingArrayInDescendingOrder {
    public static void main(String[] args) {
        Integer[] numbers = {5, 1, 4, 2, 3};
        sortingArrayInDescendingOrder(numbers);
    }

    public static void sortingArrayInDescendingOrder(Integer[] numbers){

        for( int number:numbers){
            System.out.println(number+"");
        }
        Arrays.sort(numbers, Collections.reverseOrder());
        for(int number:numbers){
            System.out.println(number+"");
        }
    }
}
