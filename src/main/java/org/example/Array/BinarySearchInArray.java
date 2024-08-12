package org.example.Array;

public class BinarySearchInArray {
    public  static void main(String args[]){
        int[] sortedArray={1,3,4,6,8,9,11,13,15,17};
        int target=11;
        int resultIndex=binarySearch(sortedArray, target);

        if(resultIndex!=-1){
            System.out.println("Element found at index:"+resultIndex);
             }
        else{
            System.out.println("Element not found");
        }
    }

    public static int binarySearch(int[] array, int target){
        int left= 0;
        int right= array.length-1;

        while(left<= right)
        {
            int mid=left+(right-left)/2;

            if(array[mid]==target)
            {
              return mid;
            }
            if(array[mid]<target)
            {
               left=mid+1;
            }
            else
            {
              right=mid-1;
            }
        }
        return -1;
    }
}
