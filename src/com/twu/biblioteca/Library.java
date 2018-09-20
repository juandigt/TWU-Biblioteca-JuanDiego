package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Map;

public class Library {

    private ArrayList<Book> libraryBooks;
    private ArrayList<Book> libraryBooksToReturn;
    private ArrayList<Book> libraryBooksToCheckout;
    private MainMenu app;
    private Map<String,String> register;
    private User currentUserLogged;
    private ArrayList<User> users = new ArrayList<User>();

    //Setup Library

    public Library(ArrayList<Book> libraryBooks, Map<String,String> register) {
        this.libraryBooks = libraryBooks;
        this.register = register;
        libraryBooksToCheckout = new ArrayList();
        libraryBooksToReturn = new ArrayList();
        this.app= new MainMenu();
        this.fillLibrary();
    }

    public void setCurrentUserLogged(User currentUserLogged) {
        this.currentUserLogged= currentUserLogged;
    }

    public void fillLibrary() {

        libraryBooks.add(new Book("author2", "Book2", 1920, 8));
        libraryBooks.add(new Book("author2", "Book2", 1901, 2));
        libraryBooks.add(new Book("author3", "Book3", 1902, 3));
        libraryBooks.add(new Book("author4", "Book4", 1903, 4));
        libraryBooksToCheckout = (ArrayList<Book>) libraryBooks.clone();
        users.add(new User("1", "password", "Juandi","Garcia", "email@email.com", 135415));
        users.add(new User("2", "password2", "User2","surname2", "email@email.com", 135415));
    }

    //Check and list books

    public void listOfBooks () {
        for (int i = 0; i < libraryBooks.size(); i++) {
            System.out.println("Book " + libraryBooks.get(i).getId() + ":" + libraryBooks.get(i));
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
        register.put(book.getTitle(), currentUserLogged.getName());
        isTheCheckoutSuccessful(book);
    }

    public boolean userHasBookToCheckout(){
        return libraryBooks.size() > 0;
    }

    public boolean isTheCheckoutSuccessful(Book book) {

        if (libraryBooksToCheckout.contains(book) && book.getCheckout()) {
            return  true;
        } else {
            return false;
        }
    }

    public void listOfBooksForCheckout() {
        for (int i = 0; i < libraryBooks.size(); i++) {
            System.out.println("Book " + libraryBooks.get(i).getId() + ":" + libraryBooks.get(i));
        }
    }

    // Return books

    public void returnBook(Book book) {
        book.setReturnBook();
        libraryBooksToCheckout.add(book);
        libraryBooksToReturn.remove(book);
        register.remove(book.getTitle());
        app.printProcessStatus( isTheReturnSuccessful(book));
    }

    public boolean userHasBookToReturn(){
    return  libraryBooksToReturn.size() > 0;
    }

    public void listOfBooksForReturn() {

        for (int i = 0; i < libraryBooksToReturn.size(); i++) {
            System.out.println("Book " + libraryBooksToReturn.get(i).getId() + ":" + libraryBooksToReturn.get(i));
        }
    }

    public boolean isTheReturnSuccessful(Book book) {

        if (!libraryBooksToReturn.contains(book) && !book.getCheckout()) {
            return  true;
        } else {
            return false;
        }
    }

    //manage of users

    public Map<String, String> getRegister() {
        return register;
    }


    public ArrayList<User> getUsers() {
        return this.users;
    }


}
