package org.example.String;

import java.util.Optional;

public class OptionalMethodjava11 {
    public static void main(String args[]){
        Optional<String> opt=Optional.of("java11");
        System.out.println(opt.isEmpty());
        opt.ifPresentOrElse(value-> System.out.println("value:"+value),
                              ()-> System.out.println("Value is absent"));
            Optional<String> orOpt=Optional.<String>empty().or(()->Optional.of("Default"));
        System.out.println(orOpt.get());
        opt.stream().forEach(System.out::println);

        }
    }

