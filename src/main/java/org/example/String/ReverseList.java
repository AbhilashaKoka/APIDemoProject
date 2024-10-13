package org.example.String;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseList {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5};
        reverseList(arr);
    }

        public static void reverseList ( Integer[] arr){
            List<Integer> numbers = Arrays.asList(arr);
            System.out.println("Original Array:" + numbers);
            Collections.reverse(numbers);
            System.out.println("Reversed List:" + numbers);
        }
    }

