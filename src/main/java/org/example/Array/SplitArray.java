package org.example.Array;

public class SplitArray {
    public static void main(String args[]){
        int[] originalArray={1,2,3,4,5,6};
        int middleIndex=originalArray.length/2;

        int[] firstHalf=new int[middleIndex];
        int[] secondHalf=new int[originalArray.length-middleIndex];

        for(int i=0;i<middleIndex;i++){
            firstHalf[i]=originalArray[i];
        }

        for(int i=middleIndex;i<originalArray.length;i++){
            secondHalf[i-middleIndex]=originalArray[i];
        }

        System.out.println("Original Array:");
        for(int num:originalArray){
            System.out.print(num+"");
        }

        System.out.println("\nFirst half:");
        for(int num:firstHalf){
            System.out.println(num+"");
        }

        System.out.println("\nSeconf half");
        for(int num:secondHalf){
            System.out.println(num+"");
        }
    }
}
