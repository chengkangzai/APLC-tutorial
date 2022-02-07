package com.company;

import java.util.function.Function;

public class Q5 {
    // Converting f(20, 15) = 20 + 15 to currying

    //Standard function
    public static int f(int a, int b) {
        return a % b;
    }

    Function<Integer, Integer> f2(int i1) {
//        return new Function<Integer, Integer>() {
//            @Override
//            public Integer apply(Integer i2) {
//                return i1 % i2;
//            }
//        };
        return i2 -> i1 % i2;
    }

    //lambda expression
    Function<Integer, Function<Integer, Integer>> f3 = i1 -> i2 -> i1 % i2;

    public static void main(String[] args) {
        //Scenario 2
        int i1 = 9;
        Function<Integer, Integer> woLambda = new Q5().f2(i1); //partial-app, wo lambda
        Function<Integer, Integer> wLambda = new Q5().f3.apply(i1); //partial-app, w lambda

        System.out.println(compute(woLambda));
        //or ...
        System.out.println(compute(wLambda));


        // Scenario 1
        int i2 = 3;
        System.out.println(Q5.f(i1, i2));
        //or ...
        System.out.println(new Q5().f2(i1).apply(i2));
    }

    static int compute(Function<Integer, Integer> func) {
        int i2 = 3;
        return func.apply(i2);
    }
}
