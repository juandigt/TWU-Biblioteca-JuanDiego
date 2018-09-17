package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> libraryBooks = new ArrayList<Book>();
    private ArrayList<Book> userBooks = new ArrayList<Book>();

    public Library () {
        libraryBooks.add(new Book("autor1", "libro1", 1900));
        libraryBooks.add(new Book("autor2", "libro2", 1901));
        libraryBooks.add(new Book("autor3", "libro3", 1902));
        libraryBooks.add(new Book("autor4", "libro4", 1903));
    }

    public void listBooks() {
        for(int i =0; i<libraryBooks.size(); i++) {
            System.out.println("Book "+(i+1)+":"+libraryBooks.get(i));
        }
    }

    public void listBooksUser() {
        for(int i =0; i<userBooks.size(); i++) {
            System.out.println("Book "+(i+1)+":"+userBooks.get(i));
        }
    }

    public void checkout(int bookSelected) {

        bookSelected--;
        try {
            userBooks.add(libraryBooks.get(bookSelected));
        }
        catch (IndexOutOfBoundsException excepcion){
            //userBooks = new ArrayList<>();
            System.out.println("oye te has salido del rango porque el indice ultimo es "+(libraryBooks.size()-1));
        }
        catch (ArithmeticException excepcion2) {
            System.out.print("una excepcion aritmetica");
        }

        catch (Exception madre) {
            System.out.print("Se ha lanzado una excepcion");
        }

        libraryBooks.remove(bookSelected);
    }

    public void returnBook(int bookSelected) {
        bookSelected--;
        libraryBooks.add(userBooks.get(bookSelected));
        userBooks.remove(bookSelected);
    }
}
