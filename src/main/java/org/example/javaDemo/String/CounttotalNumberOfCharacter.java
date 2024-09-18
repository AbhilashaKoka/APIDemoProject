package org.example.javaDemo.String;

public class CounttotalNumberOfCharacter {
    public static void main(String[] args) {
        String string="The best of both worlds";
        int count=0;
        char[] chars=string.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(chars[i]!=' ')
            {
                count++;
            }
        }
        System.out.println("Total Number of Characters in a string:"+count);
    }
}
