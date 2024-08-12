package org.example.Array;

public class OptimizedRemoveDuplicate {
    public static void main(String args[])
    {
        int[] originalArray={1,2,2,3,4,4,5};
        int uniqueElements=originalArray.length;


        for(int i=0;i<uniqueElements;i++){
            for(int j=i+1;j<uniqueElements;j++){
                if(originalArray[i]==originalArray[j])
                {
                    originalArray[j]=originalArray[uniqueElements-1];
                    uniqueElements--;
                    j--;
                }
            }
        }
        System.out.println("Array after removing duplicates:");
        for(int i=0;i<uniqueElements;i++){
            System.out.println(originalArray[i]+"");
        }
    }
}
