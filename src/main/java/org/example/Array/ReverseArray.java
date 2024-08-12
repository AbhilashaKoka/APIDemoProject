package org.example.Array;

public class ReverseArray {
    public static void main(String args[]){
        int[] numbers={1,2,3,4,5};

        System.out.println("Original Array");
        for(int number:numbers){
            System.out.println(number+" ");
        }


        for(int i=0;i< numbers.length/2;i++){
            int temp=numbers[i];
             numbers[i]=numbers[numbers.length-1-i];
             numbers[numbers.length-1-i]=temp;
        }


        System.out.println("\nReversed array:");
        for(int number:numbers){
            System.out.println(number+"");
        }
    }
}
