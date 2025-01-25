package programsDemo.programInJavaTest;

import java.util.*;
import java.util.stream.Collectors;

public class Array2Operation {

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

        String[] array41 = {"java", "Python", "C++"};
        arrayToArrayList(array41);

        ArrayList<String> list1=new ArrayList<>();
        list1.add("Java");
        list1.add("Python");
        list1.add("C++");

        ArrayList<String> list2=new ArrayList<>();
        list2.add("Java");
        list2.add("Python");
        list2.add("C++");
        compareTwoArrayList(list1,list2);


        ArrayList<Integer> numbers1 = new ArrayList<>();
        numbers1.add(1);
        numbers1.add(2);
        numbers1.add(3);
        numbers1.add(4);
        numbers1.add(5);
        numbers1.add(6);
        List<Integer> filterarr= filterEvenNumberArrayList(numbers1);
        for(int element:filterarr){
            System.out.println(element);
        }

        int[] arr155 = new int[]{1, 2, 3, 4, 5};
        CopyArrayToAnotherArray(arr155);
        int[] arr156 = new int[]{1, 2, 3, 4, 5};
        CountElementInArray(arr156);
        int[] arr11 = new int[]{5, 2, 8, 7, 1};
        arrangeElementInDescendingOrder(arr11);
        int[] arr2 = new int[]{1, 2, 3, 4, 2, 7, 8, 8, 3};
        duplicateElementOfArray(arr2);
        int[] arr3 = new int[]{1, 2, 3, 4, 5};
        EvenPosition(arr3);
        int[] a ={1,2,5,6,3,2};
        System.out.println("Third Largest:"+getThirdLargest(a));
        System.out.println("Second Largest:"+getSecondLargest(a));
        System.out.println("First Largest:"+getFirstLargest(a));
        System.out.println("First smallest:"+getFirstsmallest(a));
        System.out.println("Second smallest:"+getSecondsmallest(a));
        int[] arr4= new int[]{25, 11, 7, 75, 56};
        LargestElementOfAnArray(arr4);
        int[] arr5 = new int[]{1, 2, 3, 4, 5};
        int n = 3;
        leftRotationOfAnArray(arr5,n);
        int[] arr6 = new int[]{1, 2, 3, 4, 5};
        OddPositionOfAnArray(arr6);
        int[] arr7 = {10, 20, 30, 30, 30, 40, 40};
        removeduplicateElementOfAnArray(arr7);
        int[] arr8 = new int[]{1, 2, 3, 4, 5};
        reverseElementOfAnArray(arr8);
        int[] arr9 = new int[]{1, 2, 3, 4, 5};
        int n2 = 3;
        rightRotationElement(arr9,n2);
        int[] arr10 = new int[]{25, 11, 7, 75, 56};
        smallestElementArray(arr10);
        int[] arr21 = new int[]{5, 2, 8, 7, 1};
        sortArrWithoutUsingSorting(arr21);
        int[] ab = {1, 2, 5, 6, 3, 2};
        sortOddAndEvenInArr(ab);
    }



    public static int binarySearch(int[] array, int target){
        int left= 0;
        int right= array.length-1;

        while(left<=right)
        {
            int mid=left+(right-left)/2;
            if(array[mid]==target){
                return mid;
            }
            if(array[mid]<target){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return -1;
    }

    public static void pullallZeroToLeft( int[] arr) {
        int len = arr.length;
        int count = 0;
        for (int i = 0; i < len; i++)
            if (arr[i]!= 0)
                arr[count++] = arr[i];
            while (count < len)
            arr[count++] = 0;

        for (int j = 0; j < len; j++)
            System.out.print(arr[j] + " ");
    }


    public static void InLineINitializationOfArr() {
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("Inline initialized array:");

        for (int number : numbers){
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
    public static void splitArray(int[] arr){
        int midIndex=arr.length/2;
        int[] firstHalf=new int[midIndex];
        int[] secondHalf=new int[arr.length-midIndex];

        System.arraycopy(arr, 0, firstHalf, 0, midIndex);
        System.arraycopy(arr, midIndex, secondHalf, midIndex - midIndex, arr.length - midIndex);

        System.out.println("Original Array:");
        for(int num:arr){
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




    public static void RemoveDuplicate(int[] str){
        int newstr=str.length;

        for(int i=0;i<newstr;i++){
             for(int j=i+1;j<newstr;j++){
                if(str[i]==str[j])
                {
                    str[j]=str[newstr-1];
                    newstr--;
                    j--;
                }
            }
        }
        System.out.println("Array after removing duplicates:");
        for(int i=0;i<newstr;i++){
            System.out.println(str[i]+"");
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
            System.out.println(number+" "); }

        for(int i=0;i<numbers.length/2;i++){
            int temp=numbers[i];
            numbers[i]=numbers[numbers.length-1-i];
            numbers[numbers.length-1-i]=temp;
        }
        System.out.println("\nReversed array:");
        for(int number:numbers){
            System.out.println(number+"");
        }
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
        for(int number: numbers){
            System.out.print(number+"");
        }
    }

    public static void arrAddition(int[] array1, int[] array2){
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

    public static List<Integer> filterEvenNumberArrayList(ArrayList<Integer> num){
        List<Integer> ls= num.stream()
                .filter(number->number%2==0)
                .collect(Collectors.toList());
        return ls;

    }
    public static void compareTwoArrayList(ArrayList<String> ls1, ArrayList<String> ls2){
        boolean isEqual=ls1.equals(ls2);
        System.out.println("list1 equals list2:"+isEqual);
        boolean isContained=ls1.containsAll(ls2);
        System.out.println("list1 contained all elements list2:"+isContained);
    }

    public static void arrayToArrayList(String[] arr){
        List<String> ls=new ArrayList<>(Arrays.asList(arr));
        System.out.println("Array to ArrayList:"+ls);
        ArrayList<String> listOfLanguages=new ArrayList<>();
        listOfLanguages.add("Javascript");
        listOfLanguages.add("TypeScript");
        listOfLanguages.add("kotlin");
        String[] languageArray=listOfLanguages.toArray(new String[0]);
        System.out.println("ArrayList to an array:"+Arrays.toString(languageArray));

    }

    public static <T> List<T> RemoverDuplicateMethod(List<T> list) {
        List<T> newList = new ArrayList<>();
        for (T element : list) {
            if (!newList.contains(element)) {
                newList.add(element);
            }
        }
        return newList;
    }

    public static void sortOddAndEvenInArr(int[] a){
        System.out.println("Odd Numbers:");
        for(int i=0;i<a.length;i++){
            if(a[i]%2!=0){
                System.out.println(a[i]);
            }
        }
        System.out.println("Even Number:");
        for(int i=0;i<a.length;i++){
            if(a[i]%2==0){
                System.out.println(a[i]);
            }
        }
    }

    public static void sortArrWithoutUsingSorting(int[] arr){
        int temp=0;
        System.out.println("Element of the original array:");

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]+" ");
        }

        for(int i=0;i<arr.length;i++){
            for(int j=i+1; j<arr.length;j++){
                if(arr[i]>arr[j]){
                    temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        System.out.println();
        System.out.println("Element of array sorted in ascending order:");
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]+" ");
        }
    }

    public static void smallestElementArray(int[] arr){
        int min=arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min)
                min=arr[i];
        }
        System.out.println("Smallest element present in given array:"+min);
    }

    public static void rightRotationElement(int[] arr, int n){

        System.out.println("Original Array:");
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]+" ");
        }

        for(int i=0;i<n;i++){
            int j, last;
            last=arr[arr.length-1];

            for(j=arr.length-1;j>0;j--){
                arr[j]=arr[j-1];
            }
            arr[j]=last;
        }
        System.out.println();

        System.out.println("Array after right rotation:");
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]+" ");
        }
    }

    public static void reverseElementOfAnArray(int[] arr){
        System.out.println("Original Array");

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]+" ");
        }
        System.out.println();
        System.out.println("Array in reverse order:");

        for(int i= arr.length-1;i>=0;i--){
            System.out.println(arr[i]+"");
        }
    }

    public static void removeduplicateElementOfAnArray(int[] arr){
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

    public static void OddPositionOfAnArray(int[] arr){
        System.out.println("Element of given array present on odd position");
        for(int i=0;i<arr.length;i=i+2){
            System.out.println(arr[i]);
        }
    }

    public static void leftRotationOfAnArray(int[] arr, int n){
        System.out.println("Original Array:");
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]+" ");
        }
        for(int i=0;i<n;i++){
            int j,first;
            first=arr[0];
            for(j=0;j<arr.length-1;j++){
                arr[j]=arr[j+1];
            }
            arr[j]=first;
        }
        System.out.println();
        System.out.println("Array after left rotation");
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]+"");
        }
    }
    public static void LargestElementOfAnArray(int[] arr){
        int max=arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max)
                max=arr[i];
        }
        System.out.println("Largest element  present in the array:"+max);
    }
    static int getThirdLargest(int[] a){
        int temp;
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                if(a[i]>a[j])
                {
                    temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }
            }
        }
        return a[a.length-3];
    }

    static int getSecondLargest(int[] a){
        int temp;
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                if(a[i]>a[j])
                {
                    temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }
            }
        }
        return a[a.length-2];
    }


    static int getFirstLargest(int[] a){
        int temp;
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                if(a[i]>a[j])
                {
                    temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }
            }
        }
        return a[a.length-1];
    }

    static int getFirstsmallest(int[] a){
        int temp;
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                if(a[i]>a[j])
                {
                    temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }
            }
        }
        return a[0];
    }


    static int getSecondsmallest(int[] a){
        int temp;
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                if(a[i]>a[j])
                {
                    temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }
            }
        }
        return a[1];
    }


    public static void EvenPosition(int[] arr){
        System.out.println("Element of the given array present on the even position:");
        for(int i=1;i<arr.length;i=i+2){
            System.out.println(arr[i]);
        }
    }

    public static void duplicateElementOfArray(int[] arr){
        System.out.println("Duplicate elements in given array:");
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]==arr[j])
                    System.out.println(arr[j]);
            }
        }
    }

    public static void arrangeElementInDescendingOrder(int[] arr){
        int temp;
        System.out.println("Element of the original array:");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]<arr[j])
                {
                    temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        System.out.println();
        System.out.println("Elements of array sorted in descending order:");
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]+"");
        }
    }

    public static void CountElementInArray(int[] arr){
        System.out.println("Number of element present in the given array:"+arr.length);
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum=sum+arr[i];
        }
        System.out.println("Sum of all the element  an array:"+sum);
    }


    public static void CopyArrayToAnotherArray (int[] arr1) {
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
