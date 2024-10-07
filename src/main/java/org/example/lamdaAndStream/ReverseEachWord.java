package org.example.lamdaAndStream;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseEachWord {
    public static void main(String[] args){
        String input="Java 8 is great";

        String result= Arrays.stream(input.split(" "))
                .map(word->new StringBuilder(word).reverse().toString())
                .collect(Collectors.joining(""));

        System.out.println("Original string:"+input);
        System.out.println("Reversed string:"+result);
    }
}
