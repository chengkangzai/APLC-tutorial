package com.company;

public class Main {

    public static void main(String[] args) {
        int a = Main.sum_by_recursion(5);
        System.out.println(a);
    }

    // impact: clear code and readable
    static int sum_by_recursion(int n) {
        if (n > 0) {
            return n + sum_by_recursion(n - 1); // recursive call
        }
        return n; // stop condition
    }
}
