package org.example.javaDemo.JavaArrayPrograms;

public class CopyAndArrayIntoAnotherArray {
    public static void main(String args[]){
        int[] arr1=new int[]{1,2,4,5};
        int[] arr2=new int[]{2,6,7,4};



        for(int i=0; i<arr1.length; i++){
            arr2[i]=arr1[i];
        }

        System.out.println("Elements of original array:");
        for(int i=0;i<arr1.length;i++){
          System.out.println(arr1[i]+" ");
      }
        System.out.println();

        System.out.println("Elements of new array:");
        for(int i=0;i<arr2.length;i++)
        {
            System.out.println(arr2[i]+" ");
        }
    }

}
