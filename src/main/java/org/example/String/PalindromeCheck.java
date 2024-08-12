package org.example.String;

import java.util.Scanner;

public class PalindromeCheck {
    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter any String :");
        String str=scanner.nextLine();
        Boolean palindrome = isPalindrome(str);
        System.out.println("String is Palindrome:"+palindrome);
    }

    public static boolean isPalindrome(String input)
    {
        boolean bol=false;
        String normalizedString=input.toLowerCase();
        String PalindromeString=new StringBuffer(normalizedString).reverse().toString();
        return normalizedString.equals(PalindromeString);
    }
}
