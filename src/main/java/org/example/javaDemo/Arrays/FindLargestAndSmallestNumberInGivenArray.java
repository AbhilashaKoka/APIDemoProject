package org.example.javaDemo.Arrays;

public class FindLargestAndSmallestNumberInGivenArray {
    public static void main(String args[]){
        int a[]={1,2,5,6,3,2};

        System.out.println("Third Largest:"+getThirdLargest(a,6));
        System.out.println("Second Largest:"+getSecondLargest(a,6));
        System.out.println("First Largest:"+getFirstLargest(a,6));
        System.out.println("First smallest:"+getFirstsmallest(a,6));
        System.out.println("Second smallest:"+getSecondsmallest(a,6));
    }

    static int getThirdLargest(int[] a, int total){
      int temp;
        for(int i=0;i<total;i++){
            for(int j=i+1;j<total;j++){
                if(a[i]>a[j])
                {
                    temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }
            }
        }
        return a[total-3];
    }

    static int getSecondLargest(int[] a, int total){
        int temp;
        for(int i=0;i<total;i++){
            for(int j=i+1;j<total;j++){
                if(a[i]>a[j])
                {
                    temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }
            }
        }
        return a[total-2];
    }


    static int getFirstLargest(int[] a, int total){
        int temp;
        for(int i=0;i<total;i++){
            for(int j=i+1;j<total;j++){
                if(a[i]>a[j])
                {
                    temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }
            }
        }
        return a[total-1];
    }

    static int getFirstsmallest(int[] a, int total){
        int temp;
        for(int i=0;i<total;i++){
            for(int j=i+1;j<total;j++){
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


    static int getSecondsmallest(int[] a, int total){
        int temp;
        for(int i=0;i<total;i++){
            for(int j=i+1;j<total;j++){
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


}
