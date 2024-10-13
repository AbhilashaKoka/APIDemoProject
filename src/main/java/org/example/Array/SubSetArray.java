package org.example.Array;

public class SubSetArray {
    public static void main(String[] args) {
        String str = "FUN";
        subsetOfArr(str);
    }

    public static void subsetOfArr(String str){
        int len = str.length();
        int temp = 0;
        String[] arr = new String[len * (len + 1) + 2];
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
            arr[temp]=str.substring(i,j+1);
            temp++;
            }
        }
        System.out.println("All subsets for given string are:");
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
