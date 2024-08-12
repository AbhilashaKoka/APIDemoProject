package org.example.String;

import org.apache.commons.lang3.StringUtils;

public class CheckDigitsUsingIsDigits {

    public static void main(String[] args) {
        String input="123456";
        boolean result=containsOnlyDigits(input);
        System.out.println(result);
    }

    public static boolean containsOnlyDigits(String str){
        for(int i=0; i<str.length();i++){
            if(!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public  static boolean containsOnlydigits(String str){
        return str.matches("\\d+");
    }


    public static boolean containOnlyDigits2(String str){
        return str.chars().allMatch(Character::isDigit);
    }



    public static boolean containsOnlyDigits3(String str){
        return StringUtils.isNumeric(str);
    }
}
