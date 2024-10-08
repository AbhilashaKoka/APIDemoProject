package org.example.javaDemo.String;

public class FrequencyOfcharacterInString {

    public static void main(String[] args) {

        FindFreqofEachCharacterInString("Java is Fun");
        FrequencyOfGivenCharacter("Java is Fun", 'a');
    }


        public static void FindFreqofEachCharacterInString(String str){
            int i, j;
            char[] string = str.toCharArray();
            int[] freq = new int[str.length()];
            for (i = 0; i < str.length(); i++) {
                freq[i] = 1;
                for (j = i + 1; j < str.length(); j++) {
                    if (string[i] == string[j]) {
                        freq[i]++;
                        string[j] = '0';
                    }
                }
            }

            System.out.println("Characters and their corresponding frequencies");
            for (i = 0; i < freq.length; i++) {
                if (string[i] != ' ' && string[i] != '0')
                    System.out.println(string[i] + "-" + freq[i]);
            }
        }

    public static void FrequencyOfGivenCharacter(String str, char c){

        int count = 0;
        for (int i=0; i<=str.length()-1; i++) {
        if(str.charAt(i) == c) {
            count++;
        }
    }
        System.out.println("Frequency of t is: "+count);
}
}
