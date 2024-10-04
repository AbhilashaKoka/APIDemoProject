package org.example.Number;

public class GCDOfTwoNumbers {

    public static void main(String args[]){
        int number1=48;
        int number2=18;
        System.out.println("The GCD of"+number1+"and"+number2+" is:"+gcd(number1, number2));

    }
    public static int gcd(int num1, int num2){
        while(num1!=num2){
            if(num1>num2)
                num1=num1-num2;
            else num2=num2-num1;
        }
        return num1;
    }
}
