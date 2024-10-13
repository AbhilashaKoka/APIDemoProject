package org.example.ArrayList;

import java.util.ArrayList;

public class CompareArrayLists{
    public static void main(String[] args) {
        ArrayList<String> list1=new ArrayList<>();
        list1.add("Java");
        list1.add("Python");
        list1.add("C++");

        ArrayList<String> list2=new ArrayList<>();
        list2.add("Java");
        list2.add("Python");
        list2.add("C++");
        compareTwoArrayList(list1,list2);
    }

    public static void compareTwoArrayList(ArrayList<String> list1, ArrayList<String> list2){
        boolean isEqual=list1.equals(list2);
        System.out.println("list1 equals list2:"+isEqual);

        boolean isContained=list1.containsAll(list2);
        System.out.println("list1 contained all elements list2:"+isContained);
    }
}
