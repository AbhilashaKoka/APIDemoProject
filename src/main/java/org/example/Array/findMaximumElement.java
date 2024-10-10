package org.example.Array;

public class findMaximumElement {
    public static void main(String[] args){
        int[] numbers={3,7,2,15,10};
        int max=numbers[0];
        for(int i=1;i<numbers.length;i++){
            if(numbers[i]>max){
                max=numbers[i];
            }
        }
        System.out.println("Maximum Element:"+max);
    }
}
