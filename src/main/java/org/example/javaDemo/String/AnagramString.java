package org.example.javaDemo.String;
import java.util.Arrays;

public class AnagramString{
    public static void main(String[] args) {
        String str1="Brag";
        String str2="Grab";

        str1=str1.toLowerCase();
        str2=str2.toLowerCase();


        if(str1.length()!=str2.length()){
            System.out.println("The string is not anagram");
        }
        else {
            char[] string1=str1.toCharArray();
            char[] string2=str2.toCharArray();

            Arrays.sort(string1);
            Arrays.sort(string2);

            if(Arrays.equals(string1, string2)==true){
                System.out.println("Both the string are anagram");
            }
            else
            {
                System.out.println("Both the string are not anagram");
            }
        }
    }
}
