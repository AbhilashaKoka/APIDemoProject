package javaProgram.demo.stringTest;

public class OnlyDigitCheck {
    public static void main(String[] args) {
        String input="12353";
        boolean isOnlyDigits=input.matches("\\d+");
        System.out.println("Contains only digits:"+isOnlyDigits);
    }
}
