package org.example.ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayAndArrayLIstConversion {
    public static void main(String[] args){
        String[] array={"java","Python","C++"};
        List<String> arrayList=new ArrayList<>(Arrays.asList(array));
        System.out.println("Array to ArrayList:"+arrayList);

        ArrayList<String> listOfLanguages=new ArrayList<>();
        listOfLanguages.add("Javascript");
        listOfLanguages.add("TypeScript");
        listOfLanguages.add("kotlin");

        String[] languageArray=listOfLanguages.toArray(new String[0]);
        System.out.println("ArrayList to an array:"+Arrays.toString(languageArray));




    }
}
