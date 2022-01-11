package com.company;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Dory", "Gill", "Bruce", "Nemo");
        findNemo(names);
    }

    /**
     * Imperative Coding, that I tried to implement in functional programming
     */
    public boolean findNemoWithSteam(List<String> names) {
        return names.stream() // This is iterating over the list
                .anyMatch(name -> name.equals("Nemo"));
    }

    /**
     * This works, but it is not pure,as contains() is not pure
     * because it throws an exception which is a side effect
     */
    public boolean findNemoWithListAPI(List<String> names) {
        return names.contains("Nemo");
    }

    /**
     * This is to demonstrate the use of passing static methods as arguments
     */
    public static String find(List<String> names) {
        return names.stream()
                .filter(name -> name.equals("Nemo")) // Lambda expression
//                .filter(Main::chkNemo) // you can also pass the method as a reference
                .findAny().orElse(null);
    }

    static boolean chkNemo(String elem) {
        return elem.equals("Nemo");
    }

    /**
     * Imperative Coding,
     * Impure Function
     */
    public static void findNemo(List<String> names) {
        boolean found = false; // This is not a good practice as it introduces side effects
        for (String name : names) {
            if (name.equals("Nemo")) {
                found = true;
                break;
            }
        }

        //Ei I ask you to find, didn't ask you to print la bitch
        if (found)
            System.out.println("Found Nemo");//In functional Programming, we should not have side effects like this
        else
            System.out.println("Sorry, Nemo not found");
    }

}
