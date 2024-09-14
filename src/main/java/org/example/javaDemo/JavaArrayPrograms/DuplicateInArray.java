package org.example.javaDemo.JavaArrayPrograms;

public class DuplicateInArray {
    public static void main(String[] args) {
        int[]arr =new int[]{1,2,3,4,5,6,7};
        System.out.println("Duplicate element in array");
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++)
            {
                if(arr[i]==arr[j])
                    System.out.println(arr[j]);
            }
        }
    }
}
