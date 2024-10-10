package org.example.javaDemo.String;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    public static void main(String[] args) {
        LongestSubstringMethod("aaabbbbbccccc",0,0);
    }

    public static void LongestSubstringMethod(String input, int maxLength, int start){
        Map<Character, Integer> map=new HashMap<>();
        for(int end=0;end<input.length();end++)
           {
            char current=input.charAt(end);
            if(map.containsKey(current))
            {
                start=Math.max(map.get(current)+1, start);
            }
            map.put(current, end);
            maxLength=Math.max(maxLength, end-start+1);
        }
        System.out.println("Longest substring length:"+maxLength);

    }
}
