package org.example.String;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseEachWord {
    public static void main(String[] args) {
        String str = "java is great and fun";
        String result = reverseWord(str);
        System.out.println("reverse String:"+result);

    }

    public static String reverseWord(String input) {

        return Arrays.stream(input.split("\s+"))
                .map(word->new StringBuilder(word).reverse().toString())
                .collect(Collectors.joining(" "));
    }


    public static String reverseWordIntradition(String input){
        String[] words=input.split("\\s+");

        StringBuilder result=new StringBuilder();

        for(String word:words){
            result.append(new StringBuilder(word).reverse().toString()).append(" ");
        }

        return result.toString().trim();
    }
}

