package com.twu.biblioteca;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

public class BookTest {


    private static Book book;

    @Before
    public void setUp() {
        book = new Book("Lorca", "La casa...", 1920, 1);
    }


    @Test
    public void testIfBookGetsInitializedCorrectly() {
        assertEquals("Lorca", book.getAuthor());
        assertEquals("La casa...", book.getTitle());
        assertEquals(1920, book.getYear());
    }

    @Test
    public void bookCheckoutShouldReturnFalseWhenInitialized() {
        assertFalse(book.getCheckout());
    }

    @Test
    public void bookIsCheckoutShouldReturnTrueWhenCheckoutBook(){
        book.setCheckout();
        assertTrue(book.getCheckout());
    }

    @Test
    public void bookIsCheckoutShouldReturnFalseWhenReturnBook() {
        book.setReturnBook();
        assertFalse(book.getCheckout());
    }

}