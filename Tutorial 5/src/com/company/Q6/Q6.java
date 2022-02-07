package com.company.Q6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q6 {
    static final List<Book> bookList = Arrays.asList(
            new Book("When Breath Becomes Air", 8.8),
            new Book("The Universe Has Your Back", 5.6),
            new Book("A War and Peace", 7.9),
            new Book("One Hundred Years of Solitude", 7.9),
            new Book("Moby Dick", 4.3),
            new Book("The Great Wall", 7.0)
    );

    public static void main(String[] args) {
//        With the use of Function as argument manner, demonstrate Java code for sorting the Book objects stored in the List as follow by book title and rating.
        bookList.sort(Comparator.comparing(Book::getTitle).thenComparing(Book::getRating));
        bookList.forEach(book -> System.out.println(book.getTitle() + " " + book.getRating()));
    }
}
