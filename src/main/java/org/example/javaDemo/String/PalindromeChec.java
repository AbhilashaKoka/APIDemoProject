package org.example.javaDemo.String;

public class PalindromeChec {
    public static void main(String[] args) {
        String str="Madam";
        palindromeCheck(str);
    }

    public static void palindromeCheck( String str ){
      String normalizestr=str.toLowerCase();
      boolean isPalindrome=new StringBuilder(normalizestr).reverse().toString().equals(normalizestr);
        System.out.println(isPalindrome);
    }
}