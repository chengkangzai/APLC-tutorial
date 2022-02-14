package com.company;

import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println(fibonacci(5));
        countdown(5);
        int[] numArr = new int[]{2, 3, 1, 48, 6, 3, 8, 9};
        System.out.println(maximum(8, numArr));
    }


    static int factorial(int n) {
        if (n == 1) {
            return n;
        } else {
            return n * factorial(n - 1);
        }
    }

    static void countdown(int n) {
        if (n > 0) {
            System.out.println(n);
            countdown(n - 1);
        } else {
            System.out.println("Timeout!");
        }
    }

    static int fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    static UnaryOperator<Integer> factorial = n -> {
        if (n == 1) {
            return n;
        } else {
            return n * Main.factorial.apply(n - 1);
        }
    };

    //create a method to reverse string with recursion
    static UnaryOperator<String> reverse = n -> {
        if (n.length() == 1) {
            return n;
        } else {
            return n.charAt(n.length() - 1) + Main.reverse.apply(n.substring(0, n.length() - 1));
        }
    };

    //create a method to find max number with recursion in array of number
    static int max(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        } else {
            return Math.max(arr[arr.length - 1], max(arr));
        }
    }

    public static int maximum(int size, int[] arr) {
        if (size == 1)
            return arr[0];
        return Math.max(arr[size - 1], maximum(size - 1, arr));
    }

}


