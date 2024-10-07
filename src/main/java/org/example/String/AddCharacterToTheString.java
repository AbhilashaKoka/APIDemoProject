package org.example.String;

public class AddCharacterToTheString {

    public static void main(String[] args) {

        String baseString="Hello";

        String updatedString=baseString+",World!";

        System.out.println(" Using +operator:"+updatedString);

        String concatString=baseString.concat(",World!");

        System.out.println("Using Concate method:"+concatString);

        System.out.println("Using StringBuilder:" + (baseString) + ",World!");
    }
}
