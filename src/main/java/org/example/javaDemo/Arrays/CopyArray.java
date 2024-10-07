package org.example.javaDemo.Arrays;

public class CopyArray {

    public static void main(String[] args) {

        int[] arr1 = new int[]{1, 2, 3, 4, 5};
        int[] arr2 = new int[arr1.length];

        System.arraycopy(arr1, 0, arr2, 0, arr1.length);

            System.out.println("Element of the original array:");
               for (int j = 0; j < arr1.length; j++) {
                System.out.println(arr1[j] + " ");
            }

            System.out.println();

            System.out.println("Elements of new Array:");
                for (int z = 0; z < arr2.length; z++) {
                System.out.println(arr2[z] + " ");
            }

    }
}
