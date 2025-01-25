package programsDemo.stringTest;

public class OperationInString {
    String  str1,str2,str3,str,str4,s5,s6,s7,s8,s9,s10;

    public OperationInString() {
         str1 = "Hello";
         str2 = "Javatpoint";
         str3 = "Reader";
         str = "Country";
         str4 = "Hello Javatpoint readers";
         s5 = "hello";
         s6 = "hello";
         s7 = "meklo";
         s8 = "hemlo";
         s9 = "flag";
         s10 = "java by javatpoint";
    }

    public static void main(String args[]) {

        OperationInString op= new OperationInString();
        op=new OperationInString();
        op.ConcatTwoString();
        op. ContainString();
        op.ComparingTwoString();
        op.CheckStringsAreEqual();
    }

     public  void ComparingTwoString(){
        System.out.println(s5.compareTo(s6));//0 because both are equal
        System.out.println(s5.compareTo(s7));//-5 because "h" is 5 times lower than "m"
        System.out.println(s5.compareTo(s8));//-1 because "l" is 1 times lower than "m"
        System.out.println(s5.compareTo(s9));//2 because "h" is 2 times greater than "f"
      }


        public  void ConcatTwoString(){
        String str4 = str1.concat(" ").concat(str2).concat(" ").concat(str3);
        System.out.println(str4);
        String str5 = str1.concat("!!!");
        System.out.println(str5);
        String str6 = str1.concat("@").concat(str2);
        System.out.println(str6);
        String s = "India is my ".concat(str);
        System.out.println(s);
     }

    public void ContainString() {
            boolean isContains = str4.contains("Javatpoint");
            System.out.println(isContains);
            System.out.println(str4.contains("javatpoint")); // false
        }

        public void EndWithCharacter(){
        System.out.println(s10.endsWith("t"));
        System.out.println(s10.endsWith("point"));
            if(str.endsWith(".com")) {
                System.out.println("String ends with .com");
            }else System.out.println("It does not end with .com");
        }


public  void CheckStringsAreEqual(){
    String s11="javatpoint";
    String s12="javatpoint";
    String s13="JAVATPOINT";
    String s14="python";
    System.out.println(s11.equals(s12));//true because content and case is same
    System.out.println(s11.equals(s13));//false because case is not same
    System.out.println(s11.equals(s14));//false because content is not same
}
}



