package javaProgram.demo.stringTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StringOperation2 {

    public static void main(String[] args){
        String str1="listen";
        String str2="silent";
        System.out.println("Are Anagram:"+checkAnagram(str1, str2));
        String str11 = "Brag";
        String str22 = "Grab";
        anagramString(str11,str22);
        String input="hello world";
        System.out.println(captializeFirstLetter(input));
        String string = "The best of both worlds";
        String input1="abc";
        printAllSubString(input1);
        String str = "Javatpoint is a great site for learning Java.";
        int noOfVowel = countVowels(str);
        System.out.println("String: " + str);
        System.out.println("Total number of vowels in the string are: "+ noOfVowel + "\n");
        FindFreqofEachCharacterInString("Java is Fun");
        FrequencyOfGivenCharacter("Java is Fun", 'a');
        LongestSubstringMethod("aaabbbbbccccc",0,0);
        String str4 = "FUN";
        subsetOfArrElements(str4);
        String str5="Madam";
        palindromeCheck(str5);
    }

    public static void palindromeCheck( String str ){
        String normalizestr=str.toLowerCase();
        boolean isPalindrome=new StringBuilder(normalizestr).reverse().toString().equals(normalizestr);
        System.out.println(isPalindrome);
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


    public static void FindFreqofEachCharacterInString(String str){
        int i, j;
        char[] string = str.toCharArray();
        int[] freq = new int[str.length()];
        for (i = 0; i < str.length(); i++) {
            freq[i] = 1;
            for (j = i + 1; j < str.length(); j++) {
                if (string[i] == string[j]) {
                    freq[i]++;
                    string[j] = '0';
                }
            }
        }

        System.out.println("Characters and their corresponding frequencies");
        for (i = 0; i < freq.length; i++) {
            if (string[i] != ' ' && string[i] != '0')
                System.out.println(string[i] + "-" + freq[i]);
        }
    }

    public static void FrequencyOfGivenCharacter(String str, char c){
        int count = 0;
        for (int i=0; i<=str.length()-1; i++) {
            if(str.charAt(i) == c) {
                count++;
            }
        }
        System.out.println("Frequency of t is: "+count);
    }

    private static boolean isVowel(char c){
        ArrayList<Character> al = new ArrayList<>();
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
        for(int i = 0; i < al.size(); i++){
            if(c == al.get(i)){
                return true;
            }
        }
        return false;
    }

    public static int countVowels(String s)
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




    public static void printAllSubString(String str){
        for(int i=0; i<str.length();i++){
            for(int j=i+1;j<=str.length();j++){
                System.out.println(str.substring(i,j));
            }
        }
    }
    public static void countTotalNumberOfCharacter(String string){
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

    public static String captializeFirstLetter(String str)
    {
        String[] words=str.split(" ");
        StringBuilder sb=new StringBuilder();


        for(String word:words){
            sb.append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1))
                    .append("");
        }

        return sb.toString().trim();
    }
    public static void anagramString(String str1, String str2){

        str1=str1.toLowerCase();
        str2=str2.toLowerCase();


        if(str1.length()!=str2.length()){
            System.out.println("The string is not anagram");
        }
        else {
            char[] string1=str1.toCharArray();
            char[] string2=str2.toCharArray();

            Arrays.sort(string1);
            Arrays.sort(string2);

            if(Arrays.equals(string1, string2)){
                System.out.println("Both the string are anagram");
            }
            else
            {
                System.out.println("Both the string are not anagram");
            }
        }
    }

    public static boolean checkAnagram(String str1, String str2){
        if(str1.length()!=str2.length()){
            return false;
        }

        char[] charArray1=str1.toCharArray();
        char[] charArray2=str2.toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        return Arrays.equals(charArray1, charArray2);
    }
}
