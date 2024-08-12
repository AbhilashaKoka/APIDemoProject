package org.example.String;

public class MergedString {
    public static void main(String[] args) {
        String[] str1={"java","is","fun"};
        String[] str2={"and", "powerful"};

        String[] mergedarr=new String[str1.length+str2.length];
        int index=0;

        for(String s1:str1){
            mergedarr[index++]=s1;
        }

        for(String s2:str2)
        {
            mergedarr[index++]=s2;
        }

        System.out.println("Merged array using loop:");
        for(String element:mergedarr){
            System.out.println(element);
        }
    }

}
