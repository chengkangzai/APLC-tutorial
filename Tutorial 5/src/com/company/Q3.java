package com.company;

import java.util.function.BiFunction;

public class Q3 {
    BiFunction<String, String, String> join2 = (s1, s2) -> String.join(" ", s1, s2);

    public static void run() {
        Joiner joiner = (str1, str2) -> String.join(" ", str1, str2);
        System.out.println(joiner.apply("Hello", "World"));

        //or this, using BiFunction
        Q3 q1 = new Q3();
        System.out.println(q1.join2.apply("Hello", " World"));
    }

}


@FunctionalInterface
interface Joiner {
    String apply(String a, String b);
}

