package org.example.javaDemo.String;

public class GetCharacterFromString {
    public static void main(String[] args) {
        String str = "Welcome to JavaTpoint!";
        char[] chArr = new char[25];
        int srcBeginIndex = 11;
        int srcEndIndex = 11;
        int dstBeginIndex = 2;

        try
        {
            str.getChars(srcBeginIndex, srcEndIndex, chArr, dstBeginIndex);
            System.out.println(chArr);
        }
        catch(Exception excpn)
        {
            System.out.println(excpn);
        }
        System.out.println("The getChars() method prints nothing as start and end indices are equal.");
    }
}



