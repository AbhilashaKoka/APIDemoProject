package org.example.javaDemo.Arrays;

public class RemoveDuplicateElements{
    public static void main(String[] args) {
        int[] arr ={10,20,30,30, 30,40,40};
        int length=arr.length;

        length=removeDuplicate(arr, length);

        for(int i=0;i<length;i++){
            System.out.println(arr[i]+" ");
        }

    }
    static int removeDuplicate(int[] arr, int n){
        if(n==0||n==1){
            return n ;
        }

        int[] temp=new int[n];
        int j=0;

        for(int i=0;i<n-1;i++){
            if(arr[i]!=arr[i+1]){
                temp[j++]=arr[i];
            }
        }

        temp[j++]=arr[n-1];

        if (j >= 0) System.arraycopy(temp, 0, arr, 0, j);
        return j;
    }
}
