package org.example.String;// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        String str="Abhilashaa";
        int len=str.length();
        int n=5, temp=0;
        int chars=len/n;


        String[] equalStr=new String[n];
        for(int i=0;i<len;i=i+chars){
            String part=str.substring(i,i+chars);
            equalStr[temp]=part;
            temp++;
        }

        for(int i=0;i<equalStr.length;i++){
            String  str1=equalStr[i].toString();
            System.out.println(str1);
            for(int j=str1.length()-1;j>0;j--){
                 str1+=str1.charAt(j);
            }
            System.out.println(str1);
        }
    }
}