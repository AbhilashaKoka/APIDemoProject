package org.example.Array;
import java.util.Arrays;

public class SortArrayInAscendingOrder {
    public static void main(String[] args) {
        int[] numbers = {5, 1, 4, 2, 3};
        sortInAscendingOrder(numbers);
    }
    public static void sortInAscendingOrder(int[] numbers){
        System.out.println("Original array:");
        for(int number:numbers){
            System.out.println(number+"");
        }
        Arrays.sort(numbers);
        System.out.println("\n Sorted array in ascending order:");
        for(int number: numbers)
        {
            System.out.print(number+"");
        }
    }
}
