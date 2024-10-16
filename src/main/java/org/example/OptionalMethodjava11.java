package org.example;

import java.util.Optional;

public class OptionalMethodjava11 {
    public static void main(String[] args){
        Optional<String> opt=Optional.of("java11");
        System.out.println(opt.isEmpty());
        opt.ifPresentOrElse(value-> System.out.println("value:"+value),
                              ()-> System.out.println("Value is absent"));
            Optional<String> orOpt=Optional.<String>empty().or(()->Optional.of("Default"));
        System.out.println(orOpt.get());
        opt.stream().forEach(System.out::println);
//String Method In Java11
        String str="JAVA11";
        System.out.println(str.isBlank());
        System.out.println(str.strip());
        System.out.println(str.stripLeading());
        System.out.println(str.stripTrailing());
        System.out.println("java\nKotlin\nScala".lines().count());
        System.out.println("Hello".repeat(3));
        String baseString="Hello";

        String updatedString=baseString+",World!";

        System.out.println(" Using +operator:"+updatedString);

        String concatString=baseString.concat(",World!");

        System.out.println("Using Concate method:"+concatString);

        System.out.println("Using StringBuilder:" + (baseString) + ",World!");

        }
    }

