package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.IntStream;

public class Q2 {

    BiFunction<Integer, ArrayList<Integer>, Integer> compute = (x, y) -> List.copyOf(y).stream().mapToInt(Integer::intValue).sum() * x;

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int a = TestComputer.compute(1, arr);
        System.out.println(a); // 55

        //This is the same as above, but using the functional interface or lambda expression
        int b = new Q2().compute.apply(1, new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        System.out.println(b); // 55
    }
}

//implementing functional concept using Java/Javascript language.
class TestComputer {
    static int compute(int x, int[] input) {
        return IntStream.of(input).sum() * x;
    }

    //acceptable, but not pure
    static int compute1(int x, int[] input) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            list.add(input[i]);
        }
        return list.stream().mapToInt(Integer::intValue).sum() * x;
    }

//    static int sum = 0;
//
//    static int compute(int x, int[] a) {
//        for (int i : a) {
//            sum += i;
//        }
//        return x * sum;
//    }


}
