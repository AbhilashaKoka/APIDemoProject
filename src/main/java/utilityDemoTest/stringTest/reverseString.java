package utilityDemoTest.stringTest;

import java.util.HashMap;

public class reverseString {
    public static void main(String[] args) {
        String str="AbhilashaKoka";
        HashMap<Integer, Character> map=new HashMap<>();
        for(int i=0;i<str.length();i++){
            map.put(i,str.charAt(i));
        }
StringBuilder reverse=new StringBuilder();
        for(int i=str.length()-1;i>=0;i--){
            reverse.append(map.get(i));
        }
        System.out.println(reverse);
    }
}
