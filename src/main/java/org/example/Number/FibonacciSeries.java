package org.example.Number;

public class FibonacciSeries {
    public static void main(String[] args) {
        int terms=10;
        fibonacciSeriesMethod(terms);
    }

    public static void fibonacciSeriesMethod(int terms){
        int firstTerm=0;
        int secondTerm=1;
         for(int i=1;i<=terms;++i)
        {
            System.out.println(firstTerm+" ");
            int nextTerm=firstTerm+secondTerm;
            firstTerm=secondTerm;
            secondTerm=nextTerm;
        }
    }
}
