package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Q9 {
    public static void main(String[] args) throws IOException {
//        Assume that the following file contains 10 integers. Find and display the total of all integers.
        Files.lines(Paths.get("src/com/company/units.txt")).forEach(System.out::println);
        var s = Files.lines(Paths.get("src/com/company/units.txt")).mapToInt(Integer::parseInt).sum();
        System.out.println(s);
    }
}
