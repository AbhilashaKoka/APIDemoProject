package org.example.javaDemo.String;

public class CapitalizeFirstLetterOfEachWord {
    public static void main(String[] args) {
        String input="hello world";
        System.out.println(captializeFirstLetter(input));
    }

    public static String captializeFirstLetter(String str)
    {
        String[] words=str.split(" ");
        StringBuilder sb=new StringBuilder();


        for(String word:words){
            sb.append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1))
                    .append("");
            }

        return sb.toString().trim();
    }
}