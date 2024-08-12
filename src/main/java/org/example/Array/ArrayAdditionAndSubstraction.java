package org.example.Array;

public class ArrayAdditionAndSubstraction {
    public static void main(String[] args){
        int[] array1={2,4,6,8};
        int[] array2={1,3,5,7};

        int[] additionalResult=new int[array1.length];
        int[] substractionResult=new int[array1.length];

        for(int i=0;i<array1.length;i++){
            additionalResult[i]=array1[i]+array2[i];
            substractionResult[i]=array1[i]-array2[i];
        }

        System.out.println("Addition Result:");
        for(int num: additionalResult){
            System.out.print(num+"");
        }

        System.out.println("\nSubstraction Result");
        for(int num:substractionResult)
        {
            System.out.print(num+"");
        }
    }
}
