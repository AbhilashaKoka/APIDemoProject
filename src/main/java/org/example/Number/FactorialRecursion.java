package org.example.Number;

public  class FactorialRecursion{

    public static void main(String[] args){
        int number=4;
        long factorial= factorial(number);
        System.out.println("Factorial of number"+factorial);
    }

    public static long factorial(int n){
        if(n==0||n==1)
        {
            return 1;
        }
        else
           {
              return n*factorial(n-1);
            }
       }
}