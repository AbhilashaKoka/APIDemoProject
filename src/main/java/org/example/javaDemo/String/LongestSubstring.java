package org.example.javaDemo.String;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    public static void main(String[] args) {

        LongestSubstringMethod("aaabbbbbccccc",0,0);
        String str = "FUN";
        subsetOfArrElements(str);
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
    public static void subsetOfArrElements(String str){
        int len = str.length();
        int temp = 0;
        String[] arr = new String[len * (len + 1) + 2];
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                arr[temp]=str.substring(i,j+1);
                temp++;
            }
        }
        System.out.println("All subsets for given string are:");
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
