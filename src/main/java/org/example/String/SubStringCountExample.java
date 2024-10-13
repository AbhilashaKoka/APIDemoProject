package org.example.String;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SubStringCountExample {
    public static void main(String[] args) {
        String input = "java is great. java is fun. java is POwerful";
        String substring = "Java";
        subStringCount(input,substring);
    }

    public static void subStringCount(String input, String substring){
        String[] parts=input.split(substring);
        int countUsingSplit=parts.length-1;
        System.out.println("No. of occurrence using split:"+countUsingSplit);
        int countUsingIndexOf=0;
        int index=0;
        while((index=input.indexOf(substring, index))!=-1){
            countUsingIndexOf++;
            index +=substring.length();
        }
        System.out.println("Number of occurrences using indexOf():"+countUsingIndexOf);
        Pattern pattern=Pattern.compile(substring);
        Matcher matcher=pattern.matcher(input);
        int countUsingRegex=0;
        while(matcher.find()){
            countUsingRegex++;
        }
        System.out.println("Number of occurrences using regex:"+countUsingRegex);
    }
}
