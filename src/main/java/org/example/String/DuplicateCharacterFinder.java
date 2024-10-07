package org.example.String;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DuplicateCharacterFinder {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the String:");
        String str=scanner.nextLine();
        duplicateCharacterCount(str);

    }

    public static void duplicateCharacterCount(String input){
        String[] strings=input.split("");
        Map<String, Integer> strCount=new HashMap<>();
        for(String str:strings){
            strCount.put(str,strCount.getOrDefault(str,0)+1);
        }


        for(Map.Entry<String, Integer> entry:strCount.entrySet()){
            if(entry.getValue()>1)
             {
              System.out.println("Duplicate Character:"+entry.getKey()+":"+entry.getValue());
             }
        }


    }
}
