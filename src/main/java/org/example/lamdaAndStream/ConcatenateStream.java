package org.example.lamdaAndStream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConcatenateStream {
    public static void main(String[] args) {
        Stream<String> stream1= Stream.of("Java","Python","C++");
        Stream<String> stream2= Stream.of("Javascript","TypeScript","Kotlin");
    }

    public static void concatenateStream(Stream<String> stream1,Stream<String>stream2){
        Stream<String> concatenatedStream=Stream.concat(stream1,stream2);
        List<String> resultList=concatenatedStream.collect(Collectors.toList());
        System.out.println("Concatenated Stream Result:"+resultList);
    }

}
