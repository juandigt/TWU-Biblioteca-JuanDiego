package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

public class LibraryTest {

    @Test
    public void listBooksCanBeFilled() {
        ArrayList<Book> libraryBooksTest = new ArrayList<Book>();
        ArrayList<Book> userBooksTest = new ArrayList<Book>();
        Library library = new Library(libraryBooksTest, userBooksTest);

        boolean actualEmpty = libraryBooksTest.isEmpty();
        boolean expectedEmpty = true;
        assertEquals(expectedEmpty, actualEmpty);


        library.fillLibrary();

        boolean actual = libraryBooksTest.isEmpty();
        boolean expected = false;

        assertEquals(expected, actual);

    }

    @Test
    public void checkoutOneBookTest() {

        ArrayList<Book> libraryBooksTest = new ArrayList<Book>();
        ArrayList<Book> userBooksTest = new ArrayList<Book>();
        libraryBooksTest.add(new Book("author1", "Book1", 1900));
        libraryBooksTest.add(new Book("author2", "Book2", 1901));
        libraryBooksTest.add(new Book("author3", "Book3", 1902));
        Library library = new Library(libraryBooksTest, userBooksTest);


        library.checkoutBook(2);
        int actual = userBooksTest.size();
        int expected = 1;

        assertEquals(expected, actual);


    }

    @Test
    public void returnOneBookTest() {

        ArrayList<Book> libraryBooksTest = new ArrayList<Book>();
        ArrayList<Book> userBooksTest = new ArrayList<Book>();
        libraryBooksTest.add(new Book("author1", "Book1", 1900));
        libraryBooksTest.add(new Book("author2", "Book2", 1901));
        libraryBooksTest.add(new Book("author3", "Book3", 1902));
        userBooksTest.add(new Book("autor1", "libro1", 1900));
        Library library = new Library(libraryBooksTest, userBooksTest);

        library.returnBook(1);

        int actual = userBooksTest.size();
        int expected = 0;
        assertEquals(expected, actual);
    }


}
