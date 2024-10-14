package org.example.String;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringOperation{

    //OP:IsAtUkAmIr
    public static void main(String[] args) {

        String str = "sitakumari";
        Reversingsecondcharacterwithchangecase(str);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string:");
        String input = scanner.nextLine();
        Map<Character, Integer> charCount = countCharacters(input);
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
            String input1 = "hello world";
            characterCountInString(input1);
            String input2 = "programming";
            countCharacterInString(input2);
        }
        String input1="123456";
        boolean result=containsOnlyDigits(input1);
        System.out.println(result);
        String str1="HelloWorld";

        boolean result1=containOnlyLetter(str1);
        System.out.println(result1);
        Scanner scanner2=new Scanner(System.in);
        System.out.println("Enter the String:");
        String str3=scanner2.nextLine();
        duplicateCharacterCount(str3);
        String sentence = "Java id a programming language and java is also a platform";
        System.out.println("Duplicate words in the string is:");
        findDuplicateCharacter2(sentence);
        String input2 = "javastream";
        findRepeatedCharacter(input2);

        String Input = "Java is great and java is fun, Programming in java is great";
        duplicateWordCount(Input);
        String text = "this is a test this is only a test";
        findOccurrenceOfWordInStr(text);
        String str4 = "This is an example string, an example of a string.";
        String word = "example";
        findOccurOfWordInStr(str4,word);

        String str5 = "aaaabbbbcccc";
        DivideStringInSubSet(str5,3);
        Scanner scanner6 = new Scanner(System.in);
        System.out.println("Enter any string:");
        String input3 = scanner6.nextLine();
        generateallPermutationOfString(input3);

        String str66="HelloWorld12344";

        boolean result6=containOnlyLetter1(str66);
        System.out.println(result6);
        String str8 = "sample string";
        maxOccurOfChar(str8);

        String[] str11 = {"java", "is", "fun"};
        String[] str21 = {"and", "powerful"};
        mergeTwoStrs(str11, str21);
        String text1 = "Java Guides";
        char result11 = findNonRepeatedCharater(text1);
        if (result11 != '\0'){
            System.out.println("The Non repeated character is:" + result11);
        } else {
            System.out.println("All character  are repeated");
        }

        Scanner scanner4=new Scanner(System.in);
        System.out.println("Enter any String :");
        String str7=scanner4.nextLine();
        Boolean palindrome = isPalindrome(str7);
        System.out.println("String is Palindrome:"+palindrome);
        String input9="Java is great and java is fun and java is powerful";

        String result9 =removeTheDuplicateWords(input9);
        System.out.println(result9);


        String str99 = "java is great and fun";
        String result99 = reverseWordIntradition(str99);
        System.out.println("reverse String:"+result99);

        Integer[] arr = {1, 2, 3, 4, 5};
        reverseList(arr);
        String input34 = "java is great. java is fun. java is POwerful";
        String substring = "Java";
        subStringCount(input34,substring);
        String str14 = "Hello";
        String str24 = "World";
        swapToString(str14,str24);
        Scanner scanner5 = new Scanner(System.in);
        System.out.println("Enter your string:");
        String input5 = scanner5.nextLine();
        int[] counts = countVowelsAndConsonants(input5);
        System.out.println("Number of vowels: " + counts[0]);
        System.out.println("Number of consonants: " + counts[1]);

        String str555 = "Abhilasha Koka Koka";
        nonRepeatedCharacter(str555);
    }

    public static void nonRepeatedCharacter(String str) {
        String[] arr = str.split("\\s+");
        Map<String, Integer> map = new Hashtable<>();
        for (String str2 : arr) {
            map.put(str2, map.getOrDefault(str2, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        int vowelCount = 0;
        int consonentsCount = 0;
        for (char ch : str.toLowerCase().toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                if ("aeiou".indexOf(ch) != -1) {
                    vowelCount++;
                }
                consonentsCount++;
            }
        }
        System.out.println("Vowel count:" + vowelCount + ":" + "Consonent Count:" + consonentsCount);
    }


    public static int[] countVowelsAndConsonants(String input) {
        int vowelsCount = 0, consonantsCount = 0;
        for (char c : input.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                // Ensure character is a letter
                if ("aeiou".indexOf(c) != -1) {
                    vowelsCount++;
                } else {
                    consonantsCount++;
                }
            }
        }

        return new int[]{vowelsCount, consonantsCount};
    }

    public static void swapToString(String str1, String str2){
        String temp=str1;
        str1=str2;
        str2=temp;
        System.out.println(str1);
        System.out.println(str2);
        str1=str1+str2;
        str2=str1.substring(0,str1.length()-str2.length());
        str1=str1.substring(str2.length());
        System.out.println(str1);
        System.out.println(str2);
    }

    public static void subStringCount(String input, String substring){
        String[] parts=input.split(substring);
        int countUsingSplit=parts.length-1;
        System.out.println("No. of occurrence using split:"+countUsingSplit);
        int countUsingIndexOf=0;
        int index=0;
        while((index=input.indexOf(substring, index))!=-1){
            countUsingIndexOf++;
            index +=substring.length();
        }
        System.out.println("Number of occurrences using indexOf():"+countUsingIndexOf);
        Pattern pattern=Pattern.compile(substring);
        Matcher matcher=pattern.matcher(input);
        int countUsingRegex=0;
        while(matcher.find()){
            countUsingRegex++;
        }
        System.out.println("Number of occurrences using regex:"+countUsingRegex);
    }

    public static void reverseList ( Integer[] arr){
        List<Integer> numbers = Arrays.asList(arr);
        System.out.println("Original Array:" + numbers);
        Collections.reverse(numbers);
        System.out.println("Reversed List:" + numbers);
        String originalString ="Hello";
        String reverseString=new StringBuilder(originalString).reverse().toString();
        System.out.println("Original String:"+originalString);
        System.out.println("Reversed string:"+reverseString);
        String rev=reverseString(originalString);
        System.out.println(rev);

        char[] charArr=originalString.toCharArray();
        for(int i=charArr.length-1;i>0;i--)
        {
            System.out.println(charArr[i]);
        }
    }


    public static String reverseString(String input){
        if(input.isEmpty())
            return input;
        return reverseString(input.substring(1))+input.charAt(0);
    }

//    public static String reverseWord(String input) {
//
//        return Arrays.stream(input.split("\s+"))
//                .map(word->new StringBuilder(word).reverse().toString())
//                .collect(Collectors.joining(" "));
//    }
//

    public static String reverseWordIntradition(String input){
        String[] words=input.split("\\s+");

        StringBuilder result=new StringBuilder();

        for(String word:words){
            result.append(new StringBuilder(word).reverse()).append(" ");
        }

        return result.toString().trim();
    }

    public static String removeTheDuplicateWords(String input ){
        String normalizedStr=input.toLowerCase();
        String[] words=normalizedStr.split("\\s+");
        Set<String> wordset = new HashSet<>();
        StringBuilder result=new StringBuilder();

        for(String word:words){
            if(!wordset.contains(word)){
                wordset.add(word);
                result.append(word).append(" ");
            }
        }
        return result.toString().trim();
    }


    public static String removeduplicateWords(String input){
        Set<String> wordSet=Arrays.stream(input.split("\\s+"))
                .collect(Collectors.toCollection(LinkedHashSet::new));
        return String.join(" ",wordSet);

    }


    public static boolean isPalindrome(String input)
    {
        boolean bol=false;
        String normalizedString=input.toLowerCase();
        String PalindromeString=new StringBuffer(normalizedString).reverse().toString();
        return normalizedString.equals(PalindromeString);
    }
    public static char findNonRepeatedCharater(String input) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c:input.toCharArray()){
            charCount.put(c,charCount.getOrDefault(c,0)+1);
        }
        for(char ch:input.toCharArray()){
            if(charCount.get(ch)==1){
                return ch;
            }
        }
        return '\0';
    }

    public static void mergeTwoStrs(String[] str1, String[] str2){
        String[] mergedarr=new String[str1.length+str2.length];
        int index=0;
        for(String s1:str1){
            mergedarr[index++]=s1;
        }
        for(String s2:str2)
        {
            mergedarr[index++]=s2;
        }

        System.out.println("Merged array using loop:");
        for(String element:mergedarr){
            System.out.println(element);
        }
    }
    public static void maxOccurOfChar(String str){
        Map<Character,Integer> charfrequencyMap=new HashMap();
        char maxOcurringChar=' ';
        int maxFequency=0;
        for(char c:str.toCharArray()){
            charfrequencyMap.put(c,charfrequencyMap.getOrDefault(c,0)+1);
        }
        for(Map.Entry<Character,Integer> entry:charfrequencyMap.entrySet()){
            if(entry.getValue()> maxFequency)
            {
                maxFequency=entry.getValue();
                maxOcurringChar= entry.getKey();
            }
        }
        System.out.println("Maximum Occuring character:'"+maxOcurringChar+"'with a frequency of"+maxFequency);

    }
    public static boolean containOnlyLetter1(String input) {
        if (!input.isEmpty() || input == null){
            for (int i = 0; i < input.length(); i++){
                if(!Character.isLetterOrDigit(input.charAt(i))){
                    return false;
                }
            }
        }
        return true;
    }
    public static void generateallPermutationOfString(String input){
        if(input.length()==0)
        {
            System.out.println("   ");
        }
        for(int i=0;i<input.length();i++)
        {
            char ch=input.charAt(i);
            String remaining=input.substring(0,i)+input.substring(i+1);
            System.out.println(remaining);
        }
    }

    public static void DivideStringInSubSet (String str, int n) {
        int len = str.length();
        int temp = 0, chars = len / n;
        String[] equalStr = new String[n];
        if (len % n != 0)
        {
            System.out.println("Sorry the string can`t be divided into " + n
                    + " equals parts");
        }
        else { //how much to iterate
            for (int i = 0; i < len; i = i + chars)
            {
                String part = str.substring(i, i + chars);
                equalStr[temp] = part;
                temp++;
            }
            System.out.println(n + "equals parts of given string are:");
            for (int i = 0; i < equalStr.length; i++)
            {
                System.out.println(equalStr[i]);
            }
        }
    }
    public static void findOccurrenceOfWordInStr(String text) {
        String[] words = text.split(" ");
        Map<String, Integer> wordCount = new Hashtable<>();
        for (String word : words) {
            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }

        System.out.println("word Occurrence");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }


    public static void findOccurOfWordInStr(String str, String word){
        int count = 0;
        // Convert string to lower case to make the search case-insensitive
        String lowerCaseStr = str.toLowerCase();
        String lowerCaseWord = word.toLowerCase();
        // Split the string into words
        String[] words = lowerCaseStr.split("\\s+");
        // Count the occurrence of the word
        for (String w : words)
        {
            if (w.equals(lowerCaseWord))
            {
                count++;
            }
        }
        System.out.println("The word '" + word + "' appears " + count + " times in the string.");
    }

    public static void duplicateWordCount(String Input) {
        String normalizedStr = Input.toLowerCase();
        String[] words = normalizedStr.split("\\W+");
        Map<String, Integer> wordCountMap = new HashMap<>();
        for (String word : words) {
            if (wordCountMap.containsKey(word)) {
                wordCountMap.put(word, wordCountMap.get(word) + 1);
            } else {
                wordCountMap.put(word, 1);
            }
        }
        System.out.println("Duplicate words in the String:");
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet())
        {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }
        }
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

    public static void findDuplicateCharacter2(String str) {
        String[] words = str.split("");
        Map<String, Integer> wordCountMap = new HashMap<>();
        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + ":" + entry.getValue() + "times");
            }
        }
    }

    public static void findRepeatedCharacter(String input){
        Character result = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toMap(Function.identity(), v -> 1, Integer::sum, LinkedHashMap::new))
                .entrySet().stream().filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .findFirst().orElse(null);

        if (result != null) {
            System.out.println("First repeated character:" + result);
        } else {
            System.out.println("NO repeated characters found");
        }
    }
    public static boolean containOnlyLetter(String input){
        for(int i=0;i<input.length();i++){
            if(!Character.isLetter(input.charAt(i)))
            {
                return false;
            }
        }
        return true;
    }

    public static boolean containsOnlyDigits(String str)
    {
        for(int i=0; i<str.length();i++){
            if(!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public  static boolean containsOnlydigits(String str){
        return str.matches("\\d+");
    }

    public static boolean containOnlyDigits2(String str){
        return str.chars().allMatch(Character::isDigit);
    }

    public static boolean containsOnlyDigits3(String str){
        return StringUtils.isNumeric(str);
    }


public static Map<Character, Integer> countCharacters(String input) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : input.toCharArray()){
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        return charCountMap;
    }

    public static void characterCountInString(String input){
        Map<Character, Long> characterCounts=
                input.chars()
                        .mapToObj(c->(char)c)
                        .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));


        System.out.println("Character counts:");
        characterCounts.forEach((character, count)-> System.out.println(character+":"+count));
    }

    public static void countCharacterInString(String input){

        input.chars()
                .mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream().filter(entry->entry.getValue()>1)
                .forEach(entry-> System.out.println("Character:"+entry.getKey()+",Count:"+entry.getValue()));

    }

    public static void Reversingsecondcharacterwithchangecase(String str){
        char[] charArr=str.toCharArray();
        char[] newcharArr=new char[charArr.length];
         for(int i=0;i<charArr.length;i=i+2)
         {
             newcharArr[i+1]=Character.toUpperCase(charArr[i]);
             newcharArr[i]= Character.toLowerCase(charArr[i+1]);
         }
        System.out.println(newcharArr);
    }
}
