package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class LibraryTest {


    private static Library library;



    @Test
    public void listBooksIsNotEmptyAfterFillLibrary() {
        ArrayList<Book> libraryBooksTest = new ArrayList<Book>();
        Library library = new Library(libraryBooksTest);
        library.fillLibrary();

        assertEquals(false, libraryBooksTest.isEmpty());
    }

    @Test
    public void listBooksForCheckoutShouldContentJustBooksAvailableForCheckout() {
        ArrayList<Book> libraryBooksTest = new ArrayList<Book>();
        Book book1 = new Book("author5", "Book5", 1902, 3);
        libraryBooksTest.add(book1);
        Library library = new Library(libraryBooksTest);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        library.listBooksForCheckout();
        String expectedOutput = "Book 1:\n" + "Author: author5\n" + "Title: Book5\n" + "Year: 1902\n\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void bookSelectedReturnTheCorrectBook() {

        ArrayList<Book> libraryBooksTest = new ArrayList<Book>();
        libraryBooksTest.add(new Book("author1", "Book1", 1900, 1));
        libraryBooksTest.add(new Book("author2", "Book2", 1901, 2));
        libraryBooksTest.add(new Book("author3", "Book3", 1902, 3));
        Library library = new Library(libraryBooksTest);


       assertEquals(libraryBooksTest.get(0), library.findBookInLibrary(1));
    }


    @Test
    public void checkoutBookShouldChangeTheCheckoutStateToTrueWhenIsAValidBook() {
        ArrayList<Book> libraryBooksTest = new ArrayList<Book>();
        libraryBooksTest.add(new Book("author3", "Book3", 1902, 3));
        Book book = new Book("Lorca", "La casa...", 1920, 1);
        Library library = new Library(libraryBooksTest);

        library.checkoutBook(libraryBooksTest.get(0));
        assertTrue(libraryBooksTest.get(0).getCheckout());
    }

    @Test
    public void checkoutSuccessfullyOneBookWhenTheBookIsValid() {
        ArrayList<Book> libraryBooksTest = new ArrayList<Book>();
        Book book1 = new Book("Lorca", "La casa...", 1920, 1);
        libraryBooksTest.add(book1);
        Library library = new Library(libraryBooksTest);

        library.checkoutBook(book1);
        assertTrue(library.checkoutSuccessful(book1));
    }

    @Test
    public void checkoutNotPossibleWhenTheBookIsNOtValid() {
        ArrayList<Book> libraryBooksTest = new ArrayList<Book>();
        Book book1 = new Book("Lorca", "La casa...", 1920, 1);
        Library library = new Library(libraryBooksTest);
        library.checkoutBook(book1);
        assertFalse(library.checkoutSuccessful(book1));
    }

    @Test
    public void returnOneBookTest() {

        ArrayList<Book> libraryBooksTest = new ArrayList<Book>();
        libraryBooksTest.add(new Book("author1", "Book1", 1900, 1));
        libraryBooksTest.add(new Book("author2", "Book2", 1901, 2));
        libraryBooksTest.add(new Book("author3", "Book3", 1902, 3));
        Library library = new Library(libraryBooksTest);

//        library.returnBook();
//

//        int expected = 0;
//        assertEquals();
    }

//    @Test
//    public void checkoutNotSuccessForBookNotInTheListTest() {
//
//        ArrayList<Book> libraryBooksTest = new ArrayList<Book>();
//        libraryBooksTest.add(new Book("author1", "Book1", 1900, 1));
//        libraryBooksTest.add(new Book("author2", "Book2", 1901, 2));
//        libraryBooksTest.add(new Book("author3", "Book3", 1902, 3));
//        Library library = new Library(libraryBooksTest);
//
//        library.checkoutBook(6);
//        boolean actual = library.processSuccessful(UserListBeforeCheckout);
//        boolean expected = false;
//
//        assertEquals(expected, actual);
//
//
//    }
//
//    @Test
//    public void returnNotSuccessForBookNotInTheListTest() {
//        ArrayList<Book> libraryBooksTest = new ArrayList<Book>();
//        libraryBooksTest.add(new Book("author1", "Book1", 1900, 1));
//        libraryBooksTest.add(new Book("author2", "Book2", 1901, 2));
//        libraryBooksTest.add(new Book("author3", "Book3", 1902, 3));
//        Library library = new Library(libraryBooksTest);
//
//        Library library = new Library(libraryBooksTest);
//        int UserListBeforeReturn = userBooksTest.size();
//
//
//        library.returnBook(6);
//        boolean actual = library.processSuccessful(UserListBeforeReturn);
//        boolean expected = false;
//
//        assertEquals(expected, actual);
//
//
//    }
//
//    @Test
//    public void listMoviesCanBeFullfiled() {
//        ArrayList<Movie> libraryMoviesTest = new ArrayList<Movie>();
//        ArrayList<Movie> userMovieTest = new ArrayList<Movie>();
//        Library library = new Library(libraryMoviesTest, userMovieTest);
//
//        library.fillLibrary();
//
//        boolean actual = libraryMoviesTest.isEmpty();
//        boolean expected = false;
//
//        assertEquals(expected, actual);
//
//    }
//
//

}
