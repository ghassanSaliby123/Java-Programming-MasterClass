package com.ghassan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    //It is a new concept in Java 8 helps us to make a sequence of actions
    //This interface contains several methods
    //When we write the sequence of operations, each one works on the results if the previous one
    //Through these operations we can write method reference such as String::toUpperCase()
    //This way can be applied if the operation is a method and a function at the same time
    //A method means that it is a part from object String.toUppercase
    //A function means that it can work without an object toUpperCase(String)
    //So we can write it in the method reference way String::toUpperCase()
    //We can create Streams based on collections such as Collections.stream()
    //Or we can create a stream through of() method Stream.of(, , , ,); which should be from the same type
    public static void main(String[] args) {
        List<String> someBingoNumbers = Arrays.asList(
                "N40","N36",
                "B12", "B6",
                "G53", "G49", "G60", "G50","g34",
                "I26", "I17", "I29",
                "O71");

        List<String> gNumbers = new ArrayList<>();
        //The commented code below can be replaced with one statement using stream
        //The stream
        someBingoNumbers.stream()
                .map(String::toUpperCase)
                .filter(s->s.startsWith("G"))
                .sorted()
                .forEach(System.out::println);

        //Print the numbers start with G
//        someBingoNumbers.forEach(number -> {
//            if (number.toUpperCase().startsWith("G")){
//                gNumbers.add(number);
//            }
//        });
//
//       gNumbers.sort((s1, s2) -> s1.compareTo(s2));
//       gNumbers.forEach(s -> System.out.println(s));

        //Creating a stream without a collection
        Stream<String> ioNumberOfStream = Stream.of("I26","I17","I29","O71");
        Stream<String> inNumberOfStream = Stream.of("N40","N36","I26","I17","I29","O71");
        //concat two streams together
        Stream<String> concatStream = Stream.concat(ioNumberOfStream,inNumberOfStream);
        //count the unique object in the stream it is a terminal operation
        System.out.println(concatStream.distinct().count());

    }
}
