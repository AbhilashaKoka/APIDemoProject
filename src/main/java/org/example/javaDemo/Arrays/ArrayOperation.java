package org.example.javaDemo.Arrays;

public class ArrayOperation {

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 4, 5};
        CopyArrayToAnotherArray(arr1);
           int[] arr = new int[]{1, 2, 3, 4, 5};
           CountElementInArray(arr);
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

