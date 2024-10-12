package org.example.Array;

public class OptimizedRemoveDuplicate {
    public static void main(String[] args) {
        int[] originalArray = {1, 2, 2, 3, 4, 4, 5};
         RemoveDuplicate(originalArray);

    }

    public static void RemoveDuplicate(int[] original){
        int unique=original.length;
        for(int i=0;i<unique;i++){
            for(int j=i+1;j<unique;j++){
                if(original[i]==original[j])
                {
                    original[j]=original[unique-1];
                    unique--;
                    j--;
                }
            }
        }
        System.out.println("Array after removing duplicates:");
        for(int i=0;i<unique;i++){
            System.out.println(original[i]+"");
        }
    }
}
