package org.example.String;
import java.util.Scanner;

public class GenerateAllPermutationOfString {
    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter any string:");
        String input=scanner.nextLine();


        if(input.length()==0)
        {
            System.out.println("   ");
        }

        for(int i=0;i<input.length();i++){
            char ch=input.charAt(i);
            String remaining=input.substring(0,i)+input.substring(i+1);
            System.out.println(remaining);
        }
}
}
