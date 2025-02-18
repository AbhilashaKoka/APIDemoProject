package utilityDemoTest.programInJavaTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.Scanner;

import static utilityDemoTest.programInJavaTest.StringOperation.*;

public class TestClass {
    //OP:IsAtUkAmIr


    @Test
    public void Test1() {
            String str = "sitakumari";
            Reversingsecondcharacterwithchangecase(str);
            Assert.assertEquals("iSaTuKaMiR","iSaTuKaMiR");
        }

    @Test
    public void Test2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string:");
        String input = scanner.nextLine();
        Map<Character, Integer> charCount = countCharacters(input);
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());

        }

    }
    @Test
    public void Test3() {
        String input1 = "123456";
        boolean result = containsOnlyDigits(input1);
        System.out.println(result);
    }

    @Test
    public void Test4() {

        String str1 = "HelloWorld";
        boolean result1 = containOnlyLetter(str1);
        System.out.println(result1);

    }
    @Test
    public void Test5() {
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Enter the String:");
        String str3 = scanner2.nextLine();
        duplicateCharacterCount(str3);
    }
    @Test
    public void Test6() {
        String sentence = "Java id a programming language and java is also a platform";
        System.out.println("Duplicate words in the string is:");
        findDuplicateCharacter2(sentence);
    }

    @Test
    public void Test7() {
        String input2 = "javastream";
        findRepeatedCharacter(input2);
    }

    @Test
    public void Test8() {

        String Input = "Java is great and java is fun, Programming in java is great";
        duplicateWordCount(Input);
    }
    @Test
    public void Test9() {
        String text = "this is a test this is only a test";
        findOccurrenceOfWordInStr(text);
    }

    @Test
    public void Test10() {
        String str4 = "This is an example string, an example of a string.";
        String word = "example";
        findOccurOfWordInStr(str4, word);
    }

    @Test
    public void Test11() {
        String str5 = "aaaabbbbcccc";
        DivideStringInSubSet(str5, 3);
    }

    @Test
    public void Test12() {
        Scanner scanner6 = new Scanner(System.in);
        System.out.println("Enter any string:");
        String input3 = scanner6.nextLine();
        generateallPermutationOfString(input3);
    }
    @Test
    public void Test13() {
        String str66 = "HelloWorld12344";
        boolean result6 = containOnlyLetter1(str66);
        System.out.println(result6);
        String str8 = "sample string";
        maxOccurOfChar(str8);
    }
    @Test
    public void Test14() {
        String[] str11 = {"java", "is", "fun"};
        String[] str21 = {"and", "powerful"};
        mergeTwoStrs(str11, str21);
    }

    @Test
    public void Test15() {
        String text1 = "Java Guides";
        char result11 = findNonRepeatedCharater(text1);
        if (result11 != '\0'){
            System.out.println("The Non repeated character is:" + result11);
        } else {
            System.out.println("All character  are repeated");
        }
    }
    @Test
    public void Test16() {


        Scanner scanner4 = new Scanner(System.in);
        System.out.println("Enter any String :");
        String str7 = scanner4.nextLine();
        Boolean palindrome = isPalindrome(str7);
        System.out.println("String is Palindrome:"+palindrome);
    }

    @Test
    public void Test17() {

        String input9 = "Java is great and java is fun and java is powerful";
        String result9 = removeTheDuplicateWords(input9);
        System.out.println(result9);
    }
    @Test
    public void Test18() {

        String str99 = "java is great and fun";
        String result99 = reverseWordIntradition(str99);

        System.out.println("reverse String:" + result99);
    }
    @Test
    public void Test19() {
        Integer[] arr = {1, 2, 3, 4, 5};
        reverseList(arr);
    }
    @Test
    public void Test20() {
        String input34 = "java is great. java is fun. java is POwerful";
        String substring = "Java";
        subStringCount(input34, substring);
    }
    @Test
    public void Test21() {
        String str14 = "Hello";
        String str24 = "World";
        swapToString(str14, str24);
    }

    @Test
    public void Test22() {
        Scanner scanner5 = new Scanner(System.in);
        System.out.println("Enter your string:");
        String input5 = scanner5.nextLine();
        int[] counts = countVowelsAndConsonants(input5);
        System.out.println("Number of vowels: " + counts[0]);
        System.out.println("Number of consonants: " + counts[1]);
    }
    @Test
    public void Test23() {
        String str555 = "Abhilasha Koka Koka";
        nonRepeatedCharacter(str555);

    }
    @Test
    public void Test24() {
        String str34 = "hello 54689 world of 8687 gorilla";
        String output = capitalizeWords(str34);
        System.out.println(output);
    }

    @Test
    public void Test25() {
    String input1 = "hello world";
    characterCountInString(input1);
    String input2 = "programming";
    countCharacterInString(input2);

}

@Test
    public void Test26()
{

    String str = " Hello World";
    String str2 = swapFirstLast(str);
    System.out.println("Original String: " + str);
    System.out.println("Modified String: " + str2);
}

@Test
    public void Test27()
{
    int nameLength = 10;
    String randomName = generateRandomName(nameLength);
    System.out.println("Generated Random Name: " + randomName);
}



@Test
    public void Test28()
{
    String password = generatePassword();
    System.out.println("Generated Password: " + password);
}

@Test
    public void Test29()
{
    String  UUID=UUIDGenerator();
    System.out.println(UUID);

}
}


