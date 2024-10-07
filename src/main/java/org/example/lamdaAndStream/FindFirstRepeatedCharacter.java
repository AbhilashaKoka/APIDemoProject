package org.example.lamdaAndStream;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindFirstRepeatedCharacter {
    public static void main(String[] args) {
        String input = "javastream";
        Character result = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toMap(Function.identity(), v -> 1, Integer::sum, LinkedHashMap::new))
                .entrySet().stream().filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .findFirst().orElse(null);

        if (result != null) {
            System.out.println("First repeated character:" + result);
        } else {
            System.out.println("NO repeated characters found");
        }
    }
}

