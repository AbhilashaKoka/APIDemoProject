package org.example.String;

public class ReverseString {
    public static void main(String[] args){
        String originalString ="Hello";
        String reverseString=new StringBuilder(originalString).reverse().toString();
        System.out.println("Original String:"+originalString);
        System.out.println("Reversed string:"+reverseString);
        String rev=reverseString(originalString);
        System.out.println(rev);

        char[] charArr=originalString.toCharArray();
        for(int i=charArr.length-1;i>0;i--)
        {
            System.out.println(charArr[i]);
        }
    }


    public static String reverseString(String input){
        if(input.isEmpty())
            return input;
        return reverseString(input.substring(1))+input.charAt(0);
    }
}
