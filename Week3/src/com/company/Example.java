package com.company;

import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Example {
    static List<String> recordLst = Arrays.asList(
            "Bruce,123456",
            "Dory,987654",
            "Gill,654321",
            "Mary,919191"
    );

    static List<Pair> createPairImperative(List<String> col) {
        List<Pair> pairLst = new ArrayList<>();
        for (String rec : col) {
            String[] token = rec.split(",");
            pairLst.add(Pair.with(token[0], token[1]));
        }
        return pairLst;
    }

    static List<Pair> createPairFunctional(List<String> col, String delimiter) {
        return col.stream()
                .map(rec -> {
                    String[] token = rec.split(delimiter);
                    return Pair.with(token[0], Integer.parseInt(token[1]));
                })
                //alternatively,
//                .map(rec -> Pair.fromCollection(Arrays.asList(rec.split(delimiter))))
                .collect(Collectors.toCollection(ArrayList::new));
    }


    public static void main(String[] args) {
//        CodeFromSlide.run();

        long start2 = System.nanoTime();

        System.out.println("Create Pair with Imperative Coding");
        List<Pair> pair1 = createPairImperative(recordLst);
        pair1.forEach(System.out::println);
        long end2 = System.nanoTime();
        System.out.println("Elapsed Time in nano seconds: " + (end2 - start2));

        System.out.println("----------------------------------");

        long start1 = System.nanoTime();
        System.out.println("Create Pair with Functional Coding");
        List<Pair> pairs = createPairFunctional(recordLst, ",");
        pairs.forEach(System.out::println);
        long end1 = System.nanoTime();
        System.out.println("Elapsed Time in nano seconds: " + (end1 - start1));




//        System.out.println("Create Pair with Functional Coding");
//        List<Pair> pairs = createPair(recordLst, ",");
//        pairs.forEach(System.out::println);
//
//        System.out.println("----------------------------------");
//        System.out.println("Create Pair with Imperative Coding");
//        List<Pair> pair1 = createPair(recordLst);
//        pair1.forEach(System.out::println);

    }

}
