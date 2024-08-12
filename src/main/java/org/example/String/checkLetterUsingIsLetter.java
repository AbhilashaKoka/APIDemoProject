package org.example.String;

public class checkLetterUsingIsLetter {
    public static void main(String[] args) {
        String str="HelloWorld";

        boolean result=containOnlyLetter(str);
        System.out.println(result);
    }
    public static boolean containOnlyLetter(String input){
        for(int i=0;i<input.length();i++){
            if(!Character.isLetter(input.charAt(i)))
            {
                return false;
            }
        }
        return true;
    }
}
