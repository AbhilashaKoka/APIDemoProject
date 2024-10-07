package org.example.Number;
//sum of its own digits, each raised to the power of the number of digits.
public class CheckArmstrongNumber {
    public static void main(String[] args){
        int number=370;
        int originalNumber=number;
        int sum=0;

        //calculate the number of the digits
        int numberOfDigits=String.valueOf(number).length();
        while(number>0){
            int digit=number%10;
            sum+=Math.pow(digit,numberOfDigits);
            number/=10;
        }

        if(sum==originalNumber)
        {
            System.out.println(originalNumber+"is a armstrong number");
        }
        else {
            System.out.println(originalNumber+"is not a armstrong number");
        }
    }
}
