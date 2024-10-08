package org.example.javaDemo.String;// import statement
import java.util.*;

public class FindVowelInGivenString{

    ArrayList<Character>   al;

      FindVowelInGivenString(){
        al = new ArrayList<>();
        al.add('A');
        al.add('E');
        al.add('a');
        al.add('e');
        al.add('I');
        al.add('O');
        al.add('i');
        al.add('o');
        al.add('U');
        al.add('u');
    }


    private boolean isVowel(char c){
        for(int i = 0; i < al.size(); i++){
            if(c == al.get(i)){
                return true;
            }
        }
        return false;
    }

    public int countVowels(String s)
    {
        int countVowel = 0;
        int size = s.length();
        for(int j = 0; j < size; j++)
        {
            char c = s.charAt(j);
            if(isVowel(c)){
                countVowel = countVowel + 1;
            }
        }
        return countVowel;
    }

    public static void main(String argvs[])
    {
        FindVowelInGivenString obj = new FindVowelInGivenString();
        String str = "Javatpoint is a great site for learning Java.";
        int noOfVowel = obj.countVowels(str);
        System.out.println("String: " + str);
        System.out.println("Total number of vowels in the string are: "+ noOfVowel + "\n");

    }
}    