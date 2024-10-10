package org.example.Number;

public class SumOfNaturalNumber{

    public static void main(String[] args){
        int n=100;
        int sumWithLoop=0;
        for(int i=1;i<=n;i++)
        {
            sumWithLoop+=i;
        }
        int sumWithFormula=n*(n+1)/2;
        System.out.println("Sum using loop:"+sumWithLoop);
        System.out.println("Sum using formula:"+sumWithFormula);
    }
}
