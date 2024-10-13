package org.example.String;

public class ChangeEvenPositionToUpperCaseAndOddPositionToLowerCaseAndInterchangePosition{

    //OP:IsAtUkAmIr
    public static void main(String[] args) {

        String str = "sitakumari";
        Reversingsecondcharacterwithchangecase(str);
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
