package org.example.Number;

public class LargestOfThreeNumber {
    public static void main(String[] args){
        int num1=10, num2=20, num3=30;
        int largest;

        if(num1>=num2&&num1>=num3){
            largest=num1;
        }

        else if(num2>=num1&&num2>=num3){
            largest=num2;

        }else{
            largest=num3;
        }

        System.out.println("The largest number is:"+largest);
    }
}
