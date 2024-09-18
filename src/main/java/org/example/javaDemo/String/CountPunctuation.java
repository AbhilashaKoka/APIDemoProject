package org.example.javaDemo.String;

public class CountPunctuation {
    public static void main(String[] args) {
        int count=0;
        String str="He Said, 'The mail man loves you,'I heard it with my own ears";
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='!'||
            str.charAt(i)==','||str.charAt(i)==';')
            {
                count++;
            }
        }
        System.out.println("The number of punctuations exist in the string is:"+count);
    }
}
