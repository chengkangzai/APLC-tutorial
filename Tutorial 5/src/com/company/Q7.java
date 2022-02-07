package com.company;

import java.util.function.Function;

public class Q7 {
    //turn f(a, b, c, d) = (a + b) * (c + d). to currying function

    public static int normal(int a, int b, int c, int d) {
        return (a + b) * (c + d);
    }

    static Function<Integer, Function<Integer, Function<Integer, Function<Integer, Integer>>>> currying = a -> b -> c -> d -> (a + b) * (c + d);

    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 3;
        int d = 4;
        System.out.println(normal(a, b, c, d));
        System.out.println(currying.apply(a).apply(b).apply(c).apply(d));
    }
}
