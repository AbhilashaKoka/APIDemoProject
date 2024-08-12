package org.example.lamdaAndStream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class RetrieveLastElement {
    public static void main(String args[]){
        List<String> strings= Arrays.asList("Java","Python","C++","Javascript","Ruby");
        Optional<String> lastElement=strings.stream().reduce((first,second)->second);
        lastElement.ifPresent(element-> System.out.println("The last element is:"+element));
    }
}
