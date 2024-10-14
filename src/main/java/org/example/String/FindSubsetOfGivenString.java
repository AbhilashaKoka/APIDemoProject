package org.example.String;

public class FindSubsetOfGivenString{

    public static void main(String[] args) {
        String str = "aaaabbbbcccc";
        DivideStringInSubSet(str,3);
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
    }

