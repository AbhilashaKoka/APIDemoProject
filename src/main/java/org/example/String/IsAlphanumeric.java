package org.example.String;

public class IsAlphanumeric {
    public static void main(String[] args) {
        String str="HelloWorld12344";

        boolean result=containOnlyLetter(str);
        System.out.println(result);
    }
    public static boolean containOnlyLetter(String input) {
        if (!input.isEmpty() || input == null){
            for (int i = 0; i < input.length(); i++){
                 if(!Character.isLetterOrDigit(input.charAt(i))){
                    return false;
                }
            }
        }
        return true;
    }
}

