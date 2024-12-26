package javaProgram.demo.stringTest;

public class PrintCharacterAtOddAndEvenPosition {

    public static void main(String[] args) {
        PrintCharacterAtOdd("AbhilashaKoka");
        PrintCharacterAtEven("AbhilashaKoka");
    }


    public static void PrintCharacterAtOdd(String str)
    {
        for (int i=0; i<=str.length()-1; i++) {
            if(i%2!=0)
            {
                System.out.println("Char at "+i+" place "+str.charAt(i));
            }
        }
    }

    public static void PrintCharacterAtEven(String str){
        for(int i=0;i<str.length()-1;i++){
            if(i%2==0)
            {
                System.out.println("Char at "+i+" place "+str.charAt(i));
            }
        }
    }
}
