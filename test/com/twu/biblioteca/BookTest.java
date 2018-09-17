package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void getAuthorTest(){
        Book libro1 = new Book("Lorca", "La casa...", 1920);

        assert(libro1.getAuthor().equals("Lorca"));
    }

    @Test
    public void setAuthorTest(){
        Book libro1 = new Book("Lorca", "La casa...", 1920);
        libro1.setAuthor("Tolkien");
        assert(libro1.getAuthor().equals("Tolkien"));
    }

    @Test
    public void getTitleTest(){
        Book libro1 = new Book("Lorca", "La casa...", 1920);

        assert(libro1.getTitle().equals("La casa..."));
    }

    @Test
    public void setTitleTest(){
        Book libro1 = new Book("Lorca", "La casa...", 1920);
        libro1.setTitle("Lord of the Rings");
        assert(libro1.getTitle().equals("Lord of the Rings"));
    }

    @Test
    public void getYearTest(){
        Book libro1 = new Book("Lorca", "La casa...", 1920);

        assertEquals(libro1.getYear() , (1920));
    }

    @Test
    public void setYearTest(){
        Book libro1 = new Book("Lorca", "La casa...", 1920);
        libro1.setYear(1930);
        assertEquals(libro1.getYear() , (1930));
    }

    /*library.checkout(1);
        userBooks -> arrayslis que contenga el libro1
        library.setUserBooks(new arraylist(libro1));
        assert(library.getUserBooks.equals(new arraylist(libro1)));
        assert(library.getLibraryBooks.equals(new arraylist(todos los libros menos el libro1)));*/



}