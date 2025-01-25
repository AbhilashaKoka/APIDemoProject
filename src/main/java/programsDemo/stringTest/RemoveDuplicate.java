package programsDemo.stringTest;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicate {


    public static void main(String[] args) {
        removeDuplicateMethod("hello");
    }
    public static void removeDuplicateMethod(String input)
    {
        char[] chars=input.toCharArray();
        Set<Character> charSet=new LinkedHashSet<>();

        for(char c:chars){
            charSet.add(c);
        }

        StringBuilder sb=new StringBuilder();

        for(char c:charSet){
            sb.append(c);
        }

        System.out.println("String after removing duplicated:"+sb.toString());
    }
}
