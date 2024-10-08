package org.example.javaDemo.String;

public class PrintFirstAndLastCharacterInString {
    public static void main(String[] args) {
        FirstAndLastCharacter("Abhilasha");
    }



    public static void FirstAndLastCharacter( String str){
    int strLength = str.length();
        System.out.println("Character at 0 index is: "+ str.charAt(0));
        System.out.println("Character at last index is: "+ str.charAt(strLength-1));
}
}
