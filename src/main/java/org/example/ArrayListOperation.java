package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayListOperation {
    public static void main(String[] args) {
        String[] array = {"java", "Python", "C++"};
        arrayToArrayList(array);

        ArrayList<String> list1=new ArrayList<>();
        list1.add("Java");
        list1.add("Python");
        list1.add("C++");

        ArrayList<String> list2=new ArrayList<>();
        list2.add("Java");
        list2.add("Python");
        list2.add("C++");
        compareTwoArrayList(list1,list2);


        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        List<Integer> filterarr= filterEvenNumberArrayList(numbers);
        for(int element:filterarr){
            System.out.println(element);
        }
    }

    public static List<Integer> filterEvenNumberArrayList(ArrayList<Integer> num){
        List<Integer> ls= num.stream()
                .filter(number->number%2==0)
                .collect(Collectors.toList());
        return ls;

    }
    public static void compareTwoArrayList(ArrayList<String> ls1, ArrayList<String> ls2){
        boolean isEqual=ls1.equals(ls2);
        System.out.println("list1 equals list2:"+isEqual);
        boolean isContained=ls1.containsAll(ls2);
        System.out.println("list1 contained all elements list2:"+isContained);
    }

    public static void arrayToArrayList(String[] arr){
        List<String> ls=new ArrayList<>(Arrays.asList(arr));
        System.out.println("Array to ArrayList:"+ls);
        ArrayList<String> listOfLanguages=new ArrayList<>();
        listOfLanguages.add("Javascript");
        listOfLanguages.add("TypeScript");
        listOfLanguages.add("kotlin");
        String[] languageArray=listOfLanguages.toArray(new String[0]);
        System.out.println("ArrayList to an array:"+Arrays.toString(languageArray));

    }

    public static <T> List<T> RemoverDuplicateMethod(List<T> list) {
        List<T> newList = new ArrayList<>();
        for (T element : list) {
            if (!newList.contains(element)) {
                newList.add(element);
            }
        }
        return newList;
    }
}
