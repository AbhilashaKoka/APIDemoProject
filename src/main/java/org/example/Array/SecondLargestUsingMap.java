package org.example.Array;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

class SecondLargestUsingMap {
    public static void main(String[] args) {
        int[] array = {10, 20, 4, 45, 99, 100, 33, 99};
        SecondLargestUsingMapMethod(array);
    }

    public static void SecondLargestUsingMapMethod(int[] array){
        Map<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        for (int num : array)
        {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int count = 0;
        int secondLargest = Integer.MIN_VALUE;
        for (int key : map.keySet())
        {
            count++;
            if (count == 2)
            {
                secondLargest = key;
                break;
            }
        }
      System.out.println("Second largest element:"+secondLargest);
    }
}
