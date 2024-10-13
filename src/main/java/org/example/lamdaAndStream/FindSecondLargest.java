package org.example.lamdaAndStream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindSecondLargest {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,6,7,8};
        secondLargestInarr(arr);
    }

    public static void secondLargestInarr(int[] arr){
        //Creating a list of Integer
        List<Integer> numbers= Arrays.asList(1,2,3,4,5,6,6,7,8);
        Optional<Integer> secondLargest=numbers.stream()
                .distinct()
                .sorted()
                .skip(numbers.size() - 2)
                .findFirst();

        secondLargest.ifPresent(s-> System.out.println("The second largest number is:"+s));
    }
}
