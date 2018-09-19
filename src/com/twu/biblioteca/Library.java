package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> libraryBooks;
    private ArrayList<Book> libraryBooksToReturn;
    private ArrayList<Book> libraryBooksToCheckout;
    private MainMenu app;


    public Library(ArrayList<Book> libraryBooks) {
        this.libraryBooks = libraryBooks;
        libraryBooksToCheckout = new ArrayList();
        libraryBooksToReturn = new ArrayList();
        this.app= new MainMenu();
    }

    public void fillLibrary() {

        libraryBooks.add(new Book("author2", "Book2", 1920, 1));
        libraryBooks.add(new Book("author2", "Book2", 1901, 2));
        libraryBooks.add(new Book("author3", "Book3", 1902, 3));
        libraryBooks.add(new Book("author4", "Book4", 1903, 4));
        libraryBooksToCheckout = (ArrayList<Book>) libraryBooks.clone();
    }


    public void listOfBooks () {
        for (int i = 0; i < libraryBooks.size(); i++) {
            System.out.println("Book " + (i + 1) + ":" + libraryBooks.get(i));
        }

    }

    public boolean validBook(int id) {

        for (Book book: libraryBooks){
            if (id == book.getId()) {
                return true;
            }
        }
        return false;
    }


    public Book findBookInLibrary(int bookSelected) {
        Book book = new Book();

        for (int i = 0; i < libraryBooks.size(); i++) {
            if (libraryBooks.get(i).getId() == bookSelected) {
                book = libraryBooks.get(i);
            }
        }
        return book;
    }

    // Checkout


    public void checkoutBook(Book book) {
        book.setCheckout();
        libraryBooksToCheckout.remove(book);
        libraryBooksToReturn.add(book);
       isTheCheckoutSuccessful(book);
    }

    public boolean hashBookCheckout(){
        return libraryBooksToCheckout.size() > 0;
    }

    public boolean isTheCheckoutSuccessful(Book book) {

        if (libraryBooksToCheckout.contains(book) && book.getCheckout() == true) {
            return  true;
        } else {
            return false;
        }
    }

    public void listBooksForCheckout() {
        for (int i = 0; i < libraryBooksToCheckout.size(); i++) {
            System.out.println("Book " + (i + 1) + ":" + libraryBooksToCheckout.get(i));
        }
    }

    // Return books

    public void returnBook(Book book) {
        book.setReturnBook();
        libraryBooksToCheckout.add(book);
        libraryBooksToReturn.remove(book);
        app.printProcessStatus( isTheReturnSuccessful(book));
    }


    public boolean hashBookReturn(){
    return  libraryBooksToReturn.size() > 0;
    }

    public void listOfBooksForReturn() {

        for (int i = 0; i < libraryBooksToReturn.size(); i++) {
            System.out.println("Book " + (i + 1) + ":" + libraryBooksToReturn.get(i));
        }
    }

    public boolean isTheReturnSuccessful(Book book) {

        if (!libraryBooksToReturn.contains(book) && book.getCheckout() == false) {
            return  true;
        } else {
            return false;
        }

    }
}
