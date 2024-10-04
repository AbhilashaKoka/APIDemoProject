package org.example.javaDemo.String;

public class FrequencyOfcharacterInString {

    public static void main(String[] args) {

        String str = "AbhilashaKoka";
        int i, j;
        char[] string = str.toCharArray();
        int[] freq = new int[str.length()];
        for (i = 0; i < str.length(); i++){
            freq[i] = 1;
            for (j = i + 1; j < str.length(); j++){
                if (string[i] == string[j]){
                    freq[i]++;
                    string[j] = '0';
                }
            }
        }

        System.out.println("Characters and their corresponding frequencies");
        for (i = 0; i<freq.length; i++) {
            if (string[i]!=' ' && string[i] != '0')
                System.out.println(string[i] + "-" + freq[i]);
        }

    }
}
