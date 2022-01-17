package com.company;

import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Triplet;

import java.util.Arrays;
import java.util.List;

public class CodeFromSlide {
    public static void run() {
        Pair<String, Integer> pair = new Pair<String, Integer>("A pair", 55);

        pair.forEach(System.out::println);

        Triplet<String, Integer, Double> triplet = Triplet.with("hello", 23, 1.2);

        triplet.forEach(System.out::println);

        Quartet<String, Double, Integer, String> quartet = Quartet.with("john", 72.5, 32, "1051 SW");

        quartet.forEach(System.out::println);

        List<String> listOfNames = Arrays.asList("john", "doe", "anne", "alex");

        listOfNames.stream().map(String::toUpperCase).forEach(System.out::println);
    }
}
