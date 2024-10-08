package org.example.javaDemo.Arrays;

import java.sql.SQLOutput;

public class RightRotateElement {
    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,4,5};
        int n=3;

        System.out.println("Original Array:");
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]+" ");
        }

        for(int i=0;i<n;i++){
            int j, last;
            last=arr[arr.length-1];

            for(j=arr.length-1;j>0;j--){
                arr[j]=arr[j-1];
            }
            arr[j]=last;
        }
        System.out.println();

        System.out.println("Array after right rotation:");
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]+" ");
        }
    }
}
