package org.example.lamdaAndStream;

import java.util.stream.IntStream;

public class PrimeNumberCHeck {

public static void main(String[] args)
{
    int number=29;
    boolean isPrime=isPrime(number);

    if(isPrime)
    {
        System.out.println(number+"is a prime number");
    }
    else{
        System.out.println(number+"is not a prime number");
    }
    }

public static boolean isPrime(int number)
{
    if(number<=1){
        return false;
    }
    return !IntStream.rangeClosed(2,(int)Math.sqrt(number)).anyMatch(i->number%i==0);
}}
