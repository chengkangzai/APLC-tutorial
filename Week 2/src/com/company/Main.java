package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        int[] array = {12, 34, 21, 4, 56, 77, 88, 44, 885, 2, 5, 7, 98, 54};


        iterateAndPrintArray(array);
        searchAndDisplayArray(array, 885);
        doubleUpEachElement(array);
        sortElementInAscendingOrder(array);
        sortElementInDescendingOrder(array);
        generateNumberInRangeWithGap();
        displayElementThatIsGreaterThan10(array);
        printMinAndMin(array);
        printSumAndAverage(array);
        findEvenNumber(array);
    }

    public static void iterateAndPrintArray(int[] array) {
        Arrays
                .stream(array)
                .forEach(System.out::println);

        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void searchAndDisplayArray(int[] array, int element) {
        IntStream
                .range(0, array.length)
                .filter(i -> array[i] == element).findFirst()
                .ifPresent(i -> System.out.println("Element found at index " + i));

        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                System.out.println("Element found at index " + i);
            }
        }
    }

    public static void doubleUpEachElement(int[] array) {
        Arrays
                .stream(array)
                .map(i -> i * 2)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new)) // convert to ArrayList
                .forEach(System.out::println);


        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int j : array) {
            arrayList.add(j * 2);
        }
        arrayList.forEach(System.out::println);
    }

    public static void sortElementInAscendingOrder(int[] array) {
        Arrays
                .stream(array)
                .sorted()
                .forEach(System.out::println);

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(array));
    }

    public static void sortElementInDescendingOrder(int[] array) {
        Arrays
                .stream(array)
                .boxed()
                .sorted(Collections.reverseOrder())
                .forEach(System.out::println);

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static void generateNumberInRangeWithGap() {
        int[] array = IntStream.rangeClosed(1, 100).filter(i -> i % 2 == 0).toArray();
        System.out.println(Arrays.toString(array));

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                arrayList.add(i);
            }
        }
        System.out.println(arrayList);
    }

    public static void displayElementThatIsGreaterThan10(int[] array) {
        Arrays
                .stream(array)
                .filter(i -> i > 10)
                .forEach(System.out::println);

        for (int j : array) {
            if (j > 10) {
                System.out.println(j);
            }
        }
    }

    public static void printMinAndMin(int[] array) {
        Arrays
                .stream(array)
                .min()
                .ifPresent(x -> System.out.println("Minimum element is " + x));
        Arrays
                .stream(array)
                .max()
                .ifPresent(x -> System.out.println("Maximum element is " + x));

        int min = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.println("Minimum element is " + min);
        System.out.println("Maximum element is " + max);
    }

    public static void printSumAndAverage(int[] array) {
        int sum = Arrays
                .stream(array, 0, array.length)
                .sum();
        System.out.println("Sum of the elements is " + sum);

        Arrays
                .stream(array, 0, array.length)
                .average()
                .ifPresent(x -> System.out.println("Average of the elements is " + x));

        int sum1 = 0;
        for (int j : array) {
            sum1 += j;
        }
        System.out.println("Sum of the elements is " + sum1);
        System.out.println("Average of the elements is " + sum1 / array.length);
    }

    public static void findEvenNumber(int[] array) {
        Arrays
                .stream(array)
                .filter(i -> i % 2 == 0)
                .sorted()
                .forEach(x -> System.out.println(x + " is even number"));

        for (int j : array) {
            if (j % 2 == 0) {
                System.out.println(j + " is even number");
            }
        }
    }
}