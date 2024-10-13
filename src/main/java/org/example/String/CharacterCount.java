package org.example.String;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharacterCount {

    public static void main(String[] args) {
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

}