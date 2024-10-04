package org.example.Number;

public class PrimeNumberWithTheRange {
    public static void main(String args[]){
        int start=10;
        int end=50;

        System.out.println("Prime number between"+start+"and"+end+":");
        for(int i=start;i<=end;i++){
            if(isPrime(i)){
                System.out.println(i+"");
            }
        }
    }

    public static boolean isPrime(int number){
        if(number<=1){
            return false;

        }
        for(int i=2;i<=Math.sqrt(number);i++)

        {
            if(number%i==0)
            {
                return false;
            }
        }
        return true;
    }
}
