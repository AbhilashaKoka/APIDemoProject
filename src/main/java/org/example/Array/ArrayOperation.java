package org.example.Array;

import java.util.*;

public class ArrayOperation {

    public static void main(String[] args){
        int[] array1 = {2, 4, 6, 8};
        int[] array2 = {1, 3, 5, 7};
        arrAddition(array1,array2);
        arrSubstraction(array1,array2);

        int[] numbers = {5, 7, 8, 2, 4};
        avgOfArray(numbers);

        int[] numbers2={1,2,3,4,5};
        reversingElementInArr(numbers2);

        int[] array11 = {1, 2, 3};
        int[] array21 = {4, 5, 6};
        mergeTwoArr(array11,array21);

        int[] originalArray = {1, 2, 2, 3, 4, 4, 5};
        RemoveDuplicate(originalArray);

        int[] numbers45 = {5, 1, 4, 2, 3};
        sortInAscendingOrder(numbers45);

        Integer[] numbers25 = {5, 1, 4, 2, 3};
        sortingArrayInDescendingOrder(numbers25);

        int[] originalArray1 = {1, 2, 3, 4, 5, 6};
        splitArray(originalArray1);
        InitializationwithAnonymousArray();
        InLineINitializationOfArr();
        BlockInitializationOfArray();

        int[] arr = {1, 9, 0, 3};
        pullallZeroToLeft(arr);

        int[] sortedArray={1,3,4,6,8,9,11,13,15,17};
        int target=11;
        int resultIndex=binarySearch(sortedArray, target);
        if(resultIndex!=-1){
            System.out.println("Element found at index:"+resultIndex);
        }
        else{
            System.out.println("Element not found");
        }

        int[] array = {10, 20, 4, 45, 99, 100, 33, 99};
        SecondLargestUsingMapMethod(array);

        int[] arr1={1,2,3,4,5,6,6,7,8};
        secondLargestInarr(arr1);

        int[] numbers28 = {3, 7, 2, 15, 10};
        largestElement(numbers28);
    }

    public static void largestElement(int[] numbers){
        int max=numbers[0];
        for(int i=1;i<numbers.length;i++){
            if(numbers[i]>max)
            {
                max=numbers[i];
            }
        }
        System.out.println("Maximum Element:"+max);
    }

    public static void SecondLargestUsingMapMethod(int[] array){
        Map<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        for (int num : array)
        {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int count = 0;
        int secondLargest = Integer.MIN_VALUE;
        for (int key : map.keySet())
        {
            count++;
            if (count == 2)
            {
                secondLargest = key;
                break;
            }
        }
        System.out.println("Second largest element:"+secondLargest);
    }



    public static void secondLargestInarr(int[] arr){
        //Creating a list of Integer
        List<Integer> numbers= Arrays.asList(1,2,3,4,5,6,6,7,8);
        Optional<Integer> secondLargest=numbers.stream()
                .distinct()
                .sorted()
                .skip(numbers.size() - 2)
                .findFirst();

        secondLargest.ifPresent(s-> System.out.println("The second largest number is:"+s));
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

    public static void pullallZeroToLeft( int[] arr) {
        int len = arr.length;
        int count = 0;
        for (int i = 0; i < len; i++)

            if (arr[i] != 0)
                arr[count++] = arr[i];
        while (count < len)
            arr[count++] = 0;

        for (int j = 0; j < len; j++)
            System.out.print(arr[j] + " ");
    }


    public static void InLineINitializationOfArr() {
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("Inline initialized array:");
        for (int number : numbers) {
            System.out.println(number + "");
        }
    }
    public static void InitializationwithAnonymousArray() {

        String[] names = new String[]{"java", "Python", "C++", "Javascript"};
        System.out.println("\n\n Initialized with anonymous array:");
        for (String name : names){
            System.out.print(name + " ");
        }
    }
    public static void BlockInitializationOfArray(){
        double[] doubles;
        {
            doubles = new double[4];
            doubles[0] = 1.1;
            doubles[1] = 2.2;
            doubles[2] = 3.3;
            doubles[3] = 4.4;
        }

        System.out.println("\n\n Initialized in a block");
    }
    public static void splitArray(int[] originalArray){
        int middleIndex=originalArray.length/2;
        int[] firstHalf=new int[middleIndex];
        int[] secondHalf=new int[originalArray.length-middleIndex];
        System.arraycopy(originalArray, 0, firstHalf, 0, middleIndex);
        System.arraycopy(originalArray, middleIndex, secondHalf, middleIndex - middleIndex, originalArray.length - middleIndex);

        System.out.println("Original Array:");
        for(int num:originalArray){
            System.out.print(num+"");
        }

        System.out.println("\nFirst half:");
        for(int num:firstHalf){
            System.out.println(num+"");
        }

        System.out.println("\nSeconf half");
        for(int num:secondHalf){
            System.out.println(num+"");
        }
    }

    public static void sortingArrayInDescendingOrder(Integer[] numbers){

        for( int number:numbers){
            System.out.println(number+"");
        }
        Arrays.sort(numbers, Collections.reverseOrder());
        for(int number:numbers){
            System.out.println(number+"");
        }
    }
    public static void sortInAscendingOrder(int[] numbers){
        System.out.println("Original array:");
        for(int number:numbers){
            System.out.println(number+"");
        }
        Arrays.sort(numbers);
        System.out.println("\n Sorted array in ascending order:");
        for(int number: numbers)
        {
            System.out.print(number+"");
        }
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

    public static void mergeTwoArr(int[] array1, int[] array2){
        int[] mergedArray=new int[array1.length+array2.length];
        System.arraycopy(array1, 0, mergedArray, 0, array1.length);
        System.arraycopy(array2, 0, mergedArray, array1.length + 0, array2.length);
        System.out.println("Merged Array:");

        for(int number:mergedArray){
            System.out.print(number+"");
        }
    }

    public static void reversingElementInArr(int[] numbers){
        System.out.println("Original Array");

        for(int number:numbers){
            System.out.println(number+" ");
        }

        for(int i=0;i< numbers.length/2;i++){
            int temp=numbers[i];
            numbers[i]=numbers[numbers.length-1-i];
            numbers[numbers.length-1-i]=temp;
        }

        System.out.println("\nReversed array:");
        for(int number:numbers){
            System.out.println(number+"");
        }
    }


    public static void arrAddition(int[] array1, int[] array2) {
        int[] additionalResult = new int[array1.length];

        for (int i = 0; i < array1.length; i++) {
            additionalResult[i] = array1[i] + array2[i];
       }

        System.out.println("Addition Result:");
        for (int num : additionalResult) {
            System.out.print(num + "");
        }
    }

    public static void arrSubstraction(int[] array1, int[] array2){
        int[] substractionResult = new int[array1.length];

        for (int i = 0; i < array1.length; i++){
            substractionResult[i] = array1[i] - array2[i];
        }

        System.out.println("\nSubstraction Result");
        for(int num:substractionResult)
        {
            System.out.print(num+"");
        }
    }

    public static void avgOfArray(int[] numbers){
        int sum=0;
        for(int number:numbers){
            sum+=number;
        }
        double average=(double)sum/numbers.length;
        System.out.println("Average of array elements:"+average);

    }
}
