package org.example.javaDemo.Arrays;

public class CountArray {
    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,4,5};
        System.out.println("Number of element present in the given array:"+arr.length);

        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum=sum+arr[i];
        }
        System.out.println("Sum of all the element  an array:"+sum);
    }
}
