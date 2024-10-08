package org.example.javaDemo.Arrays;

public class FindLargestAndSmallestNumberInGivenArray {
    public static void main(String[] args){
        int[] a ={1,2,5,6,3,2};

        System.out.println("Third Largest:"+getThirdLargest(a));
        System.out.println("Second Largest:"+getSecondLargest(a));
        System.out.println("First Largest:"+getFirstLargest(a));
        System.out.println("First smallest:"+getFirstsmallest(a));
        System.out.println("Second smallest:"+getSecondsmallest(a));
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


}
