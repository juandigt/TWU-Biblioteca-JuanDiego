package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

public class LibraryTest {


    private static Library library;

    @Test
    public void listBooksIsNotEmptyAfterFillLibrary() {
        ArrayList<Book> libraryBooksTest = new ArrayList<Book>();
        Library library = new Library(libraryBooksTest, new HashMap<String, String>());

        assertEquals(false, libraryBooksTest.isEmpty());
    }

    @Test
    public void listBooksForCheckoutShouldContainJustBooksAvailableForCheckout() {
        ArrayList<Book> libraryBookList = new ArrayList<Book>();
        HashMap<String, String> register = new HashMap();
        Library library = new Library (libraryBookList , register);
        library.setCurrentUserLogged(library.getUsers().get(0));
        int initialSize = library.getlibraryBooksToCheckout().size();

        library.checkoutBook(libraryBookList.get(0));
        int finalSize = library.getlibraryBooksToCheckout().size();

        assertEquals(initialSize,finalSize + 1);

    }

    @Test
    public void bookSelectedReturnTheCorrectBook() {

        ArrayList<Book> libraryBooksTest = new ArrayList<Book>();
        libraryBooksTest.add(new Book("author1", "Book1", 1900, 1));
        libraryBooksTest.add(new Book("author2", "Book2", 1901, 2));
        libraryBooksTest.add(new Book("author3", "Book3", 1902, 3));
        Library library = new Library(libraryBooksTest, new HashMap<String, String>());

        assertEquals(libraryBooksTest.get(0), library.findBookInLibrary(1));
    }


    @Test
    public void checkoutBookShouldChangeTheCheckoutStateToTrueWhenIsAValidBook() {
        User currentUser = new User("1", "password", "Juandi","Garcia", "email@email.com", 135415);
        ArrayList<Book> libraryBooksTest = new ArrayList<Book>();
        libraryBooksTest.add(new Book("author3", "Book3", 1902, 3));
        Book book = new Book("Lorca", "La casa...", 1920, 1);
        Library library = new Library(libraryBooksTest, new HashMap<String, String>());
        library.setCurrentUserLogged(currentUser);

        library.checkoutBook(libraryBooksTest.get(0));
        assertTrue(libraryBooksTest.get(0).getCheckout());
    }

    @Test
    public void checkoutSuccessfullyOneBookWhenTheBookIsValid() {
        User currentUser = new User("1", "password", "Juandi","Garcia", "email@email.com", 135415);
        ArrayList<Book> libraryBooksTest = new ArrayList<Book>();
        Book book1 = new Book("Lorca", "La casa...", 1920, 1);
        libraryBooksTest.add(book1);
        Library library = new Library(libraryBooksTest, new HashMap<String, String>());
        library.setCurrentUserLogged(currentUser);
        library.checkoutBook(book1);

        assertTrue(book1.getCheckout());
    }

    @Test
    public void checkoutNotPossibleWhenTheBookIsNOtValid() {
        User currentUser = new User("1", "password", "Juandi","Garcia", "email@email.com", 135415);
        ArrayList<Book> libraryBooksTest = new ArrayList<Book>();
        Book book1 = new Book("Lorca", "La casa...", 1920, 1);
        Library library = new Library(libraryBooksTest, new HashMap<String, String>());
        library.setCurrentUserLogged(currentUser);
        library.checkoutBook(book1);
        assertFalse(library.isTheCheckoutSuccessful(book1));
    }

    @Test
    public void returnOneBookShouldChangeTheCheckoutStateToTrueWhenIsAValidBook() {

        ArrayList<Book> libraryBooksTest = new ArrayList<Book>();
        libraryBooksTest.add(new Book("author3", "Book3", 1902, 3));
        Library library = new Library(libraryBooksTest, new HashMap<String, String>());
        libraryBooksTest.get(0).setCheckout();
        library.returnBook(libraryBooksTest.get(0));
        assertFalse(libraryBooksTest.get(0).getCheckout());
    }
}
