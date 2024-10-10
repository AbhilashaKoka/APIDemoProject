package org.example.javaDemo.String;

public class FIndSubsubstrings {
    public static void main(String[] args) {
        String input="abc";
        printAllSubString(input);
    }



    public static void printAllSubString(String str){
        for(int i=0; i<str.length();i++){
            for(int j=i+1;j<=str.length();j++){
                System.out.println(str.substring(i,j));
            }
        }
    }
}
