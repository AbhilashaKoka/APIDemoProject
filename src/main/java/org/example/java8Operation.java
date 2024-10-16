package org.example;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class java8Operation {

    public static void main(String[] args) {
        String input = "hello world";
        characterCountInString(input);

        Stream<String> stream1= Stream.of("Java","Python","C++");
        Stream<String> stream2= Stream.of("Javascript","TypeScript","Kotlin");
        concatenateStream(stream1,stream2);

        String input1 = "programming";
        countCharacterInString(input1);

        String input2 = "javastream";
        findRepeatedCharacter(input2);

        int[] arr={1,2,3,4,5,6,6,7,8};
        secondLargestInarr(arr);

        List<String> items = List.of("apple", "banana", "cherry");
        listToMapconversion(items);

        List<Integer> numbers = Arrays.asList(2, 4, 7, 5, 9, 10, 3, 1);
        maxAndminElementFinder(numbers);

        int number=29;
        checkPrimeNumber(number);

        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5, 5, 7, 9, 10);
        printEvenNumber(numbers2);

        List<Integer> numberWithDuplicates = Arrays.asList(1, 2, 3, 4, 4, 5, 6, 7, 7, 8, 9, 10);
        System.out.println("Original list with duplicates:" + numberWithDuplicates);
        removeDuplicateElement(numberWithDuplicates);

        List<String> strings = Arrays.asList("Java", "Python", "C++", "Javascript", "Ruby");
        retrievelastElementfromList(strings);

        String input3 = "Java 8 is great";
        reverseEachCharacterInWord(input3);

        String originalString = "Hello";
        reverseString(originalString);

        List<String> strings1 = Arrays.asList("Banana", "Apple", "Orange", "Mango", "Grape");
        sortStringInAlphabeticOrder(strings1);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number:");
        String number4 = scanner.nextLine();
        sumOfAllDigits(number4);
        scanner.close();
    }


    public static void sumOfAllDigits(String num){
        int sum=num.chars()
                .map(Character::getNumericValue)
                .sum();
        System.out.println("The sum of the digits is:"+sum);
    }


    public static void sortStringInAlphabeticOrder(List<String> str){
        List<String> sortstr=str.stream().sorted().collect(Collectors.toList());
        System.out.println("sorted list of string:");
        sortstr.forEach(System.out::println);
    }

    public static  void reverseString(String str){
        String revstr=new StringBuilder(str).reverse().toString();
        System.out.println("Original String:"+str);
        System.out.println("Reversed String:"+revstr);
    }

    public static  void reverseEachCharacterInWord(String str){
        String result= Arrays.stream(str.split(" "))
                .map(word->new StringBuilder(str).reverse().toString())
                .collect(Collectors.joining(""));
        System.out.println("Original string:"+str);
        System.out.println("Reversed string:"+result);
    }

    public static void retrievelastElementfromList(List<String> str){
        Optional<String> lastElement=str.stream().reduce((first,second)->second);
        lastElement.ifPresent(element-> System.out.println("The last element is:"+element));
    }

    public static void removeDuplicateElement(List<Integer> num){
        List<Integer>  num2=num.stream().distinct().collect(Collectors.toList());
        System.out.println("List without duplicates:"+num2);

    }

    public static void printEvenNumber(List<Integer> num){
        System.out.println("Even numbers:");
        num.stream().filter(n->n%2==0).forEach(System.out::println);
    }

    public static void checkPrimeNumber(int num){
        boolean isPrime=isPrime(num);
        if(isPrime)
        {
            System.out.println(num+"is a prime number");
        }
        else
        {
            System.out.println(num+"is not a prime number");
        }
    }

    public static boolean isPrime(int num)
    {
        if(num<=1){
            return false;
        }
        return !IntStream.rangeClosed(2,(int)Math.sqrt(num)).anyMatch(i->num%i==0);
    }

    public static void maxAndminElementFinder(List<Integer> numbers){
        OptionalInt max=numbers.stream().mapToInt(Integer::intValue).max();
        OptionalInt min=numbers.stream().mapToInt(Integer::intValue).min();
        max.ifPresent(value-> System.out.println("Maximun value:"+value));
        min.ifPresent(value-> System.out.println("Minimum value:"+value));

    }

    public static void listToMapconversion(List<String> items){
        Map<String, Integer> itemMap=items.stream()
                .collect(Collectors.toMap(item->item, item->item.length()));

        Map<String, Integer> itemMap2=items.stream()
                .collect(Collectors.toMap(item->item, String::length));

        System.out.println("List to map:"+itemMap2);
        itemMap.forEach((key,value)-> System.out.println(key+":"+value));
    }
    public static void secondLargestInarr(int[] arr){

        List<Integer> numbers= Arrays.asList(1,2,3,4,5,6,6,7,8);
        Optional<Integer> secondLargest=numbers.stream()
                .distinct()
                .sorted()
                .skip(numbers.size() - 2)
                .findFirst();

        secondLargest.ifPresent(s-> System.out.println("The second largest number is:"+s));
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
    public static void countCharacterInString(String input){

        input.chars()
                .mapToObj(c->(char)c)
                .collect(Collectors
                        .groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream().filter(entry->entry.getValue()>1)
                .forEach(entry-> System.out.println("Character:"+entry.getKey()+",Count:"+entry.getValue()));

    }

    public static void concatenateStream(Stream<String> stream1,Stream<String>stream2){
        Stream<String> concatenatedStream=Stream.concat(stream1,stream2);
        List<String> resultList=concatenatedStream.collect(Collectors.toList());
        System.out.println("Concatenated Stream Result:"+resultList);
    }

    public static void characterCountInString(String input){

        Map<Character, Long> characterCounts=
                            input.chars()
                           .mapToObj(c->(char)c)
                           .collect(Collectors
                                   .groupingBy(Function
                                           .identity(),Collectors
                                           .counting()));


        System.out.println("Character counts:");
        characterCounts.forEach((character, count)-> System.out.println(character+":"+count));
    }
}
