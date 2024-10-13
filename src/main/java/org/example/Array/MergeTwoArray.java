package org.example.Array;

public class MergeTwoArray {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3};
        int[] array2 = {4, 5, 6};
        mergeTwoArr(array1,array2);
    }
    public static void mergeTwoArr(int[] array1, int[] array2){
        int[] mergedArray=new int[array1.length+array2.length];
        System.arraycopy(array1, 0, mergedArray, 0, array1.length);
        System.arraycopy(array2, 0, mergedArray, array1.length + 0, array2.length);
        System.out.println("Merged Array:");
        for(int number:mergedArray){
              System.out.print(number+"");
        }
    }

}
